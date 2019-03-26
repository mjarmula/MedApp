package pl.miloszjarmula.medapp.controller;

import org.hibernate.property.access.internal.PropertyAccessStrategyNoopImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.miloszjarmula.medapp.entity.Receptionist;
import pl.miloszjarmula.medapp.repository.ReceptionistRepository;

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
    public String saveReceptionist(@ModelAttribute Receptionist receptionist) {
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
    public String editReceptionist(@ModelAttribute Receptionist receptionist) {
        receptionistRepository.save(receptionist);
        return "zaupdatowalem";
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String deleteReceptionist(@PathVariable Long id) {
        receptionistRepository.deleteById(id);
        return "usnolem";
    }

    //wyszukiwanie i zaawasnsowane wyszukiwanie


}
