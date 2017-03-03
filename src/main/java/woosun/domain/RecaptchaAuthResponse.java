package woosun.domain;

import java.util.Date;

public class RecaptchaAuthResponse {
	
	private boolean success;
	private Date challengeTs;
	private String hostname;
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public Date getChallengeTs() {
		return challengeTs;
	}
	public void setChallengeTs(Date challengeTs) {
		this.challengeTs = challengeTs;
	}
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	
	
}
