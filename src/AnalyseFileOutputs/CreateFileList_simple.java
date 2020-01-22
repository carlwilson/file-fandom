package AnalyseFileOutputs;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CreateFileList_simple {

	static String examinedFolder;

	public static void main(String args[]) throws Exception {

		examinedFolder = Utilities.BrowserDialogs.chooseFolder();

		PrintWriter OutputFile = Utilities.OutputFile.createOutputfile();

		if (examinedFolder != null) {

			ArrayList<File> allfiles = Utilities.ListsFiles.getPaths(new File(examinedFolder), new ArrayList<File>());

			for (int i = 0; i < allfiles.size(); i++) {

				System.out.println(allfiles.get(i).toString());
				OutputFile.println(allfiles.get(i).toString());
				
			String md5Checksum = Utilities.GetMD5checksum.getChecksum(allfiles.get(i));
			
				
			System.out.println (md5Checksum);
				
			}

			OutputFile.close();
		}
	}
}
