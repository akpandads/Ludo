package com.akpanda.ludo.endpoints.inbound;

import com.akpanda.ludo.core.LudoCoreFunctionalities;
import com.akpanda.ludo.dto.PlayerNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class RestGameEndpoint {

    @PostMapping("akpanda/ludo/game/create")
    public void createGame(@RequestBody PlayerNames playerNames){

    }
}
