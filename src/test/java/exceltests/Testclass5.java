package exceltests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.commons.lang3.ArrayUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.schemas.office.visio.x2012.main.CellType;

public class Testclass5 {
	
	
	  
	  public void integrationTest() throws IOException {
	    System.out.println("-------------Test case started ----------------");
	    
	    Object[][] obj2=dataSupplier();
	    
	  
	  
	    int i;
	    for (i=0;i<obj2.length;i++) {
	    	
	    	 ObjectMapper oMapper = new ObjectMapper();
	    	 Map<String, Object> map2 = oMapper.convertValue(obj2[i][0], Map.class);
	    	 System.out.println(map2.get("status"));
	    	 System.out.println(map2.get("comment"));
	    	 System.out.println();
	    	 
	    	// Map mapItems =ArrayUtils.toMap(obj2);
	    	// System.out.println("The item with key0 is : " + mapItems.get("status"));    }
	    }
	    	   
	    
	    
	    	
	   
	//    System.out.print(obj2[0][0]);
	    
	  //  Map <Object,Object> map=new HashMap<>();
	    
	 //   map=convert2DArrayToMap(dataSupplier());
	    
	  //  System.out.print(map);
	    
	    

	    System.out.println("-------------Test case Ended ----------------");

	  }

	  public static Map<Object, Object> convert2DArrayToMap(Object[][] data) throws IOException{
		  
		   
		    return Arrays.stream(data).collect(Collectors.toMap(m -> m[0], m -> m[0]));
		  
	/*	  Map<Object, Object> map = new HashMap<>();
		    for (Object[] m : data)
		    {
		      if (map.put(m[0], m[0]) != null)
		      {
		        throw new IllegalStateException("Duplicate key");
		      }
		    }
		    return map;*/
		  }
	  public  static Object[][] dataSupplier() throws IOException {

	    File file = new File(".//Files//TestData.xlsx");
	    FileInputStream fis = new FileInputStream(file);

	    XSSFWorkbook wb = new XSSFWorkbook(fis);
	    XSSFSheet sheet = wb.getSheetAt(0);
	    wb.close();
	    int lastRowNum = sheet.getLastRowNum() ;
	    int lastCellNum = sheet.getRow(0).getLastCellNum();
	    Object[][] obj = new Object[lastRowNum][1];

	    for (int i = 0; i < lastRowNum; i++) {
	      Map<Object, Object> datamap = new HashMap<>();
	      for (int j = 0; j < lastCellNum; j++) {
	    	  
	    	  Cell c =sheet.getRow(i+1).getCell(j) ;
	    	 if ( c == null ) {
	    		 
	    		 datamap.put(sheet.getRow(0).getCell(j).toString(), null);
	    		 break;
	    		 
	    	 }
	        datamap.put(sheet.getRow(0).getCell(j).toString(), sheet.getRow(i+1).getCell(j).toString());
	      }
	      obj[i][0] = datamap;

	    }
	    return  obj;
	  }

}
