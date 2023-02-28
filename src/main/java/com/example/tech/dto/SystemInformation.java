package com.example.tech.dto;

import java.io.Serializable;
import java.util.Set;

public class SystemInformation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String hostName;
	private String hostAddress;
	private String osName;
	private String workingDirectoryName;
	private Set<ProcessInfo> processList;

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getHostAddress() {
		return hostAddress;
	}

	public void setHostAddress(String hostAddress) {
		this.hostAddress = hostAddress;
	}

	public String getOsName() {
		return osName;
	}

	public void setOsName(String osName) {
		this.osName = osName;
	}

	public String getWorkingDirectoryName() {
		return workingDirectoryName;
	}

	public void setWorkingDirectoryName(String workingDirectoryName) {
		this.workingDirectoryName = workingDirectoryName;
	}

	public Set<ProcessInfo> getProcessList() {
		return processList;
	}

	public void setProcessList(Set<ProcessInfo> processList) {
		this.processList = processList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hostAddress == null) ? 0 : hostAddress.hashCode());
		result = prime * result + ((hostName == null) ? 0 : hostName.hashCode());
		result = prime * result + ((osName == null) ? 0 : osName.hashCode());
		result = prime * result + ((processList == null) ? 0 : processList.hashCode());
		result = prime * result + ((workingDirectoryName == null) ? 0 : workingDirectoryName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		SystemInformation other = (SystemInformation) obj;
		if (hostAddress == null) {
			if (other.hostAddress != null) {
				return false;
			}
		} else if (!hostAddress.equals(other.hostAddress)) {
			return false;
		}
		if (hostName == null) {
			if (other.hostName != null) {
				return false;
			}
		} else if (!hostName.equals(other.hostName)) {
			return false;
		}
		if (osName == null) {
			if (other.osName != null) {
				return false;
			}
		} else if (!osName.equals(other.osName)) {
			return false;
		}
		if (processList == null) {
			if (other.processList != null) {
				return false;
			}
		} else if (!processList.equals(other.processList)) {
			return false;
		}
		if (workingDirectoryName == null) {
			if (other.workingDirectoryName != null) {
				return false;
			}
		} else if (!workingDirectoryName.equals(other.workingDirectoryName)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "SystemInformation [hostName=" + hostName + ", hostAddress=" + hostAddress + ", osName=" + osName
				+ ", workingDirectoryName=" + workingDirectoryName + ", processList=" + processList + "]";
	}

}
