package com.precompiler.s3.config;

import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ConfigurationProperties(prefix = "aws.s3")
@Getter
@Setter
@ToString
public class S3ConfigurationProperties {
	// @NotNull
	// private String roleArn;
	// @NotNull
	// private String roleSessionName;
	@NotNull
	private String region;
}
