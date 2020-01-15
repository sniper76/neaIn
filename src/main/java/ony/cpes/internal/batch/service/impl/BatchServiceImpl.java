package ony.cpes.internal.batch.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import ony.cmm.common.bean.SmsBean;
import ony.cmm.common.dao.CommonDAO;
import ony.cmm.common.service.CommonService;
import ony.cpes.internal.batch.bean.BatchLogBean;
import ony.cpes.internal.batch.dao.BatchDAO;
import ony.cpes.internal.batch.service.BatchService;

@Service("batchService")
public class BatchServiceImpl implements BatchService {

	@Autowired
	private BatchDAO bdao;
	
	@Autowired 
	MessageSource messageSource;

	@Autowired 
	SessionLocaleResolver localeResolver;
	
	@Autowired 
	CommonService commSvc;
	
	@Autowired
	private CommonDAO commonDao;

	@Override
	public void getBatchConn() {
		int result = commonDao.getBatchConn();
	}
	
	public void selectOverThreeDaysApplic() throws Exception{
		
		List<Map<String, String>> list = bdao.selectOverThreeDaysApplic();
		
		BatchLogBean batchLog = new BatchLogBean();
		batchLog.setBatchKindCd("BAT0000000001");
		batchLog.setLang("en");
		try {
			insertBatch(batchLog);
			for(Map<String, String> map : list) {
				if("Y".equals(map.get("emailNtceAgreeYn"))) {
					// send email
				}
				
				if("Y".equals(map.get("smsNtceAgreeYn"))) {
					/* send SMS */
		               String msg = "You have a resume that you haven't read in three days.";
		               SmsBean sms = new SmsBean();
		               sms.setSmsText(msg);
		               sms.setSmsTo("85581609370");
		               commSvc.insertSmsLog(sms);
				}
			}
			batchLog.setSuccessYn("Y");
			updateBatchLog(batchLog);
		} catch (Exception e) {
			batchLog.setSuccessYn("N");
			updateBatchLog(batchLog);
		}
		
	}

	public void selectOverThreeDaysOffer() throws Exception{

		List<Map<String, String>> list = bdao.selectOverThreeDaysApplic();
		BatchLogBean batchLog = new BatchLogBean();
		batchLog.setBatchKindCd("BAT0000000002");
		batchLog.setLang("en");
		try {
			insertBatch(batchLog);
			for(Map<String, String> map : list) {
				if("Y".equals(map.get("emailNtceAgreeYn"))) {
					
				}
				
				if("Y".equals(map.get("smsNtceAgreeYn"))) {
					/* send SMS */
		               String msg = "You have a offer that you haven't read in three days.";
		               SmsBean sms = new SmsBean();
		               sms.setSmsText(msg);
		               sms.setSmsTo("85581609370");
		               commSvc.insertSmsLog(sms);
				}
			}
			batchLog.setSuccessYn("Y");
			updateBatchLog(batchLog);
		} catch (Exception e) {
			batchLog.setSuccessYn("N");
			updateBatchLog(batchLog);
		}
	}
	
	public void insertBatchPopulCompny() throws Exception {
		
		Map<String, String> map = new HashMap<String, String>();

		BatchLogBean batchLog = new BatchLogBean();
		batchLog.setBatchKindCd("BAT0000000003");
		batchLog.setLang("en");
		try {
			insertBatch(batchLog);
			// 오늘의 기업
			int result1 = bdao.insertBatchTodayPopulCompny(map);
			batchLog.setSuccessYn("Y");
			updateBatchLog(batchLog);
		} catch (Exception e) {
			batchLog.setSuccessYn("N");
			updateBatchLog(batchLog);
		}
		
		// 이주의 기업
		batchLog.setBatchKindCd("BAT0000000004");
		try {
			insertBatch(batchLog);
			int result2 = bdao.insertBatchWeekPopulCompny(map);
			batchLog.setSuccessYn("Y");
			updateBatchLog(batchLog);
		} catch (Exception e) {
			batchLog.setSuccessYn("N");
			updateBatchLog(batchLog);
		}
		
		// 이달의 기업
		batchLog.setBatchKindCd("BAT0000000005");
		try {
			insertBatch(batchLog);
			int result3 = bdao.insertBatchMonthPopulCompny(map);
			batchLog.setSuccessYn("Y");
			updateBatchLog(batchLog);
		} catch (Exception e) {
			batchLog.setSuccessYn("N");
			updateBatchLog(batchLog);
		}
		
		// 오늘의 채용공고
		batchLog.setBatchKindCd("BAT0000000006");
		try {
			insertBatch(batchLog);
			int result4 = bdao.insertBatchMonthPopulVacancy(map);
			batchLog.setSuccessYn("Y");
			updateBatchLog(batchLog);
		} catch (Exception e) {
			batchLog.setSuccessYn("N");
			updateBatchLog(batchLog);
		}
		
		// 휴면회원
		batchLog.setBatchKindCd("BAT0000000007");
		try {
			insertBatch(batchLog);
			int result5 = bdao.updateBatchDormancyMember();
			batchLog.setSuccessYn("Y");
			updateBatchLog(batchLog);
		} catch (Exception e) {
			batchLog.setSuccessYn("N");
			updateBatchLog(batchLog);
		}
		
		// 채용공고 진행중 상태 변경
		batchLog.setBatchKindCd("BAT0000000008");
		try {
			insertBatch(batchLog);
			int result6 = bdao.updateBatchNowVacancy();
			batchLog.setSuccessYn("Y");
			updateBatchLog(batchLog);
		} catch (Exception e) {
			batchLog.setSuccessYn("N");
			updateBatchLog(batchLog);
		}
		
		// 채용공고 채용마감 상태 변경
		batchLog.setBatchKindCd("BAT0000000009");
		try {
			insertBatch(batchLog);
			int result7 = bdao.updateBatchOverVacancy();
			batchLog.setSuccessYn("Y");
			updateBatchLog(batchLog);
		} catch (Exception e) {
			batchLog.setSuccessYn("N");
			updateBatchLog(batchLog);
		}
		
		// 교육훈련 모집 대기 상태 변경
		batchLog.setBatchKindCd("BAT0000000010");
		try {
			insertBatch(batchLog);
			int result8 = bdao.updateBatchBeforeEduTrnng();
			batchLog.setSuccessYn("Y");
			updateBatchLog(batchLog);
		} catch (Exception e) {
			batchLog.setSuccessYn("N");
			updateBatchLog(batchLog);
		}
		
		// 교육훈련 모집 중 상태 변경
		batchLog.setBatchKindCd("BAT0000000011");
		try {
			insertBatch(batchLog);
			int result9 = bdao.updateBatchNowEduTrnng();
			batchLog.setSuccessYn("Y");
			updateBatchLog(batchLog);
		} catch (Exception e) {
			batchLog.setSuccessYn("N");
			updateBatchLog(batchLog);
		}
		
		// 교육훈련 모집마감 상태 변경
		batchLog.setBatchKindCd("BAT0000000012");
		try {
			insertBatch(batchLog);
			int result10 = bdao.updateBatchOverEduTrnng();
			batchLog.setSuccessYn("Y");
			updateBatchLog(batchLog);
		} catch (Exception e) {
			batchLog.setSuccessYn("N");
			updateBatchLog(batchLog);
		}
	}
	
	/**
	 * Regist log batch
	 * @param param
	 */
	public void insertBatch(BatchLogBean param) {
		try {
			bdao.insertBatchLog(param);
		} catch (Exception e) {
		}
	}
	
	/**
	 * Update log Batch
	 * @param param
	 */
	public void updateBatchLog(BatchLogBean param) {
		try {
			bdao.updateBatchLog(param);
		} catch (Exception e) {
		}
	}
	
}
