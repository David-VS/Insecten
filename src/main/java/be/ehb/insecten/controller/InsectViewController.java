package be.ehb.insecten.controller;

import be.ehb.insecten.model.Insect;
import be.ehb.insecten.model.InsectDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class InsectViewController {

    private InsectDao dao;

    @Autowired
    public InsectViewController(InsectDao dao) {
        this.dao = dao;
    }

    @ModelAttribute("hello")
    public String sayHello(){
        return "Hello world";
    }

    @ModelAttribute("all_in")
    public Iterable<Insect> getInsects(){
        return dao.findAll();
    }

    @ModelAttribute("formInsect")
    public Insect createNewInsect(){
        return new Insect();
    }

    @GetMapping({"/","/insect" })
    public String openIndex(ModelMap map){
        return "index";
    }

    @PostMapping("/add")
    public String postInsect(@ModelAttribute("formInsect")
                                 @Valid Insect insect,
                             BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return "index";
        }
        dao.save(insect);
        return "redirect:insect";//redirect -> voert get uit naar dit adres
    }
}
