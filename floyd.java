import java.util.*;
public class floyd{
  static int[][] m;
  static int n,max=99999;
  static void allpairshort(){
    for(int k=0;k<n;k++)
      for(int i=0;i<n;i++)
        for(int j=0;j<n;j++)
          if(i!=k && j!=k)
            m[i][j]=Math.min(m[i][j],m[i][k]+m[k][j]);
    System.out.println("\nAll Pairs shortes distances :");
    for(int i=0;i<n;i++){
      for(int j=0;j<n;j++)
        System.out.printf("%3d ",m[i][j]);
      System.out.println();
    }
  }
    
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    System.out.print("Enter the number of vertices : ");
    n=sc.nextInt();
    System.out.println("Enter the Weighted Matrix : ");
    m=new int[n][n];
    for(int i=0,t=0;i<n;i++)
      for(int j=0;j<n;j++){
        m[i][j]=sc.nextInt();
        if(i!=j && m[i][j]==0)
          m[i][j]=max;
      }
    allpairshort();
  }
}
/* Example test case
  5
  0 6 999 1 999 
  6 0 5 2 2 
  999 5 0 999 5 
  1 2 999 0 1
  999 2 5 1 0
6
0 6 999 999 3 7
6 0 5 2 4 999
999 5 0 2 999 999
999 2 2 0 3 999
3 4 999 3 0 8
7 999 999 999 8 0

4
0 999 3 1
2 0 999 1
999 7 0 1
7 999 999 0

4
0 3 999 7
8 0 2 999
5 999 0 1
2 999 999 0
*/