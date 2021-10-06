package com.greatlearning.forkjoin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class UrlConnectionReader {

	String urlString; 
	UrlConnectionReader(String url){
		urlString = url;
	}
	public void readWrite() {
	
    InputStream is = null;
    BufferedReader br;
    String line = null;

    try {
    	
        URL url = new URL(urlString);
        //is = url.openConnection().getInputStream();
        is = url.openStream();  // throws an IOException
        br = new BufferedReader(new InputStreamReader(is));

        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    } catch (MalformedURLException mue) {
         mue.printStackTrace();
    } catch (IOException ioe) {
         ioe.printStackTrace();
    } finally {
        try {
            if (is != null) is.close();
        } catch (IOException ioe) {
        	ioe.printStackTrace();
        }
    }
}
 
}
