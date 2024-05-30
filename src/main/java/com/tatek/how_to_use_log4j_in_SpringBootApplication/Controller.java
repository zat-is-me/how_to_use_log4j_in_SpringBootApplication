package com.tatek.how_to_use_log4j_in_SpringBootApplication;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loggerApi")
public class Controller {

    public static final Logger logger = LogManager.getLogger(Controller.class);

    @GetMapping("/myLogger")
    public String getMessage(){
        logger.info("The information is successfully logged to the logger file");
        return "The Logger work fine";
    }
}
