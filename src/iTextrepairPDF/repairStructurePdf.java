package iTextrepairPDF;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;

public class repairStructurePdf {
	
	static String examinedFolder;

	public static void main(String args[]) throws IOException, DocumentException {

		examinedFolder = Utilities.BrowserDialogs.chooseFolder();

		if (examinedFolder != null) {

			ArrayList<File> files = Utilities.ListsFiles.getPaths(new File(examinedFolder), new ArrayList<File>());
			if (files == null)
				return;
			String mimetype;
			PdfReader reader;

			for (int i = 0; i < files.size(); i++) {
				mimetype = FileAnalysation.CheckFileHeader.getFileMimeType(files.get(i));
				if (mimetype != null) {
					if (mimetype.equals("application/pdf")) {
						try {
							reader = new PdfReader(files.get(i).toString());
							if (!reader.isEncrypted()) { // TODO: crashes if
															// encrypted PDF
								repairWithItext(reader, files.get(i));
							}
						} catch (Exception e) {
							System.out.println(files.get(i).toString() + e);
						}
					}
				}
			}
		}
		/*
		 * } catch (FileNotFoundException e) {
		 * JOptionPane.showMessageDialog(null, e, "error message",
		 * JOptionPane.ERROR_MESSAGE); }
		 */

	}

	/**
	 * Makes a copy from each PDF-file in the folder and puts it in the same
	 * folder with the prefix"Mig_iText"
	 * 
	 * @param takes
	 *            in PdfReader and the filename as a string
	 * @return: void
	 * 
	 */

	static void repairWithItext(PdfReader reader, File filename) throws DocumentException, IOException {

		Map<String, String> info = reader.getInfo();
		Document document = new Document();

		String filenameStr = filename.getName();

		PdfCopy copy = new PdfCopy(document, new FileOutputStream(examinedFolder + "//" + "Mig_iText" + filenameStr));

		int pdfVersion = FileAnalysation.CheckFileHeader.getPdfVersion(filename.toString());

		//ist aber trotzdem PDF 1.4 leider
		copy.setPdfVersion(PdfWriter.PDF_VERSION_1_3);

		// TODO: there is a way to get all the metadata as described in one of
		// Bruno's books
		if (info.get("Title") != null)
			document.addTitle((String) info.get("Title"));
		if (info.get("Author") != null)
			document.addAuthor((String) info.get("Author"));
		if (info.get("Keywords") != null)
			document.addKeywords((String) info.get("Keywords"));
		// TODO: Is this the right Keyword?
		if (info.get("Date") != null)
			document.addKeywords((String) info.get("Date"));
		copy.createXmpMetadata();
		document.open();
		int n = reader.getNumberOfPages();
		for (int i = 0; i < n;) {
			copy.addPage(copy.getImportedPage(reader, ++i));
		}
		copy.freeReader(reader);
		document.close();
	}



}
