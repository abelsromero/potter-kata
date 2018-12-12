package org.kata;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class ShoppingCartTest {

    @Test
    public void should_buy_1_book() {
        final ShoppingCartManager store = new ShoppingCartManager();
        final Double cost = store.buy(Book.The_Hobbit);

        assertThat(cost).isEqualTo(8);
    }

    @Test
    public void should_buy_2_different_book() {
        final ShoppingCartManager store = new ShoppingCartManager();
        final Double cost = store.buy(Book.The_Hobbit, Book.The_Silmarillion);

        assertThat(cost).isEqualTo(16 - (16 * 0.05));
    }

    @Test
    public void should_buy_3_different_book() {
        final ShoppingCartManager store = new ShoppingCartManager();
        final Double cost = store.buy(Book.The_Hobbit, Book.The_Silmarillion, Book.The_Fellowship_of_the_Ring);

        assertThat(cost).isEqualTo(24 - (24 * 0.10));
    }

    @Test
    public void should_buy_2_same_books() {
        final ShoppingCartManager store = new ShoppingCartManager();
        final Double cost = store.buy(Book.The_Hobbit, Book.The_Hobbit);

        assertThat(cost).isEqualTo(16);
    }

    @Test
    public void should_pass_acceptance_test() {
        final ShoppingCartManager store = new ShoppingCartManager();
        final Double cost = store.buy(
            Book.The_Hobbit, Book.The_Hobbit,
            Book.The_Fellowship_of_the_Ring, Book.The_Fellowship_of_the_Ring,
            Book.The_Two_Towers, Book.The_Two_Towers,
            Book.The_Return_of_the_King,
            Book.The_Silmarillion
        );

        assertThat(cost).isEqualTo(51.20);
    }

    @Test
    public void should_pass_acceptance_test_2() {
        final ShoppingCartManager store = new ShoppingCartManager();
        final Double cost = store.buy(
            Book.The_Hobbit, Book.The_Hobbit, Book.The_Hobbit, Book.The_Hobbit, Book.The_Hobbit,
            Book.The_Fellowship_of_the_Ring, Book.The_Fellowship_of_the_Ring, Book.The_Fellowship_of_the_Ring, Book.The_Fellowship_of_the_Ring, Book.The_Fellowship_of_the_Ring,
            Book.The_Two_Towers, Book.The_Two_Towers, Book.The_Two_Towers, Book.The_Two_Towers,
            Book.The_Return_of_the_King, Book.The_Return_of_the_King, Book.The_Return_of_the_King, Book.The_Return_of_the_King, Book.The_Return_of_the_King,
            Book.The_Silmarillion, Book.The_Silmarillion, Book.The_Silmarillion, Book.The_Silmarillion
        );

        assertThat(cost).isEqualTo(3 * (8 * 5 * 0.75) + 2 * (8 * 4 * 0.8));
    }


}
