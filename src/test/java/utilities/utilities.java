package utilities;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
 
public class utilities {

	 
	    public static void WriteUserDetails(String Name, String email) throws IOException {
	        // Array to store the names and emails
	        String[] names = {"Bendale, Tushar (Cognizant)", "Gawande, Swaraj (Cognizant)", "Agarwal, Anmol (Cognizant", "Yerne, Mayank (Cognizant", "Sahariya, Ashutosh (Cognizant"};
	        String[] emails = {"2303704@cognizant.com", "2304106@cognizant.com", "2303741"
	        		+ "@cognizant.com", "2303704@cognizant.com", "2303704@cognizant.com"};
	 
	        try {
	            FileOutputStream file = new FileOutputStream(".\\TestData\\Data.xlsx");
	            
	            XSSFWorkbook workbook = new XSSFWorkbook();
	            
	            XSSFSheet userdetails = workbook.createSheet("UserDetails");
	            
	            XSSFRow r1 = userdetails.createRow(0);
	            // Create a font with bold style
	            XSSFFont font = workbook.createFont();
	            font.setBold(true);
	            // Create a cell style with the bold font
	            XSSFCellStyle style = workbook.createCellStyle();
	            style.setFont(font);
	            // Set the cell style for each cell in the first row
	            for (int i = 0; i < 2; i++) {
	                XSSFCell cell = r1.createCell(i);
	                cell.setCellValue(i == 0 ? "UserName" : "Email");
	                cell.setCellStyle(style);
	                userdetails.autoSizeColumn(i);
	            }
	            XSSFRow r2 = userdetails.createRow(1);
	            r2.createCell(0).setCellValue(Name);
	            userdetails.autoSizeColumn(0);
	            r2.createCell(1).setCellValue(email);
	            userdetails.autoSizeColumn(1);
	 
	            boolean matchFound = false;
	 
	            for (int k = 0; k < names.length; k++) {
	                if (Name.equals(names[k]) && email.equals(emails[k])) {
	                    // If match, add Status and Result columns with values
	                    r1.createCell(2).setCellValue("Status");
	                    r1.createCell(3).setCellValue("Result");
	                    r2.createCell(2).setCellValue("Verified");
	                    r2.createCell(3).setCellValue("Pass");
	                    // Create font for status and result
	                    XSSFFont passFont = workbook.createFont();
	                    passFont.setBold(true);
	                    // Create cell style for pass
	                    XSSFCellStyle passStyle = workbook.createCellStyle();
	                    passStyle.setFont(passFont);
	                    passStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
	                    passStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	                    // Apply style to pass cell
	                    XSSFCell passCell = r2.getCell(3);
	                    passCell.setCellStyle(passStyle);
	                    matchFound = true;
	                    break;
	                }
	            }
	 
	            if (!matchFound) {
	                // If no match, set Status and Result to fail
	                r1.createCell(2).setCellValue("Status");
	                r1.createCell(3).setCellValue("Result");
	                r2.createCell(2).setCellValue("Not verified");
	                userdetails.autoSizeColumn(2);
	                r2.createCell(3).setCellValue("Fail");
	                // Create font for status and result
	                XSSFFont failFont = workbook.createFont();
	                failFont.setBold(true);
	                // Create cell style for fail
	                XSSFCellStyle failStyle = workbook.createCellStyle();
	                failStyle.setFont(failFont);
	                failStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
	                failStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	                // Apply style to fail cell
	                XSSFCell failCell1 = r2.getCell(2);
	                failCell1.setCellStyle(failStyle);
	                XSSFCell failCell2 = r2.getCell(3);
	                failCell2.setCellStyle(failStyle);
	            }
	 
	            // Set bold font style for Status and Result columns
	            for (int i = 2; i <= 3; i++) {
	                XSSFCell cell = r1.createCell(i);
	                cell.setCellValue(i == 2 ? "Status" : "Result");
	                cell.setCellStyle(style);
	            }
	            workbook.write(file);
	            workbook.close();
	            file.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
		    
	
	
	
	
	

	
    public static void writeInfoInColumn(String[] data,int colNum) {
    	FileInputStream file = null;
    	XSSFWorkbook workbook = null; 

          
        
		try {
			file = new FileInputStream(".\\TestData\\Data.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 try {
			workbook = new XSSFWorkbook(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         XSSFSheet eac = workbook.createSheet("EthicsAndComplianceInfo");
         XSSFRow r1 = eac.createRow(0);
        
         
         r1.createCell(0).setCellValue("ResourcesAndLinks");
         
         eac.autoSizeColumn(0);

    	 for(int i = 0; i<data.length; i++) {
    		 XSSFRow row = eac.createRow(i+1);
    		 row.createCell(colNum).setCellValue(data[i]);

    	 }
         eac.autoSizeColumn(colNum);

    	 
    	 try {
			file.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	 FileOutputStream fileOut=null;
    	 try {
			fileOut = new FileOutputStream(".\\TestData\\Data.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 
    	 try {
			workbook.write(fileOut);
			workbook.close();
	         file.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
    	 
    	
    }


    	public void writeData(String sheetName, List<String> a,int rowNo, int colNo, String filepath) throws IOException {

    		FileInputStream file = null;

        	XSSFWorkbook workbook = null;
 
    		try {

    			file = new FileInputStream(".\\TestData\\Data.xlsx");

    		} catch (FileNotFoundException e) {

    			// TODO Auto-generated catch block

    			e.printStackTrace();

    		}

        	 try {

    			workbook = new XSSFWorkbook(file);

    		} catch (IOException e) {

    			// TODO Auto-generated catch block

    			e.printStackTrace();

    		}

    		XSSFSheet sheet = null;

    		try {

    			sheet = workbook.createSheet(sheetName);

    			System.out.println("sheet found" + sheet);

    		}

    		catch(Exception e) {

    			sheet = workbook.getSheet(sheetName);

    			System.out.println("createdd sheet " + sheet);

    		}
 
    		 

    		for(int i = rowNo; i<a.size(); i++) {

    			if(sheet.getRow(i)==null)

    			{

    				sheet.createRow(i);

    			}

    			XSSFRow row =sheet.getRow(i);   

    			row.createCell(colNo).setCellValue(a.get(i));


    		}
    		
            sheet.autoSizeColumn(colNo);


    		try {

    			file.close();

    		} catch (IOException e1) {

    			// TODO Auto-generated catch block

    			e1.printStackTrace();

    		}

    		FileOutputStream fo=new FileOutputStream(filepath);

    		workbook.write(fo);		

    		fo.close();

    		fo.close();
 
    	}

    }