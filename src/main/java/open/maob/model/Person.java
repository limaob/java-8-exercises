package open.maob.model;

/**
 * @Description:
 * @Author: limaob
 * @CreateDate: 2019/1/2
 */
public class Person {

    private String name;
    private Integer age;
    private Long assets;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getAssets() {
        return assets;
    }

    public void setAssets(Long assets) {
        this.assets = assets;
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Person() {

    }

    public Person(String name, Integer age, Long assets) {

        this.name = name;
        this.age = age;
        this.assets = assets;
    }
    public Person(Long assets) {

        this.assets = assets;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", assets=" + assets +
                '}';
    }
}
