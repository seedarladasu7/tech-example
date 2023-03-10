package com.example.tech.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.tech.dto.ProcessInfo;
import com.example.tech.dto.SystemInformation;
import com.example.tech.util.InstalledSoftwareList;

@Service
public class SystemInformationServiceImpl implements SystemInformationService {

	public SystemInformation getSystemProcessInfo() {
		String hostName;
		String hostAddress;
		String osName;
		String workingDirectoryName;

		SystemInformation sysInfo = null;
		try {

			sysInfo = new SystemInformation();
			hostName = InetAddress.getLocalHost().getHostName();
			hostAddress = InetAddress.getLocalHost().getHostAddress();
			osName = System.getProperty("os.name");
			workingDirectoryName = System.getProperty("user.dir");

			sysInfo.setHostName(hostName);
			sysInfo.setHostAddress(hostAddress);
			sysInfo.setOsName(osName);
			sysInfo.setWorkingDirectoryName(workingDirectoryName);

			String processEntry;
			Process process = null;
			String operatingSys = System.getProperty("os.name");
			List<ProcessInfo> pNameAndIdList = new ArrayList<>();

			if (operatingSys.contains("Windows")) {
				process = Runtime.getRuntime().exec(System.getenv("windir") + "\\system32\\" + "tasklist.exe");
			} else if (operatingSys.contains("Linux")) {
				process = Runtime.getRuntime().exec("ps -few");
			}

			BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
			while ((processEntry = input.readLine()) != null) {

				System.out.println(processEntry);
				ProcessInfo pInfo = new ProcessInfo();

				if (!processEntry.contains("Console")) {
					continue;
				}

				String processNameAndPId = processEntry.split(" Console")[0];
				System.out.println("processNameAndPId: " + processNameAndPId);

				boolean isPIDExists = false;

				if (processNameAndPId != null && !processNameAndPId.equals("") && !processNameAndPId.equals(" ")
						&& !processNameAndPId.equals("Image") && !processNameAndPId.contains("=")) {

					char[] chars = processNameAndPId.toCharArray();
					for (char c : chars) {
						if (Character.isDigit(c)) {
							isPIDExists = true;
						}
					}

					if (!isPIDExists) {
						continue;
					}
					String pricessName = processNameAndPId.split(" ")[0];
					String processId = processNameAndPId.substring(processNameAndPId.lastIndexOf(" "));

					if (processId != null && !processId.equals("")) {
						pInfo.setProcessId(Long.parseLong(processId.trim()));
					}
					pInfo.setProcessName(pricessName);
					pNameAndIdList.add(pInfo);
				}
			}

			sysInfo.setProcessList(pNameAndIdList);

			input.close();

		} catch (Exception err) {
			err.printStackTrace();
		}

		return sysInfo;
	}

	public boolean uploadService(String serviceName) {
		Map<String, Object> map = new HashMap<>();
		boolean result = false;
		InstalledSoftwareList installedSoftwareList = new InstalledSoftwareList();

		try {
			String line;
			
			Process p = null;
			
			String operatingSys = System.getProperty("os.name");
			
			if (operatingSys.contains("Windows")) {
				p = Runtime.getRuntime().exec("tasklist.exe");
			} else if (operatingSys.contains("Linux")) {
				//p = Runtime.getRuntime().exec("ps -few");
			}
			
			// System.out.println(p);
			BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while ((line = input.readLine()) != null) {
				if (line.startsWith(serviceName)) {
					result = true;
					break;
				}
			}
			input.close();
//		          if (!result) {
//		              File directory = new File("c:/");
//              File file = installedSoftwareList.searchFile(directory, serviceName +".exe");
//		              if (file != null) {
//		                  System.out.println(file.getAbsoluteFile());
//		                File response =  file.getAbsoluteFile();
//		                  Process process = Runtime.getRuntime().exec(file.getAbsoluteFile().toString());//exec("sc query " + serviceName);
//		              }
//		          }

		} catch (Exception err) {
			err.printStackTrace();
		}
		// return true;

		return result;
	}

}