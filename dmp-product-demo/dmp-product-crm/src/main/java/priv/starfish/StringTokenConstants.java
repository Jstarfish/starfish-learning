package priv.starfish;

import com.google.common.base.Ascii;


public class StringTokenConstants {
	public static final String DELIMITER_SOH = new String(new byte[]{Ascii.SOH});
	public static final String DELIMITER_STX = new String(new byte[]{Ascii.STX});
	public static final String DELIMITER_COLON = ":";
	public static final String DELIMITER_COMMA = ",";
	public static final String DELIMITER_UNDERSCORES  = "_";
	public static final String DELIMITER_NULL = "\\N";
	public static final String DELIMITER_BLANK = " ";
	public static final String DELIMITER_TAB = "\t";
	public static final String DELIMITER_PLUS = "+";
	public static void main(String[] args) {
		System.out.println(DELIMITER_SOH);
	}
}
