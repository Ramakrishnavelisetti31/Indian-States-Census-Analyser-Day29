package com.bdlz.stateanalyser;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static com.bdlz.stateanalyser.CensusAnalyserException.ExceptionType.CENSUS_INCORRECT_FILE_FORMAT;
import static org.junit.Assert.*;

public class CensusAnalyserTest {
    private String INDIAN_CENSUS_CSV_FILE_PATH = "C:\\Users\\lenovo\\IdeaProjects\\IndianStateAnalyser\\src\\main\\resources\\IndianStateCensus.csv";
    private String INIDAN_CENSUS_WrongCSV_FILE_PATH = "C:\\Users\\lenovo\\IdeaProjects\\IndianStateAnalyser\\src\\main\\resources\\IndianStateCensus1.csv";
    private String INDIAN_CENSUS_INCORRECT_FILE_FORMAT  = "C:\\Users\\lenovo\\IdeaProjects\\IndianStateAnalyser\\src\\main\\resources\\IndianStateCensus.txt";
    private String INDIAN_CENSUS_WITHWRONG_DELIMITER ="C:\\Users\\lenovo\\IdeaProjects\\IndianStateAnalyser\\src\\main\\resources\\IndianStateCensus.csv";


    // Tc1.1
    @Test
    public void givenIndianCensusCSVFile_WhenLoad_ShouldReturnCorrectRecords() throws CensusAnalyserException {
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        int count = censusAnalyser.loadIndiaCensusData(INDIAN_CENSUS_CSV_FILE_PATH);
        Assert.assertEquals(29,count);
    }

    // TC1.2
    @Test
    public void givenIndianCensusWrongCSVFile_WhenLoad_ShouldReturnException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(INIDAN_CENSUS_WrongCSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(e.type, CensusAnalyserException.ExceptionType.CENSUS_FILE_INCORRECT);
            e.printStackTrace();
        }

    }

    // TC1.3
    @Test
    public void givenIndianCensusCSVFile_WhenCorrectPathButWrongFileFormat_ShouldThrowException() {

        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(INDIAN_CENSUS_INCORRECT_FILE_FORMAT);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CENSUS_INCORRECT_FILE_FORMAT, e.type);
        }
    }

    // TC1.4
    @Test
    public void givenIndianCensusCSVFile_WhenWrongDelimiter_ShouldThrowException() {

        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(INDIAN_CENSUS_WITHWRONG_DELIMITER);
        }
        catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_WRONG_DELIMITER, e.type);
            e.printStackTrace();
        }
    }

}