package com.theironyard;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * Created by meekinsworks on 9/2/16.
 */
@Controller
public class TestController {
    ArrayList<Message> messages = new ArrayList<>();


//	•	In your controller, create a route for /
//	◦	It should take the model and the request as arguments
//	◦	It should read the username from the session and add it to the model
//	◦	It should return the home template

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session) {
        model.addAttribute("name", session.getAttribute("userName"));
        return "home";
    }


    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String userName) {
        session.setAttribute("userName", session.getAttribute("userName"));
        return "/";
    }
    @RequestMapping(path = "/add-message", method = RequestMethod.GET)
    public String message(Model model, int id, String text) {
        Message m = new Message (id, text);

        messages.add(m);
//        messages.size()+1)
        return "/";

    }
    @RequestMapping (path = "/delete-message", method = RequestMethod.POST)
    public String deleteMessage(HttpSession session, int id) {
        messages.remove(id-1);
        return "redirect:/";


    }


}
