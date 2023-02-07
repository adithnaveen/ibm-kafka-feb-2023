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


> kafka-topics.sh --bootstrap-server localhost:9092 --topic d2-first-topic --describe 


- as of now this does not work (single kakfa)
> kafka-topics.sh --bootstrap-server localhost:9092 --create --topic d2-second-topic --partitions 3 --replication-factor 3

- without group 
- kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic d2-first-topic


- with group 
- kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic d2-first-topic --group first-application


- kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic d2-first-topic --group second-application

- kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic d2-first-topic --group second-application

- kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic d2-first-topic --group second-application




