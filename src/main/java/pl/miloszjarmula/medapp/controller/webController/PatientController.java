package pl.miloszjarmula.medapp.controller.webController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.miloszjarmula.medapp.entity.Admin;
import pl.miloszjarmula.medapp.entity.Patient;
import pl.miloszjarmula.medapp.repository.PatientRepository;

import javax.validation.Valid;

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
    public String form(@Valid Patient patient, BindingResult result){
        if(result.hasErrors()){
            return "patient/form";
        }
        patientRepository.save(patient);
        return "zaposale";
    }
    @GetMapping("/edit/{id}")
    public String editAdmin(@PathVariable Long id, Model model){
        model.addAttribute("patient",patientRepository.findById(id));
        return "patient/form";
    }
    @PostMapping("/edit/{id}")
    @ResponseBody
    public String editAdmin(@Valid Patient patient, BindingResult result){
        if(result.hasErrors()){
            return "patient/form";
        }
        patientRepository.save(patient);
        return "updated";
    }
    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable Long id){
        patientRepository.deleteById(id);
        return "usunolem";
    }

    @GetMapping("/findAll")
    public String findAll(Model model){
        model.addAttribute("patients", patientRepository.findAll());
        return "patient/list";
    }
    @GetMapping("/find/{id}")
    public String findById(Model model, @PathVariable Long id){
        model.addAttribute("patients", patientRepository.findById(id));
        return "patient/list";
    }
}
