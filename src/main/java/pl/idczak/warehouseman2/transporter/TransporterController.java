package pl.idczak.warehouseman2.transporter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.idczak.warehouseman2.IncorrectDataException;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/transporters")
public class TransporterController {

    private TransporterService transporterService;
    private String errorMessage;

    public TransporterController(TransporterService transporterService) {
        this.transporterService = transporterService;
    }

    @GetMapping("")
    public String findTransporters(Model model, @RequestParam(required = false) String search) {
        errorMessage = null;
        if (search == null || "".equals(search))
            model.addAttribute("transporters", transporterService.findAll());
        else
            model.addAttribute("transporters", transporterService.findAllByBase(search));
        return "transporter/transporters";
    }

    @GetMapping("/add")
    public String mapAddPage(Model model){
        model.addAttribute("message", errorMessage);
        return "transporter/add_transporter";
    }

    @GetMapping("/edit/{id}")
    public String findTransporterToEdit(@PathVariable Long id, Model model){
        errorMessage = null;
        Optional<TransporterDto> transporterDto = transporterService.findById(id);
        transporterDto.ifPresent(t -> model.addAttribute("transporter", t));
        return "transporter/edit_transporter";
    }

    @PostMapping("")
    public String save(@ModelAttribute TransporterDto transporterDto, Model model){
        try{
            TransporterDto dto = transporterService.saveTransporter(transporterDto);
        }catch (IncorrectDataException e){
            model.addAttribute("message", e.getMessage());
            errorMessage = e.getMessage();
            return "redirect:/transporters/add";
        }
        model.addAttribute("transporters", transporterService.findAll());
        errorMessage = null;
        return "transporter/transporters";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute TransporterDto transporterDto, Model model){
        try{
            TransporterDto dto = transporterService.editTransporter(transporterDto);
        }catch (IncorrectDataException e){
            model.addAttribute("message", e.getMessage());
        }
        model.addAttribute("transporters", transporterService.findAll());
        return "transporter/transporters";
    }

    @GetMapping("/{id}")
    public String takeALook(@PathVariable Long id, Model model){
        errorMessage = null;
        List<TransporterDto> dtoList = transporterService.findAllById(id);
        if (dtoList.isEmpty())
            model.addAttribute("message", "There is no such Transporter");
        else
            model.addAttribute("transporters", dtoList);
        return "transporter/transporters";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Long id, Model model){
        try {
            transporterService.deleteById(id);
        } catch (IncorrectDataException e){
            model.addAttribute("message", e.getMessage());
        }
        model.addAttribute("transporters", transporterService.findAll());
        return "transporter/transporters";
    }
}
