package edu.hfut.util;
/*
    Project: FACE
    Author: Boyn
    Date: 2019/5/26
*/

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 将PNG格式转为JPG格式
 */
public class ImageConverter {

	public static File Convert(File image) throws IOException{
		String suffix = getSuffix(image);
		if(suffix.equals("jpg")){
			return image;
		}
		else if(suffix.equals("png")){
			return png2jpg(image);
		}
		return null;
	}

	private static String getSuffix(File file){
		String fileName = file.getName();
		return fileName.substring(fileName.lastIndexOf(".")+1);
	}

	private static File png2jpg(File pngFile) throws IOException{

		String fileName = pngFile.getName();
		BufferedImage bufferedImage = ImageIO.read(pngFile);
		BufferedImage jpgBufferedImage = new BufferedImage(bufferedImage.getWidth(),bufferedImage.getHeight(),BufferedImage.TYPE_INT_RGB);
		jpgBufferedImage.createGraphics().drawImage(bufferedImage,0,0, Color.WHITE,null);
		File jpgFile = new File(fileName.replace("png","jpg"));
		ImageIO.write(jpgBufferedImage,"jpg",jpgFile);
		return jpgFile;
	}
}
