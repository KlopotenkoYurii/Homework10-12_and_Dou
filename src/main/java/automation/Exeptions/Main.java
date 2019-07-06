package automation.Exeptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to calc program 1.0.0.0");
        while (true) {
            int x = readInteger();
            int y = readInteger();

            System.out.println(String.format("%s + %s = %s", x, y, x + y));
            System.out.print("Continue - yes/no ");
            String answer = bufferedReader.readLine();

                if(answer.equalsIgnoreCase("no")){
            break;
        }
        }
        System.out.println("Finished to calc program 1..0.0");
    }

    public static int readInteger() throws IOException {
        System.out.print("Enter number: ");
        int number;
        while (true) {
            String numberAsString = bufferedReader.readLine();
            try {
                number = Integer.valueOf(numberAsString);

                if (number < 0) {
                    throw new NegativeValueException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.print("Incorrect value. Please re-enter a number: ");
            }catch (NegativeValueException e){
                System.out.print("Negative value Please re-enter positive value");
            }
        }
        return number;
    }
}






//    public static void catchException(){
//            try {
//                //TODO: code will be executed
//                System.out.println("Try Begin");
//
//                throw new Exception("my exception");
//
//                //   System.out.println("Try End");
//            } catch (Exception e) {
//                System.out.println("Inside catch");
//                //TODO: code in this block will run in case of Exeption
//            }finally {
//                System.out.println("Inside finaly");
//                //TODO: code in this block will run anyway
//            }
//            System.out.println("After try-catch-finaly block");
//        }
//        }



