package com.lulu.mini_Project;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BusinessLogic {

	//CRUD Operations
	void createData() throws SQLException {
		Connection connection = ConnectDB.setupConnection();
		String query ="INSERT INTO products ( id, name, descp,cost ) VALUES( ?,?,?,?)";
//		String query = "insert values into employee(? ,? ,?)  ";
		PreparedStatement myStmt = connection.prepareStatement(query);
		myStmt.setInt(1, 6666);
		myStmt.setString(2, "Laptop");
		myStmt.setString(3, "Electronics");
		myStmt.setInt(4, 6000);

		int success = myStmt.executeUpdate();
		System.out.println("Added Successfully " + success);
     	}

	void readData() throws SQLException {


		Connection connection=ConnectDB.setupConnection();

		 Statement statement;
		 statement = connection.createStatement();
         ResultSet resultSet;
         resultSet = statement.executeQuery(
             "select * from products where id>=1111");
         int id;
         String name;
         String descp;
         int cost;
         while (resultSet.next()) {
             id = resultSet.getInt("id");
             name = resultSet.getString("name");
             descp=resultSet.getString("descp");
             cost = resultSet.getInt("cost");
             System.out.println("id : " + id
                                + " name : " + name +"  descp:"+ descp + "cost: " +cost);
         }
	}

	void updateData() throws SQLException {


		Connection connection = ConnectDB.setupConnection();
		String query = "update products set name= ? where id = ? ";
		PreparedStatement myStmt = connection.prepareStatement(query);
		myStmt.setString(1, "paint");
		myStmt.setInt(2, 3333);
		boolean success = myStmt.execute();
		System.out.println(" Successfully " + success);



	}


	void deletData() throws SQLException {
		Connection connection = ConnectDB.setupConnection();
		String query = "delete from products where id = ? ";
		PreparedStatement myStmt = connection.prepareStatement(query);
		myStmt.setInt(1, 6666);
		boolean success = myStmt.execute();
		System.out.println("Deleted Successfully " + success);



	}
	}



/*
  void updateData() throws SQLException {

			Connection connection = ConnectDB.setupConnection();

			String query = "update products set name = ? where id = ? ";

			PreparedStatement myStmt = connection.prepareStatement(query);

			myStmt.setString(1, "paint");

			myStmt.setInt(2, 555);

			boolean success = myStmt.execute();

			System.out.println("Updated Successfully " + success);



		}

		void deleteData() throws SQLException {

			Connection connection = ConnectDB.setupConnection();

			String query = "delete from products where id = ? ";

			PreparedStatement myStmt = connection.prepareStatement(query);

			myStmt.setInt(1, 666);

			boolean success = myStmt.execute();

			System.out.println("Deleted Successfully " + success);



		}
 */


