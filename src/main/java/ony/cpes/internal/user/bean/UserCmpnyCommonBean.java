package ony.cpes.internal.user.bean;

import java.util.ArrayList;
import java.util.List;

import ony.cmm.common.bean.CommonBean;

/**
 * User Application Bean
 * @author onycom
 * @since
 * @version 1.0
 * @see
 *
 * <pre>
 * << (Modification Information) >>
 *
 *  Modify Date   	Modifier 	Description
 *  ------------- 	-------- 	---------------------------
 *  2019.11.07 		Joo
 *
 * </pre>
 */
public class UserCmpnyCommonBean extends CommonBean{

	private static final long serialVersionUID = 4979179976898050104L;
	
	//0. System Parameter
	private String sysLangCd				= "";
	
	//1. Base Parameter
	private String	userSeq					= "";
	private String	resumeSeq				= "";
	private String	vacancySeq				= "";
	private String	compnySeq				= "";
	private String	vacancyTitle			= "";
	
	private List<UserCmpnyCommonBean> list;
	
	//Additional Data Parameter
	private List<String> selectedList 		= new ArrayList<String>();
	private String	vacancyYear				= "";
	
	
	
	
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
	 * @return the userSeq
	 */
	public String getUserSeq() {
		return userSeq;
	}
	/**
	 * @param userSeq the userSeq to set
	 */
	public void setUserSeq(String userSeq) {
		this.userSeq = userSeq;
	}
	/**
	 * @return the resumeSeq
	 */
	public String getResumeSeq() {
		return resumeSeq;
	}
	/**
	 * @param resumeSeq the resumeSeq to set
	 */
	public void setResumeSeq(String resumeSeq) {
		this.resumeSeq = resumeSeq;
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
	 * @return the compnySeq
	 */
	public String getCompnySeq() {
		return compnySeq;
	}
	/**
	 * @param compnySeq the compnySeq to set
	 */
	public void setCompnySeq(String compnySeq) {
		this.compnySeq = compnySeq;
	}
	/**
	 * @return the vacancyTitle
	 */
	public String getVacancyTitle() {
		return vacancyTitle;
	}
	/**
	 * @param vacancyTitle the vacancyTitle to set
	 */
	public void setVacancyTitle(String vacancyTitle) {
		this.vacancyTitle = vacancyTitle;
	}
	/**
	 * @return the list
	 */
	public List<UserCmpnyCommonBean> getList() {
		return list;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(List<UserCmpnyCommonBean> list) {
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
	 * @return the vacancyYear
	 */
	public String getVacancyYear() {
		return vacancyYear;
	}
	/**
	 * @param vacancyYear the vacancyYear to set
	 */
	public void setVacancyYear(String vacancyYear) {
		this.vacancyYear = vacancyYear;
	}
		

	
}
