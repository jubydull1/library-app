# Library Management  App
Its a Simple Library Management System.
There are 5 API's for doing operation like register book and borrower.Get All list of the books and borrow and return a book.

# Steps to Setup
# Clone the application


# Build and run the app using maven

mvn clean install
java -jar target/api-library-0.0.1-SNAPSHOT
Alternatively, you can run the app without packaging it using -

mvn spring-boot:run
The app will start running at http://localhost:6868/

# Api Documentation
For Api Documentation used Open API url http://localhost:6868/swagger-ui/index.html
For Health Check used API : http://localhost:6868/actuator/health/

# Container
For Containerize used Docker.can run with command docker-compose up --build.


## Explore Rest APIs
* To Register new Borrower /api/v1/borrowers
* To Get ALl books used GET  /api/v1/books
* To Register new Book use POST /api/v1/books
* To Borrow a book /v1/borrow-book/{bookId}/books/{borrowerId}/borrow
* To Return a book /v1/borrow-book/{bookId}/books/{borrowerId}/return
