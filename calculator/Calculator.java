import java.util.*;

public class Calculator {
   public static void main(String[] args) {
      System.out.println("Welcome to Calculator!\n");
      boolean menu = true;
      Scanner input = new Scanner(System.in);
      
      while (menu) {
         System.out.println("1. Add\n2. Subtract\n3. Multiply\n4. Divide\n5. Quit\n");
      
         System.out.print("What is your choice?: ");
         
         int choice = input.nextInt();
         int x;
         int y;
         
         if (choice == 1) {
            x = first();
            y = second();
            int ans = Add(x, y);
            System.out.println("The result of your calculation is " + ans + "\n");
         }
         else if (choice == 2) {
            x = first();
            y = second();
            int ans = Subtract(x, y);
            System.out.println("The result of your calculation is " + ans + "\n");
         }
         else if (choice == 3) {
            x = first();
            y = second();
            int ans = Multiply(x, y);
            System.out.println("The result of your calculation is " + ans + "\n");
         }
         else if (choice == 4) {
            x = first();
            y = second();
            int ans = Divide(x, y);
            System.out.println("The result of your calculation is " + ans + "\n");
         }
         else if (choice == 5) {
            menu = false;
         }
         else {
            System.out.println("Error: Please try again");
         }
      }
   }
   
   public static int Add(int x, int y) {
      int z = x + y;
      return z;
   }
   
   public static int Subtract(int x, int y) {
      int z = x - y;
      return z;
   }
   
   public static int Multiply(int x, int y) {
      int z = x * y;
      return z;
   }
   
   public static int Divide(int x, int y) {
      int z = x / y;
      return z;
   }
   
   public static int first() {
      Scanner input = new Scanner(System.in);
      System.out.print("First number: ");
      int x = input.nextInt();
      return x;
   }
   
   public static int second() {
      Scanner input = new Scanner(System.in);
      System.out.print("Second number: ");
      int y = input.nextInt();
      System.out.println();
      return y;
   }
}