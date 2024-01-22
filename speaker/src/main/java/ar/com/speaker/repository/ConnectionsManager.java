package ar.com.speaker.repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionsManager {
	
	public static Connection getConnection() {
		
		String host = "localhost";
		String username = "root";
		String password = "1234";
		String port = "3307";
		String dbName = "SPEAKER_DB";
		String dbUrl = "jdbc:mysql://"+host+":"+port+"/"+dbName + "?allowPublicKeyRetrieval=true&serverTimeZone=UTC&useSSL=false";
		String driver = "com.mysql.cj.jdbc.Driver";
		
		try { 
			Class.forName(driver);
			return DriverManager.getConnection(dbUrl, username, password);
		} catch (Exception e) {
			throw new IllegalArgumentException("No se pudo obtener conexion: " + dbUrl + " - " + driver);
		}
		
	}

}
