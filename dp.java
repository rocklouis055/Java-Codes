import java.util.*;

public class dp {
  static int[] w, v;
  static int n, k;

  static void sol() {
    int[][] t = new int[n + 1][k + 1];
    for (int i = 0; i <= n; i++)
      for (int j = 0; j <= k; j++) {
        if (i == 0 || j == 0)
          t[i][j] = 0;
        else if (w[i - 1] > j)
          t[i][j] = t[i - 1][j];
        else
          t[i][j] = Math.max(v[i - 1] + t[i - 1][j - w[i - 1]], t[i - 1][j]);
      }
    System.out.println("Memo Table is :");
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= k; j++)
        System.out.printf("%2d ", t[i][j]);
      System.out.println();
    }
    System.out.println("Max Value we can get is : " + t[n][k]);
    System.out.print("Select items : ");
    int i = n, j = k;
    while (i > 0 && j > 0) {
      if (t[i][j] != t[i - 1][j]) {
        System.out.print(i + " ");
        j -= w[i - 1];
      }
      i -= 1;
    }
  }

  // Example Case Input : 5 4 1 10 2 7 1 11 3 15
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.printf("Enter the Knapsac Capacity : ");
    k = sc.nextInt();
    System.out.printf("Enter the number of elements : ");
    n = sc.nextInt();
    w = new int[n];
    v = new int[n];
    System.out.printf("Enter the Weights and Values of %d:\n", n);
    for (int i = 0; i < n; i++) {
      w[i] = sc.nextInt();
      v[i] = sc.nextInt();
    }
    sol();
  }
};