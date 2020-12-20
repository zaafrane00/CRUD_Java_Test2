package Vermeg.testfolder;

import Vermeg.Book;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BookTest extends TestCase {
    Book book;

    @Before
    public void setUp() throws Exception {
        System.out.println("begins");
        book=new Book();
        book.setAuther("hamza");
        book.setId(1);
        book.setPrice(50.5);
        book.setTitle("witcher");
        book.setReleaseDate("2020");
    }

    @After
    public void tearDown() throws Exception {
        book=null;
    }

    public boolean isInteger(String s){
        try{
            Integer.parseInt(s);
            return true;
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
        return false;
    }

    @Test
    public void testBook(){
        assertNotNull("livre null", book);
    }

    @Test
    public void testAuther(){
        assertNotNull("livre null", book);
        assertNotNull("auther null", book.getAuther());
    }

    @Test
    public void testRelease(){
        assertNotNull("livre null", book);
        assertNotNull("release date null", book.getReleaseDate());
        assertTrue("release date must be numeric", this.isInteger(book.getReleaseDate()));
    }
}