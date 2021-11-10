package com.sgzsg.nba.card.test.gamestart;

import com.sgzs.nba.card.game.SpringbootApplication;
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
        for (int i = 0; i < 5; i++) {
            Player player = Player.builder()
                    .playerId((long) i)
                    .playerName("勒布朗.詹姆斯")
                    .playerNumber("23")
                    .playerHeight("2.03m")
                    .playerWeight("250磅")
                    .canPosition(Lists.newArrayList(i))
                    .playerPower(Player.PlayerPower.builder()
                            .attackFreeThrow(1)
                            .build())
                    .matchStatistics(new MatchStatistics()).build();
            homePlayers.put((long) i,player);
            onFieldHomePlayerIds[i] = (long)i;
        }
        for (int i = 0; i < 5; i++) {
            Player player = Player.builder()
                    .playerId((long) (i+5))
                    .playerName("勒布朗.詹姆斯")
                    .playerNumber("23")
                    .playerHeight("2.03m")
                    .playerWeight("250磅")
                    .canPosition(Lists.newArrayList(i))
                    .playerPower(Player.PlayerPower.builder()
                            .attackFreeThrow(1)
                            .build())
                    .matchStatistics(new MatchStatistics()).build();
            awayPlayers.put((long) (i+5),player);
            onFieldAwayPlayerIds[i] = (long)(i+5);
        }
        applicationEventPublisher.publishEvent(new GameStartEvent(this,"湖人队","勇士队",homePlayers,awayPlayers,onFieldHomePlayerIds,onFieldAwayPlayerIds));
    }
}
