import java.util.*;
public class kruskal{
  static int[][] m,q;
  static int n,max=99999;
  static void minpath(){
    int[] v=new int[n];
    int g=1,k=0,c=0;
    int[][] grp=new int[n][n];
    int[][] d=new int[n*n][3];
    for(int i=0;i<n*(n-1);i++){
      if(v[q[i][1]]==0 && v[q[i][2]]==0){
        d[k][0]=q[i][1];
        d[k][1]=q[i][2];
        d[k++][2]=q[i][0];
        v[q[i][1]]=g;
        v[q[i][2]]=g++;
      }
      else if((v[q[i][1]]==0 && v[q[i][2]]!=0)){
        d[k][0]=q[i][1];
        d[k][1]=q[i][2];
        d[k++][2]=q[i][0];
        v[q[i][1]]=v[q[i][2]];
      }
      else if((v[q[i][1]]!=0 && v[q[i][2]]==0)){
        d[k][0]=q[i][1];
        d[k][1]=q[i][2];
        d[k++][2]=q[i][0];
        v[q[i][2]]=v[q[i][1]];
      }
      else if(v[q[i][1]]!=v[q[i][2]] && v[q[i][1]]!=0 && v[q[i][2]]!=0 && (grp[v[q[i][1]]][v[q[i][2]]]!=grp[v[q[i][2]]][v[q[i][1]]] || grp[v[q[i][1]]][v[q[i][2]]]==0 || grp[v[q[i][2]]][v[q[i][1]]]==0)){
    // sir,not working if 3 or more groups are interconnected 😔 
        d[k][0]=q[i][1];
        d[k][1]=q[i][2];
        d[k++][2]=q[i][0];
        grp[v[q[i][1]]][v[q[i][2]]]=grp[v[q[i][2]]][v[q[i][1]]]=v[q[i][1]];
      }
    }
    for(int i=0;i<k;i++){
      System.out.printf("Select Edge from %d to %d with weight %d\n",d[i][0],d[i][1],d[i][2]);
    }
  }
  static void sort(int[][] a,int n){
    int t;
    for(int i=0;i<n*n-n;i++){
      for(int j=0;j<n*n-i-1-n;j++){
        if(a[j][0]>a[j+1][0]){
          t=a[j][0];
          a[j][0]=a[j+1][0];
          a[j+1][0]=t;
          t=a[j][1];
          a[j][1]=a[j+1][1];
          a[j+1][1]=t;
          t=a[j][2];
          a[j][2]=a[j+1][2];
          a[j+1][2]=t;
        }
      }
    }
  }
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    System.out.print("Enter the number of vertices : ");
    n=sc.nextInt();
    System.out.println("Enter the Weighted Matrix : ");
    m=new int[n][n];
    q=new int[n*n-n][3];
    for(int i=0,t=0;i<n;i++)
      for(int j=0;j<n;j++){
        m[i][j]=sc.nextInt();
        if(i!=j){
        q[t][0]=m[i][j];
        q[t][1]=Math.min(i,j);
        q[t++][2]=Math.max(i,j);}
      }
    sort(q,n);
    minpath();
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