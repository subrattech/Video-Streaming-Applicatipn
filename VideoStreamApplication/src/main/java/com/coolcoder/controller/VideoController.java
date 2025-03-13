package com.coolcoder.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.coolcoder.entity.Video;
import com.coolcoder.payload.CustomMessage;
import com.coolcoder.service.VideoService;

@RestController
@RequestMapping("/api/v1/videos")
public class VideoController {

	@Autowired
	private VideoService videoService;

	@PostMapping
	public ResponseEntity<?> create(@RequestParam("file") MultipartFile file, @RequestParam("titel") String titel,
			@RequestParam("description") String description) {

		Video video = new Video();
		video.setTitel(titel);
		video.setDescription(description);
		video.setVideoId(UUID.randomUUID().toString());

		Video saveVideo = videoService.save(video, file);

		if (saveVideo != null) {
			return ResponseEntity.status(HttpStatus.OK).body(video);
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(CustomMessage.builder().message("Video not uploaded").success(false).build());
		}

	}

}
