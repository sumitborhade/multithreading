package com.example.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Main {

	static class URIModel {
		private String scheme;
		
		private String hostname;
		
		private int port;
		
		private String remainingUri;
		
		public URIModel(String scheme, String hostname, int port, String remainingUri) {
			super();
			this.scheme = scheme;
			this.hostname = hostname;
			this.port = port;
			this.remainingUri = remainingUri;
		}

		public String getScheme() {
			return scheme;
		}

		public void setScheme(String scheme) {
			this.scheme = scheme;
		}

		public String getHostname() {
			return hostname;
		}

		public void setHostname(String hostname) {
			this.hostname = hostname;
		}

		public int getPort() {
			return port;
		}

		public void setPort(int port) {
			this.port = port;
		}

		public String getRemainingUri() {
			return remainingUri;
		}

		public void setRemainingUri(String remainingUri) {
			this.remainingUri = remainingUri;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((hostname == null) ? 0 : hostname.hashCode());
			result = prime * result + port;
			result = prime * result + ((remainingUri == null) ? 0 : remainingUri.hashCode());
			result = prime * result + ((scheme == null) ? 0 : scheme.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			URIModel other = (URIModel) obj;
			if (hostname == null) {
				if (other.hostname != null)
					return false;
			} else if (!hostname.equalsIgnoreCase(other.hostname))
				return false;
			if (port != other.port)
				return false;
			if (remainingUri == null) {
				if (other.remainingUri != null)
					return false;
			} else if (!remainingUri.equals(other.remainingUri))
				return false;
			if (scheme == null) {
				if (other.scheme != null)
					return false;
			} else if (!scheme.equalsIgnoreCase(other.scheme))
				return false;
			return true;
		}
	}
	
	public static void main(String[] args) throws IOException {
		InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
		BufferedReader in = new BufferedReader(reader);
		String line;
		while ((line = in.readLine()) != null) {

			String[] uris = line.split(";");
			String uri1 = uris[0];
			String uri2 = uris[1];
			URIModel uriModel1 = parseUri(uri1);
			System.out.println("================================");
			URIModel uriModel2 = parseUri(uri2);
			
			System.out.println(uriModel1.equals(uriModel2) ? "True" : "False");
		}
	}

	public static URIModel parseUri(String uri) throws MalformedURLException, UnsupportedEncodingException {
		URL url = new URL(uri);
		String protocol = url.getProtocol();
		String host = url.getHost();
		int port = url.getPort() != -1 ? url.getPort() : 80;
		
		String path = url.getPath();
		System.out.println(escapeJavascript(path));
		URIModel uriModel = new URIModel(protocol,host, port, escapeJavascript(path));
		return uriModel;
	}
	
	public static String escapeJavascript(String str) {
		ScriptEngine engine = new ScriptEngineManager()
		        .getEngineByName("JavaScript");
	    try {
	        return engine.eval(String.format("escape(\"%s\")", 
	            str.replaceAll("%20", " "))).toString()
	                .replaceAll("%3A", ":")
	                .replaceAll("%2F", "/")
	                .replaceAll("%3B", ";")
	                .replaceAll("%40", "@")
	                .replaceAll("%3C", "<")
	                .replaceAll("%3E", ">")
	                .replaceAll("%3D", "=")
	                .replaceAll("%26", "&")
	                .replaceAll("%25", "%")
	                .replaceAll("%24", "$")
	                .replaceAll("%23", "#")
	                .replaceAll("%2B", "+")
	                .replaceAll("%2C", ",")
	                .replaceAll("%3F", "?");
	    } catch (ScriptException ex) {
	    	System.out.println("ScriptException caught");
	        return null;
	    }
	}
}