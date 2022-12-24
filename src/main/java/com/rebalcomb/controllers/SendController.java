package com.rebalcomb.controllers;

import com.rebalcomb.config.ServerUtil;
import com.rebalcomb.controllers.utils.Util;
import com.rebalcomb.mapper.MessageRequestMapper;
import com.rebalcomb.model.dto.MessageRequest;
import com.rebalcomb.model.entity.Message;
import com.rebalcomb.model.entity.enums.TypeLog;
import com.rebalcomb.service.LogService;
import com.rebalcomb.service.MessageService;
import com.rebalcomb.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Controller
public class SendController {
    private final Logger logger = LoggerFactory.getLogger(SendController.class);
    private final MessageService messageService;
    private final UserService userService;
    private final LogService logService;

    private final Util util;

    public static String INFO;

    @Autowired
    public SendController(MessageService messageService, UserService userService, LogService logService, Util util) {
        this.messageService = messageService;
        this.userService = userService;
        this.logService = logService;
        this.util = util;
    }

//    @PostMapping("/sendNewMessage")
//    public ModelAndView login(ModelAndView model, @Valid @ModelAttribute MessageRequest messageRequest, Principal principal) throws InterruptedException, IOException, ExecutionException, NoSuchAlgorithmException {
//        List<String> usernameList = userService.findAllUsername();
//        if(!usernameList.contains(messageRequest.getUser_to())){
//            model.addObject("error", "Address not found!");
//            model.addObject("isSend", false);
//            model.addObject("headPageValue", "write");
//            model.addObject("isAdmin", util.isAdmin(principal));
//            model.addObject("messageRequest", new MessageRequest());
//            model.setViewName("headPage");
//            return model;
//        }
//
//        if(messageRequest.getUser_to().equals(principal.getName())){
//            model.addObject("isSend", false);
//            model.addObject("headPageValue", "write");
//            model.addObject("isAdmin", util.isAdmin(principal));
//            model.addObject("messageRequest", new MessageRequest());
//            model.setViewName("headPage");
//            return model;
//        }
//        MessageRequest messageRequestNew = MessageRequestMapper.mapMessageRequest(messageRequest, principal.getName());
//        if(messageService.sendMessage(messageRequestNew)){
//            model.addObject("isSend", true);
//            model.addObject("messages", messageService.findAllBySender(principal.getName()));
//            model.addObject("headPageValue", "outcoming");
//            model.addObject("isAdmin", util.isAdmin(principal));
//            model.setViewName("headPage");
//            logger.info("Message sent successfully!");
//            logService.create(TypeLog.MESSAGE, "To: '" + messageRequest.getUser_to()+ "' | From: '" + messageRequest.getUser_from() + "' | Title: '" + messageRequest.getTitle() + "'");
//            return model;
//        }else{
//            model.addObject("isSend", false);
//            model.addObject("headPageValue", "write");
//            model.addObject("messageRequest", new MessageRequest());
//            model.addObject("isAdmin", util.isAdmin(principal));
//            model.setViewName("headPage");
//            return model;
//        }
//    }
}
