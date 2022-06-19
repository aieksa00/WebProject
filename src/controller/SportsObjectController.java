package controller;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.put;
import static spark.Spark.post;

import com.google.gson.Gson;

import Beans.SportsObject;
import services.SportsObjectService;

public class SportsObjectController {
	
	private static Gson g = new Gson();
	private static SportsObjectService sportsobjectService = new SportsObjectService();
	
	public static void getSportsObjects() {
		get("rest/sportsobjects/", (req, res) -> {
			res.type("application/json");
			return g.toJson(sportsobjectService.getSportsObjects());
		});
	}
	
	public static void getSportsObject() {
		get("rest/sportsobjects/:id", (req, res) -> {
			res.type("application/json");
			String id = req.params("id");
			return g.toJson(sportsobjectService.getSportsObject(id));
		});
	}
	
	public static void addSportsObject() {
		post("rest/sportsobjects/add", (req, res) -> {
			res.type("application/json");
			SportsObject pd = g.fromJson(req.body(), SportsObject.class);
			sportsobjectService.addSportsObject(pd);
			return "SUCCESS";
		});
	}
	
	public static void editSportsObject() {
		put("rest/sportsobjects/edit/:id", (req, res) -> {
			res.type("application/json");
			String id = req.params("id");
			SportsObject pd = g.fromJson(req.body(), SportsObject.class);
			sportsobjectService.editSportsObject(id, pd);
			return "SUCCESS";
		});
	}
	
	public static void deleteSportsObject() {
		delete("rest/sportsobjects/delete/:id", (req, res) -> {
			res.type("application/json");
			String id = req.params("id");
			sportsobjectService.deleteSportsObject(id);
			return "SUCCESS";
		});
	}

	public static void getSportsObjectsSearch() {
		get("rest/sportsobjects/:searchParam/:searchInput", (req, res) -> {
			res.type("application/json");
			String param = req.params("searchParam");
			String input = req.params("searchInput");
			switch(param){
				case "objectType": return g.toJson(sportsobjectService.getSportsObjectsByType(input));
				case "name": return g.toJson(sportsobjectService.getSportsObjectsByName(input));
				case "location": return g.toJson(sportsobjectService.getSportsObjectsByLocation(input));
				case "rating": return g.toJson(sportsobjectService.getSportsObjectsByRating(input));
				default: return g.toJson(sportsobjectService.getSportsObjectsByName(input));
			}
		});
	}
}


