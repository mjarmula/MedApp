package pl.miloszjarmula.medapp.controller.searchController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.miloszjarmula.medapp.entity.Receptionist;
import pl.miloszjarmula.medapp.repository.ReceptionistRepository;

@Controller
@RequestMapping("/receptionistSearch")
public class ReceptionistSearchController {

    private final ReceptionistRepository receptionistRepository;

    @Autowired
    public ReceptionistSearchController(ReceptionistRepository receptionistRepository) {
        this.receptionistRepository = receptionistRepository;
    }

    @GetMapping("/search")
    public String searchReceptionist(Model model){
        model.addAttribute("receptionist", new Receptionist());
        return "receptionist/search";
    }

    @PostMapping("/search")
    @ResponseBody
    public String searchReceptionist(@ModelAttribute Receptionist receptionist){
        return receptionistRepository.findAllByFirstNameContainingAndLastNameContainingAndEmailContaining(receptionist.getFirstName(), receptionist.getLastName(), receptionist.getEmail()).toString();
    }
}
