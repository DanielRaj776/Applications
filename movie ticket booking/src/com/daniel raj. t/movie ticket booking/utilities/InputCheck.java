package utilities;

public class InputCheck {
    public static boolean isNumber (String num) {
	
	if(num.length() == 0)
	    return false;
	char[] charArr = num.toCharArray();
	for(char ch : charArr) {
	    if(!(Character.isDigit(ch))) {
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
    public static boolean isDate (String fullDate) {
	if(!(fullDate.length() == 10))
	    return false;
	if(!(fullDate.charAt(4) == '-' && fullDate.charAt(7) == '-'))
	    return false;
	String yearString = fullDate.substring(0, 4);
	String monthString = fullDate.substring(5, 7);
	String dateString  = fullDate.substring(8, 10);
	if(!(isNumber(yearString) && isNumber(monthString) && isNumber(dateString)))
	    return false;
	int year = Integer.parseInt(yearString);
	int month = Integer.parseInt(monthString);
	int date = Integer.parseInt(dateString);
	boolean result = false;
	if(year >= 1970) {
	    if(month > 0 && month < 13) {
		if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
		    if(date > 0 && date <= 31)
			result = true;
		}else if(month == 4 || month == 6 || month == 9 || month == 11){
		    if(date > 0 && date <= 30)
			result = true;
		}else {
		    if(year % 4 == 0) {
			if(year % 100 == 0 && year % 400 == 0) {
			    if(date > 0 && date <= 29)
				result = true;
			}else if(year % 100 == 0) {
			    if(date > 0 && date <= 28)
				    result = true;
			}else {
			    if(date > 0 && date <= 29)
				result = true;
			}
		    }else {
			if(date > 0 && date <= 28)
			    result = true;
		    }
		}
	    }
	}
	return result;
    }
    public static boolean isTime (String time) {
	if(!(time.length() == 8))
	    return false;
	if(!(time.charAt(2) == ':' && time.charAt(5) == ':'))
	    return false;
	String hourString = time.substring(0, 2);
	String minuteString = time.substring(3, 5);	
	String secondString = time.substring(6, 8);
	if(!(isNumber(hourString) && isNumber(minuteString) && isNumber(secondString)))
	    return false;
	int hour = Integer.parseInt(hourString);
	int minute = Integer.parseInt(minuteString);
	int second = Integer.parseInt(secondString);
	if(hour > -1 && hour < 24) {
	    if(minute > -1 && minute < 60) {
		if(second > - 1 && second < 60) {
		    return true;
		}
	    }
	}
	return false;
    }
}
