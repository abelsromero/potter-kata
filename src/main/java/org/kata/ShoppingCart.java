package org.kata;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ShoppingCart {

    public List<Set<Book>> packages = new ArrayList<>();

    public static ShoppingCart copyOf(ShoppingCart sourceCart) {
        final List<Set<Book>> packagesCopy = sourceCart.packages.stream()
            .map(p -> new HashSet<>(p))
            .collect(Collectors.toList());

        final ShoppingCart newCart = new ShoppingCart();
        newCart.packages.addAll(packagesCopy);
        return newCart;
    }
}
