package SimpleTools;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import thredds.filesystem.FileSystemProto.File;

public class GetMD5 {

	public static void main(String args[]) throws FileNotFoundException, IOException {

		JOptionPane.showMessageDialog(null, "Please choose the folder with files to analyse.", "File Analysation",
				JOptionPane.QUESTION_MESSAGE);
		String folder = Utilities.BrowserDialogs.chooseFolder();

		ArrayList<File> files = Utilities.ListsFiles.getPaths(new File(), new ArrayList<File>());

		for (int i = 0; i < files.size(); i++) {

			String md5checksum = Utilities.GetMD5checksum(files.get(i));
						System.out.println(md5checksum);

		}

}
