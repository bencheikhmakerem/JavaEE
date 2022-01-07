package org.makerem.model;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name ="commune")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Access(AccessType.FIELD)
public class Commune {
	
	@XmlElement(name="id")
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name="name",length=80)
	@XmlElement(name="name")

	private String name;
	
	
	
	
	public Commune() {
		super();
	}
	
	public Commune(String name)
	{
		this.name = name;
	}
	
	
	public Commune(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}



	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}



	@Override
	public String toString() {
		return "Commune [id=" + id + ", name=" + name + "]";
	}
	

	
}
