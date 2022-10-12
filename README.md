# Spring Demo Examples
  This is Spring Boot master branch wich contian
    blank project for cloning and set up.
    Project created as a guide and demo for learning purposes.
    
    #Who can use it?
These examples are useful both for beginners with no previous experience
with Spring and for individuals who good knowlgde of Spring Boot.
However, Java programing basic knowldge needed.
Instructors may use these examples for teaching purposes.

The project is divided into the following branches:

1) Spring Boot MVC and Thymeleaf
2) Spring Boot Data and Spring MVC
3) Spring Boot Security
4) Spring Boot File Upload

To move from one topic to another, the user needs to switch to the
branch of interest to him / her

#Installation

1) For a successful installation of the project, it recommended cloning
   the project using the clone button.
2) Next use "git clone <link>" in your terminal to clone project in
   desired directory

#Usage

1.Spring-MVC-Thymeleaf branch is example of how use Spring Boot Thymeleaf engine to create dynamic html pages. However, from this example you also can learn about such annotations like @Controller, @PostMapping, @GetMapping, @Valid and @ModelAttibute. This example also show how to use Lombok annotations

a.Before download be sure you have Java8/11 JDK installed. It is recommended to use IntelliJ IDE to run this project.

Spring Boot MVC and Thymeleaf project demonstrates how Java class or variable can be mapped to html. Run project and use such Browse as Chrome to navigate to available pages:

1. http://localhost:8080/ - basic example of how pass Sting to html template
2. http://localhost:8080/employee - pass class data to template
3. http://localhost:8080/add-employee - example of how to use html form to add new entity
4. http://localhost:8080/all-employees - show all added employees as a list. 
5. http://localhost:8080/validation/process-employee - example show how to use validation in html form with Thymeleaf

Example 4 and 5 are extremely important to understand. It is recommended to go over code couple of times. Code also has comments for important points.

In addition, under src/test/java directory you can find basic JUnit tests. 


2.	Spring-Data-JPA branch is the example of Spring Boot Data and basic Spring Rest. 

	a.Before start you should set up database and edit in application.properties file username, password and link to database(if database local use jdbc:mysql://localhost:3306/<db name>)

	b.Be sure that you have Java 8/11 JDK installed.

	c.Install Postman application (Note: you need to have it in order to test endpoints) 

	d.Double check pom.xml to be familiar with dependencies used in this section
	

Spring Data example utilize following concepts as an example:
1.	Basic class mapping to entities. This example use DTO and ModelMapper as concepts of mapping data to entity class. 
2.	Using One-To-Many, Many-to-Many and One-to-One database relationships
3.	Using @Restcontroller, @Autowired, @Service, @Transactional, @Repository, @Query and other annotations
4.	Using layered concepts Controller->Service-> Repository(DAO -> Repository)


This demo uses both Rest HATEAOS and Rest controller concepts, so you can understand difference between them. 
Use this link to get access to public postman json. Once you import link you can start testing available endpoints:

	https://www.getpostman.com/collections/5383078e5c04e0625e1b

Note: to get all available endpoints for HATEAOS just call 

	http://localhost:8080 

If you interested to learn about testing for Rest you can examine src/test/java directory

	
3.Spring-Security branch demonstrates basic Spring Security and implements password authentication for users.

	a.Before start you should set up database and edit in application.properties file username, password and link to database(if database local use jdbc:mysql://localhost:3306/<db name>)

	b.Be sure that you have Java 8/11 JDK installed.

	c.Double check pom.xml to be familiar with dependencies used in this section
	
	This demo example have 2 security approaches:
1.	UserServiceImpl uses anonymous new class User from “org.springframework.security.core.userdetails”. This is the most easiest way to achieve basic security functions
2.	UserServiceImpl uses UserPincipal class. UserPrincipal class implements UserDetails and overrides UserDetails class (“org.springframework.security.core.userdetails.UserDetails”) methods. This approach offers a lot more flexibility from security viewpoint. Plus such approach need also specific database queries in order to map different user roles. It is recommended also review repositories for such queries
	
	In this example user data saved to database and every user have specific roles. By default, application provides 3 type of roles for users “ROLE_ADMIN”, “ROLE_USER” and “ROLE_GUEST”. You can find those roles in 
SpringDemoLearningApplication.java. In SpringDemoLearningApplication.java also implements CommandLineRunner interface to write user roles and one admin user to database on application launch. Admin user created to show how application interface can be customized based on user roles. To avoid roles and admin user duplication in database leave “spring.jpa.hibernate.ddl-auto=create”. Otherwise, you need to create extra code to avoid roles and user duplication.

Special attention should in this application is given to Thymeleafe Security Extras. Thymeleafe help developer customize paged based on user roles and provide information about logged in user. 

#How to use application:
	
1.	You can start application and try login with admin user without creating other users. 
2.	To see difference in home page content for different user you need to create regular user account. Navigate in browser to http://localhost:8080/sign-up and fill put form. Note: it is important to pay attention to data validation process. In this example specific customized password validation annotation used. It is recommended to dive into this code and understand how it works. Application doesn’t provide password complexity functionality but you can create it by yourself.
3.	After sign up try to use user email as login and password to login in
4.	If successful you will notice differences in information shown for admin and user
5.	It is recommended create some other functionality for guest users. 


4.	Spring_file_upload branch demonstrates file upload example. 
	a.Before start Be sure that you have Java 8/11 JDK installed.
	
	This example is created to demonstrate basic file upload using MultipartFile class and RedirectAttributes. Application use PDFBox dependency to upload and encrypt pdf files. You can choose any other file
	Format and process in the desired way. After uploading pdf file saved in directory with unique UUID. For example in real application such approach can be used to save files in directory with named using user unique id(for example UUID).   

The majority of examples covers all necessary type of annotations used in Spring. Some branches also demonstrates how to use exceptions and logging. 
