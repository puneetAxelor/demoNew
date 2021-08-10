/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.yes.app;

import static com.yes.app.MessageUtils.getMessage;
import static com.yes.utilities.StringUtils.join;
import static com.yes.utilities.StringUtils.split;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.text.WordUtils;

import com.yes.list.LinkedList;
import com.yes.utilities.Employee;
import com.yes.utilities.Sample;
import com.yes.utilities.Student;
import com.yes.utilities.Test;
import com.yes.utilities.defo;
import com.yes.utilities.funcInter;
import com.yes.utilities.functional;
import com.yes.utilities.inter;
import com.yes.utilities.interf;

public class App implements defo {
    public static void main(String[] args) {
    	
    	Student stu[] = {
    			new Student("first", 90),
    			new Student("third", 50),
    			new Student("second", 40),
    			new Student("fourth", 80),
    			new Student("fifth", 20)
    	};
        
    	
    	List<Integer> list = new ArrayList<>();
    	list.add(0);
    	list.add(25);
    	list.add(30);
    	list.add(10);
    	list.add(15);
    	list.add(20);
    	list.add(45);
    	
    	ArrayList<Employee> al = new ArrayList<>();
    	al.add(new Employee("A", 1000));
    	al.add(new Employee("B", 2000));
    	al.add(new Employee("C", 3000));
    	al.add(new Employee("D", 4000));
    	al.add(new Employee("E", 5000));
    	al.add(new Employee("F", 6000));
    	
    	ArrayList<String> ar = new ArrayList<>();
		ar.add("John Doe");
		ar.add("Mary Jane");
		ar.add("Kya Bola");
		ar.add("Peter Parker");
		ar.add("Sooby Doo");
		ar.add("SpiderMan");
		ar.add("Neen Yaru");
		ar.add("New One");
		
		Comparator<String> c = (st1, st2) -> {
			int l1  = st1.length();
			int l2 = st2.length();
			
			if (l1 < l2) return -1;
			else if (l1 > l2) return 1;
			else return st1.compareTo(st2);
		};
    	
    	
    	
    	LinkedList tokens;      
        tokens = split(getMessage());
        String result = join(tokens);
        System.out.println(WordUtils.capitalize(result));
        
        // Stream forEach
        list.stream().forEach(i->{
        	System.out.println("The square of "+i+" is "+i*i);
        });
        
        // Stream toArray
        Integer[] OtoA = list.stream().toArray(Integer[]::new);
        System.out.println("Object to Array from Stream");
        for (Integer I :OtoA) {
        	System.out.print(I +" ");
        }
        
        // Object to Stream
        System.out.println("\nObject to Stream");
        Stream.of(OtoA).forEach(System.out::println);
        
        // lambda functional interface
        functional f = () -> System.out.println("Lambda functional interface");
        f.m1();
        
        Runnable r = () -> {
        	for (int i=0; i < 10; i++) {
        		System.out.println("Child Thread");
        	}
        };
        
        Thread t = new Thread(r);
        t.start();
        
        for (int i=0; i < 10; i++) {
        	System.out.println("Main Thread");
        }
        
        // Method Reference
        Runnable r1 = Test::m5;
        Thread t1 = new Thread(r1);
        t1.start();
        
        Test app = new Test();
        Runnable r2 = app::m6;
        Thread t2  = new Thread(r2);
        t2.start();
        
        funcInter de = Test::sum;
        de.add(100, 200);
        
        // Constructor Reference
        interf itf = Sample::new;
        Sample sam = itf.get();
        
        inter it = Sample::new;
        Sample sa = it.get("Puneet");
        
        // java streams
        List<Integer> arr = list.stream().filter(i->i%2==0).collect(Collectors.toList());
        System.out.println(arr);
        
        List<Integer> l1 = list.stream().map(i->i*2).collect(Collectors.toList());
        System.out.println(l1);
        
        long count = list.stream().filter(i->i>25).count();
        System.out.println("Count of output "+count);
        
        List<Integer> l2 = list.stream().sorted().collect(Collectors.toList());
        System.out.println("Sorted with stream "+l2);
        
        List<Integer> l3 = list.stream().sorted((i1,i2)-> (i1<i2)?1:(i1>i2)?-1:0).collect(Collectors.toList());
        System.out.println("Customized Sorting "+l3);
        
        List<String> l4 = ar.stream().sorted(c).collect(Collectors.toList());
        System.out.println("Sort by length of string "+l4);
        
        Integer min = list.stream().min((i1,i2) -> i1.compareTo(i2)).get();
        Integer max = list.stream().max((i1, i2) -> i1.compareTo(i2)).get();
        System.out.println("Min value "+min);
        System.out.println("Max value "+max);
        
        
        // Predicate
        String s[] = {"AB", "BCD", "GFDA", "OT", "POQWRT", "REST"};
        
        Predicate<String> p2 = s1 -> s1.length()%2 ==0;
        Predicate<String> p3 = s1 -> s1.length() > 3;
        
        for(String s1: s) {
        	if (p2.and(p3).test(s1)) {
        		System.out.println(s1);
        	}
        }
        
        Predicate<Employee> p1 = e -> e.getSalary()>3000;
        
        for(Employee e1: al) {
        	if(p1.negate().test(e1)) {
        		System.out.println(e1.getName()+":"+e1.getSalary());
        	}
        }
        
        // BiPredicate
        
        BiPredicate<Integer, Integer> bip = (a, b) -> (a + b) % 2 == 0;
        
        System.out.println("Sum is even: "+bip.test(10, 20));
        
        // Int, Double, Long Predicate (no need for autoboxing, unboxing)
        int []arr1 = { 10, 5, 30, 25, 70, 45, 80};
        
        IntPredicate pr1 = pre -> pre % 2 ==0;
        System.out.println("Using IntPredicate");
        for (int i: arr1) {
        	if (pr1.test(i)) {
        		System.out.println(i);
        	}
        }
        
        // FUNCTION FUNCTIONAL INTERFACE
        
        Predicate<Student> pr = p -> p.getMarks() > 60;
        
        Function<Student ,String> fun = q -> {
        	int marks = q.getMarks();
        	String grade ="";
        	if (marks > 80) grade = "A{Distinction]";
        	else if (marks>60) grade = "B[first class]";
        	else if (marks >50) grade = "C";
        	else if (marks > 40) grade = "D";
        	else grade = "F[Fail]";
        	return grade;
        };
        
        // Supplier
        
        Supplier<Date> sup = () -> new Date();
        System.out.println(sup.get());
        
        Supplier<String> supOtp = () -> {
        	String otp = "";
        	for (int i=0; i  < 6; i++) {
        		otp += (int)(Math.random() * 10);
        		
        	}
        	
        	return otp;
        };
        
        System.out.println("OTP: "+supOtp.get());
        
        
        // Consumer
        
        Consumer<Student> con = k -> {
        	if (pr.test(k)) {
	        	System.out.println("Name: "+k.getName());
	        	System.out.println("Marks: "+k.getMarks());
	        	System.out.println("Grade: "+fun.apply(k));
	        	System.out.println();
        	}
        };
        
        for (Student s1 : stu) {
        	con.accept(s1);
        }
        
        
        
        // Default and static methods
       
        
        
        System.out.println(defo.add(5, 2));
        
        
    }
    
    

	@Override
	public void m3() {
		System.out.println("m3 method");
		
	}

	@Override
	public void m4() {
		System.out.println("m4 method");
	}
}
