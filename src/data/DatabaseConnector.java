/*
// Subproblem: Define the class and its shared variables.
// We need to store the connection and the file path.
CLASS DatabaseConnector:
    PRIVATE STATIC Connection _connection = null;
    PRIVATE STATIC STRING db_path = "db/MomAndPops.accdb";

    // Subproblem: Create the main function that other classes will call.
    PUBLIC STATIC FUNCTION getConnection():

        // Subproblem: Handle errors, like if the file isn't found.
        TRY:

            // Subproblem: Check if the connection needs to be created.
            // (It's either the first time, or it got closed).
            IF _connection IS NULL OR _connection.isClosed():

                // This is the "why": we need to build it

                // Subproblem 1: Find the database file.
                String absolutePath = new File(db_path).getAbsolutePath();

                // Subproblem 2: Format the path for the UCanAccess driver.
                String connectionString = "jdbc:ucanaccess://" + absolutePath;

                // Subproblem 3: Create the connection and save it.
                _connection = DriverManager.getConnection(connectionString);

            END IF

            // Subproblem: Return the ready-to-use connection.
            RETURN _connection;

        CATCH (SQLException e):
            // Subproblem: Handle errors if anything went wrong.
            PRINT_ERROR("Database connection failed: " + e.getMessage());
            RETURN null;
        END TRY

    END FUNCTION
END CLASS
*/