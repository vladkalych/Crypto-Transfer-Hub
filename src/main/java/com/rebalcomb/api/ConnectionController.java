package com.rebalcomb.api;

import com.rebalcomb.config.ServerUtil;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ConnectionController {

    @GetMapping("/connection")
    public boolean connection(){
        return ServerUtil.IS_CONNECTION;
    }

}
