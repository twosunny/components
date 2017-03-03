package woosun.repository;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.data.redis.core.ZSetOperations.TypedTuple;
import org.springframework.stereotype.Repository;

@Repository
public class RedisRepository {
	
	//ZSet Operation
	@Resource(name="redisTemplate")
	private ZSetOperations<String, String> zsetOps;
	
	public Set<TypedTuple<String>> reverseRangeWithScores(String key, long start, long end){
		
		return zsetOps.reverseRangeWithScores(key, start, end);
		
	}
	
	public long reverseRank(String key, String obj){
		
		Long rank = zsetOps.reverseRank(key, obj);
		if(rank == null) return -1;
		
		return rank.longValue();
	}

}
