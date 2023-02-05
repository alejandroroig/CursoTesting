package org.cursotesting.entidades;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BookCollection {
    private final List<Book> books;

    public List<Book> find(String textToFind) {
        List<Book> foundBooks = new ArrayList<Book>();
        for(Book book : this.books){
            if(book.getISBN().equals(textToFind) ||
                    book.getTitle().contains(textToFind)){
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }
}
