package com.sgzs.nba.card.game.delegate.match.memory;

import com.sgzs.nba.card.game.delegate.match.memory.model.MatchModelMemorySaveEnum;
import com.sgzs.nba.card.game.delegate.match.memory.model.MatchModelMemorySaveResponse;
import com.sgzs.nba.card.game.dto.MatchModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: jianyufeng
 * @date: 2021/11/8 23:24
 * @description: 内存存储比赛业务层
 */
@Slf4j
@Service
public class MatchModelMemorySaveService {
    @Autowired
    private ConcurrentHashMap<Long, MatchModel> matchModelMemoryMap;

    public MatchModelMemorySaveResponse get(Long matchId){
        try {
            MatchModel matchModel = matchModelMemoryMap.get(matchId);
            if (Objects.isNull(matchModel)){
                return MatchModelMemorySaveResponse.of(MatchModelMemorySaveEnum.MATCH_NOT_EXIST);
            }
            return MatchModelMemorySaveResponse.of(MatchModelMemorySaveEnum.SUCCESS,matchModel);
        }catch (Exception e){
            log.info("内存取出比赛失败",e);
            return MatchModelMemorySaveResponse.of(MatchModelMemorySaveEnum.ERROR);
        }
    }

    public MatchModelMemorySaveResponse save(MatchModel matchModel){
        try {
            matchModelMemoryMap.put(matchModel.getMatchId(),matchModel);
            return MatchModelMemorySaveResponse.of(MatchModelMemorySaveEnum.SUCCESS,matchModel);
        }catch (Exception e){
            log.info("比赛存储内存失败",e);
            return MatchModelMemorySaveResponse.of(MatchModelMemorySaveEnum.ERROR);
        }
    }
}
