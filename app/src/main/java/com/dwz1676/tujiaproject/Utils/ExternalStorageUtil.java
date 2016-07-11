package com.dwz1676.tujiaproject.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExternalStorageUtil {
	public static byte[] readDataFromSdcard(String dir, String fileName) {
		ByteArrayOutputStream baos = null;
		FileInputStream fis = null;
		try {
				String path =dir.concat("/").concat(fileName);
				File file = new File(path);
				if (file != null && file.exists()) {
					baos = new ByteArrayOutputStream();
					fis = new FileInputStream(file);
					int len = 0;
					byte[] buffer = new byte[1024];
					while ((len = fis.read(buffer)) != -1) {
						baos.write(buffer, 0, len);
					}
					return baos.toByteArray();
				}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (baos != null) {
				try {
					baos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

}
