package org.maven;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.IOException;

public class APICaller
{
    //You'll need to replace "DEMO" with your own API key, then compile the program
    //Details in README
    private static final String API_KEY = "DEMO";

    public static void main( String[] args ) throws IOException {
        if(args.length == 0){
            System.out.println("Please enter your request");
            return;
        }

        String query = "";

        if(args.length == 1){
            //In case the request looks like this : "This is user's request"
            String [] temp = args[0].split(" ");
            for(String s : temp){
                query += s + "+";
            }
        }else{
            //In case the request looks like this : This is user's request
            for(String s : args){
                query += s + "+";
            }
        }

        query = query.substring(0, query.length()-1); //Removes the extra '+' at the end of query

        //Sends an API request that returns an XML file
        Document doc = Jsoup.connect("http://www.wolframalpha.com/api/v2/query?appid=" + API_KEY + "&input=" + query).get();

        //Selects what we want from the XML
        Elements e = doc.select("plaintext");

        //We'll select only the 1st API response, then remove the fluff around it
        String result = e.get(1).toString().replace("<plaintext>", "").replace("</plaintext>", "");

        //And now we do some formatting magic
        final int length = result.length();
        String topBorder = "╔";
        for(int i = 0 ; i < length ; i++){
            topBorder += "═";
        }
        topBorder += "╗";

        String bottomBorder = "╚";
        for(int i = 0 ; i < length ; i++){
            bottomBorder += "═";
        }
        bottomBorder += "╝";

        System.out.println("\n" + topBorder);
        System.out.println("►" + result);
        System.out.println(bottomBorder);

        System.out.println("\nMore at : https://www.wolframalpha.com/input?i=" + query);
    }
}
