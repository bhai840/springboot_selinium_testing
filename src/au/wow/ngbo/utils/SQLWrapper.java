/**
 * This class connects to RC DB, executes the query 
 * and return results in List<List<Object>> 
 * 
 * To execute a query, call the below method
 * SQLWrapper sql = new SQLWrapper(log);
 * List<List<Object>> results = sql.executeQuery(getContext(), Query)
 */
/*package au.wow.ngbo.utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;*/

//import au.wow.ngbomain.tests.StoreProperties;


/*public class SQLWrapper extends StoreProperties{

	Connection con = null;
	Statement stmt = null;
	ResultSet rs;
	Logger log;
	
	
	public SQLWrapper(Logger log){
		this.log=log;
	}
	
	*//**
	 * Establishes a connection to RC DB
	 * @param context
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 *//*
	public void connectToRCDB(TestContext context) throws SQLException {
		String uid1,pwd1,eng,database,host;
		if(System.getProperty("store")==null){ 
			uid1 = context.getStringProperty("uid1");
			pwd1 = context.getStringProperty("pwd1");
			eng = context.getStringProperty("eng");
			database = context.getStringProperty("database");
			host = context.getStringProperty("host");
		}else{
			uid1 = user;
			pwd1 = pwd;
			eng = eng1;
			database = database1;
			host = host1;
		}
		
		System.out.println("engine"+eng1);
		String dburl = "jdbc:sqlanywhere:uid="+ uid1 +";pwd="+pwd1+";eng="+eng+ ";database="+database+";links=tcpip(host="+host+")";
		con = DriverManager.getConnection(dburl);
			try {
				//Class.forName("oracle.jdbc.driver.OracleDriver");
				String dburl = "jdbc:sqlanywhere:uid="+ uid1 +";pwd="+pwd1+";eng="+eng+ ";database="+database+";links=tcpip(host="+host+")";
				con = DriverManager.getConnection(dburl);
			} catch (SQLException e) {
				Assert.fail("Error occurred in establishing a connection", e.fillInStackTrace());
			}
		}
	
	//Connect to RC DB
	public void connectToRCDatabase(TestContext context){		
		String dbURL = context.getStringProperty("dbURL");
		String dbuserid = context.getStringProperty("dbuserid");
		String dbpwd = context.getStringProperty("dbpassword");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(dbURL,dbuserid, dbpwd);
		} catch (ClassNotFoundException e) {
			Assert.fail("OracleDriver class is not loaded/found", e.fillInStackTrace());
		} catch (SQLException e) {
			Assert.fail("Error occurred in establishing a connection", e.fillInStackTrace());
		}
	}
	
	public List<List<Object>> executeQueryRC(TestContext context, String Query) throws Exception{
		connectToRCDatabase(context);
		createStatement();
		executeQuery(Query);
		List<List<Object>> results= getResults();
		closeConnection();
		//Report_AddStep("testcase", Query,"","","Pass");
		return results;
	}
	
	//PromoBuild_RC
	public List<List<Object>> updateQueryRC(TestContext context, String Query) throws SQLException{
		//System.out.println(Store);
		connectToRCDatabase(context);
		createStatement();
		executeQuery(Query);
		List<List<Object>> results= null;
		closeConnection();
		return results;
	}
	
	public void connectToRCDBStore(TestContext context, String Store) throws SQLException {
		String uid1,pwd1,eng,database,host;
		StoreProperties.getStoreDetails(Store);
			uid1 = user;
			pwd1 = pwd;
			eng = eng1;
			database = database1;
			host = host1;
		
			String dburl = "jdbc:sqlanywhere:uid="+ uid1 +";pwd="+pwd1+";eng="+eng+ ";database="+database+";links=tcpip(host="+host+")";
			con = DriverManager.getConnection(dburl);
			try {
				//Class.forName("oracle.jdbc.driver.OracleDriver");
				String dburl = "jdbc:sqlanywhere:uid="+ uid1 +";pwd="+pwd1+";eng="+eng+ ";database="+database+";links=tcpip(host="+host+")";
				con = DriverManager.getConnection(dburl);
			} catch (SQLException e) {
				Assert.fail("Error occurred in establishing a connection", e.fillInStackTrace());
			}
		}
	
	*//**
	 * Creates a connection statement
	 * @throws SQLException 
	 *//*
	public void createStatement() throws SQLException{
		stmt=con.createStatement();
		try {
			stmt=con.createStatement();
		} catch (SQLException e) {
			Assert.fail("Error in creating the statement", e);
		}
	}
	
	*//**
	 * Establishes connection to RC DB, executes query, return results and closing the connection 
	 * @param context
	 * @param Query
	 * @return ResultSet
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 *//*
	public List<List<Object>> executeQuery(TestContext context, String Query) throws SQLException{
		connectToRCDB(context);
		createStatement();
		executeQuery(Query);
		List<List<Object>> results= getResults();
		closeConnection();
		return results;
	}
	
	public List<String> executeQueryList(TestContext context, String Query) throws SQLException{
		connectToRCDB(context);
		createStatement();
		executeQuery(Query);
		List<String> results= getResultsList();
		closeConnection();
		return results;
	}

	public List<String> getResultsList() throws SQLException{
		List<String> results = new ArrayList<String>();
		if(rs!=null){
			int columnsize = rs.getMetaData().getColumnCount();
			while(rs.next()){
			List<String> row = new ArrayList<>(columnsize);
			for(int i=1;i<=columnsize;i++){
			row.add(rs.getString(i));
			}
			results.addAll(row);}
		try {
		int columnsize = rs.getMetaData().getColumnCount();
		while(rs.next()){
		List<String> row = new ArrayList<>(columnsize);
		for(int i=1;i<=columnsize;i++){
		row.add(rs.getString(i));
		}
		results.addAll(row);

		}
		} catch (SQLException e) {
		e.printStackTrace();
		System.out.println(e);
		Assert.fail("Error in processing DB results", e);
		}
		}
		if(con!=null){
			con.close();
		try {
		con.close();
		} catch (SQLException e) {
		Assert.fail("Error in closing the connection", e.fillInStackTrace());
		}
		}

		return results;
		}
	
	public List<List<Object>> executeQueryStore(TestContext context, String Query, String Store) throws SQLException{
		//System.out.println(Store);
		connectToRCDBStore(context, Store);
		createStatement();
		executeQuery(Query);
		List<List<Object>> results= getResults();
		closeConnection();
		return results;
	}

	*//**
	 * Establishes connection to RC DB, executes query, return results and closing the connection 
	 * @param context
	 * @param Query
	 * @return ResultSet
	 * @throws IOException 
	 * @throws SQLException 
	 *//*
	public void executeQuery_CUD(TestContext context, String Query) throws IOException, SQLException{
		connectToRCDB(context);
		createStatement();
		executeQuery(Query);
		con.commit();
		closeConnection();
		//Report_AddStep("testcase", Query,"","","Pass");
		
	}
	
	
	*//**
	 * Executes the query once connection is already established
	 * @param Query
	 * @return ResultSet
	 * @throws SQLException 
	 *//*
	
	public ResultSet executeQuery(String Query) throws SQLException{
		rs=stmt.executeQuery(Query);
		try {
 			//System.out.println(Query);
			rs=stmt.executeQuery(Query);
		} catch (SQLException e) {
			Assert.fail("Error in executing Query: " + Query, e.fillInStackTrace());
		}
		return rs;
	}
	
	
	*//**
	 * Close the connection once the queries are executed
	 * @throws SQLException 
	 *//*
	public void closeConnection() throws SQLException{
		if(con!=null){
			con.close();
			try {
				con.close();
			} catch (SQLException e) {
				Assert.fail("Error in closing the DB connection", e.fillInStackTrace());
			}
		}
	}
	
	*//**
	 * Converts resultset object into List<List<Object>>
	 * @return List<List<Object>> of results
	 * @throws SQLException 
	 *//*
	public List<List<Object>> getResults() throws SQLException{
		List<List<Object>> results = new ArrayList<List<Object>>();
		if(rs!=null){
			int columnsize = rs.getMetaData().getColumnCount();
			while(rs.next()){
				List<Object> row = new ArrayList<>(columnsize);
				for(int i=1;i<=columnsize;i++){
					row.add(rs.getObject(i));
				}
				results.add(row);
				
			}
			try {
				int columnsize = rs.getMetaData().getColumnCount();
				while(rs.next()){
					List<Object> row = new ArrayList<>(columnsize);
					for(int i=1;i<=columnsize;i++){
						row.add(rs.getObject(i));
					}
					results.add(row);
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(e);
				Assert.fail("Error in processing DB results", e);
			}
		}
		if(con!=null){
			con.close();
			try {
				con.close();
			} catch (SQLException e) {
				Assert.fail("Error in closing the connection", e.fillInStackTrace());
			}
		}
		
		return results;
	}
	
	public void executeQuery_CUDStore(TestContext context, String Query, String Store) throws IOException, SQLException{
	//	System.out.println(Store);
		connectToRCDBStore(context, Store);
		createStatement();
		executeQuery(Query);
		con.commit();
		closeConnection();
		//Report_AddStep("testcase", Query,"","","Pass");

		}
		
	public List<String> executeQueryStoreList(TestContext context, String Query, String Store) throws SQLException{
		//System.out.println(Store);
		connectToRCDBStore(context, Store);
		createStatement();
		executeQuery(Query);
		List<String> results= getResultsList();
		closeConnection();
		return results;
	}
	
}
	*/

