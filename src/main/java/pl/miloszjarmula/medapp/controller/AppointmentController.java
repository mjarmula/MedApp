package pl.miloszjarmula.medapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.miloszjarmula.medapp.entity.Appointment;
import pl.miloszjarmula.medapp.entity.Doctor;
import pl.miloszjarmula.medapp.repository.AppointmentRepository;

@Controller
@RequestMapping("/appointment")
public class AppointmentController {

    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentController(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute(new Appointment());
        return "appointment/form";
    }

    @PostMapping("/form")
    @ResponseBody
    public String addDoctor(@ModelAttribute Appointment appointment){
        appointmentRepository.save(appointment);
        return "zapsialem";
    }

    @GetMapping("/edit/{id}")
    public String editDoctor(Model model, @PathVariable Long id){
        model.addAttribute("appointment", appointmentRepository.findById(id));
        return "appointment/form";
    }

    @PostMapping("/edit/{id}")
    @ResponseBody
    public String editDocor(@ModelAttribute Appointment appointment){
        appointmentRepository.save(appointment);
        return "zapdatyowalem";
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String deleteDoctor(@PathVariable Long id){
        appointmentRepository.deleteById(id);
        return "usunolem";
    }

}
