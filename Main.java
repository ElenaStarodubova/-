//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.main1();

    }

}

class Calculator {
    public static void main1() {

        Scanner in = new Scanner(System.in);
        System.out.print("Введите выражение: ");

        String input = in.nextLine();

        String[] strs = input.split("(?<=[-+*/])|(?=[-+*/])");

        String str1 = strs[0];
        String str2 = strs[1];
        String str3 = strs[2];


        if (str2.equals("-"))  {

            str3 = str3.replaceAll("[^a-zA-Z0-9]", "");
            String str = str1.replace(str3, "");
            str = str.replaceAll("[^a-zA-Z0-9]", "");
            System.out.println(str);

        }
        else if (str2.equals("+")) {
            String str = str1.concat(str3);
            str = str.replaceAll("[^a-zA-Z0-9]", "");
            System.out.println(str);
        }
    }
}
