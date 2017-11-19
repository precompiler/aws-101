package com.precompiler.s3.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.profile.internal.securitytoken.RoleInfo;
import com.amazonaws.auth.profile.internal.securitytoken.STSProfileCredentialsServiceProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
@EnableConfigurationProperties(value = S3ConfigurationProperties.class)
public class AWSConfiguration {
	@Bean
	public AmazonS3 s3Client(S3ConfigurationProperties properties) {
		RoleInfo roleInfo = new RoleInfo().withRoleArn(properties.getRoleArn())
				.withRoleSessionName(properties.getRoleSessionName());
		STSProfileCredentialsServiceProvider credentialProvider = new STSProfileCredentialsServiceProvider(roleInfo);
		AmazonS3 amazonS3Client = AmazonS3ClientBuilder.standard().withCredentials(credentialProvider)
				.withRegion(properties.getRegion()).build();
		return amazonS3Client;
	}
}
