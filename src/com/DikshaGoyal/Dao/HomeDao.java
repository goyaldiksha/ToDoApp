package com.DikshaGoyal.Dao;

import java.util.ArrayList;
import com.DikshaGoyal.Model.Session;
import com.DikshaGoyal.Model.TaskDetails;
import com.DikshaGoyal.Model.User;

public interface HomeDao {

	User checkUser(User u) throws Exception;

	void newProfile(User u) throws Exception;

	void addTask(TaskDetails u) throws Exception;
	
	void addSession(Session u) throws Exception;

	Session getSession(String sessionId) throws Exception;

	ArrayList<TaskDetails> getTask(int userId) throws Exception;

	void logout(String sessionId) throws Exception;

	void delete(int id) throws Exception;

	void complete(int id) throws Exception;
}
