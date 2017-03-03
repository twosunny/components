package woosun.test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ZSetOperations.TypedTuple;
import org.springframework.test.context.junit4.SpringRunner;

import woosun.component.ObjectConvertComponent;
import woosun.repository.RedisRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
	
	@Autowired
	private RedisRepository redisRepository;
	
	@Autowired
	private ObjectConvertComponent objectConvertComponent;

	@Test
	public void test() {
		
		
		Set<TypedTuple<String>> rankSet = redisRepository.reverseRangeWithScores("user2", 0, 10);
		if(rankSet == null || rankSet.size() == 0){
			System.out.println("null!!!");
			return;
		}
		List<MemberRanking> rank = 
			rankSet.stream().map(value -> {
			MemberRanking r = new MemberRanking();
			r.setNickName(value.getValue());
			r.setTp(value.getScore().intValue());
			return r;
		}).collect(Collectors.toList());
		
		System.out.println(objectConvertComponent.objectToJson(rank));
		
		System.out.println(redisRepository.reverseRank("user200", "AAA"));
		//System.out.println(e.getScore()+","+e.getValue()
		//testList.forEach(tt -> System.out.println(tt));
		
		/*
		redisService.leftAddList("test5", userList);
		
		List<User> getList = redisService.getListAll("test5");
		for(User user : getList){
			System.out.println(user.getName());
		}
		getList.forEach(user -> System.out.println(user.getName()));
		*/
		//userList.get(arg0)
		//redisService.rightAddList("userList", (List<Object>)userList);
		
		//Object redisDatas = redisService.get("userList");
		//List<User> redisDatas = (List<User>)redisService.getValue("userList");
		
		/*
		redisDatas.forEach(
				user -> System.out.println(user.name)
				);
				*/
	}
	
	private class MemberRanking{
		
		private String nickName;
		private int tp;
		public String getNickName() {
			return nickName;
		}
		public void setNickName(String nickName) {
			this.nickName = nickName;
		}
		public int getTp() {
			return tp;
		}
		public void setTp(int tp) {
			this.tp = tp;
		}
		
		
	}
	

}
