package javaPackage01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteConnection {

    // Method to connect to SQLite database
    public static Connection connect() {
        Connection conn = null;
        try {
            // Database parameters
            String url = "jdbc:sqlite:db/atm.db";
            // Create a connection to the database
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    // Method to create a new table
    public static void createNewTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:db/atm.db";

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS users (\n"
                + " id integer PRIMARY KEY,\n"
                + " name text NOT NULL,\n"
                + " balance real\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // Create a new table
            stmt.execute(sql);
            System.out.println("Table has been created.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Method to insert data into the table
    public static void insertData(String[] info) {
    	
    	String url = "jdbc:sqlite:db/atm.db";
		StringBuilder sql = new StringBuilder();
		
		// create a sql statement
		sql = "INSERT INTO users(name, balance) VALUES('";
				
    	for (int i = 0; i<info.length; i++) {
    		
    		sql.append(info[i]);
    		if(i != info.length - 1) {
    			sql.append(", ");
    		}
    		
    	}
    	
		sql.append("', 1000.0)");
        
        

        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Data has been inserted.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}

