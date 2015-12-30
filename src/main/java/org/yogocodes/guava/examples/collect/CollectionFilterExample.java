package org.yogocodes.guava.examples.collect;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;

public class CollectionFilterExample {
	public static void main(String[] args) {
		List<Person> personnel = new ArrayList<Person>();
		for(int i = 0 ; i < 500 ; i++ ) {
			Person person = new Person(i, "first-" + i, "last-" + i);
			personnel.add(person);
		}
		
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
}
