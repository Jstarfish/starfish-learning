package builder;
import org.junit.Assert;

/**
 * @description:
 * @author: starfish
 * @date: 2021/6/8 21:52
 */
public class User {

    private Long id;
    private String name;
    private Integer age;
    private String desc;

    private User(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.age = builder.age;
        this.desc = builder.desc;
    }

    public static Builder newBuilder(Long id, String name) {
        return new Builder(id, name);
    }

    public Long getId() {return id;}
    public String getName() {return name;}
    public Integer getAge() {return age;}
    public String getDesc() {return desc;}

    @Override
    public String toString() {
        return "Builder{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", desc='" + desc + '\'' +
                '}';
    }

    public static class Builder {
        private Long id;
        private String name;
        private Integer age;
        private String desc;

        private Builder(Long id, String name) {
            Assert.assertNotNull("标识不能为空",id);
            Assert.assertNotNull("名称不能为空",name);
            this.id = id;
            this.name = name;
        }
        public Builder age(Integer age) {
            this.age = age;
            return this;
        }
        public Builder desc(String desc) {
            this.desc = desc;
            return this;
        }
        public User build() {
            return new User(this);
        }

    }

    public static void main(String[] args) {
        User user = User.newBuilder(1L, "alibaba").age(102).desc("test").build();
        System.out.println(user.toString());
    }
}
