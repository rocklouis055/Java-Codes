import java.util.*;

public class qsortworking {

  static void qsort2(int[] a, int low, int high) {
    if (low < high) {
      int p = partition(a, low, high);
      qsort2(a, low, p - 1);
      qsort2(a, p + 1, high);
    }
  }

  static int partition(int[] a, int low, int high) {
    int pivot = a[low];
    int i = low;
    int j = high;
    while (i <= j) {
      while (a[i] <= pivot) {
        i++;
      }
      while (a[j] > pivot) {
        j--;
      }
      if (i < j) {
        swap(a, i, j);
      }
    }
    a[low] = a[j];
    a[j] = pivot;
    return j;
  }

  static void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  static void qsort(int[] l, int s, int e, int n) {
    int i = s + 1;
    int p = s, t;
    int j = e - 1;
    if (e - s <= 2) {
      if (l[e - 1] < l[s]) {
        t = l[e - 1];
        l[e - 1] = l[s];
        l[s] = t;
      }
    } else {
      while (i < j) {
        while (l[i] <= l[p] && i < j) {
          i += 1;
        }
        while (l[j] >= l[p] && j > p)
          j -= 1;
        if (i < j) {
          t = l[i];
          l[i] = l[j];
          l[j] = t;
        }
      }
      t = l[p];
      l[p] = l[j];
      l[j] = t;
      p = j;
      if (p - s > 0)
        qsort(l, s, p, n);
      if (p < e - 2)
        qsort(l, p + 1, e, n);
    }
  }

  public static void main(String[] args) {
    long s;
    Random a = new Random();
    int t, n, k = 100000000;
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the length of the Random array : ");
    n = sc.nextInt();
    int[] l = new int[n];
    int[] l2 = new int[n];
    int[] l3 = new int[n];
    for (int i = 0; i < n; i++) {
      l[i] = a.nextInt(k);
      l2[i] = l[i];
      l3[i] = l[i];
    }
    // for(int i=0;i<n;i++)
    // System.out.print(l[i]+" ");
    s = System.nanoTime();
    qsort(l, 0, n, n);
    s = System.nanoTime() - s;
    for (int i = 1; i < n; i++) {
      if (l[i] < l[i - 1])
        System.out.println(i);
    }
    System.out.println("Time to  Quick  sort in nano seconds : " + s);

    s = System.nanoTime();
    qsort2(l3, 0, n - 1);
    s = System.nanoTime() - s;
    for (int i = 1; i < n; i++) {
      if (l3[i] < l3[i - 1])
        System.out.println(i);
    }
    System.out.println("Time to  Quick2 sort in nano seconds : " + s);
    s = System.nanoTime();
    Arrays.sort(l2);
    s = System.nanoTime() - s;
    for (int i = 1; i < n; i++) {
      if (l2[i] < l2[i - 1])
        System.out.println(i);
    }
    System.out.println("Time to Inbuilt sort in nano seconds : " + s);
    // for(int i=0;i<n;i++)
    // System.out.print(l[i]+" ");
  }
};
import java.util.*;

public class qsortworking {

  static void qsort2(int[] a, int low, int high) {
    if (low < high) {
      int p = partition(a, low, high);
      qsort2(a, low, p - 1);
      qsort2(a, p + 1, high);
    }
  }

  static int partition(int[] a, int low, int high) {
    int pivot = a[low];
    int i = low;
    int j = high;
    while (i <= j) {
      while (a[i] <= pivot) {
        i++;
      }
      while (a[j] > pivot) {
        j--;
      }
      if (i < j) {
        swap(a, i, j);
      }
    }
    a[low] = a[j];
    a[j] = pivot;
    return j;
  }

  static void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  static void qsort(int[] l, int s, int e, int n) {
    int i = s + 1;
    int p = s, t;
    int j = e - 1;
    if (e - s <= 2) {
      if (l[e - 1] < l[s]) {
        t = l[e - 1];
        l[e - 1] = l[s];
        l[s] = t;
      }
    } else {
      while (i < j) {
        while (l[i] <= l[p] && i < j) {
          i += 1;
        }
        while (l[j] >= l[p] && j > p)
          j -= 1;
        if (i < j) {
          t = l[i];
          l[i] = l[j];
          l[j] = t;
        }
      }
      t = l[p];
      l[p] = l[j];
      l[j] = t;
      p = j;
      if (p - s > 0)
        qsort(l, s, p, n);
      if (p < e - 2)
        qsort(l, p + 1, e, n);
    }
  }

  public static void main(String[] args) {
    long s;
    Random a = new Random();
    int t, n, k = 100000000;
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the length of the Random array : ");
    n = sc.nextInt();
    int[] l = new int[n];
    int[] l2 = new int[n];
    int[] l3 = new int[n];
    for (int i = 0; i < n; i++) {
      l[i] = a.nextInt(k);
      l2[i] = l[i];
      l3[i] = l[i];
    }
    // for(int i=0;i<n;i++)
    // System.out.print(l[i]+" ");
    s = System.nanoTime();
    qsort(l, 0, n, n);
    s = System.nanoTime() - s;
    for (int i = 1; i < n; i++) {
      if (l[i] < l[i - 1])
        System.out.println(i);
    }
    System.out.println("Time to  Quick  sort in nano seconds : " + s);

    s = System.nanoTime();
    qsort2(l3, 0, n - 1);
    s = System.nanoTime() - s;
    for (int i = 1; i < n; i++) {
      if (l3[i] < l3[i - 1])
        System.out.println(i);
    }
    System.out.println("Time to  Quick2 sort in nano seconds : " + s);
    s = System.nanoTime();
    Arrays.sort(l2);
    s = System.nanoTime() - s;
    for (int i = 1; i < n; i++) {
      if (l2[i] < l2[i - 1])
        System.out.println(i);
    }
    System.out.println("Time to Inbuilt sort in nano seconds : " + s);
    // for(int i=0;i<n;i++)
    // System.out.print(l[i]+" ");
  }
};
