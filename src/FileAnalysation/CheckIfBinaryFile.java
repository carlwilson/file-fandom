package FileAnalysation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CheckIfBinaryFile {

	public static boolean checkbinary(File file) throws IOException {
		
		//inputs a file and outputs if the file is a binaryFile (true) or not (false), if it is an ASCII file

		BufferedReader fileReader = new BufferedReader(new FileReader(file));

		List<String> linesLog = new ArrayList<String>();
		FileReader input = new FileReader(file);
		BufferedReader buffRd = new BufferedReader(input);
		String str;

		while ((str = buffRd.readLine()) != null) {
			linesLog.add(str);
		}

		buffRd.close();

		int lineswithnonascii = 0;

		for (int j = 0; j < linesLog.size(); j++) {
			if (!(linesLog.get(j).matches("^\\p{ASCII}*$"))) {
				lineswithnonascii++;
			}
		}

		boolean binaryFile;

		if (lineswithnonascii == 0) {
			binaryFile = false;
		} else {
			binaryFile = true;
		}

		fileReader.close();

		return binaryFile;

	}

}
