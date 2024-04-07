package Test;

class Parent {
    int num = 10;
    int n1;

    public Parent() {
        System.out.println("父类初始化");
    }

    public Parent(int n) {
        n1 = n;
        System.out.println("父类初始化");
    }

    public void printNum() {
        this.num = num + 2;
        System.out.println(num);
    }
}

class Son extends Parent {
    int num = 1;
    int n1;

    public Son() {
        System.out.println("子类初始化");
    }

    public Son(int n) {
        n1 = n;
        System.out.println("子类初始化");
    }

    public void printNum() {
        num += 1;
        System.out.println(num);
    }

    // @Override
    public void printNum(int i) {
        num += i;
        System.out.println(num);
    }
}

public class Inherit {
    public static void main(String[] args) {
        Parent p = new Son(); // 先调用父类的初始化再调用子类的初始化
        System.out.println(p.num); // 父类的属性
        p.printNum(); // 如果子类重写了该方法，调用子类的，反之调用父类的
        System.out.println(p.num);
    }
}
