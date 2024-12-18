# Grocery Booking Api

The Grocery Booking Application provides APIs for user registration, role based authentication, and
managing groceries available in the database. Admins can perform management tasks, while normal users can fetch and
purchase groceries.

### Steps to start Grocery Booking Application

> Prerequisites Installations :  Java 21, Maven, Git Client, MySQL

> Optional : Docker

1. You can either clone the repository using Git or download the project as a ZIP file.

    ```bash 
    git clone https://github.com/sayani-chandra/qp-assessment.git

2. This project uses MySQL as the database. You can set it up locally.

    1. Install MySQL and create a database named `grocerybooking`.
    2. Update application.properties with username and password.

3. Once MySQL is running, build the project using Maven:
   ```bash
   mvn clean install

## Running the application

1. Make sure you have MySQL DB installed with **grocerybooking** database created
2. Run the java file inside GroceryBookingApplication **java\com\demo\GroceryBookingApi\GroceryBookingApplication.java**

### Testing Grocery Booking Api

The Api's can be tested using postman collection provided inside the `resources` folder in root.

1. Create the user first, using the api `(/register)`
2. Create `roles` table by assigning role`(ADMIN/USER)` to the newly registered user

important: Use Basic Auth in Authorization and enter Username and Password accordingly, depending on the role for admin
controlled and user controlled
api's