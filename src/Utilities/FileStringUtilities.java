package Utilities;

import java.io.File;
import java.util.regex.Pattern;

public class FileStringUtilities {
	
	public static String getExtension(File file) {
		String[] segs = file.toString().split(Pattern.quote("."));
		return segs[segs.length - 1];
	}
	
	public static String getExtension(String filename) {
		String[] segs = filename.split(Pattern.quote("."));
		return segs[segs.length - 1];
	}

	public static String getFileName(File file) {
		String filename;
		String[] parts = file.toString().split(Pattern.quote("\\"));
		filename = parts[parts.length - 1]; // filename including extension

		String[] segs = filename.split(Pattern.quote("."));
		filename = segs[segs.length - 2];

		return filename;
	}
	
	public static String getFileNameFromString(String file) {
		String filename;
		String[] parts = file.split(Pattern.quote("\\"));
		filename = parts[parts.length - 1]; // filename including extension

		String[] segs = filename.split(Pattern.quote("."));
		filename = segs[segs.length - 2];

		return filename;
	}

	
	public static String getFileNameFromStringWithExtension(String string) {
		String filename;
		String[] parts = string.split(Pattern.quote("\\"));
		filename = parts[parts.length - 1]; // filename including extension

		return filename;
	}
	

}
