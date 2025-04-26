package utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.imageio.ImageIO;

import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class commonUtils {

	public static String generateEmail() {

		return new Date().toString().replaceAll("\\s", "").replaceAll("\\:", "") + "@mail.com";

	}

	public static boolean compareTwoScreenshots(String actualImagePath, String expectedImagePath) {
		BufferedImage acutualBImg = null;
		BufferedImage expectedBImg = null;
		try {
			acutualBImg = ImageIO.read(new File(System.getProperty("user.dir") + actualImagePath));
			expectedBImg = ImageIO.read(new File(System.getProperty("user.dir") + expectedImagePath));
		} catch (IOException e) {
			e.printStackTrace();
		}

		ImageDiffer imgDiffer = new ImageDiffer();
		ImageDiff imgDifference = imgDiffer.makeDiff(expectedBImg, acutualBImg);

		return imgDifference.hasDiff();

	}

	public static void deleteTheImage(String imageName) {

		File imageFilePath = new File(System.getProperty("user.dir") + "\\Screenshots\\" + imageName);
		if (imageFilePath.exists()) {
			if (imageFilePath.delete()) {
				System.out.println("Image deleted successfully: " + imageName);
			} else {
				System.out.println("Failed to delete the image.");
			}
		} else {
			System.out.println("Image file not found.");
		}

	}

	public static Properties loadProperties() {

		Properties prop = new Properties();
		try {
			FileReader fr = new FileReader(
					System.getProperty("user.dir") + "//src//test//resources//projectData.properties");
			prop.load(fr);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	
	
}
