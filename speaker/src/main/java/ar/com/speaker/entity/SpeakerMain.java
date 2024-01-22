package ar.com.speaker.entity;

import java.time.LocalDate;

public class SpeakerMain {

	public static void main(String[] args) {
		Speaker speaker = new Speaker("Aldana", "Cassanello", "aldi@email.com", "excel", LocalDate.now());
	
		Speaker speakerFromDB = new Speaker(1L, "Aldana", "Cassanello", "aldi@email.com", "excel", LocalDate.now());
	

	
	}

}
