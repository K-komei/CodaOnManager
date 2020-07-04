package coda_on_manager.coda_on_manager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
 
 
@Controller 

public class CodaController {


@RequestMapping("/RootPage")
public String RootPage() {
    return "RootPage";
}

@RequestMapping("/")
public String Result() {
    return "Result_test";
}


}