package com.precompiler.s3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.s3.model.Bucket;
import com.precompiler.s3.model.ListBucketsResponse;
import com.precompiler.s3.service.S3Service;

/**
 * S3 demo controller.
 * 
 * @author Richard Li
 */
@RestController
public class S3DemoController {

	private S3Service s3Service;

	@Autowired
	public S3DemoController(S3Service s3Service) {
		this.s3Service = s3Service;
	}

	/**
	 * List S3 buckets.
	 * 
	 * @return Buckets information.
	 */
	@RequestMapping(path = "/buckets", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ListBucketsResponse> listBuckets() {
		List<Bucket> buckets = s3Service.listBuckets();
		if (CollectionUtils.isEmpty(buckets)) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(new ListBucketsResponse(buckets), HttpStatus.OK);
		}
	}

	/**
	 * Health check.
	 * 
	 * @return
	 */
	@RequestMapping(path = "/healthCheck", method = RequestMethod.GET)
	public ResponseEntity<Void> healthCheck() {
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
