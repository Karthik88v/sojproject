package com.example.sojproject.controller;

import com.example.sojproject.service.MathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/math")
public class MathApiController {

    private MathService mathService;

    public MathApiController(MathService mathService) {
        this.mathService = mathService;
    }

    @GetMapping(value = "/min", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Integer>> getMinimumNumbers(@RequestParam(value = "numbers") List<Integer> numbers,
                                              @RequestParam(value = "quantifier") Integer quantifier) throws Exception {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(mathService.getMinimumNumbers(numbers, quantifier));
    }

    @GetMapping(value = "/max", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Integer>> getMaximumNumbers(@RequestParam(value = "numbers") List<Integer> numbers,
                                                           @RequestParam(value = "quantifier") Integer quantifier) throws Exception {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(mathService.getMaximumNumbers(numbers, quantifier));
    }

    @GetMapping(value = "/avg", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Double> calculateAverage(@RequestParam(value = "numbers") List<Integer> numbers) throws Exception {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(mathService.calculateMedian(numbers));
    }

    @GetMapping(value = "/median", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Double> calculateMedian(@RequestParam(value = "numbers") List<Integer> numbers) throws Exception {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(mathService.calculateMedian(numbers));
    }

    @GetMapping(value = "/percentile", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Double> calculatePercentile(@RequestParam(value = "numbers") List<Integer> numbers,
                                                @RequestParam(value = "quantifier") Integer quantifier) throws Exception {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(mathService.calculatePercentile(numbers, quantifier));
    }

    @ExceptionHandler({ Exception.class })
    public ResponseEntity<Object> handleException(Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
