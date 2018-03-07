package com.ztkj.core.redis;

import redis.clients.jedis.ShardedJedis;

/**
 * Created by Zero on 2016/7/4.
 */
public interface RedisDataSource {

    public abstract ShardedJedis getRedisClient();
    public void returnResource(ShardedJedis shardedJedis);
    public void returnResource(ShardedJedis shardedJedis, boolean broken);

}
