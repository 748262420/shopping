package com.lanou.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Upload {

	private File file;

	private String fileFileName;

	private InputStream inputStream;

	private String fileContentType;

	public String upload() {

		try {
			FileInputStream fileInputStream = new FileInputStream(file);
		} catch (Exception e) {

		} finally {

		}
		return null;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

}
