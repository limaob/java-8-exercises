package open.maob.function.example;

import open.maob.model.Person;

import java.text.DecimalFormat;
import java.util.function.Function;

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
    }

    // 测试Function<T, R>
    private static void testFuction(){
        Function<Long, String> f = i -> new DecimalFormat("#,###").format(i);
        Person person = new Person(999999L);
        System.out.println("我的存款: " + f.apply(person.getAssets()));
    }

    // 测试Function<T, R>.andThen和Function<T, R>.compose
    private static void andThenAndCompose(){
        Function<Integer, Integer> f = i -> i+1;
        Function<Integer, Integer> g = i -> i*2;
        Function<Integer, Integer> h = f.andThen(g); //f(g(x))
        Function<Integer, Integer> s = f.compose(g);// g(f(x))
        System.out.println("f(g(x)):\t"+h.apply(5));
        System.out.println("g(f(x)):\t"+s.apply(5));
    }

}
