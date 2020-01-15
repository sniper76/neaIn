package ony.cpes.internal.bulletin.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ony.cpes.internal.bulletin.bean.BanWordBean;
import ony.cpes.internal.bulletin.dao.BanWordDAO;
import ony.cpes.internal.bulletin.service.BanWordService;

@Service("BanWordService")
public class BanWordServiceImpl implements BanWordService{
	
	private static Log log = LogFactory.getLog(BanWordServiceImpl.class);
	
	@Autowired
	private BanWordDAO banWordDAO;
	
	@Override
	/**
	 * 게시판관리 목록 조회
	 * @param param BsnsBean
	 * @return BsnsBean
	 */
    public BanWordBean selectBanWordList(BanWordBean param) throws Exception {
    	
		int totalCount = banWordDAO.selectBanWordTotalCount(param);
		param.setRecordsTotal(totalCount);
		int pageNo = (param.getStart() + param.getLength()) / param.getLength();
	    param.setPageNo(pageNo);

		List<BanWordBean> list = banWordDAO.selectBanWordList(param);

		param.setiTotalRecords(totalCount);
		param.setiTotalDisplayRecords(totalCount);
		param.setList(list);
		
		return param;
    }
	
	/**
	 * 
	 */
	@Override
	public Map<String,Object> insertBanWord(BanWordBean param) throws Exception {
		Map<String,Object> result = new HashMap<String,Object>();
    	

		String uuid = (String)banWordDAO.selectUUID();
		param.setBanwordSeq(uuid);
		
		int resultCd = banWordDAO.insertBanWord(param);
		
		if(resultCd > 0) {
			result.put("stat", "0000"); //success
			result.put("msg", "");
		}else {
			result.put("stat", "1111"); //fail
			result.put("msg", "");
		}
		
		return result;
    }
	
	@Override
	public Map<String,Object> updateBanWord(BanWordBean param) throws Exception {
		Map<String,Object> result = new HashMap<String,Object>();
    	
		
		int resultCd = banWordDAO.updateBanWord(param);
		
		if(resultCd > 0) {
			result.put("stat", "0000"); //success
			result.put("msg", "");
		}else {
			result.put("stat", "1111"); //fail
			result.put("msg", "");
		}
		
		return result;
    }
	
	
	@Override
	public Map<String,Object> deleteBanWord(BanWordBean param) throws Exception {
		Map<String,Object> result = new HashMap<String,Object>();
		
		int resultCd = 0;
    	
		List<String> sList = param.getSelectedList();
		for(String s : sList) {
			param.setBanwordSeq(s);
			resultCd = banWordDAO.deleteBanWord(param);
		}
		
		if(resultCd > 0) {
			result.put("stat", "0000"); //success
			result.put("msg", "");
		}else {
			result.put("stat", "1111"); //fail
			result.put("msg", "");
		}
		
		return result;
    }
	
}
