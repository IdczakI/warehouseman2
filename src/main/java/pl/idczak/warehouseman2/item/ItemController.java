package pl.idczak.warehouseman2.item;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.idczak.warehouseman2.IncorrectDataException;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/items")
public class ItemController {

    private ItemService itemService;
    private String errorMessage;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("")
    public String findItems(Model model, @RequestParam(required = false) String name) {
        errorMessage = null;
        if (name == null || "".equals(name))
            model.addAttribute("items", itemService.findAll());
        else
            model.addAttribute("items", itemService.findAllByName(name));
        return "/item/items";
    }

    @GetMapping("/add")
    public String mapAddPage(Model model) {
        model.addAttribute("message", errorMessage);
        return "item/add_item";
    }

    @GetMapping("/edit/{id}")
    public String findItemToEdit(@PathVariable Long id, Model model) {
        errorMessage = null;
        Optional<ItemDto> itemDto = itemService.findById(id);
        itemDto.ifPresent(i -> model.addAttribute("item", i));
        return "item/edit_item";
    }

    @PostMapping("")
    public String save(@ModelAttribute ItemDto itemDto, Model model) {
        try {
            ItemDto dto = itemService.saveItem(itemDto);
        } catch (IncorrectDataException e) {
            model.addAttribute("message", e.getMessage());
            errorMessage = e.getMessage();
            return "redirect:/items/add";
        }
        model.addAttribute("items", itemService.findAll());
        errorMessage = null;
        return "item/items";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute ItemDto itemDto, Model model) {
        try {
            ItemDto dto = itemService.editItem(itemDto);
        } catch (IncorrectDataException e) {
            model.addAttribute("message", e.getMessage());
        }
        model.addAttribute("items", itemService.findAll());
        return "item/items";
    }

    @GetMapping("/{id}")
    public String takeALook(@PathVariable Long id, Model model) {
        errorMessage = null;
        List<ItemDto> dtoList = itemService.findALlById(id);
        if (dtoList.isEmpty())
            model.addAttribute("message", "There is no such of Item");
        else
            model.addAttribute("items", dtoList);
        return "item/items";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Long id, Model model) {
        try {
            itemService.deleteById(id);
        } catch (IncorrectDataException e) {
            model.addAttribute("message", e.getMessage());
        }
        model.addAttribute("items", itemService.findAll());
        return "item/items";
    }
}

