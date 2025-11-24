package com.stackunderflow.pizzasystem.data;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {

    // Private variable to hold the single, reusable connection (The Singleton Pattern)
    private static Connection connection = null; 
    // Path to the MS Access file inside the /db folder
    private static final String DB_PATH = "db/MomAndPops.accdb";

    /**
     * Returns a live connection to the MS Access database.
     */
    public static Connection getConnection() throws SQLException {
        // Check if the connection is null or if it was closed.
        if (connection == null || connection.isClosed()) {
            try {
                // 1. Load the UCanAccess driver class (CRITICAL first step for JDBC)
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); 
                
                // 2. Get the absolute path to the database file
                String absolutePath = new File(DB_PATH).getAbsolutePath();

                // 3. Establish the connection using the UCanAccess URL format
                String connectionURL = "jdbc:ucanaccess://" + absolutePath;
                
                connection = DriverManager.getConnection(connectionURL);
                
            } catch (ClassNotFoundException e) {
                // This exception occurs if the UCanAccess JAR files are missing from the classpath.
                System.err.println("Database Driver Error: UCanAccess JARs not found in classpath.");
                throw new SQLException("UCanAccess driver initialization failed.");
            }
        }
        return connection;
    }
}