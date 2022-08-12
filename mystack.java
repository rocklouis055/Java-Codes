import java.util.Scanner;
public class mystack {
    int max, top, ele;
    int[] st;
    public mystack() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the Stack :");
        max = sc.nextInt();
        st = new int[max];
        top -= 1;
    }
    public void push(int ele) {
        if (top == max - 1) {
            System.out.println("\nOverftow!");
            return;
        }
        st[++top] = ele;
    }
    public int pop() {
        if (top == -1) {
            System.out.println("\nunderflow! ");
            return (-1);
        }
        return (st[top--]);
    }
    public void display() {
        if (top == -1) {
            System.out.println("\nunderflow! ");
            return;
        }
        for (int i = 0; i <=top; i++) {
            System.out.print(st[i]+" ");
        }
    sc.close();
    }
  public static void main(String[] args) {
     int o, ele;
        Scanner sc = new Scanner(System.in);
        mystack obj = new mystack();
        while (true) {
            System.out.println("\nEnter ur choice :");
            System.out.println("1.Push.");
            System.out.println("2.Pop");
            System.out.println("3. Display");
            System.out.println("4.Exit");

            o = sc.nextInt();
            switch (o) {
                case 1:
                    System.out.println("Enter the element :");
                    ele = sc.nextInt();
                    obj.push(ele);
                    break;

                case 2:
                    System.out.println("Poped element is :" + obj.pop());
                    break;

                case 3:
                    j: System.out.println(
                        "Elements in the Stack are :");
                    obj.display();
                    break;

                case 4:
                    System.out.println("Exiting..");
                    System.exit(0);

                default:
                    System.out.println("Invalid");
            }
        }
}
}