package com.example.tech.util;

import java.io.File;

public class InstalledSoftwareList {

	public File searchFile(File file, String search) {
		if (file.isDirectory()) {
			File[] arr = file.listFiles();
			if (arr != null)
				for (File f : arr) {
					File found = searchFile(f, search);
					if (found != null) {
						return found;
					}
				}
		} else {
			if (file.getName().equals(search)) {
				return file;
			}
		}
		return null;
	}

}
