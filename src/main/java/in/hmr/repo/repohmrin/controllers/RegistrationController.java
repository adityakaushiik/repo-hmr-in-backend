package in.hmr.repo.repohmrin.controllers;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import in.hmr.repo.repohmrin.services.DatabaseEntryService;
import in.hmr.repo.repohmrin.userResponses.RegistrationDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "api/")
public class RegistrationController {

    @Autowired
    private DatabaseEntryService databaseEntry;

    @PostMapping({"/register"})
    @JsonDeserialize(as = RegistrationDetails.class)
    public String userRegistration(@RequestBody RegistrationDetails registrationDetails) {
        System.out.println("received request");
        System.out.println(registrationDetails);
//        System.out.println("file" + file.getOriginalFilename());

        return "We have your notes for review , " +
                "if they are approved you will be able to see them on the website ," +
                "Thank You for your contribution!";
    }
//    @PostMapping({"/file"})
//    public String userFile(@RequestParam("file") MultipartFile file) {
//        System.out.println("received request");
//        System.out.println("file" + file.getOriginalFilename());
////        System.out.println(registrationDetails);
//
//        return "We have your notes for review , " +
//                "if they are approved you will be able to see them on the website ," +
//                "Thank You for your contribution!";
//    }
}