package com.example.tech.dto;

import java.io.Serializable;

public class SystemProcess implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String processName;
	private int pID;
	private String hostName;
	private String hostAddress;
	private String osName;
	private String workingDirectoryName;

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public int getpID() {
		return pID;
	}

	public void setpID(int pID) {
		this.pID = pID;
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hostAddress == null) ? 0 : hostAddress.hashCode());
		result = prime * result + ((hostName == null) ? 0 : hostName.hashCode());
		result = prime * result + ((osName == null) ? 0 : osName.hashCode());
		result = prime * result + pID;
		result = prime * result + ((processName == null) ? 0 : processName.hashCode());
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
		SystemProcess other = (SystemProcess) obj;
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
		if (pID != other.pID) {
			return false;
		}
		if (processName == null) {
			if (other.processName != null) {
				return false;
			}
		} else if (!processName.equals(other.processName)) {
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
		return "SystemProcess [processName=" + processName + ", pID=" + pID + ", hostName=" + hostName
				+ ", hostAddress=" + hostAddress + ", osName=" + osName + ", workingDirectoryName="
				+ workingDirectoryName + "]";
	}

}
