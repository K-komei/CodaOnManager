package coda_on_manager.coda_on_manager.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import coda_on_manager.coda_on_manager.dataSource.CodeData_Entity;
import coda_on_manager.coda_on_manager.dataSource.CodeData_repository;
import coda_on_manager.coda_on_manager.dataSource.UserData_Entity;
import coda_on_manager.coda_on_manager.dataSource.UserData_repository;

 
 
@Controller 
@RequestMapping("/")




public class CodaController {

//DI注入
@Autowired

//UserDataレポジトリを定義
CodeData_repository code_rp;


@GetMapping("Editor")
public String Editor(Model model) {

CodeData_Entity code = new CodeData_Entity();
model.addAttribute("code",code);

return "Editor";
}

@PostMapping("Editor")
public String Editor(Model model,@ModelAttribute UserData_Entity user) {
CodeData_Entity code = new CodeData_Entity();
model.addAttribute("code",code);
return "Editor";
}


@GetMapping("SiginUp")
public String SiginUp(Model model) {
UserData_Entity user_info = new UserData_Entity();
model.addAttribute("user",user_info);
return "SiginUp";
}

@PostMapping("Upload")
public String Upload(CodeData_Entity code) {
    
        System.out.println(code.getId());
        System.out.println(code.getCodename());
        System.out.println(code.getCodebody());
        System.out.println(code.getCreate_user_id());

        code_rp.save(code);
    
return "redirect:Editor";

}

@GetMapping("Filelist")
public String CodeData_view(Model model){
List<CodeData_Entity> code_data = code_rp.findAll();
model.addAttribute("codes",code_data);
return "FileList";
}



}