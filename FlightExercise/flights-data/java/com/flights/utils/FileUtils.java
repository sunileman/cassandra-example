package com.flights.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

	public static List<String> readFileIntoList(String filename) {

		List<String> fileList = new ArrayList<String>();
		BufferedReader br = null;
		File file = new File("src/main/resources", filename);

		try {
			String currentLine;
			br = new BufferedReader(new FileReader(file));

			while ((currentLine = br.readLine()) != null) {
				fileList.add(currentLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}			
		}
		return fileList;
	}
}
