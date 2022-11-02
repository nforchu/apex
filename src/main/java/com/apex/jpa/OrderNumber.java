package com.apex.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;


@Entity
@SequenceGenerator(name = "order_numbers_sequence", initialValue = 1, allocationSize = 1)
public class OrderNumber {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_numbers_sequence")
	private long id;
}
