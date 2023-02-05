package org.cursotesting;

import org.cursotesting.entidades.Book;
import org.cursotesting.entidades.BookCollection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BookCollectionTest {
    @Test
    public void shouldFindABookByISBN()
    {
        final String isbnToLocate = "un-isbn-2";
        BookCollection books = new BookCollection(List.of(new Book[]{
                new Book("un-isbn-1", "un titulo 1", "un autor 1"),
                new Book(isbnToLocate, "un titulo 2", "un autor 2"),
                new Book(isbnToLocate, "un titulo 2", "un autor 2"),
                new Book("un-isbn-3", "un titulo 3", "un autor 3"),
        }));
        books.find(isbnToLocate)
                .forEach((Book book) -> Assertions.assertEquals(book.getISBN(), isbnToLocate));
    }
    @Test
    public void shouldFindABookByTitle() {
        final String titleToLocate = "un titulo 3";
        BookCollection books = new BookCollection(List.of(new Book[] {
                new Book("un-isbn-1", "un titulo 1", "un autor 1"),
                new Book("un-isbn-2", "un titulo 2", "un autor 2"),
                new Book("un-isbn-3", titleToLocate, "un autor 3")
        }));
        books.find(titleToLocate)
                .forEach((Book book) -> Assertions.assertEquals(book.getTitle(), titleToLocate));
    }

    @Test
    public void shouldNotFindIfCollectionIsEmpty() {
        final String titleToLocate = "un titulo 3";
        BookCollection books = new BookCollection(List.of(new Book[] {}));
        Assertions.assertTrue(books.find(titleToLocate).isEmpty());
    }
    @Test
    public void shouldGetAnEmptyListIfNoMatchesAreFound() {
        final String isbnToLocate = "un-texto-que-no-existe-como-isbn-o-author";
        BookCollection books = new BookCollection(List.of(new Book[]{
                new Book("un-isbn-1", "un titulo 1", "un autor 1"),
                new Book("un-isbn-2", "un titulo 2", "un autor 2"),
                new Book("un-isbn-3", "un titulo 3", "un autor 3"),
        }));
        Assertions.assertTrue(books.find(isbnToLocate).isEmpty());
    }
}
