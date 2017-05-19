# Connect to the Database
##### Written by Alexander Potashnik (GitHub: sashapotash29)



### PostgreSQL Review Section

### What is a Database?

- A database is used to store information (data) in a way that allows for easy access and simple mathematical operations.
- For example, most people are familiar with Excel but rarely find themselves reaching a point where they run out of room.
- The truth is there is a finite amount of space and as more and more information is accumulated      (imagine the amount of tweets that are stored!!!), there needs to be an efficient way to store this information and look through it. 
- Low and Behold, the Database! Primarily, every business has a SQL based database and may also have a NoSQL database which will be covered later on.

### Installation Process

- The installation process described below is for Mac OS X and Linux users.
- The package manager being used is HomeBrew.

#### Installing via Brew
```
brew update

brew install postgres

```
- The first command (written in the Terminal) is to update Brew in case any upgrades have been made since your last usage.
- The following command is used to install PostgreSQL onto your machine.
- **Note** HomeBrew is not only serving as a tool to obtain programming packages but also as a service manager as well. Therefore, when you start your PostgreSQL server, homebrew will take on the task.

### Checking Services
```
brew services list
```

- This command is used to see what services Brew is responsible for and is running.
- **Note** If you have just ran the previous command, you will see postgres followed by the word stopped. This means it is not currently running. This is useful if you are making commands to the database and their is an issue with the connection.


### Starting up your PostgreSQL Server

- Before continuing, it's important to be aware that SQL software is designed for more than simply storing information but creating a server that allows for users to connect and interact with databases and tables.
- Therefore, before we can start storing/writing information into tables and create a database, we need to start our server so it can accept connections and/or requests for actions.

- Assuming your server is not currently running (this can be checked via the above command under "Checking Services"), run the following command.

```
brew services start postgresql
```
- Rough translation is "Brew, check your services, and start the PostgreSQL server".
- The output in the terminal will show it is successful with a message similar to this.
```
==> Successfully started `postgresql` (label: homebrew.mxcl.postgresql)
```
- **Note** If you run the "brew services list" command in your terminal, you will see the path for your server which is important being you can be running multiple PostgreSQL servers outside of Brew.

### Creating a Role
- First, to access the PostgreSQL terminal environment, we need to type in the command:
```
psql
```
- Once here, we need to create a role. 
- From documentation (via https://www.postgresql.org/docs/8.1/static/sql-createrole.html),
	- "A role is an entity that can own database objects and have database privileges; a role can be considered a "user", a "group", or both depending on how it is used."
- In its essence, roles help explain to the database who is using the server and what they should have access to. You can imagine a company will have a server running but a database for the Human Resources department and another one for the Inventory Managers. It would be chaotic and potentially harmful if both parties could change and access information that was non-essential to their function in the company.

- To create a role, we will run the following command in the psql terminal:
```
CREATE ROLE *name_of_role* WITH *option1* *option2* *etc.*
```
- The server is aware that you are creating a role and using "WITH" explains how this user can interact with the Datbase.

- For example, 
```
CREATE ROLE Tommy WITH CREATEDB CREATEROLE LOGIN PASSWORD
```
- The above statement translates to "Create a role named Tommy and give Tommy the ability to do the following".
- CREATEDB - allows the role to create databases.
- CREATEROLE - allows the role to create roles.
- LOGIN - the role created has to be logged into.
- PASSWORD - Set the role's password, meaning the user will be prompted for a password to access said role.

### Where is the data stored?

- Taking a step back from the syntatical sugar involved in PostgreSQL, the data is being stored in a directory usually at the end of this path.
```
/usr/local/pgsql/data
```
- The folder at this location contains the databases that have been created.
- Now, as you use PostgreSQL, you will be updating the software using Brew (via "brew update") and this will change the path to your data.
- For example, your previous version of PostgreSQL will have a path set to reach the database files that the new version is unaware of and therefore, will not have access to the data you stored previously.
- In order to transfer your data, use the following command:
```
pg_dumpall -p 5432 | psql -d postgres -p 6543
```
- **Note** the "5432" and "6543" indicate the ports where the servers are listening for commands. 

### Creating a Database

- Assuming the server is running and accepting connections, we need to create a database, which can be thought of as a collection of tables.
- To create a Database provided you are in a role that can and in the PostgreSQL terminal environment, the following command will allow said operation.
```
CREATE DATABASE *name_of_database*
```
- After the name of the database, you can specify certain database specific configurations such as which role is the owner.
- Another example is "TEMPLATE" which allows for you to specify how the database should be structured. Generally, the deafult is used and is sufficient.
- For more information, refer to this link: http://www.postgresqltutorial.com/postgresql-create-database/

## Java Portion

### How to connect with Java?

- For this example, we will be using PostgreSQL, but the main difference will be noticed in how we set up the database. The commands we write are similar within all SQL software out there.

### JDBC Driver

- In order to connect to the Database (in this case PostgreSQL Server), Java will need a driver.
- **Note** A different driver is needed in case of MySQL, Microsoft SQL Server, Oracle, etc.
- This part will take some configurations.
- First make sure the server is running via brew and then find which port the server is listening on. By default it should be on "5432".
- In case it is not run the following commands:
```
//IN TERMINAL

psql

// IN PSQL Terminal Environment

SELECT *
FROM pg_settings
WHERE name = 'port';
```

- The result should return columns of different values one of which will be the port.

#### Connecting to PSQL via JDBC

- First we need a URL that explains the path to our PSQL Server. The idea here is that your Java program will make a request to that server and will ask to connect/interact with your database.
- In my example, I created a database called students.
```
String URL = "jdbc:postgresql://localhost:5432/students";
Connection conn = DriverManager.getConnection(URL);
```
- To begin, we identify the path which will generally start with 
```
jdbc:postgresql://
```
- This is then followed by the host (genearlly "localhost" for your local machine) followed by the port ( i.e. 5432) and then a "/" with the table name (i.e. students).

- Next we need to make an instance of a Connection which will be an object that represents our connection to the database. 
- **Note** You may need to add parameters in the getConnection() to explain your authentication (Username, Password).


#### Making a Query (SELECT STATEMENT)

- For those unfamiliar with SQL, every statement you execute is nothing more than String that gets read by the Database software which then deciphers what to grab from you. In our case, we will start by creating the string and then passing it through via some Java Objects.

```
Statement stmt = conn.createStatement();

String SQL = "Select * from student_info";

ResultSet rs = stmt.executeQuery(SQL);

```

- First we create a "statement" object using "conn.createStatement()". This piece of code returns a statement object that contains the properties of our connection and creates a statement object which we can then use to interact with our database.
- The String named "SQL" is the string that contains our SQL Comman we would like to execute, which follows SQL syntax. (Basically asking for all rows of data in the table named "student_info").
- **Note** The last line executes our statement and returns an object known as a "ResultSet". We never have to define where the database is or how to connect being the "statement" object we created contains that information.


#### Retrieving our information from the ResultSet

- If we were to println() our result set, we will see that it prints an object rather than the information. This means we need to navigate this object to obtain our information.

##### TABLE STRUCTURE

```
CREATE TABLE student_info (
id  integer PRIMARY KEY,
fname  varchar(30) NOT NULL,
lname  varchar(30) NOT NULL,
grade  integer);
```

##### CONTENTS

```
 id | fname  |   lname   | grade 
----+--------+-----------+-------
  1 | Robert | Robinson  |    12
  2 | Sally  | Silverman |    11
  3 | Bobby  | Braxton   |     9
  4 | Freddy | Pacino    |    10
(4 rows)
```
##### Code Example

- So our ResultSet object we should receive based on our query should contain the information above in the order reading left to right and top to bottom.
- Here is the code to navigate through our ResultSet and then we will explain the mechanics.
```
 while(rs.next()){
            int id = rs.getInt(1);
            String fname = rs.getString(2);
            String lname = rs.getString(3);
            int grade = rs.getInt(4);

 // THE PART BELOW IS SO WE CAN VIEW THE INFORMATION ONCE IT IS DONE.          
            System.out.println(id + " " + fname + " " + lname + " " + grade);
        
        
        }
```
- It begins with a while loop that asks the question upon reaching the bottom of the loop of "did rs.next() return true or false?".
- rs.next() is a function that returns true/false depending on if it can surmise there is another row. Similar to a for loop that will continue until a certain number/length is reached. 
```
// With For
	for(int i =0; i<= array.length; i++){
	// DO SOMETHING

	};

// With While
	int i = 0;
	while(i<= array.length){
	// DO SOMETHING
	i += 1;

}
```
- Next to visually understand what we are getting, we explain what data type each item in each column is respectively.
- This is done using getString(), getInt(), and others. Each one od these functions take in a number as a parameter asking for what index value is it in that row. For example, "Robert" will be a string that is located at the second index.
- **Note** It does not start at 0!!!
- At the end, I print the information so we can see what it is we retrieved.

#### More example SQL Statements with Java

##### SELECT Statement with WHERE clause
```
//        SELECT WITH WHERE STATEMENT
        String SQL2 = "SELECT * FROM student_info WHERE grade > 9";
        Statement stmt2 = conn.createStatement();
        ResultSet rs2 = stmt2.executeQuery(SQL2);
        System.out.println(rs2);
        displayResults(rs2);
```
- **Note** displayResults() is a method that takes a ResultSet as a parameter and displays the data. Being it involves a while loop that checks for rs.next() (is there another row), it can only display multiple rows, not a single row.

##### INSERT Statement
- In the beginning, I am simply grabbing inputs from the user with which to build my SQL command. This is in order to practice passing Java variables we create through String Concatenation.
```
 		Scanner input = new Scanner(System.in);
        System.out.print("New Student's ID number: ");
        int id = Integer.parseInt(input.nextLine());
        System.out.print("New Student's First Name: ");
        String new_fname = input.nextLine();
        System.out.print("New Student's Last Name: ");
        String new_lname = input.nextLine();
        System.out.print(new_fname + " " + new_lname +"'s Grade: ");
        int new_grade = Integer.parseInt(input.nextLine());
        
        
        String SQL4 = "INSERT INTO student_info VALUES('"+id+"','"+new_fname+"','"+ new_lname + "','" + new_grade+ "')";
        stmt.executeUpdate(SQL4);
        
        ResultSet rs5 = stmt.executeQuery("SELECT * from student_info");

        displayResults(rs5);
```
- **NOTE** We are utilizing executeUpdate() instead of executeQuery() being the latter function retuns a ResultSet where as our chose SQL command simply adds something to the database without retunring anything.




