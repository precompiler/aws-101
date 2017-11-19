package com.precompiler.s3.model;

import java.util.List;

import com.amazonaws.services.s3.model.Bucket;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ListBucketsResponse {
	private List<Bucket> buckets;
}
