package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.codec.digest.DigestUtils; //wird erst nach java path eintragen funktionieren

public class GetMD5checksum {

	public static String getChecksum(File file) throws FileNotFoundException, IOException {
	
		String checksum = DigestUtils.md5Hex(new FileInputStream(file));
				
		return checksum;
	}

}
