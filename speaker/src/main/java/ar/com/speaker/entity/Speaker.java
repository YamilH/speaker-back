package ar.com.speaker.entity;

import java.time.LocalDate;

public class Speaker {
	
	private Long id;
	private String name;
	private String surname;
	private String topic;
	private String email;
	private LocalDate enrollmentDate;
	
	
	public Speaker(String name, String surname, String topic, String email, LocalDate enrollmentDate) {
		this.name = name;
		this.surname = surname;
		this.topic = topic;
		this.email = email;
		this.enrollmentDate = enrollmentDate;
	}


	public Speaker(Long id, String name, String surname, String topic, String email, LocalDate enrollmentDate) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.topic = topic;
		this.email = email;
		this.enrollmentDate = enrollmentDate;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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

	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}


	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getEnrollmentDate() {
		return enrollmentDate;
	}
	public void setEnrollmentDate(LocalDate enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}


	@Override
	public String toString() {
		return "Speaker [id=" + id + ", name=" + name + ", surname=" + surname + ", topic=" + topic + ", email=" + email
				+ ", enrollmentDate=" + enrollmentDate + "]";
	}
	

}
