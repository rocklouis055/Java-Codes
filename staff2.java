import java.util.Scanner;

class staff {
  int staffid, sal;
  long phone;
  String name;

  staff(String n, int id, long ph, int s) {
    staffid = id;
    phone = ph;
    name = n;
    sal = s;
  }

  void display() {
    System.out.println("\nDetails are :");
    System.out.println("Name : " + name);
    System.out.println("ID : " + staffid);
    System.out.println("Phone : " + phone);
    System.out.println("Salary : " + sal);
  }
};

class teaching extends staff {
  String domain, pub;

  teaching(String n, int id, long ph, int sal, String dom, String p) {
    super(n, id, ph, sal);
    domain = dom;
    pub = p;
  }

  void dteach() {
    super.display();
    System.out.println("Domains : " + domain);
    System.out.println("Publications : " + pub);
  }
};

class technical extends staff {
  String skills;

  technical(String n, int id, long ph, int sal, String s) {
    super(n, id, ph, sal);
    skills = s;
  }

  void dtech() {
    super.display();
    System.out.println("Skills : " + skills);
  }
};

class contract extends staff {
  String period;

  contract(String n, int id, long ph, int sal, String p) {
    super(n, id, ph, sal);
    period = p;
  }

  void dcontract() {
    super.display();
    System.out.println("Period : " + period);
  }
};

public class staff2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int id, sal, o;
    String name, dom, pub, skills, period;
    long p;
    System.out.println("Staff Manegemment : ");
    System.out.println("1. Teaching Staff");
    System.out.println("2. Technical Staff");
    System.out.println("3. Staff Staff");
    System.out.print("Select your option : ");
    o = sc.nextInt();
    switch (o) {
      case 1:
        System.out.println("You have selected Teaching Staff.Please fill the details.");
        teaching[] teach = new teaching[3];
        for (int i = 0; i < 3; i++) {
          System.out.println("Staff : " + (i + 1));
          name = sc.next();
          id = sc.nextInt();
          sal = sc.nextInt();
          p = sc.nextLong();
          pub = sc.next();
          dom = sc.next();
          teach[i] = new teaching(name, id, p, sal, dom, pub);
        }
        for (int i = 0; i < 3; i++) {
          teach[i].dteach();
          System.out.println();
        }
        break;
      case 2:
        System.out.println("You have selected technical Staff.Please fill the details.");
        technical[] tech = new technical[3];
        for (int i = 0; i < 3; i++) {
          System.out.println("Staff : " + (i + 1));
          name = sc.next();
          id = sc.nextInt();
          sal = sc.nextInt();
          p = sc.nextLong();
          skills = sc.next();
          tech[i] = new technical(name, id, p, sal, skills);
        }
        for (int i = 0; i < 3; i++) {
          tech[i].dtech();
          System.out.println();
        }
        break;
      case 3:
        System.out.println("You have selected contract Staff.Please fill the details.");
        contract[] con = new contract[3];
        for (int i = 0; i < 3; i++) {
          System.out.println("Staff : " + (i + 1));
          name = sc.next();
          id = sc.nextInt();
          sal = sc.nextInt();
          p = sc.nextLong();
          period = sc.next();
          con[i] = new contract(name, id, p, sal, period);
        }
        for (int i = 0; i < 3; i++) {
          con[i].dcontract();
          System.out.println();
        }
        break;
      default:
        System.out.println("INVALID OPTION! Exiting...");
    }
  }
  sc.close();
};
