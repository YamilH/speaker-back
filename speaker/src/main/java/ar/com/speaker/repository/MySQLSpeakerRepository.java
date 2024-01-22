package ar.com.speaker.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ar.com.speaker.entity.Speaker;
import ar.com.speaker.repository.ConnectionsManager;

public class MySQLSpeakerRepository implements SpeakerRepository {

	@Override
	public void save(Speaker speaker) {
		String sql = "insert into speaker (name, surname, topic, email, enrollment_date) values (?,?,?,?,?)";
		try {
			Connection conn = ConnectionsManager.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			statement.setString(1, speaker.getName());
			statement.setString(2, speaker.getSurname());
			statement.setString(3, speaker.getTopic());
			statement.setString(4, speaker.getEmail());
			statement.setDate(5, new java.sql.Date(System.currentTimeMillis()));
			statement.executeUpdate();
		}catch (Exception e) {
			throw new IllegalArgumentException("Can't create product", e);
		}
	}

	@Override
	public Speaker getById(Long id) {
		String sql = "select id, name, surname, topic, email, enrollment_date from speaker where id = ?";
		Speaker speaker = null;
		try {
			Connection conn = ConnectionsManager.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, id);
			ResultSet res = statement.executeQuery();
			if(res.next()) {
				Long _id = res.getLong(1);
				String name = res.getString(2);
				String surname = res.getString(3);
				String topic = res.getString(4);
				String email = res.getString(5);
				Date enrollmentDate = res.getDate(6);
				
				speaker = new Speaker(id, name, surname, topic, email, LocalDate.now());
			}
			
		}catch (Exception e) {
			throw new IllegalArgumentException("Can't reach speaker", e);
		}
		return speaker;
	}

	@Override
	public void update(Speaker speaker) {
		String sql = "update speaker "
				+ "set name=?, surname=?, topic=?, email=? "
				+ "where id = ?";
		try {
			Connection conn = ConnectionsManager.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, speaker.getName());
			statement.setString(2, speaker.getSurname());
			statement.setString(3, speaker.getTopic());
			statement.setString(4, speaker.getEmail());
			statement.setLong(5, speaker.getId());
			
			statement.executeUpdate();
		}catch(Exception e) {
			throw new IllegalArgumentException("Can't update speaker", e);
		}	
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from speaker where id = ?";
		try {
			Connection conn = ConnectionsManager.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, id);
			statement.executeUpdate();
		}catch(Exception e) {
			throw new IllegalArgumentException("Can't delete speaker", e);
		}	
	}

	@Override
	public List<Speaker> findAll() {
		String sql = "select id, name, surname, topic, email, enrollment_date from speaker";
		List<Speaker> speakers = new ArrayList<>();
		try {
			Connection conn = ConnectionsManager.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet res = statement.executeQuery();
			
			while(res.next()) {
				Long _id = res.getLong(1);
				String name = res.getString(2);
				String surname = res.getString(3);
				String topic = res.getString(4);
				String email = res.getString(5);
				Date enrollmentDate = res.getDate(6);
				
				Speaker product = new Speaker(_id, name, surname, topic, email, LocalDate.now());
				speakers.add(product);
			
			}
			
		}catch (Exception e) {
			throw new IllegalArgumentException("Can't reach speaker", e);
		}
		return speakers;
	}

}
