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
    protected String releaseDate;

    public Book(String title, String auther, double price, String releaseDate) {
        this.title = title;
        this.auther = auther;
        this.price = price;
        this.releaseDate = releaseDate;
    }
    
     public Book(Book b) {
        this.title = b.title;
        this.auther = b.auther;
        this.price = b.price;
        this.releaseDate = b.releaseDate;
    }
     
     public Book() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuther(String auther) {
        this.auther = auther;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", title=" + title + ", auther=" + auther + ", price=" + price + ", release=" + releaseDate + '}';
    }

}
