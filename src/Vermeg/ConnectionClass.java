/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vermeg;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Zaafrane
 */
public class ConnectionClass {
         protected Statement stm=null;
         protected ResultSet res=null;
         protected java.sql.Connection myConnection=null;
         
         
          public ConnectionClass() throws ClassNotFoundException,SQLException {
         Class.forName("com.mysql.jdbc.Driver");
         myConnection=DriverManager.getConnection("jdbc:mysql://localhost/javatest","root","");  
    }
          
        void addBook(Book book, String table) throws SQLException {
        stm=myConnection.createStatement();
        String req="";
        req="insert into "+table+"(title,auther,price,releasee)values('"+book.title+"','"+book.auther+"',"+book.price+","+book.release+")";
        System.out.println(req);
        stm.executeUpdate(req);
    }
        
         String [][] getAllBooks(String table) throws SQLException {
        stm=myConnection.createStatement();
        String response[][];
        String req="";      
        req="select* from "+table;
        System.err.println(req);
        res=stm.executeQuery(req); 
        //reference last row in the table
        res.last();
        int taille=res.getRow();
         //returning reference to his default value in the table
        res.beforeFirst();
        System.out.println(taille);
        response=new String[taille][5];
        int i=0;
        while(res.next()) {
            for(int j=0; j<5; j++)
            response[i][j]=res.getString(j+1)+"";
            i++;
        }
        return response;
    }
         
}

