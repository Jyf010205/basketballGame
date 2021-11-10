package com.sgzs.nba.card.game.listener;

import com.sgzs.nba.card.game.dto.MatchModel;
import com.sgzs.nba.card.game.event.JumpBallEvent;
import com.sgzs.nba.card.game.service.MatchModelSaveService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author: jianyufeng
 * @date: 2021/11/7 18:32
 * @description: 跳球监听器
 */
@Slf4j
@Component
public class JumpBallListener implements ApplicationListener<JumpBallEvent> {
    @Autowired
    private MatchModelSaveService matchModelSaveService;

    @Override
    public void onApplicationEvent(JumpBallEvent event) {
        MatchModel matchModel = matchModelSaveService.get(event.getMatchId());
        System.out.println(matchModel);
    }
}
