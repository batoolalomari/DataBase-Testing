import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mysql.cj.xdevapi.Result;

public class EmployeesDBTest {

	Connection con;
	Statement stmt;
	Result rs;

	@BeforeTest
	public void SetUp() throws SQLException {
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "123123");

	}

	@Test(priority = 1)
	public void addData() throws SQLException {
		String query = "insert into employees (employeeNumber,lastName,firstName,extension,email,officeCode,reportsTo,jobTitle)\r\n"
				+ "values (1234,'omar','azzam','o1234','omarazzam@gamil.com','1',1002,'President')";
		stmt = con.createStatement();
		int addResult = stmt.executeUpdate(query);
		Assert.assertEquals(addResult > 0, true, "row dose not added");

	}

	@Test(priority = 2)
	public void updateData() throws SQLException {
		String query = "update employees set employeeNumber=4321 where employeeNumber=1234";
		stmt = con.createStatement();
		int result = stmt.executeUpdate(query);
		Assert.assertEquals(result > 0, true, "row dose not updated");

	}

	@Test(priority = 3)
	public void getData() throws SQLException {
		String query = "select * from employees where employeeNumber=4321";
		stmt = con.createStatement();
		stmt.executeQuery(query);

	}

	@Test(priority = 4)
	public void deleteData() throws SQLException {
		String query = "delete from employees where employeeNumber=4321";
		stmt = con.createStatement();
		int result = stmt.executeUpdate(query);
		Assert.assertEquals(result > 0, true);

	}

}
