package com.in28minutes.learnspringboot.examples.a7.springannotations;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
//@Component
public class MySQLDataService implements DataService {

	@Override
	public int[] retrieveData() {
		return new int[] { 1, 2, 3, 4, 5 };
	}

}
