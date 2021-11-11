package com.sgzs.nba.card.game.dto;

import lombok.Data;
import lombok.ToString;

import java.time.LocalTime;
import java.util.HashMap;

/**
 * @author: jianyufeng
 * @date: 2021/11/7 20:54
 * @description: 比赛模型
 */
@Data
@ToString
public class MatchModel {

    /**
     * 比赛id号
     */
    private Long matchId;

    /**
     * 主场球队名称
     */
    private String homeTeam;

    /**
     * 客场球队名称
     */
    private String awayTeam;

    /**
     * 主场球员
     */
    private HashMap<Long,Player> homePlayers;

    /**
     * 客场球员
     */
    private HashMap<Long,Player> awayPlayers;

    /**
     * 在场上的主场球员Ids
     */
    private Long[] onFieldHomePlayerIds;

    /**
     * 在场上的客场球员Ids
     */
    private Long[] onFieldAwayPlayerIds;

    /**
     * 球权
     */
    private Integer hasBall;

    /**
     * 持球人Id
     */
    private Long hasBallPlayerId;

    /**
     * 主场数据统计
     */
    private MatchStatistics homeWatchStatistics;

    /**
     * 客场数据统计
     */
    private MatchStatistics awayWatchStatistics;

    /**
     * 节
     */
    private Integer quarter;

    /**
     * 节剩余时间
     */
    private LocalTime quarterTimeRemaining;

    /**
     * 24秒剩余时间
     */
    private LocalTime twentyFourSecondsTimeRemaining;
}
