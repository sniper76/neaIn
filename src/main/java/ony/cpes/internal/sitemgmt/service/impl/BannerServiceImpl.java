package ony.cpes.internal.sitemgmt.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ony.cpes.internal.sitemgmt.service.BannerService;
import ony.cpes.internal.sitemgmt.bean.BannerBean;
import ony.cpes.internal.sitemgmt.dao.BannerDAO;

@Service("BannerService")
public class BannerServiceImpl implements BannerService{
	
	private static Log log = LogFactory.getLog(BannerServiceImpl.class);
	
	@Autowired
	private BannerDAO bannerDAO;
	
	
	@Override
	/**
	 * 배너관리 목록 조회
	 * @param param BsnsBean
	 * @return BsnsBean
	 */
    public BannerBean selectBannerList(BannerBean param) throws Exception {
    	
		int totalCount = bannerDAO.selectPopUpTotalCount(param);
		List<BannerBean> list = bannerDAO.selectBannerList(param);

		param.setiTotalRecords(totalCount);
		param.setiTotalDisplayRecords(totalCount);
		param.setList(list);
		
		return param;
    }
	
	
	/**
	 * 배너관리 추가
	 * @param param BsnsBean
	 * @return Map
	 */
	@Override
	public Map<String,Object> insertBanner(BannerBean param) throws Exception {
		Map<String,Object> result = new HashMap<String,Object>();
    	

		String uuid = (String)bannerDAO.getUUID();
		param.setBannerSeq(uuid);
		
		int resultCd = bannerDAO.insertBanner(param);
		
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
	 * 배너 상세 조회
	 * @param param BsnsBean
	 * @return Map
	 */
	@Override
	public BannerBean selectBannerDtl(BannerBean param) throws Exception {
		BannerBean bannerBean = new BannerBean();
		
		bannerBean = bannerDAO.selectBannerDtl(param);
		
		return bannerBean;
    }
	
	
	
	/**
	 * 배너관리 수정
	 * @param param BsnsBean
	 * @return Map
	 */
	@Override
	public Map<String,Object> updateBanner(BannerBean param) throws Exception {
		Map<String,Object> result = new HashMap<String,Object>();
		
		int resultCd = bannerDAO.updateBanner(param);
		
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
	 * 배너관리 삭제
	 * @param param BsnsBean
	 * @return Map
	 */
	@Override
	public Map<String,Object> deleteBannerDtl(BannerBean param) throws Exception {
		Map<String,Object> result = new HashMap<String,Object>();
		
		int resultCd = bannerDAO.deleteBannerDtl(param);
		
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
