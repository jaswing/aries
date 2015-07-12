package com.xperad.aries.controller;

import com.xperad.aries.exception.DuplicateUserException;
import com.xperad.aries.persistence.model.User;
import com.xperad.aries.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/**
 * @author sun@xperad.com
 * @version 1.0, 2015/05/24
 */

@Controller
public class RegisterController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private MessageSource messageSource;

    @ModelAttribute(value = "genderMap")
    private Map<Boolean, String> genderMap(Locale locale) {
        Map<Boolean, String> genderMap = new LinkedHashMap<>();
        genderMap.put(true, messageSource.getMessage("genderMap.male", null, locale));
        genderMap.put(false, messageSource.getMessage("genderMap.female", null, locale));
        return genderMap;
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.GET)
    public String signUp(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "signUp";
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public String registerUserAccount(
            Model model,
            @Valid @ModelAttribute("user") User user,
            BindingResult result,
            Locale locale,
            WebRequest request,
            Errors errors,
            RedirectAttributes redirect) {

        if (!result.hasErrors()) {
            User addedUser = createUserAccount(user, result);
            if (addedUser == null) {
                result.rejectValue("username", "ERR001", messageSource.getMessage("regError", null, locale));
            } else {
                redirect.addFlashAttribute("user", addedUser);
                return "redirect:/successRegister";
            }
        }

        return "signUp";
    }

    @RequestMapping(value = "/successRegister", method = RequestMethod.GET)
    public String successRegister(Model model, @ModelAttribute("user") User user) {
        model.addAttribute("user", user);
        return "successRegister";
    }

    private User createUserAccount(User user, BindingResult result) {
        try {
            return userService.addUserReturn(user);
        } catch (DuplicateUserException e) {
            logger.error(e.getMessage());
        }
        return null;
    }
}
