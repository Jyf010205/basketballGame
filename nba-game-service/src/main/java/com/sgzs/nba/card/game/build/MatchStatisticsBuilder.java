package com.sgzs.nba.card.game.build;

import com.sgzs.nba.card.game.dto.MatchStatistics;

/**
 * @author: jianyufeng
 * @date: 2021/11/7 23:34
 * @description: 数据统计构建器
 */
public class MatchStatisticsBuilder {

    public static MatchStatistics build(){

        MatchStatistics matchStatistics = new MatchStatistics();
        matchStatistics.setPoints(0);
        matchStatistics.setOffensiveRebounds(0);
        matchStatistics.setDefensiveRebounds(0);
        matchStatistics.setTotalRebounds(0);
        matchStatistics.setAssist(0);
        matchStatistics.setSteals(0);
        matchStatistics.setBlocks(0);
        matchStatistics.setPersonalFouls(0);
        matchStatistics.setTurnovers(0);
        matchStatistics.setFieldGoalAttempts(0);
        matchStatistics.setFieldGoals(0);
        matchStatistics.setFreeThrowGoals(0);
        matchStatistics.setThreePointFieldGoalAttempts(0);
        matchStatistics.setThreePointFieldGoals(0);
        matchStatistics.setFreeThrowGoalAttempts(0);
        matchStatistics.setFreeThrowGoals(0);
        matchStatistics.setPlusMinus(0);
        return matchStatistics;
    }

}
