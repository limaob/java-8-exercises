package open.maob.lambda.example;

import open.maob.model.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description:
 * @Author: limaob
 * @CreateDate: 2019/1/2
 */
public class LambdaExpression {

    /**
     * Lambda表达式的相关说明
     * 1. 不需要参数,返回值为 5
     * () -> 5
     * 2. 接收一个参数(数字类型),返回其2倍的值
     * x -> 2 * x
     * 3. 接受2个参数(数字),并返回他们的差值
     * (x, y) -> x – y
     * 4. 接收2个int型整数,返回他们的和
     * (int x, int y) -> x + y
     * 5. 接受一个 string 对象,并在控制台打印,不返回任何值(看起来像是返回void)
     * (String s) -> System.out.print(s)
     */
    public static void main(String[] args) {
        // 测试Lambda
        useLambda();
        // 测试排序
        List<Person> data = generateData();
        System.out.println("--------------------排序前--------------------");
        data.forEach(person -> System.out.println(person));
        sortByName(data);
        System.out.println("--------------------排序后--------------------");
        data.forEach(person -> System.out.println(person));
    }



    // 测试Lambda表达式
    private static void useLambda() {
        MathOperation add = (x, y) -> x + y;
        // 大括号中的返回语句(可以写多条语句)
        MathOperation multiplication = (x, y) -> {
            return x * y;
        };

        MathOperation division = (int x, int y) -> x / y;

        System.out.println("10 + 5 = " + operate(10, 5, add));
        System.out.println("10 x 5 = " + operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + operate(10, 5, division));

        // 打印无返回值接口函数
        GreetingService greet = message -> System.out.println("Hello, "+ message);
        greet.sayMessage("sk");
    }


    // 计算接口
    interface MathOperation {
        int operation(int x, int y);
    }

    // 无返回值接口
    interface GreetingService {
        void sayMessage(String message);
    }

    // 计算过程
    private  static int operate(int x, int y, MathOperation mathOperation) {
        return mathOperation.operation(x, y);
    }


    private static void sortByName(List<Person> persons) {
        Collections.sort(persons, (p1, p2) -> p1.getName().compareTo(p2.getName()));
    }


    private static List<Person> generateData() {
        List<Person> persons = new ArrayList<>();
        for (int i = 9; i > 0; i--) {
            Person person = new Person("name0" + i, 20 + i);
            persons.add(person);
        }
        return persons;
    }
}
