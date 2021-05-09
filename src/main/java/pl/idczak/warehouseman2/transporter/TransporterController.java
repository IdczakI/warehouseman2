package pl.idczak.warehouseman2.transporter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TransporterController {

    private TransporterService transporterService;

    public TransporterController(TransporterService transporterService) {
        this.transporterService = transporterService;
    }

    @GetMapping("/transporters")
    public String findItems(Model model, @RequestParam(required = false) String search) {
        if (search == null || "".equals(search))
            model.addAttribute("transporters", transporterService.findAll());
        else
            model.addAttribute("transporters", transporterService.findAllByBase(search));
        return "transporters";
    }
}
