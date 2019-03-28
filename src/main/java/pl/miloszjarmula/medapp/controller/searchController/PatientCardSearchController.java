package pl.miloszjarmula.medapp.controller.searchController;

import org.hibernate.property.access.internal.PropertyAccessStrategyNoopImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.miloszjarmula.medapp.entity.Patient;
import pl.miloszjarmula.medapp.entity.PatientCard;
import pl.miloszjarmula.medapp.repository.PatientCardRepository;

import javax.validation.constraints.PastOrPresent;

@Controller
@RequestMapping("/patientCardSearch")
public class PatientCardSearchController {

    private final PatientCardRepository patientCardRepository;

    @Autowired
    public PatientCardSearchController(PatientCardRepository patientCardRepository) {
        this.patientCardRepository = patientCardRepository;
    }

    @GetMapping("/search")
    public String searchPatientCard(Model model){
        model.addAttribute("patientCard", new PatientCard());
        return "patientCard/search";
    }
    @PostMapping("/search")
    @ResponseBody
    public  String searchPatientCard(@ModelAttribute PatientCard patientCard){
       return patientCardRepository.findAllByPatientFirstNameContainingAndPatientLastNameContaining(patientCard.getPatient().getFirstName(), patientCard.getPatient().getLastName()).toString();
    }
}
