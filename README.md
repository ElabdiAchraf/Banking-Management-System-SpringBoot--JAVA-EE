# Banking-Management-System using SpringBoot - javaEE
A web application based on the Spring Boot framework. Use of Spring Data JPA, Spring Security,Hibernate, Thymleaf and Bootstrap

# Functional specifications:
![image](https://user-images.githubusercontent.com/75706371/186046125-79d8ca40-1945-459d-bd49-88eb688b5b77.png)


Each account belongs to one customer.
A bank account can be a current account or a savings account.

##### The application must allow to:
  - add groups
  - add employees
  - assign employees to groups
  - add customers
  - add accounts  
  - make payments to an account
  - make withdrawals from an account 
  - make transfers from one account to another
  - consult an account
  - consult a client's accounts 
  - view account transactions
  
 # Technical specifications:
  - Pour la consultation des opération, les opérations doivent s'afficher dans des pages. On doit utiliser la pagination, c'est à dire qu'on ne veut pas afficher toutes les opérationd sur la meme page.
  - The application must be secure. Only identified persons who are authorized to perform the above mentioned operations.
  - The application must handle user-related errors
  - The application must be responsive for different terminals
  
 # Application Architecture
 The application is based on a layered architecture:
 - A DAO layer for data access. Here we create the ClientRepository, AccountRepository and OperationRepository interfaces which are inherited from the JpaRepository interface.

- An Entities layer where we create our entities (classes) that will be mapped with the tables in the database 3. A business layer where we create an interface IbanqueMetier that defines the operations mentioned below and a class IbanqueMetierImpl that implements this class

- A web layer (presentation) where we manage everything that is web (View)
![image](https://user-images.githubusercontent.com/75706371/186046059-fdfb2868-b51a-4443-87ba-ef979ced2768.png)


# Technologies used:
- Java
- Spring Boot, Spring Data JPA, Spring Security
- View (UI) : Thymeleaf, JavaScript, Bootstrap3
- SGBD : MySQL
# Demo
![image](https://user-images.githubusercontent.com/75706371/186046230-4012d13d-c45c-4e63-945e-a02bceeb077c.png)
![image](https://user-images.githubusercontent.com/75706371/186046311-59a9602f-39f2-42ba-b3d1-587457b4d0e9.png)
![image](https://user-images.githubusercontent.com/75706371/186046381-14290b8d-7ce1-4290-92aa-c472ccca2376.png)
![image](https://user-images.githubusercontent.com/75706371/186046423-0462f2fd-7cda-4e65-af81-9509ff49953b.png)
![image](https://user-images.githubusercontent.com/75706371/186046472-6c14571b-3576-4a01-9db5-e36e3289129d.png)
![image](https://user-images.githubusercontent.com/75706371/186046524-2d3b51e5-217a-432a-942f-7d99408f3530.png)
![image](https://user-images.githubusercontent.com/75706371/186046555-55fba0d6-507c-4e48-8bc2-6a69cd9d6d5f.png)
![image](https://user-images.githubusercontent.com/75706371/186046597-1722ada1-17cb-4345-befd-13e552bf989a.png)
### ...







  
