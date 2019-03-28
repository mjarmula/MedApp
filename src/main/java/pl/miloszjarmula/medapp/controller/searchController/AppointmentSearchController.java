package pl.miloszjarmula.medapp.controller.searchController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.miloszjarmula.medapp.entity.Appointment;
import pl.miloszjarmula.medapp.repository.AppointmentRepository;

@Controller
@RequestMapping("/searchAppointment")
public class AppointmentSearchController {

    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentSearchController(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @GetMapping("/search")
    public String searchAppointment(Model model){
        model.addAttribute("appointment", new Appointment());
        return "appointment/search";
    }
    @PostMapping("/search")
    @ResponseBody
    public String searchAppointment(@ModelAttribute Appointment appointment){
       return appointmentRepository.findAllByPatientLastNameContainingAndDoctorLastNameContainingAndAppointmentDateTime(appointment.getPatient().getLastName(), appointment.getDoctor().getLastName(), appointment.getAppointmentDateTime()).toString();
    }
}
