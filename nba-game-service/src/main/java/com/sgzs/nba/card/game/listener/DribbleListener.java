package com.sgzs.nba.card.game.listener;

import com.sgzs.nba.card.game.dto.MatchModel;
import com.sgzs.nba.card.game.event.DribbleEvent;
import com.sgzs.nba.card.game.event.GameStartEvent;
import com.sgzs.nba.card.game.service.matchsave.MatchModelSaveService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DribbleListener implements ApplicationListener<DribbleEvent> {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;
    @Autowired
    private MatchModelSaveService matchModelSaveService;

    @Override
    public void onApplicationEvent(DribbleEvent dribbleEvent) {
        MatchModel matchModel = matchModelSaveService.get(dribbleEvent.getMatchId());

        System.out.println(1);
    }
}
