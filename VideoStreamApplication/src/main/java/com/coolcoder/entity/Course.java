package com.coolcoder.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "yt_courses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {

	@Id
	private String id;

	private String titel;

//	@OneToMany(mappedBy = "course")
//	private List<Video> list=new ArrayList<>();

}
