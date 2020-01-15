package ony.cpes.internal.bulletin.service;

import java.util.Map;

import ony.cpes.internal.bulletin.bean.BanWordBean;
import ony.cpes.internal.bulletin.bean.BulletinBean;

public interface BanWordService {
	/**
     * 금지어 조회
     *
     * @param param BanWordBean
     * @return BanWordBean
     */
    public BanWordBean selectBanWordList(BanWordBean param) throws Exception;
    
    /**
     * 금지어 등록
     * @param param
     * @return
     * @throws Exception
     */
    public Map<String,Object> insertBanWord(BanWordBean param) throws Exception;
    
    /**
     * 
     * @param param
     * @return
     * @throws Exception
     */
    public Map<String,Object> updateBanWord(BanWordBean param) throws Exception;
    
    /**
     * 
     * @param param
     * @return
     * @throws Exception
     */
    public Map<String,Object> deleteBanWord(BanWordBean param) throws Exception;
    

}
