package homework8;

import java.util.Scanner;

class InputString {
    String inputData;
    Scanner in = new Scanner(System.in);
    public String inputString(){
        System.out.print("Enter the mathematical expression whose result you need: ");
        inputData = in.nextLine();
        inputData = inputData.replace(",",".");
        inputData = inputData.replace(" ","");
        //inputData = inputData.replaceAll("\\w"," "); почему при активной данной строке все буквы просто удаляютсяются?
        return inputData;
    }
}
class SearchSymbol {
    final String[] doing = {"*","/","+","-","%"};
    String extdo = "fall";

    public String getSearchSymbol(String inputString) {
        for (int i=0;i<doing.length;i++) {
            //char simb = doing[i].strip();
            if (0 < inputString.indexOf(doing[i].strip()) &
                    inputString.indexOf(doing[i].strip()) < (inputString.length() - 1)) {
                extdo=doing[i].strip();
            }
        }
        return extdo;
    }
}
class Calculation {
    String expression;
    public void calculation() {
        InputString inputString = new InputString();
        expression = inputString.inputString();
        SearchSymbol searchSymbol = new SearchSymbol();
        String symbol = searchSymbol.getSearchSymbol(expression);
        expression=expression.replaceAll("[a-w,A-W]"," ");
        //expression=expression.replaceAll("\\w"," "); почему если я пишу предыдущую строку в таком виде, то все кроме символов меняется на пробелы?
        while (symbol=="fall" || expression.indexOf(" ") > -1) {
            if (Character.getNumericValue(expression.charAt(0)) == 0){
                System.out.println("Program interrupted by user.");
                System.exit(0);
            }
            System.out.println("Expression format is not correct. \n Enter 0 to exit ore");
            expression=inputString.inputString();
            symbol = searchSymbol.getSearchSymbol(expression);
        }
        if (symbol!="fall"){
            switch (symbol){
                case ("*"):
                {
                    expression=expression.replace(symbol.strip()," ");
                    String[] cal = expression.split(" ");
                    System.out.println("Result: " + (Double.valueOf(cal[0]) * Double.valueOf(cal[1])));
                }
                break;
                case ("/"):
                {
                    String[] cal = expression.split(symbol);
                    System.out.println("Result: " +(Double.valueOf(cal[0])/Double.valueOf(cal[1])));
                }
                break;
                case ("+"):
                {
                    expression=expression.replace(symbol.strip()," ");
                    String[] cal = expression.split(" ");
                    System.out.println("Result: " +(Double.valueOf(cal[0])+Double.valueOf(cal[1])));
                }
                break;
                case ("-"):
                {
                    String[] cal = expression.split("-");
                    System.out.println("Result: " +(Double.valueOf(cal[0])-Double.valueOf(cal[1])));
                }
                break;
                case ("%"):
                    {
                    String[] cal = expression.split("%");
                    System.out.println("Result: " +((Double.valueOf(cal[0])/100)*Double.valueOf(cal[1])));
                }
                break;
            }
        }
    }

}

public class task2 {

    public static void main(String[] args) {
        Calculation calculation = new Calculation();
        calculation.calculation();

    }
}
