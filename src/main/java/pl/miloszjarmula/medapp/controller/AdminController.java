package pl.miloszjarmula.medapp.controller;

import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.miloszjarmula.medapp.entity.Admin;
import pl.miloszjarmula.medapp.repository.AdminRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminController(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @GetMapping("")
    public String home(){
        return "admin/home";
    }

    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("admin",new Admin());
        return "admin/form";
    }
    @PostMapping("/form")
    @ResponseBody
    public String form(@Valid Admin admin, BindingResult result){
        if(result.hasErrors()){
            return "admin/form";
        }
        adminRepository.save(admin);
        return "zaposalem";
    }
    @GetMapping("/edit/{id}")
    public String editAdmin(@PathVariable Long id, Model model){
        model.addAttribute("admin",adminRepository.findById(id));
        return "admin/form";
    }
    @PostMapping("/edit/{id}")//czy to id musi tu byc?
    @ResponseBody
   public String editAdmin(@Valid Admin admin, BindingResult result){
        if (result.hasErrors()){
            return "admin/form";
        }
        adminRepository.save(admin);
        return "updated";
    }
    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable Long id){
        adminRepository.deleteById(id);
        return "usunolem";
    }
    @GetMapping("/find/{id}")
    public String findById(@PathVariable Long id, Model model){
        model.addAttribute("admin", adminRepository.findById(id));
        return "admin/list";
    }
    @GetMapping("/findAll")
    public String findAll(Model model){
        model.addAttribute("admin", adminRepository.findAll());
        return "admin/list";
    }
}
