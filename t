[1mdiff --git a/src/main/resources/application.properties b/src/main/resources/application.properties[m
[1mindex 2c6b451..bbdf676 100644[m
[1m--- a/src/main/resources/application.properties[m
[1m+++ b/src/main/resources/application.properties[m
[36m@@ -2,9 +2,9 @@[m [mserver.port: 9002[m
 management.port: 9003[m
 management.address: 127.0.0.1[m
 [m
[31m-spring.datasource.url=jdbc:mysql://localhost:3306/creativei_enquiry[m
[32m+[m[32mspring.datasource.url=jdbc:mysql://localhost:3306/creativei_inquiry[m
 spring.datasource.username=root[m
[31m-spring.datasource.password=[m
[32m+[m[32mspring.datasource.password=root[m
 [m
 # Keep the connection alive if idle for a long time (needed in production)[m
 spring.datasource.testWhileIdle = true[m
