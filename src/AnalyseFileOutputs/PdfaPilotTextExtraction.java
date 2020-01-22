package AnalyseFileOutputs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class PdfaPilotTextExtraction {

	public static void main(String args[]) throws IOException {

		String examinedFolder = Utilities.BrowserDialogs.chooseFolder ();
		PrintWriter outputTxt = new PrintWriter(new FileWriter(examinedFolder + "\\reportsAnalysis.txt"));

		ArrayList<File> files = Utilities.ListsFiles.getPaths(new File(examinedFolder), new ArrayList<File>());

		for (int i = 0; i < files.size(); i++) {

			String extension = Utilities.FileStringUtilities.getExtension(files.get(i).toString()).toLowerCase();

			if (extension.equals("log")) {
				
				System.out.println (files.get(i).toString());
				
				
				List<String> linesTxt = new ArrayList<String>();

				String filename = getFileName(files.get(i).toString());

				FileReader input = new FileReader(files.get(i).getPath());
				BufferedReader buffRd = new BufferedReader(input);
				String str;

				while ((str = buffRd.readLine()) != null) {
					linesTxt.add(str);
				}

				buffRd.close();

				for (int j = 0; j < linesTxt.size(); j++) {

					if ((linesTxt.get(j).contains("Errors")) /* ^ (!(linesTxt.get(j).contains("PDFA"))) */) {
						outputTxt.println(filename);
						outputTxt.println(linesTxt.get(j).replace("Hit	Error	", ""));
					}
				}
			}
		}

		outputTxt.close();

	}

	private static String getFileName(String string) {
		String filename;
		String[] parts = string.split(Pattern.quote("\\"));
		filename = parts[parts.length - 1]; // filename including extension

		return filename;
	}

}
