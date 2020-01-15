package ony.cpes.internal.batch.service;

import java.util.Map;

public interface BatchService {
	
	public void getBatchConn();
	
	public void selectOverThreeDaysApplic() throws Exception;

	public void selectOverThreeDaysOffer() throws Exception;
	
	public void insertBatchPopulCompny() throws Exception;
}
