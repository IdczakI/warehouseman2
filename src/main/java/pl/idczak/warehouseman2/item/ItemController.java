package pl.idczak.warehouseman2.item;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ItemController {

    private ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/items")
    public String findItems(Model model, @RequestParam(required = false) String name) {
        if (name == null || "".equals(name))
            model.addAttribute("items", itemService.findAll());
        else
            model.addAttribute("items", itemService.findAllByName(name));
        return "items";
    }
}
