package com.gxz.sys.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.gxz.sys.utils.RandomUtils;

@Controller
@RequestMapping("file")
public class UploadController {

	@Value("${upload.uploadPath}")
	private String uploadPath;

	/**
	 * 文件上传
	 */
	@RequestMapping("uploadFile")
	@ResponseBody
	public Map<String,Object> uploadFile(MultipartFile mf) {
		//创建文件夹
		String dirName=RandomUtils.createDateStrUseCurrrentDate();
		//构造文件夹对象
		File dirFile=new File(uploadPath,dirName);
		//判断文件夹是否存在
		if(!dirFile.exists()) {
			dirFile.mkdirs();
		}
		//生成文件新名字
		String newFileName=RandomUtils.createFileNameUseTime(mf.getOriginalFilename());
		//构造要上传的文件
		File newFile=new File(dirFile, newFileName);
		//上传
		Integer code=0;
		try {
			mf.transferTo(newFile);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			code=-1;
		}
		Map<String,Object> map=new HashMap<>();
		map.put("code", code);
		map.put("msg", "");
		Map<String,Object> data=new HashMap<>();
		data.put("src", dirName+"/"+newFileName);
		map.put("data", data);
		return map;
	}

	/**
	 * 文件下载
	 */
	@RequestMapping("download")
	public ResponseEntity<Object> fileDownload(String path) {
		// 构造文件对象
		File file = new File(uploadPath,path);

		// 将下载的文件，封装byte[]
		byte[] bytes = null;
		try {
			bytes = FileUtils.readFileToByteArray(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 创建封装响应头信息的对象
		HttpHeaders header = new HttpHeaders();
		// 封装响应内容类型(APPLICATION_OCTET_STREAM 响应的内容不限定)
		header.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		// 设置下载的文件的名称
		header.setContentDispositionFormData("attachment", "123.jpg");

		// 创建ResponseEntity对象
		ResponseEntity<Object> entity = new ResponseEntity<Object>(bytes, header, HttpStatus.CREATED);

		return entity;

	}

}
