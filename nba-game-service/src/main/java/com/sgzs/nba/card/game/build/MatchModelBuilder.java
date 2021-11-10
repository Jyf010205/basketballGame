package com.sgzs.nba.card.game.build;

import cn.hutool.core.lang.Snowflake;
import com.sgzs.nba.card.game.dto.MatchModel;
import com.sgzs.nba.card.game.dto.Player;
import com.sgzs.nba.card.game.util.SpringContextHolder;

import java.time.LocalTime;
import java.util.HashMap;

/**
 * @author: jianyufeng
 * @date: 2021/11/7 23:03
 * @description: 比赛模型构建器
 */
public class MatchModelBuilder {

    public static MatchModel build(String homeTeam, String awayTeam, HashMap<Long, Player> homePlayers, HashMap<Long,Player> awayPlayers, Long[] onFieldHomePlayerIds, Long[] onFieldAwayPlayerIds){
        MatchModel matchModel = new MatchModel();
        Snowflake snowflake = SpringContextHolder.getBean("MatchCreateIdUtil");
        matchModel.setMatchId(snowflake.nextId());
        matchModel.setHomeTeam(homeTeam);
        matchModel.setAwayTeam(awayTeam);
        homePlayers.values().forEach(player -> {
            player.setMatchStatistics(MatchStatisticsBuilder.build());
        });
        awayPlayers.values().forEach(player -> {
            player.setMatchStatistics(MatchStatisticsBuilder.build());
        });
        matchModel.setHomePlayers(homePlayers);
        matchModel.setAwayPlayers(awayPlayers);
        matchModel.setOnFieldHomePlayerIds(onFieldHomePlayerIds);
        matchModel.setOnFieldAwayPlayerIds(onFieldAwayPlayerIds);
        matchModel.setHomeWatchStatistics(MatchStatisticsBuilder.build());
        matchModel.setAwayWatchStatistics(MatchStatisticsBuilder.build());
        matchModel.setQuarter(1);
        matchModel.setQuarterTimeRemaining(LocalTime.of(0,48));
        matchModel.setTwentyFourSecondsTimeRemaining(LocalTime.of(0,0,24));
        return matchModel;
    }
}
