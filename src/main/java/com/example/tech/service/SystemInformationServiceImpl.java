package com.example.tech.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.tech.dto.ProcessInfo;
import com.example.tech.dto.SystemInformation;

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
			Set<ProcessInfo> pNameAndIdList = new HashSet<>();

			if (operatingSys.contains("Windows")) {
				process = Runtime.getRuntime().exec(System.getenv("windir") + "\\system32\\" + "tasklist.exe");
			} else if (operatingSys.contains("Linux")) {
				process = Runtime.getRuntime().exec("ps -few");
			}

			BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
			while ((processEntry = input.readLine()) != null) {
				// System.out.println("process: " + process);
				ProcessInfo pInfo = new ProcessInfo();
				String containsStr = "";
				if (processEntry.contains("Console")) {
					containsStr = "Console";
				} else if (processEntry.contains("Services")) {
					containsStr = "Services";
				}

				String processNameAndPId = processEntry.split(" " + containsStr)[0];
				System.out.println("processNameAndPId: " + processNameAndPId);

				if (processNameAndPId != null && !processNameAndPId.equals("") && !processNameAndPId.equals(" ")
						&& !processNameAndPId.equals("Image") && !processNameAndPId.contains("=")) {
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

}