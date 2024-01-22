package ar.com.speaker.controllers;

public class SpeakerRequest {
	
	private String name;
	private String surname;
	private String topic;
	private String email;
	
	public SpeakerRequest() {
		
	}

	public SpeakerRequest(String name, String surname, String topic, String email) {
		super();
		this.name = name;
		this.surname = surname;
		this.topic = topic;
		this.email = email;
	}
	
	

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getTopic() {
		return topic;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "SpeakerRequest [name=" + name + ", surname=" + surname + ", topic=" + topic + ", email=" + email + "]";
	}
	
	
	
}
