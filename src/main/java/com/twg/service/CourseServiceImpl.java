package com.twg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twg.entity.Course;
import com.twg.repository.CourseRepo;

@Service
public class CourseServiceImpl implements CourseService
{
	@Autowired
	private CourseRepo courseRepo; 

	@Override
	public String upsert(Course course)
	{
		courseRepo.save(course);
		return "Success";
	}

	@Override
	public Course getById(Integer cid) 
	{
		Optional<Course> retrieve = courseRepo.findById(cid);
		if (retrieve.isPresent()) 
		{
			return retrieve.get();
		}
		
		return null;
	}

	@Override
	public List<Course> getAllCourse()
	{
		return courseRepo.findAll();
	}

	@Override
	public String deleteById(Integer cid) 
	{
		if (courseRepo.existsById(cid))
		{
			courseRepo.deleteById(cid);
			return "Delete Success";
		}
		else
		{
			return "No record is found";
		}
	}
}
