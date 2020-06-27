package coda_on_manager.coda_on_manager;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;

 
@Controller

public class MainPageController{
    @RequestMapping(value = "/RootPage", method = RequestMethod.GET)
    public String RootPage(Model model){
        // 空のフォームオブジェクトをModelに設定
    model.addAttribute("message", new Message());
        // 遷移先を返す(この場合はinput.htmlが遷移先となる)
    return "RootPage";
}

}

