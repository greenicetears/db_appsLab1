package mypackage;
import java.sql.*;  
import java.util.*;

class mySqlCon{  
public static void main(String args[]){ 
	Scanner scan = new Scanner(System.in);
	int action;
	String name;
	String surname;
	int age;
	int del;
try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/new_schema?characterEncoding=latin1","root","Lamborghini1!");  

Statement stmt=con.createStatement();  

ResultSet rs=stmt.executeQuery("select * from Person");  

while(rs.next())  
System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+" "+rs.getInt(4));
System.out.print("To add data to the table, please type 1\n");
System.out.print("To delete data from the table, please type 2\n");
action = scan.nextInt();
if(action == 1) {
	System.out.print("Please Enter the Name: ");
	name = scan.next();
	System.out.print("Please Enter the Surname: ");
	surname = scan.next();
	System.out.print("Please Enter the Age: ");
	age = scan.nextInt();
	System.out.print("You have Added " + name + " " + surname + " " + age);
	int q = stmt.executeUpdate("INSERT INTO `new_schema`.`Person` (`Name`, `Surname`, `Age`) VALUES ('"+name+"', '"+surname+"', '"+age+"')");
}
else if(action == 2 ){
	System.out.print("Please insert the number of the row You want to delete: ");
	del = scan.nextInt();
	int de = stmt.executeUpdate("DELETE FROM Person WHERE id="+del);
	System.out.print("You have deleted row number "+ del);
	con.close();  
}
}
catch(Exception e){ System.out.println(e);}  
}  
}  
