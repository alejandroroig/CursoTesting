package org.cursotesting.bookcollection;

import org.cursotesting.entidades.Book;
import org.cursotesting.entidades.BookCollection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindTest {
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
        books.find(isbnToLocate).forEach((Book book) -> assertThat(isbnToLocate, is(equalTo(book.getISBN()))));
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
                .forEach((Book book) -> assertEquals(book.getTitle(), titleToLocate));
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
        assertThat(books.find(isbnToLocate).isEmpty(), is(true));
    }
}
