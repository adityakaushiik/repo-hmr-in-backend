package in.hmr.repo.repohmrin.controller;

import in.hmr.repo.repohmrin.model.User;
import in.hmr.repo.repohmrin.services.DatabaseEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    @Autowired
    private DatabaseEntry databaseEntry;

    @GetMapping({"/"})
    public String index() {
        return "index";
    }

    @PostMapping({"/register"})
    public String userRegistration(@ModelAttribute User user, Model model) {

        databaseEntry.addEntry(user);
        model.addAttribute("user", user);

        return "registration-complete";
    }
}
