package mk.ukim.finki.wp.web;

import mk.ukim.finki.wp.model.Order;
import mk.ukim.finki.wp.service.impl.OrderServiceImpl;
import mk.ukim.finki.wp.service.impl.PizzaServiceImpl;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by 131223 on 11/22/2016.
 */
@Controller
public class PizzaOrderController {
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index() {
        List<String> types = new OrderServiceImpl().getPizzaTypes();
        ModelAndView mv = new ModelAndView("pizza_order");
        mv.getModel().put("types", types);
        return mv;
    }

    @RequestMapping(method = RequestMethod.GET, value = "client")
    public ModelAndView showClientInfo(@RequestParam String pizzaType, HttpSession session) {
        ModelAndView mv = new ModelAndView("client_info");
        session.setAttribute("pizzaType", pizzaType);
        return mv;
    }

    @RequestMapping(method = RequestMethod.GET, value = "placeOrder")
    public ModelAndView placeOrder(@RequestParam String clientName, @RequestParam String clientAddress, HttpSession session) {
        ModelAndView mv = new ModelAndView("place_order");

        String pt = (String) session.getAttribute("pizzaType");

        Order o = new PizzaServiceImpl().placeOrder(pt, clientName, clientAddress);

        mv.getModel().put("order", o);

        return mv;
    }
}
