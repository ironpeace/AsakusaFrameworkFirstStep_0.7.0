package com.example.batch;

import com.asakusafw.vocabulary.batch.Batch;
import com.asakusafw.vocabulary.batch.BatchDescription;
import com.example.batchapp.MainJobFlow;

/**
 * SampleBatch
 */
@Batch(name = "SampleBatch")
public class SampleBatch extends BatchDescription {
	@Override
	public void describe() {
		// mainJobFlow	MainJobFlow
		run(MainJobFlow.class).soon();
	}
}
