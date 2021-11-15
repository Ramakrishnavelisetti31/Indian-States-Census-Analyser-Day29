package com.bdlz.stateanalyser;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CensusAnalyserTest {
    private String INDIAN_CENSUS_CSV_FILE_PATH = "C:\\Users\\lenovo\\IdeaProjects\\IndianStateAnalyser\\src\\main\\resources\\IndianStateCensus.csv";

    // Tc1.1
    @Test
    public void givenIndianCensusCSVFile_WhenLoad_ShouldReturnCorrectRecords() {
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        int count = censusAnalyser.loadIndiaCensusData(INDIAN_CENSUS_CSV_FILE_PATH);
        Assert.assertEquals(29,count);
    }
}