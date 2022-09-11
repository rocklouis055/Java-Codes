import java.util.*;
public class tsp{
  static int[][] m;
  static int[] d;
  static int n,max=99999,k=0;
  static int min=max;
  static void minweight(int s,int[] v,int c,int[] dv,int w,int j){
    int count=0;
    for(int i=0;i<n;i++){
      
      if(v[i]==0 && m[c][i]!=0){
        count+=1;
        v[i]=1;
        dv[j]=i;
        minweight(s,v,i,dv,m[c][i]+w,j+1);
        v[i]=0;
      }
    }
    if(count==0){
      if(d[n+1]>w+m[c][s]){
        for(int l=0;l<n;l++)
          d[l]=dv[l];
        d[n]=s;
        d[n+1]=w+m[c][s];
      }
    }
  }
  static void mincycle(){
    int[] dv=new int[n+1];
    d=new int[n+2];
    dv[0]=0;
    int[] v=new int[n];
    v[0]=1;
    d[n+1]=max;
    minweight(0,v,0,dv,0,1);
    System.out.printf("Cycle with min weight of %d is : ",d[n+1]);
    for(int i=0;i<=n;i++)
    System.out.printf("%2d ",d[i]);
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
    mincycle();
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

4
0 1 2 4
1 0 0 1
2 0 0 1
4 1 1 0

4
0 10 15 20
5 0 9 10
6 13 0 12
8 8 9 0

*/