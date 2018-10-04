//DOCS
/*
    base.convertToDec(String input, int Base)
        Converts the input format to Decimal using the Base specified

    base.DecConversion(String input, int outputBase)
        Converts the decimal value to the specified base

    base.singleToDec(char input)
        Gets the corresponding integer to a single character input. (ie A = 10)

    base.decToSingle(int dec)
        Converts the decimal input into a character if necessary (ie 10 = A)

    base.performMath(String firstNum, String secondNum, int firstBase, int secondBase, String operation)
        Performs math and returns the resulting double. 
*/



public class main{
    public static void main(String args[]){
        base.decConversion(100,16);
    }
}


class base{
    public static int singleToDec(char in){ // fix this
        int asc = (int)in;
        if(asc >= 48 && asc <= 57){
            System.out.println(in + " : " + (asc - 48));
            return asc - 48;
        }
        else if(asc >= 65 && asc <= 90){
            System.out.println(in + " : " + (asc - 57));
            return asc - 55; 
        }
        else{
            return -1;
        }
    }

    public static char decToSingle(int dec){
        if(dec >= 0 && dec <= 9){
            return Integer.toString(dec).charAt(0);
        }
        else if(dec > 9 && dec < 35){
            return (char)(64 + (dec - 9));
        }
        return '=';
    }

    public static int convertToDec(String in, int b){ // b is the type of number you're inputting
        int n = in.length();
        int s = 0; 
        for(int i = 0; i < in.length(); i++){
            n--;
            s += base.singleToDec(in.charAt(i)) * Math.pow(b, n);
        }
        return s;
    }

    public static String decConversion(int n, int b){
        String output = "";
        while(true){
            if(n == 0){
                break;
            }
            int remainder = n % b;
            output += Integer.toString(remainder);
            n = (int)(n/b);
        } 
        output = new StringBuffer(output).reverse().toString();      
        return output;
    }

    public static double performMath(String firstNum, String secondNum, int firstBase, int secondBase, String operation){ // 
        double n1 = (double)base.convertToDec(firstNum, firstBase);
        double n2 = (double)base.convertToDec(secondNum, secondBase);

        switch(operation){
            case "add": 
                return n1 + n2; 
            case "multiply": 
                return n1 * n2;
            case "divide": 
                return n1 / n2;
            case "subtract": 
                return n1 - n2;
        }
        return 0;
    }
}

