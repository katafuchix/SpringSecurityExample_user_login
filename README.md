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

<div>
<img width="360" src="https://github.com/katafuchix/SpringSecurityExample_user_login/assets/6063541/b47173ba-646c-42ca-b5d1-ec76e06ec071">
<img width="360" src="https://github.com/katafuchix/SpringSecurityExample_user_login/assets/6063541/1f8eb3d5-881a-4dbd-be60-ba888ceac55c">
</div>

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
