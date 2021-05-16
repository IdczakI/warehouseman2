package pl.idczak.warehouseman2.warehouseman;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/warehousemen")
public class WarehousemanController {

    private WarehousemanService warehousemanService;

    public WarehousemanController(WarehousemanService warehousemanService) {
        this.warehousemanService = warehousemanService;
    }

    @GetMapping("")
    public String findWarehousemen(Model model, @RequestParam(required = false) String search) {
        if (search == null || "".equals(search))
            model.addAttribute("warehousemen", warehousemanService.findAll());
        else
            model.addAttribute("warehousemen", warehousemanService.findAllByBase(search));
        model.addAttribute("loggedInUser", warehousemanService.getLoggedInWarehouseman());
        return "/warehouseman/warehousemen";
    }

    @GetMapping("/{id}")
    public String takeALook(@PathVariable Long id, Model model){
        List<WarehousemanDto> dtoList = warehousemanService.findAllById(id);
        if (dtoList.isEmpty())
            model.addAttribute("message", "There is no such Warehouseman");
        else
            model.addAttribute("warehousemen", dtoList);
        model.addAttribute("loggedInUser", warehousemanService.getLoggedInWarehouseman());
        return "/warehouseman/warehousemen";
    }
}
