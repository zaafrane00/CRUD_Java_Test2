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

         public Statement stm=null;
         public ResultSet res=null;
         public java.sql.Connection myConnection=null;

          public ConnectionClass() throws ClassNotFoundException,SQLException {
         Class.forName("com.mysql.jdbc.Driver");
         myConnection=DriverManager.getConnection("jdbc:mysql://localhost/javabook","root","");
    }


    public ResultSet getBookbyId(int id) {
        ResultSet res = null;
        try {
            String req = "SELECT * FROM books WHERE id = ?";
            PreparedStatement ps = myConnection.prepareStatement(req);
            ps.setInt(1, id);
            res = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }


    void addBook(Book book, String table) throws SQLException {
        stm=myConnection.createStatement();
        String req="";
        req="insert into "+table+"(title,auther,price,releaseDate)values('"+book.title+"','"+book.auther+"',"+book.price+","+book.releaseDate+")";
        //System.out.println(req);
        stm.executeUpdate(req);
    }
        
    String [][] getAllBooks(String table) throws SQLException {
        stm=myConnection.createStatement();
        String response[][];
        String req="";      
        req="select* from "+table;
       // System.err.println(req);
        res=stm.executeQuery(req); 
        //reference last row in the table
        res.last();
        int taille=res.getRow();
         //returning reference to his default value in the table
        res.beforeFirst();
        //System.out.println(taille);
        response=new String[taille][5];
        int i=0;
        while(res.next()) {
            for(int j=0; j<5; j++)
            response[i][j]=res.getString(j+1)+"";
            i++;
        }
        return response;
    }
      public void deleteBook(int id)throws SQLException{
        if(getBookbyId(id).next()){
            String req = "DELETE FROM books WHERE id = ?";
            PreparedStatement ps = myConnection.prepareStatement(req);
            ps.setInt(1, id);
            if (ps.executeUpdate()==-1)
                System.out.println("An error occured we couldn't delete this book ");
            else
                System.out.println("Book deleted successfully");
            ps.close();
        }
        else
            System.out.println("None of the books have the specified  ID: "+ id);
        }

}

