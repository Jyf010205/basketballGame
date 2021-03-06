package com.sgzs.nba.card.game.listener;

import com.sgzs.nba.card.game.build.MatchModelBuilder;
import com.sgzs.nba.card.game.constant.PlayerPositionEnum;
import com.sgzs.nba.card.game.dto.MatchModel;
import com.sgzs.nba.card.game.dto.Player;
import com.sgzs.nba.card.game.event.GameStartEvent;
import com.sgzs.nba.card.game.event.JumpBallEvent;
import com.sgzs.nba.card.game.service.matchsave.MatchModelSaveService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

/**
 * @author: jianyufeng
 * @date: 2021/11/7 21:49
 * @description: 比赛启动监听器
 */

@Slf4j
@Component
public class GameStartListener implements ApplicationListener<GameStartEvent> {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    private MatchModelSaveService matchModelSaveService;

    @Override
    public void onApplicationEvent(GameStartEvent event) {
        String homeTeam = event.getHomeTeam();
        String awayTeam = event.getAwayTeam();

        if (StringUtils.isEmpty(homeTeam) && StringUtils.isEmpty(awayTeam)){
            log.error("主客场球队名称为空");
            return;
        }
        HashMap<Long, Player> homePlayers = event.getHomePlayers();
        HashMap<Long, Player> awayPlayers = event.getAwayPlayers();

        if (Objects.isNull(homePlayers) || Objects.isNull(awayPlayers) || homePlayers.keySet().size() < 5 || awayPlayers.keySet().size() < 5){
            log.error("主客场球队人数不足5人,主场球队人数:{},客场球队人数:{}",homePlayers,awayPlayers);
            return;
        }

        Long[] onFieldHomePlayerIds = event.getOnFieldHomePlayerIds();
        Long[] onFieldAwayPlayerIds = event.getOnFieldAwayPlayerIds();

        if (Objects.isNull(onFieldHomePlayerIds) || Objects.isNull(onFieldAwayPlayerIds) || onFieldHomePlayerIds.length != 5 || onFieldAwayPlayerIds.length != 5){
            log.error("首发球员不是5人,HomePlayerIds:{},AwayPlayerIds:{}",onFieldHomePlayerIds,onFieldAwayPlayerIds);
            return;
        }

        if(!homePlayers.keySet().containsAll(Arrays.asList(onFieldHomePlayerIds)) ||
                !awayPlayers.keySet().containsAll(Arrays.asList(onFieldAwayPlayerIds))){
            log.error("首发球员Id球队中不存在");
            return;
        }

        if (!homePlayers.get(onFieldHomePlayerIds[0]).getPlayerStaticData().getCanPosition().contains(PlayerPositionEnum.PG.getPositionId()) &&
                !awayPlayers.get(onFieldAwayPlayerIds[0]).getPlayerStaticData().getCanPosition().contains(PlayerPositionEnum.PG.getPositionId())){
            log.error("首发控卫球员可打位置中没有控卫,homePlayer:{},awayPlayer:{}",homePlayers.get(onFieldHomePlayerIds[0]),awayPlayers.get(onFieldAwayPlayerIds[0]));
            return;
        }

        if (!homePlayers.get(onFieldHomePlayerIds[1]).getPlayerStaticData().getCanPosition().contains(PlayerPositionEnum.SG.getPositionId()) &&
                !awayPlayers.get(onFieldAwayPlayerIds[1]).getPlayerStaticData().getCanPosition().contains(PlayerPositionEnum.SG.getPositionId())){
            log.error("首发得分后卫球员可打位置中没有得分后卫,homePlayer:{},awayPlayer:{}",homePlayers.get(onFieldHomePlayerIds[1]),awayPlayers.get(onFieldAwayPlayerIds[1]));
            return;
        }

        if (!homePlayers.get(onFieldHomePlayerIds[2]).getPlayerStaticData().getCanPosition().contains(PlayerPositionEnum.SF.getPositionId()) &&
                !awayPlayers.get(onFieldAwayPlayerIds[2]).getPlayerStaticData().getCanPosition().contains(PlayerPositionEnum.SF.getPositionId())){
            log.error("首发小前锋球员可打位置中没有小前锋,homePlayer:{},awayPlayer:{}",homePlayers.get(onFieldHomePlayerIds[2]),awayPlayers.get(onFieldAwayPlayerIds[2]));
            return;
        }

        if (!homePlayers.get(onFieldHomePlayerIds[3]).getPlayerStaticData().getCanPosition().contains(PlayerPositionEnum.PF.getPositionId()) &&
                !awayPlayers.get(onFieldAwayPlayerIds[3]).getPlayerStaticData().getCanPosition().contains(PlayerPositionEnum.PF.getPositionId())){
            log.error("首发大前锋球员可打位置中没有大前锋,homePlayer:{},awayPlayer:{}",homePlayers.get(onFieldHomePlayerIds[3]),awayPlayers.get(onFieldAwayPlayerIds[3]));
            return;
        }

        if (!homePlayers.get(onFieldHomePlayerIds[4]).getPlayerStaticData().getCanPosition().contains(PlayerPositionEnum.C.getPositionId()) &&
                !awayPlayers.get(onFieldAwayPlayerIds[4]).getPlayerStaticData().getCanPosition().contains(PlayerPositionEnum.C.getPositionId())){
            log.error("首发中锋球员可打位置中没有中锋,homePlayer:{},awayPlayer:{}",homePlayers.get(onFieldHomePlayerIds[4]),awayPlayers.get(onFieldAwayPlayerIds[4]));
            return;
        }
        MatchModel matchModel = MatchModelBuilder.build(homeTeam, awayTeam, homePlayers, awayPlayers, onFieldHomePlayerIds, onFieldAwayPlayerIds);

        // 存放比赛模型
        matchModelSaveService.save(matchModel);

        log.info("matchId:{} 比赛准备就绪,开始!",matchModel.getMatchId());
        // 开始跳球事件
        applicationEventPublisher.publishEvent(new JumpBallEvent(this,matchModel.getMatchId()));
    }
}
