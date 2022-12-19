package in.hmr.repo.repohmrin.controllers;

import in.hmr.repo.repohmrin.userResponses.RegistrationDetails;
import in.hmr.repo.repohmrin.services.DatabaseEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
public class RegistrationController {
    @Autowired
    private DatabaseEntryService databaseEntry;
    private final String FOLDER_PATH = "file://E:/repo.hmr_fileData/img";

    @GetMapping({"/register"})
    public String index() {
        return "upload-page";
    }

    @PostMapping({"/register"})
    public String userRegistration(@ModelAttribute RegistrationDetails registrationDetails,
                                   Model model) throws IOException {
        databaseEntry.addEntry(registrationDetails);

//        String filePath = FOLDER_PATH + registrationDetails.getImage().getOriginalFilename();
        model.addAttribute("user", registrationDetails);
//        model.addAttribute("image", filePath);
        return "registration-complete";
    }
}