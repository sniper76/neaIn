package ony.cpes.internal.vacancy.bean;

import java.util.ArrayList;
import java.util.List;
import ony.cmm.common.bean.CommonBean;

/**
 * VACANCY BEAN
 * @author Onycom
 * @since
 * @version 1.0
 * @see
 *
 * <pre>
 * << (Modification Information) >>
 *
 *  Date           	Modifier   	Description
 *  ------------- 	-------- 	---------------------------
 *  2019.11.21 		Joo
 *
 * </pre>
 */
public class VacancyLangBean extends CommonBean{

	private static final long serialVersionUID = 4979179976898050104L;
	
	//0. System Parameter
	private String sysLangCd					= "";
	
	//1. Base Parameter
	private String 	vacancySeq					= "";
	private String 	langCd						= "";
	private String 	langLvlCd					= "";
	
	private List<VacancyLangBean> list;
	
	//Additional Data Parameter
	private List<String> selectedList 		= new ArrayList<String>();
	private String 	langNm						= "";
	private String 	langLvlNm					= "";
	
	// Search Condition Parameter		

	
	
	/**
	 * @return the sysLangCd
	 */
	public String getSysLangCd() {
		return sysLangCd;
	}
	/**
	 * @param sysLangCd the sysLangCd to set
	 */
	public void setSysLangCd(String sysLangCd) {
		this.sysLangCd = sysLangCd;
	}
	/**
	 * @return the vacancySeq
	 */
	public String getVacancySeq() {
		return vacancySeq;
	}
	/**
	 * @param vacancySeq the vacancySeq to set
	 */
	public void setVacancySeq(String vacancySeq) {
		this.vacancySeq = vacancySeq;
	}
	/**
	 * @return the langCd
	 */
	public String getLangCd() {
		return langCd;
	}
	/**
	 * @param langCd the langCd to set
	 */
	public void setLangCd(String langCd) {
		this.langCd = langCd;
	}
	/**
	 * @return the langLvlCd
	 */
	public String getLangLvlCd() {
		return langLvlCd;
	}
	/**
	 * @param langLvlCd the langLvlCd to set
	 */
	public void setLangLvlCd(String langLvlCd) {
		this.langLvlCd = langLvlCd;
	}
	/**
	 * @return the list
	 */
	public List<VacancyLangBean> getList() {
		return list;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(List<VacancyLangBean> list) {
		this.list = list;
	}
	/**
	 * @return the selectedList
	 */
	public List<String> getSelectedList() {
		return selectedList;
	}
	/**
	 * @param selectedList the selectedList to set
	 */
	public void setSelectedList(List<String> selectedList) {
		this.selectedList = selectedList;
	}
	/**
	 * @return the langNm
	 */
	public String getLangNm() {
		return langNm;
	}
	/**
	 * @param langNm the langNm to set
	 */
	public void setLangNm(String langNm) {
		this.langNm = langNm;
	}
	/**
	 * @return the langLvlNm
	 */
	public String getLangLvlNm() {
		return langLvlNm;
	}
	/**
	 * @param langLvlNm the langLvlNm to set
	 */
	public void setLangLvlNm(String langLvlNm) {
		this.langLvlNm = langLvlNm;
	}
	


}
