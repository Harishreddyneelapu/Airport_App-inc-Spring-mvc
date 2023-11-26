# Airport_App-inc-Spring-mvc

Airport_App
The Airport_App is a comprehensive web application developed using Spring MVC and Hibernate, designed to streamline and manage various aspects of airport operations, with a focus on runway and taxi services. This application offers a user-friendly interface for efficiently handling crucial airport functionalities.

Key Features
Runway Management
Add New Runways: Easily input details such as length, width, surface type, and direction for new runways.

Update Runway Information: Modify runway details using the unique Runway ID.

View Runway List: Access a comprehensive list of all runways within the system.

Delete Runways: Remove runways from the system by specifying the Runway ID.

Taxi Management
Add New Taxis: Input essential details including model, driver name, current location, and availability for new taxis.

Update Taxi Information: Modify taxi details based on the unique Taxi ID.

View Taxi List: Access a complete list of all taxis registered in the system.

Delete Taxis: Remove taxis from the system by specifying the Taxi ID.

Airport Operations
Search for Airports: Easily find airports by name or ID.

Delete Airports: Remove airports from the system by specifying the Airport ID or name.

Update Airport Information: Modify airport details using the unique Airport ID or name.

View Airport List: Access a comprehensive list of all registered airports.

Technologies Used
Spring MVC: Used for building the web application, managing controllers, and handling HTTP requests.

Hibernate: Integrated for efficient object-relational mapping and database operations.

MySQL: Utilized as the relational database management system for data storage.

Java: The primary programming language for the backend logic and business operations.

Setup Instructions
Database Setup:

Create a MySQL database named airport.
Configure the hibernate.cfg.xml file in the WEB-INF directory with your database connection details.
Project Import:

Import the project into your preferred Java development environment (e.g., Eclipse, IntelliJ).
Dependency Management:

Ensure Maven is installed and configured.
Resolve dependencies by running mvn clean install.
Server Deployment:

Deploy the application on a servlet container (e.g., Apache Tomcat).
Access the Application:

Access the application through the specified URL (default is http://localhost:8080/Airport_App).
Usage
Navigate to the different endpoints for runway, taxi, and airport management as specified in the dispatcherServlet mappings in the web.xml file.
Contributors
NEELAPU HARISH REDDY
Feel free to contribute to the project by submitting issues or pull requests. Your feedback and suggestions are highly appreciated!
