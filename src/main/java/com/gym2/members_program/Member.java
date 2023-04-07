package com.gym2.members_program;



import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
@Table(name = "members")
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "first_name")
	private String first_name;
	
	@Column(name = "last_name")
	private String last_name;
	
	@Column(name = "age")
	private int age;

	@Column(name = "date_registered")
	@Temporal(TemporalType.DATE)
	private Date dateOfRegistered;
	
	@Column(name = "gym_membership")
	private int gym_membership;
	
	@Column(name = "expired_date")
	@Temporal(TemporalType.DATE)
	private Date expired_date;
	
	/*
	 * polla members se ena Program plan
	 * */
	@ManyToOne
    @JoinColumn(name="program_id")
	private Program program;
	
	public Member() {
		super();
	}



	public Member(String first_name, String last_name, int age, Date dateOfRegistered, int gym_membership,
			Date expired_date) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.age = age;
		this.dateOfRegistered = dateOfRegistered;
		this.gym_membership = gym_membership;
		this.expired_date = expired_date;
	}



	/*
	 * gym charge(analoga to programma)...
	 * */




	public void setId(int id) {
		this.id = id;
	}


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public Date getDateOfRegistered() {
		return dateOfRegistered;
	}


	public void setDateOfRegistered(Date dateOfRegistered) {
		this.dateOfRegistered = dateOfRegistered;
	}

	public int getGym_membership() {
		return gym_membership;
	}





	public void setGym_membership(int gym_membership) {
		this.gym_membership = gym_membership;
	}





	public Date getExpired_date() {
		return expired_date;
	}





	public void setExpired_date(Date expired_date) {
		this.expired_date = expired_date;
	}
	public int getId() {
		return id;
	}

	public Program getProgram() {
		return program;
	}
	
	public int getProgram_id() {
		return this.program.getId();
	}

	public void setProgram(Program program) {
		this.program = program;
	}
	
	@Override
	public String toString() {
		return "Member [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", age=" + age
				+ ", dateOfRegistered=" + dateOfRegistered + "]";
	}
	
	
	
}