package com.greatlearning.forkjoin;

import java.io.File;
import java.util.concurrent.ForkJoinPool;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		
		
		try {
			System.err.println("Strated App");
			String url = main.readInputUrl(args);
			UrlConnectionReader urlConnectionReader = new UrlConnectionReader(url);
			ForkJoinPool forkJoinPool = new ForkJoinPool();
			forkJoinPool.execute(urlConnectionReader);
			urlConnectionReader.join();
			System.err.println("End App");
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}
	
	String readInputUrl(String[] args) {
		if(args.length == 0) throw new RuntimeException("Url not provided");
		return args[0];
	}

}

