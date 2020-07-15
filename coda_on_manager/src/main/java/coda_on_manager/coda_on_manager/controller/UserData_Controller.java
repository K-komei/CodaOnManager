package coda_on_manager.coda_on_manager.controller;



import org.springframework.stereotype.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import coda_on_manager.coda_on_manager.dataSource.UserData_Entity;
import coda_on_manager.coda_on_manager.dataSource.UserData_repository;
//import coda_on_manager.coda_on_manager.service.Userdata_Registration;

//エンティティ:ユーザーデータに関するコントローラ

@Controller
@RequestMapping("/Userdata")
 //以下のメソッドは上記URLから始まるURLに適用する

public class UserData_Controller {
   
//DI注入
@Autowired

//UserDataレポジトリを定義
UserData_repository UserData_Repository;

@GetMapping("View")
public String UserData_view(Model model){
List<UserData_Entity> user_info = UserData_Repository.findAll();
model.addAttribute("users",user_info);
return "UserData";
}

@PostMapping("Create")
public void UserData_create(@ModelAttribute UserData_Entity user){
    UserData_Repository.save(user);
}

    
}