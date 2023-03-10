package org.cursotesting.bookcollection;

import org.cursotesting.entidades.Book;
import org.cursotesting.entidades.BookCollection;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class FindCopiesTest {
    @Test
    public void shouldFindCopiesOfABook() {
        final Book bookToBeFound = new Book("libro-que-debe-encontrase", "un titulo 1", "un autor 1");
        BookCollection books = new BookCollection(List.of(new Book[]{
                new Book("libro-que-debe-encontrase", "un titulo 1", "un autor 1"),
                new Book("libro-que-debe-encontrase", "un titulo 1", "un autor 1"),
                new Book("un-isbn-2", "un titulo 2", "un autor 2"),
                new Book("un-isbn-3", "un titulo 3", "un autor 3"),
        }));
        List<Book> foundBooks = books.findCopies(bookToBeFound);
        assertFalse(foundBooks.isEmpty());
        foundBooks.forEach((Book book) -> assertThat(book, is(equalTo(bookToBeFound))));
    }
}
