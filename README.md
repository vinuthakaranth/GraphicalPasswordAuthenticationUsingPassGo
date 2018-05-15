# GraphicalPasswordAuthenticationUsingPassGo
This is a stand alone project in Java, which can be easily developed and tested on the system.

In this project, we are implementing the ‘PASS-GO’ technique which is a grid based scheme in order to overcome the drawbacks of traditional password schemes. 
Pass-Go requires a user to select (or touch) intersections, as a way to input a password, which is stored in a database during the initial registration process. 
User can give their password as a  set of points as well as multiple lines satisfying the constraints (i.e. intersections).
Later during the login process once the user logins with appropriate username and password, the process is success otherwise 2-3 attempts is given to correct his/her passwords for login.

This project has CLient side to perform the password authentication and server side to save the data of the client.

Microsoft Office Access, previously known as Microsoft Access, is used as a database for the project to store details of the intersection points, pictures and pattern.

Pass-Go is implemented using Java Swings. Pass-Go requires a user to select (or touch) intersections, As an intersection is actually a point, doesn’t have an area. 
Pass-Go is implemented based on a grid which is comprised of G horizontal and vertical lines. 
The gridframe class which extends JPanel contains grids of 300 (width)×300 (height)pixels.

