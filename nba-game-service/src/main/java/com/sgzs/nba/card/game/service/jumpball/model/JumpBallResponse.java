package com.sgzs.nba.card.game.service.jumpball.model;

import com.sgzs.nba.card.game.constant.HasBallEnum;
import lombok.Data;

import java.util.Objects;

/**
 * @author: jianyufeng
 * @date: 2021/11/11 23:33
 * @description:
 */
@Data
public class JumpBallResponse {

    /**
     * 球权
     */
    private Integer hasBall;

    public static JumpBallResponse of(Integer hasBall){
        JumpBallResponse response = new JumpBallResponse();

        if (Objects.isNull(hasBall)){
            response.setHasBall(HasBallEnum.HOME.getCode());
        }else {
            response.setHasBall(hasBall);
        }

        return response;
    }

}
