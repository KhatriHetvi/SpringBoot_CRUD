package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Demo;
import com.example.demo.repository.DemoRepository;

@RestController
public class DemoController {
		@Autowired
		DemoRepository demos;
		@PostMapping("demo/add")
		public String addDemo(Demo demo)
		{
			try
			{
				demos.save(demo);
				return "Record Added into Database";
			}
			catch(Exception ex)
			{
				return ex.getMessage();
			}
		}
		
		
		@GetMapping("demo/")
		public Iterable<Demo>getAllDemo()
		{
			return demos.findAll();
		}
		
		@PostMapping("demo/del")
		public String delDemo(Integer Id)
		{
			try
			{
				demos.deleteById(Id);
				return "Record Deleted";
			}
			catch(Exception ex)
			{
				ex.getMessage();
			}
			return "Something went wrong!!";
		}
}
