package com.gym2;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class Gym2Application {

	public static void main(String[] args) {
		SpringApplication.run(Gym2Application.class, args);
		System.out.println("Finished.....");
		try {
			openHomePage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void openHomePage() throws IOException {
	       Runtime rt = Runtime.getRuntime();
	       rt.exec("rundll32 url.dll,FileProtocolHandler " + "http://localhost:8080");
	 }

}
