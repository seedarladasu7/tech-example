package com.example.tech.service;

import org.springframework.stereotype.Service;

import com.example.tech.dto.SystemProcess;

@Service
public class SystemProcessService {

	public SystemProcess getSystemProcessInfo() {
		SystemProcess sysProcess = new SystemProcess();
		sysProcess.setHostName("HostName");
		sysProcess.setHostAddress("Host Address");
		sysProcess.setpID(1234);
		sysProcess.setOsName("OS Name");
		sysProcess.setProcessName("Process Name");
		sysProcess.setWorkingDirectoryName("Working Directory Name");
		return sysProcess;
	}

}
