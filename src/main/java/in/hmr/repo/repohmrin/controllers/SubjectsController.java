package in.hmr.repo.repohmrin.controllers;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SubjectsController {

    @PostMapping("/search/getSubjects")
    @ResponseBody
    public String[] subjects(@RequestBody String string) throws JSONException {
        JSONObject jsonObject = new JSONObject(string);
        int semester = jsonObject.getInt("sem");

        if (semester<3) {
            String[] CSE1 = {
                    "ETMA-101 Applied Mathematics-I",
                    "ETPH-103 Applied Physics-I",
                    "ETME-105 Manufacturing Processes",
                    "ETEE-107 Electrical Technology",
                    "ETHS-109 Human Values and Professional Ethics",
                    "ETCS-111 Fundamentals of Computing",
                    "ETCH-113 Applied Chemistry"};
            String[] CSE2 = {
                    "ETMA-102 Applied Mathematics-II",
                    "ETPH-104 Applied Physics-II",
                    "ETEC-106 Electronic Devices",
                    "ETCS-108 Introduction to Programming",
                    "ETME-110 Engineering Mechanics",
                    "ETHS-112 Communication Skills",
                    "ETEN-114 Environmental Studies"};

            return (semester == 2) ? CSE2 : CSE1;
        }
        return cseData(semester);
    }

    private String[] cseData(int sem) {
        List<String[]> cse = new ArrayList<>(6);
        String[] CSE3 = {"ETMA-201 Applied Mathematics–III",
                "ETCS-203 Foundation of Computer Science",
                "ETEC-205 Switching Theory and Logic Design",
                "ETEE-207 Circuits and Systems",
                "ETCS-209 Data Structure",
                "ETCS-211 Computer Graphics and Multimedia"};
        String[] CSE4 = {"ETMA-202 Applied Mathematics – IV",
                "ETCS-204 Computer Organization and Architecture",
                "ETCS-206 Theory of Computation",
                "ETCS-208 Database Management Systems",
                "ETCS-210 Object Oriented Programming",
                "ETEC-212 Communication Systems"};
        String[] CSE5 = {"ETCS-301 Algorithms Design and Analysis",
                "ETCS-303 Software Engineering",
                "ETCS-307 Java Programming",
                "ETMS-311 Industrial Management",
                "ETEC-303 Digital Communication",
                "ETHS-301 Communication Skills for Professionals"};
        String[] CSE6 = {"ETCS-302 Compiler Design",
                "ETCS-304 Operating Systems",
                "ETCS-306 Computer Networks",
                "ETCS-308 Web Technology",
                "ETCS-310 Artificial Intelligence",
                "ETEE-310 Microprocessor and Microcontroller"};
        String[] CSE7 = {"ETCS-401 Information Security",
                "ETCS-403 Software Testing and Quality Assurance",
                "ETEC-405 Wireless Communication",
                "ETCS-407 Complexity Theory",
                "ETCS-409 Intellectual Property Rights",
                "ETEC-401 Embedded Systems",
                "ETCS-413 Data Mining and Business Intelligence",
                "ETCS-415 Advanced Computer Architecture",
                "ETCS-410 Natural Language Processing",
                "ETIT-415 Digital Signal Processing",
                "ETCS-421 Simulation and Modelling",
                "ETCS-423 Advanced DBMS",
                "ETCS-427 Parallel Computing",
                "ETIT-401 Advanced Computer Networks",
                "ETEE-429 Control System",
                "ETHS-419 Sociology and Elements of Indian History for Engineers"};
        String[] CSE8 = {"ETIT-402 Mobile Computing",
                "ETCS-402 Machine Learning",
                "ETHS-402 Human Values and Professional Ethics-II",
                "ETIT-418 Digital Image Processing",
                "ETCS-408 Microelectronics",
                "ETEC-406 Ad Hoc and Sensor Networks",
                "ETIT-410 Soft Computing",
                "ETIC-414 VLSI Design",
                "ETIT-430 Distributed Systems",
                "ETCS-412 Object Oriented Software Engineering",
                "ETCS-414 Computer Vision",
                "ETCS-416 Software Project Management",
                "ETCS-404 Human Computer Interaction",
                "ETIT-416 Information Theory and Coding",
                "ETCS-418 Web Intelligence and Big Data",
                "ETCS-420 Service Oriented Architecture",
                "ETCS-422 Multiagent Systems",
                "ETCS-424 Principles of Programming Languages",
                "ETCS-426 Telecommunication Networks",
                "ETCS-428 Selected Topics of Recent Trends in Computer Science and Engineering"};
        cse.add(CSE3);
        cse.add(CSE4);
        cse.add(CSE5);
        cse.add(CSE6);
        cse.add(CSE7);
        cse.add(CSE8);

        return cse.get(sem - 3);
    }
}
