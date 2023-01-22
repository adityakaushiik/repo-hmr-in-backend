package in.hmr.repo.repohmrin.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import in.hmr.repo.repohmrin.services.DatabaseEntryService;
import in.hmr.repo.repohmrin.userResponses.RegistrationDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/")
public class RegistrationController {
    @Autowired
    private DatabaseEntryService databaseEntry;

    @PostMapping("/register")
    public RegistrationDetails uploadSingleFile(@RequestParam("file") MultipartFile file,
                                                   @RequestParam("data") String details) throws IOException {
        System.out.println(Timestamp.valueOf(LocalDateTime.now()));

        ObjectMapper objectMapper = new ObjectMapper();
        RegistrationDetails registrationDetails = objectMapper.readValue(details, RegistrationDetails.class);

        databaseEntry.addEntry(registrationDetails, file);

        return registrationDetails;
    }
}