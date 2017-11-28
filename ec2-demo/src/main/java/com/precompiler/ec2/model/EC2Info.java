package com.precompiler.ec2.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EC2Info {
	private String amiId;
	private String hostname;
	private String instanceId;
	private String publicHostname;
	private String publicIpV4;
}
