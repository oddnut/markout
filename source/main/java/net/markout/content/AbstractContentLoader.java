/*
	AbstractContentLoader.java

	Author: David Fogel
	Copyright 2009 David Fogel
	All rights reserved.
*/

package net.markout.content;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import net.markout.ContentWriter;
import net.markout.MalformedXMLException;
import net.markout.types.SystemLiteral;

import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * AbstractContentLoader
 * 
 * Comment here.
 */
public abstract class AbstractContentLoader implements ContentLoader, EntityResolver {
	// *** Class Members ***

	// *** Instance Members ***
	private Map<String, InputSourceFactory> sourceFactories;
	
	private ExecutorService asyncContentExecutor;

	// *** Constructors ***
	protected AbstractContentLoader() {
		
		sourceFactories = new HashMap<String, InputSourceFactory>();
		
		asyncContentExecutor = Executors.newCachedThreadPool();	
	}

	// *** ContentLoader Methods ***
	public Content parse(InputSource xml, XPath xpath) throws IOException, MalformedXMLException {
		
		SelectableContent sc = parseDocument(xml);
		
		if (xpath != null)
			return sc.select(xpath);
		else
			return sc;
	}
	
	public Content load(LoadType type, 
						final InputSource xml, 
						final XPath xpath) {
	
		switch (type) {
		
		case lazy:
			return new LazyContent(xml, xpath);
		
		case async:
			
			return new AsyncContent(asyncContentExecutor.submit(new Callable<Content>() {
				public Content call() throws Exception {
					return parse(xml, xpath);
				}
			}));
			
		default:
			throw new IllegalArgumentException("LoadType is null or unknown.");
		}
	}
	
	public void setSource(SystemLiteral systemID, InputSource source) throws IOException {
		
		sourceFactories.put(systemID.toString(), new InputSourceFactory(source));
	}
	
	// *** EntityResolver Methods ***
	public InputSource resolveEntity (String publicId, String systemId) throws SAXException, IOException {
		
		InputSourceFactory f = sourceFactories.get(systemId);
		
		return  f != null ? f.createInputSource() : null;
	}
	
	// *** Public Methods ***

	// *** Protected Methods ***
	protected abstract SelectableContent parseDocument(InputSource xml) throws IOException, MalformedXMLException;

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
	
	protected class AsyncContent implements Content {
		Future<Content> futureContent;
		volatile Content wrapped;
		
		public AsyncContent(Future<Content> futureContent) {
			this.futureContent = futureContent;
			wrapped = null;
		}
		
		public void writeTo(ContentWriter out) throws IOException {
			
			// double-checked locking should work okay with a volatile variable in >=jdk1.5
			if (wrapped == null) {
				synchronized(AsyncContent.this) {
					if (wrapped == null) {
						try {
							wrapped = futureContent.get();
						}
						catch (ExecutionException ee) {
							Throwable cause = ee.getCause();
							if (cause instanceof IOException)
								throw (IOException) cause;
							// hmm:
							throw new ContentParsingException("Exception while parsing", cause);
						}
						catch (InterruptedException ie) {
							// not sure what the best thing to do here is
							throw new RuntimeException("Content parsing interrupted", ie);
						}
					}
				}
			}
			
			wrapped.writeTo(out);
		}
	}
	
	protected class LazyContent implements Content {
		InputSource xml;
		XPath xpath;
		volatile Content wrapped;
		
		public LazyContent(InputSource xml, XPath xpath) {
			this.xml = xml;
			this.xpath = xpath;
			wrapped = null;
		}

		public void writeTo(ContentWriter out) throws IOException {
			
			// double-checked locking should work okay with a volatile variable in >=jdk1.5
			if (wrapped == null) {
				synchronized(LazyContent.this) {
					if (wrapped == null)
						wrapped = parse(xml, xpath);
				}
			}
			
			wrapped.writeTo(out);
		}
	}
	
	protected static class InputSourceFactory {
		private char[] chars;
		private byte[] bytes;
		private String encoding;
		private String systemID;
		private String publicID;
		
		public InputSourceFactory(InputSource source) throws IOException {
			
			Reader r;
			InputStream is;
			
			if ((r = source.getCharacterStream()) != null) {
				
				CharArrayWriter caw = new CharArrayWriter();
				char[] buf = new char[2048];
				int read = 0;
				while ((read = r.read(buf)) != -1)
					caw.write(buf, 0, read);
				r.close();
				
				chars = caw.toCharArray();
				
			} else if ((is = source.getByteStream()) != null) {
				
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				byte[] buf = new byte[2048];
				int read = 0;
				while ((read = is.read(buf)) != -1)
					baos.write(buf, 0, read);
				is.close();
				
				bytes = baos.toByteArray();
			}
			
			encoding = source.getEncoding();
			systemID = source.getSystemId();
			publicID = source.getPublicId();
		}
		
		public InputSource createInputSource() {
			InputSource s = new InputSource();
			if (chars != null)
				s.setCharacterStream(new CharArrayReader(chars));
			if (bytes != null)
				s.setByteStream(new ByteArrayInputStream(bytes));
			s.setEncoding(encoding);
			s.setSystemId(systemID);
			s.setPublicId(publicID);
			
			return s;
		}
	}
}
