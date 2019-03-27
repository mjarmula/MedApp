package pl.miloszjarmula.medapp.controller;

import org.hibernate.property.access.internal.PropertyAccessStrategyNoopImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.miloszjarmula.medapp.entity.Receptionist;
import pl.miloszjarmula.medapp.repository.ReceptionistRepository;
import sun.awt.image.ShortInterleavedRaster;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/receptionist")
public class ReceptionistController {

    private final ReceptionistRepository receptionistRepository;

    @Autowired
    public ReceptionistController(ReceptionistRepository receptionistRepository) {
        this.receptionistRepository = receptionistRepository;
    }


    @GetMapping("")
    public String home(){
        return "receptionist/home";
    }

    @GetMapping("/form")
    public String receptionistForm(Model model) {
        model.addAttribute(new Receptionist());
        return "receptionist/form";
    }

    @PostMapping("/form")
    @ResponseBody
    public String saveReceptionist(@Valid Receptionist receptionist, BindingResult result) {
        if(result.hasErrors()){
            return "receptionist/form";
        }
        receptionistRepository.save(receptionist);
        return "zapoisalem";
    }

    @GetMapping("/edit/{id}")
    public String editReceptionist(Model model, @PathVariable Long id) {
        model.addAttribute("receptionist", receptionistRepository.findById(id));
        return "receptionist/form";
    }

    @PostMapping("/edit/{id}")
    @ResponseBody
    public String editReceptionist(@Valid Receptionist receptionist, BindingResult result) {
        if(result.hasErrors()){
            return "receptionist/form";
        }
        receptionistRepository.save(receptionist);
        return "zaupdatowalem";
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String deleteReceptionist(@PathVariable Long id) {
        receptionistRepository.deleteById(id);
        return "usnolem";
    }
    @GetMapping("/findAll")
    public String findAll(Model model){
        model.addAttribute("receptionists",receptionistRepository.findAll());
        return "receptionist/list";
    }
    @GetMapping("/find/{id}")
    public String findById(Model model, @PathVariable Long id){
        model.addAttribute("receptionists",receptionistRepository.findById(id));
        return "receptionist/list";
    }

    //wyszukiwanie i zaawasnsowane wyszukiwanie


}
