package com.xperad.aries.controller;

import com.xperad.aries.exception.UserNotFoundException;
import com.xperad.aries.persistence.model.User;
import com.xperad.aries.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author sun@xperad.com
 * @version 1.0, 2015/06/21
 */

@Controller
@RequestMapping("/users")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @RequestMapping("/{id}")
    public ModelAndView view(@PathVariable("id") int userId) {
        User userInfo = null;
        try {
            userInfo = userService.getUser(userId);
        } catch (UserNotFoundException e) {
        }
        return new ModelAndView("users/view", "user", userInfo);
    }
}
