package pl.miloszjarmula.medapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.miloszjarmula.medapp.entity.Doctor;
import pl.miloszjarmula.medapp.repository.DoctorRepository;

import javax.print.Doc;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorController(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @GetMapping("")
    public String home(){
        return "doctor/home";
    }

    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute(new Doctor());
        return "doctor/form";
    }

    @PostMapping("/form")
    @ResponseBody
    public String addDoctor(@ModelAttribute Doctor doctor){
        doctorRepository.save(doctor);
        return "zapsialem";
    }

    @GetMapping("/edit/{id}")
    public String editDoctor(Model model, @PathVariable Long id){
        model.addAttribute("doctor", doctorRepository.findById(id));
        return "doctor/form";
    }

    @PostMapping("/edit/{id}")
    @ResponseBody
    public String editDocor(@ModelAttribute Doctor doctor){
        doctorRepository.save(doctor);
        return "zapdatyowalem";
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String deleteDoctor(@PathVariable Long id){
        doctorRepository.deleteById(id);
        return "usunolem";
    }

}
