package com.example.tech.dto;

import java.io.Serializable;

public class ProcessInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long processId;
	private String processName;

	public long getProcessId() {
		return processId;
	}

	public void setProcessId(long processId) {
		this.processId = processId;
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (processId ^ (processId >>> 32));
		result = prime * result + ((processName == null) ? 0 : processName.hashCode());
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
		ProcessInfo other = (ProcessInfo) obj;
		if (processId != other.processId) {
			return false;
		}
		if (processName == null) {
			if (other.processName != null) {
				return false;
			}
		} else if (!processName.equals(other.processName)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ProcessInfo [processId=" + processId + ", processName=" + processName + "]";
	}

}
