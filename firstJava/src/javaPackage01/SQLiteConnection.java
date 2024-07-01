package javaPackage01;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public final class SQLiteConnection {
	
	// Method to connect to SQLite database
    public static Connection connectDB(){
        
    	Connection con = null;
    	try {
            // Database parameters
//    		String dbPath = "db/atm.db"; // Relative path
//            String absolutePath = new File(dbPath).getAbsolutePath();
//            String url = "jdbc:sqlite:" + absolutePath;
    		// Load the SQLite JDBC driver (necessary for some setups)
            
			Class.forName("org.sqlite.JDBC");
			
    		String url = "jdbc:sqlite:db/atm.db";
            

            // Create a connection to the database
            con = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return con;
    }

    // **not necessary for now**Method to create a new table
    public static void createNewTable() {
    	
    	//create a connection to DB
    	Connection con = connectDB();
    	
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS users (\n"
                + " id integer PRIMARY KEY,\n"
                + " name text NOT NULL,\n"
                + " balance real\n"
                + ");";

        try (Statement stmt = con.createStatement()) {
            // Create a new table
            stmt.execute(sql);
            System.out.println("Table has been created.");
            // close the DB connection
        	con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Method to insert data into the table
    public static void insertData(String[] info) {
    	
    	// create a connection to DB
    	Connection con = connectDB();
		StringBuilder sql = new StringBuilder();
		// create a sql statement
		sql.append("INSERT INTO userInformation(userID, userPASSWORD) VALUES('");
				
    	for (int i = 0; i<info.length; i++) {
    	    		sql.append(info[i]);
    		if(i != info.length - 1) {
    			sql.append("', '");
    		}
    	}
    	
		sql.append("')");
        
        try (Statement stmt = con.createStatement()) {
            stmt.execute(sql.toString());
            System.out.println("Data has been inserted.");
            // close the DB connection
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}

