package com.abshar.educational.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/")
public class HomeController {
    static final String VIEW_NAME = "view/main";
    /**
     * Spring REST template.
     */
    private final RestTemplate restTemplate;
    /**
     * HomeController Constructor.
     * @param pRestTemplate rest template
     */
    public HomeController(final RestTemplate pRestTemplate) {
        this.restTemplate = pRestTemplate;
    }

    /**
     * Handles the main web page.
     *
     * @return the view name
     */
    @RequestMapping({"/" })
    public String home() {
        return VIEW_NAME;
    }
}
