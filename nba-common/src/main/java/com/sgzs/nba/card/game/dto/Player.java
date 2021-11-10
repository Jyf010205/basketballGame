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
    public static class PlayerPower{

        /**
         * 球员体力
         */
        private Integer stamina;

        /**
         * 两分球能力
         */
        private Integer attackTwoPoint;

        /**
         * 三分球能力
         */
        private Integer attackThreePoint;

        /**
         * 上篮能力
         */
        private Integer attackLayUp;

        /**
         * 罚球能力
         */
        private Integer attackFreeThrow;

        /**
         * 传球能力
         */
        private Integer attackPass;

        /**
         * 进攻篮板
         */
        private Integer attackOffensiveRebound;

        /**
         * 投篮干扰能力
         */
        private Integer defenceOnBall;

        /**
         * 抢断能力
         */
        private Integer defenceSteal;

        /**
         * 盖帽能力
         */
        private Integer defenceBlock;

        /**
         * 防守篮板能力
         */
        private Integer defenceDefensiveRebound;
    }

}
