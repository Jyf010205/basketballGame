package com.sgzs.nba.card.game.service;

import com.sgzs.nba.card.game.delegate.match.memory.MatchModelMemorySaveService;
import com.sgzs.nba.card.game.delegate.match.memory.model.MatchModelMemorySaveResponse;
import com.sgzs.nba.card.game.delegate.match.redis.MatchModelRedisSaveService;
import com.sgzs.nba.card.game.delegate.match.redis.model.MatchModelRedisSaveResponse;
import com.sgzs.nba.card.game.dto.MatchModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: jianyufeng
 * @date: 2021/11/8 23:24
 * @description:
 */
@Slf4j
@Service
public class MatchModelSaveService {
    @Autowired
    private MatchModelRedisSaveService matchModelRedisSaveService;

    @Autowired
    private MatchModelMemorySaveService matchModelMemorySaveService;

    public void save(MatchModel matchModel){

        MatchModelRedisSaveResponse redisSaveResponse = matchModelRedisSaveService.save(matchModel);
        if (redisSaveResponse.isSuccess()){
            return;
        }

        // redis存储比赛失败，BackUp
        MatchModelMemorySaveResponse memorySaveResponse = matchModelMemorySaveService.save(matchModel);
        if (!memorySaveResponse.isSuccess()){
            log.error("matchId:{},比赛存储失败",matchModel.getMatchId());
        }

    }

    public MatchModel get(Long matchId){

        MatchModelRedisSaveResponse redisSaveResponse = matchModelRedisSaveService.get(matchId);
        if (redisSaveResponse.isSuccess()){
            return redisSaveResponse.getMatchModel();
        }

        MatchModelMemorySaveResponse memorySaveResponse = matchModelMemorySaveService.get(matchId);
        if (memorySaveResponse.isSuccess()){
            return redisSaveResponse.getMatchModel();
        }
        log.error("match:{},比赛不存在",matchId);
        return null;

    }

}
