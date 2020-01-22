package Utilities;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class OutputFile {

	// Variablen bzw Attribute, Instanzvariablen
	String pathToFile;
	String extension;

//Methoden
	public static PrintWriter createOutputfile() throws IOException {

		JOptionPane.showMessageDialog(null, "Please choose folder for OutputFile", "Location Outputfile",
				JOptionPane.QUESTION_MESSAGE);
		String pathToFile = Utilities.BrowserDialogs.chooseFolder();

		Object[] options = { "txt", "xml", "json" };
		int inteingabe = JOptionPane.showOptionDialog(null, "Which flavour of OutputFile do you wish?", "Extension",
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[2]);

		String extension = null;

		switch (inteingabe) {
		case 0:
			extension = "txt";
			break;

		case 1:
			extension = "xml";
			break;

		case 2:
			extension = "json";
			break;
		}

		PrintWriter OutputFile = new PrintWriter(new FileWriter(pathToFile + "\\outputfile." + extension));

		return OutputFile;

	}

}
