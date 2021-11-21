package com.sgzs.nba.card.game.listener;

import com.sgzs.nba.card.game.constant.HasBallEnum;
import com.sgzs.nba.card.game.constant.PlayerPositionEnum;
import com.sgzs.nba.card.game.dto.MatchModel;
import com.sgzs.nba.card.game.dto.Player;
import com.sgzs.nba.card.game.event.DribbleEvent;
import com.sgzs.nba.card.game.event.JumpBallEvent;
import com.sgzs.nba.card.game.service.jumpball.GetBallAfterJumpBallService;
import com.sgzs.nba.card.game.service.jumpball.JumpBallService;
import com.sgzs.nba.card.game.service.jumpball.model.GetBallAfterJumpBallResponse;
import com.sgzs.nba.card.game.service.jumpball.model.JumpBallResponse;
import com.sgzs.nba.card.game.service.matchsave.MatchModelSaveService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author: jianyufeng
 * @date: 2021/11/7 18:32
 * @description: 跳球监听器
 */
@Slf4j
@Component
public class JumpBallListener implements ApplicationListener<JumpBallEvent> {
    @Autowired
    private MatchModelSaveService matchModelSaveService;
    @Autowired
    private JumpBallService jumpBallService;
    @Autowired
    private GetBallAfterJumpBallService getBallAfterJumpBallService;
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void onApplicationEvent(JumpBallEvent event) {
        MatchModel matchModel = matchModelSaveService.get(event.getMatchId());

        // 两队两名中锋跳球
        Player homePlayer = matchModel.getHomePlayers().get(matchModel.getOnFieldHomePlayerIds()[PlayerPositionEnum.C.getPositionId()]);
        Player awayPlayer = matchModel.getAwayPlayers().get(matchModel.getOnFieldAwayPlayerIds()[PlayerPositionEnum.C.getPositionId()]);

        // 判断谁跳球胜利
        JumpBallResponse jumpBallResponse = jumpBallService.jumpBall(homePlayer, awayPlayer);
        log.info("{}队获得球权", HasBallEnum.codeOf(jumpBallResponse.getHasBall()));

        GetBallAfterJumpBallResponse getBallAfterJumpBallResponse;
        Long hasBallPlayerId = null;

        // 判断队内谁控球
        if (HasBallEnum.HOME.getCode().equals(jumpBallResponse.getHasBall())) {
            getBallAfterJumpBallResponse = getBallAfterJumpBallService.getBallAfterJumpBall(matchModel.getHomePlayers(), matchModel.getOnFieldHomePlayerIds());
            hasBallPlayerId = getBallAfterJumpBallResponse.getHasBallPlayerId();

            // 如果持球者的id不在场上 控球者为控卫
            if (!Arrays.asList(matchModel.getOnFieldHomePlayerIds()).contains(hasBallPlayerId)) {
                hasBallPlayerId = matchModel.getOnFieldHomePlayerIds()[PlayerPositionEnum.PG.getPositionId()];
            }
        } else if (HasBallEnum.AWAY.getCode().equals(jumpBallResponse.getHasBall())) {
            getBallAfterJumpBallResponse = getBallAfterJumpBallService.getBallAfterJumpBall(matchModel.getAwayPlayers(), matchModel.getOnFieldAwayPlayerIds());
            hasBallPlayerId = getBallAfterJumpBallResponse.getHasBallPlayerId();

            if (!Arrays.asList(matchModel.getOnFieldAwayPlayerIds()).contains(hasBallPlayerId)) {
                hasBallPlayerId = matchModel.getOnFieldAwayPlayerIds()[PlayerPositionEnum.PG.getPositionId()];
            }
        }

        // 球权，持球人Id放入比赛模型
        matchModel.setHasBall(jumpBallResponse.getHasBall());
        matchModel.setHasBallPlayerId(hasBallPlayerId);

        matchModelSaveService.save(matchModel);

        applicationEventPublisher.publishEvent(new DribbleEvent(this, matchModel.getMatchId()));
    }
}
