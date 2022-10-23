package com.example.sojproject.service;

import com.example.sojproject.service.impl.MathServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@RunWith(SpringRunner.class)
public class MathServiceTest {

    @InjectMocks
    MathServiceImpl mathService;

    @Test
    public void getMinNumbers_shouldThrowExceptionForNullList(){
        try{
            mathService.getMinimumNumbers(null, 2);
        } catch (Exception e) {
            Assert.assertEquals("List should not be empty or null", e.getMessage());
        }
    }

    @Test
    public void getMinNumbers_shouldThrowExceptionForNoQuantifier(){
        try{
            mathService.getMinimumNumbers(Arrays.asList(1,2,3), 0);
        } catch (Exception e) {
            Assert.assertEquals("Quantifier must be greater than 0", e.getMessage());
        }
    }

    @Test
    public void getMinNumbers_shouldReturnMinListGivenPositiveNumbers() throws Exception {
        Assert.assertEquals(Arrays.asList(1,3,6), mathService.getMinimumNumbers(Arrays.asList(12,6,3,1,11,8), 3));
    }

    @Test
    public void getMinNumbers_shouldReturnMinListGivenNegativeNumbers() throws Exception {
        Assert.assertEquals(Arrays.asList(-11,-6,1), mathService.getMinimumNumbers(Arrays.asList(12,-6,3,1,-11,8), 3));
    }

    @Test
    public void getMaxNumbers_shouldThrowExceptionForNullList(){
        try{
            mathService.getMaximumNumbers(null, 2);
        } catch (Exception e) {
            Assert.assertEquals("List should not be empty or null", e.getMessage());
        }
    }

    @Test
    public void getMaxNumbers_shouldThrowExceptionForNoQuantifier(){
        try{
            mathService.getMaximumNumbers(Arrays.asList(1,2,3), 0);
        } catch (Exception e) {
            Assert.assertEquals("Quantifier must be greater than 0", e.getMessage());
        }
    }

    @Test
    public void getMaxNumbers_shouldReturnMaxListGivenPositiveNumbers() throws Exception {
        Assert.assertEquals(Arrays.asList(12,11,8), mathService.getMaximumNumbers(Arrays.asList(12,6,3,1,11,8), 3));
    }

    @Test
    public void getMaxNumbers_shouldReturnMaxListGivenNegativeNumbers() throws Exception {
        Assert.assertEquals(Arrays.asList(12,8,3), mathService.getMaximumNumbers(Arrays.asList(12,-6,3,1,-11,8), 3));
    }

    @Test
    public void calculateAverage_shouldThrowExceptionForNullList(){
        try{
            mathService.calculateAverage(null);
        } catch (Exception e) {
            Assert.assertEquals("List should not be empty or null", e.getMessage());
        }
    }

    @Test
    public void calculateAverage_shouldReturnAverageForPositiveNumbers() throws Exception {
        Assert.assertEquals(Double.valueOf(1.1666666666666667), mathService.calculateAverage(Arrays.asList(12,-6,3,1,-11,8)));
    }

    @Test
    public void calculateMedian_shouldThrowExceptionForNullList(){
        try{
            mathService.calculateMedian(null);
        } catch (Exception e) {
            Assert.assertEquals("List should not be empty or null", e.getMessage());
        }
    }

    @Test
    public void calculateMedian_shouldReturnMedianForEvenList() throws Exception {
        Assert.assertEquals(Double.valueOf(2.0), mathService.calculateMedian(Arrays.asList(12,-6,3,1,-11,8)));
    }

    @Test
    public void calculateMedian_shouldReturnMedianForOddList() throws Exception {
        Assert.assertEquals(Double.valueOf(1.0), mathService.calculateMedian(Arrays.asList(12,-6,3,1,-11)));
    }

    @Test
    public void calculatePercentile_shouldThrowExceptionForNullList(){
        try{
            mathService.calculatePercentile(null, 2);
        } catch (Exception e) {
            Assert.assertEquals("List should not be empty or null", e.getMessage());
        }
    }

    @Test
    public void calculatePercentile_shouldThrowExceptionForNoQuantifier(){
        try{
            mathService.calculatePercentile(Arrays.asList(1,2,3), 0);
        } catch (Exception e) {
            Assert.assertEquals("Quantifier must be greater than 0", e.getMessage());
        }
    }

    @Test
    public void calculatePercentile_shouldReturnMedianForOddList() throws Exception {
        Assert.assertEquals(Double.valueOf(3.5), mathService.calculatePercentile(Arrays.asList(12,-6,3,1,-11), 70));
    }
}
