package com.zqh.config;

import com.alibaba.fastjson.JSONObject;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

/**
 * @author zhuangqinghui
 * @version 1.0
 * @date 2021/1/5 16:21
 */
public class PreciseModuloTableShardingAlgorithm implements PreciseShardingAlgorithm<Long> {
    private static final String ACTUAL_TARGET_TEMPLATE = "%s_%d";

    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Long> shardingValue) {
        System.out.println(JSONObject.toJSONString(availableTargetNames));
        System.out.println(JSONObject.toJSONString(shardingValue));
        return "course_1";
    }
}
