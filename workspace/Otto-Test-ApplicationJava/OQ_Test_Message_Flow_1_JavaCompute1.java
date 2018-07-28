import java.sql.*;

import com.ibm.broker.javacompute.MbJavaComputeNode;
import com.ibm.broker.plugin.MbElement;
import com.ibm.broker.plugin.MbException;
import com.ibm.broker.plugin.MbMessage;
import com.ibm.broker.plugin.MbMessageAssembly;
import com.ibm.broker.plugin.MbOutputTerminal;
import com.ibm.broker.plugin.MbUserException;
//import com.mysql.jdbc.*;
//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.Statement;


public class OQ_Test_Message_Flow_1_JavaCompute1 extends MbJavaComputeNode {

	public void evaluate(MbMessageAssembly inAssembly) throws MbException {
		MbOutputTerminal out = getOutputTerminal("out");
		MbOutputTerminal alt = getOutputTerminal("alternate");

		MbMessage inMessage = inAssembly.getMessage();

		// create new empty message
		MbMessage outMessage = new MbMessage();
		MbMessageAssembly outAssembly = new MbMessageAssembly(inAssembly,
				outMessage);

		try {
			// optionally copy message headers
			copyMessageHeaders(inMessage, outMessage);
			// ----------------------------------------------------------
			// Add user code below

			Connection conn; conn = null;
			Statement stmt; stmt = null;
			ResultSet srs0; srs0 = null;
			
			 try {
		        // Obtain a java.sql.Connection using a JDBC Type4 datasource - in this example for a 
		        // JDBC broker configurable service called "MyDB2"  

		        conn = getJDBCType4Connection("mysql_integration",
		                     JDBC_TransactionType.MB_TRANSACTION_AUTO);

		        // Example of using the Connection to create a java.sql.Statement  
		        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
		                     ResultSet.CONCUR_READ_ONLY);
		        srs0 = stmt.executeQuery("SELECT * FROM integration.genres");    

		        //stmt.executeUpdate("UPDATE MySchema.MyTable SET CITY = \"Springfield\" WHERE Name = \"Bart\"");
		        
		        // Perform other database updates   
		         

		      } catch (SQLException sqx ){
		        sqx.printStackTrace();
		      } finally {
		        // Close the artifacts
		        if (stmt != null) stmt.close();
		        if (srs0 != null) srs0.close();

		        // Clear the outMessage
		        outMessage.clearMessage();
		      }     			
			
			
			
			
			// End of user code
			// ----------------------------------------------------------
		} catch (MbException e) {
			// Re-throw to allow Broker handling of MbException
			throw e;
		} catch (RuntimeException e) {
			// Re-throw to allow Broker handling of RuntimeException
			throw e;
		} catch (Exception e) {
			// Consider replacing Exception with type(s) thrown by user code
			// Example handling ensures all exceptions are re-thrown to be handled in the flow
			throw new MbUserException(this, "evaluate()", "", "", e.toString(),
					null);
		}
		// The following should only be changed
		// if not propagating message to the 'out' terminal
		out.propagate(outAssembly);
	}

	public void copyMessageHeaders(MbMessage inMessage, MbMessage outMessage)
			throws MbException {
		MbElement outRoot = outMessage.getRootElement();

		// iterate though the headers starting with the first child of the root
		// element
		MbElement header = inMessage.getRootElement().getFirstChild();
		while (header != null && header.getNextSibling() != null) // stop before
																	// the last
																	// child
																	// (body)
		{
			// copy the header and add it to the out message
			outRoot.addAsLastChild(header.copy());
			// move along to next header
			header = header.getNextSibling();
		}
	}

}
