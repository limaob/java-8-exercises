package open.maob.function.example;

import open.maob.model.Person;

import java.text.DecimalFormat;
import java.util.function.*;

/**
 * @Description:
 * @Author: limaob
 * @CreateDate: 2019/1/2
 */
public class FunctionalExample {

    public static void main(String[] args) {
        // 测试Function<T, R> T代表input R代表Return
        testFuction();
        // 测试Function<T, R>.andThen和Function<T, R>.compose
        andThenAndCompose();
        // 测试算子Operator\
        testOperator();
        // 测试算子Predicate
        testPredicate();
        // 测试Consumer
        testConsumer();
    }

    // 测试Function<T, R> BitFunction<T, U, R>
    private static void testFuction() {
        Function<Long, String> f = i -> new DecimalFormat("#,###").format(i);
        Person person = new Person(999999L);
        System.out.println("我的存款: " + f.apply(person.getAssets()));
        // 多个参数
        BiFunction<Integer, Integer, Integer> bitFunction = (a, b) -> a * b;
        System.out.println(bitFunction.apply(2, 3));
    }

    // 测试Function<T, R>.andThen和Function<T, R>.compose
    private static void andThenAndCompose() {
        Function<Integer, Integer> f = i -> i + 1;
        Function<Integer, Integer> g = i -> i * 2;
        Function<Integer, Integer> h = f.andThen(g); //f(g(x))
        Function<Integer, Integer> s = f.compose(g);// g(f(x))
        System.out.println("f(g(x)):\t" + h.apply(5));
        System.out.println("g(f(x)):\t" + s.apply(5));
    }

    // 测试 算子Operator  UnaryOperator和BinaryOperator。分别对应单元算子和二元算子
    private static void testOperator() {
        UnaryOperator<Integer> add = x -> x + 1;
        BinaryOperator<Integer> multiply = (a, b) -> a * b;

        System.out.println("相加算子计算: " + add.apply(3));
        System.out.println("相加算子计算: " + multiply.apply(2, 6));
    }


    // 测试 谓词函数Predicate 返回值是Boolean 其默认方法也封装了and、or和negate逻辑
    private static void testPredicate() {
        Predicate<Integer> predicate = v -> v > 7;
        // BiPredicate
        BiPredicate<Integer, String> biPredicate = (a, b) -> a > 10 || b.equals("limb");
        if (predicate.test(10)){
            System.out.println("测试大于10的数...");
        }
        if (biPredicate.test(10, "limb")){
            System.out.println("测试大于10的数或者limb...");
        }
    }

    // 测试 Consumer<T> 无需定义返回类型
    private  static void testConsumer(){
        Consumer<String> consumer = System.out::println;
        consumer.accept("limaob");
    }


    // 测试 Supplier<T> 生成能力
    private static void  testSupplier(){
        Supplier<Person> supplier = Person::new;
        // 生成一个对象
        Person person = supplier.get();
    }
}
