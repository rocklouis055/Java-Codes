import java.util.*;
class threadmy extends Thread{
  static int[] arr=new int[10];

  public int l1,h1;
    public void start(int l,int h){
      l1=l;
      h1=h;
      this.run();
    }
    public void run(){
      this.qsort(l1,h1);
    }
  static void qsort(int l,int h){
    int p=l,s=l+1,e=h,t;
    if(h-l<=2){
      if(arr[l]>arr[h]){
        t=arr[l];
        arr[l]=arr[h];
        arr[h]=t;
      }
      if(h-l>=1 && arr[l]>arr[l+1]){
        t=arr[l];
        arr[l]=arr[l+1];
        arr[l+1]=t;
      }
      else if(h-l>=1 && arr[h]<arr[h-1]){
        t=arr[h];
        arr[h]=arr[h-1];
        arr[h-1]=t;
      }
    }
    else{
      threadmy t1=null,t2=null;
      boolean t1c=false,t2c=false;
      while(s<e){
        while(s<=h && arr[p]>=arr[s])
          s+=1;
        while(e>=l && arr[p]<arr[e])
          e-=1;
        if(s<e){
          t=arr[s];
          arr[s]=arr[e];
          arr[e]=t;
        }
      }
      t=arr[e];
      arr[e]=arr[p];
      arr[p]=t;
      p=e;
      
      if(p-l>0){
        t1=new threadmy();
        t1.start(l,p-1);
        t1c=true;
      }
      
      if(h-p>0){
        t2=new threadmy();
        t2.start(p+1,h);
        t2c=true;
      }
      if(t1c && t2c){
        while(t1.isAlive() || t2.isAlive());
      }
      else if(t1c)
        while(t1.isAlive());
      else if(t2c)
        while(t2.isAlive());
    } 
  }

  // static int n=0;
  static void quicksort(int arr[],int l,int h) {
		if(l<h) {
			int p = partition(arr,l,h);
			quicksort(arr,l,p-1);
			quicksort(arr,p+1,h);
		}
	}
	
	static int partition(int arr[],int l,int h) {
		int p=arr[l],i=l,j=h;
		while(i<=j) {
			while(i<=h && arr[i]<=p) {
				i++;
			}
			while(arr[j]>p) {
				j--;
			}
			if(i<j) {
				swap(arr,i,j);
			}
		}
		arr[l]=arr[j];
		arr[j]=p;
		return j;
	}
	
	static void swap(int arr[],int i,int j) {
		int temp;
		temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
  public void main(String[] args){
    Random a=new Random();
    Scanner sc=new Scanner(System.in);
    // threadmy t=new threadmy;
    System.out.print("Enter the size of the array : ");
    int n=sc.nextInt();
    
    int[] ar2=new int[n];
    for(int i=0;i<n;i++){
      arr[i]=a.nextInt(100);
      ar2[i]=arr[i];
    }
    arr=new int[]{9,8,7,6,5,4,3,2,1,0};
    long t;
    
    t=System.nanoTime();
    quicksort(ar2,0,n-1);
    t=System.nanoTime()-t;
    for(int i=0;i<n-1;i++){
      if(ar2[i]>ar2[i+1]){
        System.out.println("Not sorted");
        break;
      }
    }
    System.out.println("Time taken by Manisha's sort : "+t);
    t=System.nanoTime();
    qsort(0,n-1);
      // while(tm.isAlive());
    t=System.nanoTime()-t;
    for(int i=0;i<n-1;i++){
      if(arr[i]>arr[i+1]){
        System.out.println("Not sorted");
        break;
      }
    }
    for(int i:arr)
        System.out.print(i+" ");
    System.out.println("\nTime taken by Louise's  sort : "+t);
  }
};