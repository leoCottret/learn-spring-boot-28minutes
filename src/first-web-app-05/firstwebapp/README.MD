# Easy way to get a persistent database for this project
- application.properties and pom.xml are already configured for MySQL so
1. install docker
2. replace the "REPLACE" parts by the values of your choice in this command, then run it
	- `docker run --detach --env MYSQL_ROOT_PASSWORD=REPLACE --env MYSQL_USER=REPLACE --env MYSQL_PASSWORD=REPLACE --env MYSQL_DATABASE=REPLACE --name mysql --publish 3306:3306 mysql:8-oracle`
3. add the environment variables to your IDE
4. everything is ready!