package at.ernhofer.dezsys11_androidrestfulws;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Class which has Utility methods
 *
 */
public class Utility {
    private static Pattern pattern;
    private static Matcher matcher;
    //Email Pattern
    private static final String EMAIL_PATTERN = "/^((\"[\\w-\\s]+\")|([\\w-]+(?:\\.[\\w-]+)*)|(\"[\\w-\\s]+\")([\\w-]+(?:\\.[\\w-]+)*))(@((?:[\\w-]+\\.)*\\w[\\w-]"+
            "{0,66})\\.([a-z]{2,6}(?:\\.[a-z]{2})?)$)|(@\\[?((25[0-5]\\.|2[0-4][0-9]\\.|1[0-9]{2}\\.|[0-9]{1,2}\\.))((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\\.)"+
            "{2}(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\\]?$)/i";

    /**
     * Validate Email with regular expression
     *
     * @param email
     * @return true for Valid Email and false for Invalid Email
     */
    public static boolean validate(String email) {
        //pattern = Pattern.compile(EMAIL_PATTERN);
        //matcher = pattern.matcher(email);

        boolean retValue = true;

        int i = email.indexOf("@");
        int j = email.indexOf(".", i);

        if (i == 0)  // Anzahl der Zeichen vor dem @
        {
            retValue = false;
        }

        if (j == -1)  // Prüft ob kein Punkt nach dem @ Zeichen kommt
        {
            retValue = false;
        }

        if ((j - i) < 2)  // Prüft Anzahl der Zeichen zwischen dem @ und dem .
        {
            retValue = false;
        }

        if (j == (email.length() -1))  // Mail Adresse muss länger sein, als die Stelle vom Punkt
        {
            retValue = false;
        }

        return retValue;

        //return matcher.matches();

    }
    /**
     * Checks for Null String object
     *
     * @param txt
     * @return true for not null and false for null String object
     */
    public static boolean isNotNull(String txt){
        return txt!=null && txt.trim().length()>0 ? true: false;
    }
}