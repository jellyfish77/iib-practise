# Integration services (SOAP/HTTP inputs)

## OVERVIEW

This tutorial demonstrates a simple integration service with a SOAP/HTTP binding. The integration service converts temperatures from Celsius to Fahrenheit, or from Fahrenheit to Celsius, by using request-response operations.

In IBM Integration Bus, an integration service is a specialized application with a defined interface that acts as a container for a web services solution. The service interface is specified in a WSDL document that contains the operation and fault definitions. Each service operation and error handler is implemented as a subflow in the integration service.

You will import the integration service to your Integration Toolkit workspace, and invoke the integration service to send a SOAP request by using the Flow exerciser.

## Tutorial Topics

- Integration services
- SOAP/HTTP web services
- Transformation using graphical data mapping

## Learning outcomes

- Use IBM Integration Bus to create and invoke a SOAP/HTTP request-response web service.

## Follow these steps to complete the tutorial

The Temperature Converter integration service is shown in the Application Development view of your workspace.

1. Open the Integration Service Description of the TemperatureConverter service, and click the Start Flow exerciser icon  to start recording the message path through the integration service.
2. Click the Send Message icon  and create a new input message.
3. Choose the CtoF SOAP operation, edit the message data if you like, and click Send. Your request message is sent to the integration service SOAP input.

After the request message is processed by the integration service, the message path is automatically highlighted on the service description diagram.

- Click on the highlighted operation to see the message path through the operation subflow.
- You can click on any connection to see the data that passed through that connection. You can see that the request (input) message data shows the temperature in Celsius in the TemperatureInC XML element, and the response (output) message has converted this to a TemperatureInF XML element.

To stop recording the message path through the flow, click the Return flow to edit mode icon Return flow to edit mode.

## WSDL

http://192.168.1.103:7800/TemperatureConverter/TemperatureConverter?wsdl