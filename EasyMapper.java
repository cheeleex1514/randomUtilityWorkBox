/**
*
*   Quickly takes a csv file with two columns and maps values from column 1 to column 2.
*   Creates a ruby file that contains a module of final key value pairs.
*
*   Requires input file path, output file path, and a desired module name.
* 
*   Note: This was a quick put together to create mappings of thousands records pulled from a data store. 
*
*/


import java.io.*;
import java.util.Scanner;
import java.util.*;

public class EasyMapper{
    public static void main(String...args) throws Exception{
        
        String inputFilePath = ""; 
        String fileOutputPath = ""; 
        String desiredModuleName = "";
        String output = "module " + desiredModuleName + "\n\tID = {";
        
        Scanner scan = new Scanner(new File(inputFilePath));
        
        while(scan.hasNextLine()){
            String[] line = scan.nextLine().split(",",-1);
            output = output + ("\n\t\t'" + line[1] + "' => '" + line[0] + "',");
        }

        output = output + "\n\t}.freeze\nend";
        
        PrintWriter pw = new PrintWriter(fileOutputPath);
        pw.println(output);
        pw.close();
    }   
}
