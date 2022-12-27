package in.hmr.repo.repohmrin.controllers;

import in.hmr.repo.repohmrin.userResponses.RegistrationDetails;
import in.hmr.repo.repohmrin.services.DatabaseEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("api/")
public class RegistrationController {
    @Autowired
    private DatabaseEntryService databaseEntry;

    @PostMapping({"/register"})
    public String userRegistration(@ModelAttribute RegistrationDetails registrationDetails) throws IOException {
        databaseEntry.addEntry(registrationDetails);
        return "registration-complete";
    }
}