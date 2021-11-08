package com.sgzs.nba.card.game.listener;

import com.sgzs.nba.card.game.event.JumpBallEvent;
import lombok.extern.slf4j.Slf4j;
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

    @Override
    public void onApplicationEvent(JumpBallEvent event) {
        System.out.println(event.getMatchId());
    }
}
