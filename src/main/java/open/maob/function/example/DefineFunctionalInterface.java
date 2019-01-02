package open.maob.function.example;

/**
 * @Description:
 * @Author: limaob
 * @CreateDate: 2019/1/2
 */
@FunctionalInterface
public interface DefineFunctionalInterface {

    /**
     * 1、该注解只能标记在"有且仅有一个抽象方法"的接口上。
     * 2、JDK8接口中的静态方法和默认方法，都不算是抽象方法。
     * 3、接口默认继承java.lang.Object，所以如果接口显示声明覆盖了Object中方法，那么也不算抽象方法。
     * 4、该注解不是必须的，如果一个接口符合"函数式接口"定义，那么加不加该注解都没有影响。加上该注解能够更好地让编译器进行检查。如果编写的不是函数式接口，但是加上了@FunctionInterface，那么编译器会报错。
     * 5.接口中可以添加default修饰的默认方法。
     * 6.接口中添加static修饰的静态方法，可以直接通过接口名调用。
     */
    void eat();

    //声明覆盖了Object中方法不会报错
    boolean equals(Object obj);
    // 默认方法
    default void printMessage(String message){
        System.out.println(message);
    }
    // 静态方法  ClassName.method调用
    static void sendMessage(String message){
        System.out.println("发送消息成功: " + message);
    }
}
