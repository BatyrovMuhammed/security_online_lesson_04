package legendSoft.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {

    @GetMapping("/")
    public String getAllStudents(){
        return "/all_student";
    }
    @GetMapping("/admin-info")
    public String getInfo(){
        return "view_admin";
    }
    @GetMapping("/manager-info")
    public String getInfoManager(){
        return "/manager";
    }
}
