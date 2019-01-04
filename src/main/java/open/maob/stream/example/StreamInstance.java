package open.maob.stream.example;

import open.maob.model.Person;

import javax.annotation.processing.Filer;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Description: stream 相关测试
 * @Author: limaob
 * @CreateDate: 2019/1/4
 */
public class StreamInstance {

    public static void main(String[] args) {
        // stream的创建方式
        // createStream();

        // stream 只能执行一次
        List<Person> persons = generateData();

        // filter(Predicate<? super T> predicate) 过滤方法
        List<Person> filterList = persons.stream().filter(person -> person.getAge() == 20).collect(Collectors.toList());
        System.out.println("过滤后: " + filterList);

        // distinct() 根据equal方法去重 处理自定义去重，需要重新定义equals和hashcode方法
        List<Integer> distinctList = Arrays.asList(1, 1, 1, 2, 2, 3, 3, 4, 4, 4).stream().distinct().collect(Collectors.toList());
        System.out.println(distinctList + "去重后: " + distinctList);

        // sort(Comparator<? super T> comparator)
        System.out.println("排序前: " + persons);
        List<Person> sortedList = persons.stream().sorted((p1, p2) -> p2.getAge() - p1.getAge()).collect(Collectors.toList());
        ;
        System.out.println("反向排序后: " + sortedList);

        // limit(long p) 获取前p个元素
        List<Person> limitList = persons.stream().limit(2).collect(Collectors.toList());
        System.out.println("限制元素后: " + limitList);

        // skip(long p) 跳过前p个元素
        List<Person> skipList = persons.stream().skip(2).collect(Collectors.toList());
        System.out.println("去除元素后: " + skipList);

        // map(Function<? super T, ? extends R> mapper) 映射元素
        List<String> mapList = persons.stream().map(Person::getName).collect(Collectors.toList());
        System.out.println("映射后的集合: " + mapList);

        // flatMap(Function<? super T, ? extends Stream<? extends R>> mapper) 将流中的每一个元素 T 映射为一个流，再把每一个流连接成为一个流
        List<String> list = new ArrayList<>();
        list.add("aaa bbb ccc");
        list.add("ddd eee fff");
        list.add("ggg hhh iii");
        List<String> flatMapList = list.stream().map(s -> s.split(" ")).flatMap(Arrays::stream).collect(Collectors.toList());
        System.out.println(list + "\t转变流后: " + flatMapList);

        // anyMatch(Predicate<? super T> predicate) 匹配是否有符合条件的元素
        boolean match = persons.stream().anyMatch(person -> person.getAge() == 20);
        System.out.println("是否含有年龄为20的person: " + match);

        // allMatch(Predicate<? super T> predicate) 是否所有元素都匹配条件
        boolean allMatch = persons.stream().allMatch(person -> person.getAge() == 20);
        System.out.println("是否所有年龄都为20: " + allMatch);

        // noneMatch(Predicate<? super T> predicate) 是否所有元素都不匹配条件 与allMatch相反
        boolean noneMatch = persons.stream().noneMatch(person -> person.getAge() == 20);
        System.out.println("是否所有年龄都不为20: " + noneMatch);

        // findAny() 返回值是Optional<T>  找到其中一个元素(使用 stream() 时找到的是第一个元素；使用 parallelStream() 并行时找到的是其中一个元素)
        Optional<Person> personOptional = persons.stream().findAny();
        System.out.println("寻找元素: " + personOptional);

        // findFirst() 找到第一个元素 返回值是Optional<T>
        Optional<Person> personFirst = persons.stream().findFirst();
        System.out.println("寻找第一个元素: " + personFirst);

        // reduce(BinaryOperator<T> accumulator) 和 reduce(T identity, BinaryOperator<T> accumulator)
        // reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner);
        Integer result = persons.stream().map(Person::getAge).reduce(1, (a, b) -> a * b);
        System.out.println("乘积: " + result);
        Optional<Integer> reduce = persons.stream().map(Person::getAge).reduce(Integer::sum);
        System.out.println("求和: " + reduce.get());

        // count() 返回元素个数
        long count = persons.stream().count();


    }

    /**
     * 几种常用的stream的创建方式
     */
    private static void createStream() {
        // 数组创建
        int[] arr = {1, 2, 3};
        IntStream arrStream = Arrays.stream(arr);
        // 集合方式
        List<String> strs = Arrays.asList("11212", "dfd", "2323", "dfhgf");
        Stream<String> strStream = strs.stream();
        // Stream.generate(Supplier s) 无限流 通常用于随机数、常量的 Stream
        Stream.generate(() -> "number" + new Random().nextInt()).limit(4).forEach(System.out::println);
        // Stream. iterate (T seed, UnaryOperator<T> f) 创建规律的无限流
        //通过将seed种子进行函数处理迭代生成无限的流
        Stream.iterate(0, x -> x + 1).limit(3).forEach(System.out::println);
        Stream.iterate(0, x -> x).limit(3).forEach(System.out::println);

    }


    // 生成数据
    private static List<Person> generateData() {
        List<Person> list = new ArrayList<>();
        list.add(new Person("mike", 25));
        list.add(new Person("jack", 20));
        list.add(new Person("tom", 30));
        return list;
    }


}
