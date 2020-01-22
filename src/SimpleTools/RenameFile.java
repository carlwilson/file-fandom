package SimpleTools;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Utilities.FileStringUtilities;

public class RenameFile {

	public static void main(String args[]) throws Exception {
		String folder;

		JOptionPane.showMessageDialog(null, "Please choose the folder with files to rename.", "Files Rename",
				JOptionPane.QUESTION_MESSAGE);
		folder = Utilities.BrowserDialogs.chooseFolder();

		ArrayList<File> files = Utilities.ListsFiles.getPaths(new File(folder), new ArrayList<File>());

		int serialno = 0;

		for (int i = 0; i < files.size(); i++) {

			String extension = (FileStringUtilities.getExtension(files.get(i)));
			extension = extension.toLowerCase();
			
			// nur eine laufende Nummer hinzufuegen

			serialno++;

			String filename = FileStringUtilities.getFileName(files.get(i));

			File filenew = new File(folder + "//" + filename + Integer.toString(serialno) + "." + extension);
			System.out.println(filenew.toString());
			files.get(i).renameTo(filenew);

		}

	}
}
