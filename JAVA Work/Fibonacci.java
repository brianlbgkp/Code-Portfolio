import java.util.Scanner;

public class Fibonacci {

    public static int calculate(int num){
        if((num == 0)|| (num == 1)) {
            return num;
        } else {
            int answer = calculate(num - 1) + calculate(num - 2);
            return answer;
        }
    }

    public static void main(String[] args){
        int result = calculate(5);
        System.out.println(result);

        //if you want to calculate based on user input

        System.out.println("Input an integer: ");

        Scanner in = new Scanner(System.in);

        int userInt = in.nextInt();
        int userResult = calculate(userInt);
        System.out.println(userResult);
    }
}
