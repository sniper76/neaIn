package ony.cpes.internal.trnng.bean;

import java.util.ArrayList;
import java.util.List;

import ony.cmm.common.bean.CommonBean;
import ony.cpes.internal.user.bean.UserBean;


public class EduTrnngMngBean extends CommonBean{
	
	private String eduTrnngSeq;
	private String eduTrnngSubSeq;
	private String eduTrnngLogSeq;
	private String eduTrnngSubLogSeq;

	private String insttSeq;
	private String insttLogSeq;
	
	private String eduTrnngNm;
	private String eduBgnDt;
	private String eduEndDt;
	private String sponsor;
	private String recurmtBgnDt;
	private String recurmtEndDt;
	private String eduDura;
	private String dayTime;
	private String jcUserSeq;
	private String cateCd;
	private String procProgramStudy;
	private String degreeAwards;
	private String prospectOccupCate;
	private String tuition;
	private String eduTarget;
	private String admssCriteria;
	private String content;
	private String enrolMethod;
	private String sign;
	private String eduProvd;
	private String fileGrpSeqEdu;
	private String insttNm;
	
	private String insttNmEn;
	private String insttNmKh;

	private String insttOwnerNm;
	private String insttRegNum;
	private String insttAddrCd;
	private String insttContent;
	private String insttMngerNm;
	private String insttOfficeTel;
	private String insttCell;
	private String insttFax;
	private String insttEmail;
	private String insttWebsite;
	private String fileGrpSeqInstt;
	
	private String userSeq;
	private String userAuthCd;
	private String userStsCd;
	private String userNm;
	private String userEmail;
	private String userCell;
	private String birth;
	private String age;
	private String genderCd;
	private String jobskStsCd;
	private String useYn;
	private String delYn;
	private String regUserSeq;
	private String regDt;
	private String modUserSeq;
	private String modDt;
	private String regUserNm;
	private String modUserNm;

	private String jcCd;
	private String trnngNatnexpDivCd;
	private String eduDivCd;
	private String insttTypeCd;
	private String insttStsCd;
	private String insttOwnershipCd;
	private String insttOwnerCd;
	
	private String pcTypeCd;
	private String tvcDivCd;
	private String hgepDivCd;
	private String recrumtStsCd;
	
	private String programCorsTypeCd;
	private String major1DepthCd;
	private String major2DepthCd;
	private String skillJobProgramCorsCd;
	private String highGenrlEduCorsCd;
	private String neaEduDivCd;
	
	private String addrCd;
	private String provcCd;

	private String jcAgreeDt;
	private String jcRejectDt;
	
	private String jcUserNm;
	
	private String periodKeyword;
	
	private String timeWeek;
	private String jcAgreeStsCd;

	private String dataStsCd;

	private String teacherNm;
	private String teacherNm1;
	private String teacherNm2;
	private String teacher1Career;
	private String teacher2Career;
	private String lecturePhotoFileGrpSeq;
	private String teacher1PhotoFileGrpSeq;
	private String teacher2PhotoFileGrpSeq;
	private String area;
	private String googleMapLink;
	private String mngerNm;
	private String cell;
	private String email;

	private String addrNm;
	private String addrFullCd;
	private String addrFullNm;
	private String addrDtl;
	private String teachDt;
	private String teachBgnHour;
	private String teachBgnMinute;
	private String teachBgnAmpm;
	private String teachEndHour;
	private String teachEndMinute;
	private String teachEndAmpm;
	private String curricl;
	private String matr;
	private String addrCd2Depth;
	
	private String fileGrpSeq;
	
	private String lectureCommonUploadResult = "";
	private String teachOneCommonUploadResult = "";
	private String teachTwoCommonUploadResult = "";
	
	private int recrumtMemb = 0;
	private int subscriberCnt = 0;
	
	private List<String> eduTrnngSeqList = new ArrayList<String>();	
	
	private List<String> subscriberUserSeqList = new ArrayList<String>();	

	private UserBean user = new UserBean();	
	
	private List<EduTrnngMngBean> list;

	/**
	 * @return the eduTrnngSeq
	 */
	public String getEduTrnngSeq() {
		return eduTrnngSeq;
	}

	/**
	 * @param eduTrnngSeq the eduTrnngSeq to set
	 */
	public void setEduTrnngSeq(String eduTrnngSeq) {
		this.eduTrnngSeq = eduTrnngSeq;
	}

	/**
	 * @return the eduTrnngNm
	 */
	public String getEduTrnngNm() {
		return eduTrnngNm;
	}

	/**
	 * @param eduTrnngNm the eduTrnngNm to set
	 */
	public void setEduTrnngNm(String eduTrnngNm) {
		this.eduTrnngNm = eduTrnngNm;
	}

	/**
	 * @return the eduBgnDt
	 */
	public String getEduBgnDt() {
		return eduBgnDt;
	}

	/**
	 * @param eduBgnDt the eduBgnDt to set
	 */
	public void setEduBgnDt(String eduBgnDt) {
		this.eduBgnDt = eduBgnDt;
	}

	/**
	 * @return the eduEndDt
	 */
	public String getEduEndDt() {
		return eduEndDt;
	}

	/**
	 * @param eduEndDt the eduEndDt to set
	 */
	public void setEduEndDt(String eduEndDt) {
		this.eduEndDt = eduEndDt;
	}

	/**
	 * @return the sponsor
	 */
	public String getSponsor() {
		return sponsor;
	}

	/**
	 * @param sponsor the sponsor to set
	 */
	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}

	/**
	 * @return the recurmtBgnDt
	 */
	public String getRecurmtBgnDt() {
		return recurmtBgnDt;
	}

	/**
	 * @param recurmtBgnDt the recurmtBgnDt to set
	 */
	public void setRecurmtBgnDt(String recurmtBgnDt) {
		this.recurmtBgnDt = recurmtBgnDt;
	}

	/**
	 * @return the recurmtEndDt
	 */
	public String getRecurmtEndDt() {
		return recurmtEndDt;
	}

	/**
	 * @param recurmtEndDt the recurmtEndDt to set
	 */
	public void setRecurmtEndDt(String recurmtEndDt) {
		this.recurmtEndDt = recurmtEndDt;
	}

	/**
	 * @return the eduDura
	 */
	public String getEduDura() {
		return eduDura;
	}

	/**
	 * @param eduDura the eduDura to set
	 */
	public void setEduDura(String eduDura) {
		this.eduDura = eduDura;
	}

	/**
	 * @return the dayTime
	 */
	public String getDayTime() {
		return dayTime;
	}

	/**
	 * @param dayTime the dayTime to set
	 */
	public void setDayTime(String dayTime) {
		this.dayTime = dayTime;
	}

	/**
	 * @return the provcCd
	 */
	public String getProvcCd() {
		return provcCd;
	}

	/**
	 * @param provcCd the provcCd to set
	 */
	public void setProvcCd(String provcCd) {
		this.provcCd = provcCd;
	}
	
	/**
	 * @return the jcUserSeq
	 */
	public String getJcUserSeq() {
		return jcUserSeq;
	}

	/**
	 * @param jcUserSeq the jcUserSeq to set
	 */
	public void setJcUserSeq(String jcUserSeq) {
		this.jcUserSeq = jcUserSeq;
	}

	/**
	 * @return the cateCd
	 */
	public String getCateCd() {
		return cateCd;
	}

	/**
	 * @param cateCd the cateCd to set
	 */
	public void setCateCd(String cateCd) {
		this.cateCd = cateCd;
	}

	/**
	 * @return the procProgramStudy
	 */
	public String getProcProgramStudy() {
		return procProgramStudy;
	}

	/**
	 * @param procProgramStudy the procProgramStudy to set
	 */
	public void setProcProgramStudy(String procProgramStudy) {
		this.procProgramStudy = procProgramStudy;
	}

	/**
	 * @return the degreeAwards
	 */
	public String getDegreeAwards() {
		return degreeAwards;
	}

	/**
	 * @param degreeAwards the degreeAwards to set
	 */
	public void setDegreeAwards(String degreeAwards) {
		this.degreeAwards = degreeAwards;
	}

	/**
	 * @return the prospectOccupCate
	 */
	public String getProspectOccupCate() {
		return prospectOccupCate;
	}

	/**
	 * @param prospectOccupCate the prospectOccupCate to set
	 */
	public void setProspectOccupCate(String prospectOccupCate) {
		this.prospectOccupCate = prospectOccupCate;
	}

	/**
	 * @return the tuition
	 */
	public String getTuition() {
		return tuition;
	}

	/**
	 * @param tuition the tuition to set
	 */
	public void setTuition(String tuition) {
		this.tuition = tuition;
	}

	/**
	 * @return the eduTrnngSubSeq
	 */
	public String getEduTrnngSubSeq() {
		return eduTrnngSubSeq;
	}

	/**
	 * @param eduTrnngSubSeq the eduTrnngSubSeq to set
	 */
	public void setEduTrnngSubSeq(String eduTrnngSubSeq) {
		this.eduTrnngSubSeq = eduTrnngSubSeq;
	}

	/**
	 * @return the eduTarget
	 */
	public String getEduTarget() {
		return eduTarget;
	}

	/**
	 * @param eduTarget the eduTarget to set
	 */
	public void setEduTarget(String eduTarget) {
		this.eduTarget = eduTarget;
	}

	/**
	 * @return the admssCriteria
	 */
	public String getAdmssCriteria() {
		return admssCriteria;
	}

	/**
	 * @param admssCriteria the admssCriteria to set
	 */
	public void setAdmssCriteria(String admssCriteria) {
		this.admssCriteria = admssCriteria;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the enrolMethod
	 */
	public String getEnrolMethod() {
		return enrolMethod;
	}

	/**
	 * @param enrolMethod the enrolMethod to set
	 */
	public void setEnrolMethod(String enrolMethod) {
		this.enrolMethod = enrolMethod;
	}

	/**
	 * @return the sign
	 */
	public String getSign() {
		return sign;
	}

	/**
	 * @param sign the sign to set
	 */
	public void setSign(String sign) {
		this.sign = sign;
	}

	/**
	 * @return the eduProvd
	 */
	public String getEduProvd() {
		return eduProvd;
	}

	/**
	 * @param eduProvd the eduProvd to set
	 */
	public void setEduProvd(String eduProvd) {
		this.eduProvd = eduProvd;
	}

	/**
	 * @return the fileGrpSeqEdu
	 */
	public String getFileGrpSeqEdu() {
		return fileGrpSeqEdu;
	}

	/**
	 * @param fileGrpSeqEdu the fileGrpSeqEdu to set
	 */
	public void setFileGrpSeqEdu(String fileGrpSeqEdu) {
		this.fileGrpSeqEdu = fileGrpSeqEdu;
	}

	/**
	 * @return the programCorsTypeCd
	 */
	public String getProgramCorsTypeCd() {
		return programCorsTypeCd;
	}

	/**
	 * @param programCorsTypeCd the programCorsTypeCd to set
	 */
	public void setProgramCorsTypeCd(String programCorsTypeCd) {
		this.programCorsTypeCd = programCorsTypeCd;
	}

	/**
	 * @return the major1DepthCd
	 */
	public String getMajor1DepthCd() {
		return major1DepthCd;
	}

	/**
	 * @param major1DepthCd the major1DepthCd to set
	 */
	public void setMajor1DepthCd(String major1DepthCd) {
		this.major1DepthCd = major1DepthCd;
	}

	/**
	 * @return the major2DepthCd
	 */
	public String getMajor2DepthCd() {
		return major2DepthCd;
	}

	/**
	 * @param major2DepthCd the major2DepthCd to set
	 */
	public void setMajor2DepthCd(String major2DepthCd) {
		this.major2DepthCd = major2DepthCd;
	}

	/**
	 * @return the skillJobProgramCorsCd
	 */
	public String getSkillJobProgramCorsCd() {
		return skillJobProgramCorsCd;
	}

	/**
	 * @param skillJobProgramCorsCd the skillJobProgramCorsCd to set
	 */
	public void setSkillJobProgramCorsCd(String skillJobProgramCorsCd) {
		this.skillJobProgramCorsCd = skillJobProgramCorsCd;
	}

	/**
	 * @return the highGenrlEduCorsCd
	 */
	public String getHighGenrlEduCorsCd() {
		return highGenrlEduCorsCd;
	}

	/**
	 * @param highGenrlEduCorsCd the highGenrlEduCorsCd to set
	 */
	public void setHighGenrlEduCorsCd(String highGenrlEduCorsCd) {
		this.highGenrlEduCorsCd = highGenrlEduCorsCd;
	}

	/**
	 * @return the neaEduDivCd
	 */
	public String getNeaEduDivCd() {
		return neaEduDivCd;
	}

	/**
	 * @param neaEduDivCd the neaEduDivCd to set
	 */
	public void setNeaEduDivCd(String neaEduDivCd) {
		this.neaEduDivCd = neaEduDivCd;
	}
	
	/**
	 * @return the insttSeq
	 */
	public String getInsttSeq() {
		return insttSeq;
	}

	/**
	 * @param insttSeq the insttSeq to set
	 */
	public void setInsttSeq(String insttSeq) {
		this.insttSeq = insttSeq;
	}

	/**
	 * @return the insttNm
	 */
	public String getInsttNm() {
		return insttNm;
	}

	/**
	 * @param insttNm the insttNm to set
	 */
	public void setInsttNm(String insttNm) {
		this.insttNm = insttNm;
	}

	/**
	 * @return the insttOwnerNm
	 */
	public String getInsttOwnerNm() {
		return insttOwnerNm;
	}

	/**
	 * @param insttOwnerNm the insttOwnerNm to set
	 */
	public void setInsttOwnerNm(String insttOwnerNm) {
		this.insttOwnerNm = insttOwnerNm;
	}

	/**
	 * @return the insttRegNum
	 */
	public String getInsttRegNum() {
		return insttRegNum;
	}

	/**
	 * @param insttRegNum the insttRegNum to set
	 */
	public void setInsttRegNum(String insttRegNum) {
		this.insttRegNum = insttRegNum;
	}

	/**
	 * @return the insttAddrCd
	 */
	public String getInsttAddrCd() {
		return insttAddrCd;
	}

	/**
	 * @param insttAddrCd the insttAddrCd to set
	 */
	public void setInsttAddrCd(String insttAddrCd) {
		this.insttAddrCd = insttAddrCd;
	}

	/**
	 * @return the insttContent
	 */
	public String getInsttContent() {
		return insttContent;
	}

	/**
	 * @param insttContent the insttContent to set
	 */
	public void setInsttContent(String insttContent) {
		this.insttContent = insttContent;
	}

	/**
	 * @return the insttMngerNm
	 */
	public String getInsttMngerNm() {
		return insttMngerNm;
	}

	/**
	 * @param insttMngerNm the insttMngerNm to set
	 */
	public void setInsttMngerNm(String insttMngerNm) {
		this.insttMngerNm = insttMngerNm;
	}

	/**
	 * @return the insttOfficeTel
	 */
	public String getInsttOfficeTel() {
		return insttOfficeTel;
	}

	/**
	 * @param insttOfficeTel the insttOfficeTel to set
	 */
	public void setInsttOfficeTel(String insttOfficeTel) {
		this.insttOfficeTel = insttOfficeTel;
	}

	/**
	 * @return the insttCell
	 */
	public String getInsttCell() {
		return insttCell;
	}

	/**
	 * @param insttCell the insttCell to set
	 */
	public void setInsttCell(String insttCell) {
		this.insttCell = insttCell;
	}

	/**
	 * @return the insttFax
	 */
	public String getInsttFax() {
		return insttFax;
	}

	/**
	 * @param insttFax the insttFax to set
	 */
	public void setInsttFax(String insttFax) {
		this.insttFax = insttFax;
	}

	/**
	 * @return the insttEmail
	 */
	public String getInsttEmail() {
		return insttEmail;
	}

	/**
	 * @param insttEmail the insttEmail to set
	 */
	public void setInsttEmail(String insttEmail) {
		this.insttEmail = insttEmail;
	}

	/**
	 * @return the insttWebsite
	 */
	public String getInsttWebsite() {
		return insttWebsite;
	}

	/**
	 * @param insttWebsite the insttWebsite to set
	 */
	public void setInsttWebsite(String insttWebsite) {
		this.insttWebsite = insttWebsite;
	}

	/**
	 * @return the fileGrpSeqInstt
	 */
	public String getFileGrpSeqInstt() {
		return fileGrpSeqInstt;
	}

	/**
	 * @param fileGrpSeqInstt the fileGrpSeqInstt to set
	 */
	public void setFileGrpSeqInstt(String fileGrpSeqInstt) {
		this.fileGrpSeqInstt = fileGrpSeqInstt;
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
	 * @return the userAuthCd
	 */
	public String getUserAuthCd() {
		return userAuthCd;
	}

	/**
	 * @param userAuthCd the userAuthCd to set
	 */
	public void setUserAuthCd(String userAuthCd) {
		this.userAuthCd = userAuthCd;
	}

	/**
	 * @return the userStsCd
	 */
	public String getUserStsCd() {
		return userStsCd;
	}

	/**
	 * @param userStsCd the userStsCd to set
	 */
	public void setUserStsCd(String userStsCd) {
		this.userStsCd = userStsCd;
	}

	/**
	 * @return the userNm
	 */
	public String getUserNm() {
		return userNm;
	}

	/**
	 * @param userNm the userNm to set
	 */
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}

	/**
	 * @return the userEmail
	 */
	public String getUserEmail() {
		return userEmail;
	}

	/**
	 * @param userEmail the userEmail to set
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
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
	 * @return the delYn
	 */
	public String getDelYn() {
		return delYn;
	}

	/**
	 * @param delYn the delYn to set
	 */
	public void setDelYn(String delYn) {
		this.delYn = delYn;
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
	 * @return the trnngNatnexpDivCd
	 */
	public String getTrnngNatnexpDivCd() {
		return trnngNatnexpDivCd;
	}

	/**
	 * @param trnngNatnexpDivCd the trnngNatnexpDivCd to set
	 */
	public void setTrnngNatnexpDivCd(String trnngNatnexpDivCd) {
		this.trnngNatnexpDivCd = trnngNatnexpDivCd;
	}

	/**
	 * @return the eduDivCd
	 */
	public String getEduDivCd() {
		return eduDivCd;
	}

	/**
	 * @param eduDivCd the eduDivCd to set
	 */
	public void setEduDivCd(String eduDivCd) {
		this.eduDivCd = eduDivCd;
	}

	/**
	 * @return the insttTypeCd
	 */
	public String getInsttTypeCd() {
		return insttTypeCd;
	}

	/**
	 * @param insttTypeCd the insttTypeCd to set
	 */
	public void setInsttTypeCd(String insttTypeCd) {
		this.insttTypeCd = insttTypeCd;
	}

	/**
	 * @return the insttStsCd
	 */
	public String getInsttStsCd() {
		return insttStsCd;
	}

	/**
	 * @param insttStsCd the insttStsCd to set
	 */
	public void setInsttStsCd(String insttStsCd) {
		this.insttStsCd = insttStsCd;
	}

	/**
	 * @return the insttOwnershipCd
	 */
	public String getInsttOwnershipCd() {
		return insttOwnershipCd;
	}

	/**
	 * @param insttOwnershipCd the insttOwnershipCd to set
	 */
	public void setInsttOwnershipCd(String insttOwnershipCd) {
		this.insttOwnershipCd = insttOwnershipCd;
	}

	/**
	 * @return the jcCd
	 */
	public String getJcCd() {
		return jcCd;
	}

	/**
	 * @param jcCd the jcCd to set
	 */
	public void setJcCd(String jcCd) {
		this.jcCd = jcCd;
	}

	/**
	 * @return the pcTypeCd
	 */
	public String getPcTypeCd() {
		return pcTypeCd;
	}

	/**
	 * @param pcTypeCd the pcTypeCd to set
	 */
	public void setPcTypeCd(String pcTypeCd) {
		this.pcTypeCd = pcTypeCd;
	}

	/**
	 * @return the tvcDivCd
	 */
	public String getTvcDivCd() {
		return tvcDivCd;
	}

	/**
	 * @param tvcDivCd the tvcDivCd to set
	 */
	public void setTvcDivCd(String tvcDivCd) {
		this.tvcDivCd = tvcDivCd;
	}

	/**
	 * @return the hgepDivCd
	 */
	public String getHgepDivCd() {
		return hgepDivCd;
	}

	/**
	 * @param hgepDivCd the hgepDivCd to set
	 */
	public void setHgepDivCd(String hgepDivCd) {
		this.hgepDivCd = hgepDivCd;
	}

	/**
	 * @return the recrumtStsCd
	 */
	public String getRecrumtStsCd() {
		return recrumtStsCd;
	}

	/**
	 * @param recrumtStsCd the recrumtStsCd to set
	 */
	public void setRecrumtStsCd(String recrumtStsCd) {
		this.recrumtStsCd = recrumtStsCd;
	}

	/**
	 * @return the insttOwnerCd
	 */
	public String getInsttOwnerCd() {
		return insttOwnerCd;
	}

	/**
	 * @param insttOwnerCd the insttOwnerCd to set
	 */
	public void setInsttOwnerCd(String insttOwnerCd) {
		this.insttOwnerCd = insttOwnerCd;
	}
	/**
	 * @return the jcAgreeDt
	 */
	public String getJcAgreeDt() {
		return jcAgreeDt;
	}

	/**
	 * @param jcAgreeDt the jcAgreeDt to set
	 */
	public void setJcAgreeDt(String jcAgreeDt) {
		this.jcAgreeDt = jcAgreeDt;
	}

	/**
	 * @return the jcRejectDt
	 */
	public String getJcRejectDt() {
		return jcRejectDt;
	}

	/**
	 * @param jcRejectDt the jcRejectDt to set
	 */
	public void setJcRejectDt(String jcRejectDt) {
		this.jcRejectDt = jcRejectDt;
	}	
	
	/**
	 * @return the jcUserNm
	 */
	public String getJcUserNm() {
		return jcUserNm;
	}

	/**
	 * @param jcUserNm the jcUserNm to set
	 */
	public void setJcUserNm(String jcUserNm) {
		this.jcUserNm = jcUserNm;
	}

	/**
	 * @return the timeWeek
	 */
	public String getTimeWeek() {
		return timeWeek;
	}

	/**
	 * @param timeWeek the timeWeek to set
	 */
	public void setTimeWeek(String timeWeek) {
		this.timeWeek = timeWeek;
	}

	/**
	 * @return the jcAgreeStsCd
	 */
	public String getJcAgreeStsCd() {
		return jcAgreeStsCd;
	}

	/**
	 * @param jcAgreeStsCd the jcAgreeStsCd to set
	 */
	public void setJcAgreeStsCd(String jcAgreeStsCd) {
		this.jcAgreeStsCd = jcAgreeStsCd;
	}
	

	/**
	 * @return the insttNmEn
	 */
	public String getInsttNmEn() {
		return insttNmEn;
	}

	/**
	 * @param insttNmEn the insttNmEn to set
	 */
	public void setInsttNmEn(String insttNmEn) {
		this.insttNmEn = insttNmEn;
	}

	/**
	 * @return the insttNmKh
	 */
	public String getInsttNmKh() {
		return insttNmKh;
	}

	/**
	 * @param insttNmKh the insttNmKh to set
	 */
	public void setInsttNmKh(String insttNmKh) {
		this.insttNmKh = insttNmKh;
	}

	
	/**
	 * @return the recrumtMemb
	 */
	public int getRecrumtMemb() {
		return recrumtMemb;
	}

	/**
	 * @param recrumtMemb the recrumtMemb to set
	 */
	public void setRecrumtMemb(int recrumtMemb) {
		this.recrumtMemb = recrumtMemb;
	}

	/**
	 * @return the teacherNm
	 */
	public String getTeacherNm() {
		return teacherNm;
	}

	/**
	 * @param teacherNm the teacherNm to set
	 */
	public void setTeacherNm(String teacherNm) {
		this.teacherNm = teacherNm;
	}

	/**
	 * @return the teacherNm1
	 */
	public String getTeacherNm1() {
		return teacherNm1;
	}

	/**
	 * @param teacherNm1 the teacherNm1 to set
	 */
	public void setTeacherNm1(String teacherNm1) {
		this.teacherNm1 = teacherNm1;
	}

	/**
	 * @return the teacherNm2
	 */
	public String getTeacherNm2() {
		return teacherNm2;
	}

	/**
	 * @param teacherNm2 the teacherNm2 to set
	 */
	public void setTeacherNm2(String teacherNm2) {
		this.teacherNm2 = teacherNm2;
	}

	/**
	 * @return the teacher1Career
	 */
	public String getTeacher1Career() {
		return teacher1Career;
	}

	/**
	 * @param teacher1Career the teacher1Career to set
	 */
	public void setTeacher1Career(String teacher1Career) {
		this.teacher1Career = teacher1Career;
	}

	/**
	 * @return the teacher2Career
	 */
	public String getTeacher2Career() {
		return teacher2Career;
	}

	/**
	 * @param teacher2Career the teacher2Career to set
	 */
	public void setTeacher2Career(String teacher2Career) {
		this.teacher2Career = teacher2Career;
	}

	/**
	 * @return the lecturePhotoFileGrpSeq
	 */
	public String getLecturePhotoFileGrpSeq() {
		return lecturePhotoFileGrpSeq;
	}

	/**
	 * @param lecturePhotoFileGrpSeq the lecturePhotoFileGrpSeq to set
	 */
	public void setLecturePhotoFileGrpSeq(String lecturePhotoFileGrpSeq) {
		this.lecturePhotoFileGrpSeq = lecturePhotoFileGrpSeq;
	}

	/**
	 * @return the teacher1PhotoFileGrpSeq
	 */
	public String getTeacher1PhotoFileGrpSeq() {
		return teacher1PhotoFileGrpSeq;
	}

	/**
	 * @param teacher1PhotoFileGrpSeq the teacher1PhotoFileGrpSeq to set
	 */
	public void setTeacher1PhotoFileGrpSeq(String teacher1PhotoFileGrpSeq) {
		this.teacher1PhotoFileGrpSeq = teacher1PhotoFileGrpSeq;
	}

	/**
	 * @return the teacher2PhotoFileGrpSeq
	 */
	public String getTeacher2PhotoFileGrpSeq() {
		return teacher2PhotoFileGrpSeq;
	}

	/**
	 * @param teacher2PhotoFileGrpSeq the teacher2PhotoFileGrpSeq to set
	 */
	public void setTeacher2PhotoFileGrpSeq(String teacher2PhotoFileGrpSeq) {
		this.teacher2PhotoFileGrpSeq = teacher2PhotoFileGrpSeq;
	}

	/**
	 * @return the area
	 */
	public String getArea() {
		return area;
	}

	/**
	 * @param area the area to set
	 */
	public void setArea(String area) {
		this.area = area;
	}

	/**
	 * @return the googleMapLink
	 */
	public String getGoogleMapLink() {
		return googleMapLink;
	}

	/**
	 * @param googleMapLink the googleMapLink to set
	 */
	public void setGoogleMapLink(String googleMapLink) {
		this.googleMapLink = googleMapLink;
	}

	/**
	 * @return the mngerNm
	 */
	public String getMngerNm() {
		return mngerNm;
	}

	/**
	 * @param mngerNm the mngerNm to set
	 */
	public void setMngerNm(String mngerNm) {
		this.mngerNm = mngerNm;
	}

	/**
	 * @return the cell
	 */
	public String getCell() {
		return cell;
	}

	/**
	 * @param cell the cell to set
	 */
	public void setCell(String cell) {
		this.cell = cell;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}	

	/**
	 * @return the addrCd
	 */
	public String getAddrCd() {
		return addrCd;
	}

	/**
	 * @param addrCd the addrCd to set
	 */
	public void setAddrCd(String addrCd) {
		this.addrCd = addrCd;
	}	

	/**
	 * @return the addrNm
	 */
	public String getAddrNm() {
		return addrNm;
	}

	/**
	 * @param addrNm the addrNm to set
	 */
	public void setAddrNm(String addrNm) {
		this.addrNm = addrNm;
	}	
	
	/**
	 * @return the addrDtl
	 */
	public String getAddrDtl() {
		return addrDtl;
	}

	/**
	 * @param addrDtl the addrDtl to set
	 */
	public void setAddrDtl(String addrDtl) {
		this.addrDtl = addrDtl;
	}

	/**
	 * @return the teachDt
	 */
	public String getTeachDt() {
		return teachDt;
	}

	/**
	 * @param teachDt the teachDt to set
	 */
	public void setTeachDt(String teachDt) {
		this.teachDt = teachDt;
	}

	/**
	 * @return the teachBgnHour
	 */
	public String getTeachBgnHour() {
		return teachBgnHour;
	}

	/**
	 * @param teachBgnHour the teachBgnHour to set
	 */
	public void setTeachBgnHour(String teachBgnHour) {
		this.teachBgnHour = teachBgnHour;
	}

	/**
	 * @return the teachBgnMinute
	 */
	public String getTeachBgnMinute() {
		return teachBgnMinute;
	}

	/**
	 * @param teachBgnMinute the teachBgnMinute to set
	 */
	public void setTeachBgnMinute(String teachBgnMinute) {
		this.teachBgnMinute = teachBgnMinute;
	}

	/**
	 * @return the teachBgnAmpm
	 */
	public String getTeachBgnAmpm() {
		return teachBgnAmpm;
	}

	/**
	 * @param teachBgnAmpm the teachBgnAmpm to set
	 */
	public void setTeachBgnAmpm(String teachBgnAmpm) {
		this.teachBgnAmpm = teachBgnAmpm;
	}

	/**
	 * @return the teachEndHour
	 */
	public String getTeachEndHour() {
		return teachEndHour;
	}

	/**
	 * @param teachEndHour the teachEndHour to set
	 */
	public void setTeachEndHour(String teachEndHour) {
		this.teachEndHour = teachEndHour;
	}

	/**
	 * @return the teachEndMinute
	 */
	public String getTeachEndMinute() {
		return teachEndMinute;
	}

	/**
	 * @param teachEndMinute the teachEndMinute to set
	 */
	public void setTeachEndMinute(String teachEndMinute) {
		this.teachEndMinute = teachEndMinute;
	}

	/**
	 * @return the teachEndAmpm
	 */
	public String getTeachEndAmpm() {
		return teachEndAmpm;
	}

	/**
	 * @param teachEndAmpm the teachEndAmpm to set
	 */
	public void setTeachEndAmpm(String teachEndAmpm) {
		this.teachEndAmpm = teachEndAmpm;
	}

	/**
	 * @return the curricl
	 */
	public String getCurricl() {
		return curricl;
	}

	/**
	 * @param curricl the curricl to set
	 */
	public void setCurricl(String curricl) {
		this.curricl = curricl;
	}

	/**
	 * @return the matr
	 */
	public String getMatr() {
		return matr;
	}

	/**
	 * @param matr the matr to set
	 */
	public void setMatr(String matr) {
		this.matr = matr;
	}

	/**
	 * @return the subscriberCnt
	 */
	public int getSubscriberCnt() {
		return subscriberCnt;
	}

	/**
	 * @param subscriberCnt the subscriberCnt to set
	 */
	public void setSubscriberCnt(int subscriberCnt) {
		this.subscriberCnt = subscriberCnt;
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

	/**
	 * @return the modUserNm
	 */
	public String getModUserNm() {
		return modUserNm;
	}

	/**
	 * @param modUserNm the modUserNm to set
	 */
	public void setModUserNm(String modUserNm) {
		this.modUserNm = modUserNm;
	}
	
	/**
	 * @return the periodKeyword
	 */
	public String getPeriodKeyword() {
		return periodKeyword;
	}

	/**
	 * @param periodKeyword the periodKeyword to set
	 */
	public void setPeriodKeyword(String periodKeyword) {
		this.periodKeyword = periodKeyword;
	}	

	/**
	 * @return the fileGrpSeq
	 */
	public String getFileGrpSeq() {
		return fileGrpSeq;
	}

	/**
	 * @param fileGrpSeq the fileGrpSeq to set
	 */
	public void setFileGrpSeq(String fileGrpSeq) {
		this.fileGrpSeq = fileGrpSeq;
	}
	
	/**
	 * @return the eduTrnngLogSeq
	 */
	public String getEduTrnngLogSeq() {
		return eduTrnngLogSeq;
	}

	/**
	 * @param eduTrnngLogSeq the eduTrnngLogSeq to set
	 */
	public void setEduTrnngLogSeq(String eduTrnngLogSeq) {
		this.eduTrnngLogSeq = eduTrnngLogSeq;
	}

	/**
	 * @return the eduTrnngSubLogSeq
	 */
	public String getEduTrnngSubLogSeq() {
		return eduTrnngSubLogSeq;
	}

	/**
	 * @param eduTrnngSubLogSeq the eduTrnngSubLogSeq to set
	 */
	public void setEduTrnngSubLogSeq(String eduTrnngSubLogSeq) {
		this.eduTrnngSubLogSeq = eduTrnngSubLogSeq;
	}
	
	/**
	 * @return the insttLogSeq
	 */
	public String getInsttLogSeq() {
		return insttLogSeq;
	}

	/**
	 * @param insttLogSeq the insttLogSeq to set
	 */
	public void setInsttLogSeq(String insttLogSeq) {
		this.insttLogSeq = insttLogSeq;
	}

	/**
	 * @return the dataStsCd
	 */
	public String getDataStsCd() {
		return dataStsCd;
	}

	/**
	 * @param dataStsCd the dataStsCd to set
	 */
	public void setDataStsCd(String dataStsCd) {
		this.dataStsCd = dataStsCd;
	}

	/**
	 * @return the userCell
	 */
	public String getUserCell() {
		return userCell;
	}

	/**
	 * @param userCell the userCell to set
	 */
	public void setUserCell(String userCell) {
		this.userCell = userCell;
	}

	/**
	 * @return the birth
	 */
	public String getBirth() {
		return birth;
	}

	/**
	 * @param birth the birth to set
	 */
	public void setBirth(String birth) {
		this.birth = birth;
	}

	/**
	 * @return the age
	 */
	public String getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(String age) {
		this.age = age;
	}

	/**
	 * @return the genderCd
	 */
	public String getGenderCd() {
		return genderCd;
	}

	/**
	 * @param genderCd the genderCd to set
	 */
	public void setGenderCd(String genderCd) {
		this.genderCd = genderCd;
	}
	
	/**
	 * @return the jobskStsCd
	 */
	public String getJobskStsCd() {
		return jobskStsCd;
	}

	/**
	 * @param jobskStsCd the jobskStsCd to set
	 */
	public void setJobskStsCd(String jobskStsCd) {
		this.jobskStsCd = jobskStsCd;
	}
	

	/**
	 * @return the addrCd2Depth
	 */
	public String getAddrCd2Depth() {
		return addrCd2Depth;
	}

	/**
	 * @param addrCd2Depth the addrCd2Depth to set
	 */
	public void setAddrCd2Depth(String addrCd2Depth) {
		this.addrCd2Depth = addrCd2Depth;
	}
	
	/**
	 * @return the addrFullNm
	 */
	public String getAddrFullNm() {
		return addrFullNm;
	}

	/**
	 * @param addrFullNm the addrFullNm to set
	 */
	public void setAddrFullNm(String addrFullNm) {
		this.addrFullNm = addrFullNm;
	}

	/**
	 * @return the addrFullCd
	 */
	public String getAddrFullCd() {
		return addrFullCd;
	}

	/**
	 * @param addrFullCd the addrFullCd to set
	 */
	public void setAddrFullCd(String addrFullCd) {
		this.addrFullCd = addrFullCd;
	}
	
	/**
	 * @return the eduTrnngSeqList
	 */
	public List<String> getEduTrnngSeqList() {
		return eduTrnngSeqList;
	}

	/**
	 * @param eduTrnngSeqList the eduTrnngSeqList to set
	 */
	public void setEduTrnngSeqList(List<String> eduTrnngSeqList) {
		this.eduTrnngSeqList = eduTrnngSeqList;
	}
	
	/**
	 * @return the subscriberUserSeqList
	 */
	public List<String> getSubscriberUserSeqList() {
		return subscriberUserSeqList;
	}

	/**
	 * @param subscriberUserSeqList the subscriberUserSeqList to set
	 */
	public void setSubscriberUserSeqList(List<String> subscriberUserSeqList) {
		this.subscriberUserSeqList = subscriberUserSeqList;
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
	 * @return the list
	 */
	public List<EduTrnngMngBean> getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(List<EduTrnngMngBean> list) {
		this.list = list;
	}

	/**
	 * @return the lectureCommonUploadResult
	 */
	public String getLectureCommonUploadResult() {
		return lectureCommonUploadResult;
	}

	/**
	 * @param lectureCommonUploadResult the lectureCommonUploadResult to set
	 */
	public void setLectureCommonUploadResult(String lectureCommonUploadResult) {
		this.lectureCommonUploadResult = lectureCommonUploadResult;
	}

	/**
	 * @return the teachOneCommonUploadResult
	 */
	public String getTeachOneCommonUploadResult() {
		return teachOneCommonUploadResult;
	}

	/**
	 * @param teachOneCommonUploadResult the teachOneCommonUploadResult to set
	 */
	public void setTeachOneCommonUploadResult(String teachOneCommonUploadResult) {
		this.teachOneCommonUploadResult = teachOneCommonUploadResult;
	}

	/**
	 * @return the teachTwoCommonUploadResult
	 */
	public String getTeachTwoCommonUploadResult() {
		return teachTwoCommonUploadResult;
	}

	/**
	 * @param teachTwoCommonUploadResult the teachTwoCommonUploadResult to set
	 */
	public void setTeachTwoCommonUploadResult(String teachTwoCommonUploadResult) {
		this.teachTwoCommonUploadResult = teachTwoCommonUploadResult;
	}
}
