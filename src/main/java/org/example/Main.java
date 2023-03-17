package org.example;

import org.example.coffee.order.CoffeeOrderBoard;
import org.example.coffee.order.Order;

public class Main {
    public static void main(String[] args) {
        CoffeeOrderBoard board = new CoffeeOrderBoard();

        Order order1 = new Order("John");
        Order order2 = new Order("Sarah");
        Order order3 = new Order("David");

        board.add(order1);
        board.add(order2);
        board.add(order3);

        board.draw();

        board.deliver();
        board.deliver();

        board.prioritizeOrder(3);

        board.draw();
    }
}
