package pl.miloszjarmula.medapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.miloszjarmula.medapp.entity.Admin;
import pl.miloszjarmula.medapp.entity.Patient;
import pl.miloszjarmula.medapp.repository.PatientRepository;

@Controller
@RequestMapping("/patient")
public class PatientController {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }


    @GetMapping("")
    public String home(){
        return "patient/home";
    }

    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("patient",new Patient());
        return "patient/form";
    }
    @PostMapping("/form")
    @ResponseBody
    public String form(@ModelAttribute Patient patient){
        patientRepository.save(patient);
        return "zaposale";
    }
    @GetMapping("/edit/{id}")
    public String editAdmin(@PathVariable Long id, Model model){
        model.addAttribute("patient",patientRepository.findById(id));
        return "patient/form";
    }
    @PostMapping("/edit/{id}")//czy to id musi tu byc?
    @ResponseBody
    public String editAdmin(@ModelAttribute Patient patient){
        patientRepository.save(patient);
        return "updated";
    }
    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable Long id){
        patientRepository.deleteById(id);
        return "usunolem";
    }
}
