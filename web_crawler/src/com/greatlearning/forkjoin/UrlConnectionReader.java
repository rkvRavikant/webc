package com.greatlearning.forkjoin;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.RecursiveTask;

public class UrlConnectionReader  extends RecursiveTask {

	String urlString; 
	UrlConnectionReader(String url){
		this.urlString = url;
	}
	
	
	@Override
	protected Object compute() {
		readWrite();
		return null;
	}
	
	
	public void readWrite() {
	
    InputStream is = null;
    BufferedReader br;
    String line = null;
    PrintWriter writerObj = null;

    try {
    	
        URL url = new URL(urlString);
        is = url.openConnection().getInputStream();
        br = new BufferedReader(new InputStreamReader(is));
        writerObj = new PrintWriter(new File("output.txt"));
        while ((line = br.readLine()) != null) {
        	writerObj.write(line.replaceAll("\\<.*?\\>", ""));        
        	writerObj.flush();  
        }
    } catch (MalformedURLException e) {
         System.err.println("Exception while Reading the url: "+e.getMessage());
    } catch (IOException e) {
    	System.err.println("Exception while Reading/Writing the content: "+e.getMessage());;
    } finally {
        try {
            if (is != null) is.close();
            writerObj.close(); 
        } catch (IOException e) {
        	System.err.println("Exception while Closing the connection: "+e.getMessage());;
        }
    }
}

 
}
