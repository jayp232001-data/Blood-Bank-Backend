# Blood-Bank-Backend
Blood-Bank-Backend
🩸 Blood Bank Backend

The Blood Bank Backend is a Spring Boot REST API system for managing blood donors, blood stock, and blood requests. It handles core blood bank operations such as adding donors, tracking inventory, and processing blood requests. This backend is designed with a clean layered architecture and MySQL integration.




🚀 Features

Donor registration & full CRUD operations

Blood stock management with auto-initialization

Blood request creation & status updates

Hospital-side integration ready

MySQL + JPA + Hibernate

Clean architecture (Controller → Service → Repository)

Error-free startup with auto stock creation




🛠️ Tech Stack

Java 17

Spring Boot

Spring Web

Spring Data JPA

Hibernate

MySQL

Maven




📂 Project Structure
src/main/java/com/example/demo
│── controller
│── service
│── repository
│── model
│── config
│── BloodBankBackendApplication.java





⚙️ Setup Instructions
1️⃣ Clone the Repository
git clone https://github.com/jayp232001-data/Blood-Bank-Backend.git
cd Blood-Bank-Backend





2️⃣ Create MySQL Database
CREATE DATABASE bloodbank_db;




3️⃣ Add Database Config to application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/bloodbank_db?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true





🩸 Blood Stock Auto Initialization

On application startup, if the blood stock table is empty, the system inserts default 3-digit quantities:

Blood Group	Quantity
A+	120
A−	110
B+	150
B−	130
AB+	140
AB−	100
O+	160
O−	115

✔ Runs only once when table is empty
✔ Does NOT throw errors if stock already exists




📡 API Endpoints
🔹 Donor APIs
Method	Endpoint	Description
GET	/api/donors	Get all donors
POST	/api/donors	Add new donor
GET	/api/donors/{id}	Get donor by ID
PUT	/api/donors/{id}	Update donor
DELETE	/api/donors/{id}	Delete donor




🔹 Blood Stock APIs
Method	Endpoint	Description
GET	/api/bloodstock	List blood stock
POST	/api/bloodstock/add	Add blood units
PUT	/api/bloodstock/update/{id}	Update blood quantity





🔹 Blood Request APIs
Method	Endpoint	Description
POST	/api/requests	Create blood request
GET	/api/requests	Get all requests
PUT	/api/requests/{id}	Update request status
▶️ Run the Application
mvn spring-boot:run

🧪 Testing
mvn test




📘 API Documentation (If Swagger added)
http://localhost:8080/swagger-ui/index.html




🤝 Contributing

Pull requests and suggestions are welcome.


👨‍💻 Author

Jay Patil
GitHub: https://github.com/jayp232001-data
