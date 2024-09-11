package Test;

public interface Interface {
    // 接口只有定义，不能有方法的实现
    void makeSound();

    default void sleep1() {
        System.out.println("Sleeping1...");
    }

    static void sleep2() {
        System.out.println("Sleeping2...");
    }

    private void sleep3() {
        // 私有方法不能被实现类访问，只能在接口内部使用
        System.out.println("Sleeping3...");
    }

}