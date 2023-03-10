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

    public List<Book> findCopies(Book bookToFind) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : this.books) {
            if (book.getISBN().equals(bookToFind.getISBN())
                    && book.getTitle().equals(bookToFind.getTitle())
                    && book.getAuthor().equals(bookToFind.getAuthor())
            ) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    public List<Book> findOrFail(String textToFind) throws ExpectedToFindAtLeastABook {
        List<Book> foundBooks = new ArrayList<>();
        for(Book book : this.books){
            if(book.getISBN().equals(textToFind) || book.getTitle().contains(textToFind)) {
                foundBooks.add(book);
            }
        }
        if(foundBooks.isEmpty()){
            throw new ExpectedToFindAtLeastABook();
        }
        return foundBooks;
    }


    public static class ExpectedToFindAtLeastABook extends Exception {
    }
}
