package pl.idczak.warehouseman2.transporter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.idczak.warehouseman2.DuplicateException;

@Controller
@RequestMapping("/transporters")
public class TransporterController {

    private TransporterService transporterService;

    public TransporterController(TransporterService transporterService) {
        this.transporterService = transporterService;
    }

    @GetMapping("")
    public String findTransporters(Model model, @RequestParam(required = false) String search) {
        if (search == null || "".equals(search))
            model.addAttribute("transporters", transporterService.findAll());
        else
            model.addAttribute("transporters", transporterService.findAllByBase(search));
        return "transporter/transporters";
    }

    @GetMapping("/add")
    public String mapAddPage(){
        return "transporter/add_transporter";
    }

    @PostMapping("")
    public String save(@ModelAttribute TransporterDto transporterDto, Model model){
        try{
            TransporterDto dto = transporterService.saveTransporter(transporterDto);
        }catch (DuplicateException e){
            model.addAttribute("message", e.getMessage());
        }
        model.addAttribute("transporters", transporterService.findAll());
        return "transporter/transporters";
    }
}
