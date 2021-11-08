package com.sgzs.nba.card.game.event;

import com.sgzs.nba.card.game.dto.Player;
import org.springframework.context.ApplicationEvent;

import java.util.HashMap;

/**
 * @author: jianyufeng
 * @date: 2021/11/7 21:45
 * @description:
 */
public class GameStartEvent extends ApplicationEvent {

    private final String homeTeam;

    private final String awayTeam;

    private final HashMap<Long,Player> homePlayers;

    private final HashMap<Long,Player> awayPlayers;

    /**
     * 从0到4 代表 PG,SG,SF,PF,C
     */
    private final Long[] onFieldHomePlayerIds;

    private final Long[] onFieldAwayPlayerIds;

    public GameStartEvent(Object source,String homeTeam,String awayTeam,HashMap<Long,Player> homePlayers,HashMap<Long,Player> awayPlayers,Long[] onFieldHomePlayerIds,Long[] onFieldAwayPlayerIds) {
        super(source);
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homePlayers = homePlayers;
        this.awayPlayers = awayPlayers;
        this.onFieldHomePlayerIds = onFieldHomePlayerIds;
        this.onFieldAwayPlayerIds = onFieldAwayPlayerIds;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public HashMap<Long,Player> getHomePlayers() {
        return homePlayers;
    }

    public HashMap<Long,Player> getAwayPlayers() {
        return awayPlayers;
    }

    public Long[] getOnFieldHomePlayerIds() {
        return onFieldHomePlayerIds;
    }

    public Long[] getOnFieldAwayPlayerIds() {
        return onFieldAwayPlayerIds;
    }
}
