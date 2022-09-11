import java.util.*;
public class dijkstra{
  static int[][] m;
  static int n,max=99999;
  static void getshortest(int s){
    int[] d=new int[n];
    boolean[] v=new boolean[n];
    int w=0,m1=0,m2=s,c=0,k;
    for(int i=0;i<n;i++){
      d[i]=max;
      v[i]=true;
    }
    d[m2]=0;
    while(c<n){
      w=m1;
      k=m2;
      v[k]=false;
      m1=max;
      for(int i=0;i<n;i++)
        if(v[i]){
          d[i]=Math.min(d[i],w+m[k][i]);
          if(m1>=d[i]){
            m1=d[i];
            m2=i;
          }
        }
      c+=1;
    }
    System.out.println();
    for(int i=0;i<n;i++){
        System.out.printf("The minimum distance from %d to %d is : %d\n",s,i,d[i]);
    }
  }
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    System.out.print("Enter the number of vertices : ");
    n=sc.nextInt();
    System.out.println("Enter the Weighted Matrix : ");
    m=new int[n][n];
    for(int i=0;i<n;i++)
      for(int j=0;j<n;j++)
        m[i][j]=sc.nextInt();
    System.out.println("Enter the Source node : ");
    getshortest(sc.nextInt());
  }
}
/* Example test case
  5
  0 6 999 1 999 
  6 0 5 2 2 
  999 5 0 999 5 
  1 2 999 0 1
  999 2 5 1 0
*/