package pl.miloszjarmula.medapp.controller.webController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.miloszjarmula.medapp.repository.DrugRepository;

import javax.xml.ws.Action;

@Controller
@RequestMapping("/drug")
public class DrugController {

    private final DrugRepository drugRepository;

    @Autowired
    public DrugController(DrugRepository drugRepository) {
        this.drugRepository = drugRepository;
    }

    @GetMapping("findAll")
    public String findAll(Model model){
       model.addAttribute("drugs",drugRepository.findAll());
        return "drug/list";
    }


}
