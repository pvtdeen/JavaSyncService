
#  JAVA SYNC SERVICES

this project sync data from csv to MYSQL and you can also update CSV;


## Tecchnologies Used

Database : MYSQL database \
JAVA\
JDBC driver \
OpenCSV library \

## Tools 
IntelliJIDEA IDE \
XAMMP  \
Notepad 
JDK version "16.0.2"
  # Getting Started

  ## Creating DataBase
  1. Open MySQL 
  2. Run Below Query
  ```bash
  CREATE DATABASE csvdb;
  CREATE TABLE csv (
    s_no bigint(255)
    timestamp varchar(255),
    ver varchar(255),
    product_family  varchar(255),
    country varchar(255),
    device_type  varchar(255),
    os varchar(255),
    checkout_failure_count  varchar(255),
    payment_api_failure_count varchar(255),
    purchase_count  varchar(255),
    revenue  varchar(255)
    PRIMARY KEY(s_no)
);
```
3. open given code in your IDE.
4. wait for Dependencies to install.
5. change user and password in javasyncservice class
6. run the Start.main();

  
## Screenshots

![App Screenshot](/Screenshots/Screenshot%202022-04-24%20153833.png)
![App Screenshot](/Screenshots/Screenshot%202022-04-24%20154058.png)
![App Screenshot](/Screenshots/Screenshot%20(85).png)
![App Screenshot](/Screenshots/Screenshot%20(86).png)
update USER AND pASSWORD HERE !
![App Screenshot](/Screenshots/Screenshot%20(87).png)
DEPENDENCIES
![App Screenshot](/Screenshots/Screenshot%202022-04-24%20155956.png)


