package com.example.batchapp;

import com.example.modelgen.dmdl.csv.AbstractItemMasterCsvInputDescription;

/**
 * 商品マスタ
 */
public class ItemMasterFromCsv extends AbstractItemMasterCsvInputDescription {

	@Override
	public String getBasePath() {
		return "sample/in";
	}

	@Override
	public String getResourcePattern() {
		return "item_master.csv";
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
