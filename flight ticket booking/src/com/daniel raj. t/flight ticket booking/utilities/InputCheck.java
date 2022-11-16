package utilities;

public class InputCheck {
    public static boolean isNumber (String string) {
	boolean result = true;
	for(int i = 0; i < string.length(); i++) {
	    char ch = string.charAt(i);
	    if(!Character.isDigit(ch)) {
		result = false;
		break;
	    }
	}
	return result;
    }
    
    public static boolean isEnglishCharOrSpace (String string) {
	boolean result = true;
	for(int i = 0; i < string.length(); i++) {
	    char ch = string.charAt(i);
	    if(!(Character.isAlphabetic(ch) || ch == ' ' )) {
		result = false;
		break;
	    }
	}
	return result;
    }
    
}
