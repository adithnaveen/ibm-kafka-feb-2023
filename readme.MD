# ibm-kafka-feb-2023


### System Requirement 
- System with 8 GB 
- Hypervisor Support to test with docker 
- abount 50 GB free space 
- Operating System Mac / Windows / Linux
- Open internet access 


### Step 1 
> Download and install jdk 11 for your respective OS(Mac/Win/Linux) - https://www.oracle.com/in/java/technologies/javase/jdk11-archive-downloads.html

### Step 2 
>  Download Kafka from - https://downloads.apache.org/kafka/3.2.3/kafka_2.12-3.2.3.tgz
> Extract with softwares like 7 zip / win zip etc 

* Note Windows Users: install wsl2 first -  https://docs.microsoft.com/en-us/windows/wsl/install
### Step 3 
> Add Kafka to system path - kafka_2.13-3.1.0/bin 

### Additional Softwares 
> Docker - https://www.docker.com/products/docker-desktop/

> Eclipse JEE - https://www.eclipse.org/downloads/


- Name, Exp in which you are working, what are you expecting out of this program 

## Introduction 

- Anandaha Ganesh - working in 9 year, working in testing domain , exploreing on kafka and how this can be incorporated in kakfa 

- Anantha Naga Lakshmi - 8.5 years exp, in automation, working in ibm from 7 months, currently using kafka in project, exploring kakfa 

- Basavaraj Bandi - 14 Years exp, 8.5 as developer, fullstack tester working in testing, native apps testing, looking for how kafka can help in testing 

- Girish Parteek - working with IBM from 16 years, worked in diff domain currently working with testing, mostly in technical work + cloud architect, trying to understand holistic view to know the implementation 

- Hiranmai Pilla - 10 Year exp in testing, working automation selenium + java, to upgrade skill for testing 

- Mailesh B - 1.5 year exp, test specialist with IBM, has api background currently kakfa is used in the project and to know how kafka works 

- Nikhitha - 9 year exp in test, with IBM from 3 months, works as automation selelnium + java, to know benefits of java and where it can be used 

- Palina Sravani - 4 year exp working with IBM from 1 year, what is kafka and explore on kafka 

- Ravi Nedarpalle - 17 Year exp, manual testing + automation, new to kafka and how this is works and can be incorporated 

- Sahana - 1 year exp IBM, testing engg, now more about kafka and if there is a chance to implement 

- Shreelaxi Bose -  with IBM 13 years, working with testing, new to kafka to explore and implementing kafka + selenium + java + manual

- Shubham Tiwari - working with telco, 13 years worked with telecom, have done couple of POC, understand more of arch side, and what will help for multiple use cases 

- Vedam - 14 years exp with IT, IBM 9 Years, Mainframe, manual testing working with performance engg, Quality how kafka can be used

- I'm Naveen 20 Year, 18 Year i'm trainer, have trained over 70 Companies, develop content, association with IBM from 5 years. 

- training planned for 3 days 


> tar -xvf <fileName.tgz>



- 2000's - Login, stock, customer details, shipping, order, tracking etc - Vertical Scaling 





- Producer - Consumer 
- Publisher - Subscriber 



- Array, ArrayList, Set - Values are sent 
- Map - Key Value are sent 


- workings (windows users please refer inside windows folder)

- Staring Zookeeper 
> ./bin/zookeeper-server-start.sh ./config/zookeeper.properties

- Starting Kafka 
> ./bin/kafka-server-start.sh ./config/server.properties

- list all the topics 
> bin/kafka-topics.sh --bootstrap-server localhost:9092 --list

- create topic 
> bin/kafka-topics.sh --bootstrap-server localhost:9092 --create --topic first_topic 

> bin/kafka-topics.sh --bootstrap-server localhost:9092 --create --topic second-topic

> bin/kafka-topics.sh --bootstrap-server localhost:9092 --create --topic third-topic

> bin/kafka-console-producer.sh --bootstrap-server localhost:9092 --topic first_topic 

> bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic first_topic 

- to read all data 
> bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic first_topic --from-beginning 

- to describe the topic 
> kafka-topics.sh --bootstrap-server localhost:9092 --describe --topic first_topic

- to describe all topics 
> kafka-topics.sh --bootstrap-server localhost:9092 --describe 


- passing key,value 
> kafka-console-producer.sh --bootstrap-server localhost:9092 --topic second-topic --property parse.key=true --property key.separator=: 

> kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic second-topic --property print.key=true --property print.value=true

> kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic second-topic --property print.key=true --property print.value=true --property print.timestamp=true

> kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic second-topic --property print.key=true --property print.value=true --property print.timestamp=true --formatter kafka.tools.DefaultMessageFormatter


# Day 2 

- Monolithic 
    - View 
    - BL 
    - DB 
    - Service
    - DAO 

- Microservice 
    - login 
    - sso 
    - stock
    - Order
    - Product
    - Video 
    - Likes
    - Dislikes
    - Comments 

- ESB Service Providers 
    - Kafka 
    - Open MQ 
    - Rabbit MQ
    - Mule Soft 
    - Tibco 
    ... 

- Kafka 
    - JVM - Platform independent 
    - Scala 
        - Groovy, Ruby, R, Splunk (Utility)... 
    - They are reactive in nature 
        - who introduced async coding with JVM 
        - Java 8 - upto that it was only sync code, thick code, functional programming -> 
        - asycn, Reactive support 

- In DB you can query, in Kafka you cannot query 
    - to send message you need kafka producer 
    - to get message you need kafka consumer - which acts like subscriber 

- by default the messages in kafka is kept for - 1 week 
- by default every topic shall have 1 partition 
- Kafka 2.x - zookeeper is mandatory 
- Kafka 3.x - zookeeper is not mandatory, it is not production ready, it is at POC stage, KRAFT (Kafka Raft)
- Kafka 4.x - Zookeeper shall be removed 



## working with partitions 

- create topic with 3 partitions 
> kafka-topics.sh --bootstrap-server localhost:9092 --create --topic d2-first-topic --partitions 3

- descirbe the topic 
> kafka-topics.sh --bootstrap-server localhost:9092 --topic d2-first-topic --describe

- as of now this does not work (single kakfa)
> kafka-topics.sh --bootstrap-server localhost:9092 --create --topic d2-second-topic --partitions 3 --replication-factor 3

- without group (which shall consume all the message produced by producer)
- kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic d2-first-topic


- with group (2 consumer, where data is balanced between 2 consumer)
> kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic d2-first-topic --group first-application

> kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic d2-first-topic --group first-application



- with group (3 consumer, where data is balanced between 3 consumer)
> kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic d2-first-topic --group second-application
> kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic d2-first-topic --group second-application
> kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic d2-first-topic --group second-application


- working with lag and resetting lags 

```
> kafka-consumer-groups.sh --bootstrap-server localhost:9092 --describe --group first-application

GROUP             TOPIC           PARTITION  CURRENT-OFFSET  LOG-END-OFFSET  LAG             CONSUMER-ID                                           HOST            CLIENT-ID
first-application d2-first-topic  0          28              28              0               console-consumer-c30baba0-1292-45c3-aa6c-47cca7300d2a /192.168.29.183 console-consumer
first-application d2-first-topic  1          17              17              0               console-consumer-c30baba0-1292-45c3-aa6c-47cca7300d2a /192.168.29.183 console-consumer
first-application d2-first-topic  2          25              25              0               console-consumer-f95a6fd3-e5cf-4ead-a471-d5ab3f1c2fb6 /192.168.29.183 console-consumer
$

```
- close all the consumers of first-application, you will get similar to this where no consumer is connected, and not there is a lag value 
- if the lag is 0 it means all the records are consumed 
```
 >    kafka-consumer-groups.sh --bootstrap-server localhost:9092 --describe --group first-application

Consumer group 'first-application' has no active members.

GROUP             TOPIC           PARTITION  CURRENT-OFFSET  LOG-END-OFFSET  LAG             CONSUMER-ID     HOST            CLIENT-ID
first-application d2-first-topic  0          28              30              2               -               -               -
first-application d2-first-topic  1          17              18              1               -               -               -
first-application d2-first-topic  2          25              26              1               -               -               -
```

- up the consumer 

```
 > kafka-consumer-groups.sh --bootstrap-server localhost:9092 --describe --group first-application

GROUP             TOPIC           PARTITION  CURRENT-OFFSET  LOG-END-OFFSET  LAG             CONSUMER-ID                                           HOST            CLIENT-ID
first-application d2-first-topic  0          30              30              0               console-consumer-ab9e8407-e9bb-43de-87e5-fddae7573e15 /192.168.29.183 console-consumer
first-application d2-first-topic  1          18              18              0               console-consumer-ab9e8407-e9bb-43de-87e5-fddae7573e15 /192.168.29.183 console-consumer
first-application d2-first-topic  2          26              26              0               console-consumer-ab9e8407-e9bb-43de-87e5-fddae7573e15 /192.168.29.183 console-consumer
```


- OLTP - SAGA 
- OLAP - Reporting 

- even in the group you can get all the messages from beginning 

- will the messages from current point 
> kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic d2-first-topic --group third-application

> kafka-consumer-groups.sh --bootstrap-server localhost:9092 --describe --group third-application

> kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic d2-first-topic --group fourth-application --from-beginning


- resetting offsets

- this will not work, pls ensure to have --execute and --topic or --all-topics 
> kafka-consumer-groups.sh --bootstrap-server localhost:9092 --group third-application --reset-offsets --to-earliest

- resetting shall work (and it will take the offset value to 0)
> kafka-consumer-groups.sh --bootstrap-server localhost:9092 --group third-application --reset-offsets --to-earliest --execute --topic d2-first-topic

- describe to check 
- kafka-consumer-group.sh --bootstrap-server localhost:9092 --describe --group --third-application 

- resetting  by -5 (Before) values 
> kafka-consumer-groups.sh --bootstrap-server localhost:9092 --group third-application --reset-offsets --shift-by -5 --execute --topic d2-first-topic

- resetting  by 5 (After) values 
> kafka-consumer-groups.sh --bootstrap-server localhost:9092 --group third-application --reset-offsets --shift-by 5 --execute --topic d2-first-topic


---- 

## working with Kafka and Java 

1. Java 11 (Done)
2. Kafka (Done)
3. [Eclipse / IntellJ - IDE] / [VS Code / Nodepad ++  - Editors]
4. Maven (Implicitly has Maven) - Dependency Management Tool 
    - 3.1 Kafka Client (Maven Dependency in pom.xml)
    - 3.2 Logger slf4j + simple 
5. Program 
    - 5.1 Configuration - bootstrap details 
    - 5.2 Producer 
    - 5.3 generate a record 
    - 5.4 Send and get the ack 
    - 5.5 close + flush 

--- 

# Day 3 

### Question 
- why package is needed 
- explain the need of programming (kafka client)
- retro of java producer program 

## Agenda 
- Kafka Consumer-Java program  (Done)
- Send Multiple messages with Java to Kafka (Done)
- Send Json (Serialize / Deserialize) - Show connecting (Mock) with DB (Done)
- Process Large data into your system (Wikimedia) (done)
- KRaft - Start Kafka Without Zookeeper - (need to reply)

```
    $ ./bin/kafka-storage.sh
    usage: kafka-storage [-h] {info,format,random-uuid} ...
    kafka-storage: error: too few arguments

    $ ./bin/kafka-storage.sh random-uuid
    n0QNQ_eZRlyS3-FzEz0wvQ
    
    $ ./bin/kafka-storage.sh format -t n0QNQ_eZRlyS3-FzEz0wvQ -c ./config/kraft/server.properties
    Formatting /tmp/kraft-combined-logs
    
    $ kafka-server-start.sh ./config/kraft/server.properties

    # 

```
- Dockerzie Kafka + Testing 


```


```
<pre>
docker-compose.yml 

———————----------

version: '3'
services:
  zookeeper:
    image: confluentinc/cp-zookeeper:7.3.0
    container_name: zookeeper
    environment:
      ZOOKEEPER_CLIENT_PORT: 2181
      ZOOKEEPER_TICK_TIME: 2000

  broker:
    image: confluentinc/cp-kafka:7.3.0
    container_name: broker
    ports:
    # To learn about configuring Kafka for access across networks see
    # https://www.confluent.io/blog/kafka-client-cannot-connect-to-broker-on-aws-on-docker-etc/
      - "9092:9092"
    depends_on:
      - zookeeper
    environment:
      KAFKA_BROKER_ID: 1
      KAFKA_ZOOKEEPER_CONNECT: 'zookeeper:2181'
      KAFKA_LISTENER_SECURITY_PROTOCOL_MAP: PLAINTEXT:PLAINTEXT,PLAINTEXT_INTERNAL:PLAINTEXT
      KAFKA_ADVERTISED_LISTENERS: PLAINTEXT://localhost:9092,PLAINTEXT_INTERNAL://broker:29092
      KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR: 1
      KAFKA_TRANSACTION_STATE_LOG_MIN_ISR: 1
      KAFKA_TRANSACTION_STATE_LOG_REPLICATION_FACTOR: 1


—————————————-
docker-compose up -d
—————————————-
docker exec broker \
kafka-topics --bootstrap-server broker:9092 \
             --create \
             --topic quickstart
—————————————-
docker exec --interactive --tty broker \
kafka-console-producer --bootstrap-server broker:9092 \
                       --topic quickstart
—————————————-
docker exec --interactive --tty broker \
kafka-console-consumer --bootstrap-server broker:9092 \
                       --topic quickstart \
                       --from-beginning
—————————————-
docker-compose down
—————————————-
</pre>
```


```

- Single Zookeeper + Multiple Kafka Cluster Setup + Replication Factor of 3 

```
    > step1 - Start Zookeeper 
    > Step2 - Make a copy of server.properties -> server1.properties, server2.properties 
    > Step3 - Content server.properties - 9092 broker.id=0 + log path to be changed + plain text uncomment (optional)
    > Step4 - Content server1.properties - 9093 broker.id=1 + log path to be changed + plain text uncomment (optional)
    > Step5 - Content server2.properties - 9094 broker.id=2 + log path to be changed + plain text uncomment (optional)
    > Step6 - start the kafka with property information server.properties, server1.properites, server2.properties 
    > Step7 - Create the topic 
        > kafka-topics.sh --bootstrap-server localhost:9092,localhost:9093,localhost:9094 --topic partition-with-replica --create --partit
ions 3 --replication-factor 3

        >  kafka-topics.sh --bootstrap-server localhost:9092,localhost:9093,localhost:9094 --list

        > kafka-topics.sh --bootstrap-server localhost:9092,localhost:9093,localhost:9094 --describe --topic partition-with-replica
    > Step8 - Launch the producer 
        > kafka-console-producer.sh --bootstrap-server localhost:9092,localhost:9093,localhost:9094 --topic partition-with-replica
    
    > Step- Launch the consumer 
        >  kafka-console-consumer.sh --bootstrap-server localhost:9092,localhost:9093,localhost:9094 --topic partition-with-replica

    - Now you can kill the kafka, until atleast 1 kafka is up the messages are delivered 

```
- Multi Zookeeper + Multiple Kafka Cluster Setup + Replication Factor of 3 (Optional)
- Setting up kafka with spring boot application (Option)

