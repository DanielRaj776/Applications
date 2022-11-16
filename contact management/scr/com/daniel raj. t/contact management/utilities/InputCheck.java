package utilities;

public class InputCheck {
    public static boolean isNumber (String num) {
	if(num.length() == 0)
	    return false;
	char[] charArr = num.toCharArray();
	for(char ch : charArr) {
	    if(!(ch >= '0' && ch <= '9')) {
		return false;
	    }
	}
	return true;
    }
    public static boolean isEnglishCharacter (String words) {
	if(words.length() == 0)
	    return false;
	char[] charArr = words.toCharArray();
	for(char ch : charArr) {
	    if(!((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || ch == ' ')) {
		return false;
	    }
	}
	return true;
    }
}
