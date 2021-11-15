package com.bdlz.stateanalyser;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;

public class CensusAnalyser {
    public int loadIndiaCensusData(String csvFilePath) throws CensusAnalyserException {
        try {
            if (csvFilePath.contains("txt")) {
                throw new CensusAnalyserException("File must be in CSV Format", CensusAnalyserException.ExceptionType.CENSUS_INCORRECT_FILE_FORMAT);
            }
            Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
            CsvToBean<IndiaCensusCSV> csvToBean = new CsvToBeanBuilder<IndiaCensusCSV>(reader)
                    .withType(IndiaCensusCSV.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            Iterator<IndiaCensusCSV> iterator = csvToBean.iterator();
            // iterator doesn't consume memory
            Iterable<IndiaCensusCSV> csvIterable = () -> iterator;
            int count = (int) StreamSupport.stream(csvIterable.spliterator(), true).count();
            return count;
        } catch (RuntimeException e) {
            throw new CensusAnalyserException("CSV File Must Has Incorrect Header", CensusAnalyserException.ExceptionType.CENSUS_WRONG_HEADER);
        } catch (IOException e) {
            throw new CensusAnalyserException(e.getMessage(), CensusAnalyserException.ExceptionType.CENSUS_FILE_INCORRECT);
        }
    }

    public int loadIndianStateCodeData(String csvFilePath) throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
        CsvToBean<IndianStateCodeCSV> csvToBean = new CsvToBeanBuilder<IndianStateCodeCSV>(reader)
                .withType(IndianStateCodeCSV.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();
        Iterator<IndianStateCodeCSV> iterator = csvToBean.iterator();
        // iterator doesn't consume memory
        Iterable<IndianStateCodeCSV> csvIterable = () -> iterator;
        int count = (int) StreamSupport.stream(csvIterable.spliterator(), true).count();
        return count;
    }
}
