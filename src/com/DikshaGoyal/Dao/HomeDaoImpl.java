package com.DikshaGoyal.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.DikshaGoyal.Model.Session;
import com.DikshaGoyal.Model.TaskDetails;
import com.DikshaGoyal.Model.User;


@Repository
public class HomeDaoImpl implements HomeDao{
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public User checkUser(User u) throws Exception {
        Connection connection = null;
        try {    
	        connection = jdbcTemplate.getDataSource().getConnection();
	        PreparedStatement stmt = connection.prepareStatement("Select * from userDetails where email=?");
	        stmt.setString(1, u.getEmail());
	        ResultSet rs = stmt.executeQuery();
	        return rs.next() ? new User(rs.getString("name"), rs.getString("email"), rs.getInt("id"), rs.getString("password")) : null;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw e;
        }
	}

	@Override
	public void newProfile(User u) throws Exception {
		// TODO Auto-generated method stub
        Connection connection = null;
        try {    
	        connection = jdbcTemplate.getDataSource().getConnection();
	        PreparedStatement stmt = connection.prepareStatement("INSERT INTO userDetails (name, email, password) VALUES (?,?,?)");
	        stmt.setString(1, u.getName());
	        stmt.setString(2, u.getEmail());
	        stmt.setString(3, u.getPass());
	        stmt.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw e;
        }
	}

	@Override
	public void addTask(TaskDetails u) throws Exception {
		Connection connection = null;
		try{
        connection = jdbcTemplate.getDataSource().getConnection();
        PreparedStatement stmt = connection.prepareStatement("INSERT INTO taskDetail (uid, name, dueDate, completed) VALUES (?,?,?,?)");
        stmt.setInt(1, u.getUserId());
        stmt.setString(2, u.getName());
        stmt.setString(3, u.getDate());
        stmt.setInt(4, 0);
        stmt.executeUpdate();
		}
		catch (Exception e){
			throw e;
		}
	}

	@Override
	public void addSession(Session u) throws Exception {
		Connection connection = null;
		try{
        connection = jdbcTemplate.getDataSource().getConnection();
        PreparedStatement stmt = connection.prepareStatement("INSERT INTO SESSION (SessionId, UserId) VALUES (?,?)");
        stmt.setString(1, u.getSessionId());
        stmt.setInt(2, u.getUserId());
        stmt.executeUpdate();
		}
		catch (Exception e){
			throw e;
		}
	}

	@Override
	public Session getSession(String sessionId) throws Exception {
		// TODO Auto-generated method stub
		Connection connection = null;
        try {    
	        connection = jdbcTemplate.getDataSource().getConnection();
	        PreparedStatement stmt = connection.prepareStatement("Select * from session where sessionId=?");
	        stmt.setString(1, sessionId);
	        ResultSet rs = stmt.executeQuery();
	        return rs.next() ? new Session(rs.getString("sessionId"), rs.getInt("userId")) : null;
        }catch(Exception e){
        	throw e;
        }
	}

	@Override
	public ArrayList<TaskDetails> getTask(int userId) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<TaskDetails> list=new ArrayList<>();
		Connection connection = null;
        try {    
	        connection = jdbcTemplate.getDataSource().getConnection();
	        PreparedStatement stmt = connection.prepareStatement("Select * from taskDetail where uid=?");
	        stmt.setInt(1, userId);
	        ResultSet rs = stmt.executeQuery();
	        while(rs.next()){
	        	TaskDetails ob=new TaskDetails();
	        	System.out.println("Task Id "+rs.getInt("id"));
	        	ob.setId(rs.getInt("id"));
	        	ob.setName(rs.getString("name"));
	        	ob.setDate(rs.getString("dueDate"));
	        	ob.setCompleted(rs.getInt("completed"));
	        	list.add(ob);
	        }
	        return list;   
        }
	catch(Exception e){
        	throw e;
        }
	}

	@Override
	public void logout(String sessionId) throws Exception {
		// TODO Auto-generated method stub
		Connection connection = null;
        try {    
	        connection = jdbcTemplate.getDataSource().getConnection();
	        PreparedStatement stmt = connection.prepareStatement("delete from session where sessionId=?");
	        stmt.setString(1, sessionId);
	        int rs = stmt.executeUpdate();
	        System.out.println(rs+" records deleted");  
        }
	catch(Exception e){
        	throw e;
        }
	}

	@Override
	public void delete(int id) throws Exception {
		// TODO Auto-generated method stub
		Connection connection = null;
        try {    
	        connection = jdbcTemplate.getDataSource().getConnection();
	        PreparedStatement stmt = connection.prepareStatement("delete from taskDetail where id=?");
	        stmt.setInt(1, id);
	        int rs = stmt.executeUpdate();
	        System.out.println(rs+" records deleted");  
        }
	catch(Exception e){
        	throw e;
        }
	}

	@Override
	public void complete(int id) throws Exception {
		// TODO Auto-generated method stub
		Connection connection = null;
        try {    
	        connection = jdbcTemplate.getDataSource().getConnection();
	        PreparedStatement stmt = connection.prepareStatement("update taskDetail set completed=? where id=?");
	        stmt.setBoolean(1, true);
	        stmt.setInt(2, id); 
	        stmt.executeUpdate();
        }
	catch(Exception e){
        	throw e;
        }
	}

}
