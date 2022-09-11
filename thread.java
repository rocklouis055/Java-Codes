import java.util.*;
import java.lang.*;
class multithread extends Thread{
  int t;
  multithread(int k){
    t=k;
  }
  int gen(){
    return((int)(Math.random()*(100-0+1))+0);
  }
  int square(int n){
    return(n*n);
  }
  int cube(int n){
    return(n*n*n);
  }
  public void run(){
    int n=gen();
    System.out.println("Thread "+t+", Generated number is : "+n);
    System.out.println("Thread "+t+", Sqaure of the number is : "+square(n));
    System.out.println("Thread "+t+", Cube of the number is : "+cube(n));
  }
}
public class thread{
  public static void main(String[] args) throws InterruptedException{
    for(int i=0;i<10;i++){
      multithread n=new multithread(i);
      n.start();
      System.out.println(n.isAlive());
      // Thread.sleep(100);
      while(n.isAlive());
    }
  }
}