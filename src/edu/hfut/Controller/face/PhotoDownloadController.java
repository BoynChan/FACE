package edu.hfut.Controller.face;
/*
    Project: FACE
    Author: Boyn
    Date: 2019/5/29
*/

import edu.hfut.service.WorkTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * 提供id下载worker的照片
 */
@Controller
@RequestMapping("/api")
public class PhotoDownloadController {
	@Autowired
	private WorkTableService workTableService;

	@RequestMapping("/download/{id}")
	public void download(@PathVariable Integer id, HttpServletRequest request, HttpServletResponse response) throws Exception{
		String filePath = workTableService.getPhotoPathById(id);
		String fileName = workTableService.getPhotoNameById(id);
		fileName = URLEncoder.encode(fileName,"UTF-8");
		File file = new File(filePath);
		response.setContentType("application/octet-stream");
		response.addHeader("Content-disposition", "attachment;filename=" + new String(fileName.getBytes(), StandardCharsets.UTF_8));
		InputStream inputStream = new FileInputStream(file);
		ServletOutputStream outputStream = response.getOutputStream();
		byte[] bs = new byte[4000000];
		while ((inputStream.read(bs) > 0)) outputStream.write(bs);
		outputStream.close();
		inputStream.close();
	}
}
