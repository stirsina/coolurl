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

	private static String HOME_DIRECTORY = "c:\\work\\hehe\\";
	private static String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_";

	private CoolURLUtils() {
	}

	public static String generateString() {
		return RandomStringUtils.random(new Random().nextInt(25) + 6, ALPHABET);
	}

	public static void main(String[] args) {
//		System.out.println(generateString());
		writeToFile("ertewrter123", "linkkk","a");
	}

	public static Map<String, String> readFromFile(String value, String fileName) {

		Map<String, String> resultMap = new HashMap<String, String>();
		
		
		try (BufferedReader br = new BufferedReader(new FileReader(
				HOME_DIRECTORY + fileName + ".txt"))) {
			String sCurrentLine = "";

			while ((sCurrentLine = br.readLine()) != null) {
				if (sCurrentLine.startsWith(value))
				{
					int index = sCurrentLine.indexOf(";");
					resultMap.put(sCurrentLine.substring(0, index), sCurrentLine.substring(index));
					break;
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return resultMap;
	}
	
	
	public static void writeToFile(String key, String value, String fileName) {
		
		Path path = FileSystems.getDefault().getPath(HOME_DIRECTORY, fileName + ".txt") ;
		
		try (BufferedWriter bw = Files.newBufferedWriter (path, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
			
			bw.append(key + ";" + value + "\n");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
