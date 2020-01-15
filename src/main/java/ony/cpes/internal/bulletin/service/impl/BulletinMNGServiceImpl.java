package ony.cpes.internal.bulletin.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import ony.cpes.internal.bulletin.bean.BulletinCateBean;
import ony.cpes.internal.bulletin.bean.BulletinMNGBean;
import ony.cpes.internal.bulletin.dao.BulletinMNGDAO;
import ony.cpes.internal.bulletin.service.BulletinMNGService;
import ony.cpes.internal.common.bean.ProgramBean;

@Service("BulletinMNGService")
public class BulletinMNGServiceImpl implements BulletinMNGService{
	
	private static Log log = LogFactory.getLog(BulletinMNGServiceImpl.class);
	
	@Autowired
	private BulletinMNGDAO bulletinMNGDAO;
	
	@Autowired MessageSource messageSource;
	
	@Autowired SessionLocaleResolver localeResolver;
	
	@Override
	/**
	 * 게시판관리 목록 조회
	 * @param param BsnsBean
	 * @return BsnsBean
	 */
    public BulletinMNGBean selectBulletinMNGList(BulletinMNGBean param) throws Exception {
    	
		int totalCount = bulletinMNGDAO.selectBulletinMNGTotalCount(param);
		List<BulletinMNGBean> list = bulletinMNGDAO.selectBulletinMNGList(param);

		param.setiTotalRecords(totalCount);
		param.setiTotalDisplayRecords(totalCount);
		param.setList(list);
		
		return param;
    }
	
	@Override
	/**
	 * 게시판관리 추가
	 * @param param BsnsBean
	 * @return BsnsBean
	 */
    public Map<String,Object> insertBulletinMNG(HttpServletRequest request, BulletinMNGBean param, Map<String,Object> mp) throws Exception {
		
		Map<String,Object> result = new HashMap<String,Object>();
		
		try {
			ProgramBean programBean = new ProgramBean();
			
			BulletinCateBean bcb = new BulletinCateBean();
			
			String blUuid = "";
			String prUuid = "";
			String pgmId = "";
			
			int resultCd = 0;
			int resultSc = 0;
			
			// bulletin management get Seq
			blUuid = (String)bulletinMNGDAO.selectUUID();
			param.setBulletinMngSeq(blUuid);
			
			resultCd = bulletinMNGDAO.insertBulletinMNG(param);
			
			//category insert
			if(Integer.parseInt((String)mp.get("cateCnt")) > 0) {
				
				mp.remove("cateCnt"); // category count flag remove
				for(int i=1; i < mp.size()+1; i++) {
					
						String cateUuid = "";
						// category get Seq
						cateUuid = (String)bulletinMNGDAO.selectUUID();
						bcb.setBulletinMngSeq(blUuid);
						bcb.setBulletinCateSeq(cateUuid);
						bcb.setBulletinCateNm((String)mp.get("cate"+i));
						bcb.setSort(i);
						resultCd = bulletinMNGDAO.insertBulletinCate(bcb);
						
						if(resultCd > 0) {
							resultSc = 1;
						}else {
							resultSc = 0;
						}
		    	}
			}else {
				resultSc = 1;
			}
			
			// program insert
			if(resultSc > 0) {
				// add program get seq
				
				//for(int i =0; i < 5; i ++) {
					prUuid = (String)bulletinMNGDAO.selectUUID();
					programBean.setProgramSeq(prUuid); 
					programBean.setBulletinMngSeq(blUuid);
					pgmId = (String)bulletinMNGDAO.selectPgmId();
					
					String url = "";
					if ("BTC0000000001".equals(param.getBulletinTypeCd())) {
						url = "/internal/bulletin/bulletinBasic.do?programId=" + pgmId;
					} else if ("BTC0000000002".equals(param.getBulletinTypeCd())) {
						url = "/internal/bulletin/bulletinThumb.do?programId=" + pgmId;
					} else if ("BTC0000000003".equals(param.getBulletinTypeCd())) {
						url = "/internal/bulletin/bulletinPhoto.do?programId=" + pgmId;
					} else if ("BTC0000000004".equals(param.getBulletinTypeCd())) {
						url = "/internal/bulletin/bulletinAtch.do?programId=" + pgmId;
					} else if ("BTC0000000005".equals(param.getBulletinTypeCd())) {
						url = "/internal/bulletin/bulletinFaq.do?programId=" + pgmId;
					} else if ("BTC0000000006".equals(param.getBulletinTypeCd())) {
						url = "/internal/bulletin/bulletinCommunity.do?programId=" + pgmId;
					}

					programBean.setProgramUrl(url);
					
					programBean.setProgramId(pgmId);
					programBean.setRangeCd(param.getBulletinRangeCd());
					programBean.setProgramNm(param.getBulletinNm());
					programBean.setUseYn("Y");
					programBean.setRegUserSeq(param.getUser().getUserSeq());
					programBean.setModUserSeq(param.getUser().getUserSeq());
					resultCd = bulletinMNGDAO.insertProgram(programBean);
				//}
				
				if(resultCd > 0) {
					
					result.put("stat", messageSource.getMessage("cpes.success.code",null, "Success", localeResolver.resolveLocale(request)));
					result.put("msg", messageSource.getMessage("cpes.success.msg",null, "Success", localeResolver.resolveLocale(request)));
					
				}else {
					
					result.put("stat", messageSource.getMessage("cpes.success.error",null, "Error", localeResolver.resolveLocale(request)));
					result.put("msg", messageSource.getMessage("cpes.success.error",null, "Error", localeResolver.resolveLocale(request)));
					
				}
			}else {
				result.put("stat", messageSource.getMessage("cpes.success.error",null, "Error", localeResolver.resolveLocale(request)));
				result.put("msg", messageSource.getMessage("cpes.success.error",null, "Error", localeResolver.resolveLocale(request)));
			}
		} catch (Exception e) {
			result.put("stat", messageSource.getMessage("cpes.success.error",null, "Error", localeResolver.resolveLocale(request)));
			result.put("msg", messageSource.getMessage("cpes.success.error",null, "Error", localeResolver.resolveLocale(request)));
		}
    	
		
		return result;
    }
	
	@Override
	/**
	 * 게시판관리 삭제
	 * @param param BsnsBean
	 * @return BsnsBean
	 */
    public Map<String,Object> deleteBulletinMNG(BulletinMNGBean param) throws Exception {
    	
		Map<String,Object> result = new HashMap<String,Object>();
		BulletinCateBean bcb = new BulletinCateBean();
		
		
		try {
			
			//find menu
			int menuCnt = bulletinMNGDAO.selectMenuCnt(param);
			
			if(menuCnt == 0) {
				//delete flag Bulletin Management
	    		int resultCd = bulletinMNGDAO.deleteBulletinMNG(param);
	    		
	    		//delete category
	    		bcb.setBulletinMngSeq(param.getBulletinMngSeq());
	    		bulletinMNGDAO.deleteBulletinCate(bcb);
	    		
				if(resultCd > 0) {
					result.put("stat", "0000"); //success
					result.put("msg", "");
			        return result;
				}else {
					result.put("stat", "1111"); //fail
					result.put("msg", "");
					return result; 
				}
			}else {
				result.put("stat", "9999"); //aleady menu
				result.put("msg", "");
		        return result;
			}
    		
    		
    		
	        
    	} catch (Exception e) {
			result.put("stat", "1111");
			result.put("msg", e.getCause().getMessage());
			return result;   		
    	}
		
		
    }
	
	@Override
	/**
	 * 게시판관리 수정
	 * @param param BsnsBean
	 * @return BsnsBean
	 */
    public Map<String,Object> updateBulletinMNG(BulletinMNGBean param,Map<String,Object> mp) throws Exception {
    	
		Map<String,Object> result = new HashMap<String,Object>();
		
		Map<String,Object> cateKey = new HashMap<String,Object>();
		
		List<String> cateList = new ArrayList<>();
		
		BulletinCateBean bcb = new BulletinCateBean();
		
		//String blUuid = "";
		//String prUuid = "";
		
		int resultCd = 0;
		int resultSc = 0;
		
		
		resultCd = bulletinMNGDAO.updateBulletinMNG(param);
		
		bcb.setBulletinMngSeq(param.getBulletinMngSeq());
		bulletinMNGDAO.deleteBulletinCate(bcb);
		
		//category insert
		if(Integer.parseInt((String)mp.get("cateCnt")) > 0) {
			
			mp.remove("cateCnt"); // category count flag remove
			for(int i=1; i < mp.size()+1; i++) {
				
					String cateUuid = "";
					// category get Seq
					cateUuid = (String)bulletinMNGDAO.selectUUID();
					bcb.setBulletinMngSeq(param.getBulletinMngSeq());
					bcb.setBulletinCateSeq(cateUuid);
					bcb.setBulletinCateNm((String)mp.get("cate"+i));
					bcb.setSort(i);
					resultCd = bulletinMNGDAO.insertBulletinCate(bcb);
					
					if(resultCd > 0) {
						resultSc = 1;
					}else {
						resultSc = 0;
					}
	    	}
		}else {
			resultSc = 1;
		}
		
		if(resultSc > 0) {
			result.put("stat", "0000"); //success
			result.put("msg", "");
		}else {
			result.put("stat", "1111"); //fail
			result.put("msg", "");
		}
		
		return result;
    }
	
	@Override
	/**
	 * 게시판관리 상세
	 * @param param BsnsBean
	 * @return BsnsBean
	 */
    public BulletinMNGBean selectBulletinMngDtl(BulletinMNGBean param) throws Exception {
    	
		BulletinMNGBean bulletinMNGBean = new BulletinMNGBean();
		
		bulletinMNGBean = bulletinMNGDAO.selectBulletinMngDtl(param);

		//bulletinMNGBean.setList(list);
		return bulletinMNGBean;
    }
	
	@Override
	/**
	 * 게시판관리 카테고리 리스트
	 * @param param BsnsBean
	 * @return BsnsBean
	 */
    public BulletinCateBean selectBulletinCateList(BulletinMNGBean param) throws Exception {
		BulletinCateBean bcb = new BulletinCateBean();
		
		List<BulletinCateBean> list = bulletinMNGDAO.selectBulletinCateList(param);

		bcb.setList(list);
		
		return bcb;
    }
	
	@Override
	/**
	 * 게시판관리 상세
	 * @param param BsnsBean
	 * @return BsnsBean
	 */	
	public BulletinMNGBean selectBulletinMngByProgramId(BulletinMNGBean param) throws Exception {
		return bulletinMNGDAO.selectBulletinMngByProgramId(param);
	}
}
