package ony.cpes.internal.sitemgmt.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ony.cpes.internal.sitemgmt.service.PopUpService;
import ony.cpes.internal.bulletin.bean.BulletinBean;
import ony.cpes.internal.sitemgmt.bean.PopUpBean;
import ony.cpes.internal.sitemgmt.controller.PopUpController;
import ony.cpes.internal.sitemgmt.dao.PopUpDAO;
import ony.framework.bean.PagingBean;

@Service("PopUpService")
public class PopUpServiceImpl implements PopUpService{
	
	private static Log log = LogFactory.getLog(PopUpServiceImpl.class);
	
	@Autowired
	private PopUpDAO popUpDAO;
	
	@Override
	/**
	 * 팝업관리 목록 조회
	 * @param param BsnsBean
	 * @return BsnsBean
	 */
    public PopUpBean selectPopUpList(PopUpBean param) throws Exception {
    	
		int totalCount = popUpDAO.selectPopUpTotalCount(param);
		List<PopUpBean> list = popUpDAO.selectPopUpList(param);

		param.setiTotalRecords(totalCount);
		param.setiTotalDisplayRecords(totalCount);
		param.setList(list);
		
		return param;
    }
	
	
	/**
	 * 팝업관리 추가
	 * @param param BsnsBean
	 * @return Map
	 */
	@Override
	public Map<String,Object> insertPopUp(PopUpBean param) throws Exception {
		Map<String,Object> result = new HashMap<String,Object>();
    	

		String uuid = (String)popUpDAO.getUUID();
		param.setPopupSeq(uuid);
		
		int resultCd = popUpDAO.insertPopUp(param);
		
		if(resultCd > 0) {
			result.put("stat", "0000"); //success
			result.put("msg", "");
		}else {
			result.put("stat", "1111"); //fail
			result.put("msg", "");
		}
		
		return result;
    }
	
	/**
	 * 팝업 상세 조회
	 * @param param BsnsBean
	 * @return Map
	 */
	@Override
	public PopUpBean selectPopUpDtl(PopUpBean param) throws Exception {
		PopUpBean popUpBean = new PopUpBean();
		
		popUpBean = popUpDAO.selectPopUpDtl(param);
		
		return popUpBean;
    }
	
	
	
	/**
	 * 팝업관리 수정
	 * @param param BsnsBean
	 * @return Map
	 */
	@Override
	public Map<String,Object> updatePopUp(PopUpBean param) throws Exception {
		Map<String,Object> result = new HashMap<String,Object>();
		
		int resultCd = popUpDAO.updatePopUp(param);
		
		if(resultCd > 0) {
			result.put("stat", "0000"); //success
			result.put("msg", "");
		}else {
			result.put("stat", "1111"); //fail
			result.put("msg", "");
		}
		
		return result;
    }
	
	/**
	 * 팝업관리 삭제
	 * @param param BsnsBean
	 * @return Map
	 */
	@Override
	public Map<String,Object> deletePopUp(PopUpBean param) throws Exception {
		Map<String,Object> result = new HashMap<String,Object>();
		
		int resultCd = popUpDAO.deletePopUp(param);
		
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
