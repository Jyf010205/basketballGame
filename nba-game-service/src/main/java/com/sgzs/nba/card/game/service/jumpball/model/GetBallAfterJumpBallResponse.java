package com.sgzs.nba.card.game.service.jumpball.model;

import lombok.Data;

/**
 * @author: jianyufeng
 * @date: 2021/11/11 23:46
 * @description:
 */
@Data
public class GetBallAfterJumpBallResponse {

    /**
     * 持球人Id
     */
    private Long hasBallPlayerId;

    public static GetBallAfterJumpBallResponse of(Long hasBallPlayerId){
        GetBallAfterJumpBallResponse response = new GetBallAfterJumpBallResponse();
        response.setHasBallPlayerId(hasBallPlayerId);
        return response;
    }
}
