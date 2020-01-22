package AnalyseFileOutputs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class PdfaPilotHtmlExtraction {

	public static void main(String args[]) throws IOException {

		String examinedFolder = Utilities.BrowserDialogs.chooseFolder();

		PrintWriter outputXml = new PrintWriter(new FileWriter(examinedFolder + "\\HtmlTextEctraction.xml"));
		PrintWriter nonEmbeddedFonts = new PrintWriter(new FileWriter(examinedFolder + "\\MissingFonts.txt"));
		PrintWriter otherErrors = new PrintWriter(new FileWriter(examinedFolder + "\\OtherErrors.txt"));

		String xmlVersion = "xml version='1.0'";
		String xmlEncoding = "encoding='ISO-8859-1'";
		outputXml.println("<?" + xmlVersion + " " + xmlEncoding + "?>");
		String xmlxslStyleSheet = "<?xml-stylesheet type=\"text/xsl\" href=\"HtmlFindings.xsl\"?>";
		outputXml.println(xmlxslStyleSheet);
		outputXml.println("<HtmlSummary>");

		if (examinedFolder != null) {

			ArrayList<String> allErrors = new ArrayList<String>();

			ArrayList<File> files = Utilities.ListsFiles.getPaths(new File(examinedFolder), new ArrayList<File>());
			if (files != null) {

				int failed = 0;
				int successful = 0;
				int fontproblems = 0;

				for (int i = 0; i < files.size(); i++) {

					String extension = Utilities.FileStringUtilities.getExtension(files.get(i).toString())
							.toLowerCase();

					if (extension.equals("html")) {
						outputXml.println("<Finding>");
						outputXml.println("<ID>" + (i + 1) + "</ID>");

						String filename = files.get(i).toString();

						outputXml.println("<Filename>" + filename + "</Filename>");
						List<String> linesHtml = new ArrayList<String>();

						FileReader input = new FileReader(files.get(i).getPath());
						BufferedReader buffRd = new BufferedReader(input);
						String str;
						StringBuffer buff = new StringBuffer();

						while ((str = buffRd.readLine()) != null) {
							linesHtml.add(str);
						}

						buffRd.close();

						for (int j = 0; j < linesHtml.size(); j++) {
							buff.append(linesHtml.get(j) + "\n");

							if (linesHtml.get(j).contains("class=block_problems_problemsdescription")) {
								outputXml.println("<Fehlermeldung>" + linesHtml.get(j + 1) + "</Fehlermeldung>");

								allErrors.add(linesHtml.get(j + 1)
										.replace("															", ""));
							}

							else if ((linesHtml.get(j).contains("not embedded"))
									&& (linesHtml.get(j - 1).contains("block_problems_description_details"))) {
								nonEmbeddedFonts.println(linesHtml.get(j)
										.replace("															", ""));
							}
						}

						String temp = new String();
						temp = buff.toString();

						if (temp.contains("successful")) {
							successful++;
							outputXml.println("<PdfAKonvertierung>" + "successful" + "</PdfAKonvertierung>");
						}

						if (temp.contains("failed")) {
							failed++;
							outputXml.println("<PdfAKonvertierung>" + "failed" + "</PdfAKonvertierung>");

							if (temp.contains("Font not embedded ")) {
								fontproblems++;
								outputXml.println("<FontProblems>" + "true" + "</FontProblems>");
							}

							/* falls verschoben werden soll */
							// files.get(i).renameTo(new File (examinedFolder +
							// "\\failed\\" + files.get(i).getName()));

						}

						else {
							// nothing happens
						}

						outputXml.println("</Finding>");
					}

				}

				outputXml.println("<Summary>");
				outputXml.println("<examined>" + (failed + successful) + "</examined>");
				outputXml.println("<failed>" + failed + "</failed>");
				outputXml.println("<FontProblems>" + fontproblems + "</FontProblems>");
				outputXml.println("<successful>" + successful + "</successful>");

				outputXml.println("</Summary>");
				nonEmbeddedFonts.close();

			}

			// allErrors bereinigen, auflisten und zählen

			Collections.sort(allErrors);

			for (int i = 0; i < allErrors.size(); i++) {

				if (allErrors.get(i).contains(" (")) {
					/*
					 * String parts[] = allErrors.get(i).split(" ("); cleanedErrors.add(parts[0]);
					 * otherErrors.println(parts[0]);
					 */
				}

				else
					otherErrors.println(allErrors.get(i));

			}

		}
		outputXml.println("</HtmlSummary>");
		outputXml.close();
		XmlXsltOutputs.HtmlCustomizedXsl(examinedFolder + "//" + "HtmlFindings" + ".xsl");

		otherErrors.close();

		// TODO: Stylesheet erstellen
	}

	public static String getHtmlFileName(File file) {
		String filename;
		String[] parts = file.toString().split(Pattern.quote("\\"));
		filename = parts[parts.length - 1]; // filename including extension

		String[] segs = filename.split(Pattern.quote("."));
		filename = segs[segs.length - 1];

		return filename;
	}

}
