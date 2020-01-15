package ony.cpes.internal.common.bean;

import java.util.List;

import ony.cmm.common.bean.CommonBean;
import ony.cpes.internal.user.bean.UserBean;

/**
 * model for JobCenter
 * @author Onycom yhLee
 * @since 2019.10.09
 * @version 1.0
 * @see
 *
 * <pre>
 * << Modification Information >>
 *
 *  modify date           updater    description
 *  ------------- -------- ---------------------------
 *  2019.12.10 				ckw     creation
 *
 * </pre>
 */
public class JobResearchMngBean extends CommonBean{

	private static final long serialVersionUID = 4979179976898050104L;

	private int    iscoId          ;
	private String iscoCd      = "";
	private String enNm        = "";
	private String khNm        = "";
	private String upperCd     = "";
	private String cdLvl       = "";
	private String regUserSeq  = "";
	private String regUserNm   = "";
	private String regDt       = "";
	private String modUserSeq  = "";
	private String modDt       = "";
	private String useYn       = "";
	private String lvl         = "";
	private String expln       = "";
	private String cateNm      = "";
	private String occupIncKh  = "";
	private String occupIncEn  = "";
	private String occupExcKh  = "";
	private String occupExcEn  = "";
	private String noteKh      = "";
	private String noteEn      = "";
	private String defEn       = "";
	private String defKh       = "";
	private String taskEn      = "";
	private String taskKh      = "";
	private String jobCateCd   = "";
	private String oneDepth    = "";
	private String twoDepth    = "";
	private String threeDepth  = "";
	private String fourDepth   = "";
	
	
    private List<JobResearchMngBean> list;
    
    private UserBean user = new UserBean();
    
    
    public List<JobResearchMngBean> getList() {
		return list;
	}
	public void setList(List<JobResearchMngBean> list) {
		this.list = list;
	}
	/**
	 * @return the jobCateCd
	 */
	public String getJobCateCd() {
		return jobCateCd;
	}
	/**
	 * @param jobCateCd the jobCateCd to set
	 */
	public void setJobCateCd(String jobCateCd) {
		this.jobCateCd = jobCateCd;
	}
	/**
	 * @return the useYn
	 */
	public String getUseYn() {
		return useYn;
	}
	/**
	 * @param useYn the useYn to set
	 */
	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}
	/**
	 * @return the user
	 */
	public UserBean getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(UserBean user) {
		this.user = user;
	}
	/**
	 * @return the oneDepth
	 */
	public String getOneDepth() {
		return oneDepth;
	}
	/**
	 * @param oneDepth the oneDepth to set
	 */
	public void setOneDepth(String oneDepth) {
		this.oneDepth = oneDepth;
	}
	/**
	 * @return the twoDepth
	 */
	public String getTwoDepth() {
		return twoDepth;
	}
	/**
	 * @param twoDepth the twoDepth to set
	 */
	public void setTwoDepth(String twoDepth) {
		this.twoDepth = twoDepth;
	}
	/**
	 * @return the threeDepth
	 */
	public String getThreeDepth() {
		return threeDepth;
	}
	/**
	 * @param threeDepth the threeDepth to set
	 */
	public void setThreeDepth(String threeDepth) {
		this.threeDepth = threeDepth;
	}
	/**
	 * @return the fourDepth
	 */
	public String getFourDepth() {
		return fourDepth;
	}
	/**
	 * @param fourDepth the fourDepth to set
	 */
	public void setFourDepth(String fourDepth) {
		this.fourDepth = fourDepth;
	}
	/**
	 * @return the iscoId
	 */
	public int getIscoId() {
		return iscoId;
	}
	/**
	 * @param iscoId the iscoId to set
	 */
	public void setIscoId(int iscoId) {
		this.iscoId = iscoId;
	}
	/**
	 * @return the iscoCd
	 */
	public String getIscoCd() {
		return iscoCd;
	}
	/**
	 * @param iscoCd the iscoCd to set
	 */
	public void setIscoCd(String iscoCd) {
		this.iscoCd = iscoCd;
	}
	/**
	 * @return the enNm
	 */
	public String getEnNm() {
		return enNm;
	}
	/**
	 * @param enNm the enNm to set
	 */
	public void setEnNm(String enNm) {
		this.enNm = enNm;
	}
	/**
	 * @return the khNm
	 */
	public String getKhNm() {
		return khNm;
	}
	/**
	 * @param khNm the khNm to set
	 */
	public void setKhNm(String khNm) {
		this.khNm = khNm;
	}
	/**
	 * @return the upperCd
	 */
	public String getUpperCd() {
		return upperCd;
	}
	/**
	 * @param upperCd the upperCd to set
	 */
	public void setUpperCd(String upperCd) {
		this.upperCd = upperCd;
	}
	/**
	 * @return the cdLvl
	 */
	public String getCdLvl() {
		return cdLvl;
	}
	/**
	 * @param cdLvl the cdLvl to set
	 */
	public void setCdLvl(String cdLvl) {
		this.cdLvl = cdLvl;
	}
	/**
	 * @return the regUserSeq
	 */
	public String getRegUserSeq() {
		return regUserSeq;
	}
	/**
	 * @param regUserSeq the regUserSeq to set
	 */
	public void setRegUserSeq(String regUserSeq) {
		this.regUserSeq = regUserSeq;
	}
	/**
	 * @return the regDt
	 */
	public String getRegDt() {
		return regDt;
	}
	/**
	 * @param regDt the regDt to set
	 */
	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}
	/**
	 * @return the modUserSeq
	 */
	public String getModUserSeq() {
		return modUserSeq;
	}
	/**
	 * @param modUserSeq the modUserSeq to set
	 */
	public void setModUserSeq(String modUserSeq) {
		this.modUserSeq = modUserSeq;
	}
	/**
	 * @return the modDt
	 */
	public String getModDt() {
		return modDt;
	}
	/**
	 * @param modDt the modDt to set
	 */
	public void setModDt(String modDt) {
		this.modDt = modDt;
	}
	/**
	 * @return the lvl
	 */
	public String getLvl() {
		return lvl;
	}
	/**
	 * @param lvl the lvl to set
	 */
	public void setLvl(String lvl) {
		this.lvl = lvl;
	}
	/**
	 * @return the expln
	 */
	public String getExpln() {
		return expln;
	}
	/**
	 * @param expln the expln to set
	 */
	public void setExpln(String expln) {
		this.expln = expln;
	}
	/**
	 * @return the cateNm
	 */
	public String getCateNm() {
		return cateNm;
	}
	/**
	 * @param cateNm the cateNm to set
	 */
	public void setCateNm(String cateNm) {
		this.cateNm = cateNm;
	}
	/**
	 * @return the occupIncKh
	 */
	public String getOccupIncKh() {
		return occupIncKh;
	}
	/**
	 * @param occupIncKh the occupIncKh to set
	 */
	public void setOccupIncKh(String occupIncKh) {
		this.occupIncKh = occupIncKh;
	}
	/**
	 * @return the occupIncEn
	 */
	public String getOccupIncEn() {
		return occupIncEn;
	}
	/**
	 * @param occupIncEn the occupIncEn to set
	 */
	public void setOccupIncEn(String occupIncEn) {
		this.occupIncEn = occupIncEn;
	}
	/**
	 * @return the occupExcKh
	 */
	public String getOccupExcKh() {
		return occupExcKh;
	}
	/**
	 * @param occupExcKh the occupExcKh to set
	 */
	public void setOccupExcKh(String occupExcKh) {
		this.occupExcKh = occupExcKh;
	}
	/**
	 * @return the occupExcEn
	 */
	public String getOccupExcEn() {
		return occupExcEn;
	}
	/**
	 * @param occupExcEn the occupExcEn to set
	 */
	public void setOccupExcEn(String occupExcEn) {
		this.occupExcEn = occupExcEn;
	}
	/**
	 * @return the noteKh
	 */
	public String getNoteKh() {
		return noteKh;
	}
	/**
	 * @param noteKh the noteKh to set
	 */
	public void setNoteKh(String noteKh) {
		this.noteKh = noteKh;
	}
	/**
	 * @return the noteEn
	 */
	public String getNoteEn() {
		return noteEn;
	}
	/**
	 * @param noteEn the noteEn to set
	 */
	public void setNoteEn(String noteEn) {
		this.noteEn = noteEn;
	}
	/**
	 * @return the defEn
	 */
	public String getDefEn() {
		return defEn;
	}
	/**
	 * @param defEn the defEn to set
	 */
	public void setDefEn(String defEn) {
		this.defEn = defEn;
	}
	/**
	 * @return the defKh
	 */
	public String getDefKh() {
		return defKh;
	}
	/**
	 * @param defKh the defKh to set
	 */
	public void setDefKh(String defKh) {
		this.defKh = defKh;
	}
	/**
	 * @return the taskEn
	 */
	public String getTaskEn() {
		return taskEn;
	}
	/**
	 * @param taskEn the taskEn to set
	 */
	public void setTaskEn(String taskEn) {
		this.taskEn = taskEn;
	}
	/**
	 * @return the taskKh
	 */
	public String getTaskKh() {
		return taskKh;
	}
	/**
	 * @param taskKh the taskKh to set
	 */
	public void setTaskKh(String taskKh) {
		this.taskKh = taskKh;
	}
	/**
	 * @return the regUserNm
	 */
	public String getRegUserNm() {
		return regUserNm;
	}
	/**
	 * @param regUserNm the regUserNm to set
	 */
	public void setRegUserNm(String regUserNm) {
		this.regUserNm = regUserNm;
	}
	
	
	
}
