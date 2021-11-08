package com.sgzs.nba.card.game.config;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.sgzs.nba.card.game.constant.SnowflakeCreateEnum;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: jianyufeng
 * @date: 2021/11/7 23:07
 * @description:
 */
@Configuration
public class SnowflakeUtilConfig {

    @Bean(name = "MatchCreateIdUtil")
    public Snowflake create(){
        return IdUtil.createSnowflake(1, SnowflakeCreateEnum.MatchCreateId.getSnowflakeDataCenterId());
    }
}
