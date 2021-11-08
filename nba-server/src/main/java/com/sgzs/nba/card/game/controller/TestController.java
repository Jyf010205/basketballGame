package com.sgzs.nba.card.game.controller;

import com.sgzs.nba.card.game.build.MatchModelBuilder;
import com.sgzs.nba.card.game.dto.MatchModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: jianyufeng
 * @date: 2021/11/7 17:50
 * @description:
 */
@Slf4j
@RestController
public class TestController {

    @GetMapping("/test")
    public String test(){
        return "hello nba";
    }

    @GetMapping("/startGame")
    public void startGame(){
        MatchModel build = MatchModelBuilder.build("1", "2", null, null, null, null);
        System.out.println(1);
    }

}
