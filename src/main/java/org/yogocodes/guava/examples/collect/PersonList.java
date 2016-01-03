package org.yogocodes.guava.examples.collect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersonList extends ArrayList<Person> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PersonList(List<Person> persons) {
		super(persons);
	}
	
	public PersonList sortById() {
		PersonList personList = new PersonList(this);
		
		personList.sort(Comparator.comparing(Person::getId));
		
		return personList;
	}
	
	public PersonList sortByFirstName() {
		PersonList personList = new PersonList(this);
		personList.sort(Comparator.comparing(Person::getFirstName));
		
		return personList;
		
	}
	
	public PersonList filterByIdList(Integer ...integers ) {
		List<Integer> idList = Arrays.asList(integers);
		PersonList personList = new PersonList(this);
		Stream<Person> filteredStream = personList.stream().filter(p -> {
			return idList.contains(Integer.valueOf(p.getId()));
		});
		
		List<Person> filteredList = filteredStream.collect(Collectors.toList());
		
		
		return new PersonList(filteredList);
		
	}
	
	

}
