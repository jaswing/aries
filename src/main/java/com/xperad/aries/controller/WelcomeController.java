package com.xperad.aries.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author xperad
 * @version 1.0, 2015/05/18
 */

@Controller
public class WelcomeController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public String index() {
        logger.debug("This is test log message.");
        return "index";
    }
}
