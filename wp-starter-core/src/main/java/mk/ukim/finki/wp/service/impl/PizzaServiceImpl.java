package mk.ukim.finki.wp.service.impl;

import mk.ukim.finki.wp.model.Order;
import mk.ukim.finki.wp.service.PizzaService;

/**
 * Created by 131223 on 11/22/2016.
 */
public class PizzaServiceImpl implements PizzaService {
    public static long ids = 0;
    public Order placeOrder(String pizzaType, String clientName, String address) {
        Order o = new Order();
        o.setOrderId(ids++);
        o.setPizzaType(pizzaType);
        o.setClientName(clientName);
        o.setClientAddress(address);
        return o;
    }
}
