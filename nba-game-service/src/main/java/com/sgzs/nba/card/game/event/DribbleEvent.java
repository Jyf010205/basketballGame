package com.sgzs.nba.card.game.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author: jianyufeng
 * @date: 2021/11/12 0:04
 * @description: 运球事件
 */
public class DribbleEvent extends ApplicationEvent {

    private final Long matchId;

    public DribbleEvent(Object source,Long matchId) {
        super(source);
        this.matchId = matchId;
    }


    public Long getMatchId() {
        return matchId;
    }
}
