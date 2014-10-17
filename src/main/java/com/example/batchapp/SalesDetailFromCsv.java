package com.example.batchapp;

import com.example.modelgen.dmdl.csv.AbstractSalesDetailCsvInputDescription;

/**
 * 売上明細
 */
public class SalesDetailFromCsv extends AbstractSalesDetailCsvInputDescription {

	@Override
	public String getBasePath() {
		return "sample/in";
	}

	@Override
	public String getResourcePattern() {
		return "sales_detail.csv";
	}

	@Override
	public boolean isOptional() {
		return false;
	}

	@Override
	public DataSize getDataSize() {
		return DataSize.UNKNOWN;
	}
}
