package woosun.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfiguration {

	@Bean
	public JedisConnectionFactory jedisConnectionFactory() {
		
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		jedisPoolConfig.setMaxTotal(8);
		jedisPoolConfig.setMaxIdle(8);
		jedisPoolConfig.setMinIdle(1);
		jedisPoolConfig.setMaxWaitMillis(1000);
		
	  
		JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
		jedisConnectionFactory.setHostName("127.0.0.1");
		jedisConnectionFactory.setPort(6379);
		jedisConnectionFactory.setTimeout(1000);
		jedisConnectionFactory.setUsePool(true);
		jedisConnectionFactory.setPoolConfig(jedisPoolConfig);
		
	  
	    return jedisConnectionFactory;
	 }

	@Bean("redisTemplate")
	public RedisTemplate<String,String> redisTemplate(JedisConnectionFactory jedisConnectionFactory) {
		
		RedisTemplate<String,String> redisTemplate = new RedisTemplate<String,String>();
		
		redisTemplate.setConnectionFactory(jedisConnectionFactory);
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setDefaultSerializer(new StringRedisSerializer());
		
		return redisTemplate;
	}
	
	

}
