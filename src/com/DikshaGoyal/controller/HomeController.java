package com.DikshaGoyal.controller;


import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.DikshaGoyal.Model.Session;
import com.DikshaGoyal.Model.TaskDetails;
import com.DikshaGoyal.Model.User;
import com.DikshaGoyal.Service.HomeService;


@Controller
public class HomeController {
	@Autowired
	HomeService hs;
	
//	Home Page
	@RequestMapping(value="/")
	public String home(){
		return "index" ;	
	}
	
//	Login button
	@RequestMapping(value="login")
	public String loginHere(){
		return "login" ;	
	}
	
//	Check valid user
	@RequestMapping(value="checkUser")
	public String checkUser(HttpServletRequest req, User u,  HttpSession session) throws Exception{
		User user = hs.checkUser(u);
		if(user == null){
			req.setAttribute("msg", "User not found. Please check credentials");
			return "login";
		}
		else{
			Session newSession = new Session(UUID.randomUUID().toString(), user.getId());
			hs.addSession(newSession);
			req.setAttribute("msg", "Successfuly Logged In");
			req.setAttribute("email", u.getEmail());
			req.setAttribute("sessionId", newSession.getSessionId());
			System.out.println("Logged in");
			return "showTask";
		}
	}
	
//	signUp button
	@RequestMapping(value="signup")
	public String signUp(){
		return "register" ;	
	}
	
//	Register new user
	@RequestMapping(value="register")
	public String stProfile(HttpServletRequest req, User u) throws Exception{
		hs.newProfile(u);
		return "login";
	}
	
	
//	Pending task list
	@RequestMapping(value="pending")
	public String pendingTask(HttpServletRequest req, TaskDetails u) throws Exception{
		req.setAttribute("sessionId", (String)req.getParameter("sessionId"));
		String sessionId = (String)req.getParameter("sessionId");
		int userId = hs.getSession(sessionId).getUserId();
		ArrayList<TaskDetails> list=hs.getTask(userId);
		req.setAttribute("list", list);
		req.setAttribute("name", u.getName());
		req.setAttribute("dueDate", u.getDate());
		
		return "pendingTask";
	}
	
	
//	Add Task button
	@RequestMapping(value="add")
	public String add(HttpServletRequest req){
		req.setAttribute("sessionId", (String)req.getParameter("sessionId"));
//		req.setAttribute("sessionId", (String)req.getSession().getAttribute("sessionId"));
//		System.out.println((String)req.getSession().getAttribute("sessionId"));
		return "newTask" ;	
	}
	
//Add Task
	@RequestMapping(value="addTask")
	public String addTask(HttpServletRequest req, TaskDetails u) throws Exception{
		req.setAttribute("sessionId", (String)req.getParameter("sessionId"));
		String sessionId = (String)req.getParameter("sessionId");
		int userId = hs.getSession(sessionId).getUserId();
		u.setUserId(userId);
		hs.addTask(u);
		return "showTask" ;	
	}
	
//	logout
	@RequestMapping(value="logout")
	public void logout(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		String sessionId = req.getParameter("sessionId");
		System.out.print("sessionId: "+sessionId);
		hs.logout(sessionId);
		resp.sendRedirect("login");
		//return "login";
	}
	
	
//	complete task
	@RequestMapping(value="taskOption")
	public String taskOption(HttpServletRequest req, TaskDetails u) throws Exception{
		req.setAttribute("sessionId", req.getParameter("sessionId"));
		int id=Integer.parseInt(req.getParameter("taskId"));
		String button = req.getParameter("button");
		
		if("delete".equals(button))
			hs.delete(id);
		else
			hs.complete(id);
		
		return "showTask";
	}
	
}
