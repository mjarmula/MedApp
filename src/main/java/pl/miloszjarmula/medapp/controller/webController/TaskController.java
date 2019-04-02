package pl.miloszjarmula.medapp.controller.webController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.miloszjarmula.medapp.entity.Task;
import pl.miloszjarmula.medapp.repository.TaskRepository;

import java.util.List;

@Controller
@RequestMapping("/task")
public class TaskController {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/form")
    public String formTask(Model model){
        model.addAttribute("task", new Task());
        return "task/form";
    }
    @PostMapping("/form")
    @ResponseBody
    public String formTask(@ModelAttribute Task task, BindingResult result){
        if(result.hasErrors()){
            return "task/form";
        }
        taskRepository.save(task);
        return"zapisalem";
    }

    @GetMapping("/edit/{id}")
    public String editTask(@PathVariable Long id, Model  model){
        model.addAttribute("task", taskRepository.findById(id));
        return "task/form";
    }
    @PostMapping("/edit/{id}")
    @ResponseBody
    public String editTask(@ModelAttribute Task  task, BindingResult result){
        if(result.hasErrors()){
            return "task/form";
        }

        taskRepository.save(task);
        return "updated";
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String deleteTask(@PathVariable Long id){
        taskRepository.deleteById(id);
        return "deleted";
    }

    @GetMapping("/findAll")
    public String findAll(Model model){
        model.addAttribute("tasks",taskRepository.findAll());
        return "task/list";
    }
    @GetMapping("find/{id}")
    public String findById(Model model, @PathVariable Long id){
        model.addAttribute("tasks", taskRepository.findById(id));
        return "task/list";
    }


}
