package com.jellyfish77;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.w3c.dom.Document;

import com.ibm.broker.javacompute.MbJavaComputeNode;
import com.ibm.broker.plugin.MbElement;
import com.ibm.broker.plugin.MbException;
import com.ibm.broker.plugin.MbMessage;
import com.ibm.broker.plugin.MbMessageAssembly;
import com.ibm.broker.plugin.MbOutputTerminal;
import com.ibm.broker.plugin.MbUserException;
import com.ibm.broker.plugin.MbXMLNSC;

public class Movie_JAXB_Map_MF_JavaCompute extends MbJavaComputeNode {

	protected static JAXBContext jaxbContext = null;
	
	public void evaluate(MbMessageAssembly inAssembly) throws MbException {
		MbOutputTerminal out = getOutputTerminal("out");
		// MbOutputTerminal alt = getOutputTerminal("alternate");

		MbMessage inMessage = inAssembly.getMessage();

		// create a new empty output message
		MbMessage outMessage = new MbMessage();
		MbMessageAssembly outAssembly = new MbMessageAssembly(inAssembly,
				outMessage);

		// optionally copy input message headers to the new output
		copyMessageHeaders(inMessage, outMessage);

		try {

			// unmarshal the input message data from the Broker tree into your
			// Java object classes
			Object inMsgJavaObj = jaxbContext.createUnmarshaller().unmarshal(
					inMessage.getDOMDocument());
			
			Movie movieInObj = (Movie) inMsgJavaObj;
			//Movie movieOutObj = new Movie();
			// ----------------------------------------------------------
			// Add user code below

			
			Object outMsgJavaObj = movieInObj;
			
			Document outDocument = outMessage
					.createDOMDocument(MbXMLNSC.PARSER_NAME);
			// marshal the new or updated output Java object class into the Broker tree
			jaxbContext.createMarshaller().marshal(outMsgJavaObj, outDocument);

			// The following should only be changed
			// if not propagating message to the 'out' terminal
			out.propagate(outAssembly);
			
			// End of user code
			// ----------------------------------------------------------
		} catch (JAXBException e) {
			// Example Exception handling	
			throw new MbUserException(this, "evaluate()", "", "", e.toString(),
					null);		
		} catch (MbException e) {
			// Re-throw to allow Broker handling of MbException
			throw e;
		} catch (RuntimeException e) {
			// Re-throw to allow Broker handling of RuntimeException
			throw e;
		} catch (Exception e) {
			// Consider replacing Exception with type(s) thrown by user code
			// Example handling ensures all exceptions are re-thrown to be
			// handled in the flow
			throw new MbUserException(this, "evaluate()", "", "", e.toString(),
					null);
		} finally {
			// clear the outMessage even if there's an exception
			outMessage.clearMessage();
		}

	}

	public void copyMessageHeaders(MbMessage inMessage, MbMessage outMessage)
			throws MbException {
		MbElement outRoot = outMessage.getRootElement();

		// iterate though the headers starting with the first child of the root
		// element and stopping before the last child (message body)
		MbElement header = inMessage.getRootElement().getFirstChild();
		while (header != null && header.getNextSibling() != null) {
			// copy the header and add it to the out message
			outRoot.addAsLastChild(header.copy());
			// move along to next header
			header = header.getNextSibling();
		}
	}

}
