package org.kata;

public enum Book {

    The_Hobbit("The Hobbit"),
    The_Fellowship_of_the_Ring("The Fellowship of the Ring"),
    The_Two_Towers("The Two Towers"),
    The_Return_of_the_King("The Return of the King"),
    The_Silmarillion("The Silmarillion");

    private final String title;

    Book(String title) {
        this.title = title;
    }
}
