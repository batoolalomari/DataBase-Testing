import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mysql.cj.xdevapi.Result;

public class CustomersDbTest {

	Connection con;
	Statement stmt;
	Result rs;

	@BeforeTest
	public void SetUp() throws SQLException {
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "123123");

	}

	@Test(priority = 1)
	public void addDate() throws SQLException {
		String query = "insert  into customers (customerNumber,customerName,contactLastName,contactFirstName,phone,addressLine1,addressLine2,city,state,postalCode,country,salesRepEmployeeNumber,creditLimit) values (987,'omar','azzam','omar','6175552555', '6251 Ingle Ln.', NULL, 'Boston', 'MA', '51003', 'USA', 1188, '85100.00');";

		stmt = con.createStatement();
		int result = stmt.executeUpdate(query);
		Assert.assertEquals(result > 0, true);

	}

	@Test(priority = 2)
	public void updateDate() throws SQLException {
		String query = "update customers set customerNumber=1234 where customerNumber=987;";
		stmt = con.createStatement();
		int result = stmt.executeUpdate(query);
		Assert.assertEquals(result > 0, true);
	}

	@Test(priority = 3)
	public void getDate() throws SQLException {
		String query = "select * from customers where customerName='omar';";
		stmt = con.createStatement();
		stmt.executeQuery(query);

	}

	@Test(priority = 4)
	public void deleteDate() throws SQLException {
		String query = "delete from customers where customerNumber=1234;";
		stmt = con.createStatement();
		int result = stmt.executeUpdate(query);
		Assert.assertEquals(result > 0, true);
	}

}
