package com.sgzs.nba.card.game.config;

import com.sgzs.nba.card.game.dto.MatchModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: jianyufeng
 * @date: 2021/11/8 23:15
 * @description:
 */
@Configuration
public class MatchSaveMapConfig {

    @Bean(name = "MatchModelMemoryMap")
    public ConcurrentHashMap<Long, MatchModel> create(){
        return new ConcurrentHashMap<>();
    }

}
