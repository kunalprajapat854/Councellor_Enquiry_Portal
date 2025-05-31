                                  Spring Boot Mini Project 2 - Councellor Enquiry Portal 
This is a Spring Boot web application that allows counsellors to manage student enquiries. Each counsellor can create, view, and manage multiple enquiries. The application uses a layered architecture with Thymeleaf for the front-end and MySQL as the database.

**Features:**

* Counsellor Registration and Login

* Add New Enquiry

* Edit Enquiry

* View Enquiry List

* Search Enquiries (by Class Mode, Course, and Status)

* Dashboard with enquiry statistics

* Session Management for logged-in counsellors

* Duplicate Email Check during registration

---
**Database Design:**

COUNCELLOR

│
├── COUNCELLORID (Primary Key)

├── NAME

├── EMAIL

├── PASSWORD

└── PHONE

      │
      └── ENQUIRY (One Counsellor → Many Enquiries)
            ├── ENQUIRYID (Primary Key)
            ├── NAME (Student Name)
            ├── PHONE (Student Phone)
            ├── CLASSMODE (Online / Offline)
            ├── COURSE
            ├── STATUS (New / Enrolled / Lost)
            └── COUNCELLORID (Foreign Key → COUNCELLOR)

**Relationship:**

One-to-Many: One counsellor can create multiple enquiries.

The ENQUIRY table contains a foreign key COUNCELLORID that references the COUNCELLOR table.

---


         Application Layers:

**Repository Layer:**

CouncellorRepo – handles Counsellor entity

EnquiryRepo – handles Enquiry entity

**Service Layer:**

          CouncellorService.java
boolean login(String email, String password)

Councellor register(Councellor councellor)

boolean duplicateEmailCheck(String email)

DashboardResponse response(Integer counsellorId)

          EnquiryService.java:

boolean addEnquiry(Integer counsellorId, Enquiry enq)

List<Enquiry> getAllEnq(Integer counsellorId)

List<Enquiry> viewRequestEnq(Integer counsellorId, ViewRequestEnq requestEnq)

Enquiry editEnq(Integer enqId)

---
           UI Pages

index.html	    -       Login page

register.html    -    	Counsellor registration page

dashboard.html	 -     Dashboard showing enquiry summary

enquiry.html    -    	Form to add/edit enquiry

view-enq.html	   -     Search and view enquiries

---

         Session Management
After login, the counsellor's ID is stored in the HTTP session.

This ID is used to manage and display data specific to the logged-in counsellor.

---

    Search Functionality
* Implemented using Spring Data JPA Query by Example (QBE)

*  Allows filtering enquiries based on:

* Class Mode

* Course

* Status

---

       How to Run the Project
  
**Clone the repository:**

'git clone https://github.com/your-username/counsellor-enquiry-portal.git

---

    Configure MySQL in application.properties:
* spring.datasource.url=jdbc:mysql://localhost:3306/enquiry_db
* spring.datasource.username=root

* spring.datasource.password=yourpassword

* spring.jpa.hibernate.ddl-auto=update

---

    Run the application:
     
*  mvn spring-boot:run

Access the application at:

'http://localhost:8080/'









