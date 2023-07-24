package com.anapedra.commerce.components;

import com.anapedra.commerce.entities.User;
import com.anapedra.commerce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenEnhencer implements TokenEnhancer {
    @Autowired
    UserRepository userRepository;
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {

        User user=userRepository.registrationEmail(oAuth2Authentication.getName());
        Map<String,Object> map=new HashMap<>();
        map.put("id",user.getId());
        map.put("name",user.getName());
        map.put("email",user.getRegistrationEmail());
        DefaultOAuth2AccessToken token= (DefaultOAuth2AccessToken) oAuth2AccessToken;
        token.setAdditionalInformation(map);
        return oAuth2AccessToken;
    }
}