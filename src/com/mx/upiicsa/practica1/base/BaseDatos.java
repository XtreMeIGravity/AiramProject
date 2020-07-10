package com.mx.upiicsa.practica1.base;
import java.sql.DriverManager;
import java.sql.Connection;

public class BaseDatos {
	 Connection connection;
	    protected Connection connectDatabase() {

	        try {
	            try {
	                Class.forName("org.postgresql.Driver");
	            } catch (ClassNotFoundException ex) {
	                System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
	            }
	            connection = null;
	            connection = DriverManager.getConnection(
	                    "jdbc:postgresql://localhost:5432/disco",//Cambie D a mayus
	                    "postgres", "root");//Cambie Passw

	            boolean valid = connection.isValid(50000);
	            System.out.println(valid ? "TEST OK" : "TEST FAIL");


	        } catch (java.sql.SQLException sqle) {
	            System.out.println("Error: " + sqle);
	        }
	        return null;
	    }

	    protected void desconectar() {
	        try {
	            connection.close();
	        }catch (java.sql.SQLException sqle) {
	            System.out.println("Error: " + sqle);
	        }

	    }
}
