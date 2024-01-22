package ar.com.speaker.repository;

import java.util.List;

import ar.com.speaker.entity.Speaker;

public interface SpeakerRepository {
	
	public void save(Speaker speaker);
	public Speaker getById(Long id);
	public void update(Speaker speaker);
	public void delete(Long id);
	public List<Speaker> findAll();

}
