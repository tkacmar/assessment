# Assessment

### The Challenge:

In project Assessment are prepared 2 empty services (modules): `API` and `Logger`. Implement these services in the following way:
API service is responsible for communication via REST API with GUI frontend. It should contain 2 REST endpoints. 
First endpoint is used to obtain list of all articles from database. 
Second endpoint should return content of concrete article with all comments. 
Each operation on rest API is logged in Logger service (written to STDOUT). 
API service and Logger service should communicate through Kafka topic. 
Kafka connection details are prepared in helper class [KafkaConnectionHelper](api/src/main/java/com/ribs/api/KafkaConnectionHelper.java).
Articles and comments are stored in MySQL database (connection string is in [application.properties](api/src/main/resources/application.properties) file). 
Database tables and their relations are described in [er_diagram.png](er_diagram.png).

All authentication details for MySQL and Kafka will be provided via email, 
right before the challenge. 
You can use properties `kafka.username` and `kafka.password` for authentication to Kafka broker.
Prepare your solution in new branch, 
created from main and push it back to Github.