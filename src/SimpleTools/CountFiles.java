package SimpleTools;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

import Utilities.FileStringUtilities;

public class CountFiles {

	public static void main(String args[]) throws Exception {
		String folder;

		JOptionPane.showMessageDialog(null, "Please choose the folder with files to count.", "Files count",
				JOptionPane.QUESTION_MESSAGE);
		folder = Utilities.BrowserDialogs.chooseFolder();

		PrintWriter outputCsv = new PrintWriter(new FileWriter(folder + "\\list.csv"));

		ArrayList<File> files = Utilities.ListsFiles.getPaths(new File(folder), new ArrayList<File>());

		int findings = files.size();

		ArrayList<Long> fileSizePdf;
		ArrayList<Long> fileSizeMisc;
		fileSizePdf = new ArrayList<Long>();
		fileSizeMisc = new ArrayList<Long>();

		int jpeg = 0;
		int pdf = 0;
		int tiff = 0;
		int exe = 0;
		int bat = 0;
		int gif = 0;
		int html = 0;
		int serialno = 0;

		ArrayList<String> extensions = new ArrayList<String>();

		outputCsv.println("FileName ; JHOVE findings; JHOVE errormessages; Adobe XI can open; comments");

		for (int i = 0; i < files.size(); i++) {

			long size = files.get(i).length();
			size = size / 1024;

			fileSizeMisc.add(size);

			String extension = (FileStringUtilities.getExtension(files.get(i)));

			extension = extension.toLowerCase();

			extensions.add(extension);

			if (extension.equals("pdf")) {
				fileSizePdf.add(size);
				// System.out.println(files.get(i).toString());
				// outputCsv.println(files.get(i).toString());
				// System.out.println(size + " KB");
				pdf++;
			}

			if (extension.equals("jpg") || extension.equals("jpeg")) {
				jpeg++;
			}

			if (extension.equals("tif")) {
				tiff++;
			}
			
			if (extension.equals("html")) {
				html++;
			}

			if (extension.equals(("exe"))) {
				outputCsv.println(files.get(i).toString());
				exe++;
			}
			if (extension.equals(("bat"))) {
				outputCsv.println(files.get(i).toString());
				bat++;
			}

			if (extension.equals(("gif"))) {
				outputCsv.println(files.get(i).toString());
				gif++;
			}		
	}

		// sort and output all the extensions in the sample

		PrintWriter output = new PrintWriter(new FileWriter(folder + "\\extensions.txt"));

		Collections.sort(extensions);
		int i;

		// copy extensions because later the no. of entries of each
		// element will be counted

		ArrayList<String> originextensions = new ArrayList<String>();

		for (i = 0; i < extensions.size(); i++) { // There might be a
													// pre-defined
													// function for this
			originextensions.add(extensions.get(i));
		}

		// get rid of redundant entries
		i = 0;
		while (i < extensions.size() - 1) {
			if (extensions.get(i).equals(extensions.get(i + 1))) {
				extensions.remove(i);
			} else {
				i++;
			}
		}

		System.out.println("Sample consists of " + extensions.size() + " different extensions");

		// how often does each extension occur?
		int j = 0;
		int temp;

		for (i = 0; i < extensions.size(); i++) {
			temp = 0;
			for (j = 0; j < originextensions.size(); j++) {
				if (extensions.get(i).equals(originextensions.get(j))) {
					temp++;
				}
			}
			output.println((i + 1) + ": " + temp + " x " + extensions.get(i));
		}

		output.close();

		System.out.println(jpeg + " JPEG Files");
		System.out.println(pdf + " PDF Files");
		System.out.println(tiff + " TIFF Files");
		System.out.println(gif + " Gif Files");
		System.out.println(html + " HTML Files");

		long sizePdf = 0;

		for (i = 0; i < fileSizePdf.size(); i++) {
			sizePdf = sizePdf + fileSizePdf.get(i);
			// System.out.println(sizePdf + " KB");
		}

		System.out.println(sizePdf + " KB");
		if (pdf != 0) {
			System.out.println("Durchschnittliche Größe PDF Datei: " + sizePdf / pdf + " KB");
		}

		long sizeMisc = 0;

		for (i = 0; i < fileSizeMisc.size(); i++) {
			sizeMisc = sizeMisc + fileSizeMisc.get(i);
			// System.out.println(sizePdf + " KB");
		}

		System.out.println("Gesamter untersuchter Speicher " + sizeMisc + " KB");

		System.out.println("Durchschnittliche Größe einer Datei: " + sizeMisc / files.size() + " KB");

		// TODO: alle Elemente der ArrayList addieren und durch Anzahl der
		// Elemente teilen

		JOptionPane.showMessageDialog(null, findings, "Files", JOptionPane.INFORMATION_MESSAGE);

		System.out.println(findings);

		outputCsv.println("exe Dateien: " + exe);
		outputCsv.println("bat Dateien: " + bat);

		outputCsv.close();

	}
}

