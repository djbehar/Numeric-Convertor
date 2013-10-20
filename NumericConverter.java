import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class NumericConvertor {
    Integer i;

    // contructor
    NumericConvertor(Integer i) {
        this.i = i;
    }

    // convert a numerical digit (0 - 19) to an english word
    String digitHelper(String s) {
        if (s.equals("0"))
            return "";
        else if (s.equals("1"))
            return "one";
        else if (s.equals("2"))
            return "two";
        else if (s.equals("3"))
            return "three";
        else if (s.equals("4"))
            return "four";
        else if (s.equals("5"))
            return "five";
        else if (s.equals("6"))
            return "six";
        else if (s.equals("7"))
            return "seven";
        else if (s.equals("8"))
            return "eight";
        else if (s.equals("9"))
            return "nine";
        else if (s.equals("10"))
            return "ten";
        else if (s.equals("11"))
            return "eleven";
        else if (s.equals("12"))
            return "twelve";
        else if (s.equals("13"))
            return "thirteen";
        else if (s.equals("14"))
            return "fourteen";
        else if (s.equals("15"))
            return "fifteen";
        else if (s.equals("16"))
            return "sixteen";
        else if (s.equals("17"))
            return "seventeen";
        else if (s.equals("18"))
            return "eighteen";
        else
            return "nineteen";
    }

    // convert the second digit to the correct prefix
    String secondDigitHelper(String s) {
        if (s.equals("2"))
            return "twenty";
        else if (s.equals("3"))
            return "thirty";
        else if (s.equals("4"))
            return "forty";
        else if (s.equals("5"))
            return "fifty";
        else if (s.equals("6"))
            return "sixty";
        else if (s.equals("7"))
            return "seventy";
        else if (s.equals("8"))
            return "eighty";
        else
            return "ninety";
    }

    // convert a two digit number to an english word
    String convertTwo(String s) {
        if (s.length() == 1)
            return digitHelper(s);
        else if (s.substring(0, 1).equals("0"))
            return digitHelper(s.substring(1, 2));
        else if (s.substring(0, 1).equals("1"))
            return digitHelper(s);
        else
            return this.secondDigitHelper(s.substring(0, 1)) + " "
                    + this.digitHelper(s.substring(1, 2));
    }

    // convert a three digit number to an english word
    String convertThree(String s) {
        if (s.length() != 3)
            return convertTwo(s);
        else if (s.substring(0, 1).equals("0"))
            return convertTwo(s.substring(1));
        else
            return digitHelper(s.substring(0, 1)) + " hundred "
                    + convertTwo(s.substring(1));
    }

    // determine how many digits belong in the last "group of three"
    // (ie. if the number is 7234, one digit (7) belongs)
    int determineFirst(int i) {
        if (i % 3 == 0)
            return 3;
        else
            return (i % 3);
    }

    // convert a number (as a string) to an english word
    String convertString(String s) {

        int x = (determineFirst(s.length()));
        int l = s.length() - 1;

        if ((l / 3) > 3)
            return convertThree(s.substring(0, x)) + " trillion "
                    + convertString(s.substring(x));
        else if ((l / 3) > 2)
            return convertThree(s.substring(0, x)) + " billion "
                    + convertString(s.substring(x));

        else if ((l / 3) > 1)
            return convertThree(s.substring(0, x)) + " million "
                    + convertString(s.substring(x));

        else if ((l / 3) > 0)
            return convertThree(s.substring(0, x)) + " thousand "
                    + convertString(s.substring(x));
        else
            return convertThree(s);

    }

    // convert an integer (0 - .999quadrillion)to an english word
    String convert() {
        String myString = this.i.toString();
        if (this.i == 0)
            return "zero";
        else if (myString.startsWith("-"))
            return "negative " + 
        convertString(this.i.toString().substring(1, i.toString().length()));
        // remove leading zeroes
        else if (myString.startsWith("0")) {
            while (myString.startsWith("0")) {
                myString = myString.substring(1, this.i.toString().length());
            }
            return myString;
        }
        else
            return convertString(this.i.toString());
    }
}

class Algorithm {

    public static void printInput() {

        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();

        NumericConvertor number = new NumericConvertor(i);

        System.out.println(number.convert());

    }

    public static void main(String args[]) {
        printInput();
    }
}