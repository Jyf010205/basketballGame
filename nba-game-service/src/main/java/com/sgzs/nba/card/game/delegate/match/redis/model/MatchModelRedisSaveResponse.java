package com.sgzs.nba.card.game.delegate.match.redis.model;

import com.sgzs.nba.card.game.dto.MatchModel;
import lombok.Data;

/**
 * @author: jianyufeng
 * @date: 2021/11/8 23:29
 * @description: 内存存储比赛返回值
 */
@Data
public class MatchModelRedisSaveResponse {
    private MatchModelRedisSaveEnum matchModelRedisSaveEnum;

    private MatchModel matchModel;

    public boolean isSuccess(){
        return MatchModelRedisSaveEnum.SUCCESS.equals(matchModelRedisSaveEnum);
    }

    public static MatchModelRedisSaveResponse of(MatchModelRedisSaveEnum matchModelMemorySaveEnum){
        MatchModelRedisSaveResponse response = new MatchModelRedisSaveResponse();
        response.setMatchModelRedisSaveEnum(matchModelMemorySaveEnum);
        return response;
    }

    public static MatchModelRedisSaveResponse of(MatchModelRedisSaveEnum matchModelMemorySaveEnum, MatchModel matchModel){
        MatchModelRedisSaveResponse response = new MatchModelRedisSaveResponse();
        response.setMatchModelRedisSaveEnum(matchModelMemorySaveEnum);
        response.setMatchModel(matchModel);
        return response;
    }
}
