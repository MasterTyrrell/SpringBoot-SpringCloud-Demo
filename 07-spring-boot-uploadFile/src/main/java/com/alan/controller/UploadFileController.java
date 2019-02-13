package com.alan.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadFileController {
	
	@RequestMapping("/uploadFileController")
	public Map<String,String> uploadFile(MultipartFile file)throws Exception{
		System.out.println(file.getOriginalFilename());
		file.transferTo(new File("e:/"+file.getOriginalFilename()));
		Map<String,String> map = new HashMap<String,String>();
		map.put("msg", "ok");
		return map;
		
	}
}
