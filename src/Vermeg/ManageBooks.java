/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vermeg;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Zaafrane
 */
public class ManageBooks {
    ConnectionClass conec=null;
    
      public ManageBooks() {
        try {
            conec=new ConnectionClass();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageBooks.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManageBooks.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
       public void store(Book b)throws SQLException{
        this.conec.addBook(b,"books");
           System.out.println("Book successfully added");
    }
       
        public String[][] index()throws SQLException{
        String res[][];
         res=this.conec.getAllBooks("books") ;
         System.out.println(Arrays.deepToString(res));
         return res;
    }
       
           public static void main(String args[]){
        try {
            ManageBooks manager=new ManageBooks();
            Book b=new Book(7,"book4","mohamed",50.99,2019);
            System.out.println(b);
            manager.index();
            manager.store(b);
            manager.index();
             
        } catch (SQLException ex) {
            Logger.getLogger(ManageBooks.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
