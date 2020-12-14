# CS4125 45%

45% Project for CS4125 - SYSTEMS ANALYSIS AND DESIGN

Members of this team: 

    Darragh O'Donnell - 17239567 
    Mateusz Tyrkiel - 17204097 
    Ryan O'Connor - 17209382
    Jonathan Ryley - 17211501

Meetings: 

    Every Monday at 13:30 PM to 14:30 PM  
    In this time we will discuss issues related to the project and update on what we have achieved in the week!
    Don't miss this meeting.

Deadline:

    Monday 14th December 2020 - WEEK 12

Meeting attendance:
    Meeting attendance:
        19/10/2020 13:30-14:00
            Everyone
        26/10/2020 13:30–14:00
            Everyone
        02/11/2020 13:30-14:00
            Everyone
        09/11/2020 13:30-14:00
            Everyone
        16/11/2020 13:30-14:00
            Everyone
        23/11/2020 13:30-14:00
            Everyone
        27/11/2020 16:00-16:45
            Everyone
        30/11/2020 13:30-14:00
            Everyone
        04/11/2020 16:00-16:45
            Everyone
        07/12/2020 13:30-14:00 & 18:00-21:00
            Everyone
        13/12/2020 - 14/12/2020
            Everyone


Dance Manager Studio:
Requirements:
	IDE:         		Netbeans IDE 8.2 RC
	WebServer:   		GlassFish 4.0, XAMPP (Apache, MYSQL)
	JDK:         		1.8.0
	Version Control:	GitHub
 
Installation:
	Install Netbeans IDE 8.2 RC from this link: https://netbeans.org/downloads/8.2/rc/
	Install GlassFish 4.0 from this link: https://javaee.github.io/glassfish/download
	Install XAMPP from this link: https://www.apachefriends.org/download.html
	Install JDK from this link: https://www.oracle.com/ie/java/technologies/javase/javase8-archive-downloads.html

Setup:
	After installing XAMPP open the XAMPP control panel and start the Apache and MySQL modules from the action menu.
	Open this link http://localhost/phpmyadmin/ in an internet browser of choice.
	From the project folder, find dance.sql and upload it to the link just opened using the steps below:
		Create database give it a name 'dance' and click create.
		When the database is created in the top menu bar you will see import.
		Choose Choose file and open the dance.sql that was located and saved earlier.
		Ensure that the format is set to SQL and click 'GO'.
		You have successfully set up the database.
	Open Netbeans which you have installed previously and follow the following configuration:
		Connect database to netbeans:
			Open the services tab .
			Click down on databases.
			Right click on MYSQL server and click create database.
			Name it the same as the XAMPP database 'dance' and click ok.
			Press file and click open file.
			Find where you located the dance.sql file and click open.
			Open the sql file.
			Click the drop down to the right of Connection and select the database.
			Next click the Run SQL button.
		Open projects on Netbeans:
			Click file and select Open Project.
			With this method, open the DanceSchool(Server) and DanceManagerStudioClient(Client).
			If asked for server selection, select GlassFish 4.0.
		Running the webservice:
			Right click on the Dance School project.
			Select Run.
		Running the application:
			Right click the DanceManagerStudioClient select clean and build.
			Right click the DanceManagerStudioClient select run.

