package csvtests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CsvFileReader5 {
	
private static final String CSVFILEPATH = "./Files/upgrade.csv";

 public static List<List<String>> records = new ArrayList<>();
	public static void main(String[] args) throws Exception {
	
	
		
		
		try (BufferedReader br = new BufferedReader(new FileReader(CSVFILEPATH))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		        String[] values = line.split(",");
		        try {
					records.add(Arrays.asList(values));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		       
		    }
		   System.out.println(records); 
		}
		

        }
		
	    	 
	    	// Map mapItems =ArrayUtils.toMap(obj2);
	    	// System.out.println("The item with key0 is : " + mapItems.get("status"));    }
	  
		
	//	 System.out.print(obj2[0][0]);
	


}