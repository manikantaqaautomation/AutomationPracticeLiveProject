package utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;

import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class commonUtils {
	
public static String generateEmail() {
		
		return new Date().toString().replaceAll("\\s","").replaceAll("\\:","")+"@mail.com";
		
	}

public static boolean compareTwoScreenshots(String actualImagePath, String expectedImagePath) {
	BufferedImage acutualBImg = null;
	BufferedImage expectedBImg = null;
	try {
		acutualBImg = ImageIO.read(new File(System.getProperty("user.dir")+actualImagePath));
		expectedBImg = ImageIO.read(new File(System.getProperty("user.dir")+expectedImagePath));
	} catch (IOException e) {
		e.printStackTrace();
	}

	ImageDiffer imgDiffer = new ImageDiffer();
	ImageDiff imgDifference = imgDiffer.makeDiff(expectedBImg, acutualBImg);

	return imgDifference.hasDiff();

}

}
