package com.sgzs.nba.card.game.delegate.match.memory.model;

import com.sgzs.nba.card.game.dto.MatchModel;
import lombok.Data;

/**
 * @author: jianyufeng
 * @date: 2021/11/8 23:29
 * @description: 内存存储比赛返回值
 */
@Data
public class MatchModelMemorySaveResponse {

    private MatchModelMemorySaveEnum matchModelMemorySaveEnum;

    private MatchModel matchModel;

    public boolean isSuccess(){
        return MatchModelMemorySaveEnum.SUCCESS.equals(matchModelMemorySaveEnum);
    }

    public static MatchModelMemorySaveResponse of(MatchModelMemorySaveEnum matchModelMemorySaveEnum){
        MatchModelMemorySaveResponse response = new MatchModelMemorySaveResponse();
        response.setMatchModelMemorySaveEnum(matchModelMemorySaveEnum);
        return response;
    }

    public static MatchModelMemorySaveResponse of(MatchModelMemorySaveEnum matchModelMemorySaveEnum, MatchModel matchModel){
        MatchModelMemorySaveResponse response = new MatchModelMemorySaveResponse();
        response.setMatchModelMemorySaveEnum(matchModelMemorySaveEnum);
        response.setMatchModel(matchModel);
        return response;
    }
}
