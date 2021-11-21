package com.sgzsg.nba.card.test.gamestart;

import com.sgzs.nba.card.game.SpringbootApplication;
import com.sgzs.nba.card.game.constant.PlayerPositionEnum;
import com.sgzs.nba.card.game.dto.MatchStatistics;
import com.sgzs.nba.card.game.dto.Player;
import com.sgzs.nba.card.game.event.GameStartEvent;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

/**
 * @author: jianyufeng
 * @date: 2021/11/10 22:51
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GameStartTest {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Test
    public void startGame(){
        HashMap<Long,Player> homePlayers = new HashMap<>();
        HashMap<Long,Player> awayPlayers = new HashMap<>();
        Long[] onFieldHomePlayerIds = new Long[5];
        Long[] onFieldAwayPlayerIds = new Long[5];

        Player player1 = Player.builder()
                .playerId(1L)
                .playerName("拉塞尔-韦斯特布鲁克")
                .playerStaticData(Player.PlayerStaticData.builder()
                        .playerNumber("0")
                        .playerHeight("191cm")
                        .playerWeight("90kg")
                        .canPosition(Lists.newArrayList(PlayerPositionEnum.PG.getPositionId()))
                        .build())
                .playerPower(Player.PlayerPower.builder().build())
                .matchStatistics(new MatchStatistics())
                .build();

        Player player2 = Player.builder()
                .playerId(2L)
                .playerName("霍顿-塔克")
                .playerStaticData(Player.PlayerStaticData.builder()
                        .playerNumber("5")
                        .playerHeight("193cm")
                        .playerWeight("105kg")
                        .canPosition(Lists.newArrayList(PlayerPositionEnum.SG.getPositionId(),PlayerPositionEnum.SF.getPositionId()))
                        .build())
                .playerPower(Player.PlayerPower.builder().build())
                .matchStatistics(new MatchStatistics())
                .build();

        Player player3 = Player.builder()
                .playerId(3L)
                .playerName("卡梅隆-安东尼")
                .playerStaticData(Player.PlayerStaticData.builder()
                        .playerNumber("7")
                        .playerHeight("201cm")
                        .playerWeight("107kg")
                        .canPosition(Lists.newArrayList(PlayerPositionEnum.SF.getPositionId(),PlayerPositionEnum.PF.getPositionId()))
                        .build())
                .playerPower(Player.PlayerPower.builder().build())
                .matchStatistics(new MatchStatistics())
                .build();

        Player player4 = Player.builder()
                .playerId(4L)
                .playerName("勒布朗-詹姆斯")
                .playerStaticData(Player.PlayerStaticData.builder()
                        .playerNumber("6")
                        .playerHeight("203cm")
                        .playerWeight("113kg")
                        .canPosition(Lists.newArrayList(PlayerPositionEnum.PG.getPositionId(),PlayerPositionEnum.SF.getPositionId(),PlayerPositionEnum.PF.getPositionId()))
                        .build())
                .playerPower(Player.PlayerPower.builder().build())
                .matchStatistics(new MatchStatistics())
                .build();

        Player player5 = Player.builder()
                .playerId(5L)
                .playerName("安东尼-戴维斯")
                .playerStaticData(Player.PlayerStaticData.builder()
                        .playerNumber("3")
                        .playerHeight("208cm")
                        .playerWeight("114kg")
                        .canPosition(Lists.newArrayList(PlayerPositionEnum.PF.getPositionId(),PlayerPositionEnum.C.getPositionId()))
                        .build())
                .playerPower(Player.PlayerPower.builder().build())
                .matchStatistics(new MatchStatistics())
                .build();

        homePlayers.put(player1.getPlayerId(),player1);
        homePlayers.put(player2.getPlayerId(),player2);
        homePlayers.put(player3.getPlayerId(),player3);
        homePlayers.put(player4.getPlayerId(),player4);
        homePlayers.put(player5.getPlayerId(),player5);

        onFieldHomePlayerIds[0] = player1.getPlayerId();
        onFieldHomePlayerIds[1] = player2.getPlayerId();
        onFieldHomePlayerIds[2] = player3.getPlayerId();
        onFieldHomePlayerIds[3] = player4.getPlayerId();
        onFieldHomePlayerIds[4] = player5.getPlayerId();

        Player player6 = Player.builder()
                .playerId(6L)
                .playerName("斯蒂芬-库里")
                .playerStaticData(Player.PlayerStaticData.builder()
                        .playerNumber("30")
                        .playerHeight("191cm")
                        .playerWeight("87kg")
                        .canPosition(Lists.newArrayList(PlayerPositionEnum.PG.getPositionId(),PlayerPositionEnum.SG.getPositionId()))
                        .build())
                .playerPower(Player.PlayerPower.builder().build())
                .matchStatistics(new MatchStatistics())
                .build();

        Player player7 = Player.builder()
                .playerId(7L)
                .playerName("克莱-汤普森")
                .playerStaticData(Player.PlayerStaticData.builder()
                        .playerNumber("11")
                        .playerHeight("198cm")
                        .playerWeight("97kg")
                        .canPosition(Lists.newArrayList(PlayerPositionEnum.SG.getPositionId(),PlayerPositionEnum.SF.getPositionId()))
                        .build())
                .playerPower(Player.PlayerPower.builder().build())
                .matchStatistics(new MatchStatistics())
                .build();

        Player player8 = Player.builder()
                .playerId(8L)
                .playerName("安德鲁-维金斯")
                .playerStaticData(Player.PlayerStaticData.builder()
                        .playerNumber("22")
                        .playerHeight("201cm")
                        .playerWeight("92kg")
                        .canPosition(Lists.newArrayList(PlayerPositionEnum.SG.getPositionId(),PlayerPositionEnum.SF.getPositionId()))
                        .build())
                .playerPower(Player.PlayerPower.builder().build())
                .matchStatistics(new MatchStatistics())
                .build();

        Player player9 = Player.builder()
                .playerId(9L)
                .playerName("德雷蒙德-格林")
                .playerStaticData(Player.PlayerStaticData.builder()
                        .playerNumber("23")
                        .playerHeight("198cm")
                        .playerWeight("106kg")
                        .canPosition(Lists.newArrayList(PlayerPositionEnum.PF.getPositionId(),PlayerPositionEnum.C.getPositionId()))
                        .build())
                .playerPower(Player.PlayerPower.builder().build())
                .matchStatistics(new MatchStatistics())
                .build();

        Player player10 = Player.builder()
                .playerId(10L)
                .playerName("凯文-鲁尼")
                .playerStaticData(Player.PlayerStaticData.builder()
                        .playerNumber("5")
                        .playerHeight("206cm")
                        .playerWeight("113kg")
                        .canPosition(Lists.newArrayList(PlayerPositionEnum.C.getPositionId()))
                        .build())
                .playerPower(Player.PlayerPower.builder().build())
                .matchStatistics(new MatchStatistics())
                .build();

        awayPlayers.put(player6.getPlayerId(),player6);
        awayPlayers.put(player7.getPlayerId(),player7);
        awayPlayers.put(player8.getPlayerId(),player8);
        awayPlayers.put(player9.getPlayerId(),player9);
        awayPlayers.put(player10.getPlayerId(),player10);

        onFieldAwayPlayerIds[0] = player6.getPlayerId();
        onFieldAwayPlayerIds[1] = player7.getPlayerId();
        onFieldAwayPlayerIds[2] = player8.getPlayerId();
        onFieldAwayPlayerIds[3] = player9.getPlayerId();
        onFieldAwayPlayerIds[4] = player10.getPlayerId();

        applicationEventPublisher.publishEvent(new GameStartEvent(this,"湖人队","勇士队",homePlayers,awayPlayers,onFieldHomePlayerIds,onFieldAwayPlayerIds));
    }
}
