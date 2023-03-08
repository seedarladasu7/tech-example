package com.example.tech.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tech.dto.SystemInformation;
import com.example.tech.service.SystemInformationServiceImpl;
import com.example.tech.util.InstalledSoftwareList;

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

	@GetMapping("/listOfSoftwares/{application}")
	public ResponseEntity<Map<String, Object>> getListOfSoftwares(@PathVariable String application) throws IOException {
		File response = null;
		Map<String, Object> map = new HashMap<String, Object>();
		boolean result = systemProcessService.uploadService(application);
		InstalledSoftwareList installedSoftwareList = new InstalledSoftwareList();
		if (!result) {
			File directory = new File("c:/");
			File file = installedSoftwareList.searchFile(directory, application + ".exe");
			if (file != null) {
				System.out.println(file.getAbsoluteFile());
				response = file.getAbsoluteFile();
				//Runtime.getRuntime().exec(file.getAbsoluteFile().toString());// exec("sc query " +
			}
		}
		if (result) {
			map.put("status", result);
			map.put("message", "Application is running");
			// map.put("message",application+ " " + "is running");
		} else {
			map.put("status", result);
			map.put("path", response);
			// map.put("message","Application is installed but not running");
			map.put("message", application + " " + "is installed but not running");
		}
		return new ResponseEntity<>(map, HttpStatus.OK);

	}
}