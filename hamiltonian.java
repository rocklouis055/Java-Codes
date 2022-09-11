import java.util.*;
public class hamiltonian{
  static int[][] m,d;
  static int n,max=99999,k=0;
  static void minweight(int s,int[] v,int c,int[] dv,int j){
    int min=max,count=0;
    for(int i1=0;i1<n;i1++){
      // System.out.println(j+Arrays.toString(v)+" "+Arrays.toString(dv));
      if(v[i1]==0 && m[c][i1]!=0){
        count+=1;
        v[i1]=1;
        dv[j]=i1;
        minweight(s,v,i1,dv,j+1);
        v[i1]=0;
      }
    }
    if(count==0 && m[c][s]!=0 && chk(v)){
      dv[j]=s;
      for(int i=0;i<=n;i++)
        d[k][i]=dv[i];
      k+=1;
      // System.out.println(k+" "+Arrays.toString(d[k-1]));
    }
  }
  static boolean chk(int[] v){
    for(int l==0;l<n;l++)
      if(v[l]==0)
        return false;
    return true;
  }
  static void findall(){
    int[] a=new int[n+1];
    int[] t=new int[n];
    for(int i1=0;i1<n;i1++){
      t[i1]=1;
      a[0]=i1;
      minweight(i1,t,i1,a,1);
      t[i1]=0;
     }
   } 
  static void message(){
    if(k==0){
      System.out.println("No Hamiltonian cycles are there.");
      return;
    }
    System.out.printf("%d Hamiltonian cycles are there : \n",k);
    for(int i=0;i<k;i++){
      System.out.printf("Cycle %3d : %s\n",i+1,Arrays.toString(d[i]));
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
    d=new int[n*n*n*n*n][n+1];
    findall();
    message();
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
0 6 0 0 3 7
6 0 5 2 4 0
0 5 0 2 0 0
0 2 2 0 3 0
3 4 0 3 0 8
7 0 0 0 8 0

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

5
0 1 0 1 1
1 0 1 1 0
0 1 0 0 1
1 1 0 0 1
1 0 1 1 0

Non Hamiltonin Graph
5
0 1 1 0 0
1 0 1 0 0
1 1 0 1 1
0 0 1 0 1
0 0 1 1 0

*/