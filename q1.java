import java.util.*;
class q1{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int a,b;
    System.out.print("Enter the number a : ");
    a=sc.nextInt();
    System.out.print("Enter the number b : ");
    b=sc.nextInt();
    a=a+b;
    b=a-b;
    a=a-b;
    System.out.print("a is : "+a+", b is : "+b);
  }
};