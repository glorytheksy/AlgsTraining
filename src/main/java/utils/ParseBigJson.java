package utils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.io.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

public class ParseBigJson {
	
    public void parse(String jsonFilePath){
        //create JsonReader object and pass it the json file,json source or json text.
        try {
        	JsonReader jsonReader = new JsonReader(
                    new InputStreamReader(
                            new FileInputStream(jsonFilePath), StandardCharsets.UTF_8));
            Gson gson = new GsonBuilder().create();
            jsonReader.beginArray(); //start of json array
            int numberOfRecords = 0;
            
            while (jsonReader.hasNext()){ //next json array element
                Document document = gson.fromJson(jsonReader, Document.class);
                //do something real
               System.out.println(document.getTitle());
                numberOfRecords++;
            }
            jsonReader.endArray();
            System.out.println("Total Records Found : "+numberOfRecords);
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	

	public static void main(String[] args) {
		
		String jsonFilePath = "/home/glorythesky/Documents/datasets/text_sum/nlpcc_data.json";
		
        long start = System.currentTimeMillis();
        ParseBigJson jsonStreamingGsonExample = new ParseBigJson();
        jsonStreamingGsonExample.parse(jsonFilePath);
        System.out.println("Total Time Taken : "+(System.currentTimeMillis() - start)/1000 + " secs");
	}
}

class Document {
	String title;
    String content;
    
    @Override
    public String toString() {
        return "Document{" +
                "title=" + this.title +
                ", content=" + this.content +
                '}';
    }
    
    public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}


