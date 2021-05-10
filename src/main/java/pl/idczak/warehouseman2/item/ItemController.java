package pl.idczak.warehouseman2.item;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.idczak.warehouseman2.DuplicateException;

@Controller
@RequestMapping("/items")
public class ItemController {

    private ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("")
    public String findItems(Model model, @RequestParam(required = false) String name) {
        if (name == null || "".equals(name))
            model.addAttribute("items", itemService.findAll());
        else
            model.addAttribute("items", itemService.findAllByName(name));
        return "/item/items";
    }

    @PostMapping("")
    public String save(@ModelAttribute ItemDto itemDto, Model model) {
        try {
            ItemDto dto = itemService.saveItem(itemDto);
        }catch (DuplicateException e){
            model.addAttribute("message", e.getMessage());
        }
        model.addAttribute("items", itemService.findAll());
        return "item/items";
    }

    @GetMapping("/add")
    public String mapAddPage() {
        return "item/add_item";
    }
}
