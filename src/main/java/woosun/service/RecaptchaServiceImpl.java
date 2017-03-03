package woosun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;

import woosun.component.HttpConnectionComponent;
import woosun.domain.RecaptchaAuthResponse;

@Service
public class RecaptchaServiceImpl implements RecaptchaService {
	
	@Value("${google.recaptcha.secret.key}")
	private String recaptchaSiteKey;
	
	@Value("${google.recaptcha.auth.url}")
	private String recaptchaAuthUrl;
	
	@Autowired
	private HttpConnectionComponent httpConnectionComponent;

	@Override
	public boolean isAuthRecaptcha(String recaptchaResponse) {
		
		if(StringUtils.isEmpty(recaptchaResponse)) return false;
		
		MultiValueMap<String,Object> params = new LinkedMultiValueMap<String,Object>();
		params.add("secret", recaptchaSiteKey);
		params.add("response", recaptchaResponse);
		
		RecaptchaAuthResponse recaptchaAuthResponse = 
		httpConnectionComponent.executePostHttp(recaptchaAuthUrl, params, RecaptchaAuthResponse.class);

		return recaptchaAuthResponse.isSuccess();
	}

}
