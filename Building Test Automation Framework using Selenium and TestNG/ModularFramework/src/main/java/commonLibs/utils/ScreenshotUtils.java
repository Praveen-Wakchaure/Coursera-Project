package commonLibs.utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {
	
	private TakesScreenshot camera;
	
	public ScreenshotUtils(WebDriver driver) {
		camera = (TakesScreenshot) driver;
	}

	public void captureAndSaveScreenshot(String filname) throws Exception {
		filname= filname.trim();
		
		File imgFile, tmpFile;
		
		imgFile = new File(filname);
		
		if(imgFile.exists()) {
			throw new Exception("File already exist");	
		}
		
		tmpFile = camera.getScreenshotAs(OutputType.FILE);
		
		FileUtils.moveFile(tmpFile, imgFile);
	}
}
