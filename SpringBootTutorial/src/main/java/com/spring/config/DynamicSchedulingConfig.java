package com.spring.config;


import com.spring.request.UserRequest;
import com.spring.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.util.Date;

@EnableScheduling
@Configuration
public class DynamicSchedulingConfig {

    private Logger log = LoggerFactory.getLogger(DynamicSchedulingConfig.class);
    //    @Scheduled(cron = "${cron.expression}")
    private final HttpServletRequest request;

    private UserServiceImpl userService;

    public DynamicSchedulingConfig(HttpServletRequest request, UserServiceImpl userService) {
        this.request = request;
        this.userService = userService;
    }

    //@Scheduled(cron = "11 15 * * *")
    @Scheduled(cron = "*/10 10 10 * * ?")
    public void scheduleTaskUsingCronExpression() throws Exception {
        log.info("scheduleTaskUsingCronExpression" + new Date());
        String ip = InetAddress.getLocalHost().getHostAddress();
        log.info("Ip scheduling : " + ip);
        log.info("==========START doGetPostOffices================");
        userService.sheduling(new UserRequest(), request, true);
        log.info("==========STOP doGetPostOffices================{}");
    }
}
