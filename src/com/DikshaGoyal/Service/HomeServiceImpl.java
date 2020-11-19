package com.DikshaGoyal.Service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DikshaGoyal.Model.Session;
import com.DikshaGoyal.Model.TaskDetails;
import com.DikshaGoyal.Model.User;
import com.DikshaGoyal.Dao.HomeDao;

@Service
public class HomeServiceImpl implements HomeService{

	@Autowired
	HomeDao hd;
	
	@Override
	public User checkUser(User u) throws Exception {
		// TODO Auto-generated method stub
		return hd.checkUser(u);
	}

	@Override
	public void newProfile(User u) throws Exception {
		// TODO Auto-generated method stub
		hd.newProfile(u);
	}

	@Override
	public void addTask(TaskDetails u) throws Exception {
		// TODO Auto-generated method stub
		hd.addTask(u);
	}

	@Override
	public void addSession(Session u) throws Exception {
		// TODO Auto-generated method stub
		hd.addSession(u);
	}

	@Override
	public Session getSession(String sessionId) throws Exception {
		// TODO Auto-generated method stub
		return hd.getSession(sessionId);
	}

	@Override
	public ArrayList<TaskDetails> getTask(int userId) throws Exception {
		// TODO Auto-generated method stub
		return hd.getTask(userId);
	}

	@Override
	public void logout(String sessionId) throws Exception {
		// TODO Auto-generated method stub
		hd.logout(sessionId);
	}

	@Override
	public void delete(int id) throws Exception {
		// TODO Auto-generated method stub
		hd.delete(id);
	}

	@Override
	public void complete(int id) throws Exception {
		// TODO Auto-generated method stub
		hd.complete(id);
	}

}
