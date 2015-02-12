package md.fcim.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.commons.lang.RandomStringUtils;

public class CoolURLUtils {

	
	private CoolURLUtils() {
	}

	public static String generateString() {
		return RandomStringUtils.random(new Random().nextInt(25) + 6, CoolUrlConstants.ALPHABET);
	}

	public static void main(String[] args) {
//		System.out.println(generateString());
		writeToFile("ertewrter123", "linkkk","a");
	}

	public static Map<String, String> readFromFile(String value, String fileName) {

		Map<String, String> resultMap = new HashMap<String, String>();
		
		
		try (BufferedReader br = new BufferedReader(new FileReader(
				CoolUrlConstants.HOME_DIRECTORY + fileName + ".txt"))) {
			String sCurrentLine = "";

			while ((sCurrentLine = br.readLine()) != null) {
					int index = sCurrentLine.indexOf(";");
					if (sCurrentLine.substring(0, index).equals(value)){
						resultMap.put(sCurrentLine.substring(0, index), sCurrentLine.substring(index+1));
						break;
					}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return resultMap;
	}
	
	
	public static void writeToFile(String key, String value, String fileName) {
		
		Path path = FileSystems.getDefault().getPath(CoolUrlConstants.HOME_DIRECTORY, fileName + ".txt") ;
		
		try (BufferedWriter bw = Files.newBufferedWriter (path, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
			
			bw.append(key + ";" + value + "\n");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
