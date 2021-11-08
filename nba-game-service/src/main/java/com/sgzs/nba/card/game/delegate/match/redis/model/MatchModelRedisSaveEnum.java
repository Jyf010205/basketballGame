package com.sgzs.nba.card.game.delegate.match.redis.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author: jianyufeng
 * @date: 2021/11/8 23:31
 * @description: 存储比赛枚举
 */
@Getter
@AllArgsConstructor
public enum MatchModelRedisSaveEnum {
    SUCCESS(0,"成功"),
    MATCH_NOT_EXIST(10000,"比赛不存在"),
    ERROR(999999,"失败"),
    ;

    private Integer code;

    private String msg;
}
