package rest;

import static spark.Spark.port;
import static spark.Spark.staticFiles;
import java.io.File;
import controller.ProductController;
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
	}
}
