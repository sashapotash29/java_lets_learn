# Connect to the Database
##### Written by Alexander Potashnik (GitHub: sashapotash29)


### What is a Database?

- A database is used to store information (data) in a way that allows for easy access and simple mathematical operations.
- For example, most people are familiar with Excel but rarely find themselves reaching a point where they run out of room.
- The truth is there is a finite amoutn of space and as more and more information is accumulated      (imagine the amount of tweets that are stored!!!), there needs to be an efficient way to store this information and look through it. 
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




### How to connect with Java?

- For this example, we will be using PostgreSQL, but the main difference will be noticed in how we set up the database. The commands we write are similar within all SQL software out there.
