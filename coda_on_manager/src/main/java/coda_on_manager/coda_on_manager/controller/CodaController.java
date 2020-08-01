package coda_on_manager.coda_on_manager.controller;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Null;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

@Autowired
CodeData_repository code_rp;


//ファイル一覧の新規ボタンでアクセスした場合における遷移先
//空のcodeデータをフィールドにセットする。
@GetMapping("Editor")
public String Editor(Model model,HttpSession session) {
        
        CodeData_Entity code = new CodeData_Entity();
        code.setId(0);
        model.addAttribute("code",code);
        UserData_Entity sessionuser = (UserData_Entity) session.getAttribute("useid");
        model.addAttribute("user",sessionuser);
        return "Editor";
}

//ファイル一覧からアクセスする際に使用するmethod
//codeデータを保持した状態でアクセスする。
@PostMapping("Editor")
public String Editor(Model model,HttpSession session,@RequestParam("codenum") int codenum) {
        CodeData_Entity code = code_rp.getOne(codenum);
        model.addAttribute("code",code);
        UserData_Entity sessionuser = (UserData_Entity) session.getAttribute("useid");
        model.addAttribute("user",sessionuser);
        return "Editor";
}


@GetMapping("SiginUp")
public String SiginUp(Model model) {
UserData_Entity user_info = new UserData_Entity();
model.addAttribute("user",user_info);
return "SiginUp";
}

@PostMapping("Upload")
public String Upload(@ModelAttribute CodeData_Entity code,HttpSession session,Model model) { 
//sessionよりユーザーデータを取り出す
 UserData_Entity user = (UserData_Entity) session.getAttribute("useid");
 //作成者にUserIdをセット
 code.setCreate_user_id(user.getId());

 if(code.getCodename().length() > 1){
        code_rp.save(code);
        return "redirect:Editor";       
 }else{
        return "redirect:Editor"; 
 }



@GetMapping("Filelist")
public String CodeData_view(Model model,HttpSession session){        

 //sessionよりユーザーデータを取り出す

 UserData_Entity user = (UserData_Entity) session.getAttribute("useid");

 //検索条件(Name Pass)を設定したEntityを生成する。
 CodeData_Entity target_code = new CodeData_Entity();

 target_code.setCreate_user_id(user.getId());

 // 生成したEntityからExampleインスタンスを生成
  Example<CodeData_Entity> example = Example.of(target_code);
  //検索を行い、一致したEntityをListに格納

  List<CodeData_Entity> codes = code_rp.findAll(example);

    model.addAttribute("codes",codes);
    model.addAttribute("user",user);
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
        session.setAttribute("useid",keepdata);
        return "redirect:Filelist";
}

}

}

}
/*

当初、上書きと新規で別のボタンにて実装しようと考えていたが、諸事情により断念

@PostMapping("OverWrite")
public String OverWrite(@ModelAttribute CodeData_Entity code,HttpSession session,Model model) {
 //sessionよりユーザーデータを取り出す
 UserData_Entity user = (UserData_Entity) session.getAttribute("useid");
 code.setCreate_user_id(user.getId());
 //
 CodeData_Entity changecode;

 if(code.getId() == 0){
         return "redirect:Editor";

 }else{
        changecode = code_rp.getOne(code.getId());
        changecode.setId(code.getId());
        changecode.setCodename(code.getCodename());
        changecode.setCodebody(code.getCodebody());
        changecode.setCreate_user_id(code.getCreate_user_id());
        code_rp.save(changecode);
        return "redirect:Editor";
 }

}
*/
