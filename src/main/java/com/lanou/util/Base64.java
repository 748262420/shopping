package com.lanou.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import sun.misc.BASE64Decoder;

public class Base64 {

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
			String imgFilePath = "C:\\Users\\xalo\\Pictures\\imggg\\" + number + "." + type;
			path = imgFilePath;
			OutputStream out = new FileOutputStream(imgFilePath);
			out.write(b);
			out.flush();
			out.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return path;

	}

}
