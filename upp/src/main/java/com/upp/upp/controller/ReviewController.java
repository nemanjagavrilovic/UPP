package com.upp.upp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.upp.upp.model.FormSubmissionDto;

@Controller
@RequestMapping(value="/review")
public class ReviewController {

	@RequestMapping(value="/chiefEditor",method=RequestMethod.POST)
	public void reviewDescision(@RequestBody List<FormSubmissionDto> dto){
		
	}
}
