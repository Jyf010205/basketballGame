package com.sgzs.nba.card.game.service.jumpball;

import com.sgzs.nba.card.game.constant.PlayerPositionEnum;
import com.sgzs.nba.card.game.dto.Player;
import com.sgzs.nba.card.game.service.jumpball.model.GetBallAfterJumpBallResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @author: jianyufeng
 * @date: 2021/11/11 23:44
 * @description: 跳球之后谁获取球权
 */
@Slf4j
@Service
public class GetBallAfterJumpBallService {

    public GetBallAfterJumpBallResponse getBallAfterJumpBall(HashMap<Long, Player> players,Long[] onFieldPlayerIds){
        // 由控卫控制球
        return GetBallAfterJumpBallResponse.of(onFieldPlayerIds[PlayerPositionEnum.PG.getPositionId()]);
    }

}
