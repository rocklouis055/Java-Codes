import java.util.*;
public class tmerge{
  static int i=0,j=0,m=0,k;
  static int[] t;
 static void msort(int[] a,int l,int h){
   if(h>l){
    int m=(h+l)/2;
    msort(a,l,m);
    msort(a,m+1,h);
    merge(a,l,h,m);
   }
 }
  static void merge(int[] a,int l,int h, int m){
    i=l;
    j=m+1;
    k=l;
    while(i<=m && j<=h){
      if(a[i]<=a[j])
        t[k++]=a[i++];
      else
        t[k++]=a[j++];
    }
    while(i<=m)
      t[k++]=a[i++];
    while(j<=h)
      t[k++]=a[j++];
    for(k=l;k<=h;k++)
      a[k]=t[k];
  }
  public static void main(String[] args){
    Random a=new Random();
    Scanner sc=new Scanner(System.in);
    // threadmy t=new threadmy;
    System.out.print("Enter the size of the array : ");
    int n=sc.nextInt();
    int[] arr=new int[n];
    int[] ar2=new int[n];
    t=new int[n];
    for(int i=0;i<n;i++){
      arr[i]=a.nextInt(100);
      ar2[i]=arr[i];
    }
    // arr=new int[]{9,8,7,6,5,4,3,2,1,0};
    long t1;
    t1=System.nanoTime();
    msort(arr,0,n-1);
      // while(tm.isAlive());
    t1=System.nanoTime()-t1;
    for(int i=0;i<n-1;i++){
      if(arr[i]>arr[i+1]){
        System.out.println("Not sorted");
        break;
      }
    }
    // for(int i:arr)
    //     System.out.print(i+" ");
    // System.out.println();
    System.out.println("\nTime taken by Louise's  sort : "+t1);
  }
}