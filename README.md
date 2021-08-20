# Assessment

### The Challenge:

In project Assessment are prepared 2 empty services (modules): `API` and `Logger`. Implement these services in the
following way:
API service is responsible for communication via REST API with GUI frontend. It should contain 2 REST endpoints. First
endpoint is used to obtain list of all articles from database. Second endpoint should return content of concrete article
with all comments. Each operation on rest API is logged in Logger service (written to STDOUT). API service and Logger
service should communicate through Kafka topic. Kafka connection details are prepared in helper
class [KafkaConnectionHelper](api/src/main/java/com/ribs/api/KafkaConnectionHelper.java). Articles and comments are
stored in MySQL database (connection string is
in [application.properties](api/src/main/resources/application.properties) file). Database tables and their relations
are described in [er_diagram.png](er_diagram.png).

All authentication details for MySQL and Kafka will be provided via email, right before the challenge. You can use
properties `kafka.username` and `kafka.password` for authentication to Kafka broker. Prepare your solution in new
branch, created from main and push it back to Github.



Building the App:
------------------------------------------------------

assessment\api> mvn clean install -U

[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  9.970 s
[INFO] Finished at: 2021-08-20T14:28:51+02:00
[INFO] ------------------------------------------------------------------------

Running the App:
------------------------------------------------------

assessment\api> mvn spring-boot:run

14:29:29.845 [Thread-5] DEBUG org.apache.kafka.clients.NetworkClient - [Consumer clientId=consumer-cd9ku08u-consumer-2, groupId=cd9ku08u-consumer] Completed co
nnection to node -2. Fetching API versions.
Database Connection Successful! Enjoy. Now it's time to push data
14:29:30.811 [Thread-5] DEBUG org.apache.kafka.clients.consumer.KafkaConsumer - [Consumer clientId=consumer-cd9ku08u-consumer-2, groupId=cd9ku08u-consumer] Ini
tializing the Kafka consumer
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.5.4)

2021-08-20 14:29:31.123  INFO 34324 --- [  restartedMain] com.ribs.api.Api  


Database Connection

Connection


Using Postman:

http://localhost:8080/articles/article
{ "id": "1",
  "name":"castulo"
}


Output:

2021-08-20 14:19:15.901  INFO 39144 --- [      Thread-10] o.a.kafka.common.utils.AppInfoParser     : Kafka version: 2.8.0
2021-08-20 14:19:15.901  INFO 39144 --- [      Thread-10] o.a.kafka.common.utils.AppInfoParser     : Kafka commitId: ebb1d6e21cc92130
2021-08-20 14:19:15.901  INFO 39144 --- [      Thread-10] o.a.kafka.common.utils.AppInfoParser     : Kafka startTimeMs: 1629465555901
2021-08-20 14:19:17.162  INFO 39144 --- [ad | producer-1] org.apache.kafka.clients.Metadata        : [Producer clientId=producer-1] Cluster ID: fn98khoLQcCcY8S
t0L3VfA
KafkaExample.produce().new Thread() {...}.run(I) Topic----> cd9ku08u-defaultArticle id1
KafkaExample.consume()cd9ku08u-default;4;;39;1;castulo
cd9ku08u-default [4] offset=39, key=1, value="castulo"

