package org.zerock.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.dto.AttachDTO;

import net.coobird.thumbnailator.Thumbnailator;

@Controller
public class UploadController {

	@GetMapping("/uploadForm")
	public void uploadByForm() {

	}

	@GetMapping("/uploadAjax")
	public void uploadByAjax() {

	}

	@PostMapping("/uploadFormAction")

	public void uploadFormPost(MultipartFile[] uploadFile, Model model) {

		String uploadFolder = "C:\\upload";

		for (MultipartFile multipartFile : uploadFile) {

			System.out.println("-------------------------------------");

			System.out.println("Upload File Name: " + multipartFile.getOriginalFilename());

			System.out.println("Upload File Size: " + multipartFile.getSize());

			File saveFile = new File(uploadFolder, multipartFile.getOriginalFilename());

			try {

				multipartFile.transferTo(saveFile);

			} catch (Exception e) {

				System.out.println(e.getMessage());

			} // end catch
		}

	}

	@PostMapping(value = "/uploadAjaxAction", produces = MediaType.APPLICATION_JSON_UTF8_VALUE) // "application/json;charset=UTF-8"
	@ResponseBody
	public ResponseEntity<List<AttachDTO>> uploadAjaxPost(MultipartFile[] uploadFile) {

		System.out.println("update ajax post................");
		
		String uploadFolder = "C:\\upload";

		List<AttachDTO> attachList = new ArrayList<>();

		// make folder --------
		for (MultipartFile multipartFile : uploadFile) {
			System.out.println("-------------------------------------");

			System.out.println("Upload File Name: " + multipartFile.getOriginalFilename());

			System.out.println("Upload File Size: " + multipartFile.getSize());

			String uploadFileName = multipartFile.getOriginalFilename();

			// IE has file path
			uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\") + 1);
			System.out.println("only file name: " + uploadFileName);

			UUID uuid = UUID.randomUUID();

			String uploadName = uuid.toString() + "_" + uploadFileName;

			File saveFile = new File(uploadFolder, uploadName);
			try {

				multipartFile.transferTo(saveFile);

				boolean isImage = checkImageType(saveFile);

				if (isImage) {

					System.out.println("이미지 파일이 업로드 되었고, 썸네일 작업");

					FileOutputStream thumbnail = new FileOutputStream(new File(uploadFolder, "s_" + uploadName));

					Thumbnailator.createThumbnail(multipartFile.getInputStream(), thumbnail, 100, 100);

					thumbnail.close();
				}

				AttachDTO fileInfo = new AttachDTO(multipartFile.getOriginalFilename(), isImage, uploadName);

				System.out.println("fileInfo : " + fileInfo);

				attachList.add(fileInfo);

			} catch (Exception e) {

				System.out.println(e.getMessage());
			} // end catch
		} // end for
		return new ResponseEntity<>(attachList, HttpStatus.OK);
	}

	private boolean checkImageType(File file) {
		boolean result = false;

		try {
			String mimeType = Files.probeContentType(file.toPath());

			System.out.println("MIMETYPE : " + mimeType);

			result = mimeType.startsWith("image");

		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}

	@GetMapping("/viewFile")
	@ResponseBody
	public ResponseEntity<byte[]> viewFile(String fname) {

		File file = new File("C:\\upload", fname);

		try {
			String mimeType = Files.probeContentType(file.toPath());

			HttpHeaders header = new HttpHeaders();
			header.add("Content-Type", mimeType);

			byte[] data = FileCopyUtils.copyToByteArray(file);

			return new ResponseEntity<>(data, header, HttpStatus.OK);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	@GetMapping(value = "/downFile", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	@ResponseBody
	public ResponseEntity<byte[]> downFile(String fname) {

		File file = new File("C:\\upload", fname);

		try {

			HttpHeaders header = new HttpHeaders();
			
			header.add("Content-Disposition",
					"attachment; filename=" + new String(fname.getBytes("UTF-8"), "ISO-8859-1"));

			byte[] data = FileCopyUtils.copyToByteArray(file);

			return new ResponseEntity<>(data, header, HttpStatus.OK);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;

	}

}
