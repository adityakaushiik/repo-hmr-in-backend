package in.hmr.repo.repohmrin.controllers;

import com.google.gson.JsonObject;
import in.hmr.repo.repohmrin.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/")
public class BookController {
    @Autowired
    FileService fileService;

    @PostMapping("/file")
    public JsonObject download(@RequestParam("name") String fileName) throws IOException {
        System.out.println("HIT -/download | File Name : {}"+fileName);
        return fileService.download(fileName);
    }
}