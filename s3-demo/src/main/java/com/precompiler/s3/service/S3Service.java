package com.precompiler.s3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.Bucket;

/**
 * S3 demo service.
 * 
 * @author Richard Li
 *
 */
@Service
public class S3Service {
	private AmazonS3 s3Client;

	@Autowired
	public S3Service(AmazonS3 s3Client) {
		this.s3Client = s3Client;
	}

	/**
	 * List buckets.
	 * 
	 * @return
	 */
	public List<Bucket> listBuckets() {
		return s3Client.listBuckets();
	}
}
