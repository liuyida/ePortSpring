package com.xmhuanyu.eport.third.Util;

import java.io.*;

/**
 * 纯Java文件操作工具，支持文件、文件夹的复制、删除、移动操作。
 * 
 * @author leizhimin 2010-6-2 16:12:14
 */
public class FileToolkit {
	public FileToolkit() {
	}

	public static void main(String args[]) throws IOException {
		// delete(new File("C:/aaa"));
		// copy(new File("D:\\work\\mrpt"), new File("C:\\aaa"));
		move(new File("C:\\bbb"), new File("C:\\ddd"));

	}

	/**
	 * 删除文件（夹）
	 * 
	 * @param file
	 *            文件（夹）
	 */
	public static void delete(File file) {
		if (!file.exists())
			return;
		if (file.isFile()) {
			file.delete();
		} else {
			for (File f : file.listFiles()) {
				delete(f);
			}
			file.delete();
		}
	}

	/**
	 * 复制文件（夹）到一个目标文件夹
	 * 
	 * @param resFile
	 *            源文件（夹）
	 * @param objFolderFile
	 *            目标文件夹
	 * @throws IOException
	 *             异常时抛出
	 */
	public static void copy(File resFile, File objFolderFile)
			throws IOException {
		if (!resFile.exists())
			return;
		if (!objFolderFile.exists())
			objFolderFile.mkdirs();
		if (resFile.isFile()) {
			File objFile = new File(objFolderFile.getPath() + File.separator
					+ resFile.getName());
			// 复制文件到目标地
			InputStream ins = new FileInputStream(resFile);
			FileOutputStream outs = new FileOutputStream(objFile);
			byte[] buffer = new byte[1024 * 512];
			int length;
			while ((length = ins.read(buffer)) != -1) {
				outs.write(buffer, 0, length);
			}
			ins.close();
			outs.flush();
			outs.close();
		} else {
			String objFolder = objFolderFile.getPath() + File.separator
					+ resFile.getName();
			File _objFolderFile = new File(objFolder);
			_objFolderFile.mkdirs();
			for (File sf : resFile.listFiles()) {
				copy(sf, new File(objFolder));
			}
		}
	}

	/**
	 * 将文件（夹）移动到令一个文件夹
	 * 
	 * @param resFile
	 *            源文件（夹）
	 * @param objFolderFile
	 *            目标文件夹
	 * @throws IOException
	 *             异常时抛出
	 */
	public static void move(File resFile, File objFolderFile)
			throws IOException {
		copy(resFile, objFolderFile);
		delete(resFile);
	}
}
