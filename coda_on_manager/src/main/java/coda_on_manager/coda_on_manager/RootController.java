package coda_on_manager.coda_on_manager;

 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
 
@RestController 

public class RootController {
    


@RequestMapping("/")
public String RootPage() {
    return "RootPage";
}

}