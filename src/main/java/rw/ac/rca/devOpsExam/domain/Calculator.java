package rw.ac.rca.devOpsExam.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Calculator {
	@Id
	@GeneratedValue
	private long id;
	
	public Calculator() {
		super();
	}


	public Calculator(long id) {
		super();
		this.id = id;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
