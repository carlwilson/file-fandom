package JhoveValidations;

import java.awt.BorderLayout;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;

import edu.harvard.hul.ois.jhove.App;
import edu.harvard.hul.ois.jhove.JhoveBase;
import edu.harvard.hul.ois.jhove.OutputHandler;
import edu.harvard.hul.ois.jhove.handler.XmlHandler;
import edu.harvard.hul.ois.jhove.module.PdfModule;
import edu.harvard.hul.ois.jhove.module.TiffModule;

public class ValidatePdf {
	static PdfModule modul;
	static TiffModule tmodul;
	static OutputHandler handler;
	public static String folder;
	static PrintWriter writer;

	public static void JhovePdfValidator() {

		String pathwriter;

		try {
			folder = JhoveGuiStarterDialog.jhoveExaminationFolder;
			if (folder != null) {

				JFrame f = new JFrame();
				JButton but = new JButton("... Program is running ... ");
				f.add(but, BorderLayout.PAGE_END);
				f.pack();
				f.setVisible(true);

				JhoveBase jb = new JhoveBase();

				String configFilePath = JhoveBase.getConfigFileFromProperties();
				jb.init(configFilePath, null);

				jb.setEncoding("UTF-8");// UTF-8 does not calculate checksums,
										// which saves time
				jb.setBufferSize(131072);
				jb.setChecksumFlag(false);
				jb.setShowRawFlag(false);
				jb.setSignatureFlag(false);

				String appName = "Customized JHOVE";
				String version = "1.0";

				int[] date = Utilities.GenericUtilities.getDate();
				String usage = "Call JHOVE via own Java";
				String rights = "Copyright nestor Format Working Group";
				App app = new App(appName, version, date, usage, rights);

				PdfModule module = new PdfModule(); // JHOVE PdfModule only

				OutputHandler handler = new XmlHandler();
				ArrayList<File> files = Utilities.ListsFiles.getPaths(new File(folder), new ArrayList<File>());

				pathwriter = (folder + "//" + "JhoveExamination.xml");

				writer = new PrintWriter(new FileWriter(pathwriter));
				handler.setWriter(writer);
				handler.setBase(jb);
				module.init("");
				module.setDefaultParams(new ArrayList<String>());

				String xmlVersion = "xml version='1.0'";
				String xmlEncoding = "encoding='ISO-8859-1'";

				writer.println("<?" + xmlVersion + " " + xmlEncoding + "?>");
				writer.println("<JhoveFindings>");

				// To handle one file after the other
				for (File file : files) {
					boolean encrypted = false;
					if (Utilities.GenericFileAnalysis.testFileHeaderPdf(file) == true) { // tests
																									// only
																									// PDF
																									// with
																									// Header
																									// %PDF
						writer.println("<item>");

						String substitute = Utilities.FileStringUtilities
								.getFileNameFromString(file.toString());
						substitute = Utilities.ReduceIllegalCharacters.reduceXmlEscapors(substitute);
						writer.println("<filename>" + substitute + "</filename>");

						PDDocument pd = new PDDocument();
						pd = PDDocument.load(file);

						if (pd.isEncrypted()) {
							encrypted = true;
							writer.println("<encryption>" + true + "</encryption>");
							writer.println("<PdfType>" + "encrypted PDF" + "</PdfType>");
						}
						
						pd.close();

//						else {
//							
//						String pdfType = filetools.pdf.PdfAnalysis.checkIfPdfA(files.get(i));							
//							writer.println("<PdfType>" + pdfType + "</PdfType>");	
//							writer.println("<encryption>" + false + "</encryption>");
//							
//						}

						PDDocumentInformation info = pd.getDocumentInformation();
						addSomeMetadata(info);
						pd.close();

						jb.process(app, module, handler, file.toString());
						writer.println("</item>");
					}

					// does not work because the process blocks the PDF file and therefore the PDF
					// cannot be moved
//
//					if (encrypted == true) {
//
//						System.out.println("Is encrypted:" + files.get(i).toString());
//
//						Path moveSourcePath = Paths.get(files.get(i).toString());
//						String fileName = utilities.fileStringUtilities.getFileName(files.get(i).toString());
//						Path moveTargetPath = Paths
//								.get("C://Users//Friese Yvonne//Desktop//PDF_Sample_Callas//LZA-Test-PDF//encrypted//"
//										+ fileName);
//
//						Files.move(moveSourcePath, moveTargetPath);
//					}
				}
				writer.println("</JhoveFindings>");
				writer.close();
				// output.XmlParserJhove.parseXmlFile(pathwriter);

				f.dispose();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e, "error message", JOptionPane.ERROR_MESSAGE);

		}
	}

	private static void addSomeMetadata(PDDocumentInformation info) throws IOException {
		try {
			Calendar creationYear = info.getCreationDate();

			Date creationYearDate = creationYear.getTime();

			int len = creationYearDate.toString().length();
			String year = creationYearDate.toString().substring(len - 4, len);
			// String creationSoftware =
			// Utilities.FileStringUtilities.reduceXmlEscapors(info.getProducer());

			writer.println("<creationyear>" + year + "</creationyear>");
//			writer.println("<creationsoftware>" + creationSoftware + "</creationsoftware>");
		}

		catch (Exception e) {
			writer.println("<creationyear>" + "</creationyear>");
			writer.println("<creationsoftware>" + "</creationsoftware>");
		}
	}
}
