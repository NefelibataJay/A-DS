package Test;

public abstract class AbstractClass {
    public AbstractClass() {
    }

    // 抽象类可以有定义与实现
    abstract void printString(String str);

    void printInt(int value) {
        System.out.println(value);
    }
}
