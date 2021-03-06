package com.gxf.user.controller;

import com.gxf.common.entity.MsgResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 功能描述：文件测试
 *	文件访问路径：http://localhost:8006/uploadpath/49b06ec5-fc75-4205-b47d-986b677f6a20.jpg
 *	文件上传页面路径：http://localhost:8006/upload.html
 *注意这个注解，参考：启动时注解.txt
 */
@Controller
@PropertySource({"classpath:gxf.properties"})
public class FileController {

	@Value("${web.file.path}")
	private String filePath;

	@RequestMapping(value = "upload")
	@ResponseBody
	public MsgResponse upload(@RequestParam("head_img") MultipartFile file, HttpServletRequest request) {

		//file.isEmpty(); 判断图片是否为空
		//file.getSize(); 图片大小进行判断

		System.out.println("配置注入打印，文件路径为："+filePath);


		String name = request.getParameter("name");
		System.out.println("用户名："+name);

		// 获取文件名
		String fileName = file.getOriginalFilename();
		System.out.println("上传的文件名为：" + fileName);

		// 获取文件的后缀名,比如图片的jpeg,png
		String suffixName = fileName.substring(fileName.lastIndexOf("."));
		System.out.println("上传的后缀名为：" + suffixName);

		// 文件上传后的路径
		fileName = UUID.randomUUID() + suffixName;
		System.out.println("转换后的名称:"+fileName);

		File dest = new File(filePath + fileName);

		try {
			file.transferTo(dest);
			return null;
//			return new MsgResponse(HttpStatus.OK.value(), fileName);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
//		return  new MsgResponse(-1, "fail to save ", null);
	}

}
