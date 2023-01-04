package in.hmr.repo.repohmrin.controllers;

import in.hmr.repo.repohmrin.services.DatabaseEntryService;
import in.hmr.repo.repohmrin.userResponses.RegistrationDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/")
public class RegistrationController {
    @Autowired
    private DatabaseEntryService databaseEntry;

//    @PostMapping("/register")
//    public String uploadSingleFile (@RequestBody GetParams getParams) {
//        System.out.println(getParams.registrationDetails);
//        System.out.println(getParams.file.getOriginalFilename());
//        return "file uploaded";
//    }

    @PostMapping("/register")
    public String uploadSingleFile (@RequestParam RegistrationDetails registrationDetails,
                                    @RequestParam("file") MultipartFile file) {
        System.out.println(registrationDetails);
        System.out.println(file.getOriginalFilename());
        return "file uploaded";
    }

//    @PostMapping("/register")
//    public String uploadSingleFile (@RequestParam("file") MultipartFile file) {
//        System.out.println(file.getOriginalFilename());
//        //wtf
//        return "file uploaded";
//    }
}