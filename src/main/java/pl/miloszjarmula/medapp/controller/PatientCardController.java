package pl.miloszjarmula.medapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.miloszjarmula.medapp.entity.Doctor;
import pl.miloszjarmula.medapp.entity.PatientCard;
import pl.miloszjarmula.medapp.repository.PatientCardRepository;

import javax.validation.Valid;


@Controller
@RequestMapping("/patientCard")
public class PatientCardController {

    private final PatientCardRepository patientCardRepository;

    @Autowired
    public PatientCardController(PatientCardRepository patientCardRepository) {
        this.patientCardRepository = patientCardRepository;
    }

    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute(new PatientCard());
        return "patientCard/form";
    }

    @PostMapping("/form")
    @ResponseBody
    public String addPatientCard(@Valid PatientCard patientCard, BindingResult result){
        if(result.hasErrors()){
            return "patientCard/form";
        }
        patientCardRepository.save(patientCard);
        return "zapsialem";
    }

    @GetMapping("/edit/{id}")
    public String editPatientCard(Model model, @PathVariable Long id){
        model.addAttribute("patientCard", patientCardRepository.findById(id));
        return "patientCard/form";
    }

    @PostMapping("/edit/{id}")
    @ResponseBody
    public String PatientCard (@Valid PatientCard patientCard, BindingResult result){
        if(result.hasErrors()){
            return "patientCard/form";
        }
        patientCardRepository.save(patientCard);
        return "zapdatyowalem";
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String deletePatientCard(@PathVariable Long id){
        patientCardRepository.deleteById(id);
        return "usunolem";
    }
    @GetMapping("/findAll")
    public String findAll(Model model){
        model.addAttribute("patientCards",patientCardRepository.findAll());
        return "patientCard/list";
    }
    @GetMapping("find/{id}")
    public String findById(Model model, @PathVariable Long id){
        model.addAttribute("patientCards", patientCardRepository.findById(id));
        return "patientCard/list";
    }

}
