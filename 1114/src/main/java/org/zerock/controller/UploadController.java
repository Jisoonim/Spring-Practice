package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

	@GetMapping("/uploadForm")
	public void uploadByForm() {
		
	}
	
	@PostMapping("/uploadFormAction")

	public void uploadFormPost(MultipartFile[] uploadFile, Model model) {

	for (MultipartFile multipartFile : uploadFile) {

	System.out.println("-------------------------------------");

	System.out.println("Upload File Name: " +multipartFile.getOriginalFilename());

	System.out.println("Upload File Size: " +multipartFile.getSize());


	}

	}
}
