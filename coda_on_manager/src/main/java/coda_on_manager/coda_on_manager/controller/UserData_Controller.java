package coda_on_manager.coda_on_manager.controller;



import org.springframework.stereotype.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
//UserData_repositoryレポジトリを定義
UserData_repository userDataRepo;


@GetMapping("View")
public String UserData_view(Model model){
List<UserData_Entity> user_info = userDataRepo.findAll();
model.addAttribute("users",user_info);
return "UserData";
}

@GetMapping("Create")
public String UserData_Create(Model model){
UserData_Entity userDataEnty = new UserData_Entity();
model.addAttribute("user", userDataEnty);
return "CreateUser";
}

@PostMapping("Registration")
public String UserData_Registration(UserData_Entity user){
    userDataRepo.save(user);
    return "SiginUp";
}


@PostMapping("Delete")
public String UserData_delete(@RequestParam("del_num") int del_num){
    userDataRepo.deleteById(del_num);
    return "redirect:View";
}


    
}