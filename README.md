# SpringSecurityExample_user_login

Spring Boot Login Auth Exmaple with spring-boot-starter-security, thymeleaf-extras-springsecurity6, MyBatis, MySQL
- create MySQL DataBase, Table, insert sample data
- create project on Eclipse with Spring Starter Project with maven
- create resources/generatorConfig.xml
- create Entity, Mapper class, XML File (ex.) mvn mybatis-generator:generate
- Edit pom.xml
- Maven install
- Define SecurityConfig class with SecurityFilterChain
- Define Model class implements UserDetails, Serice class implements UserDetailsService
- - Maven Build
- copy war file in Tomcat webapps ( Same Java SDK with Eclipse )

http://localhost:8080/


```
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>
		<dependency>
			<groupId>org.thymeleaf.extras</groupId>
			<artifactId>thymeleaf-extras-springsecurity6</artifactId>
		</dependency>
```

```
<body th:with="user=${#authentication.principal.loginUser}">

    <h1>ログイン成功</h1>
    <h2><span th:text="${user.username}"></span> さんHello!!!!</h2>

    <form th:action="@{/logout}" method="post">
    <button>Logout</button>
    </form>
    
</body>
```
