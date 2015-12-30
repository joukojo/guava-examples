package org.yogocodes.guava.examples.collect;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Ordering;

public class CollectionFilterExample {
	public static void main(String[] args) {
		filteringExample();
		
		transformGuavaExample();
		
		sortGuavaExample();
		sortingExampleJava8();
	}

	private static void filteringExample() {
		List<Person> personnel = createPersonnelList();
		
		Predicate<Person> filterByIdValue  = new Predicate<Person>() {
			
			public boolean apply(Person input) {
				
				return input.getId() > 100;
			}
		};
		Collection<Person> filtered = Collections2.filter(personnel, filterByIdValue  );
		
		System.out.println(filtered);
		
		// java8 filter 
		Stream<Person> filteredStream = personnel.stream().filter(p -> p.getId() > 100);
		List<Person> streamFiltered = filteredStream.collect(Collectors.toList());
		System.out.println(streamFiltered);
	}

	private static List<Person> createPersonnelList() {
		List<Person> personnel = new ArrayList<Person>();
		for(int i = 0 ; i < 500 ; i++ ) {
			Person person = new Person(i, "first-" + i, "last-" + i);
			personnel.add(person);
		}
		return personnel;
	}
	
	public static void transformGuavaExample() {
		List<Person> personnel = createPersonnelList();
		Function<Person, String> function = sortFunction();
		Collection<String> sortedCollection = Collections2.transform(personnel, function );
		
		System.out.println(sortedCollection);
		
	}
	
	public static void sortGuavaExample() {
		List<Person> personnel = createPersonnelList();

		Collections.sort(personnel, Ordering.natural().onResultOf( new Function<Person, Integer>() {
		      public Integer apply(Person from) {
		          return from.getId();
		        }
		      }));
		
		System.out.println("guava sort" + personnel);
	}

	private static Function<Person, String> sortFunction() {
		return new Function<Person, String>() {
		  public String apply(Person from) {
		    return from.getFirstName();
		  }
		};
	}
	
	public static void sortingExampleJava8() {
		List<Person> personnel = createPersonnelList();
		
		Comparator<Person> idValueComparator = new Comparator<Person>() {
			public int compare(Person o1, Person o2) {
				return Integer.valueOf(o1.getId()).compareTo(Integer.valueOf(o2.getId())); 
				
			};
		};
		Stream<Person> sorted = personnel.stream().sorted(idValueComparator );
		List<Person> sortedList = sorted.collect(Collectors.toList());
		
		System.out.println(sortedList);
		// sort by object property via java8
		personnel.sort(Comparator.comparing(Person::getId));
		
		System.out.println(personnel);
	}
}
