package com.lanou.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import sun.misc.BASE64Decoder;

public class Base64 {

	private HttpServletRequest request;

	public String generateImage(String imStr, String type) {

		String path = null;
		if (imStr == null) {
			return null;
		}
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			byte[] b = decoder.decodeBuffer(imStr);
			for (int i = 0; i < b.length; i++) {
				if (b[i] < 0) {
					b[i] += 256;
				}
			}
			Random random = new Random();
			int number = random.nextInt(999999999 - 100000000 + 1) + 100000000;
			String pathh = request.getSession().getServletContext().getRealPath("/uploads");
			String imgFilePath = pathh + number + "." + type;
			if (!new File(pathh).exists()) {
				new File(pathh).mkdirs();
			}
			path = "Shopping/uploads/" + number + "." + type;
			OutputStream out = new FileOutputStream(imgFilePath);
			out.write(b);
			out.flush();
			out.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return path;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

}
