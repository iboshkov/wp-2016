package mk.ukim.finki.wp.service.impl;

import mk.ukim.finki.wp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

/**
 * Created by 131223 on 11/22/2016.
 */
public class OrderServiceImpl implements OrderService {

    @Autowired
    public List<String> getPizzaTypes() {
        return Arrays.asList("Large", "Medium", "Small");
    }
}
