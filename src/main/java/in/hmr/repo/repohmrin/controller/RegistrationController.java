package in.hmr.repo.repohmrin.controller;

import in.hmr.repo.repohmrin.entity.UserResponse;
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
    private final String FOLDER_PATH = "file://E:/repo.hmr_fileData/";


    @GetMapping({"/"})
    public String index() {
        return "register";
    }

    @PostMapping({"/register"})
    public String userRegistration(@ModelAttribute UserResponse userResponse, Model model) throws IOException {

        databaseEntry.addEntry(userResponse);

        String filePath = FOLDER_PATH + userResponse.getImage().getOriginalFilename();
        model.addAttribute("user", userResponse);
        model.addAttribute("image", filePath);
        return "registration-complete";
    }
}










//    @PostMapping("/fileSystem")
//    public ResponseEntity<?> uploadImageToFIleSystem(@RequestParam("image") MultipartFile file) throws IOException {
//        String uploadImage = imageStorageService.uploadImageToFileSystem(file);
//        return ResponseEntity.status(HttpStatus.OK)
//                .body(uploadImage);
//    }
//
