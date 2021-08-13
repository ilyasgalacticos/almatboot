package kz.bitlab.almatgroup.almatboot.controllers;

import kz.bitlab.almatgroup.almatboot.beans.FirstBean;
import kz.bitlab.almatgroup.almatboot.beans.ItemManager;
import kz.bitlab.almatgroup.almatboot.beans.SecondBean;
import kz.bitlab.almatgroup.almatboot.db.DBManager;
import kz.bitlab.almatgroup.almatboot.dto.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class HomeController {

    @Autowired
    private FirstBean firstBean;

    @Autowired
//    @Qualifier("secondBeanKairat")
    @Qualifier("secondBeanAikyn")
    private SecondBean kairatNurtasBean;

    @Autowired
    @Qualifier("mikhailConnectorBean")
    private ItemManager itemManager;

    @GetMapping(value = "/") //@WebServlet(value = "/")  + doGet()
    public String index(Model model){

        ArrayList<Items> items = itemManager.getAllItems();
        model.addAttribute("tovary", items); //request.setAttribute("tovary", items);

        return "index"; // request.getRequestDispatcher("/index.html").forward(request, response);
    }

    @GetMapping(value = "/about.html")
    public String aboutPage(){
        return "about";
    }

    @PostMapping(value = "/additem")
    public String addItem(@RequestParam(name = "name") String name, // String name = request.getParameter("name");
                          @RequestParam(name = "price") double price, // double price = Double.parseDouble(request.getParameter("price"));
                          @RequestParam(name = "amount") int amount){

        Items item = new Items();
        item.setName(name);
        item.setPrice(price);
        item.setAmount(amount);

        itemManager.addItem(item);

        return "redirect:/additem?success"; // response.sendRedirect("/?success");

    }

    @GetMapping(value = "/details/{itemId}.html")
    public String details(Model model, @PathVariable(name = "itemId") Long id){
        Items item = itemManager.getItem(id);
        model.addAttribute("zat", item);
        return "details";
    }

    @GetMapping(value = "/additem")
    public String addItem(Model model){
        return "additem";
    }

    @GetMapping(value = "/testpage")
    public String testPage(Model model){

        String fullText = firstBean.getText() + " - " + firstBean.getNumber();
        String fullSecondText = kairatNurtasBean.getText() + " " + kairatNurtasBean.getNumber();
        model.addAttribute("fullTextValue", fullSecondText);
        model.addAttribute("textValue", fullText);
        return "testpage";

    }

    @GetMapping(value = "/changevalue")
    public String changeValue(){

        firstBean.setNumber(222);
        firstBean.setText("Neymar");

        return "redirect:/testpage";

    }

}
