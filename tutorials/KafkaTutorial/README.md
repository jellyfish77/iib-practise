# Kafka Tutorial

## OVERVIEW

This tutorial demonstrates a simple message flow that Produces a message using a KafkaProducer node. A seperate flow then consumes the message using a KafkaConsumer node.

This tutorial requires an Apache kafka server. This could be IBM Bluemix Message hub or your own stand alone server.

In IBM Integration Bus, an application is a container for all the resources that are required to create a solution. An application can contain IBM Integration Bus resources, such as flows, message definitions, libraries, and JAR files. An application is used to hold the message flow in this tutorial.

## Tutorial Topics

- KafkaProducer and KafkaConsumer nodes etc
- Produce a topic message
- Consume a topic message

## Learning outcomes

- Use IBM Integration Bus to produce and consume messages using the KafkaProducer and KafkaConsumer nodes.

## Follow these steps to complete the tutorial

### Start Kafka on Localhost

Start Zookeeper Server:

(Zookeeper is the server cluster manager)

    ./bin/zookeeper-server-start.sh config/zookeeper.properties

Start Kafka Server:

    /bin/kafka-server-start.sh config/server.properties

See: <https://www.youtube.com/watch?v=VbSRS7kG5Cw>

### Configure Flow Nodes

For the Kafka consumer and producer nodes:

- set a topic name (any string)
- set the Bootstrap servers to 'localhost:9092'
- set output folder path for consumer  

### Execute the Message Flow

Use the Flow Exerciser in the KafkaProducerFlow.msgflow and KafkaConsumerFlow.msgflow to run this tutorial.

- Open KafkaConsumerFlow.msgflow.
- Click the Flow Exerciser icon  to start testing the flow
- Open KafkaProducerFlow.msgflow.
- Click the Flow Exerciser icon  to start testing the flow
- Click the Send Message icon .
- Create a new message and click Send. Your message is sent to the HTTP input node.
- When the list of actions is shown, click on the Received HTTP reply message... item to show the output from the flow. This wil be the same as the message that you sent in.
- After you close the dialog, the path taken through the messageflow is highlighted. Click on the message icon on each connection to see how the tree is updated by each node.
- Go to the output directory that you specified on the FileOutput node and you should see a file that contains the message that you sent in.

This tutorial showed the KafkaConsumer and KafkaProducer nodes running in the same integration server. Remember if you experiment with other topologies you may need to run the mqsisetdbparms command accordingly, as the credentials for the Kafka nodes are scoped to the integration server.
