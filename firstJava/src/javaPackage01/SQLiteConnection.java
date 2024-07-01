package javaPackage01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteConnection {
	
	Private Connection conn = null;
    
	// Method to connect to SQLite database
    public static void connectDB() {
        try {
            // Database parameters
            String url = "jdbc:sqlite:db/atm.db";
            // Create a connection to the database
            this.conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Method to create a new table
    public static void createNewTable() {
    	
    	//create a connection to DB
    	connectDB();
    	
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS users (\n"
                + " id integer PRIMARY KEY,\n"
                + " name text NOT NULL,\n"
                + " balance real\n"
                + ");";

        try (Statement stmt = this.conn.createStatement()) {
            // Create a new table
            stmt.execute(sql);
            System.out.println("Table has been created.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally{
        	// close the DB connection
        	this.conn.close();
        }
    }

    // Method to insert data into the table
    public static void insertData(String[] info) {
    	
    	// create a connection to DB
    	connectDB();
    	
		StringBuilder sql = new StringBuilder();
		
		// create a sql statement
		sql = "INSERT INTO userInformation(userID, userPASSWORD) VALUES('";
				
    	for (int i = 0; i<info.length; i++) {
    	
    		sql.append(info[i]);
    		
    		if(i != info.length - 1) {
    			sql.append("', '");
    		}
    		
    	}
    	
		sql.append("')");
        
        try (Statement stmt = this.conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Data has been inserted.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally{
        	// close the DB connection
        	this.conn.close();
        }
    }

}

