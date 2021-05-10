package pl.idczak.warehouseman2.devivery;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DeliveryController {

    private DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @GetMapping("/deliveries")
    public String findAllDeliveries(Model model, @RequestParam(required = false) String search) {
        if (search == null || "".equals(search))
            model.addAttribute("deliveries", deliveryService.findAllDeliveries());
        else
            model.addAttribute("deliveries", deliveryService.findAllDeliveriesByBase(search));
        return "deliveries";
    }

    @GetMapping("/departures")
    public String findAllDepartures(Model model, @RequestParam(required = false) String search) {
        if (search == null || "".equals(search))
            model.addAttribute("departures", deliveryService.findAllDepartures());
        else
            model.addAttribute("departures", deliveryService.findAllDeparturesByBase(search));
        return "departures";
    }
}
