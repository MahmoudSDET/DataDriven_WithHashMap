package exceltests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.microsoft.schemas.office.visio.x2012.main.CellType;

public class Testclass {
	
	@Test(dataProvider = "data")
	  public void integrationTest(Map<Object, Object> map) {
	    System.out.println("-------------Test case started ----------------");
	    System.out.println(map.get("status"));
	    System.out.println(map.get("comment"));
	 //   System.out.println(map.get("DoB"));

	    System.out.println("-------------Test case Ended ----------------");

	  }

	  @DataProvider(name = "data")
	  public Object[][] dataSupplier() throws IOException {

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
