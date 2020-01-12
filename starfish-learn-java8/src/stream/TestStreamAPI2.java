package stream;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import lambda.Person;
import org.junit.Test;


/*
 * 一、 Stream 的操作步骤
 * 
 * 1. 创建 Stream
 * 
 * 2. 中间操作
 * 
 * 3. 终止操作
 */
public class TestStreamAPI2 {

	List<Person> persons = Person.createRoster();
	
	//3. 终止操作
	/*
		allMatch——检查是否匹配所有元素
		anyMatch——检查是否至少匹配一个元素
		noneMatch——检查是否没有匹配的元素
		findFirst——返回第一个元素
		findAny——返回当前流中的任意元素
		count——返回流中元素的总个数
		max——返回流中最大值
		min——返回流中最小值
	 */
	@Test
	public void test1(){
			boolean bl = persons.stream()
				.allMatch((e) -> e.getGender().equals(Person.Sex.FEMALE));
			
			System.out.println("所有成员都为女性吗？"+bl);
			
			boolean bl1 = persons.stream()
				.anyMatch((e) -> e.getGender().equals(Person.Sex.FEMALE));
			
			System.out.println("成员中有女性吗？"+bl1);
			
			boolean bl2 = persons.stream()
				.noneMatch((e) -> e.getGender().equals(Person.Sex.FEMALE));
			
			System.out.println("成员中是不是没有女性？"+bl2);
	}
	
	@Test
	public void test2(){
		Optional<Person> op = persons.stream()
			.sorted(Comparator.comparingInt(Person::getAge))
			.findFirst();
		
		System.out.println("年龄最小的："+op.get());

		
		Optional<Person> op2 = persons.parallelStream()
			.filter((e) -> e.getGender().equals(Person.Sex.MALE))
			.findAny();
		
		System.out.println("随便找个男的："+op2.get());
	}
	
	@Test
	public void test3(){
		long count = persons.stream()
						 .filter((e) -> e.getGender().equals(Person.Sex.FEMALE))
						 .count();
		
		System.out.println("女生的人数："+count);
		
		Optional<Integer> op = persons.stream()
			.map(Person::getAge)
			.max(Integer::compare);
		
		System.out.println("最大年龄："+op.get());
		
		Optional<Person> op2 = persons.stream()
			.min((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge()));
		
		System.out.println("最小年龄成员："+op2.get());
	}
	
	//注意：流进行了终止操作后，不能再次使用
	@Test
	public void test4(){
		Stream<Person> stream = persons.stream()
		 .filter((e) -> e.getGender().equals(Person.Sex.FEMALE));
		
		long count = stream.count();
		
		stream.map(Person::getAge)
			.max(Integer::compare);
	}
}
