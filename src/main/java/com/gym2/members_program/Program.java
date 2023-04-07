package com.gym2.members_program;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "program")
public class Program {
	@Column(name = "name")
	private String name;
	
	@Column(name = "price")
	private int price;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/*
	 * fk gia to table member*/
	@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="program_id")
	private List<Member> members;
	
	public Program() {
		super();
		this.members = new ArrayList<Member>();
	}

	public Program(String name, int price) {
		super();
		this.name = name;
		this.price = price;
		this.members = new ArrayList<Member>();
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	/*
	 * add a member to this program
	 * */
	public void addMember(Member member) {
		this.members.add(member);
	}

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

	/*
	@Override
	public String toString() {
		return "[name=" + name + ", price=" + price + "]";
	}*/
	
	public String toString() {
		return "{ "+this.name+" }";
	}
	
}
