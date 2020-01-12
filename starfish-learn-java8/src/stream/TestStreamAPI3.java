package stream;

import java.util.*;
import java.util.stream.Collectors;

import lambda.Person;
import org.junit.Test;


public class TestStreamAPI3 {

	List<Person> persons = Person.createRoster();
	
	//3. 终止操作
	/*
		归约
		reduce(T identity, BinaryOperator) / reduce(BinaryOperator) ——可以将流中元素反复结合起来，得到一个值。
	 */
	@Test
	public void test1(){
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		Integer sum = list.stream()
			.reduce(0, (x, y) -> x + y);
		
		System.out.println(sum);
		
		System.out.println("----------------------------------------");
		
		Optional<Integer> op = persons.stream()
			.map(Person::getAge)
			.reduce(Integer::sum);
		
		System.out.println("所有成员的年龄和："+op.get());
	}
	
	//需求：搜索名字中 “B” 出现的次数
	@Test
	public void test2(){
		Optional<Integer> sum = persons.stream()
			.map(Person::getName)
			.flatMap(TestStreamAPI1::filterCharacter)
			.map((ch) -> {
				if(ch.equals('B'))
					return 1;
				else 
					return 0;
			}).reduce(Integer::sum);
		
		System.out.println(sum.get());
	}
	
	//collect——将流转换为其他形式。接收一个 Collector接口的实现，用于给Stream中元素做汇总的方法
	@Test
	public void test3(){
		List<String> list = persons.stream()
			.map(Person::getName)
			.collect(Collectors.toList());
		
		list.forEach(System.out::println);
		
		System.out.println("----------------------------------");
		
		Set<String> set = persons.stream()
			.map(Person::getName)
			.collect(Collectors.toSet());
		
		set.forEach(System.out::println);

		System.out.println("----------------------------------");
		
		HashSet<String> hs = persons.stream()
			.map(Person::getName)
			.collect(Collectors.toCollection(HashSet::new));
		
		hs.forEach(System.out::println);
	}
	
	@Test
	public void test4(){
		Optional<Integer> max = persons.stream()
			.map(Person::getAge)
			.collect(Collectors.maxBy(Integer::compare));
		
		System.out.println("最大年龄："+max.get());
		
		Optional<Person> op = persons.stream().min(Comparator.comparingInt(Person::getAge));
		
		System.out.println("最小年龄的成员："+op.get());
		
		Integer sum = persons.stream()
			.collect(Collectors.summingInt(Person::getAge));
		
		System.out.println("所有成员年龄和："+sum);
		
		Long count = persons.stream()
			.collect(Collectors.counting());
		
		System.out.println("成员人数："+count);
		
		IntSummaryStatistics dss = persons.stream()
			.collect(Collectors.summarizingInt(Person::getAge));
		
		System.out.println("最大年龄："+dss.getMax());
	}
	
	//分组
	@Test
	public void test5(){
		Map<Person.Sex, List<Person>> map = persons.stream()
			.collect(Collectors.groupingBy(Person::getGender));
		
		System.out.println("按性别分组："+map);
	}
	
	//多级分组
	@Test
	public void test6(){
		Map<Person.Sex, Map<String, List<Person>>> map = persons.stream()
			.collect(Collectors.groupingBy(Person::getGender, Collectors.groupingBy((e) -> {
				if(e.getAge() >= 60)
					return "老年";
				else if(e.getAge() >= 35)
					return "中年";
				else
					return "成年";
			})));
		
		System.out.println(map);
	}
	
	//分区
	@Test
	public void test7(){
		Map<Boolean, List<Person>> map = persons.stream()
			.collect(Collectors.partitioningBy((e) -> e.getAge() >= 50));
		
		System.out.println(map);
	}
	
	//
	@Test
	public void test8(){
		String str = persons.stream()
			.map(Person::getName)
			.collect(Collectors.joining("," , "----", "----"));
		
		System.out.println(str);
	}
	
	@Test
	public void test9(){
		Optional<Integer> sum = persons.stream()
			.map(Person::getAge)
			.collect(Collectors.reducing(Integer::sum));
		
		System.out.println(sum.get());
	}
}
