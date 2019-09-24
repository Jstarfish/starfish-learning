//package priv.starfish.ProtocolBuffers;
//
//import com.google.protobuf.InvalidProtocolBufferException;
//import org.apache.commons.lang3.StringUtils;
//import priv.starfish.ProtocolBuffers.AddressBookProtos.AddressBook;
//import priv.starfish.ProtocolBuffers.AddressBookProtos.Person;
//
//import java.util.Arrays;
//import java.util.List;
//
///**
// * @author: jiahaixin
// * @date: 2019/7/24 14:39
// * @description:
// */
//public class HelloProto {
//
//    public static void main(String[] args) {
//
//        String aliAccount = "111,222";
//
//        System.out.println(Arrays.asList(StringUtils.strip(aliAccount,",")));
//
//
//        List<String> list = Arrays.asList(StringUtils.split(aliAccount,","));
//
//        System.out.println(list.contains("222"));
//
//        Person person = Person.newBuilder()
//                .setId(123)
//                .setName("starfish")
//                .setEmail("starfish@126.cn")
//                .addPhones(Person.PhoneNumber.newBuilder()
//                        .setType(Person.PhoneType.HOME)
//                        .setNumber("13555555555")
//                        .build())
//                .build();
//
//        System.out.println(person.toString());
//
//        System.out.println(person.isInitialized());
//
//        try {
//            //序列化和反序列化
//            System.out.println(Arrays.toString(person.toByteArray()));
//            System.out.println(person.toByteString());
//            Person newPerson = Person.parseFrom(person.toByteArray());
//            System.out.println(newPerson);
//            newPerson = Person.parseFrom(person.toByteString());
//            System.out.println(newPerson);
//        } catch (InvalidProtocolBufferException e) {
//            e.printStackTrace();
//        }
//
//
//        // 向地址簿添加两条Person信息
//        AddressBook.Builder books = AddressBook.newBuilder();
//        books.addPeople(person);
//        books.addPeople(Person.newBuilder(person).setEmail("xin@163.com")
//                .build());
//        System.out.println("AddressBook对象信息：");
//        System.out.println(books.build());
//
//    }
//}
