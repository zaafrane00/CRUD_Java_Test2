package Vermeg.testfolder;

import Vermeg.ConnectionClass;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;


public class ConnectionTest extends TestCase {
     Statement stm=null;
    ConnectionClass connect;

    public boolean isInteger(String s){
        try{
            Integer.parseInt(s);
            return true;
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
        return false;
    }

    @Before
    public void setUp()  {

    }

    @After
    public void tearDown(){

    }

    @Test
    public void testOpenConnection() throws SQLException, ClassNotFoundException {
        System.out.printf("testing connection");
        connect=new ConnectionClass();
        Class.forName("com.mysql.jdbc.Driver");
        assertEquals(connect.myConnection!=null,true);
    }

    @Test
    public void testAddBook() throws SQLException, ClassNotFoundException {
        System.out.println("adding book");
        String req="insert into books(title,auther,price,releaseDate)values(?,?,?,?)";
       // System.out.println(req);
        connect=new ConnectionClass();
        Class.forName("com.mysql.jdbc.Driver");
        stm=connect.myConnection.createStatement();
        PreparedStatement ps = connect.myConnection.prepareStatement(req);
        String title="The Last Wish";
        String auther="Andrzej Sapkowski";
        double price=60.99;
        String releaseDate="1997";
        ps.setString(1, title);
        ps.setString(2, auther);
        ps.setDouble(3, price);
        ps.setString(4, releaseDate);
        assertEquals("The Last Wish",title);
        assertEquals("Andrzej Sapkowski",auther);
        assertEquals(60.99,price);
        assertTrue("release date must be numeric",isInteger(releaseDate));
        assertEquals("1997",releaseDate);
        int rs=ps.executeUpdate();
        connect.myConnection.close();
    }
    @Test
    public void testDelete() throws SQLException, ClassNotFoundException {
        System.out.println("Deleting book");
        String req = "DELETE FROM books WHERE id = ?";
        // System.out.println(req);
        connect=new ConnectionClass();
        Class.forName("com.mysql.jdbc.Driver");
        stm=connect.myConnection.createStatement();
        PreparedStatement ps = connect.myConnection.prepareStatement(req);
        Object _id=5;
        assertTrue("id date must be numeric",_id instanceof Number);
        int id=(Integer)_id;
        ps.setInt(1, id);
        int rs=ps.executeUpdate();
        connect.myConnection.close();
    }

}
