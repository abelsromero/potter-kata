package org.kata;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ShoppingCartManager {


    final private CostCalculator calculator = new CostCalculator();

    public Double buy(Book... books) {
        double bestCost = 0;
        ShoppingCart bestCandidateSoFar = null;

        for (Book book : books) {
            System.out.println("Testing Book: " + book);
            List<ShoppingCart> candidates = new ArrayList<>();
            if (bestCandidateSoFar == null) {
                candidates.add(newCandidate(book));
            } else {
                candidates = getCandidates(bestCandidateSoFar, book);
            }

            chivato(candidates);

            bestCost = Double.MAX_VALUE;
            for (ShoppingCart cart : candidates) {
                double currentCost = calculator.calculateCost(cart.packages);
                if (currentCost < bestCost) {
                    bestCost = currentCost;
                    bestCandidateSoFar = cart;
                }
            }
        }

        return bestCost;
    }

    private void chivato(List<ShoppingCart> candidates) {
        System.out.println("Candidates: ");
        for (int i = 0; i < candidates.size(); i++) {
            ShoppingCart c = candidates.get(i);
            System.out.println("-- Candidate cart: " + i);
            for (Set<Book> pack : c.packages)
                System.out.println("  package: " + pack);
        }
    }

    private ShoppingCart newCandidate(Book book) {
        final ShoppingCart candidate = new ShoppingCart();
        Set<Book> candidatePackage = new HashSet<>();
        candidatePackage.add(book);
        candidate.packages.add(candidatePackage);
        return candidate;
    }

    private List<ShoppingCart> getCandidates(ShoppingCart sourceCart, Book book) {
        final List<ShoppingCart> candidates = new ArrayList<>();

        final List<Integer> candidatePackages = new ArrayList<>();
        for (int i = 0; i < sourceCart.packages.size(); i++) {
            final Set<Book> current = sourceCart.packages.get(i);
            if (!current.contains(book)) {
                candidatePackages.add(Integer.valueOf(i));
            }
        }
        // add book to specific packages
        if (candidatePackages.size() > 0) {
            for (Integer i : candidatePackages) {
                final ShoppingCart candidate = ShoppingCart.copyOf(sourceCart);
                candidate.packages.get(i).add(book);
                candidates.add(candidate);
            }
        } else {
            // add new package with book
            Set<Book> newPackage = new HashSet<>();
            newPackage.add(book);
            sourceCart.packages.add(newPackage);
            candidates.add(sourceCart);
        }

        return candidates;
    }

}
