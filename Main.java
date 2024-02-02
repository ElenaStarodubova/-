/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.HashMap;
import java.util.Arrays;

public class Main
{
    static boolean is_roman = false;
    static int first_number;
    static int second_number;
    static String operation;

    static HashMap<String, Integer> map = new HashMap<String, Integer>();

    static {
        map.put("I",    1);
        map.put("II",   2);
        map.put("III",  3);
        map.put("IV",   4);
        map.put("V",    5);
        map.put("VI",   6);
        map.put("VII",  7);
        map.put("VIII", 8);
        map.put("IX",   9);
        map.put("X",    10);
    }

    static String[] roman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

    public static Integer toArabic(String roman) {
        // method converted roman number to arabic
        Integer arabic = map.get(roman);
        if (arabic == null) {
            throw new IllegalArgumentException();
        }

        return arabic;
    }

    public static String toRoman(Integer arabic) {
        // method converted arabic number to roman
        if (arabic < 0 || arabic > 10) {
            throw new IllegalArgumentException();
        }
        return roman[arabic - 1];
    }

    public static Integer compute(Integer first_number, Integer second_number, String operation) {
        if (operation.equals("+")) {
            return first_number + second_number;
        } else if (operation.equals("-")) {
            return first_number - second_number;
        } else if (operation.equals("*")) {
            return first_number * second_number;
        } else if (operation.equals("/")) {
            return first_number / second_number;
        }
        throw new IllegalArgumentException();
    }


    public static String cacl(String input) {
        input = input.replaceAll(" ", "");
        String[] splitted = input.split("(?<=[-+*/])|(?=[-+*/])");

        if (splitted.length != 3) {
            throw new IllegalArgumentException();
        }
        if (splitted[0].contains("I") || splitted[0].contains("V") || splitted[0].contains("X")) {
            first_number = toArabic(splitted[0]);
            is_roman = true;
        } else {
            try {
                first_number = Integer.parseInt(splitted[0]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }
        if (splitted[2].contains("I") || splitted[2].contains("V") || splitted[2].contains("X")) {
            if (is_roman == false) {
                throw new IllegalArgumentException();
            }
            second_number = toArabic(splitted[2]);
        } else if (is_roman == true) {
            throw new IllegalArgumentException();
        } else {
            try {
                second_number = Integer.parseInt(splitted[2]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }

        }

        if (first_number < 1 || first_number > 10 || second_number < 1 || second_number > 10) {
            throw new IllegalArgumentException();
        }

        operation = splitted[1];

        Integer result = compute(first_number, second_number, operation);

        if (is_roman) {
            if (result < 1 || result > 10) {
                throw new IllegalArgumentException();
            }
            return toRoman(result);
        }

        return result.toString();
    }
	
	public static void main(String args[]) {
	    String input = "II * II";
        String result = cacl(input);
	    System.out.println(result);
	}
}
