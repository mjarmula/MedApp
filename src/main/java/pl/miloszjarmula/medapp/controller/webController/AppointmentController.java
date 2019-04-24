package pl.miloszjarmula.medapp.controller.webController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.miloszjarmula.medapp.entity.Appointment;
import pl.miloszjarmula.medapp.entity.Doctor;
import pl.miloszjarmula.medapp.entity.Patient;
import pl.miloszjarmula.medapp.entity.Service;
import pl.miloszjarmula.medapp.repository.AppointmentRepository;
import pl.miloszjarmula.medapp.repository.DoctorRepository;
import pl.miloszjarmula.medapp.repository.PatientRepository;
import pl.miloszjarmula.medapp.repository.ServiceRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/appointment")
public class AppointmentController {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final ServiceRepository serviceRepository;

    @Autowired
    public AppointmentController(AppointmentRepository appointmentRepository, DoctorRepository doctorRepository, PatientRepository patientRepository, ServiceRepository serviceRepository) {
        this.appointmentRepository = appointmentRepository;
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
        this.serviceRepository = serviceRepository;
    }

    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute(new Appointment());
        return "appointment/form";
    }

    @PostMapping("/form")
    @ResponseBody
    public String addDoctor(@Valid Appointment appointment, BindingResult result){
        if(result.hasErrors()){
            return "appointment/form";
        }
        appointmentRepository.save(appointment);
        return "saved";
    }

    @GetMapping("/edit/{id}")
    public String editDoctor(Model model, @PathVariable Long id){
        model.addAttribute("appointment", appointmentRepository.findById(id));
        return "appointment/form";
    }

    @PostMapping("/edit/{id}")
    @ResponseBody
    public String editDoctor(@Valid Appointment appointment, BindingResult result){
        if(result.hasErrors()){
            return "appointment/form";
        }
        appointmentRepository.save(appointment);
        return "updated";
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String deleteDoctor(@PathVariable Long id){
        appointmentRepository.deleteById(id);
        return "deleted";
    }
    @GetMapping("/findAll")
    public String findAll(Model model){
        model.addAttribute("appointments",appointmentRepository.findAll());
        return "appointment/list";
    }



    @ModelAttribute("doctors")
    public List<Doctor> getDoctors() {
        return doctorRepository.findAll();
    }

    @ModelAttribute("patients")
    public List<Patient> getPatients() {
        return patientRepository.findAll();
    }

    @ModelAttribute("services")
    public List<Service> getServices(){
        return serviceRepository.findAll();
    }



}
