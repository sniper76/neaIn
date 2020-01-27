package ony.cpes.internal.common.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import ony.cpes.internal.bulletin.bean.BanWordBean;
import ony.cpes.internal.common.bean.SynonymMngBean;

public interface SnonymMngService {
	
	/**
	 * selectSynonymMngList
	 * @param param
	 * @return
	 * @throws Exception
	 */
    public SynonymMngBean selectSynonymMngList(SynonymMngBean param) throws Exception;
    
    /**
     * insertSynonymMng
     * @param param
     * @return
     * @throws Exception
     */
    public Map<String,Object> insertSynonymMng(HttpServletRequest request,SynonymMngBean param) throws Exception;
    
    /**
     * deleteSynonymMng
     * @param request
     * @param param
     * @return
     * @throws Exception
     */
    public Map<String,Object> deleteSynonymMng(HttpServletRequest request,SynonymMngBean param) throws Exception;
    
    /**
     * updateSynonymMng
     * @param request
     * @param param
     * @return
     * @throws Exception
     */
    public Map<String,Object> updateSynonymMng(HttpServletRequest request,SynonymMngBean param) throws Exception;
    

}
