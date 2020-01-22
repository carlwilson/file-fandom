package Utilities;

public class ReduceIllegalCharacters {
	
	public static String reduceXmlEscapors(String string) {
		string = string.replace("\"", "&quot;");
		string = string.replace("\'", "&apos;");
		string = string.replace("<", "&lt;");
		string = string.replace(">", "&gt;");
		string = string.replace("&", " &amp;");
		return string;
	}

	public static String reduceNULvalues(String string) {
		string = string.replace("\0", "");
		return string;
	}

	public static String reduceUnitSeparator(String string) {
		string = string.replace("^_", ""); // there might be more: Wikipedia, C0
											// and C1 control codes
		// this has yet to be tested
		return string;
	}

}
