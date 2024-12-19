An example for JDBC prepared statement with ResultSet
ResultSet interface
The object of ResultSet maintains a cursor pointing to a row of a table.
Initially, cursor points to before the first row.
Commonly used methods of ResultSet interface
Method Name Description
public boolean next(): is used to move the cursor to the one row next
from the current position.
public boolean previous(): Is used to move the cursor to the one row
previous from the current position.
public boolean first(): Is used to move the cursor to the first row in
result set object.
public boolean last(): Is used to move the cursor to the last row in
result set object.
public int getInt(int
columnIndex):
Is used to return the data of specified column
index of the current row as int.
public int getInt(String
columnName):
Is used to return the data of specified column
name of the current row as int.
public String getString(int
columnIndex):
Is used to return the data of specified column
index of the current row as String.
public String
getString(String
columnName):
Is used to return the data of specified column
name of the current row as String.
PreparedStatement interface
The PreparedStatement interface is a subinterface of Statement. It is used to
execute parameterized query.
Let's see the example of parameterized query:
String sql="insert into emp values(?,?,?)";
As you can see, we are passing parameter (?) for the values. Its value will be set by calling
the setter methods of PreparedStatement.
As you can see, we are passing parameter (?) for the values. Its value will be set by calling
the setter methods of PreparedStatement.
50
Why use PreparedStatement?
Improves performance: The performance of the application will be faster if
you use PreparedStatement interface because query is compiled only once.
How to get the instance of PreparedStatement?
The prepareStatement() method of Connection interface is used to return the
object of PreparedStatement. Syntax:
public PreparedStatement prepareStatement(String query)throws SQLException{}
Methods of PreparedStatement interface
The important methods of PreparedStatement interface are given below:
Method Description
public void setInt(int
paramIndex, int value)
Sets the integer value to the given parameter index.
public void setString(int
paramIndex, String
value)
Sets the String value to the given parameter index.
public void setFloat(int
paramIndex, float value)
Sets the float value to the given parameter index.
public void setDouble(int
paramIndex, double
value)
Sets the double value to the given parameter index.
public int
executeUpdate()
Executes the query. It is used for create, drop, insert, update,
delete etc.
public ResultSet
executeQuery()
Executes the select query. It returns an instance of ResultSet.
Step 1: Create table in oracle database called prod with the following columns
Create table prod(p_pid number(5),p_name varchar2(20),p_price number(5,2));
Insert 3-4 records.
import java.io.*;
import java.sql.*;
class jdb_pre_stmt_dyn{
public static void main(String args[]){
try{
//step1 load the driver class
Class.forName("oracle.jdbc.driver.OracleDriver");
//step2 create the connection object
51
Connection con=DriverManager.getConnection(
"jdbc:oracle:thin:@192.168.0.3:1521:orcl","cse3","cse3");
//step3 create the statement object
Statement stmt=con.createStatement();
PreparedStatement pstmt=con.prepareStatement("insert into prod values(?,?,?)");
try{
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
System.out.println("Enter prod ID No");
int no=Integer.parseInt(br.readLine());
System.out.println("Enter prod Name");
String name=br.readLine();
System.out.println("Enter prod Price");
double price=Double.parseDouble(br.readLine());
pstmt.setInt(1,no);
pstmt.setString(2,name);
pstmt.setDouble(3,price);
pstmt.executeUpdate();
System.out.println("One row inserted");
}
catch(SQLException sqle)
{
System.out.println("Could not insert tuple" +sqle);
}
//step4 execute query
ResultSet rs=stmt.executeQuery("select * from prod");
System.out.println("p_id\t"+"p_name\t"+"p_price\t");
System.out.println("===========================");
while(rs.next())
System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
//step5 close the connection object
pstmt.close();
stmt.close();
con.close();
}catch(Exception e){ System.out.println(e);} } }