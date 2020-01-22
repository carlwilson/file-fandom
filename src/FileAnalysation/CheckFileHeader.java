package FileAnalysation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;

public class CheckFileHeader {

	static String magicNumberGif87 = "GIF87a";
	static String magicNumberGif89 = "GIF89a";
	static String magicNumberPdf = "%PDF";
	static String magicNumberTiffIntel = "II";
	static String magicNumberTiffMotorola = "MM";
	static String magicNumberJpeg = "JFIF";
	static String magicNumberXml = "<?xml version="; // TODO: check if ok

	public static boolean testFileHeaderGif(String file) throws IOException {
		BufferedReader fileReader = new BufferedReader(new FileReader(file));
		String FileHeader = fileReader.readLine();

		fileReader.close();

		boolean isGiffile = false;

		if (FileHeader != null) {
			if ((FileHeader.contains(magicNumberGif89)) || (FileHeader.contains(magicNumberGif87))) {
				isGiffile = true;
			} else {
				isGiffile = false;
			}
		}

		return isGiffile;
	}

	public static boolean testFileHeaderPdf(String file) throws IOException {
		BufferedReader fileReader = new BufferedReader(new FileReader(file));
		String FileHeader = fileReader.readLine();

		fileReader.close();

		boolean isPdfFile = false;

		if (FileHeader != null) {
			if (FileHeader.contains(magicNumberPdf)) {
				isPdfFile = true;
			} else {
				isPdfFile = false;
			}
		}

		return isPdfFile;
	}

	public static boolean testFileHeaderTiff(String file) throws IOException {
		BufferedReader fileReader = new BufferedReader(new FileReader(file));
		String FileHeader = fileReader.readLine();

		fileReader.close();

		boolean isTiffFile = false;

		if (FileHeader != null) {
			if ((FileHeader.contains(magicNumberTiffIntel)) || (FileHeader.contains(magicNumberTiffMotorola))) {
				isTiffFile = true;
			} else {
				isTiffFile = false;
			}
		}
		return isTiffFile;

	}

	public static boolean testFileHeaderTiff(File file) throws IOException {
		BufferedReader fileReader = new BufferedReader(new FileReader(file));
		String FileHeader = fileReader.readLine();

		fileReader.close();

		boolean isTiffFile = false;

		if (FileHeader != null) {
			if ((FileHeader.contains(magicNumberTiffIntel)) || (FileHeader.contains(magicNumberTiffMotorola))) {
				isTiffFile = true;
			} else {
				isTiffFile = false;
			}
		}
		return isTiffFile;

	}

	public static boolean testFileHeaderGif(File file) throws IOException {
		BufferedReader fileReader = new BufferedReader(new FileReader(file));

		System.out.println(file.toString());

		// TODO: Das hier funktioniert noch nicht

/*		char[] chararray = { 'G', 'I', 'F', '8', '9', 'a' };
		StringBuffer sb = new StringBuffer();
		int ch;
		while ((ch = fileReader.read()) < chararray.length) {
			sb.append((char) ch);
		}
		System.out.println(sb.toString());*/

		String FileHeader = fileReader.readLine();
		
		fileReader.close();

		if (FileHeader != null) {
			if (FileHeader.contains(magicNumberGif87)) { //noch für 89 prüfen
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	

	public static boolean testFileHeaderJpeg(File file) throws IOException {
		BufferedReader fileReader = new BufferedReader(new FileReader(file));
		String FileHeader = fileReader.readLine();	
		
		fileReader.close();
		
			if (FileHeader != null) {
			if (FileHeader.contains(magicNumberJpeg)) {
				return true;
			} else {
				
				// return false;
				return true;
			}
		} else {
		//	return false;
			return true;
		}
	}




	public static boolean testFileHeaderXml(File file) throws IOException {
		BufferedReader fileReader = new BufferedReader(new FileReader(file));
		String FileHeader = fileReader.readLine();	
		
		fileReader.close();
		
			if (FileHeader != null) {
			if (FileHeader.contains(magicNumberXml)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public static int getPdfVersion(String pdffile) throws IOException {
		BufferedReader fileReader = new BufferedReader(new FileReader(pdffile));
		String fileHeader = fileReader.readLine();
		fileReader.close();

		if (fileHeader.contains("%PDF-1.2")) {
			return 2;
		} else if (fileHeader.contains("%PDF-1.3")) {
			return 3;
		} else if (fileHeader.contains("%PDF-1.4")) {
			return 4;
		} else if (fileHeader.contains("%PDF-1.5")) {
			return 5;
		} else if (fileHeader.contains("%PDF-1.6")) {
			return 6;
		} else if (fileHeader.contains("%PDF-1.7")) {
			return 7;
		} else {
			return 7; /* ist das so wirklich richtig?*/
		}
	}

	public static String getFileMimeType(File file) throws IOException {
		String extension = Files.probeContentType(file.toPath());
		return extension;
	}
}
