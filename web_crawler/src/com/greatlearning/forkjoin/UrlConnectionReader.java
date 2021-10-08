package com.greatlearning.forkjoin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class UrlConnectionReader extends RecursiveTask {

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
            FileWriter myWriter = new FileWriter("output.txt");


            while ((line = br.readLine()) != null) {
                myWriter.write(line.replaceAll("\\<.*?\\>", ""));
            }
            myWriter.close();
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
	/**
     * The main computation performed by this task.
     *
     * @return the result of the computation
     */
    @Override
    protected Object compute() {
        return null;
    }
 
}
