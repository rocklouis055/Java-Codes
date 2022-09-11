
import java.util.*;

public class ms{
    static void mergeman(int []a,int s,int m,int e) {
		int []temp=new int[e-s+1];
		int i=s;
		int j=m+1;
		int k=0;
		while(i<=m && j<=e) {
			if(a[i]<=a[j]) {
				temp[k++]=a[i++];
			}
			else {
				temp[k++]=a[j++];
			}
		}
		while(i<=m) {
			temp[k++]=a[i++];
		}
		while(j<=e) {
			temp[k++]=a[j++];
		}
		for(int d=0,l=s;d<e-s+1;d++,l++) {
			a[l]=temp[d];
		}
	}
	static void msortman(int []a,int s,int e) {
		if(s>=e) {
			return;
		}
		int mid = s+(e-s)/2;
		msortman(a,s,mid);
		msortman(a,mid+1,e);
		mergeman(a,s,mid,e);
	}
  static int[] arr,temp;
  static int len,m,m2,i,j,k,k2;
   static void msort (int l,int h){
    if(l<h){
      int m=(l+h)/2;
      if(m-l>=2)
      msort(l,m);
      else
      {
          if (arr[l]>arr[m]){
          m2=arr[l];
          arr[l]=arr[m];
          arr[m]=m2;}
          
      }
      if(h-m-1>=2)
      msort(m+1,h);
      else
      {
          if (arr[m+1]>arr[h]){
          m2=arr[m+1];
          arr[m+1]=arr[h];
          arr[h]=m2;}
      }
      merge(l,m,h);
    }
    
  }
  static void merge(int l,int m,int h){
     i=l;
     j=m+1;
     k=l;
    k2=l;
    while(i<=m && j<=h){
      if(arr[i]<=arr[j]){
        temp[k++]=arr[i++];
      }
      else{
        temp[k++]=arr[j++];
      }
    }
    while(j<=h){
        temp[k++]=arr[j++];
    }
    while(i<=m){
        temp[k++]=arr[i++];
    }
     for(int m1=l;m1<=h;m1++)
     arr[m1]=temp[m1];
  }
  
  
  
  
  
  static void qsort(int[] l,int s,int e,int n){
  int i=s+1;
    int p=s,t;
    int j=e-1;
    if(e-s<=2){
       if(l[e-1]<l[s]){
           t=l[e-1];
           l[e-1]=l[s];
           l[s]=t;
       }
      }
        else{
        while(i<j){
            while(l[i]<=l[p] && i<j){
                i+=1;
            }
            while(l[j]>=l[p] && j>p )
                j-=1;
            if(i<j){
                t=l[i];
                l[i]=l[j];
                l[j]=t;}
        }
        t=l[p];
        l[p]=l[j];
        l[j]=t;
        p=j;
        if (p-s>0)
            qsort(l,s,p,n);
        if (p<e-2)
            qsort(l,p+1,e,n);
        }
  }
  
  public static void main(String [] args){
      long s;
    Random a= new Random();
    int t,n,k=100;
    Scanner sc=new Scanner(System.in);
    System.out.print("Enter the length of the Random array : ");
    n=sc.nextInt();
    int[] l=new int[n];
    int[] l2=new int[n];
    int[] l3=new int[n];
    int[] l4=new int[n];
    for(int i=0;i<n;i++){
      l[i]=a.nextInt(k);
      l2[i]=l[i];
      l3[i]=l[i];
      l4[i]=l[i];
    }
   
    s=System.nanoTime();
    qsort(l,0,n,n);
    s=System.nanoTime()-s;
    for(int i=1;i<n;i++){
        if(l[i]<l[i-1])
            System.out.println(i);
    }
    System.out.println("\nTime to  Quick  sort in nano seconds : "+s);
    arr=l3;
    temp=new int[n];
    len=n;
    s=System.nanoTime();
    msort(0,n-1);
    s=System.nanoTime()-s;

    for(int i=1;i<n;i++){
        if(l3[i]<l3[i-1])
            System.out.println(i);
    }
    
    System.out.println("Time to  Merge  sort in nano seconds : "+s);
    s=System.nanoTime();
    msortman(l4,0,n-1);
    s=System.nanoTime()-s;

    for(int i=1;i<n;i++){
        if(l4[i]<l4[i-1])
            System.out.println(i);
    }
    System.out.println("Time to  Merge2 sort in nano seconds : "+s);
     s=System.nanoTime();
    Arrays.sort(l2);
    s=System.nanoTime()-s;
    for(int i=1;i<n;i++){
        if(l2[i]<l2[i-1])
            System.out.println(i);
    }
    System.out.println("Time to Inbuilt sort in nano seconds : "+s);
  }
};
	