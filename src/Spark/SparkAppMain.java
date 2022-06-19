package Spark;

import static spark.Spark.staticFiles;
import static spark.Spark.port;
import java.io.File;
import controller.ProductController;
import controller.SportsObjectController;
import controller.UserController;

public class SparkAppMain {
	
	public static void main(String[] args) throws Exception {
		port(8000);

		staticFiles.externalLocation(new File("./static").getCanonicalPath());
		
		ProductController.getProducts();
		ProductController.getProduct();
		ProductController.addProduct();
		ProductController.editProduct();
		ProductController.deleteProduct();

		UserController.getUsers();
		UserController.getUser();
		UserController.addUser();
		UserController.editUser();
		UserController.deleteUser();

		SportsObjectController.getSportsObjects();
		SportsObjectController.getSportsObject();
		SportsObjectController.addSportsObject();
		SportsObjectController.editSportsObject();
		SportsObjectController.deleteSportsObject();
		SportsObjectController.getSportsObjectsSearch();
	}
}
