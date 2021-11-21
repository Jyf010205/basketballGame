package com.sgzs.nba.card.game.dto;

import lombok.*;

import java.util.List;

/**
 * @author: jianyufeng
 * @date: 2021/11/7 19:15
 * @description: 运动员
 */
@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Player {

    /**
     * 球员id
     */
    private Long playerId;

    /**
     * 球员名称
     */
    private String playerName;

    /**
     * 场上位置
     */
    private Integer onFieldPosition;

    /**
     * 球员基础数据
     */
    private PlayerStaticData playerStaticData;

    /**
     * 球员能力
     */
    private PlayerPower playerPower;

    /**
     * 比赛数据
     */
    private MatchStatistics matchStatistics;


    @Data
    @ToString
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PlayerStaticData{

        /**
         * 球员号码
         */
        private String playerNumber;

        /**
         * 球员身高
         */
        private String playerHeight;

        /**
         * 球员体重
         */
        private String playerWeight;

        /**
         * 比赛可打位置
         */
        private List<Integer> canPosition;
    }

    @Data
    @ToString
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PlayerPower{

        /**
         * 球员体力
         */
        private int stamina;

        /**
         * 突破能力
         */
        private int attackDribbleBreak;

        /**
         * 两分球能力
         */
        private int attackTwoPoint;

        /**
         * 三分球能力
         */
        private int attackThreePoint;

        /**
         * 上篮能力
         */
        private int attackLayUp;

        /**
         * 罚球能力
         */
        private int attackFreeThrow;

        /**
         * 传球能力
         */
        private int attackPass;

        /**
         * 进攻篮板
         */
        private int attackOffensiveRebound;

        /**
         * 防守持球能力
         */
        private int defenceOnBall;

        /**
         * 抢断能力
         */
        private int defenceSteal;

        /**
         * 盖帽能力
         */
        private int defenceBlock;

        /**
         * 防守篮板能力
         */
        private int defenceDefensiveRebound;
    }

}
