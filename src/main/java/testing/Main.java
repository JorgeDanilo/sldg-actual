package testing;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		System.out.println("Creating database in schema sldg...");
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sldg");
		entityManagerFactory.createEntityManager();
	}
}
