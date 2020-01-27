package ony.cmm.common.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * ISCO
 * @author onycom
 * @since 2019.10.22
 * @version 1.0
 * @see
 *
 * <pre>
 * << Modification Information >>
 *
 *  updateDate updater desc
 *  ------------- -------- ---------------------------
 *
 * </pre>
 */
public class IscoBean extends CommonBean{

	private static final long serialVersionUID = 4979179976898050104L;

	private String iscoCd		=	"";
	private String enNm			=	"";
	private String khNm			=	"";
	private String upperCd		=	"";
	private String lvl			=	"";
	private String cdLvl		=	"";
	private String expln		=	"";
	private String cateNm		=	"";
	private String useYn		=	"";
	private int    iscoId          ;

	private String occupIncKh;
	private String occupIncEn;
	private String occupExcKh;
	private String occupExcEn;
	private String noteKh;
	private String noteEn;
	private String defEn;
	private String defKh;
	private String taskEn;
	private String taskKh;
	private String jobCateCd;
	private String titleKh;
	private String dutiesKh;
	private String skillKh;
	private String responsibilitiesKh;
	private String eduTrnngKh;
	private String highEduKh;
	private String majorStudyKh;
	private String skillRelatedExpKh;
	private String titleEn;
	private String dutiesEn;
	private String skillEn;
	private String responsibilitiesEn;
	private String eduTrnngEn;
	private String highEduEn;
	private String majorStudyEn;
	private String skillRelatedExpEn;
	private String thumbFileGrpSeq;
	private String iscoFullCd;

	private String modUserNm;
	private String depthNm1;
	private String depthNm2;
	private String depthNm3;
	private String depthNm4;
	private String depth1EnNm;
	private String depth1KhNm;
	private String depth2EnNm;
	private String depth2KhNm;
	private String depth3EnNm;
	private String depth3KhNm;
	private String detailIscoCd;

	private List<IscoBean> list = new ArrayList<IscoBean>();

	public String getDetailIscoCd() {
		return detailIscoCd;
	}
	public void setDetailIscoCd(String detailIscoCd) {
		this.detailIscoCd = detailIscoCd;
	}
	public String getDepth1EnNm() {
		return depth1EnNm;
	}
	public void setDepth1EnNm(String depth1EnNm) {
		this.depth1EnNm = depth1EnNm;
	}
	public String getDepth1KhNm() {
		return depth1KhNm;
	}
	public void setDepth1KhNm(String depth1KhNm) {
		this.depth1KhNm = depth1KhNm;
	}
	public String getDepth2EnNm() {
		return depth2EnNm;
	}
	public void setDepth2EnNm(String depth2EnNm) {
		this.depth2EnNm = depth2EnNm;
	}
	public String getDepth2KhNm() {
		return depth2KhNm;
	}
	public void setDepth2KhNm(String depth2KhNm) {
		this.depth2KhNm = depth2KhNm;
	}
	public String getDepth3EnNm() {
		return depth3EnNm;
	}
	public void setDepth3EnNm(String depth3EnNm) {
		this.depth3EnNm = depth3EnNm;
	}
	public String getDepth3KhNm() {
		return depth3KhNm;
	}
	public void setDepth3KhNm(String depth3KhNm) {
		this.depth3KhNm = depth3KhNm;
	}
	public String getModUserNm() {
		return modUserNm;
	}
	public void setModUserNm(String modUserNm) {
		this.modUserNm = modUserNm;
	}
	public String getDepthNm4() {
		return depthNm4;
	}
	public void setDepthNm4(String depthNm4) {
		this.depthNm4 = depthNm4;
	}
	public String getDepthNm1() {
		return depthNm1;
	}
	public void setDepthNm1(String depthNm1) {
		this.depthNm1 = depthNm1;
	}
	public String getDepthNm2() {
		return depthNm2;
	}
	public void setDepthNm2(String depthNm2) {
		this.depthNm2 = depthNm2;
	}
	public String getDepthNm3() {
		return depthNm3;
	}
	public void setDepthNm3(String depthNm3) {
		this.depthNm3 = depthNm3;
	}
	public String getOccupIncKh() {
		return occupIncKh;
	}
	public void setOccupIncKh(String occupIncKh) {
		this.occupIncKh = occupIncKh;
	}
	public String getOccupIncEn() {
		return occupIncEn;
	}
	public void setOccupIncEn(String occupIncEn) {
		this.occupIncEn = occupIncEn;
	}
	public String getOccupExcKh() {
		return occupExcKh;
	}
	public void setOccupExcKh(String occupExcKh) {
		this.occupExcKh = occupExcKh;
	}
	public String getOccupExcEn() {
		return occupExcEn;
	}
	public void setOccupExcEn(String occupExcEn) {
		this.occupExcEn = occupExcEn;
	}
	public String getNoteKh() {
		return noteKh;
	}
	public void setNoteKh(String noteKh) {
		this.noteKh = noteKh;
	}
	public String getNoteEn() {
		return noteEn;
	}
	public void setNoteEn(String noteEn) {
		this.noteEn = noteEn;
	}
	public String getDefEn() {
		return defEn;
	}
	public void setDefEn(String defEn) {
		this.defEn = defEn;
	}
	public String getDefKh() {
		return defKh;
	}
	public void setDefKh(String defKh) {
		this.defKh = defKh;
	}
	public String getTaskEn() {
		return taskEn;
	}
	public void setTaskEn(String taskEn) {
		this.taskEn = taskEn;
	}
	public String getTaskKh() {
		return taskKh;
	}
	public void setTaskKh(String taskKh) {
		this.taskKh = taskKh;
	}
	public String getJobCateCd() {
		return jobCateCd;
	}
	public void setJobCateCd(String jobCateCd) {
		this.jobCateCd = jobCateCd;
	}
	public String getTitleKh() {
		return titleKh;
	}
	public void setTitleKh(String titleKh) {
		this.titleKh = titleKh;
	}
	public String getDutiesKh() {
		return dutiesKh;
	}
	public void setDutiesKh(String dutiesKh) {
		this.dutiesKh = dutiesKh;
	}
	public String getSkillKh() {
		return skillKh;
	}
	public void setSkillKh(String skillKh) {
		this.skillKh = skillKh;
	}
	public String getResponsibilitiesKh() {
		return responsibilitiesKh;
	}
	public void setResponsibilitiesKh(String responsibilitiesKh) {
		this.responsibilitiesKh = responsibilitiesKh;
	}
	public String getEduTrnngKh() {
		return eduTrnngKh;
	}
	public void setEduTrnngKh(String eduTrnngKh) {
		this.eduTrnngKh = eduTrnngKh;
	}
	public String getHighEduKh() {
		return highEduKh;
	}
	public void setHighEduKh(String highEduKh) {
		this.highEduKh = highEduKh;
	}
	public String getMajorStudyKh() {
		return majorStudyKh;
	}
	public void setMajorStudyKh(String majorStudyKh) {
		this.majorStudyKh = majorStudyKh;
	}
	public String getSkillRelatedExpKh() {
		return skillRelatedExpKh;
	}
	public void setSkillRelatedExpKh(String skillRelatedExpKh) {
		this.skillRelatedExpKh = skillRelatedExpKh;
	}
	public String getTitleEn() {
		return titleEn;
	}
	public void setTitleEn(String titleEn) {
		this.titleEn = titleEn;
	}
	public String getDutiesEn() {
		return dutiesEn;
	}
	public void setDutiesEn(String dutiesEn) {
		this.dutiesEn = dutiesEn;
	}
	public String getSkillEn() {
		return skillEn;
	}
	public void setSkillEn(String skillEn) {
		this.skillEn = skillEn;
	}
	public String getResponsibilitiesEn() {
		return responsibilitiesEn;
	}
	public void setResponsibilitiesEn(String responsibilitiesEn) {
		this.responsibilitiesEn = responsibilitiesEn;
	}
	public String getEduTrnngEn() {
		return eduTrnngEn;
	}
	public void setEduTrnngEn(String eduTrnngEn) {
		this.eduTrnngEn = eduTrnngEn;
	}
	public String getHighEduEn() {
		return highEduEn;
	}
	public void setHighEduEn(String highEduEn) {
		this.highEduEn = highEduEn;
	}
	public String getMajorStudyEn() {
		return majorStudyEn;
	}
	public void setMajorStudyEn(String majorStudyEn) {
		this.majorStudyEn = majorStudyEn;
	}
	public String getSkillRelatedExpEn() {
		return skillRelatedExpEn;
	}
	public void setSkillRelatedExpEn(String skillRelatedExpEn) {
		this.skillRelatedExpEn = skillRelatedExpEn;
	}
	public String getThumbFileGrpSeq() {
		return thumbFileGrpSeq;
	}
	public void setThumbFileGrpSeq(String thumbFileGrpSeq) {
		this.thumbFileGrpSeq = thumbFileGrpSeq;
	}
	public String getIscoFullCd() {
		return iscoFullCd;
	}
	public void setIscoFullCd(String iscoFullCd) {
		this.iscoFullCd = iscoFullCd;
	}
	public List<IscoBean> getList() {
		return list;
	}
	public void setList(List<IscoBean> list) {
		this.list = list;
	}
	public String getIscoCd() {
		return iscoCd;
	}
	public void setIscoCd(String iscoCd) {
		this.iscoCd = iscoCd;
	}
	public String getEnNm() {
		return enNm;
	}
	public void setEnNm(String enNm) {
		this.enNm = enNm;
	}
	public String getKhNm() {
		return khNm;
	}
	public void setKhNm(String khNm) {
		this.khNm = khNm;
	}
	public String getUpperCd() {
		return upperCd;
	}
	public void setUpperCd(String upperCd) {
		this.upperCd = upperCd;
	}
	public String getLvl() {
		return lvl;
	}
	public void setLvl(String lvl) {
		this.lvl = lvl;
	}
	public String getCdLvl() {
		return cdLvl;
	}
	public void setCdLvl(String cdLvl) {
		this.cdLvl = cdLvl;
	}
	public String getExpln() {
		return expln;
	}
	public void setExpln(String expln) {
		this.expln = expln;
	}
	public String getCateNm() {
		return cateNm;
	}
	public void setCateNm(String cateNm) {
		this.cateNm = cateNm;
	}
	public String getUseYn() {
		return useYn;
	}
	public void setUseYn(String useYn) {
		this.useYn = useYn;
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



}
