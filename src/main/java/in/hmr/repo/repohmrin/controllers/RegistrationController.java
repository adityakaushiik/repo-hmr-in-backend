package in.hmr.repo.repohmrin.controllers;

import in.hmr.repo.repohmrin.userResponses.RegistrationDetails;
import in.hmr.repo.repohmrin.services.DatabaseEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/")
public class RegistrationController {
    @Autowired
    private DatabaseEntryService databaseEntry;

    @PostMapping({"/register"})
    public String userRegistration(@ModelAttribute RegistrationDetails registrationDetails) throws IOException {
        System.out.println("received request");
        System.out.println(registrationDetails);
        databaseEntry.addEntry(registrationDetails);

        return "We have your notes for review , " +
                "if they are approved you will be able to see them on the website ," +
                "Thank You for your contribution!";
    }
}