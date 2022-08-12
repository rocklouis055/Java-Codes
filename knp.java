import java.util.*;
public class knp {
    public static void main(String args[]) {
     TreeMap<Float,int[]> a=new TreeMap<Float,int[]>(Collections.reverseOrder());
     Scanner sc=new Scanner(System.in);
     System.out.print("Enter the number of Datas : ");
     int n=sc.nextInt();
     System.out.print("Enter the KnapSack Capacity : ");
     int k=sc.nextInt();
     System.out.println("Enter Values and Weights :");
     for(int i=0;i<n;i++){
        int[] t=new int[2];
        t[0]=sc.nextInt();
        t[1]=sc.nextInt();
        a.put((float)t[0]/t[1],t);
     }
     float v=0,w=0;
      for (Map.Entry<Float,int[]>e : a.entrySet()){
          if(k-w>0){
              v+=e.getKey()*Math.min(e.getValue()[1],k-w);
              w+=Math.min(e.getValue()[1],k-w);
          }
          else
          break;
      }
      System.out.println("The best possible max value is : "+v);
    }
}