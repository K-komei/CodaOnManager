package coda_on_manager.coda_on_manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

 
 
@Controller 

public class CodaController {

@RequestMapping("/Main")
public String RootPage() {
    return "Main";
}

@RequestMapping("/")
public String SiginUp() {
    return "SiginUp";
}





}