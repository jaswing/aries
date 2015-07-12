package com.xperad.aries.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author sun@xperad.com
 * @version 1.0, 2015/06/21
 */

@Controller
public class DefaultController {

    @RequestMapping("/**")
    public String notFound() {
        return "errors/404";
    }
}
