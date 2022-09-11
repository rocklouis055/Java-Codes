import java.util.*;
public class qsort{
    static int pass=0;
  static void qsort(int[] l,int s,int e,int n,char par){
      
    int i=s+1;
    int p=s,t;
    int j=e-1;
    System.out.printf("\n\ns=%d e=%d p=%d pass=%d part=%c\n",s,e,l[p],pass,par);
     for(int k=0;k<10;k++){
      System.out.print(l[k]+" ");
    }
    System.out.println();
    while(i<j){
        while(l[i]<=l[p] && i<j){
            i+=1;
        }
        System.out.printf("\ni=%d %d  p=%d  pass=%d\n",i,l[i],l[p],pass);
        while(l[j]>=l[p] && j>p )
            j-=1;
        System.out.printf("\nj=%d %d  p=%d pass=%d\n",j,l[j],l[p],pass);
        if(i<j){
            t=l[i];
            l[i]=l[j];
            l[j]=t;}
    }
    System.out.printf("\n%d i=%d %d j=%d  p=%d pass=%d\n",i,l[i],j,l[j],l[p],pass);
     for(int k=0;k<10;k++){
      System.out.print(l[k]+" ");
    }
    t=l[p];
    l[p]=l[j];
    l[j]=t;
    System.out.printf("\n%d i=%d p=%d %d p=%d  pass=%d\n",i,l[i],j,l[j],l[p],pass);
    p=j;
    if (p-s>0){
        pass+=1;
        qsort(l,s,p,n,'l');}
    if (p<e-2){
        pass+=1;
    qsort(l,p+1,e,n,'r');}
        
    
  }
  public static void main(String [] args){
    Random a= new Random();
    int t;
    int[] l={5,1,8,7,6,5,4,3,2,1};
    for(int i=0;i<10;i++){
      //l[i]=a.nextInt(100);
    }
    for(int i=0;i<10;i++){
      System.out.print(l[i]+" ");
    }
    System.out.println();
    
    qsort(l,0,10,10,'f');
    if(l[9]<l[8]){
        t=l[9];
        l[9]=l[8];
        l[8]=t;
    }
    System.out.println();
    for(int i=0;i<10;i++){
      System.out.print(l[i]+" ");
    }
  }
};