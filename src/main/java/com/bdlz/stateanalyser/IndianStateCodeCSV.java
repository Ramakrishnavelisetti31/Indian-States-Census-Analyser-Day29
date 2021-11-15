package com.bdlz.stateanalyser;

import com.opencsv.bean.CsvBindByName;

public class IndianStateCodeCSV {
    @CsvBindByName(column = "SrNo")
    public String srNo;

    @CsvBindByName(column = "State")
    public String state;

    @CsvBindByName(column = "TIN")
    public String tin;

    @CsvBindByName(column = "StateCode")
    public String stateCode;

    @Override
    public String toString() {
        return "IndianStateCodeCSV{" +
                "srNo='" + srNo + '\'' +
                ", state='" + state + '\'' +
                ", tin='" + tin + '\'' +
                ", stateCode='" + stateCode + '\'' +
                '}';
    }
}
