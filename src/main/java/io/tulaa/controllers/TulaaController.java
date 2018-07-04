package io.tulaa.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.tulaa.models.InterviewRequest;
import io.tulaa.models.InterviewResponse;
import io.tulaa.utils.Utilities;

@RestController
@RequestMapping(value = "/interview")
@Api(tags = "Tulaa Interview Solution", description = "Resource for performing interview tasks", position = 1)
public class TulaaController {

	@RequestMapping(value = "/pascal", method = RequestMethod.POST)
	@ApiOperation("Endpoint to return Kth Row of the Pascal's triangle")
	public HttpEntity<InterviewResponse> uploadMobileData(@Valid @RequestBody InterviewRequest interviewRequest,
			HttpServletRequest request) {
		InterviewResponse response = new InterviewResponse();
		response.setPascalResponse(Utilities.getRow(interviewRequest.getPascalsTriangleInput()));
		return new ResponseEntity<InterviewResponse>(response, HttpStatus.OK);

	}

	@RequestMapping(value = "/triplet", method = RequestMethod.POST)
	@ApiOperation("Function that returns true if there is a triplet (a, b, c) "
			+ "that satisfies a\u00B2 + b\u00B2 = c\u00B2")
	public HttpEntity<InterviewResponse> hasArrayTiplet(@Valid @RequestBody InterviewRequest interviewRequest,
			HttpServletRequest request) {
		InterviewResponse response = new InterviewResponse();
		response.setTripletResponse(Utilities.isArrayTriplet(interviewRequest.getTripletArrayInput(),
				interviewRequest.getTripletArrayInput().length));
		return new ResponseEntity<InterviewResponse>(response, HttpStatus.OK);

	}

	@RequestMapping(value = "/counttripletssmallersum", method = RequestMethod.POST)
	@ApiOperation("Given an array of distinct integers and a sum value. Find count of triplets with sum smaller than given sum value. Expected Time Complexity is O(n\u00B2)")
	public HttpEntity<InterviewResponse> countTripletsWithSmallerSum(
			@Valid @RequestBody InterviewRequest interviewRequest, HttpServletRequest request) {
		InterviewResponse response = new InterviewResponse();
		response.setCountTripletsSmallerSumResponse(Utilities.countTripletsFn(interviewRequest.getCountTripletsInput(),
				interviewRequest.getCountTripletsInput().length, interviewRequest.getCountTripletInputSum()));
		return new ResponseEntity<InterviewResponse>(response, HttpStatus.OK);

	}

}
