package com.xperad.aries.controller;

import com.xperad.aries.persistence.model.Message;
import com.xperad.aries.service.WelcomeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author sun@xperad.com
 * @version 1.0, 2015/05/18
 */

@Controller
public class WelcomeController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private WelcomeService welcomeService;

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public String index(Model model) {

        List<Message> messages = welcomeService.searchAllMessages();
        if (messages != null) {
            logger.debug("messages size is " + messages.size());
        }
        model.addAttribute("messages", messages);
        return "index";
    }
}
