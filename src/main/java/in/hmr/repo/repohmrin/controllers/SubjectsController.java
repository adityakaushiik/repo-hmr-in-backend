package in.hmr.repo.repohmrin.controllers;

import in.hmr.repo.repohmrin.repositories.SubjectsRepository;
import in.hmr.repo.repohmrin.userResponses.GetSubjects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/")
public class SubjectsController {
    @Autowired
    private SubjectsRepository subjectsRepository;

    @PostMapping("/getSubjects")
    public String[] subjects(@RequestBody GetSubjects params){
        System.out.println("got params"+params.getBranch()+params.getSemester());

        int semester = params.getSemester();
        if (semester<3)
            return subjectsRepository.getAllByBranchAndSemester("ALL",semester).getSubjects();

        return subjectsRepository.getAllByBranchAndSemester(params.getBranch(), semester).getSubjects();
    }
}
