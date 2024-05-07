import java.util.Scanner;
//07.05.24
public class Main
{
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.main1();
    }

}


////////////////////////////////////////////////////////////////////////
class Calculator {

    public static void main1() {

        Scanner in = new Scanner(System.in);
        System.out.print("Введите выражение:");

        String input = in.nextLine();


        ///////////////////////////////////////////////////////////////////
        String[] arrSplit = input.split("\"");




        if (arrSplit[2].equals("+") | arrSplit[2].equals("-")) {
            if (arrSplit[2].equals("+")) {
                if (arrSplit[1].length() > 10|arrSplit[3].length() > 10){
                    System.out.println( "Вы ввели некорректный пример, попробуйте еще раз");
                    throw new IllegalArgumentException();
                } else {
                    String arrSplitrez = arrSplit[1].concat(arrSplit[3]);
                    System.out.print("Результат: ");
                    System.out.println("\""+arrSplitrez+"\"");

                }
            }
            if (arrSplit[2].equals("-"))  {
                if (arrSplit[1].length() > 10|arrSplit[3].length() > 10){
                    System.out.println( "Вы ввели некорректный пример, попробуйте еще раз");
                    throw new IllegalArgumentException();
                } else {
                    String arrSplitrez = arrSplit[1].replace(arrSplit[3], "");
                    System.out.print("Результат: ");
                    System.out.println("\""+arrSplitrez+"\"");

                }
            }
        }

        //////////////////////////////////////////////////////////////////////////
        String arrSplit1 = input.replaceAll("\"", "");
        String[] arrSplit2 = arrSplit1.split("(?<=[\\-+/*])|(?=[\\-+/*])");
        if (arrSplit2[1].equals("*") | arrSplit2[1].equals("/")) if(arrSplit2[1].equals("/")) {
            arrSplit2[0] = arrSplit2[0].replaceAll("[^a-zA-Z0-9]", "");

        }
        if (arrSplit2[1].equals("*")) {
            String strNum = arrSplit2[2];
            int numStr = Integer.parseInt(strNum);
            if (arrSplit2[0].length() > 10|numStr>10|numStr<0) {
                System.out.println( "Вы ввели некорректный пример, попробуйте еще раз");
                throw new IllegalArgumentException();
            }
            else   {
                String veriti = arrSplit2[0].repeat(numStr);
                if (veriti.length() < 40|veriti.length() == 40){
                    System.out.print("Результат: ");

                    System.out.println("\""+veriti+"\"");


                }
                if (veriti.length() > 40){
                    String orgRez = veriti.length() > 40 ? veriti.substring(0, 40) : veriti;
                    System.out.print("Результат: ");
                    System.out.println("\""+orgRez+"...\"");
                }

            }         }

        if (arrSplit2[1].equals("/")) {
            String strNum = arrSplit2[2];
            int numStr = Integer.parseInt(strNum);
            if (arrSplit2[0].length() > 10|numStr>10|numStr<1){
                System.out.println( "Вы ввели некорректный пример, попробуйте еще раз");
                throw new IllegalArgumentException();
            }
            else    {
                int y = arrSplit2[0].length()/numStr;
                System.out.print("Результат: ");
                int limit = y;
                String subStr = arrSplit2[0].codePointCount(0, arrSplit2[0].length()) > limit ? arrSplit2[0].substring(0, arrSplit2[0].offsetByCodePoints(0, limit)) : arrSplit2[0];
                System.out.println("\""+subStr+"\"");

            }
        }
    }
}
