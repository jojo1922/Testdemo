package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	
	  static List<String> rowDataList = new ArrayList<String>();
		
		//private static final String FILE_NAME = ;
		//public static  	 ArrayList<String> arrl = new ArrayList<String>();
		 public static   List<String> ExcelRead(String FILE_NAME) {
			// String[][] xData = new String[3][3];
			 //String a = null;
		String value = null;
	        try {

	            FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
	            XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
	          
	           Sheet datatypeSheet = workbook.getSheetAt(0);
	            Iterator<Row> iterator = datatypeSheet.iterator();
	          
	            while (iterator.hasNext()) {

	                Row currentRow = iterator.next();
	                Iterator<Cell> cellIterator = currentRow.iterator();

	                while (cellIterator.hasNext()) {

	                    Cell currentCell = cellIterator.next();
	                    //getCellTypeEnum shown as deprecated for version 3.15
	                    //getCellTypeEnum ill be renamed to getCellType starting from version 4.0
	                    if (currentCell.getCellType() == CellType.STRING) {
	                    	//a=currentCell.getStringCellValue();
	                    	//System.out.print(a + "--");
	                        System.out.print(currentCell.getStringCellValue() + "--");
	                       // arrl.add( currentCell.getStringCellValue());
	                         value= currentCell.getStringCellValue();
	                         rowDataList.add(value);
	                    }
	                   
//	                    else if (DateUtil.isCellDateFormatted(currentCell)) {
//	                     	 SimpleDateFormat datevar= new SimpleDateFormat("dd-MM-yyyy");
//	                       	//System.out.println("The cell contains a date value: ");
//	                            System.out.print( datevar.format(
//	                                currentCell.getDateCellValue()) + "--");
//	                            
//	                        }
	                    else if (currentCell.getCellType() == CellType.NUMERIC) {
	                        System.out.print(currentCell.getNumericCellValue() + "--");
	                         double values=currentCell.getNumericCellValue();
	                       
	                         value =Double. toString(values);
	                    	//String aa=  	currentCell.getNumericCellValue().toString();
	                    	//System.out.print(aa + "--");
	                        //arrl.add( currentCell.getStringCellValue());
	                    }
	                    
	                  
	                    
	                    
	                    
	                    
	                }
	               
	                System.out.println();
	              

	            }
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			//return arrl;
			//return value;

	        return rowDataList;
		
		
		
		 }
		
		
		
		 }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

