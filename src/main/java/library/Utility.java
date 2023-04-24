package library;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.DataProvider;

public class Utility {
	public static String GetpropertyFileData(String Key) throws IOException 
	{	
		FileInputStream file = new FileInputStream("C:\\Users\\shuah\\OneDrive\\Desktop\\SwagLab\\properties.properties");
		Properties p = new Properties();
		p.load(file);
		String value = p.getProperty(Key);
		return value;
	}
	public static void TakeSS(WebDriver driver,int TCID) throws IOException 
	{
		 File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 File Desti = new File("C:\\Users\\shuah\\OneDrive\\Desktop\\SwagLab\\failTestCaseSS\\TestCaseID"+TCID+".png");
		 FileHandler.copy(src, Desti);
	}
	public static String GetDataFromExcel(int Row,int Cell) throws EncryptedDocumentException, IOException 
	{
		FileInputStream file = new FileInputStream("C:\\Users\\shuah\\OneDrive\\Desktop\\SwagLab\\TestData\\testDataSwagLab.xlsx");
		 org.apache.poi.ss.usermodel.Sheet sheet = WorkbookFactory.create(file).getSheet("verification");
		 String value = sheet.getRow(Row).getCell(Cell).getStringCellValue();
		 return value;
	}
	@DataProvider(name="LoginData")
	public static Object[][] DataProvider() throws EncryptedDocumentException, IOException {
        String path = "C:\\Users\\shuah\\OneDrive\\Desktop\\SwagLab\\TestData\\testDataSwagLab.xlsx";
        String sheetName = "dataprovider";
        FileInputStream file = new FileInputStream(path);
        org.apache.poi.ss.usermodel.Sheet sheet = WorkbookFactory.create(file).getSheet(sheetName);
        int numberOfRows = sheet.getLastRowNum();
        int numberOfCells = sheet.getRow(0).getLastCellNum();
        Object[][] data = new Object[numberOfRows][numberOfCells];
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfCells; j++) {
                org.apache.poi.ss.usermodel.Cell cell = sheet.getRow(i + 1).getCell(j);
                switch (cell.getCellType()) {
                case STRING:
                    data[i][j] = cell.getStringCellValue();
                    break;
                case NUMERIC:
                    data[i][j] = cell.getNumericCellValue();
                    break;
                case BOOLEAN:
                    data[i][j] = cell.getBooleanCellValue();
                    break;
                default:
                    data[i][j] = "";
                }
            }
        }
        return data;
    }
	
	
	public static int RemoveWordAndStoreInteger(String word) 
	{
		String StrValue=word.replaceAll("\\D+", "");
		int value=Integer.parseInt(StrValue);
		return value;
	}
	public static double RemoveWordAndStoreDecimal(String word) {
		
		Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
		Matcher matcher = pattern.matcher(word);
		if(matcher.find())
		{
			return Double.parseDouble(matcher.group());
		}
		else 
		{
			throw new IllegalArgumentException("no number found");
		}
	}
}



