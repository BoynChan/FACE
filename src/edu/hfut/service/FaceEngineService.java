/*
package edu.hfut.service;
*/
/*
    Project: FACE
    Author: Boyn
    Date: 2019/5/18
*//*


import com.arcsoft.face.*;
import com.arcsoft.face.enums.ImageFormat;

import javax.imageio.ImageIO;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FaceEngineService {

	private static FaceEngineService faceEngineService;

	private FaceEngine faceEngine;

	*/
/**
	 * 设置为双验证的单例模式,保证了线程安全与效率
	 * @return FaceEngineService实例
	 *//*

	public static FaceEngineService getInstance(){
		if(faceEngineService==null){
			synchronized(FaceEngineService.class){
				if(faceEngineService==null){
					faceEngineService = new FaceEngineService();
				}
			}
		}
		return faceEngineService;
	}

	private FaceEngineService(){
			faceEngine = new FaceEngine();
			String appId = "7UTUXv6B8JXgxiU8j5R2rsaRFM2Y4wNF8wMVW7pPW5BK";
			String sdkKey = "6eYzJEiPP613UYyUnZyMtq2eruzADGfM5u4976x1Qtz2";
			faceEngine.active(appId, sdkKey);
			EngineConfiguration engineConfiguration = EngineConfiguration.builder().functionConfiguration(
					FunctionConfiguration.builder()
							.supportFaceDetect(true)
							.supportFaceRecognition(true)
							.build()).build();
			//初始化引擎
			faceEngine.init(engineConfiguration);
	}

	public byte[] getFaceFeature(File file) {
		ImageInfo imageInfo = getRGBData(file);
		List<FaceInfo> faceInfoList = new ArrayList<FaceInfo>();
		faceEngine.detectFaces(imageInfo.getRgbData(),imageInfo.getWidth(),imageInfo.getHeight(), ImageFormat.CP_PAF_BGR24,faceInfoList);
		FaceFeature faceFeature = new FaceFeature();
		faceEngine.extractFaceFeature(imageInfo.getRgbData(), imageInfo.getWidth(), imageInfo.getHeight(), ImageFormat.CP_PAF_BGR24, faceInfoList.get(0), faceFeature);
		return faceFeature.getFeatureData();
	}


	public ImageInfo getRGBData(File file) {
		if (file == null)
			return null;
		ImageInfo imageInfo;
		try {
			//将图片文件加载到内存缓冲区
			BufferedImage image = ImageIO.read(file);
			imageInfo = bufferedImage2ImageInfo(image);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return imageInfo;
	}

	private ImageInfo bufferedImage2ImageInfo(BufferedImage image) {
		ImageInfo imageInfo = new ImageInfo();
		int width = image.getWidth();
		int height = image.getHeight();
		// 使图片居中
		width = width & (~3);
		height = height & (~3);
		imageInfo.width = width;
		imageInfo.height = height;
		//根据原图片信息新建一个图片缓冲区
		BufferedImage resultImage = new BufferedImage(width, height, image.getType());
		//得到原图的rgb像素矩阵
		int[] rgb = image.getRGB(0, 0, width, height, null, 0, width);
		//将像素矩阵 绘制到新的图片缓冲区中
		resultImage.setRGB(0, 0, width, height, rgb, 0, width);
		//进行数据格式化为可用数据
		BufferedImage dstImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
		if (resultImage.getType() != BufferedImage.TYPE_3BYTE_BGR) {
			ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_LINEAR_RGB);
			ColorConvertOp colorConvertOp = new ColorConvertOp(cs, dstImage.createGraphics().getRenderingHints());
			colorConvertOp.filter(resultImage, dstImage);
		} else {
			dstImage = resultImage;
		}

		//获取rgb数据
		imageInfo.rgbData = ((DataBufferByte) (dstImage.getRaster().getDataBuffer())).getData();
		return imageInfo;
	}

}

class ImageInfo {
	public byte[] rgbData;
	public int width;
	public int height;

	public byte[] getRgbData() {
		return rgbData;
	}

	public void setRgbData(byte[] rgbData) {
		this.rgbData = rgbData;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
*/
