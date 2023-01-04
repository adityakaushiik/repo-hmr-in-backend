package in.hmr.repo.repohmrin.controllers;

import in.hmr.repo.repohmrin.services.DatabaseEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/")
public class RegistrationController {
    @Autowired
    private DatabaseEntryService databaseEntry;

    @PostMapping("/register")
    public String uploadSingleFile (@RequestParam("file") MultipartFile file) {
        System.out.println(file.getOriginalFilename());
        //wtf
        return "file uploaded";
    }
}