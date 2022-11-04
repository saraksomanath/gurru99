package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;

public class UtilityMethods {

	@DataProvider(name = "ArrayData")
	public static String[][] arrayDataProvider() {

		String[][] array = { { "user1", "password1" }, { "user2", "password2" }, { "user3", "password3" } };
		return array;
	}

	public static void scroll(WebDriver driver) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)");
	}

	public static String getProperty(String key) throws IOException {

		Properties p = new Properties();

		File file = new File(
				"C:\\Users\\Somnath\\eclipse-workspace\\com.guru99\\src\\test\\resources\\test.properties");

		FileInputStream fis = new FileInputStream(file);
		p.load(fis);

		return p.getProperty(key);

	}

	public static void screenShot(WebDriver driver) throws IOException {

		TakesScreenshot scrShot = ((TakesScreenshot) driver);

		// Call getScreenshotAs method to create image file

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		// Move image file to new destination

		File DestFile = new File("C:\\Users\\Somnath\\eclipse-workspace\\com.guru99\\ScreenShot\\"
				+ System.currentTimeMillis() + ".png");

		// Copy file at destination

		FileUtils.copyFile(SrcFile, DestFile);

	}

	public static void dropDown(WebElement Element) {

		Select select = new Select(Element);

		List<WebElement> list = select.getOptions();

		for (WebElement webElement : list) {

			webElement.click();

			System.out.println(webElement.getText());
		}
	}

	@DataProvider(name = "excelData")
	public static String[][] excelDataProvider() throws IOException {

		String[][] array;

		File file = new File(
				"C:\\Users\\Somnath\\eclipse-workspace\\com.guru99\\src\\test\\resources\\ExcelTestData.xls");

		FileInputStream fis = new FileInputStream(file);

		HSSFWorkbook wb = new HSSFWorkbook(fis);

		HSSFSheet sheet = wb.getSheetAt(0);

		HSSFRow row = sheet.getRow(0);

		Cell cell;

		int rowNo = sheet.getPhysicalNumberOfRows();
		int ColumnNo = row.getPhysicalNumberOfCells();

		array = new String[rowNo][ColumnNo];

		for (int i = 0; i < rowNo; i++) {

			for (int j = 0; j < ColumnNo; j++) {

				row = sheet.getRow(i);
				cell = row.getCell(j);
				array[i][j] = cell.getStringCellValue();
			}
		}
		
		return array;
	}

}
