package br.edu.ifpb.pweb2.model;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("simple-events-jsf");
		System.out.println(factory);
		factory.createEntityManager();
	}

}
