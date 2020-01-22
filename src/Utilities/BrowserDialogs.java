package Utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class BrowserDialogs {

	public static String chooseFolder() throws FileNotFoundException {
		try {
			JFileChooser j = new JFileChooser();
			j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			j.showOpenDialog(j);
			if (j.getSelectedFile() == null) {
				JOptionPane.showMessageDialog(null, "No folder was chosen", "Info Message", JOptionPane.PLAIN_MESSAGE);
				return null;
			} else {
				String folder = j.getSelectedFile().getPath();
				return folder;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Most likely you tried to choose a folder like \"C:\" but you do not have the rights to read files there."
							+ e,
					"Info Message", JOptionPane.PLAIN_MESSAGE);
			return null;
		}
	}

	public static String chooseFile() throws FileNotFoundException {
		try {
			JFileChooser j = new JFileChooser();
			j.setFileSelectionMode(JFileChooser.FILES_ONLY);
			j.showOpenDialog(j);
			if (j.getSelectedFile() == null) {
				JOptionPane.showMessageDialog(null, "No file was chosen");
			} else {
				String file = j.getSelectedFile().getPath();
				return file;
			}
			return null;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Most likely you tried to choose a folder like \"C:\" but you do not have the rights to read files there."
							+ e,
					"Info Message", JOptionPane.PLAIN_MESSAGE);
			return null;
		}
	}

	public static String chooseFileOrFolder() throws FileNotFoundException {

		try {
			// JOptionPane.showMessageDialog(null, "Folder or File Browser Dialog", "Please
			// choose File Folder", JOptionPane.QUESTION_MESSAGE);
			JFileChooser j = new JFileChooser();
			j.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			j.showOpenDialog(j);
			if (j.getSelectedFile() == null) {
				JOptionPane.showMessageDialog(null, "No file or folder was chosen", "Info Message",
						JOptionPane.PLAIN_MESSAGE);
				return null;
			} else {
				String folder = j.getSelectedFile().getPath();
				return folder;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Most likely you tried to choose a folder like \"C:\" but you do not have the rights to read files there."
							+ e,
					"Info Message", JOptionPane.PLAIN_MESSAGE);
			return null;
		}
	}

	public static String createnewFolder() throws FileNotFoundException {
		try {
			String newfolder = null;
			String pathtonewfolder = null;
			String name = null;

			JOptionPane.showMessageDialog(null, "Please choose parent directory for the new folder",
					"Choose Parent Folder", JOptionPane.PLAIN_MESSAGE);

			String parentdirectory = chooseFolder();
			name = JOptionPane.showInputDialog(null, "Please choose name for the new folder", "Enter String Mask",
					JOptionPane.PLAIN_MESSAGE);

			pathtonewfolder = parentdirectory + "//" + name;

			File directory = new File(pathtonewfolder);
			if (directory.exists()) {
				JOptionPane.showMessageDialog(null, "This directory already exists and will not be created.", "Warning",
						JOptionPane.WARNING_MESSAGE);
			} else {
				directory.mkdirs();
			}

			newfolder = directory.toString();
			return newfolder;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.PLAIN_MESSAGE);
			return null;
		}
	}

	public static void createnewFolderfromString(String string) {
		// TODO Auto-generated method stub
		try {
			String folder = chooseFolder();

			String pathtonewfolder = folder + "//" + string;
			File directory = new File(pathtonewfolder);
			if (!directory.exists()) {
				directory.mkdirs();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.PLAIN_MESSAGE);

		}
	}

	public static void ziptofile(ZipEntry entry, ZipFile zf) throws IOException {

		byte[] buffer = new byte[0xFFFF];
		InputStream in = zf.getInputStream(entry);

		String extension = FileStringUtilities.getExtension(entry.toString()).toLowerCase();
		
		String folder = chooseFolder();
		String filename = "test";

		File newfile = new File(folder + "\\" + filename + "." + extension);
		OutputStream os = new FileOutputStream(newfile);
		for (int len; (len = in.read(buffer)) != -1;)
			os.write(buffer, 0, len);
		in.close();
		os.close();
	}

}
