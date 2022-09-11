import java.util.*;
public class prims{
  static int[][] m;
  static int n,max=99999;
  static void minpath(int s){
    int[] v=new int[n];
    int[][] d=new int[n][n];
    int[][] min=new int[1][3];
    int c=0,k=0;
    v[s]=1;
    while(c<n-1){
      min[0][2]=max;
      for(int i=0;i<n;i++){
        if(v[i]==1){
          for(int j=0;j<n;j++){
            if(m[i][j]<min[0][2] && m[i][j]!=0 && v[j]==0){
              min[0][0]=i;
              min[0][1]=j;
              min[0][2]=m[i][j];
            }
          }
        }
      }
      v[min[0][1]]=1;
      d[k][0]=min[0][0];
      d[k][1]=min[0][1];
      d[k++][2]=min[0][2];
      c+=1;
    }
    for(int i=0;i<k;i++){
      System.out.printf("Select Edge from %d to %d with weight %d\n",d[i][0],d[i][1],d[i][2]);
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
      }
    minpath(0);
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

*/