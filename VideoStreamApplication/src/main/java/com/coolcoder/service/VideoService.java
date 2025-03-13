package com.coolcoder.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.coolcoder.entity.Video;

public interface VideoService {

	Video save(Video video, MultipartFile file);

	Video get(Video videoId);

	Video getByTitel(String titel);

	List<Video> getAll();
}
