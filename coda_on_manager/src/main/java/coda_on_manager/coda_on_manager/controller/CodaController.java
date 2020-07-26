package coda_on_manager.coda_on_manager.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import coda_on_manager.coda_on_manager.dataSource.CodeData_Entity;
import coda_on_manager.coda_on_manager.dataSource.CodeData_repository;
import coda_on_manager.coda_on_manager.dataSource.UserData_Entity;
import coda_on_manager.coda_on_manager.dataSource.UserData_repository;

 
 
@Controller 
@RequestMapping("/")
@SessionAttributes(value = "useid")


public class CodaController {

//DI注入
@Autowired

//UserDataserviceレポジトリを定義

UserData_repository user_rp;
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

@PostMapping("Login")
public String Login(@ModelAttribute UserData_Entity user,HttpSession session){

 // FindAll<example>のmethodを使用
 // 検索条件にEntityの例題をセットし、それと一致するEntityを探す
 // フォームから入力された値を受け取り、実行する。

 //検索条件(Name Pass)を設定したEntityを生成する。
UserData_Entity target_user = new UserData_Entity();
target_user.setName(user.getName());
target_user.setPass(user.getPass());

 // 生成したEntityからExampleインスタンスを生成
 Example<UserData_Entity> example = Example.of(target_user);

 //検索を行い、一致したEntityをListに格納
List<UserData_Entity> users = user_rp.findAll(example);

//上で取得したリストが"1件のみ"である場合、一致成功とし、それ以外の場合、認証不可とする。

if(users.size() == 0){
        return "redirect:SiginUp";
}else{
        UserData_Entity keepdata =users.get(0);
        //session.setAttribute("id", 1);
        //System.out.println(session.getId());
        session.setAttribute("useid",keepdata.getId());
        return "redirect:Editor";

}

}

}