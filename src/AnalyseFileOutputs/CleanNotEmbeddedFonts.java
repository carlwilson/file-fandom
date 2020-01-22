package AnalyseFileOutputs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CleanNotEmbeddedFonts {

	public static void main(String args[]) throws IOException {

		String examinedFile = Utilities.BrowserDialogs.chooseFile();

		PrintWriter outputTxt = new PrintWriter(
				new FileWriter("C:\\Users\\tunnat yvonne\\Documents\\Preservation_Planning_Test_RosettaTest"
						+ "\\analyseNotEmbeddedFonts.txt"));

		outputTxt.println(examinedFile.toString());

		List<String> linesTxt = new ArrayList<String>();

		FileReader input = new FileReader(examinedFile);
		BufferedReader buffRd = new BufferedReader(input);
		String str;

		while ((str = buffRd.readLine()) != null) {
			linesTxt.add(str);
		}

		buffRd.close();

		List<String> missingFonts = new ArrayList<String>();

		for (int j = 0; j < linesTxt.size(); j++) {

			String[] parts = linesTxt.get(j).split(" not embedded ");

		//	outputTxt.println(parts[0]);

			missingFonts.add(parts[0]);
		}

		/*
		 * 
		 * for (int i = 0; i < missingFonts.size(); i++) { System.out.println
		 * (missingFonts.get(i)); }
		 * 
		 */

		Collections.sort(missingFonts);

		ArrayList<String> originfonts = new ArrayList<String>();

		int i;

		for (i = 0; i < missingFonts.size(); i++) { // There might be a
			// pre-defined
			// function for this
			originfonts.add(missingFonts.get(i));
		}

// get rid of redundant entries
		i = 0;
		while (i < missingFonts.size() - 1) {
			if (missingFonts.get(i).equals(missingFonts.get(i + 1))) {
				missingFonts.remove(i);
			} else {
				i++;
			}
		}
		
		outputTxt.println ("Fonts not embedded numbers: " + missingFonts.size());
		
		
		int j = 0;
		int temp;

		for (i = 0; i < missingFonts.size(); i++) {
			temp = 0;
			for (j = 0; j < originfonts.size(); j++) {
				if (missingFonts.get(i).equals(originfonts.get(j))) {
					temp++;
				}
			}
			outputTxt.println((i + 1) + ": " + temp + " x " + missingFonts.get(i));
		}
		
			
		outputTxt.println();
		outputTxt.println();
		
		
		outputTxt.println("Missing Font Types generic List:");
		outputTxt.println();
		
		
		List<String> genericFonts = new ArrayList<String>();
		
		for ( int n = 0; n < originfonts.size(); n++) {
			
			String[] tempparts = originfonts.get(n).split(" - ");
			tempparts = tempparts[0].split(" ");
				
			genericFonts.add (tempparts[1]);	
					
		}

		Collections.sort(genericFonts);
		
		ArrayList<String> origingenericFonts = new ArrayList<String>();

		for (i = 0; i < genericFonts.size(); i++) { // There might be a
			// pre-defined
			// function for this
			origingenericFonts.add(genericFonts.get(i));
		}

// get rid of redundant entries
		i = 0;
		while (i < genericFonts.size() - 1) {
			if (genericFonts.get(i).equals(genericFonts.get(i + 1))) {
				genericFonts.remove(i);
			} else {
				i++;
			}
		}
				outputTxt.println ("Fonts not embedded numbers: " + genericFonts.size());


		for (i = 0; i < genericFonts.size(); i++) {
			temp = 0;
			for (j = 0; j < origingenericFonts.size(); j++) {
				if (genericFonts.get(i).equals(origingenericFonts.get(j))) {
					temp++;
				}
			}
			outputTxt.println((i + 1) + ": " + temp + " x " + genericFonts.get(i));
		}
		

		outputTxt.close();
	}

}
