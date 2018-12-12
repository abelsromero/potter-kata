package org.kata;

import java.util.List;
import java.util.Set;

public class CostCalculator {

    public Double calculateCost(List<Set<Book>> bags) {
        double cost = 0;
        for (Set<Book> bag : bags) {
//            System.out.println(bag);
            switch (bag.size()) {
                case 1:
                    cost += 8;
                    break;
                case 2:
                    cost += ((8 * 2) * (1 - 0.05));
                    break;
                case 3:
                    cost += ((8 * 3) * (1 - 0.10));
                    break;
                case 4:
                    cost += ((8 * 4) * (1 - 0.20));
                    break;
                case 5:
                    cost += ((8 * 5) * (1 - 0.25));
                    break;
            }
        }
        return cost;
    }

}
