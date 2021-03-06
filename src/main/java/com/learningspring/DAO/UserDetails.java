package com.learningspring.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class UserDetails {
	
	@Id
	@Column
	private int id;
	
	@Column
	private UserNames userfullname;
	
	@ManyToMany(mappedBy="userDetails",fetch = FetchType.EAGER)
	private List<Laptop> laps = new ArrayList<Laptop>();
	
	public List<Laptop> getLaps() {
		return laps;
	}

	public void setLaps(List<Laptop> laps) {
		this.laps = laps;
	}

	public UserNames getUserfullname() {
		return userfullname;
	}

	public void setUserfullname(UserNames userfullname) {
		this.userfullname = userfullname;
	}

	@Column
	private String name;
	
	@Column
	private String email;



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", userfullname=" + userfullname + ", laps=" + laps + ", name=" + name
				+ ", email=" + email + "]";
	}

	
	
	
}
