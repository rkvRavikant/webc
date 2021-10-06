package com.greatlearning.forkjoin;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		
		
		try {
			String url = main.readInputUrl(args);
			System.out.println(url);
			UrlConnectionReader urlConnectionReader = new UrlConnectionReader(url);
			urlConnectionReader.readWrite();
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}
	
	String readInputUrl(String[] args) {
		if(args.length == 0) throw new RuntimeException("Url not provided");
		return args[0];
	}
}

