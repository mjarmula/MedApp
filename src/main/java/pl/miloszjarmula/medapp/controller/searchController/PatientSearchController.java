package pl.miloszjarmula.medapp.controller.searchController;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.miloszjarmula.medapp.entity.Patient;
import pl.miloszjarmula.medapp.repository.PatientRepository;

@Controller
@RequestMapping("/patientSearch")
public class PatientSearchController {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientSearchController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @GetMapping("/search")
    public String searchPatient(Model model){
        model.addAttribute("patient", new Patient());
        return "patient/search";
    }
    @PostMapping("/search")
    @ResponseBody
    public String searchPatient(@ModelAttribute Patient patient){
        return patientRepository.findAllByFirstNameContainingAndLastNameContainingAndPeselContainingAndAdressContainingAndEmailContaining(patient.getFirstName(), patient.getLastName(),patient.getPesel(),patient.getAdress(),patient.getEmail()).toString();
    }
}
