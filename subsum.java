import java.util.*;
public class subsum{
  static int[] a;
  static int[][] d;
  static int n,s,k=0,t;
  static void subset(int i,int c,int[] sa,int j,int l){
    for(int v=i;v<n;v++){
      if(a[v]+c<s && v<n-1){
        sa[j]=a[v];
        subset(v+1,a[v]+c,sa,j+1,l+1);
      }
      else if(a[v]+c==s){
        sa[j]=a[v];
        for(t=0;t<=j;t++){
          d[k][t]=sa[t];
        }
        d[k][n]=t;
        k+=1;
      }
    }
  }
  static void message(){
    if(k==0)
      System.out.printf("No subset found with sum : %d\n",s);
    else{
      System.out.printf("Subset found with sum %d are :\n",s);
      for(int i1=0;i1<k;i1++){
        for(int j1=0;j1<d[i1][n];j1++)
          System.out.printf("%2d ",d[i1][j1]);
        System.out.println();
      }
    }
  }
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    System.out.print("Enter the size : ");
    n=sc.nextInt();
    System.out.print("Enter the elements : ");
    a=new int[n];
    for(int i=0;i<n;i++)
      a[i]=sc.nextInt();
    d=new int[(int)Math.pow(2,n)][n+1];
    System.out.print("Enter the sum : ");
    s=sc.nextInt();
    subset(0,0,new int[n],0,1);
    message();
  }
}
/* Example test case
  5
  1 2 5 6 8
  9
*/