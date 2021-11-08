package com.sgzs.nba.card.game.dto;

import lombok.Data;
import lombok.ToString;

import java.time.LocalTime;

/**
 * @author: jianyufeng
 * @date: 2021/11/7 20:17
 * @description: 数据统计
 */
@Data
@ToString
public class MatchStatistics {

    /**
     * 上场时间
     */
    private LocalTime minutesPlayed;

    /**
     * 得分
     */
    private Integer points;

    /**
     * 进攻篮板
     */
    private Integer offensiveRebounds;

    /**
     * 防守篮板
     */
    private Integer defensiveRebounds;

    /**
     * 总篮板
     */
    private Integer totalRebounds;

    /**
     * 助攻
     */
    private Integer assist;

    /**
     * 抢断
     */
    private Integer steals;

    /**
     * 盖帽
     */
    private Integer blocks;

    /**
     * 失误
     */
    private Integer personalFouls;

    /**
     * 失误
     */
    private Integer turnovers;

    /**
     * 投篮出手次数
     */
    private Integer fieldGoalAttempts;

    /**
     * 投篮命中次数
     */
    private Integer fieldGoals;

    /**
     * 三分出手次数
     */
    private Integer threePointFieldGoalAttempts;

    /**
     * 三分命中次数
     */
    private Integer threePointFieldGoals;

    /**
     * 罚球出手次数
     */
    private Integer freeThrowGoalAttempts;

    /**
     * 罚球命中次数
     */
    private Integer freeThrowGoals;

    /**
     * 正负值
     */
    private Integer plusMinus;

}
