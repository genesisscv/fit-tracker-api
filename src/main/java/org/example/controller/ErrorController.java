package org.example.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        // Get the HTTP status code from the request
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");

        if (statusCode != null && statusCode == 404) {
            // Handle 404 error - No mapping for GET
            return "custom404"; // Return the name of the custom 404 error page
        }

        // Handle other errors
        return "error"; // Return the name of the general error page
    }
}
