/* 
Task: We need a method to register a new user. It needs to check for duplicates, 
 * hash the password, and insert the user's data into the customers table.
 * Plan:
 * We'll create a class with a main public function called registerUser.
 * The function will first call a private helper function, userExists, to check for duplicates.
 * If the user is new, it will hash the password (assuming a PasswordHasher class exists), 
 * and then use an INSERT SQL query to save the data.
 * A status message will be returned based on the operation's success or failure.


// Define the class CustomerDataManager
CLASS CustomerDataManager:

    // --- Main Public Function ---
    PUBLIC FUNCTION registerUser(String username, String password, String firstName, String lastName, String phone):
        
        // Subtask: Check for duplicates using the helper function
        IF userExists(username) == true:
            RETURN "Error: Username already taken";
        END IF

        // Subtask: Hash the password
        String passwordHash = PasswordHasher.hash(password);

        // Subtask: Save the new user to the database
        String sql = "INSERT INTO Customers (Username, Password_Hash, First_Name, Last_Name, Phone_Number) VALUES (?, ?, ?, ?, ?)";
        
        // Subtask: Handle database errors
        TRY (Connection conn = DatabaseConnector.getConnection()):
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, passwordHash);
            pstmt.setString(3, firstName);
            pstmt.setString(4, lastName);
            pstmt.setString(5, phone);
            
            pstmt.executeUpdate(); // This saves the user
            
            RETURN "Success: Account Created!";
            
        CATCH (SQLException e):
            PRINT_ERROR("Sign-up error: " + e.getMessage());
            RETURN "Error: Database problem";
        END TRY
        
    END FUNCTION


    // --- Private Helper Function ---
    PRIVATE FUNCTION userExists(String username):
        // Subtask: Define the query to find the user
        String sql = "SELECT 1 FROM Customers WHERE Username = ?";
        
        // Subtask: Handle database errors
        TRY (Connection conn = DatabaseConnector.getConnection()):
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            
            ResultSet rs = pstmt.executeQuery();
            
            // Subtask: Check if the query returned any results
            // rs.next() is true if a user was found, false if not
            RETURN rs.next(); 
            
        CATCH (SQLException e):
            PRINT_ERROR("userExists check error: " + e.getMessage());
            // Fail-safe: If the check fails, we act as if the user *does* exist
            // to prevent accidentally creating a duplicate.
            RETURN true; 
        END TRY
        
    END FUNCTION

END CLASS
*/