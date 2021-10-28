package stream;

/**
 * @description:
 * @author: starfish
 * @date: 2021/7/20 11:10
 */
public class Student {

    private int id;
    private String name;
    private int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    //    @Override
//    public int compareTo(Student o) {
//        return name.compareTo(o.getName());
//    }
//
//    @Override
//    public boolean equals(final Object obj){
//        if (null==obj){
//            return false;
//        }
//
//        final Student std= (Student) obj;
//        if (this==std){
//            return true;
//        }else {
//            return (this.name.equals(std.getName())) && (this.age==std.getAge());
//        }
//    }
//
//    @Override
//    public int hashCode(){
//        int hashno=7;
//        hashno=13*hashno+(name==null?0:name.hashCode());
//        return hashno;
//    }
}
