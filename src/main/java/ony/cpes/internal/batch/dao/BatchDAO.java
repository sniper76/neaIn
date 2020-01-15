package ony.cpes.internal.batch.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import ony.cpes.internal.batch.bean.BatchLogBean;

@Repository("batchDAO")
public class BatchDAO extends EgovAbstractMapper {

	public List<Map<String, String>> selectOverThreeDaysApplic(){
		return getSqlSession().selectList("batch.selectOverThreeDaysApplic", null);
	}

	public List<Map<String, String>> selectOverThreeDaysOffer(){
		return getSqlSession().selectList("batch.selectOverThreeDaysOffer", null);
	}

	public int insertBatchTodayPopulCompny(Map<String, String> param) throws Exception{
		return getSqlSession().insert("setBatch.insertBatchTodayPopulCompny", param);
	}
	
	public int insertBatchWeekPopulCompny(Map<String, String> param) throws Exception{
		return getSqlSession().insert("setBatch.insertBatchWeekPopulCompny", param);
	}
	
	public int insertBatchMonthPopulCompny(Map<String, String> param) throws Exception{
		return getSqlSession().insert("setBatch.insertBatchMonthPopulCompny", param);
	}
	
	public int insertBatchMonthPopulVacancy(Map<String, String> param) throws Exception{
		return getSqlSession().insert("setBatch.insertBatchMonthPopulVacancy", param);
	}
	
	public int updateBatchDormancyMember() throws Exception{
		return getSqlSession().insert("setBatch.updateBatchDormancyMember", null);
	}
	
	public int updateBatchNowVacancy() throws Exception{
		return getSqlSession().insert("setBatch.updateBatchNowVacancy", null);
	}
	
	public int updateBatchOverVacancy() throws Exception{
		return getSqlSession().insert("setBatch.updateBatchOverVacancy", null);
	}
	
	public int updateBatchBeforeEduTrnng() throws Exception{
		return getSqlSession().insert("setBatch.updateBatchBeforeEduTrnng", null);
	}
	
	public int updateBatchNowEduTrnng() throws Exception{
		return getSqlSession().insert("setBatch.updateBatchNowEduTrnng", null);
	}
	
	public int updateBatchOverEduTrnng() throws Exception{
		return getSqlSession().insert("setBatch.updateBatchOverEduTrnng", null);
	}

	public int insertBatchLog(BatchLogBean param) throws Exception{
		return getSqlSession().insert("setBatch.insertBatchLog", param);
	}
	
	public int updateBatchLog(BatchLogBean param) throws Exception{
		return getSqlSession().insert("setBatch.updateBatchLog", param);
	}
}
