package com.example.tech.service;

import com.example.tech.dto.SystemInformation;

public interface SystemInformationService {

	public SystemInformation getSystemProcessInfo();

	public boolean uploadService(String serviceName);

}
