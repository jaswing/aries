package com.xperad.aries.controller;

import com.xperad.aries.exception.DuplicateUserException;
import com.xperad.aries.persistence.model.User;
import com.xperad.aries.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sun@xperad.com
 * @version 1.0, 2015/05/24
 */

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    private List<Boolean> genderArr;

    @RequestMapping(value = "/signUp", method = RequestMethod.GET)
    public String signUp(Model model) {
        User user = new User();
        model.addAttribute("user", user);

        genderArr = new ArrayList<>();
        genderArr.add(true);
        genderArr.add(false);
        model.addAttribute("genderArr", genderArr);

        return "signUp";
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public String registerUserAccount(
            Model model,
            @ModelAttribute("user") @Valid User user,
            BindingResult result,
            WebRequest request,
            Errors errors) {

        if (!result.hasErrors()) {
            if (!createUserAccount(user, result)) {
                result.rejectValue("email", "message.regError");
            } else {
                return "redirect:/successRegister";
            }
        }

        return "signUp";
    }

    @RequestMapping(value = "/successRegister", method = RequestMethod.GET)
    public String successRegister(Model model) {
        return "successRegister";
    }

    private boolean createUserAccount(User user, BindingResult result) {
        try {
            userService.addUser(user);
            return true;
        } catch (DuplicateUserException e) {
            e.printStackTrace();
        }
        return false;
    }
}
