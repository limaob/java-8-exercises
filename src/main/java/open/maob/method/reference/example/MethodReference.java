package open.maob.method.reference.example;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author: limaob
 * @CreateDate: 2019/1/2
 */
public class MethodReference {

    /**
     * 静态方法引用：ClassName::staticMethodName
     * 对象的实例方法引用：Object::instanceMethodName
     * 任意对象的实例方法引用：ClassName::methodName
     * 构造方法引用：Class::new
     */

    public static void main(String[] args) {
        // 静态方法引用
        Supplier<List<Fish>> supplier = MethodReference::creatFishList;
        List<Fish> fishs = supplier.get();
        int i = 9;
        for (Fish fish : fishs) {
            i--;
            fish.setName("name0" + i);
        }
        System.out.println("排序前: " + fishs);
        // 任意对象的实例方法引用
        MethodReference mr = new MethodReference();
        Set<String> set = fishs.stream().map(Fish::getName).collect(Collectors.toSet());
        System.out.println(set);
        // 对象实例方法的引用
        Fish fish = new Fish();
        fishs.sort(fish::compare);
        System.out.println("排序后: " + fishs);
    }

    private static List<Fish> creatFishList() {
        List<Fish> fishs = new ArrayList<>();
        // 构造方法引用
        Supplier<Fish> supplier = Fish::new;
        for (int i = 0; i < 5; i++) {
            fishs.add(supplier.get());
        }
        return fishs;
    }

    static class Fish implements Comparator<Fish> {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public int compare(Fish f1, Fish f2) {
            return f1.getName().compareTo(f2.getName());
        }

        @Override
        public String toString() {
            return "Fish{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }


}
