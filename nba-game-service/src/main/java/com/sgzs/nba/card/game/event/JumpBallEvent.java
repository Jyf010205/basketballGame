package com.sgzs.nba.card.game.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author: jianyufeng
 * @date: 2021/11/7 18:29
 * @description: 跳球事件
 */
public class JumpBallEvent extends ApplicationEvent {

    private final Long matchId;

    public JumpBallEvent(Object source,Long matchId) {
        super(source);
        this.matchId = matchId;
    }


    public Long getMatchId() {
        return matchId;
    }
}
