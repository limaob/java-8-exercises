package open.maob.optional.example;

import java.util.Optional;

/**
 * @Description: Optional<T> 相关使用方式  很好的解决空指针异常
 * @Author: limaob
 * @CreateDate: 2019/1/4
 */
public class OptionalInstance {

    public static void main(String[] args) {
        // of 与 ofNullable
        testOfAndOfNullable();

        // empty null包装成Optional对象 并且都相等
        testEmpty();

        // isPresent  Optionla对象是否存在
        testIsPresent();

        // ifPresent(Consumer consumer) 保存的值不是null，则调用consumer对象
        testIfPresent();

        // orElse(),如果optional对象保存的值不是null，则返回原来的值，否则orElse方法将传入的T作为默认值返回
        testOrElse();

        // orElseGet(Supplier supplier),orElseGet与orElse方法类似，区别在于得到的默认值。
        // orElseGet方法可以接受Supplier函数接口的实现来生成默认值。
        testOrElseGet();

        // filter(Predicate predicate) Optional对象值存在，并且这个值匹配给定的 函数式接口Predicate，返回一个Optional用以描述这个值。可以看作是一种校验
        testFilter();

        // map(Function function)
        testMap();

        // flatMap(Function function)
        testFlatMap();
    }

    /**
     *  flatMap(Function function)
     *  flatMap方法与map方法类似，区别在于mapping函数的返回值不同。
     *  map方法的mapping函数返回值可以是任何类型T，在map函数返回之前会包装为Optional。
     *  但flatMap方法中的lambda表达式返回值必须是Optional实例。
     */
    private static void testFlatMap() {
        Optional<Integer> optional1 = Optional.ofNullable(1);

        //flatMap与map（Function）非常类似，区别在于传入方法的lambda表达式的返回类型。
        //map方法中的lambda表达式返回值可以是任意类型，在map函数返回之前会包装为Optional。
        Optional<String> strOptional1 = optional1.map((a) -> "after map deal value1 is " + a);
        Optional<Optional<String>> strOptional2 = optional1.map((a) -> {
            return Optional.<String>of("after map deal value2 is " + a);
        });

        //但flatMap方法中的lambda表达式返回值必须是Optionl实例。
        Optional<String> str3Optional = optional1.flatMap((a) -> {
            return Optional.<String>of("after flatMap deal value3 is " + a);
        });

        System.out.println(strOptional1.get());// after map deal value1 is 1
        System.out.println(strOptional2.get().get());// after map deal value2 is 1
        System.out.println(str3Optional.get());// after flatMap deal value3 is 1
    }

    /**
     * map(Function function)：
     * 如果有值，则对其执行调用mapping函数得到返回值。
     * 如果返回值不为null，则创建包含mapping返回值的Optional作为map方法返回值，否则返回空Optional。
     */
    private static void testMap() {
        Optional<Integer> optional1 = Optional.ofNullable(1);
        Optional<Integer> optional2 = Optional.ofNullable(null);

        //map方法执行传入的lambda表达式参数对Optional实例的值进行修改。
        //为lambda表达式的返回值创建新的Optional实例作为map方法的返回值。
        Optional<String> str1Optional = optional1.map((a) -> "key1 is " + a);
        Optional<String> str2Optional = optional2.map((a) -> "key2 is " + a);  // 不修改

        System.out.println(str1Optional.get());// key1 is 1
        System.out.println(str2Optional.isPresent());// false
    }

    /**
     * filter(Predicate predicate)
     * Optional对象值存在，并且这个值匹配给定的 函数式接口Predicate，返回一个Optional用以描述这个值。
     * 可以看作是一种校验
     */
    private static void testFilter() {
        Optional<Integer> optional1 = Optional.ofNullable(1);
        Optional<Integer> optional2 = Optional.ofNullable(null);

        Optional<Integer> filter1 = optional1.filter((a) -> a == null); // 不存在
        Optional<Integer> filter2 = optional1.filter((a) -> a == 1);    // 1
        Optional<Integer> filter3 = optional2.filter((a) -> a == null); // null
        System.out.println(filter1.isPresent());    // false
        System.out.println(filter2.isPresent());    // true
        System.out.println(filter2.get().intValue() == 1);// true
        System.out.println(filter3.isPresent());    // false
    }

    /**
     * orElseGet(Supplier supplier),orElseGet与orElse方法类似，区别在于得到的默认值
     * orElseGet方法可以接受Supplier函数接口的实现来生成默认值。
     */
    private static void testOrElseGet() {
        Optional<Integer> optional1 = Optional.ofNullable(1);
        Optional<String> optional2 = Optional.ofNullable(null);
        System.out.println(optional1.orElseGet(() -> 1000) == 1); // true
        System.out.println(optional2.orElseGet(() -> "test null..."));    // test null
    }

    /**
     * orElse(),如果optional对象保存的值不是null，则返回原来的值，否则orElse方法将传入的T作为默认值返回
     */
    private static void testOrElse() {
        Optional<Integer> optional1 = Optional.ofNullable(1);
        Optional<Integer> optional2 = Optional.ofNullable(null);
        // orElse
        System.out.println(optional1.orElse(1000) == 1);    // true
        System.out.println(optional2.orElse(1000) == 1000); // true
    }

    /**
     * ifPresent(Consumer consumer) 保存的值不是null，则调用consumer对象
     */
    private static void testIfPresent() {

        Optional<String> optional1 = Optional.ofNullable("test");
        Optional<Integer> optional2 = Optional.<Integer>empty();
        optional1.ifPresent(System.out::println);   // test
        optional2.ifPresent(x -> System.out.println("null"));   // 不执行
    }

    /**
     * 测试 isPresent  Optionla对象是否存在
     */
    private static void testIsPresent() {
        Optional<String> optional1 = Optional.ofNullable("test");
        Optional<Integer> optional2 = Optional.<Integer>empty();
        System.out.println(optional1.isPresent());  // true
        System.out.println(optional2.isPresent());  // false
    }

    // 测试 empty null包装成Optional对象 并且都相等
    private static void testEmpty() {
        Optional<Integer> optional1 = Optional.ofNullable(null);
        Optional<Integer> optional2 = Optional.ofNullable(null);
        System.out.println(optional1 == optional2);// true
        System.out.println(optional1 == Optional.<Integer>empty());// true

        Object o1 = Optional.<Integer>empty();
        Object o2 = Optional.<String>empty();
        System.out.println(o1 == o2);// true
    }


    // 测试 of 与 ofNullable
    private static void testOfAndOfNullable() {
        // of方法 参数不可以是null
        Optional<Integer> optional1 = Optional.of(1);
        // ofNullable方法  参数即可以是null
        Optional<Integer> optional2 = Optional.ofNullable(null);

        System.out.println("optional1 is " + optional1); // Optional[1]
        System.out.println("optional2 is " + optional2); // Optional.empty
    }


}
