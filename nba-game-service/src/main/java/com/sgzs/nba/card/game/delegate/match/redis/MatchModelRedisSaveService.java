package com.sgzs.nba.card.game.delegate.match.redis;

import com.sgzs.nba.card.game.delegate.match.redis.model.MatchModelRedisSaveEnum;
import com.sgzs.nba.card.game.delegate.match.redis.model.MatchModelRedisSaveResponse;
import com.sgzs.nba.card.game.dto.MatchModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author: jianyufeng
 * @date: 2021/11/8 23:46
 * @description:
 */
@Slf4j
@Service
public class MatchModelRedisSaveService {

    public MatchModelRedisSaveResponse get(Long matchId){
        return MatchModelRedisSaveResponse.of(MatchModelRedisSaveEnum.ERROR);
    }

    public MatchModelRedisSaveResponse save(MatchModel matchModel){
        return MatchModelRedisSaveResponse.of(MatchModelRedisSaveEnum.ERROR);
    }
}
