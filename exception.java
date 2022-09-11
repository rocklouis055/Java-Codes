import java.util.*;
public class exception{
  public static void main(String[] args){
    int a,b;
    double c=0;
    Scanner sc=new Scanner(System.in);
    System.out.print("Enter a and b : ");
    
    try{
      a=sc.nextInt();
      b=sc.nextInt();
      c=a/b;
      System.out.println("a/b is : "+c);
    }
    catch (ArithmeticException e){
      e.printStackTrace();
    }
  }
}