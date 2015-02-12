package md.fcim.service;

import java.util.Map;

import md.fcim.utils.CoolURLUtils;

import org.apache.commons.lang.StringEscapeUtils;

public class GenerateUrlService {

	public boolean createNewUrl(String key, String value)
	{
		String tmpUrl = StringEscapeUtils.escapeJava(key);
		Map<String, String> fileMap = CoolURLUtils.readFromFile(tmpUrl, getFileName(tmpUrl));
		if (!fileMap.isEmpty())
		{
			//TODO throw record already exists
			return false;
		}
		
		CoolURLUtils.writeToFile(tmpUrl, value, getFileName(tmpUrl));
		return true;
	}
	
	private String getFileName(String fakeURL)
	{
		if (fakeURL.startsWith("\\u")){
			return "$u";
		}
		
		return fakeURL.substring(0, 1);
	}
}
