package com.twg.service;

import java.util.List;

import com.twg.entity.Course;

public interface CourseService 
{
	public String upsert(Course course);
	
	public Course getById(Integer cid);
	
	public List<Course> getAllCourse();
	
	public String deleteById(Integer cid);
	
}
