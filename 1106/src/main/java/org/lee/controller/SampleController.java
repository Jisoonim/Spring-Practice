package org.lee.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.lee.dto.BoardDTO;
import org.lee.dto.Member;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class SampleController {

	@RequestMapping("/ex1")
	public void ex1(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}
	
	@GetMapping("/exUpload")
	public void exUploadGET() {
		
	}
	
	@PostMapping("/exUpload")
	public void exUploadPOST(ArrayList<MultipartFile> files) {
		
		if(files.size() <= 0) {
			return;
		}
		files.forEach(file -> {
			System.out.println(file);
			System.out.println(file.getSize());
			System.out.println(file.getOriginalFilename());
			
			if(file.getSize() > 0) {
				
				String fileName = file.getOriginalFilename();
				File target = new File("C:\\zzz", fileName);
				
				try {
					FileCopyUtils.copy(file.getBytes() , target);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	@RequestMapping("/ex2")
	public void ex2(BoardDTO dto) {
		System.out.println(dto);
	}
	
	@PostMapping("/ex3")
	public void ex3(Member vo) {
		System.out.println(vo);
	}
	
	@GetMapping("/ex3")
	public void ex3Get() {

	}
	
}
