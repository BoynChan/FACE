package edu.hfut.Controller.face.Register;

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
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Random;

/*
    Project: FACE
    Author: Boyn
    Date: 2019/5/25
*/
@Controller("faceRegister")
@RequestMapping("/face")
public class RegisterController {
	//TODO:将注册器的POST方法改为通过AJAX传输
	@Autowired
	private WorkTableService workTableService;

	/**
	 *  这个方法主要实现了两个功能:
	 *  1.将传入的相片文件存储到文件当中
	 *  2.将传入的信息进行POJO的整合存储到数据库中
	 *  <p>
	 *  通过Register.jsp中注册信息表单传输信息
	 *  这个方法通过POST调用
	 *  <p>
	 *  工作流程是:先找到workerInfo在数据库中现在所进行到的最大id
	 *  然后通过request来获取运行环境的真实路径,并和/resources/photo结合起来
	 *  产生照片的存储目录
	 *  然后通过WorkerInfoFactory类,将传入的信息装配起来
	 *  并通过workTableService的insertWorkerInfo将WorkerInfo存储到数据库中
	 *
	 * @param workerName     工作人员姓名
	 * @param gender         性别
	 * @param age            年龄
	 * @param phone          电话
	 * @param email          邮箱
	 * @param workerGroup    工作组
	 * @param workerPosition 职位
	 * @param file           传过来的照片文件
	 * @param model          model
	 * @param request 请求
	 * @return 返回注册页面,并附带是否成功的信息
	 * @throws Exception
	 */
	@PostMapping(value = "/register")
	public String register(
			HttpServletRequest request,
			@RequestParam(value = "workerName", required = false) String workerName,
			@RequestParam(value = "gender", required = false) String gender,
			@RequestParam(value = "age", required = false) String age,
			@RequestParam(value = "phone", required = false) String phone,
			@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "workerGroup", required = false) String workerGroup,
			@RequestParam(value = "workerPosition", required = false) String workerPosition,
			@RequestParam(value = "photo", required = false) MultipartFile file,
			Model model
	) throws Exception {
		//TODO:处理可能发生的异常,并向客户端返回注册失败的信息
		WorkerInfo workerInfo;
		if(!file.isEmpty()) {
			String originName = file.getOriginalFilename();
			String path = request.getServletContext().getRealPath("resources/photo/");//指定照片存储的目录为resources/photo/
			String r = RandomStringUtils.randomAlphanumeric(8);//随机生成8位
			String fileName = r + "." + originName.substring(originName.lastIndexOf(".") + 1);
			File filePath = new File(path, fileName);//生成绝对路径名
			if (!filePath.getParentFile().exists()) {
				filePath.getParentFile().mkdirs();//如果路径不存在,则创建路径
			}
			file.transferTo(new File(path + fileName));
			File photoFile = new File(filePath.toString());

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
		}else{
			//如果没有上传照片,则自动引用none.jpg(存储在/resources/photo中)
			String path = request.getServletContext().getRealPath("resources/photo/");
			workerInfo = new WorkerInfoFactory().build(
					workerName,
					gender,
					phone,
					email,
					workerGroup,
					workerPosition,
					path+"none.jpg",
					"none.jpg",
					age,
					null);
		}
		workTableService.insertWorkerInfo(workerInfo);
		model.addAttribute("success",true);
		return "register";
	}

}
