package com.twg.controller;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.twg.entity.Course;
import com.twg.service.CourseService;

@RestController
public class CourseController 
{
	@Autowired
	private CourseService courseService;
	
	@PostMapping("/save")
	public ResponseEntity<String> createCourse(@RequestBody Course course)
	{
		String status = courseService.upsert(course);
		return new ResponseEntity<String>(status,HttpStatus.CREATED);
	}
	
	@GetMapping("/course/{cid}")
	public ResponseEntity< Course> getCourse(@PathVariable Integer cid)
	{
		Course course = courseService.getById(cid);
		return new ResponseEntity<Course>(course,HttpStatus.OK);
	}
	
//	@GetMapping("/alldata")
//	public ResponseEntity<List<Course>> allCourse()
//	{
//		List<Course> course = courseService.getAllCourse();
//		return new ResponseEntity<List<Course>>(course, HttpStatus.OK);
//	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateCourse(@RequestBody Course course)
	{
		String status = courseService.upsert(course);
		return new ResponseEntity<String>(status,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{cid}")
	public ResponseEntity<String> deleteById(@PathVariable Integer cid)
	{
		String status =courseService.deleteById(cid);
		return new ResponseEntity<>(status, HttpStatus.ACCEPTED);
	}
	
}
