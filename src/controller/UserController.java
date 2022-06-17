package controller;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.put;
import static spark.Spark.post;

import com.google.gson.Gson;

import Beans.User;
import services.UserService;

public class UserController {
	
	private static Gson g = new Gson();
	private static UserService userService = new UserService();
	
	public static void getUsers() {
		get("rest/users/", (req, res) -> {
			res.type("application/json");
			return g.toJson(userService.getUsers());
		});
	}
	
	public static void getUser() {
		get("rest/users/:id", (req, res) -> {
			res.type("application/json");
			String id = req.params("id");
			return g.toJson(userService.getUser(id));
		});
	}
	
	public static void addUser() {
		post("rest/users/add", (req, res) -> {
			res.type("application/json");
			User pd = g.fromJson(req.body(), User.class);
			userService.addUser(pd);
			return "SUCCESS";
		});
	}
	
	public static void editUser() {
		put("rest/Users/edit/:id", (req, res) -> {
			res.type("application/json");
			String id = req.params("id");
			User pd = g.fromJson(req.body(), User.class);
			userService.editUser(id, pd);
			return "SUCCESS";
		});
	}
	
	public static void deleteUser() {
		delete("rest/Users/delete/:id", (req, res) -> {
			res.type("application/json");
			String id = req.params("id");
			userService.deleteUser(id);
			return "SUCCESS";
		});
	}
}

