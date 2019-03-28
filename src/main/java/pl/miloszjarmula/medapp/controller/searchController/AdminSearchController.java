package pl.miloszjarmula.medapp.controller.searchController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.miloszjarmula.medapp.entity.Admin;
import pl.miloszjarmula.medapp.repository.AdminRepository;

@Controller
@RequestMapping("/adminSearch")
public class AdminSearchController {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminSearchController(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @GetMapping("/search")
    public String searchAdmin(Model model){
        model.addAttribute("admin",new Admin());
        return "admin/search";
    }
    @PostMapping("/search")
    @ResponseBody
    public String searchAdmin(@ModelAttribute Admin admin){
        return adminRepository.
                findAllByFirstNameContainingAndLastNameContainingAndEmailContainingAndPeselContainingAndEmailContainingAndAdressContaining(admin.getFirstName(), admin.getLastName(), admin.getEmail(), admin.getPesel(), admin.getPhoneNumber(), admin.getAdress()).toString();
    }
}
