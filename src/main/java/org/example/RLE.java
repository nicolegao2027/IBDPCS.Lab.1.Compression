package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RLE {

    public static void main(String[] args) throws FileNotFoundException {
        String decompressedString = textToString("src/main/resources/COVID-19");
        String compressedString = compress(decompressedString);
        System.out.println(compressedString);
    }

    /** This method converts the information stored in a text file into a String. */
    public static String textToString(String filename) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(filename));
        StringBuilder sb = new StringBuilder();
        while (sc.hasNext()) {
            String subSeq = sc.next();
            for (int i = 0; i < subSeq.length(); i++) {
                sb.append(subSeq.charAt(i));
            }
        }
        return sb.toString();
    }

    /** TODO 1: Given a String (a genome sequence of COVID-19) implement the RLE algorithm that will use RLE to compress a String. Returns the compressed String. */
    public static String compress(String uncompressed) {
        if(uncompressed==null||uncompressed.isEmpty()){
            return "";
        }
        String result="";
        int n=uncompressed.length();
        int i=0;
        while(i<n){
            char a=uncompressed.charAt(i);
            int count=1;
            int j=i+1;
            while(j<n&&uncompressed.charAt(j)==a){
                count++;
                j++;
            }
            result+=count;
            result+=a;
            i=j;
        }
        return result;
    }

    /** TODO 2: Given a String (a genome sequence of COVID-19) implement the RLE algorithm that will use RLE to decompress a String. Returns the uncompressed String. */
    public static String decompress(String compressed) {
        String result="";
        String count="";
        int n=compressed.length();
        if(compressed==null||compressed.isEmpty()){
            return "";
        }
        for (int i=0;i<compressed.length();i++){
            char c=compressed.charAt(i);
            if(Character.isDigit(c)){
                count+=c;
            }
            else{
                int counter=Integer.parseInt(count);
                for(int j=0;j<counter;j++){
                    result+=c;
                }
                count="";
            }
        }
        return result;
    }


}
