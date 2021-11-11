package com.sgzs.nba.card.game.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

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

    private static final Map<Integer, HasBallEnum> MAP = new HashMap<>();

    static {
        for (HasBallEnum hasBallEnum : HasBallEnum.values()){
            MAP.put(hasBallEnum.code,hasBallEnum);
        }
    }

    public static HasBallEnum codeOf(Integer code){
        return MAP.get(code);
    }
}
