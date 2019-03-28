package pl.miloszjarmula.medapp.controller.searchController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.miloszjarmula.medapp.entity.Admin;
import pl.miloszjarmula.medapp.entity.Doctor;
import pl.miloszjarmula.medapp.repository.DoctorRepository;
@Controller
@RequestMapping("/doctorSearch")
public class DoctorSearchController {

    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorSearchController(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }


    @GetMapping("/search")
    public String searchDocotr(Model model){
        model.addAttribute("doctor",new Doctor());
        return "doctor/search";
    }

    @PostMapping("/search")
    @ResponseBody
    public String searchDoctor(@ModelAttribute Doctor doctor){
        return doctorRepository.findAllByFirstNameContainingAndLastNameContainingAndSepcializationContaining(doctor.getFirstName(), doctor.getLastName(), doctor.getSepcialization()).toString();

    }
}
