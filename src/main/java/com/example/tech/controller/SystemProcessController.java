package com.example.tech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tech.dto.SystemProcess;
import com.example.tech.service.SystemProcessService;

@RestController
@RequestMapping("/doc/v1/")
public class SystemProcessController {
	@Autowired
	private SystemProcessService systemProcessService;

	@GetMapping("/processInfo")
	public ResponseEntity<SystemProcess> getProcessInfo() {

		SystemProcess sysProcess = systemProcessService.getSystemProcessInfo();

		return new ResponseEntity<>(sysProcess, HttpStatus.OK);

	}
}