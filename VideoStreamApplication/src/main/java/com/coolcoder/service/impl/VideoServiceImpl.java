package com.coolcoder.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.coolcoder.entity.Video;
import com.coolcoder.repository.VideoRepository;
import com.coolcoder.service.VideoService;

import jakarta.annotation.PostConstruct;

@Service
public class VideoServiceImpl implements VideoService {

	@Value("${file.video}")
	String DIR;

	@PostConstruct
	public void init() {

		File file = new File(DIR);

		if (!file.exists()) {
			file.mkdir();
			System.out.println("Folder Created:");
		} else {
			System.out.println("Folder alredy created");
		}

	}

	@Autowired
	private VideoRepository videoRepository;

	@Override
	public Video save(Video video, MultipartFile file) {

		// original file name
		try {
			String fileName = file.getOriginalFilename();
			String contentType = file.getContentType();
			InputStream inputStream = file.getInputStream();

			// folder path : create

			// File path
			String cleanFileName = StringUtils.cleanPath(fileName);

			String cleanFolder = StringUtils.cleanPath(DIR);

			// folder path with filename
			Path path = Paths.get(cleanFolder, cleanFileName);

			System.out.println(contentType);
			System.out.println(path);

			// copy file to the folder
			Files.copy(inputStream, path, StandardCopyOption.REPLACE_EXISTING);

			// video meta data
			video.setContentType(contentType);
			video.setFilePath(path.toString());

			// meta data save
			return videoRepository.save(video);

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public Video get(Video videoId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Video getByTitel(String titel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Video> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
