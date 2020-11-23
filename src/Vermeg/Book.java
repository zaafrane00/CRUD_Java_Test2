/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vermeg;

/**
 *
 * @author Zaafrane
 */
public class Book {
    protected int id;
    protected String title;
    protected String auther;
    protected double price;
    protected int release;

    public Book(int id,String title, String auther, double price, int release) {
        this.id=id;
        this.title = title;
        this.auther = auther;
        this.price = price;
        this.release = release;
    }
    
     public Book(Book b) {
         this.id=b.id;
        this.title = b.title;
        this.auther = b.auther;
        this.price = b.price;
        this.release = b.release;
    }
     
     public Book() {
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", title=" + title + ", auther=" + auther + ", price=" + price + ", release=" + release + '}';
    }

    
    
   
    
}
