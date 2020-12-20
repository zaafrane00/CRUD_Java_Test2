/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vermeg;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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

        public void getBookByID(int id)throws SQLException{
            ResultSet res=this.conec.getBookbyId(id);
            ResultSetMetaData rsmd = res.getMetaData();
            int nbCol = rsmd.getColumnCount();
            if(!res.next())
                System.out.println("book not found");
            else{
                while(res.next()){
                    for (int i = 1; i <= nbCol; i++) {
                        if (i > 1) System.out.print(",  ");
                        String columnValue = res.getString(i);
                        System.out.print(columnValue + " " + rsmd.getColumnName(i));
                    }
                System.out.println("");
                 }
            }
        }
        public void destroy(int id)throws SQLException{
            this.conec.deleteBook(id);
        }

    public static void main(String args[]){
        try {
            ManageBooks manager=new ManageBooks();
            Book b=new Book("book4","mohamed",50.99,"2019");
            manager.store(b);
            manager.index();
            //manager.getBookByID(1);
            // manager.destroy(2);


             
        } catch (SQLException ex) {
            Logger.getLogger(ManageBooks.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
