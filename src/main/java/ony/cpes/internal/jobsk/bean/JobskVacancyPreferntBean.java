package ony.cpes.internal.jobsk.bean;

import java.util.ArrayList;
import java.util.List;
import ony.cmm.common.bean.CommonBean;

/**
 * JOB SEEK VACANCY PREFERENTIAL BEAN
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
 *  2019.10.28 		Joo
 *
 * </pre>
 */
public class JobskVacancyPreferntBean extends CommonBean{

	private static final long serialVersionUID = 4979179976898050104L;
	
	//0. System Parameter
	private String sysLangCd				= "";
	
	//1. Base Parameter
	private String	grpCd					= "";
	private String	dtlCd					= "";
	private String	cdEnNm					= "";
	private String	cdKhNm					= "";
	
	private List<JobskVacancyPreferntBean> list;
	
	//Additional Data Parameter
	private List<String> selectedList 		= new ArrayList<String>();
	private String	cdNm					= "";
	
	
	
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
	 * @return the grpCd
	 */
	public String getGrpCd() {
		return grpCd;
	}
	/**
	 * @param grpCd the grpCd to set
	 */
	public void setGrpCd(String grpCd) {
		this.grpCd = grpCd;
	}
	/**
	 * @return the dtlCd
	 */
	public String getDtlCd() {
		return dtlCd;
	}
	/**
	 * @param dtlCd the dtlCd to set
	 */
	public void setDtlCd(String dtlCd) {
		this.dtlCd = dtlCd;
	}
	/**
	 * @return the cdEnNm
	 */
	public String getCdEnNm() {
		return cdEnNm;
	}
	/**
	 * @param cdEnNm the cdEnNm to set
	 */
	public void setCdEnNm(String cdEnNm) {
		this.cdEnNm = cdEnNm;
	}
	/**
	 * @return the cdKhNm
	 */
	public String getCdKhNm() {
		return cdKhNm;
	}
	/**
	 * @param cdKhNm the cdKhNm to set
	 */
	public void setCdKhNm(String cdKhNm) {
		this.cdKhNm = cdKhNm;
	}
	/**
	 * @return the list
	 */
	public List<JobskVacancyPreferntBean> getList() {
		return list;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(List<JobskVacancyPreferntBean> list) {
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
	 * @return the cdNm
	 */
	public String getCdNm() {
		return cdNm;
	}
	/**
	 * @param cdNm the cdNm to set
	 */
	public void setCdNm(String cdNm) {
		this.cdNm = cdNm;
	}
	

}
