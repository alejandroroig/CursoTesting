package org.cursotesting.entidades;

import lombok.Data;

@Data
public class Book {
    private final String ISBN;
    private final String title;
    private final String author;
}
