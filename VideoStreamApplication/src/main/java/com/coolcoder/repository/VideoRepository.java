package com.coolcoder.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coolcoder.entity.Video;

@Repository
public interface VideoRepository extends JpaRepository<Video, String>{

	Optional<Video> findByTitel(String titel);
	
}
