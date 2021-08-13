package kz.bitlab.almatgroup.almatboot.controllers;

import kz.bitlab.almatgroup.almatboot.beans.FirstBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OtherController {

    @Autowired
    private FirstBean firstBean;

    @GetMapping(value = "/otherpage")
    public String otherPage(Model model){

        String text = firstBean.getText() + " / "+firstBean.getNumber();
        model.addAttribute("text", text);

        return "otherpage";
    }

}
