package com.sgzs.nba.card.game.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: jianyufeng
 * @date: 2021/11/7 22:41
 * @description:
 */
@Getter
@AllArgsConstructor
public enum PlayerPositionEnum {
    PG(0,"控球后卫"),
    SG(1,"得分后卫"),
    SF(2,"小前锋"),
    PF(3,"大前锋"),
    C(4,"中锋"),
    ;


    private Integer PositionId;

    private String positionName;

    private static final Map<Integer, PlayerPositionEnum> MAP = new HashMap<>();

    static {
        for (PlayerPositionEnum playerPositionEnum : PlayerPositionEnum.values()){
            MAP.put(playerPositionEnum.PositionId,playerPositionEnum);
        }
    }

    public static PlayerPositionEnum codeOf(Integer code){
        return MAP.get(code);
    }
}
