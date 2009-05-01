/*
	Sources.java

	Author: David Fogel
	Copyright 2009 David Fogel
	All rights reserved.
*/

package net.markout.content;

import java.io.*;

import org.xml.sax.InputSource;

/**
 * Sources
 * 
 * Comment here.
 */
public class Sources {
	// *** Class Members ***
	public static class Builder {
		CharSequence string;
		char[] chars;
		Reader reader;
		
		byte[] bytes;
		InputStream inputStream;
		String encoding;
		
		String systemID;
		String publicID;
		
		public Builder from(String string) {
			this.string = string;
			return this;
		}
		
		public Builder from(char[] chars) {
			this.chars = chars;
			return this;
		}
		
		// UNFINISHED
		
		public InputSource build() {
			
			InputSource source = new InputSource();
			
			if (string != null)
				source.setCharacterStream(new StringReader(string.toString()));
			else if (chars != null)
				source.setCharacterStream(new CharArrayReader(chars));
			else if (reader != null)
				source.setCharacterStream(reader);
			else if (bytes != null)
				source.setByteStream(new ByteArrayInputStream(bytes));
			else if (inputStream != null)
				source.setByteStream(inputStream);
			
			source.setEncoding(encoding);
			source.setSystemId(systemID);
			source.setPublicId(publicID);
			
			return source;
		}
	}

	// *** Instance Members ***

	// *** Constructors ***

	// *** Interface Methods ***

	// *** Public Methods ***
	public static InputSource from(CharSequence xml) {
		return new InputSource(new StringReader(xml.toString()));
	}
	
	public static InputSource from(Reader r) {
		return new InputSource(r);
	}
	
	public static InputSource from(char[] chars) {
		return new InputSource(new CharArrayReader(chars));
	}
	
	public static InputSource from(byte[] bytes) {
		return new InputSource(new ByteArrayInputStream(bytes));
	}
	
	public static InputSource from(byte[] bytes, String encoding) {
		InputSource source = from(bytes);
		source.setEncoding(encoding);
		return source;
	}
	
	public static InputSource from(InputStream in) {
		return new InputSource(in);
	}
	
	public static InputSource from(InputStream in, String encoding) {
		InputSource source = from(in);
		source.setEncoding(encoding);
		return source;
	}
	
	public static InputSource from(String url) {
		return new InputSource(url);
	}
	
	public static InputSource from(Class<?> c, String path) {
		return new InputSource(c.getResourceAsStream(path));
	}
	
	public static InputSource from(Class<?> c, String path, String encoding) {
		InputSource source = from(c, path);
		source.setEncoding(encoding);
		return source;
	}
	
	public static InputSource from(ClassLoader cl, String path) {
		return new InputSource(cl.getResourceAsStream(path));
	}
	
	public static InputSource from(ClassLoader cl, String path, String encoding) {
		InputSource source = from(cl, path);
		source.setEncoding(encoding);
		return source;
	}
	
	public static InputSource from(File f) {
		try {
			return new InputSource(new FileInputStream(f));
		} catch (FileNotFoundException fnfe) {
			return null;
			// ??
		}
	}

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}
