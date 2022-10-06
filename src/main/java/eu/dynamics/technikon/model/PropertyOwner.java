package eu.dynamics.technikon.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Where;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
@Where(clause = "isActive = 1")
public class PropertyOwner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(unique = true)
	private String vatNumber;
	private String name;
	private String surname;
	private String address;
	private String phoneNumber;

	@Column(unique = true)
	private String email;
	private String username;
	private String password;

	@OneToMany(mappedBy = "propertyOwner", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Property> properties = new ArrayList<>();

	private Integer isActive = 1;

	public String getVatNumber() {
		return vatNumber;
	}

	public void setVatNumber(String vatNumber) {
		this.vatNumber = vatNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public List<Property> getProperties() {
		return properties;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "PropertyOwner [id=" + id + ", vatNumber=" + vatNumber + ", name=" + name + ", surname=" + surname
				+ ", address=" + address + ", phoneNumber=" + phoneNumber + ", email=" + email + ", username="
				+ username + ", password=" + password + ",  ]";
	}

	public Integer isActive() {
		return isActive;
	}

	public void setActive(Integer isActive) {
		this.isActive = isActive;
	}

}
