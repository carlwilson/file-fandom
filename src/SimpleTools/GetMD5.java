package SimpleTools;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class GetMD5 {

	public static void main(String args[]) throws FileNotFoundException, IOException {

		JOptionPane.showMessageDialog(null, "Please choose the folder with files to analyse.", "File Analysation",
				JOptionPane.QUESTION_MESSAGE);
		String folder = Utilities.BrowserDialogs.chooseFolder();

		ArrayList<File> files = Utilities.ListsFiles.getPaths(new File(folder), new ArrayList<File>());

		for (File file : files) {

			String md5checksum = Utilities.GetMD5checksum.getChecksum(file);
						System.out.println(md5checksum);

		}
	}
}
