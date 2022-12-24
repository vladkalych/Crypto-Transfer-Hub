package com.rebalcomb.api.message;

import com.rebalcomb.model.entity.Message;
import com.rebalcomb.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/messages")
public class MessageController {

    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping(value = "/inbox", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Message> inboxMessages() {
        return messageService.findAllByUsernameTo("vlad");
    }

    @GetMapping(value = "/sent", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Message> sentMessages() {
        return messageService.findAllByUsernameFrom("vlad");
    }

}
