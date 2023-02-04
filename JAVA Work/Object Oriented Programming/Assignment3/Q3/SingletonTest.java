import java.util.Scanner;

public class SingletonTest {
    public static void main(String[] args){
        for(int i = 0; i < 5; i++) {
            System.out.println("Would you like to create another instance? ");
            Scanner obj = new Scanner(System.in);
            System.out.println("Enter Yes or No ");

            String ans = obj.nextLine();
            if(ans.equals("Yes")){
                SingletonAssignment3 instance = SingletonAssignment3.createInstance();
            } else if(ans.equals("No")){
                System.out.println("No instance requested");
            }

        }

    }
}
