package edu.hfut.Controller.face.Update;

import com.sun.istack.internal.NotNull;
import edu.hfut.factory.WorkerInfoFactory;
import edu.hfut.pojo.WorkerInfo;
import edu.hfut.service.WorkTableService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/*
    Project: FACE
    Author: Boyn
    Date: 2019/5/28
*/

/**
 * 更新控制器
 */
@Controller
@RequestMapping("/face")
public class UpdateController {
	@Autowired
	private WorkTableService workTableService;


	/**
	 * 通过FormData对象提交表单对对象进行修改
	 * @param httpServletRequest Servlet请求文件
	 * @param request FormData对象生成的MultipartHttpServletRequest
	 * @return "success"
	 */
	@PostMapping(value = "/update", produces = "application/json;charset=utf-8")
	@ResponseBody
	public Object update(
			HttpServletRequest httpServletRequest,
			MultipartHttpServletRequest request
	) {
		String workerName = request.getParameter("workerName");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String age = request.getParameter("age");
		String workerGroup = request.getParameter("workerGroup");
		String workerPosition = request.getParameter("workerPosition");
		String id = request.getParameter("id");
		String isUpload = request.getParameter("isUpload");
		WorkerInfo originWorkerInfo = workTableService.getWorkerInfoById(Integer.parseInt(id));
		WorkerInfo workerInfo;
		if (isUpload.equals("0")) {
			String path = originWorkerInfo.getPhotoPath();
			String photoName = originWorkerInfo.getPhotoName();
			workerInfo = new WorkerInfoFactory().build(
					workerName,
					gender,
					phone,
					email,
					workerGroup,
					workerPosition,
					path,
					photoName,
					age,
					null);
			workerInfo.setId(originWorkerInfo.getId());
		} else {
			MultipartFile file = request.getFile("photo");
			String originName = file.getOriginalFilename();
			String path = httpServletRequest.getServletContext().getRealPath("resources/photo/");//指定照片存储的目录为resources/photo/
			String r = RandomStringUtils.randomAlphanumeric(12);
			String fileName = r + "." + originName.substring(originName.lastIndexOf(".") + 1);
			File filePath = new File(path, fileName);//生成绝对路径名
			if (!filePath.getParentFile().exists()) {
				filePath.getParentFile().mkdirs();//如果路径不存在,则创建路径
			}
			try {
				file.transferTo(new File(path + fileName));
			} catch (Exception e) {
				e.printStackTrace();
			}
			File photoFile = new File(filePath.toString());
			String originPhotoPath = originWorkerInfo.getPhotoPath();
			File originPhoto = new File(originPhotoPath);
			originPhoto.delete();
			workerInfo = new WorkerInfoFactory().build(
					workerName,
					gender,
					phone,
					email,
					workerGroup,
					workerPosition,
					filePath.toString(),
					fileName,
					age,
					photoFile);
			workerInfo.setId(originWorkerInfo.getId());
		}
		workTableService.updateWorkerInfo(workerInfo);
		return "success";//返回成功
	}
}
