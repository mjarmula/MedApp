package pl.miloszjarmula.medapp.controller.searchController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.miloszjarmula.medapp.entity.Drug;
import pl.miloszjarmula.medapp.repository.DrugRepository;

@Controller
@RequestMapping("/drugSearch")
public class DrugsearchController {

    private final DrugRepository drugRepository;

    @Autowired
    public DrugsearchController(DrugRepository drugRepository) {
        this.drugRepository = drugRepository;
    }

    @GetMapping("/search")
    public String searchDrug(Model model){
        model.addAttribute("drug", new Drug());
        return "drug/search";
    }
    @PostMapping("/search")
    @ResponseBody
    public String searchDrug(@ModelAttribute Drug drug){
        return drugRepository.findAllByNameContaining(drug.getName()).toString();
    }
}
