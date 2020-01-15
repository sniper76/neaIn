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
public class VacancyLocBean extends CommonBean{

	private static final long serialVersionUID = 4979179976898050104L;
	
	//0. System Parameter
	private String sysLangCd					= "";
	
	//1. Base Parameter
	private String 	vacancySeq					= "";
	private String 	vacancyNo					= "";
	private String 	AddrCd						= "";
	private String 	AddrFullCd					= "";
	private String 	AddrFullNm					= "";
	
	private List<VacancyLocBean> list;
	
	//Additional Data Parameter
	private List<String> selectedList 		= new ArrayList<String>();
	
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
	 * @return the vacancyNo
	 */
	public String getVacancyNo() {
		return vacancyNo;
	}

	/**
	 * @param vacancyNo the vacancyNo to set
	 */
	public void setVacancyNo(String vacancyNo) {
		this.vacancyNo = vacancyNo;
	}

	/**
	 * @return the addrCd
	 */
	public String getAddrCd() {
		return AddrCd;
	}

	/**
	 * @param addrCd the addrCd to set
	 */
	public void setAddrCd(String addrCd) {
		AddrCd = addrCd;
	}

	/**
	 * @return the addrFullCd
	 */
	public String getAddrFullCd() {
		return AddrFullCd;
	}

	/**
	 * @param addrFullCd the addrFullCd to set
	 */
	public void setAddrFullCd(String addrFullCd) {
		AddrFullCd = addrFullCd;
	}

	/**
	 * @return the addrFullNm
	 */
	public String getAddrFullNm() {
		return AddrFullNm;
	}

	/**
	 * @param addrFullNm the addrFullNm to set
	 */
	public void setAddrFullNm(String addrFullNm) {
		AddrFullNm = addrFullNm;
	}

	/**
	 * @return the list
	 */
	public List<VacancyLocBean> getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(List<VacancyLocBean> list) {
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


}
