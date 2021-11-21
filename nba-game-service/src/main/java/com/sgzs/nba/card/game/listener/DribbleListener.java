package com.sgzs.nba.card.game.listener;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.RandomUtil;
import com.sgzs.nba.card.game.constant.HasBallEnum;
import com.sgzs.nba.card.game.constant.MatchParam;
import com.sgzs.nba.card.game.dto.MatchModel;
import com.sgzs.nba.card.game.dto.Player;
import com.sgzs.nba.card.game.event.DribbleEvent;
import com.sgzs.nba.card.game.event.GameStartEvent;
import com.sgzs.nba.card.game.service.matchsave.MatchModelSaveService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.HashMap;

/**
 * @author: jianyufeng
 * @date: 2021/11/21 18:00
 * @description: 运球监听器
 */

@Slf4j
@Component
public class DribbleListener implements ApplicationListener<DribbleEvent> {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;
    @Autowired
    private MatchModelSaveService matchModelSaveService;

    @Override
    public void onApplicationEvent(DribbleEvent dribbleEvent) {
        MatchModel matchModel = matchModelSaveService.get(dribbleEvent.getMatchId());

        HasBallEnum hasBall = HasBallEnum.codeOf(matchModel.getHasBall());
        Long hasBallPlayerId = matchModel.getHasBallPlayerId();

        HashMap<Long, Player> homePlayers = matchModel.getHomePlayers();
        HashMap<Long, Player> awayPlayers = matchModel.getAwayPlayers();

        Long[] onFieldHomePlayerIds = matchModel.getOnFieldHomePlayerIds();
        Long[] onFieldAwayPlayerIds = matchModel.getOnFieldAwayPlayerIds();

        int timePass = RandomUtil.randomInt(1, MatchParam.MAX_TIME_PASS + 1);

        int getTwentyFourSecondsTimeRemainSeconds = matchModel.getTwentyFourSecondsTimeRemaining().getSecond();
        int quarterTimeRemainSeconds = matchModel.getQuarterTimeRemaining().getSecond();
        int quarterTimeRemainMinutes = matchModel.getQuarterTimeRemaining().getMinute();

        // 节时间分钟为0，快到24秒
        if ((quarterTimeRemainMinutes == 0 &&
                getTwentyFourSecondsTimeRemainSeconds - timePass <= 0) ||
                quarterTimeRemainSeconds - timePass <= 0){

            // 根据剩余时间决定是两分球/三分球
        }


        // 判断哪队持球
        if (HasBallEnum.HOME.equals(hasBall)){
            Player hasBallPlayer = homePlayers.get(hasBallPlayerId);
            Integer onFieldPosition = hasBallPlayer.getOnFieldPosition();

            Player defenceBallPlayer = awayPlayers.get(onFieldAwayPlayerIds[onFieldPosition]);


        }else if (HasBallEnum.AWAY.equals(hasBall)){
            Player hasBallPlayer = awayPlayers.get(hasBallPlayerId);
            Integer onFieldPosition = hasBallPlayer.getOnFieldPosition();

            Player defenceBallPlayer = awayPlayers.get(onFieldHomePlayerIds[onFieldPosition]);
        }
        System.out.println(1);
    }

    public static void main(String[] args) {
        LocalTime localTime = LocalTime.of(0, 0, 1);
        int second = localTime.getSecond();
        System.out.println((second - 5));
    }
}
