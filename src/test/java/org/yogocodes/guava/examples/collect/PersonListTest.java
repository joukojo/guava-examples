package org.yogocodes.guava.examples.collect;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class PersonListTest {

	@Test
	public void testPersonList() throws Exception {
		PersonList personList = new PersonList(createPersonnelList());
		
		Assert.assertFalse("person list is empty", personList.isEmpty());
		
		
	}

	@Test
	public void testSortById() throws Exception {
		PersonList shuffedList = createShuffledPersonList();
		
		PersonList sortById = shuffedList.sortById();
		// check that the list is a copy
		Assert.assertNotEquals(shuffedList, sortById);
		Assert.assertEquals("id is not 0", 0, sortById.get(0).getId());

	}

	@Test
	public void testSortByFirstName() throws Exception {
		
		PersonList personList = createShuffledPersonList();
		PersonList byFirstName = personList.sortByFirstName();
		
		// check that the list is a copy
		Assert.assertNotEquals(personList, byFirstName);
		Assert.assertEquals("id is not 0", 0, byFirstName.get(0).getId());
		
		
	}

	private PersonList createShuffledPersonList() {
		PersonList personList = new PersonList(createPersonnelList());
		Collections.shuffle(personList);
		return personList;
	}

	@Test
	public void testFilterByIdList() throws Exception {
		PersonList personList = new PersonList(createPersonnelList());
		
		Integer integers[] = {1,2,3,4, 200, 211};
		PersonList filterByIdList = personList.filterByIdList(integers);
		
		Assert.assertEquals("size differs", integers.length, filterByIdList.size());
	}

	
	private static List<Person> createPersonnelList() {
		List<Person> personnel = new ArrayList<Person>();
		for(int i = 0 ; i < 500 ; i++ ) {
			Person person = new Person(i, "first-" + i, "last-" + i);
			personnel.add(person);
		}
		return personnel;
	}
}
