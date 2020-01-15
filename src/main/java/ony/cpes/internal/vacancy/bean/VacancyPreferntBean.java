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
public class VacancyPreferntBean extends CommonBean{

	private static final long serialVersionUID = 4979179976898050104L;
	
	//0. System Parameter
	private String sysLangCd					= "";
	
	//1. Base Parameter
	private String 	vacancySeq					= "";
	private String 	preferntCondCd				= "";
	
	private List<VacancyPreferntBean> list;
	
	//Additional Data Parameter
	private List<String> selectedList 		= new ArrayList<String>();
	private String 	preferntCondNm				= "";

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
	 * @return the preferntCondCd
	 */
	public String getPreferntCondCd() {
		return preferntCondCd;
	}
	/**
	 * @param preferntCondCd the preferntCondCd to set
	 */
	public void setPreferntCondCd(String preferntCondCd) {
		this.preferntCondCd = preferntCondCd;
	}
	/**
	 * @return the list
	 */
	public List<VacancyPreferntBean> getList() {
		return list;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(List<VacancyPreferntBean> list) {
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
	 * @return the preferntCondNm
	 */
	public String getPreferntCondNm() {
		return preferntCondNm;
	}
	/**
	 * @param preferntCondNm the preferntCondNm to set
	 */
	public void setPreferntCondNm(String preferntCondNm) {
		this.preferntCondNm = preferntCondNm;
	}
	
	


}
