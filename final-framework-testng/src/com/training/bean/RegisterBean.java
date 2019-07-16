package com.training.bean;

public class RegisterBean {
	private String firstName;
	private String lastName;
	private String email;
	private String telephone;
	private String address1;
	private String address2;
	private String city;
	private String postalcode;
	private String country;
	private String region;
	private String password;
	private String confirmpassword;
	

	public RegisterBean() {
	}

	public RegisterBean(String firstName, String lastName, String email, String telephone, String address1, String address2, String city, String postalcode, String country, String region, String password, String confirmpassword) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.telephone = telephone;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.postalcode = postalcode;
		this.country = country;
		this.region = region;
		this.password = password;
		this.confirmpassword = confirmpassword;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmpassword() {
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}

	

	@Override
	public String toString() {
		return "LoginBean [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email +", telephone=" + telephone +", address1 =" +address1+ ",address2=" +address2 +", City= "+city+ ",Postal Code = " +postalcode+ ",Country = " +country+ ",Region = " +region+ ",Password = " +password+ ",Confirm Password = " +confirmpassword+"]";
	}

}
