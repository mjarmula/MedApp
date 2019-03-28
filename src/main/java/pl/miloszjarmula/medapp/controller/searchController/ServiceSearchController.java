package pl.miloszjarmula.medapp.controller.searchController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.miloszjarmula.medapp.entity.Service;
import pl.miloszjarmula.medapp.repository.ServiceRepository;

@Controller
@RequestMapping("/searchService")
public class ServiceSearchController {

    private final ServiceRepository serviceRepository;

    @Autowired
    public ServiceSearchController(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @GetMapping("/search")
    public String searchService(Model model){
        model.addAttribute("service", new Service());
        return "service/search";
    }

    @PostMapping("/search")
    @ResponseBody
    public String searchService(@ModelAttribute Service service){
        return  serviceRepository.findAllByNameContainingAndDescriptionContaining(service.getName(), service.getDescription()).toString();
    }
}
