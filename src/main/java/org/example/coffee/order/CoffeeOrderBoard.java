package org.example.coffee.order;
import java.util.LinkedList;
import java.util.Queue;

public class CoffeeOrderBoard {
    private Queue<Order> orders;

    public CoffeeOrderBoard() {
        orders = new LinkedList<>();
    }

    public void add(Order order) {
        int nextOrderNum = orders.size() + 1;
        order.setOrderNumber(nextOrderNum);
        orders.add(order);
    }

    public void deliver() {
        if (!orders.isEmpty()) {
            Order nextOrder = orders.poll();
            System.out.println("Delivering coffee order #" + nextOrder.getOrderNumber() + " for " + nextOrder.getCustomerName());
        } else {
            System.out.println("No orders in queue.");
        }
    }

    public void prioritizeOrder(int orderNumber) {
        if (orders.size() > 1) {
            Order orderToPrioritize = null;
            for (Order order : orders) {
                if (order.getOrderNumber() == orderNumber) {
                    orderToPrioritize = order;
                    break;
                }
            }
            if (orderToPrioritize != null) {
                orders.remove(orderToPrioritize);
                orders.add(orderToPrioritize);
                System.out.println("Moved order #" + orderNumber + " to the front of the queue.");
            } else {
                System.out.println("Order #" + orderNumber + " not found in queue.");
            }
        }
    }

    public void draw() {
        System.out.println("Coffee orders in queue:");
        int orderNum = 1;

        for (Order order : orders) {
            System.out.println(orderNum + ". " + order.getCustomerName() + " - Order #" + order.getOrderNumber());
            orderNum++;
        }
    }
}