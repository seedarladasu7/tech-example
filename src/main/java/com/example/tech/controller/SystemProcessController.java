package com.example.tech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tech.dto.SystemInformation;
import com.example.tech.service.SystemInformationServiceImpl;

@RestController
@RequestMapping("/doc/v1/")
public class SystemProcessController {
	@Autowired
	private SystemInformationServiceImpl systemProcessService;

	@GetMapping("/processInfo")
	public ResponseEntity<SystemInformation> getProcessInfo() {

		// List<SystemInformation> sysProcess=
		// systemInformationService.getSystemProcessInfo();
		SystemInformation sysProcess = systemProcessService.getSystemProcessInfo();
		// return new ResponseEntity<List>(sysProcess, HttpStatus.OK);
		ResponseEntity<SystemInformation> entity = new ResponseEntity<>(sysProcess, HttpStatus.OK);

		return entity;

	}
}