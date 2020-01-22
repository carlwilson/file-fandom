package AnalyseFileOutputs;


	import java.io.FileWriter;
	import java.io.IOException;
	import java.io.PrintWriter;

	public class XmlXsltOutputs {

		public static void fileAnalysis(String xsltLocation) throws IOException {

			PrintWriter xslStyle = new PrintWriter(new FileWriter(xsltLocation));

			xslStyle.println("<?xml version=\"1.0\"?>");
			xslStyle.println("<xsl:stylesheet version=\"1.0\" xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\">");
			xslStyle.println("<xsl:template match=\"/\">");
			xslStyle.println("<html>");
			xslStyle.println("<head>");
			xslStyle.println("<style>");
			xslStyle.println("tr.captiondred {background-color: #FF0000}");
			xslStyle.println("tr.captionred {background-color: #CD5C5C}");
			xslStyle.println("tr.captiongreen {background-color: #006400}");
			xslStyle.println("tr.captiontan {background-color: #FFDEAD}");
			xslStyle.println("tr.captionkhaki {background-color: #BDB76B}");
			xslStyle.println("tr.captionolive {background-color: #808000}");
			xslStyle.println("tr.captionwheat {background-color: #F5DEB3}");
			xslStyle.println("</style>");
			xslStyle.println("</head>");
			xslStyle.println("<body>");

			xslStyle.println("<h2>Overview Analyzed Files</h2>");

			xslStyle.println("<table border =\"1\">");
			xslStyle.println("<tr class=\"captionolive\">");
			xslStyle.println("<th> FileName</th> ");
			// xslStyle.println("<th> MD5Checksum</th>");
			xslStyle.println("<th> FileSizeKB</th>");
			xslStyle.println("<th> Mimetype</th>");
			xslStyle.println("<th> FileExtension</th>");
			xslStyle.println("<th> PdfEncryption</th>");
			xslStyle.println("<th> PDF Version</th>");
			xslStyle.println("<th> PDF Type</th>");
			xslStyle.println("<th> Pdf Creation Software</th>");
			xslStyle.println("<th> Creation Year</th>");
			xslStyle.println("</tr>");
			xslStyle.println("<xsl:for-each select=\"FileAnalysisSummary/File\">");
			xslStyle.println("<xsl:sort select=\"CreationYear\" />");
			xslStyle.println("<tr class=\"captionolive\">");
			//
			xslStyle.println("<td><xsl:value-of select=\"FileName\"/></td>");
			// xslStyle.println("<td><xsl:value-of select=\"MD5Checksum\"/></td>");
			xslStyle.println("<td><xsl:value-of select=\"FileSizeKB\"/></td>");
			xslStyle.println("<td><xsl:value-of select=\"Mimetype\"/></td>");
			xslStyle.println("<td><xsl:value-of select=\"FileExtension\"/></td>");
			xslStyle.println("<td><xsl:value-of select=\"PdfEncryption\"/></td>");
			xslStyle.println("<td><xsl:value-of select=\"PdfVersion\"/></td>");
			xslStyle.println("<td><xsl:value-of select=\"PdfA\"/></td>");
			xslStyle.println("<td><xsl:value-of select=\"PdfCreationSoftware\"/></td>");
			xslStyle.println("<td><xsl:value-of select=\"CreationYear\"/></td>");
			xslStyle.println("</tr>");
			xslStyle.println("</xsl:for-each>");
			xslStyle.println("</table>");
			xslStyle.println("</body>");
			xslStyle.println("</html>");
			xslStyle.println("</xsl:template>");
			xslStyle.println("</xsl:stylesheet>");

			xslStyle.close();

		}

		public static void pdfAnalysis(String xsltLocation) throws IOException {

			PrintWriter xslStyle = new PrintWriter(new FileWriter(xsltLocation));
			xslStyle.println("<?xml version=\"1.0\"?>");
			xslStyle.println("<xsl:stylesheet version=\"1.0\" xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\">");
			xslStyle.println("<xsl:template match=\"/\">");
			xslStyle.println("<html>");
			xslStyle.println("<head>");
			xslStyle.println("<style>");
			xslStyle.println("tr.captiondred {background-color: #FF0000}");
			xslStyle.println("tr.captionred {background-color: #CD5C5C}");
			xslStyle.println("tr.captiongreen {background-color: #006400}");
			xslStyle.println("tr.captiontan {background-color: #FFDEAD}");
			xslStyle.println("tr.captionkhaki {background-color: #BDB76B}");
			xslStyle.println("tr.captionolive {background-color: #808000}");
			xslStyle.println("tr.captionwheat {background-color: #F5DEB3}");
			xslStyle.println("</style>");
			xslStyle.println("</head>");
			xslStyle.println("<body>");

			xslStyle.println("<h2>Pdf Analysis</h2>");
			xslStyle.println("<table border =\"1\">");
			xslStyle.println("<tr class=\"captiontan\">");
			xslStyle.println("<th>ID</th>");
			xslStyle.println("<th>Name</th>");
			xslStyle.println("<th>MD5</th>");
			xslStyle.println("<th>Encrypted</th>");
			xslStyle.println("<th>PdfA</th>");
			xslStyle.println("</tr>");
			xslStyle.println("<xsl:for-each select=\"PdfAnalysis/Pdf\">");

			xslStyle.println("<tr class=\"captiontan\">");
			xslStyle.println("<td><xsl:value-of select=\"ObjectId\"/></td>");
			xslStyle.println("<td><xsl:value-of select=\"FileName\"/></td>");
			xslStyle.println("<td><xsl:value-of select=\"MD5Checksum\"/></td>");
			xslStyle.println("<td><xsl:value-of select=\"PdfEncrypted\"/></td>");
			xslStyle.println("<td><xsl:value-of select=\"PdfA\"/></td>");
			xslStyle.println("</tr>");
			xslStyle.println("</xsl:for-each>");
			xslStyle.println("</table>");

			xslStyle.println("</body>");
			xslStyle.println("</html>");
			xslStyle.println("</xsl:template>");
			xslStyle.println("</xsl:stylesheet>");

			xslStyle.close();

		}

		public static void PdfBoxSummaryCustomizedXsl(String xsltLocation) throws IOException {

			PrintWriter xslStyle = new PrintWriter(new FileWriter(xsltLocation));

			xslStyle.println("<?xml version=\"1.0\"?>");
			xslStyle.println("<xsl:stylesheet version=\"1.0\" xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\">");
			xslStyle.println("<xsl:template match=\"/\">");
			xslStyle.println("<html>");
			xslStyle.println("<head>");
			xslStyle.println("<style>");
			xslStyle.println("tr.captiondred {background-color: #FF0000}");
			xslStyle.println("tr.captionred {background-color: #CD5C5C}");
			xslStyle.println("tr.captiongreen {background-color: #006400}");
			xslStyle.println("tr.captiontan {background-color: #FFDEAD}");
			xslStyle.println("tr.captionkhaki {background-color: #BDB76B}");
			xslStyle.println("tr.captionolive {background-color: #808000}");
			xslStyle.println("tr.captionwheat {background-color: #F5DEB3}");
			xslStyle.println("</style>");
			xslStyle.println("</head>");
			xslStyle.println("<body>");

			xslStyle.println("<h2>PDF/A Validation with PDFBox Short Summary</h2>");
			xslStyle.println("<table border =\"1\">");
			xslStyle.println("<tr class=\"captiontan\">");
			xslStyle.println("<th>FileName</th>");
			xslStyle.println("<th>Creation Year</th>");
			xslStyle.println("<th>Creation Software</th>");
			xslStyle.println("<th>Status</th>");
			xslStyle.println("<th>ErrorsCount</th>");
			xslStyle.println("</tr>");
			xslStyle.println("<xsl:for-each select=\"PdfBoxValidationSummary/PdfAFile\">");
			xslStyle.println("<xsl:sort select=\"Status\" />");
			xslStyle.println("<xsl:if test=\"Status[contains(text(),'Valid')]\">");
			xslStyle.println("<tr class=\"captiongreen\">");
			xslStyle.println("<td><i><xsl:value-of select=\"FileName\"/></i></td>");
			xslStyle.println("<td><xsl:value-of select=\"CreationYear\"/></td>");
			xslStyle.println("<td><xsl:value-of select=\"CreationSoftware\"/></td>");
			xslStyle.println("<td><xsl:value-of select=\"Status\"/></td>");
			xslStyle.println("<td><xsl:value-of select=\"ErrorsCount\"/></td>");
			xslStyle.println("</tr>");
			xslStyle.println("</xsl:if>	");
			xslStyle.println("<xsl:if test=\"Status[contains(text(),'Invalid')]\">");
			xslStyle.println("<tr class=\"captionred\">");
			xslStyle.println("<td><i><xsl:value-of select=\"FileName\"/></i></td>");
			xslStyle.println("<td><xsl:value-of select=\"CreationYear\"/></td>");
			xslStyle.println("<td><xsl:value-of select=\"CreationSoftware\"/></td>");
			xslStyle.println("<td><xsl:value-of select=\"Status\"/></td>");
			xslStyle.println("<td><xsl:value-of select=\"ErrorsCount\"/></td>");
			xslStyle.println("</tr>");
			xslStyle.println("</xsl:if>		");
			xslStyle.println("</xsl:for-each>");
			xslStyle.println("</table>");

			xslStyle.println("<h2>Examined PDF/A Files</h2>");
			xslStyle.println("<table border =\"1\">");
			xslStyle.println("<tr class=\"captiontan\">");
			xslStyle.println("<th>Examined PDF/A</th>");
			xslStyle.println("<th>Valid</th>");
			xslStyle.println("<th>Invalid</th>");
			xslStyle.println("<th>Broken</th>");
			xslStyle.println("</tr>");
			xslStyle.println("<xsl:for-each select=\"PdfBoxValidationSummary/Summary\">");

			xslStyle.println("<tr class=\"captiontan\">");
			xslStyle.println("<td><xsl:value-of select=\"ExaminedPdfAFiles\"/></td>");
			xslStyle.println("<td><xsl:value-of select=\"ValidPdfAFiles\"/></td>");
			xslStyle.println("<td><xsl:value-of select=\"InvalidPdfAFiles\"/></td>");
			xslStyle.println("<td><xsl:value-of select=\"CausedErrorPdfAFiles\"/></td>");
			xslStyle.println("</tr>");
			xslStyle.println("</xsl:for-each>");
			xslStyle.println("</table>");

			xslStyle.println("</body>");
			xslStyle.println("</html>");
			xslStyle.println("</xsl:template>");
			xslStyle.println("</xsl:stylesheet>");

			xslStyle.close();

		}

		public static void PdfBoxCustomizedXsl(String xsltLocation) throws IOException {

			PrintWriter xslStyle = new PrintWriter(new FileWriter(xsltLocation));

			xslStyle.println("<?xml version=\"1.0\"?>");
			xslStyle.println("<xsl:stylesheet version=\"1.0\" xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\">");
			xslStyle.println("<xsl:template match=\"/\">");
			xslStyle.println("<html>");
			xslStyle.println("<head>");
			xslStyle.println("<style>");
			xslStyle.println("tr.captiondred {background-color: #FF0000}");
			xslStyle.println("tr.captionred {background-color: #CD5C5C}");
			xslStyle.println("tr.captiongreen {background-color: #006400}");
			xslStyle.println("tr.captiontan {background-color: #FFDEAD}");
			xslStyle.println("tr.captionkhaki {background-color: #BDB76B}");
			xslStyle.println("tr.captionolive {background-color: #808000}");
			xslStyle.println("tr.captionwheat {background-color: #F5DEB3}");
			xslStyle.println("</style>");
			xslStyle.println("</head>");
			xslStyle.println("<body>");

			xslStyle.println("<h2>Overview on invalid PDF/A Files</h2>");
			xslStyle.println("<table border =\"1\">");
			xslStyle.println("<tr class=\"captiontan\">");
			xslStyle.println("<th>FileName</th>");
			xslStyle.println("<th>Creation Year</th>");
			xslStyle.println("<th>Creation Software</th>");
			xslStyle.println("<th>Syntax Errors</th>");
			xslStyle.println("<th>Graphic Errors</th>");
			xslStyle.println("<th>Font Errors</th>");
			xslStyle.println("<th>Transparency Errors</th>");
			xslStyle.println("<th>Annotation Errors</th>");
			xslStyle.println("<th>Action Errors</th>");
			xslStyle.println("<th>Metadata Errors</th>");
			xslStyle.println("<th>Runtime Errors</th>");

			xslStyle.println("</tr>");
			xslStyle.println("<xsl:for-each select=\"PdfBoxValidation/PdfAFile\">");
			xslStyle.println("<tr class=\"captionred\">");
			xslStyle.println("<td><i><xsl:value-of select=\"FileName\"/></i></td>");
			xslStyle.println("<td><xsl:value-of select=\"CreationYear\"/></td>");
			xslStyle.println("<td><xsl:value-of select=\"CreationSoftware\"/></td>");
			xslStyle.println("<td><xsl:value-of select=\"SyntaxErrors\"/></td>");
			xslStyle.println("<td><xsl:value-of select=\"GraphicErrors\"/></td>");
			xslStyle.println("<td><xsl:value-of select=\"FontErrors\"/></td>");
			xslStyle.println("<td><xsl:value-of select=\"TransparencyErrors\"/></td>");
			xslStyle.println("<td><xsl:value-of select=\"AnnotationErrors\"/></td>");
			xslStyle.println("<td><xsl:value-of select=\"ActionErrors\"/></td>");
			xslStyle.println("<td><xsl:value-of select=\"MetadataErrors\"/></td>");
			xslStyle.println("<td><xsl:value-of select=\"RuntimeErrors\"/></td>");
			xslStyle.println("</tr>");
			xslStyle.println("</xsl:for-each>");
			xslStyle.println("</table>");

			xslStyle.println("</body>");
			xslStyle.println("</html>");
			xslStyle.println("</xsl:template>");
			xslStyle.println("</xsl:stylesheet>");

			xslStyle.close();

		}

		public static void TextSucheCustomizedXsl(String xsltLocation) throws IOException {

			PrintWriter xslStyle = new PrintWriter(new FileWriter(xsltLocation));

			xslStyle.println("<?xml version=\"1.0\"?>");
			xslStyle.println("<xsl:stylesheet version=\"1.0\" xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\">");
			xslStyle.println("<xsl:template match=\"/\">");
			xslStyle.println("<html>");
			xslStyle.println("<head>");
			xslStyle.println("<style>");
			xslStyle.println("tr.captiondred {background-color: #FF0000}");
			xslStyle.println("tr.captionred {background-color: #CD5C5C}");
			xslStyle.println("tr.captiongreen {background-color: #006400}");
			xslStyle.println("tr.captiontan {background-color: #FFDEAD}");
			xslStyle.println("tr.captionkhaki {background-color: #BDB76B}");
			xslStyle.println("tr.captionolive {background-color: #808000}");
			xslStyle.println("tr.captionwheat {background-color: #F5DEB3}");
			xslStyle.println("</style>");
			xslStyle.println("</head>");
			xslStyle.println("<body>");

			xslStyle.println("<h2>Textsuche</h2>");
			xslStyle.println("<table border =\"1\">");
			xslStyle.println("<tr class=\"captiontan\">");
			xslStyle.println("<th>Durchsuchter Ordner oder Datei</th>");
			xslStyle.println("<th>Art der Suche</th>");
			xslStyle.println("<th>Anzahl Dateien im Suchordner</th>");
			xslStyle.println("<th>Gesuchter Text</th>");
			xslStyle.println("<th>Text in durchsuchtem Ordner/Datei gefunden</th>");

			xslStyle.println("</tr>");
			xslStyle.println("<xsl:for-each select=\"Textsuche\">");
			xslStyle.println("<tr class=\"captiontan\">");
			xslStyle.println("<td><xsl:value-of select=\"Durchsucht\"/></td>");
			xslStyle.println("<td><xsl:value-of select=\"Art\"/></td>");
			xslStyle.println("<td><xsl:value-of select=\"AnzahlDateien\"/></td>");
			xslStyle.println("<td><xsl:value-of select=\"GesuchterText\"/></td>");
			xslStyle.println("<td><xsl:value-of select=\"OccuranceSearchedTest\"/></td>");
			xslStyle.println("</tr>");
			xslStyle.println("</xsl:for-each>");
			xslStyle.println("</table>");

			xslStyle.println("<h2>Durchsuchte Dateien</h2>");
			xslStyle.println("<table border =\"1\">");
			xslStyle.println("<tr class=\"captiontan\">");
			xslStyle.println("<th>Dateiname</th>");
			xslStyle.println("<th>Gesuchten Text gefunden</th>");
			xslStyle.println("</tr>");
			xslStyle.println("<xsl:for-each select=\"Textsuche/Datei\">");

			xslStyle.println("<xsl:sort select=\"Suchergebnis\" />");
			xslStyle.println("<tr class=\"captiontan\">");
			xslStyle.println("<td><xsl:value-of select=\"Dateiname\"/></td>");
			xslStyle.println("<td><xsl:value-of select=\"Suchergebnis\"/></td>");
			xslStyle.println("</tr>");
			xslStyle.println("</xsl:for-each>");
			xslStyle.println("</table>");

			xslStyle.println("</body>");
			xslStyle.println("</html>");
			xslStyle.println("</xsl:template>");
			xslStyle.println("</xsl:stylesheet>");

			xslStyle.close();

		}

		
		public static void PdfMetadataCustomizedXsl(String xsltLocation) throws IOException {

			PrintWriter xslStyle = new PrintWriter(new FileWriter(xsltLocation));

			xslStyle.println("<?xml version=\"1.0\"?>");
			xslStyle.println("<xsl:stylesheet version=\"1.0\" xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\">");
			xslStyle.println("<xsl:template match=\"/\">");
			xslStyle.println("<html>");
			xslStyle.println("<head>");
			xslStyle.println("<style>");
			xslStyle.println("tr.captiondred {background-color: #FF0000}");
			xslStyle.println("tr.captionred {background-color: #CD5C5C}");
			xslStyle.println("tr.captiongreen {background-color: #006400}");
			xslStyle.println("tr.captiontan {background-color: #FFDEAD}");
			xslStyle.println("tr.captionkhaki {background-color: #BDB76B}");
			xslStyle.println("tr.captionolive {background-color: #808000}");
			xslStyle.println("tr.captionwheat {background-color: #F5DEB3}");
			xslStyle.println("</style>");
			xslStyle.println("</head>");
			xslStyle.println("<body>");

			xslStyle.println("<h2>Pdf Metadata Extraction</h2>");
			xslStyle.println("<table border =\"1\">");
			xslStyle.println("<tr class=\"captiontan\">");
			xslStyle.println("<th>File Name</th> ");
			/* xslStyle.println("<th>No. of Metadata Entries</th> "); */
			xslStyle.println("<th>Year of Creation</th> ");
			xslStyle.println("<th>Pdf Version</th> ");	
			xslStyle.println("<th>Title</th> ");
			xslStyle.println("<th>Author</th> ");
			/*
			 * xslStyle.println("<th>Creation Date</th> "); xslStyle.println(
			 * "<th>Modification Date</th> ");
			 */
			/*
			 * xslStyle.println("<th>Title</th> "); xslStyle.println(
			 * "<th>Author</th> ");
			 */
			xslStyle.println("<th>Software</th> ");
			xslStyle.println("</tr>");
			xslStyle.println("<xsl:for-each select=\"PdfMetadata/File\">");
			xslStyle.println("<xsl:sort select=\"CreationYear\" />");
			xslStyle.println("<tr class=\"captiontan\">");
			xslStyle.println("<td><xsl:value-of select=\"FileName\"/></td>");
			/*
			 * xslStyle.println(
			 * "<td><xsl:value-of select=\"MetadataEntries\"/></td>" );
			 */
			xslStyle.println("<td><xsl:value-of select=\"CreationYear\"/></td>");
			xslStyle.println("<td><xsl:value-of select=\"PdfVersion\"/></td>");
			/*
			 * xslStyle.println("<td><xsl:value-of select=\"CreationDate\"/></td>");
			 * xslStyle .println(
			 * "<td><xsl:value-of select=\"ModificationDate\"/></td>");
			 */
			/*
			
			 */
			xslStyle.println("<td><xsl:value-of select=\"Title\"/></td>");
			xslStyle.println("<td><xsl:value-of select=\"Author\"/></td>");
			xslStyle.println("<td><xsl:value-of select=\"Producer\"/></td>");

			xslStyle.println("</tr>");
			xslStyle.println("</xsl:for-each>");
			xslStyle.println("</table>");

			xslStyle.println("</body>");
			xslStyle.println("</html>");
			xslStyle.println("</xsl:template>");
			xslStyle.println("</xsl:stylesheet>");

			xslStyle.close();

		}

		public static void PdfTwinTestXsl(String xsltLocation) throws IOException {

			PrintWriter xslStyle = new PrintWriter(new FileWriter(xsltLocation));

			xslStyle.println("<?xml version=\"1.0\"?>");
			xslStyle.println("<xsl:stylesheet version=\"1.0\" xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\">");
			xslStyle.println("<xsl:template match=\"/\">");
			xslStyle.println("<html>");
			xslStyle.println("<head>");
			xslStyle.println("<style>");
			xslStyle.println("tr.captiondred {background-color: #FF0000}");
			xslStyle.println("tr.captionred {background-color: #CD5C5C}");
			xslStyle.println("tr.captiongreen {background-color: #006400}");
			xslStyle.println("tr.captiontan {background-color: #FFDEAD}");
			xslStyle.println("tr.captionkhaki {background-color: #BDB76B}");
			xslStyle.println("tr.captionolive {background-color: #808000}");
			xslStyle.println("tr.captionwheat {background-color: #F5DEB3}");
			xslStyle.println("</style>");
			xslStyle.println("</head>");
			xslStyle.println("<body>");

			xslStyle.println("<h2>Compared PDF Files</h2>");
			xslStyle.println("<table border =\"1\">");
			xslStyle.println("<tr class=\"captionkhaki\">");
			xslStyle.println("<th>Original File</th>");
			xslStyle.println("<th>Number of Lines Original</th>");
			xslStyle.println("<th>Migrated File</th>");
			xslStyle.println("<th>Number of Lines Original Migration</th>");
			xslStyle.println("<th>PDF Twins</th>");
			xslStyle.println("<th>Different Lines</th>");
			xslStyle.println("<th>Levenshtein Distance Full PDF</th>");
			xslStyle.println("<th>Line Irregulaties (lines shifting etc.)</th>");
			xslStyle.println("</tr>");
			xslStyle.println("<xsl:for-each select=\"PdfTwinTest/ComparedItem\">");
			xslStyle.println("<tr class=\"captionwheat\">");
			xslStyle.println("<td><xsl:value-of select=\"FileOrg\"/></td>");
			xslStyle.println("<td><xsl:value-of select=\"LinesLengthOrg\"/></td>");
			xslStyle.println("<td><xsl:value-of select=\"FileMig\"/></td>");
			xslStyle.println("<td><xsl:value-of select=\"LinesLengthMig\"/></td>");
			xslStyle.println("<td><xsl:value-of select=\"PdfTwins\"/></td>");
			xslStyle.println("<td><xsl:value-of select=\"DifferentLines\"/></td>");
			xslStyle.println("<td><xsl:value-of select=\"LevenshteinPdf\"/></td>");
			xslStyle.println("<td><xsl:value-of select=\"LineIrregularities\"/></td>");
			xslStyle.println("</tr>");
			xslStyle.println("</xsl:for-each>");
			xslStyle.println("</table>");

			xslStyle.println("<h2>Found differences in PDF Files</h2>");
			xslStyle.println("<table border =\"1\">");
			xslStyle.println("<tr class=\"captionkhaki\">");
			xslStyle.println("<th>Difference in Line Number</th>");
			xslStyle.println("<th>Original Line</th>");
			xslStyle.println("<th>Migrated Line</th>");
			xslStyle.println("<th>Different Word (Original)</th>"); // TODO: could
																	// be more than
																	// one
			xslStyle.println("<th>Different Word (Migration)</th>");
			xslStyle.println("<th>Levenshtein Distance</th>");
			xslStyle.println("</tr>");
			xslStyle.println("<xsl:for-each select=\"PdfTwinTest/Details\">");
			xslStyle.println("<tr class=\"captionwheat\">");
			xslStyle.println("<td><xsl:value-of select=\"DifferentLineNumber\"/></td>");
			xslStyle.println("<td><xsl:value-of select=\"OriginalLine\"/></td>");
			xslStyle.println("<td><xsl:value-of select=\"MigrationLine\"/></td>");
			xslStyle.println("<td><xsl:value-of select=\"DifferentWordOrg\"/></td>");
			xslStyle.println("<td><xsl:value-of select=\"DifferentWordMig\"/></td>");
			xslStyle.println("<td><xsl:value-of select=\"LevenshteinDistance\"/></td>");
			xslStyle.println("</tr>");
			xslStyle.println("</xsl:for-each>");
			xslStyle.println("</table>");

			xslStyle.println("</body>");
			xslStyle.println("</html>");
			xslStyle.println("</xsl:template>");
			xslStyle.println("</xsl:stylesheet>");

			xslStyle.close();

		}

		public static void PdfEncryptionXsl(String xsltLocation) {
			// TODO Auto-generated method stub

		}

		public static void veraPdfXsl(String xsltLocation) throws IOException {

			PrintWriter xslStyle = new PrintWriter(new FileWriter(xsltLocation));

			// TODO: customize veraPDF XSLT

			xslStyle.println("<?xml version=\"1.0\"?>");
			xslStyle.println("<xsl:stylesheet version=\"1.0\" xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\">");
			xslStyle.println("<xsl:template match=\"/\">");
			xslStyle.println("<html>");
			xslStyle.println("<head>");
			xslStyle.println("<style>");
			xslStyle.println("tr.captiondred {background-color: #FF0000}");
			xslStyle.println("tr.captionred {background-color: #CD5C5C}");
			xslStyle.println("tr.captiongreen {background-color: #006400}");
			xslStyle.println("tr.captiontan {background-color: #FFDEAD}");
			xslStyle.println("tr.captionkhaki {background-color: #BDB76B}");
			xslStyle.println("tr.captionolive {background-color: #808000}");
			xslStyle.println("tr.captionwheat {background-color: #F5DEB3}");
			xslStyle.println("</style>");
			xslStyle.println("</head>");
			xslStyle.println("<body>");

			xslStyle.println("<h2>Summary of veraPDF Examination</h2>");

			xslStyle.println("<table border =\"1\">");
			xslStyle.println("<tr class=\"captionolive\">");
			xslStyle.println("<th>Failed</th> ");
			xslStyle.println("<th>Valid</th>");
			xslStyle.println("</tr>");
			xslStyle.println("<xsl:for-each select=\"veraPDFSummary/PdfAValidity\">");
			xslStyle.println("<tr class=\"captionolive\">");
			xslStyle.println("<td><xsl:value-of select=\"Fail\"/></td>");
			xslStyle.println("<td><xsl:value-of select=\"Pass\"/></td>");
			xslStyle.println("</tr>");
			xslStyle.println("</xsl:for-each>");
			xslStyle.println("</table>");

			xslStyle.println("<h2>Detailed Findings</h2>");

			xslStyle.println("<table border=\"1\">");
			xslStyle.println("<tr class=\"captiontan\">	");
			xslStyle.println("<th>Examined PDF File</th>");
			xslStyle.println("<th>Findings</th>");
			xslStyle.println("</tr> ");
			xslStyle.println("<xsl:for-each select=\"veraPDFSummary/item\">  ");
			xslStyle.println("<tr class=\"captiontan\">	");
			xslStyle.println("<td><xsl:value-of select=\"Filename\" />	</td>");
			xslStyle.println("<td><xsl:value-of select=\"veraPDFExamination\" /></td>");
			xslStyle.println("</tr>");
			xslStyle.println("</xsl:for-each>");
			xslStyle.println("</table>");

			xslStyle.println("</body>");
			xslStyle.println("</html>");
			xslStyle.println("</xsl:template>");
			xslStyle.println("</xsl:stylesheet>");

			xslStyle.close();

		}

		public static void HtmlCustomizedXsl(String xsltLocation) throws IOException {

			PrintWriter xslStyle = new PrintWriter(new FileWriter(xsltLocation));

			xslStyle.println("<?xml version=\"1.0\"?>");
			xslStyle.println("<xsl:stylesheet version=\"1.0\" xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\">");
			xslStyle.println("<xsl:template match=\"/\">");
			xslStyle.println("<html>");
			xslStyle.println("<head>");
			xslStyle.println("<style>");
			xslStyle.println("tr.captiondred {background-color: #FF0000}");
			xslStyle.println("tr.captionred {background-color: #CD5C5C}");
			xslStyle.println("tr.captiongreen {background-color: #006400}");
			xslStyle.println("tr.captiontan {background-color: #FFDEAD}");
			xslStyle.println("tr.captionkhaki {background-color: #BDB76B}");
			xslStyle.println("tr.captionolive {background-color: #808000}");
			xslStyle.println("tr.captionwheat {background-color: #F5DEB3}");
			xslStyle.println("</style>");
			xslStyle.println("</head>");
			xslStyle.println("<body>");

			xslStyle.println("<h2>Summary of Callas Conversion Quote</h2>");

			xslStyle.println("<table border=\"1\">");
			xslStyle.println("<tr class=\"captiontan\">	");
			xslStyle.println("<th>Examined PDF Files</th>");
			xslStyle.println("<th>Failed</th>");
			xslStyle.println("<th>Successful</th>");
			xslStyle.println("<th>FontProblem</th>");
			xslStyle.println("</tr> ");
			xslStyle.println("<xsl:for-each select=\"HtmlSummary/Summary\">  ");
			xslStyle.println("<tr class=\"captiontan\">	");
			xslStyle.println("<xsl:value-of select=\"examined\" />");
			xslStyle.println("<td><xsl:value-of select=\"failed\" /></td>");
			xslStyle.println("<td><xsl:value-of select=\"successful\" />	</td>");
			xslStyle.println("<td><xsl:value-of select=\"FontProblems\" />	</td>");
			xslStyle.println("</tr>");
			xslStyle.println("</xsl:for-each>");
			xslStyle.println("</table>");

			xslStyle.println("<h2>Callas Findings</h2>");

			xslStyle.println("<table border =\"1\">");
			xslStyle.println("<tr class=\"captionolive\">");
			xslStyle.println("<th>ID</th> ");
			xslStyle.println("<th>Filename</th>");
			xslStyle.println("<th>Callas Conversion</th>");
			xslStyle.println("<th>FontProblems</th>");
			xslStyle.println("</tr>");
			xslStyle.println("<xsl:for-each select=\"HtmlSummary/Finding\">");
			xslStyle.println("<tr class=\"captionolive\">");
			xslStyle.println("<td><xsl:value-of select=\"ID\"/></td>");
			xslStyle.println("<td><xsl:value-of select=\"Filename\"/></td>");
			xslStyle.println("<td><xsl:value-of select=\"PdfAKonvertierung\"/></td>");
			xslStyle.println("<td><xsl:value-of select=\"FontProblems\"/></td>");
			xslStyle.println("</tr>");
			xslStyle.println("</xsl:for-each>");
			xslStyle.println("</table>");

			xslStyle.println("</body>");
			xslStyle.println("</html>");
			xslStyle.println("</xsl:template>");
			xslStyle.println("</xsl:stylesheet>");

			xslStyle.close();

		}

		public static void imageMagickXsl(String xsltLocation) throws IOException {
			PrintWriter xslStyle = new PrintWriter(new FileWriter(xsltLocation));

			xslStyle.println("<?xml version=\"1.0\"?>");
			xslStyle.println("<xsl:stylesheet version=\"1.0\" xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\">");
			xslStyle.println("<xsl:template match=\"/\">");
			xslStyle.println("<html>");
			xslStyle.println("<head>");
			xslStyle.println("<style>");
			xslStyle.println("tr.captiondred {background-color: #FF0000}");
			xslStyle.println("tr.captionred {background-color: #CD5C5C}");
			xslStyle.println("tr.captiongreen {background-color: #006400}");
			xslStyle.println("tr.captiontan {background-color: #FFDEAD}");
			xslStyle.println("tr.captionkhaki {background-color: #BDB76B}");
			xslStyle.println("tr.captionolive {background-color: #808000}");
			xslStyle.println("tr.captionwheat {background-color: #F5DEB3}");
			xslStyle.println("</style>");
			xslStyle.println("</head>");
			xslStyle.println("<body>");

			xslStyle.println("<h2>Summary of imageMagick TIFF Examination</h2>");

			xslStyle.println("<table border =\"1\">");
			xslStyle.println("<tr class=\"captionolive\">");
			xslStyle.println("<th>Files analysed</th> ");
			xslStyle.println("<th>corrupt</th>");
			xslStyle.println("</tr>");
			xslStyle.println("<xsl:for-each select=\"imageMagickSummary/Summary\">");
			xslStyle.println("<tr class=\"captionolive\">");
			xslStyle.println("<td><xsl:value-of select=\"analysedTiff\"/></td>");
			xslStyle.println("<td><xsl:value-of select=\"corruptTiff\"/></td>");
			xslStyle.println("</tr>");
			xslStyle.println("</xsl:for-each>");
			xslStyle.println("</table>");

			xslStyle.println("<h2>All Messages in Sample</h2>");

			xslStyle.println("<table border =\"1\">");
			xslStyle.println("<tr class=\"captionolive\">");
			xslStyle.println("<th>Error Messages</th> ");
			xslStyle.println("<th>Occurance in Sample</th>");
			xslStyle.println("</tr>");
			xslStyle.println("<xsl:for-each select=\"imageMagickSummary/AllMessages/Message\">");
			xslStyle.println("<tr class=\"captionolive\">");
			xslStyle.println("<td><xsl:value-of select=\"MessageText\"/></td>");
			xslStyle.println("<td><xsl:value-of select=\"Occurance\"/></td>");
			xslStyle.println("</tr>");
			xslStyle.println("</xsl:for-each>");
			xslStyle.println("</table>");

			xslStyle.println("<h2>Detailed Findings</h2>");

			xslStyle.println("<table border=\"1\">");
			xslStyle.println("<tr class=\"captiontan\">	");
			xslStyle.println("<th>Number</th>");
			xslStyle.println("<th>Examined TIFF File</th>");
			xslStyle.println("<th>valid</th>");
			xslStyle.println("</tr> ");
			xslStyle.println("<xsl:for-each select=\"imageMagickSummary/FileAnalysis/File\">  ");

			xslStyle.println("<xsl:if test=\"valid[contains(text(),'false')]\">");
			xslStyle.println("<tr class=\"captionred\">");
			xslStyle.println("<td><xsl:value-of select=\"Number\" />	</td>");
			xslStyle.println("<td><xsl:value-of select=\"Filename\" />	</td>");
			xslStyle.println("<td><xsl:value-of select=\"valid\" /></td>");
			xslStyle.println("</tr>");
			xslStyle.println("</xsl:if>	");

			xslStyle.println("<xsl:if test=\"valid[contains(text(),'true')]\">");
			xslStyle.println("<tr class=\"captiongreen\">");
			xslStyle.println("<td><xsl:value-of select=\"Number\" />	</td>");
			xslStyle.println("<td><xsl:value-of select=\"Filename\" />	</td>");
			xslStyle.println("<td><xsl:value-of select=\"valid\" /></td>");
			xslStyle.println("</tr>");
			xslStyle.println("</xsl:if>	");

			xslStyle.println("</xsl:for-each>");
			xslStyle.println("</table>");

			xslStyle.println("</body>");
			xslStyle.println("</html>");
			xslStyle.println("</xsl:template>");
			xslStyle.println("</xsl:stylesheet>");

			xslStyle.close();
		}

		public static void fileFormatAnalysis(String xsltLocation) throws IOException {
			PrintWriter xslStyle = new PrintWriter(new FileWriter(xsltLocation));

			xslStyle.println("<?xml version=\"1.0\"?>");
			xslStyle.println("<xsl:stylesheet version=\"1.0\" xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\">");
			xslStyle.println("<xsl:template match=\"/\">");
			xslStyle.println("<html>");
			xslStyle.println("<head>");
			xslStyle.println("<style>");
			xslStyle.println("tr.captiondred {background-color: #FF0000}");
			xslStyle.println("tr.captionred {background-color: #CD5C5C}");
			xslStyle.println("tr.captiongreen {background-color: #006400}");
			xslStyle.println("tr.captiontan {background-color: #FFDEAD}");
			xslStyle.println("tr.captionkhaki {background-color: #BDB76B}");
			xslStyle.println("tr.captionolive {background-color: #808000}");
			xslStyle.println("tr.captionwheat {background-color: #F5DEB3}");
			xslStyle.println("</style>");
			xslStyle.println("</head>");
			xslStyle.println("<body>");

			xslStyle.println("<h2>Summary File Format Occurances</h2>");

			xslStyle.println("<table border =\"1\">");
			xslStyle.println("<tr class=\"captionolive\">");
			xslStyle.println("<th>Files Analysed</th> ");
			xslStyle.println("<th>Different Formats Siegfried (Pronom)</th>");
			xslStyle.println("<th>Different Formats TRId</th>");
			xslStyle.println("<th>Different Formats File Utility</th>");
			xslStyle.println("</tr>");
			xslStyle.println("<xsl:for-each select=\"FileFormatAnalysis/Summary/Statistics\">");

			xslStyle.println("<tr class=\"captionolive\">");
			xslStyle.println("<td><xsl:value-of select=\"AllFiles\"/></td>");
			xslStyle.println("<td><xsl:value-of select=\"FormatsPronom\"/></td>");
			xslStyle.println("<td><xsl:value-of select=\"FormatsTrid\"/></td>");
			xslStyle.println("<td><xsl:value-of select=\"FormatsFile\"/></td>");
			xslStyle.println("</tr>");
			xslStyle.println("</xsl:for-each>");
			xslStyle.println("</table>");

			xslStyle.println("<h3>Summary Siegfried Pronom</h3>");

			xslStyle.println("<table border =\"1\">");
			xslStyle.println("<tr class=\"captionolive\">");
			xslStyle.println("<th>FileFormat</th> ");
			xslStyle.println("<th>Occurance</th>");
			xslStyle.println("</tr>");
			xslStyle.println("<xsl:for-each select=\"FileFormatAnalysis/Summary/PronomFormatFinding/item\">");
			xslStyle.println("<xsl:sort select=\"Occurance\" />");
			xslStyle.println("<tr class=\"captionolive\">");
			xslStyle.println("<td><xsl:value-of select=\"MessageText\"/></td>");
			xslStyle.println("<td><xsl:value-of select=\"Occurance\"/></td>");
			xslStyle.println("</tr>");
			xslStyle.println("</xsl:for-each>");
			xslStyle.println("</table>");

			xslStyle.println("<h3>Summary TRId</h3>");

			xslStyle.println("<table border =\"1\">");
			xslStyle.println("<tr class=\"captionolive\">");
			xslStyle.println("<th>FileFormat</th> ");
			xslStyle.println("<th>Occurance</th>");
			xslStyle.println("</tr>");
			xslStyle.println("<xsl:for-each select=\"FileFormatAnalysis/Summary/TridFormatFinding/item\">");
			xslStyle.println("<xsl:sort select=\"Occurance\" />");
			xslStyle.println("<tr class=\"captionolive\">");
			xslStyle.println("<td><xsl:value-of select=\"MessageText\"/></td>");
			xslStyle.println("<td><xsl:value-of select=\"Occurance\"/></td>");
			xslStyle.println("</tr>");
			xslStyle.println("</xsl:for-each>");
			xslStyle.println("</table>");

			xslStyle.println("<h3>File Utility</h3>");

			xslStyle.println("<table border =\"1\">");
			xslStyle.println("<tr class=\"captionolive\">");
			xslStyle.println("<th>FileFormat</th> ");
			xslStyle.println("<th>Occurance</th>");
			xslStyle.println("</tr>");
			xslStyle.println("<xsl:for-each select=\"FileFormatAnalysis/Summary/FileFormatFinding/item\">");
			xslStyle.println("<xsl:sort select=\"Occurance\" />");
			xslStyle.println("<tr class=\"captionolive\">");
			xslStyle.println("<td><xsl:value-of select=\"MessageText\"/></td>");
			xslStyle.println("<td><xsl:value-of select=\"Occurance\"/></td>");
			xslStyle.println("</tr>");
			xslStyle.println("</xsl:for-each>");
			xslStyle.println("</table>");

			xslStyle.println("<h2>Overview Analyzed Files</h2>");

			xslStyle.println("<table border =\"1\">");
			xslStyle.println("<tr class=\"captionolive\">");
			xslStyle.println("<th> FileName</th> ");
			xslStyle.println("<th> PronomFindings</th>");
			xslStyle.println("<th> TRIdFindings</th>");
			xslStyle.println("<th> FileUtilityFindings</th>");
			xslStyle.println("</tr>");
			xslStyle.println("<xsl:for-each select=\"FileFormatAnalysis/File\">");

			xslStyle.println("<tr class=\"captionolive\">");
			xslStyle.println("<td><xsl:value-of select=\"FileName\"/></td>");
			xslStyle.println("<td><xsl:value-of select=\"PronomMeaning\"/></td>");
			xslStyle.println("<td><xsl:value-of select=\"Trid\"/></td>");
			xslStyle.println("<td><xsl:value-of select=\"FileUtility\"/></td>");
			xslStyle.println("</tr>");
			xslStyle.println("</xsl:for-each>");
			xslStyle.println("</table>");
			xslStyle.println("</body>");
			xslStyle.println("</html>");
			xslStyle.println("</xsl:template>");
			xslStyle.println("</xsl:stylesheet>");

			xslStyle.close();

		}

		public static void fileFormatAnalysisFits(String xsltLocation) throws IOException {
			PrintWriter xslStyle = new PrintWriter(new FileWriter(xsltLocation));

			xslStyle.println("<?xml version=\"1.0\"?>");
			xslStyle.println("<xsl:stylesheet version=\"1.0\" xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\">");
			xslStyle.println("<xsl:template match=\"/\">");
			xslStyle.println("<html>");
			xslStyle.println("<head>");
			xslStyle.println("<style>");
			xslStyle.println("tr.captiondred {background-color: #FF0000}");
			xslStyle.println("tr.captionred {background-color: #CD5C5C}");
			xslStyle.println("tr.captiongreen {background-color: #006400}");
			xslStyle.println("tr.captiontan {background-color: #FFDEAD}");
			xslStyle.println("tr.captionkhaki {background-color: #BDB76B}");
			xslStyle.println("tr.captionolive {background-color: #808000}");
			xslStyle.println("tr.captionwheat {background-color: #F5DEB3}");
			xslStyle.println("</style>");
			xslStyle.println("</head>");
			xslStyle.println("<body>");

			xslStyle.println("<h2>Summary File Format Occurances</h2>");

			xslStyle.println("<table border =\"1\">");
			xslStyle.println("<tr class=\"captionolive\">");
			xslStyle.println("<th>Files Analysed</th> ");
			xslStyle.println("<th>Different Formats Siegfried (Pronom)</th>");
			xslStyle.println("</tr>");
			xslStyle.println("<xsl:for-each select=\"FileFormatAnalysis/Summary\">");

			xslStyle.println("<tr class=\"captionolive\">");
			xslStyle.println("<td><xsl:value-of select=\"AllFiles\"/></td>");
			xslStyle.println("<td><xsl:value-of select=\"FormatsPronom\"/></td>");
			xslStyle.println("</tr>");
			xslStyle.println("</xsl:for-each>");
			xslStyle.println("</table>");

			xslStyle.println("<h3>Summary DROID Pronom</h3>");

			xslStyle.println("<table border =\"1\">");
			xslStyle.println("<tr class=\"captionolive\">");
			xslStyle.println("<th>FileFormat</th> ");
			xslStyle.println("<th>Occurance</th>");
			xslStyle.println("</tr>");
			xslStyle.println("<xsl:for-each select=\"FileFormatAnalysis/Summary/PronomFormatFinding/item\">");
			xslStyle.println("<xsl:sort select=\"Occurance\" />");
			xslStyle.println("<tr class=\"captionolive\">");
			xslStyle.println("<td><xsl:value-of select=\"MessageText\"/></td>");
			xslStyle.println("<td><xsl:value-of select=\"Occurance\"/></td>");
			xslStyle.println("</tr>");
			xslStyle.println("</xsl:for-each>");
			xslStyle.println("</table>");

			xslStyle.println("<h2>Overview Analyzed Files</h2>");

			xslStyle.println("<table border =\"1\">");
			xslStyle.println("<tr class=\"captionolive\">");
			xslStyle.println("<th> FileName</th> ");
			xslStyle.println("<th> PronomFindings</th>");
			xslStyle.println("</tr>");
			xslStyle.println("<xsl:for-each select=\"FileFormatAnalysis/File\">");

			xslStyle.println("<tr class=\"captionolive\">");
			xslStyle.println("<td><xsl:value-of select=\"FileName\"/></td>");
			xslStyle.println("<td><xsl:value-of select=\"PronomMeaning\"/></td>");
			xslStyle.println("</tr>");
			xslStyle.println("</xsl:for-each>");
			xslStyle.println("</table>");
			xslStyle.println("</body>");
			xslStyle.println("</html>");
			xslStyle.println("</xsl:template>");
			xslStyle.println("</xsl:stylesheet>");

			xslStyle.close();

		}
	}

