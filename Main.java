import java.util.*;
import java.io.*; 
  
public class Main {
	public static void main (String[] args) {
	  Scanner sc = new Scanner(System.in); 
		int n = sc.nextInt();
		char a[][] = new char[3][n];
    char[] b = new char[n*3];
      b=sc.next().toCharArray();
		System.out.println(b);
    int c=0;
    for(int i=0;i<3;i++){
      for(int j=0;j<n;j++)
        a[i][j]=b[i*n+j];
    }
   for(int i=0;i<3;i++){
      for(int j=0;j<n;j++)
        System.out.print(a[i][j]);
    }    
		StringBuilder res = new StringBuilder();
		int i = 0;
		while(i<n) {
			if(a[0][i] == '#') {
				res.append("#");
				i++;
			}
			else {
				if(a[0][i+1]=='*' && a[1][i+1]=='*' && a[2][i+1]=='.') {
					res.append("A");
				}
				else if(a[0][i+1]=='.' && a[1][i+1]=='.' && a[2][i+1]=='*') {
					res.append("U");
				}
				else if(a[0][i+1]=='*' && a[1][i+1]=='.' && a[2][i+1]=='*') {
					res.append("O");
				}
				else {
					if(a[0][i]=='*' && a[1][i]=='.' && a[2][i]=='*') {
						res.append("I");
					}
					else {
						res.append("E");
					}
				}
				i += 3;
			}
		}
		System.out.println(res);
	}
}
/*
18
*.*#***#***#***.*.*.*#*.*#.*.#*********#***#***#****.*
*/