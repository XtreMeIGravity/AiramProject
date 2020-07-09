package com.mx.upiicsa.practica1.base;


import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.mx.upiicsa.practica1.*;
public class BaseDisco extends BaseDatos{
	String insertQuery = "insert into disco (id, titulo, autor) values (?, ?, ?);";

    public List<Disco> consultaDiscos() {
    	connectDatabase();
        List<Disco> album=new ArrayList<Disco>();
        try {
            Statement stm= connection.createStatement();
            System.out.print("--->1 "+stm);
            ResultSet rs=stm.executeQuery("select * from disco");
            System.out.print("--->2 "+stm);
            System.out.print("--->"+rs.wasNull());
            while (rs.next()) {
                Disco disco=new Disco();
                disco.setAutor(rs.getString("autor"));
                disco.setNombre(rs.getString("titulo"));
                disco.setNumero(rs.getString("id"));
                album.add(disco);
            }
        }catch(Exception e) {
            e.printStackTrace();

        }
        desconectar();
        return album;
    }

    public int registraDisco(Disco disco){
        int res = 0, original=1;
        connectDatabase();
        try{
            
        	Statement stm= connection.createStatement();
            ResultSet rs=stm.executeQuery("select id from disco");
            while (rs.next()) {
                if(rs.getString("id").equalsIgnoreCase(disco.getNumero())) {
                	original=0;
                }
            }
            
	        if(original==1) {	
	        	try{
	        		stm.executeUpdate("insert into disco(id, titulo, autor) values ('"+disco.getNumero()+"', '"+disco.getNombre()+"', '"+disco.getAutor()+"');");
	                res = 1;
	            }catch (Exception e){
	                e.printStackTrace();
	            }
	        }else {
	        	res=-1;
	        }	
            
        }catch (Exception e){
            e.printStackTrace();
        }
        return res;
    }
    
    public int modificaDisco(Disco disco) {
    	int existe=0;
        connectDatabase();
        try {
            Statement stm= connection.createStatement();
            System.out.print("--->1 "+stm);
            ResultSet rs=stm.executeQuery("select id from disco");
            System.out.print("--->2 "+stm);
            System.out.print("--->"+rs.wasNull());
            while (rs.next()) {
                if(rs.getString("id").equalsIgnoreCase(disco.getNumero())) {
                	existe=1;
                }
            }
            if(existe==1) {
            	stm.executeUpdate("update disco set titulo='"+disco.getNombre()+"',autor='"+disco.getAutor()+"' where id='"+disco.getNumero()+"';");            	
            }
        }catch(Exception e) {
            e.printStackTrace();

        }
        desconectar();
        return existe;
    }
}
