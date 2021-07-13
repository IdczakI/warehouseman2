# Warehouseman 2.0
The application is an improved version of warehouseman 1.0.
This time, it was created as a web application 
using Spring MVC, Data, Thymeleaf.

## What is Warehouseman application and why it was created?

This application allows you to manage the warehouse, and more specifically in
the register of items delivered to the warehouse and those leaving it.
I created this project because I would like to make the job of a warehouse 
manager easier, because I used to be one myself.

## General info
### Login data
- ID: 110A
- password: 000

user = warehouseman

After logging in, a page with information about 
items in stock appears.
Use the colored buttons to move between pages.
Their description is below.


### Items in warehouse
It contains information about the name and description
of the item, as well as the quantity of items per one pallet.
(The quantity of items on the pallet is constant and
there can only be one type of item on each pallet).
You can also find out about the number of pallets with 
a given item and general availability of the item.

You can add a new item and edit an existing one.
However, its name must be unique, so it is not possible 
to specify an existing one. Also, it is not possible 
to rename an item while editing.

The item you created can be deleted as long as it is
not already listed in the deliveries and departures history.
You can also search for an item by its name.

### Transporters 
This section gives you an overview of the transporters.
The transporter ID is unique, therefore creating new,
editing and deleting transporters is analogous to the items 
section.

### Warehousemen
Here you can view the list of warehousemen 
(application users) working in the warehouse.
There is also the logout button here.

### Deliveries and Departures
These are the most important sections of the application.
Here is the history of all deliveries or departures.
To collect delivery or create departure, click on the 
appropriate buttons.
Next, enter the ID of the item that you want to move, and
the number of pallets.
The warehouseman ID matches the logged-in user.
Selecting a transporter is optional.

### Other info
The application gets data from the data.sql file.
The changes will be lost after restarting the application.

## Technologies
- Java 11
- Apache Maven
- Spring Boot 2.4.5
- Spring Web MVC
- Spring Data
- Thymeleaf
- H2 Database
