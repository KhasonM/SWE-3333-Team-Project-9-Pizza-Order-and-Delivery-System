/*
 * Task: We need one reliable way to get a databace connection. This prevents our code from being slow, repetitive, and makes our app easier to maintain.
 * Subtask: Define a class and the shared variables.
 * Subtask: We need to store the connection and the file path
 *    Subtask: Create the main function that other classes will call.
 *        Subtask: Handle the errors in a TRY CATCH block that might arise when trying to connect, like if a file isnt found.
 *            Subtask: Check if the connection needs to be created
 *            It either hasnt been created yet, or it was closed.
 * 
 *               Subtask: Find the database file.
 *               Subtask: Format the path for the UCanAccess driver.
 *               Subtask: Create the connection, and save it.
 * 
 *               END IF
 *               the connection is ready to be used.
 *        Subtask: CATCH errors if anything goes wrong.
 *            Print the error message for debugging.
 *            Return null if there was an error
 *        End the TRY CATCH block.
 *   End the main function.
 * End the class.
 */