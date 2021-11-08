package com.sgzs.nba.card.game.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author: jianyufeng
 * @date: 2021/11/7 23:42
 * @description:
 */
@Getter
@AllArgsConstructor
public enum HasBallEnum {
    HOME(1),
    AWAY(2),
    ;
    private Integer code;
}
