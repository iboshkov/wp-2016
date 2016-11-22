package mk.ukim.finki.wp.service;

import mk.ukim.finki.wp.model.Order;

/**
 * Created by 131223 on 11/22/2016.
 */
public interface PizzaService {
    public Order placeOrder(String pizzaType, String clientName, String address);
}
