package pl.idczak.warehouseman2.devivery;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.idczak.warehouseman2.IncorrectDataException;
import pl.idczak.warehouseman2.item.ItemDto;
import pl.idczak.warehouseman2.item.ItemService;
import pl.idczak.warehouseman2.transporter.TransporterService;
import pl.idczak.warehouseman2.warehouseman.WarehousemanService;

@Controller
public class DeliveryController {

    private DeliveryService deliveryService;
    private ItemService itemService;
    private WarehousemanService warehousemanService;
    private TransporterService transporterService;

    public DeliveryController(DeliveryService deliveryService, ItemService itemService,
                              WarehousemanService warehousemanService, TransporterService transporterService) {
        this.deliveryService = deliveryService;
        this.itemService = itemService;
        this.warehousemanService = warehousemanService;
        this.transporterService = transporterService;
    }

    @GetMapping("/deliveries")
    public String findAllDeliveries(Model model, @RequestParam(required = false) String search) {
        if (search == null || "".equals(search))
            model.addAttribute("deliveries", deliveryService.findAllDeliveries());
        else
            model.addAttribute("deliveries", deliveryService.findAllDeliveriesByBase(search));
        return "delivery/deliveries";
    }

    @GetMapping("/departures")
    public String findAllDepartures(Model model, @RequestParam(required = false) String search) {
        if (search == null || "".equals(search))
            model.addAttribute("departures", deliveryService.findAllDepartures());
        else
            model.addAttribute("departures", deliveryService.findAllDeparturesByBase(search));
        return "departure/departures";
    }

    @GetMapping("/deliveries/take")
    public String mapTakeDeliveryPage(Model model){
        model.addAttribute("warehousemen", warehousemanService.findAll());
        model.addAttribute("items", itemService.findAll());
        model.addAttribute("transporters", transporterService.findAll());
        return "delivery/take_delivery";
    }

    @GetMapping("/departures/create")
    public String mapCreateDeparturePage(Model model){
        model.addAttribute("warehousemen", warehousemanService.findAll());
        model.addAttribute("items", itemService.findAll());
        model.addAttribute("transporters", transporterService.findAll());
        return "departure/create_departure";
    }

    @PostMapping("deliveries")
    public String saveDelivery(@ModelAttribute DeliveryDto deliveryDto, Model model){
        try {
            ItemDto itemDto = itemService.updateItemDelivery(deliveryDto);
            DeliveryDto dto = deliveryService.save(deliveryDto);
        }catch (IncorrectDataException e){
            model.addAttribute("message", e.getMessage());
        }
        model.addAttribute("deliveries", deliveryService.findAllDeliveries());
        return "delivery/deliveries";
    }

    @PostMapping("departures")
    public String saveDeparture(@ModelAttribute DeliveryDto deliveryDto, Model model){
        try {
            ItemDto itemDto = itemService.updateItemDeparture(deliveryDto);
            DeliveryDto dto = deliveryService.save(deliveryDto);
        }catch (IncorrectDataException e){
            model.addAttribute("message", e.getMessage());
        }
        model.addAttribute("departures", deliveryService.findAllDepartures());
        return "departure/departures";
    }
}
