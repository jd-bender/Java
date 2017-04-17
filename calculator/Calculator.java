public class Calculator {
   public static void main(String[] args) {
      System.out.println("Welcome to Calculator!");
      System.out.println("1. Add\n2. Subtract\n3. Multiply\n4. Divide");
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
}