import java.util.*;

public class Calculator {
   public static void main(String[] args) {
      System.out.println("Welcome to Calculator!\n");
      System.out.println("1. Add\n2. Subtract\n3. Multiply\n4. Divide\n");
      
      Scanner input = new Scanner(System.in);
      
      System.out.print("What is your choice?: ");
      int choice = input.nextInt();
      
      if (choice == 1) {
         prompt();
      }
      else if (choice == 2) {
         prompt();
      }
      else if (choice == 3) {
         prompt();
      }
      else if (choice == 4) {
         prompt();
      }
      else {
         System.out.println("Error: Please try again");
      }
   }
   
   public int Add(int x, int y) {
      int z = x + y;
      return z;
   }
   
   public int Subtract(int x, int y) {
      int z = x - y;
      return z;
   }
   
   public int Multiply(int x, int y) {
      int z = x * y;
      return z;
   }
   
   public int Divide(int x, int y) {
      int z = x / y;
      return z;
   }
   
   public static void prompt() {
      System.out.println("First number: ");
      System.out.println("Second number: ");
   }
}