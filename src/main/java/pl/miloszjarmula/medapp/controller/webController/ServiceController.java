package pl.miloszjarmula.medapp.controller.webController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.miloszjarmula.medapp.entity.Doctor;
import pl.miloszjarmula.medapp.entity.Service;
import pl.miloszjarmula.medapp.repository.ServiceRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/service")
public class ServiceController {
    private final ServiceRepository serviceRepository;

    @Autowired
    public ServiceController(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("service",new Service());
        return "service/form";
    }

    @PostMapping("/form")
    @ResponseBody
    public String addDoctor(@Valid Service service, BindingResult result){
        if(result.hasErrors()){
            return "service/home";
        }
        serviceRepository.save(service);
        return "zapsialem";
    }

    @GetMapping("/edit/{id}")
    public String editDoctor(Model model, @PathVariable Long id){
        model.addAttribute("service", serviceRepository.findById(id));
        return "service/form";
    }

    @PostMapping("/edit/{id}")
    @ResponseBody
    public String editDoctor(@Valid Service service, BindingResult result){
        if(result.hasErrors()){
            return "service/form";
        }
        serviceRepository.save(service);
        return "zapdatyowalem";
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String deleteDoctor(@PathVariable Long id){
        serviceRepository.deleteById(id);
        return "usunolem";
    }
    @GetMapping("/findAll")
    public String findAll(Model model){
        model.addAttribute("service",serviceRepository.findAll());
        return "doctor/list";
    }
    @GetMapping("find/{id}")
    public String findById(Model model, @PathVariable Long id){
        model.addAttribute("service", serviceRepository.findById(id));
        return "doctor/list";
    }

}