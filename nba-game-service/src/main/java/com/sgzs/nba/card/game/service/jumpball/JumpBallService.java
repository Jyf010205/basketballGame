package com.sgzs.nba.card.game.service.jumpball;

import cn.hutool.core.util.RandomUtil;
import com.sgzs.nba.card.game.constant.HasBallEnum;
import com.sgzs.nba.card.game.dto.Player;
import com.sgzs.nba.card.game.service.jumpball.model.JumpBallResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author: jianyufeng
 * @date: 2021/11/11 23:31
 * @description: 跳球业务层
 */
@Slf4j
@Service
public class JumpBallService {
    public JumpBallResponse jumpBall(Player homePlayer,Player awayPlayer){

        int homePlayerBlock = homePlayer.getPlayerPower().getDefenceBlock();
        int awayPlayerBlock = awayPlayer.getPlayerPower().getDefenceBlock();

        if (homePlayerBlock == awayPlayerBlock){
            double randomDouble = RandomUtil.randomDouble(-1.0, 1.0);

            return JumpBallResponse.of(randomDouble > 0 ? HasBallEnum.HOME.getCode() : HasBallEnum.AWAY.getCode());
            // 后场篮板能力决定跳球球权
        }else {
            return JumpBallResponse.of(homePlayerBlock > awayPlayerBlock ? HasBallEnum.HOME.getCode() : HasBallEnum.AWAY.getCode());
        }
    }
}
