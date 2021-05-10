package pl.idczak.warehouseman2.warehouseman;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WarehousemanController {

    private WarehousemanService warehousemanService;

    public WarehousemanController(WarehousemanService warehousemanService) {
        this.warehousemanService = warehousemanService;
    }

    @GetMapping("/warehousemen")
    public String findWarehousemen(Model model, @RequestParam(required = false) String search) {
        if (search == null || "".equals(search))
            model.addAttribute("warehousemen", warehousemanService.findAll());
        else
            model.addAttribute("warehousemen", warehousemanService.findAllByBase(search));
        return "warehousemen";
    }
}
