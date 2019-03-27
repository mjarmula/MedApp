package pl.miloszjarmula.medapp.controller;

import org.hibernate.property.access.internal.PropertyAccessStrategyIndexBackRefImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.miloszjarmula.medapp.entity.Doctor;
import pl.miloszjarmula.medapp.repository.DoctorRepository;
import sun.awt.image.ShortInterleavedRaster;

import javax.print.Doc;
import javax.validation.Valid;

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
    public String addDoctor(@Valid Doctor doctor, BindingResult result){
        if(result.hasErrors()){
            return "doctor/home";
        }
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
    public String editDoctor(@Valid Doctor doctor, BindingResult result){
        if(result.hasErrors()){
            return "doctor/form";
        }
        doctorRepository.save(doctor);
        return "zapdatyowalem";
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String deleteDoctor(@PathVariable Long id){
        doctorRepository.deleteById(id);
        return "usunolem";
    }
    @GetMapping("/findAll")
    public String findAll(Model model){
        model.addAttribute("doctors",doctorRepository.findAll());
        return "doctor/list";
    }
    @GetMapping("find/{id}")
    public String findById(Model model, @PathVariable Long id){
        model.addAttribute("doctor", doctorRepository.findById(id));
        return "doctor/list";
    }

}
