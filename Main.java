import java.util.HashMap;
import java.util.Arrays;
import java.util.Scanner;


class Calculator {
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

    static String[] roman = {"I", "II", "III", "IV", "V","VI", "VII", "VIII", "IX", "X",
            "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
            "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
            "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XX",
            "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
            "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "L", "LIX", "LX",
            "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
            "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "XX",
            "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
            "XCI", "XCII", "XCIII", "XCIV", "XCV","XCVI", "XCVII", "XCVIII", "XCIX", "C"

    };

    public final static Integer toArabic(String roman) {
        // method converted roman number to arabic
        Integer arabic = map.get(roman);
        if (arabic == null) {
            throw new IllegalArgumentException();
        }

        return arabic;
    }

    public final static String toRoman(Integer arabic) {
        // method converted arabic number to roman
        if (arabic < 0 || arabic > 100) {
            throw new IllegalArgumentException();
        }
        return roman[arabic - 1];
    }

    public static Integer calculate(Integer a, Integer b, String operation) {
        Integer result;

        if (operation.equals("+")) {
            return a + b;
        } else if (operation.equals("-")) {
            return a - b;
        } else if (operation.equals("*")) {
            return a * b;
        } else if (operation.equals("/")) {
            return a / b;
        }
        throw new IllegalArgumentException();
    }


    public static String run(String input) {
        input = input.replaceAll(" ", "");
        String[] splitted = input.split("(?<=[-+*/])|(?=[-+*/])");

        if (splitted.length != 3) {
            throw new IllegalArgumentException();
        }
        if (splitted[0].contains("I") || splitted[0].contains("V") || splitted[0].contains("X") || splitted[0].contains("L") || splitted[0].contains("C")) {
            first_number = toArabic(splitted[0]);
            is_roman = true;
        } else {
            try {
                first_number = Integer.parseInt(splitted[0]);
            }
            catch (NumberFormatException e) {
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
            }
            catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }

        }

        if (first_number < 1 || first_number > 10 || second_number < 1 || second_number > 10) {
            throw new IllegalArgumentException();
        }

        operation = splitted[1];

        Integer result = calculate(first_number, second_number, operation);

        if (is_roman) {
           // if (result < 1 || result > 10) {
           if (result < 1) {
                throw new IllegalArgumentException();
            }
            return toRoman(result);
        }

        return result.toString();
    }
}


public class Main
{
    public static String calc(String input) {
        Calculator calculator = new Calculator();
        String result = calculator.run(input);

        return result;
    }
    ////////////
//	public static void main(String args[]) {
    // String input = System.console().readLine();
    // String result = calc(input);
    // System.out.println(result);
//	}
    /////////////
    public static void main(String args[]) {


        Scanner in = new Scanner(System.in);
        System.out.print("Введите выражение: ");

        String input = in.nextLine();

       // System.out.print("Введено выражение: ");
       // System.out.printf(input);

        String result = calc(input);

        System.out.print("Результат расчета: ");
        System.out.printf(result);

    }
}