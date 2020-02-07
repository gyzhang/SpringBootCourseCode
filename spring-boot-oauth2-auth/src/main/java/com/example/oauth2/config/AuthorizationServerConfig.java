package com.example.oauth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import com.example.oauth2.service.UserDetailService;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserDetailService userDetailService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	TokenStore tokenStore;

	// 使用 jwt
	@Bean
	public TokenStore tokenStore() {
		return new JwtTokenStore(jwtTokenEnhancer());
	}

	// 配置 jwt 生成 策略
	@Bean
	public JwtAccessTokenConverter jwtTokenEnhancer() {
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		converter.setSigningKey("123456"); // 密钥
		return converter;
	}

	// 配置客户端信息
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory().withClient("client_123456")// 这里直接把配置信息保存在内存中
				.secret(passwordEncoder.encode("secret_123456"))// 这里必须使用加密
				.authorizedGrantTypes("authorization_code", "refresh_token", "password", "implicit").scopes("all")
                .redirectUris("http://localhost:8080/callback")
                .accessTokenValiditySeconds(30*60)
                .refreshTokenValiditySeconds(60*60);
	}

	// 配置 Token 的节点 和 Token 服务
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

		endpoints.tokenStore(tokenStore()).authenticationManager(authenticationManager)
				.userDetailsService(userDetailService).accessTokenConverter(jwtTokenEnhancer());
	}

	// 配置 Token 节点的安全策略
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security
			.tokenKeyAccess("isAuthenticated()")
			.checkTokenAccess("permitAll()")
			.allowFormAuthenticationForClients(); //支持把secret和client id写在url上，否则需要在请求头上
	}

}
