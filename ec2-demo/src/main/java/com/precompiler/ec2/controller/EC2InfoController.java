package com.precompiler.ec2.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.precompiler.ec2.model.EC2Info;

@RestController
public class EC2InfoController {
	@Value("${ami-id}")
	private String amiId;
	@Value("${hostname}")
	private String hostname;
	@Value("${instance-id}")
	private String instanceId;
	@Value("${public-hostname}")
	private String publicHostname;
	@Value("${public-ipv4}")
	private String publicIpV4;

	@RequestMapping(path = "/ec2-info", method = RequestMethod.GET)
	public ResponseEntity<EC2Info> getEC2Info() {
		return new ResponseEntity<>(new EC2Info(amiId, hostname, instanceId, publicHostname, publicIpV4),
				HttpStatus.OK);
	}
}
