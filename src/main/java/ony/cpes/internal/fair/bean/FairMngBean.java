package ony.cpes.internal.fair.bean;

import java.util.ArrayList;
import java.util.List;

import ony.cmm.common.bean.CommonBean;
import ony.cpes.internal.user.bean.UserBean;

public class FairMngBean extends CommonBean {
	private String 	fairSeq;
	private String 	fairNmKh;
	private String 	fairNmEn;
	private String 	fairDtlExplnKh;
	private String 	fairDtlExplnEn;
	private String 	fairStsCd;
	private String 	fairStsNm;
	private String 	addrCd;
	private String 	addrFullCd;
	private String 	addrFullNm;
	private String 	addrDtl;
	private String 	addrDtl2;
	private String  googleMapLink;
	private String 	fairLngtd;
	private String 	fairLattd;
	private String 	thumbFileGrpSeq;
	private String 	fairFileGrpSeq;
	private String 	boothFileGrpSeq;
	private String 	useYn;
	private String 	fairViewYn;
	private String 	fairDivCd;
	private String 	fairDivNm;
	private String 	mstJcCd;
	private String 	mstJcNm;
	private String 	jcCd;
	private String 	jcNm;
	private String 	fairBgnDt;
	private String 	fairBgnHour;
	private String 	fairBgnMinute;
	private String 	fairBgnAmpm;
	private String 	fairEndDt;
	private String 	fairEndHour;
	private String 	fairEndMinute;
	private String 	fairEndAmpm;
	private String 	recurmtBgnDt;
	private String 	recurmtBgnHour;
	private String 	recurmtBgnMinute;
	private String 	recurmtBgnAmpm;
	private String 	recurmtEndDt;
	private String 	recurmtEndHour;
	private String 	recurmtEndMinute;
	private String 	recurmtEndAmpm;
	private String 	tel1;
	private String 	tel2;
	private String 	email;
	private String 	cell;
	private String 	url;

	private String 	userSeq;
	private String 	userNm;
	private String 	userEmail;
	private String 	userCell;
	private String	age;

	private String 	userAuthCd;
	private String 	userAuthNm;
	private String 	preferntCondCd;
	private String 	genderCd;
	private String 	genderNm;
	private String 	jobskStsCd;
	private String 	jobskStsNm;
	private String 	jcAgreeStsCd;
	private String 	jcAgreeStsNm;
	private String 	jcAgreeUserSeq;
	private String	jcAgreeUserNm;
	private String 	jcAgreeDt;

	private String 	fairHashtag;
	private String 	fairCompnyViewYn;
	private String 	fairVacancyViewYn;
	private String 	fairInsttViewYn;
	private String 	fairTrnngViewYn;
	private String 	boothTel;
	private String 	boothEmail;
	private String 	boothFeeExpln;

	private String 	delYn;

	private String 	regUserSeq;
	private String 	regDt;
	private String 	modUserSeq;
	private String 	modDt;

	private String  regUserNm;
	private String  modUserNm;

	private String  fairNm;
	private String  addrCd2Depth;
	private String  recurmtDt;
	private String  fairDt;
	private String	fairStsDiv;
	private String	periodKeyword;

	private String	compnySeq;
	private String  compnyTypeCd;
	private String  compnyTypeNm;
	private String  compnyNm;
	private String	compnyNmKh;
	private String	compnyNmEn;
	private String  regNum;
	private String  nationCd;
	private String  userStsCd;
	private String  employCntCd;

	private String  inviteYn;
	private String	inviteDt;
	private String  compnyRespYn;
	private String 	insttRespYn;
	private String 	reqDt;

	private String  mngerNm;
	private String  mngerEmail;
	private String	mngerCell;
	private String	sectorCd;

	private String  fairMngDiv;
	private String  compnyInsttDivCd;
	private String  boothReqYn;

	private String  insttSeq;
	private String  insttTypeCd;
	private String  insttTypeNm;
	private String  insttOwnerCd;
	private String  insttNm;
	private String  insttRegNum;
	private String  insttMngerNm;
	private String  insttEmail;
	private String  insttCell;

	private String 	vacancySeq;
	private String 	vacancyCertNo;
	private String 	vacancyTitle;
	private String 	vacancyStsCd;
	private String  employFormCd;
	private String  recrumtStsCd;
	private String  recrumtDiffcltYn;
	private String  period;
	private String  bgnDt;
	private String  endDt;

	private String  applicSeq;
	private String  applicProcCd;
	private String  applicCancelDt;
	private String  applicTypeCd;
	private String  applicCancelYn;
	private String  resumeSeq;
	private String  passYn;
	private String  negoAmtUnitCd;
	private String  negoAmt;
	private String  resumeOpenYn;
	private String  resumePassYn;
	private String  resumeOpenDt;
	private String  resumeTitle;

	private String  referralYn;
	private String  priResumeYn;

	private String  intvwSeq;
	private String  intvwTypeCd;
	private String  intvwOpenYn;
	private String  intvwOpenDt;
	private String  intvwDt;
	private String  intvwAgreeYn;
	private String  intvwAgreeDt;
	private String  intvwMnger;

	private int	 jobskTot;
	private int  compnyTot;
	private int  vacancyAncmtTot;
	private int  insttTot;
	private int  eduProgramTot;
	private int  applicTot;
	private int  vacancyTot;
	private int  recrumtMemb;

	private List<String> preferntCondCdList = new ArrayList<String>();
	private List<String> ageList = new ArrayList<String>();
	private List<String> compnySeqList = new ArrayList<String>();
	private List<String> insttSeqList = new ArrayList<String>();
	private List<String> vacancySeqList = new ArrayList<String>();
	private List<String> applicSeqList = new ArrayList<String>();
	private List<String> intvwSeqList = new ArrayList<String>();

	private UserBean user = new UserBean();

	private List<FairMngBean> list;

	private String supporterFileGrpSeq = "";
	private String sponsorFileGrpSeq = "";


	private String thumbCommonUploadFairResult	= "";
	private String fairCommonUploadFairResult	= "";
	private String supporterCommonUploadFairResult	= "";
	private String sponsorCommonUploadFairResult	= "";
	private String boothCommonUploadFairResult	= "";

	private String compnySeqListStr;
	private String insttSeqListStr;


	public String getInsttSeqListStr() {
		return insttSeqListStr;
	}

	public void setInsttSeqListStr(String insttSeqListStr) {
		this.insttSeqListStr = insttSeqListStr;
	}

	public String getInsttTypeNm() {
		return insttTypeNm;
	}

	public void setInsttTypeNm(String insttTypeNm) {
		this.insttTypeNm = insttTypeNm;
	}

	public String getCompnySeqListStr() {
		return compnySeqListStr;
	}

	public void setCompnySeqListStr(String compnySeqListStr) {
		this.compnySeqListStr = compnySeqListStr;
	}

	public String getUserAuthNm() {
		return userAuthNm;
	}

	public void setUserAuthNm(String userAuthNm) {
		this.userAuthNm = userAuthNm;
	}

	public String getGenderNm() {
		return genderNm;
	}

	public void setGenderNm(String genderNm) {
		this.genderNm = genderNm;
	}

	public String getJobskStsNm() {
		return jobskStsNm;
	}

	public void setJobskStsNm(String jobskStsNm) {
		this.jobskStsNm = jobskStsNm;
	}

	public String getJcAgreeStsNm() {
		return jcAgreeStsNm;
	}

	public void setJcAgreeStsNm(String jcAgreeStsNm) {
		this.jcAgreeStsNm = jcAgreeStsNm;
	}

	public String getThumbCommonUploadFairResult() {
		return thumbCommonUploadFairResult;
	}

	public void setThumbCommonUploadFairResult(String thumbCommonUploadFairResult) {
		this.thumbCommonUploadFairResult = thumbCommonUploadFairResult;
	}

	public String getFairCommonUploadFairResult() {
		return fairCommonUploadFairResult;
	}

	public void setFairCommonUploadFairResult(String fairCommonUploadFairResult) {
		this.fairCommonUploadFairResult = fairCommonUploadFairResult;
	}

	public String getSupporterCommonUploadFairResult() {
		return supporterCommonUploadFairResult;
	}

	public void setSupporterCommonUploadFairResult(String supporterCommonUploadFairResult) {
		this.supporterCommonUploadFairResult = supporterCommonUploadFairResult;
	}

	public String getSponsorCommonUploadFairResult() {
		return sponsorCommonUploadFairResult;
	}

	public void setSponsorCommonUploadFairResult(String sponsorCommonUploadFairResult) {
		this.sponsorCommonUploadFairResult = sponsorCommonUploadFairResult;
	}

	public String getBoothCommonUploadFairResult() {
		return boothCommonUploadFairResult;
	}

	public void setBoothCommonUploadFairResult(String boothCommonUploadFairResult) {
		this.boothCommonUploadFairResult = boothCommonUploadFairResult;
	}

	public String getFairStsNm() {
		return fairStsNm;
	}

	public void setFairStsNm(String fairStsNm) {
		this.fairStsNm = fairStsNm;
	}

	public String getFairDivNm() {
		return fairDivNm;
	}

	public void setFairDivNm(String fairDivNm) {
		this.fairDivNm = fairDivNm;
	}

	public String getMstJcNm() {
		return mstJcNm;
	}

	public void setMstJcNm(String mstJcNm) {
		this.mstJcNm = mstJcNm;
	}

	public String getJcNm() {
		return jcNm;
	}

	public void setJcNm(String jcNm) {
		this.jcNm = jcNm;
	}

	public String getSupporterFileGrpSeq() {
		return supporterFileGrpSeq;
	}

	public void setSupporterFileGrpSeq(String supporterFileGrpSeq) {
		this.supporterFileGrpSeq = supporterFileGrpSeq;
	}

	public String getSponsorFileGrpSeq() {
		return sponsorFileGrpSeq;
	}

	public void setSponsorFileGrpSeq(String sponsorFileGrpSeq) {
		this.sponsorFileGrpSeq = sponsorFileGrpSeq;
	}

	/**
	 * @return the fairSeq
	 */
	public String getFairSeq() {
		return fairSeq;
	}

	/**
	 * @param fairSeq the fairSeq to set
	 */
	public void setFairSeq(String fairSeq) {
		this.fairSeq = fairSeq;
	}

	/**
	 * @return the fairNmKh
	 */
	public String getFairNmKh() {
		return fairNmKh;
	}

	/**
	 * @param fairNmKh the fairNmKh to set
	 */
	public void setFairNmKh(String fairNmKh) {
		this.fairNmKh = fairNmKh;
	}

	/**
	 * @return the fairNmEn
	 */
	public String getFairNmEn() {
		return fairNmEn;
	}

	/**
	 * @param fairNmEn the fairNmEn to set
	 */
	public void setFairNmEn(String fairNmEn) {
		this.fairNmEn = fairNmEn;
	}

	/**
	 * @return the fairDtlExplnKh
	 */
	public String getFairDtlExplnKh() {
		return fairDtlExplnKh;
	}

	/**
	 * @param fairDtlExplnKh the fairDtlExplnKh to set
	 */
	public void setFairDtlExplnKh(String fairDtlExplnKh) {
		this.fairDtlExplnKh = fairDtlExplnKh;
	}

	/**
	 * @return the fairDtlExplnEn
	 */
	public String getFairDtlExplnEn() {
		return fairDtlExplnEn;
	}

	/**
	 * @param fairDtlExplnEn the fairDtlExplnEn to set
	 */
	public void setFairDtlExplnEn(String fairDtlExplnEn) {
		this.fairDtlExplnEn = fairDtlExplnEn;
	}

	/**
	 * @return the fairStsCd
	 */
	public String getFairStsCd() {
		return fairStsCd;
	}

	/**
	 * @param fairStsCd the fairStsCd to set
	 */
	public void setFairStsCd(String fairStsCd) {
		this.fairStsCd = fairStsCd;
	}

	/**
	 * @return the fairLngtd
	 */
	public String getFairLngtd() {
		return fairLngtd;
	}

	/**
	 * @param fairLngtd the fairLngtd to set
	 */
	public void setFairLngtd(String fairLngtd) {
		this.fairLngtd = fairLngtd;
	}

	/**
	 * @return the fairLattd
	 */
	public String getFairLattd() {
		return fairLattd;
	}

	/**
	 * @param fairLattd the fairLattd to set
	 */
	public void setFairLattd(String fairLattd) {
		this.fairLattd = fairLattd;
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
	 * @return the addrDtl2
	 */
	public String getAddrDtl2() {
		return addrDtl2;
	}

	/**
	 * @param addrDtl2 the addrDtl2 to set
	 */
	public void setAddrDtl2(String addrDtl2) {
		this.addrDtl2 = addrDtl2;
	}

	/**
	 * @return the thumbFileGrpSeq
	 */
	public String getThumbFileGrpSeq() {
		return thumbFileGrpSeq;
	}

	/**
	 * @param thumbFileGrpSeq the thumbFileGrpSeq to set
	 */
	public void setThumbFileGrpSeq(String thumbFileGrpSeq) {
		this.thumbFileGrpSeq = thumbFileGrpSeq;
	}

	/**
	 * @return the fairFileGrpSeq
	 */
	public String getFairFileGrpSeq() {
		return fairFileGrpSeq;
	}

	/**
	 * @param fairFileGrpSeq the fairFileGrpSeq to set
	 */
	public void setFairFileGrpSeq(String fairFileGrpSeq) {
		this.fairFileGrpSeq = fairFileGrpSeq;
	}

	/**
	 * @return the boothFileGrpSeq
	 */
	public String getBoothFileGrpSeq() {
		return boothFileGrpSeq;
	}

	/**
	 * @param boothFileGrpSeq the boothFileGrpSeq to set
	 */
	public void setBoothFileGrpSeq(String boothFileGrpSeq) {
		this.boothFileGrpSeq = boothFileGrpSeq;
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
	 * @return the fairViewYn
	 */
	public String getFairViewYn() {
		return fairViewYn;
	}

	/**
	 * @param fairViewYn the fairViewYn to set
	 */
	public void setFairViewYn(String fairViewYn) {
		this.fairViewYn = fairViewYn;
	}

	/**
	 * @return the fairDivCd
	 */
	public String getFairDivCd() {
		return fairDivCd;
	}

	/**
	 * @param fairDivCd the fairDivCd to set
	 */
	public void setFairDivCd(String fairDivCd) {
		this.fairDivCd = fairDivCd;
	}

	/**
	 * @return the mstJcCd
	 */
	public String getMstJcCd() {
		return mstJcCd;
	}

	/**
	 * @param mstJcCd the mstJcCd to set
	 */
	public void setMstJcCd(String mstJcCd) {
		this.mstJcCd = mstJcCd;
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
	 * @return the fairBgnDt
	 */
	public String getFairBgnDt() {
		return fairBgnDt;
	}

	/**
	 * @param fairBgnDt the fairBgnDt to set
	 */
	public void setFairBgnDt(String fairBgnDt) {
		this.fairBgnDt = fairBgnDt;
	}

	/**
	 * @return the fairBgnHour
	 */
	public String getFairBgnHour() {
		return fairBgnHour;
	}

	/**
	 * @param fairBgnHour the fairBgnHour to set
	 */
	public void setFairBgnHour(String fairBgnHour) {
		this.fairBgnHour = fairBgnHour;
	}

	/**
	 * @return the fairBgnMinute
	 */
	public String getFairBgnMinute() {
		return fairBgnMinute;
	}

	/**
	 * @param fairBgnMinute the fairBgnMinute to set
	 */
	public void setFairBgnMinute(String fairBgnMinute) {
		this.fairBgnMinute = fairBgnMinute;
	}

	/**
	 * @return the fairBgnAmpm
	 */
	public String getFairBgnAmpm() {
		return fairBgnAmpm;
	}

	/**
	 * @param fairBgnAmpm the fairBgnAmpm to set
	 */
	public void setFairBgnAmpm(String fairBgnAmpm) {
		this.fairBgnAmpm = fairBgnAmpm;
	}

	/**
	 * @return the fairEndDt
	 */
	public String getFairEndDt() {
		return fairEndDt;
	}

	/**
	 * @param fairEndDt the fairEndDt to set
	 */
	public void setFairEndDt(String fairEndDt) {
		this.fairEndDt = fairEndDt;
	}

	/**
	 * @return the fairEndHour
	 */
	public String getFairEndHour() {
		return fairEndHour;
	}

	/**
	 * @param fairEndHour the fairEndHour to set
	 */
	public void setFairEndHour(String fairEndHour) {
		this.fairEndHour = fairEndHour;
	}

	/**
	 * @return the fairEndMinute
	 */
	public String getFairEndMinute() {
		return fairEndMinute;
	}

	/**
	 * @param fairEndMinute the fairEndMinute to set
	 */
	public void setFairEndMinute(String fairEndMinute) {
		this.fairEndMinute = fairEndMinute;
	}

	/**
	 * @return the fairEndAmpm
	 */
	public String getFairEndAmpm() {
		return fairEndAmpm;
	}

	/**
	 * @param fairEndAmpm the fairEndAmpm to set
	 */
	public void setFairEndAmpm(String fairEndAmpm) {
		this.fairEndAmpm = fairEndAmpm;
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
	 * @return the recurmtBgnHour
	 */
	public String getRecurmtBgnHour() {
		return recurmtBgnHour;
	}

	/**
	 * @param recurmtBgnHour the recurmtBgnHour to set
	 */
	public void setRecurmtBgnHour(String recurmtBgnHour) {
		this.recurmtBgnHour = recurmtBgnHour;
	}

	/**
	 * @return the recurmtBgnMinute
	 */
	public String getRecurmtBgnMinute() {
		return recurmtBgnMinute;
	}

	/**
	 * @param recurmtBgnMinute the recurmtBgnMinute to set
	 */
	public void setRecurmtBgnMinute(String recurmtBgnMinute) {
		this.recurmtBgnMinute = recurmtBgnMinute;
	}

	/**
	 * @return the recurmtBgnAmpm
	 */
	public String getRecurmtBgnAmpm() {
		return recurmtBgnAmpm;
	}

	/**
	 * @param recurmtBgnAmpm the recurmtBgnAmpm to set
	 */
	public void setRecurmtBgnAmpm(String recurmtBgnAmpm) {
		this.recurmtBgnAmpm = recurmtBgnAmpm;
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
	 * @return the recurmtEndHour
	 */
	public String getRecurmtEndHour() {
		return recurmtEndHour;
	}

	/**
	 * @param recurmtEndHour the recurmtEndHour to set
	 */
	public void setRecurmtEndHour(String recurmtEndHour) {
		this.recurmtEndHour = recurmtEndHour;
	}

	/**
	 * @return the recurmtEndMinute
	 */
	public String getRecurmtEndMinute() {
		return recurmtEndMinute;
	}

	/**
	 * @param recurmtEndMinute the recurmtEndMinute to set
	 */
	public void setRecurmtEndMinute(String recurmtEndMinute) {
		this.recurmtEndMinute = recurmtEndMinute;
	}

	/**
	 * @return the recurmtEndAmpm
	 */
	public String getRecurmtEndAmpm() {
		return recurmtEndAmpm;
	}

	/**
	 * @param recurmtEndAmpm the recurmtEndAmpm to set
	 */
	public void setRecurmtEndAmpm(String recurmtEndAmpm) {
		this.recurmtEndAmpm = recurmtEndAmpm;
	}

	/**
	 * @return the tel1
	 */
	public String getTel1() {
		return tel1;
	}

	/**
	 * @param tel1 the tel1 to set
	 */
	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}

	/**
	 * @return the tel2
	 */
	public String getTel2() {
		return tel2;
	}

	/**
	 * @param tel2 the tel2 to set
	 */
	public void setTel2(String tel2) {
		this.tel2 = tel2;
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
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
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
	 * @return the jcAgreeUserSeq
	 */
	public String getJcAgreeUserSeq() {
		return jcAgreeUserSeq;
	}

	/**
	 * @param jcAgreeUserSeq the jcAgreeUserSeq to set
	 */
	public void setJcAgreeUserSeq(String jcAgreeUserSeq) {
		this.jcAgreeUserSeq = jcAgreeUserSeq;
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
	 * @return the fairHashtag
	 */
	public String getFairHashtag() {
		return fairHashtag;
	}

	/**
	 * @param fairHashtag the fairHashtag to set
	 */
	public void setFairHashtag(String fairHashtag) {
		this.fairHashtag = fairHashtag;
	}

	/**
	 * @return the fairCompnyViewYn
	 */
	public String getFairCompnyViewYn() {
		return fairCompnyViewYn;
	}

	/**
	 * @param fairCompnyViewYn the fairCompnyViewYn to set
	 */
	public void setFairCompnyViewYn(String fairCompnyViewYn) {
		this.fairCompnyViewYn = fairCompnyViewYn;
	}

	/**
	 * @return the fairVacancyViewYn
	 */
	public String getFairVacancyViewYn() {
		return fairVacancyViewYn;
	}

	/**
	 * @param fairVacancyViewYn the fairVacancyViewYn to set
	 */
	public void setFairVacancyViewYn(String fairVacancyViewYn) {
		this.fairVacancyViewYn = fairVacancyViewYn;
	}

	/**
	 * @return the fairInsttViewYn
	 */
	public String getFairInsttViewYn() {
		return fairInsttViewYn;
	}

	/**
	 * @param fairInsttViewYn the fairInsttViewYn to set
	 */
	public void setFairInsttViewYn(String fairInsttViewYn) {
		this.fairInsttViewYn = fairInsttViewYn;
	}

	/**
	 * @return the fairTrnngViewYn
	 */
	public String getFairTrnngViewYn() {
		return fairTrnngViewYn;
	}

	/**
	 * @param fairTrnngViewYn the fairTrnngViewYn to set
	 */
	public void setFairTrnngViewYn(String fairTrnngViewYn) {
		this.fairTrnngViewYn = fairTrnngViewYn;
	}

	/**
	 * @return the boothTel
	 */
	public String getBoothTel() {
		return boothTel;
	}

	/**
	 * @param boothTel the boothTel to set
	 */
	public void setBoothTel(String boothTel) {
		this.boothTel = boothTel;
	}

	/**
	 * @return the boothEmail
	 */
	public String getBoothEmail() {
		return boothEmail;
	}

	/**
	 * @param boothEmail the boothEmail to set
	 */
	public void setBoothEmail(String boothEmail) {
		this.boothEmail = boothEmail;
	}

	/**
	 * @return the boothFeeExpln
	 */
	public String getBoothFeeExpln() {
		return boothFeeExpln;
	}

	/**
	 * @param boothFeeExpln the boothFeeExpln to set
	 */
	public void setBoothFeeExpln(String boothFeeExpln) {
		this.boothFeeExpln = boothFeeExpln;
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
	 * @return the fairNm
	 */
	public String getFairNm() {
		return fairNm;
	}

	/**
	 * @param fairNm the fairNm to set
	 */
	public void setFairNm(String fairNm) {
		this.fairNm = fairNm;
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
	 * @return the recurmtDt
	 */
	public String getRecurmtDt() {
		return recurmtDt;
	}

	/**
	 * @param recurmtDt the recurmtDt to set
	 */
	public void setRecurmtDt(String recurmtDt) {
		this.recurmtDt = recurmtDt;
	}

	/**
	 * @return the fairDt
	 */
	public String getFairDt() {
		return fairDt;
	}

	/**
	 * @param fairDt the fairDt to set
	 */
	public void setFairDt(String fairDt) {
		this.fairDt = fairDt;
	}

	/**
	 * @return the fairStsDiv
	 */
	public String getFairStsDiv() {
		return fairStsDiv;
	}

	/**
	 * @param fairStsDiv the fairStsDiv to set
	 */
	public void setFairStsDiv(String fairStsDiv) {
		this.fairStsDiv = fairStsDiv;
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
	 * @return the jcAgreeUserNm
	 */
	public String getJcAgreeUserNm() {
		return jcAgreeUserNm;
	}

	/**
	 * @param jcAgreeUserNm the jcAgreeUserNm to set
	 */
	public void setJcAgreeUserNm(String jcAgreeUserNm) {
		this.jcAgreeUserNm = jcAgreeUserNm;
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
	 * @return the compnyTypeCd
	 */
	public String getCompnyTypeCd() {
		return compnyTypeCd;
	}

	/**
	 * @param compnyTypeCd the compnyTypeCd to set
	 */
	public void setCompnyTypeCd(String compnyTypeCd) {
		this.compnyTypeCd = compnyTypeCd;
	}

	/**
	 * @return the compnyNm
	 */
	public String getCompnyNm() {
		return compnyNm;
	}

	/**
	 * @param compnyNm the compnyNm to set
	 */
	public void setCompnyNm(String compnyNm) {
		this.compnyNm = compnyNm;
	}

	/**
	 * @return the compnyNmKh
	 */
	public String getCompnyNmKh() {
		return compnyNmKh;
	}

	/**
	 * @param compnyNmKh the compnyNmKh to set
	 */
	public void setCompnyNmKh(String compnyNmKh) {
		this.compnyNmKh = compnyNmKh;
	}

	/**
	 * @return the compnyNmEn
	 */
	public String getCompnyNmEn() {
		return compnyNmEn;
	}

	/**
	 * @param compnyNmEn the compnyNmEn to set
	 */
	public void setCompnyNmEn(String compnyNmEn) {
		this.compnyNmEn = compnyNmEn;
	}
	/**
	 * @return the regNum
	 */
	public String getRegNum() {
		return regNum;
	}

	/**
	 * @param regNum the regNum to set
	 */
	public void setRegNum(String regNum) {
		this.regNum = regNum;
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
	 * @return the employCntCd
	 */
	public String getEmployCntCd() {
		return employCntCd;
	}

	/**
	 * @param employCntCd the employCntCd to set
	 */
	public void setEmployCntCd(String employCntCd) {
		this.employCntCd = employCntCd;
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
	 * @return the mngerEmail
	 */
	public String getMngerEmail() {
		return mngerEmail;
	}

	/**
	 * @param mngerEmail the mngerEmail to set
	 */
	public void setMngerEmail(String mngerEmail) {
		this.mngerEmail = mngerEmail;
	}

	/**
	 * @return the mngerCell
	 */
	public String getMngerCell() {
		return mngerCell;
	}

	/**
	 * @param mngerCell the mngerCell to set
	 */
	public void setMngerCell(String mngerCell) {
		this.mngerCell = mngerCell;
	}

	/**
	 * @return the inviteDt
	 */
	public String getInviteDt() {
		return inviteDt;
	}

	/**
	 * @param inviteDt the inviteDt to set
	 */
	public void setInviteDt(String inviteDt) {
		this.inviteDt = inviteDt;
	}


	/**
	 * @return the nationCd
	 */
	public String getNationCd() {
		return nationCd;
	}

	/**
	 * @param nationCd the nationCd to set
	 */
	public void setNationCd(String nationCd) {
		this.nationCd = nationCd;
	}

	/**
	 * @return the compnyRespYn
	 */
	public String getCompnyRespYn() {
		return compnyRespYn;
	}

	/**
	 * @param compnyRespYn the compnyRespYn to set
	 */
	public void setCompnyRespYn(String compnyRespYn) {
		this.compnyRespYn = compnyRespYn;
	}

	/**
	 * @return the inviteYn
	 */
	public String getInviteYn() {
		return inviteYn;
	}

	/**
	 * @param inviteYn the inviteYn to set
	 */
	public void setInviteYn(String inviteYn) {
		this.inviteYn = inviteYn;
	}

	/**
	 * @return the insttRespYn
	 */
	public String getInsttRespYn() {
		return insttRespYn;
	}

	/**
	 * @param insttRespYn the insttRespYn to set
	 */
	public void setInsttRespYn(String insttRespYn) {
		this.insttRespYn = insttRespYn;
	}

	/**
	 * @return the reqDt
	 */
	public String getReqDt() {
		return reqDt;
	}

	/**
	 * @param reqDt the reqDt to set
	 */
	public void setReqDt(String reqDt) {
		this.reqDt = reqDt;
	}

	/**
	 * @return the sectorCd
	 */
	public String getSectorCd() {
		return sectorCd;
	}

	/**
	 * @param sectorCd the sectorCd to set
	 */
	public void setSectorCd(String sectorCd) {
		this.sectorCd = sectorCd;
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
	 * @return the fairMngDiv
	 */
	public String getFairMngDiv() {
		return fairMngDiv;
	}

	/**
	 * @param fairMngDiv the fairMngDiv to set
	 */
	public void setFairMngDiv(String fairMngDiv) {
		this.fairMngDiv = fairMngDiv;
	}


	/**
	 * @return the compnyInsttDivCd
	 */
	public String getCompnyInsttDivCd() {
		return compnyInsttDivCd;
	}

	/**
	 * @param compnyInsttDivCd the compnyInsttDivCd to set
	 */
	public void setCompnyInsttDivCd(String compnyInsttDivCd) {
		this.compnyInsttDivCd = compnyInsttDivCd;
	}


	/**
	 * @return the boothReqYn
	 */
	public String getBoothReqYn() {
		return boothReqYn;
	}

	/**
	 * @param boothReqYn the boothReqYn to set
	 */
	public void setBoothReqYn(String boothReqYn) {
		this.boothReqYn = boothReqYn;
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
	 * @return the vacancyCertNo
	 */
	public String getVacancyCertNo() {
		return vacancyCertNo;
	}

	/**
	 * @param vacancyCertNo the vacancyCertNo to set
	 */
	public void setVacancyCertNo(String vacancyCertNo) {
		this.vacancyCertNo = vacancyCertNo;
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
	 * @return the vacancyStsCd
	 */
	public String getVacancyStsCd() {
		return vacancyStsCd;
	}

	/**
	 * @param vacancyStsCd the vacancyStsCd to set
	 */
	public void setVacancyStsCd(String vacancyStsCd) {
		this.vacancyStsCd = vacancyStsCd;
	}

	/**
	 * @return the employFormCd
	 */
	public String getEmployFormCd() {
		return employFormCd;
	}

	/**
	 * @param employFormCd the employFormCd to set
	 */
	public void setEmployFormCd(String employFormCd) {
		this.employFormCd = employFormCd;
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
	 * @return the recrumtDiffcltYn
	 */
	public String getRecrumtDiffcltYn() {
		return recrumtDiffcltYn;
	}

	/**
	 * @param recrumtDiffcltYn the recrumtDiffcltYn to set
	 */
	public void setRecrumtDiffcltYn(String recrumtDiffcltYn) {
		this.recrumtDiffcltYn = recrumtDiffcltYn;
	}

	/**
	 * @return the bgnDt
	 */
	public String getBgnDt() {
		return bgnDt;
	}

	/**
	 * @param bgnDt the bgnDt to set
	 */
	public void setBgnDt(String bgnDt) {
		this.bgnDt = bgnDt;
	}

	/**
	 * @return the endDt
	 */
	public String getEndDt() {
		return endDt;
	}

	/**
	 * @param endDt the endDt to set
	 */
	public void setEndDt(String endDt) {
		this.endDt = endDt;
	}

	/**
	 * @return the period
	 */
	public String getPeriod() {
		return period;
	}

	/**
	 * @param period the period to set
	 */
	public void setPeriod(String period) {
		this.period = period;
	}

	/**
	 * @return the applicSeq
	 */
	public String getApplicSeq() {
		return applicSeq;
	}

	/**
	 * @param applicSeq the applicSeq to set
	 */
	public void setApplicSeq(String applicSeq) {
		this.applicSeq = applicSeq;
	}

	/**
	 * @return the applicProcCd
	 */
	public String getApplicProcCd() {
		return applicProcCd;
	}

	/**
	 * @param applicProcCd the applicProcCd to set
	 */
	public void setApplicProcCd(String applicProcCd) {
		this.applicProcCd = applicProcCd;
	}

	/**
	 * @return the applicCancelDt
	 */
	public String getApplicCancelDt() {
		return applicCancelDt;
	}

	/**
	 * @param applicCancelDt the applicCancelDt to set
	 */
	public void setApplicCancelDt(String applicCancelDt) {
		this.applicCancelDt = applicCancelDt;
	}

	/**
	 * @return the applicTypeCd
	 */
	public String getApplicTypeCd() {
		return applicTypeCd;
	}

	/**
	 * @param applicTypeCd the applicTypeCd to set
	 */
	public void setApplicTypeCd(String applicTypeCd) {
		this.applicTypeCd = applicTypeCd;
	}

	/**
	 * @return the applicCancelYn
	 */
	public String getApplicCancelYn() {
		return applicCancelYn;
	}

	/**
	 * @param applicCancelYn the applicCancelYn to set
	 */
	public void setApplicCancelYn(String applicCancelYn) {
		this.applicCancelYn = applicCancelYn;
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
	 * @return the passYn
	 */
	public String getPassYn() {
		return passYn;
	}

	/**
	 * @param passYn the passYn to set
	 */
	public void setPassYn(String passYn) {
		this.passYn = passYn;
	}

	/**
	 * @return the negoAmtUnitCd
	 */
	public String getNegoAmtUnitCd() {
		return negoAmtUnitCd;
	}

	/**
	 * @param negoAmtUnitCd the negoAmtUnitCd to set
	 */
	public void setNegoAmtUnitCd(String negoAmtUnitCd) {
		this.negoAmtUnitCd = negoAmtUnitCd;
	}

	/**
	 * @return the negoAmt
	 */
	public String getNegoAmt() {
		return negoAmt;
	}

	/**
	 * @param negoAmt the negoAmt to set
	 */
	public void setNegoAmt(String negoAmt) {
		this.negoAmt = negoAmt;
	}

	/**
	 * @return the resumeOpenYn
	 */
	public String getResumeOpenYn() {
		return resumeOpenYn;
	}

	/**
	 * @param resumeOpenYn the resumeOpenYn to set
	 */
	public void setResumeOpenYn(String resumeOpenYn) {
		this.resumeOpenYn = resumeOpenYn;
	}

	/**
	 * @return the resumePassYn
	 */
	public String getResumePassYn() {
		return resumePassYn;
	}

	/**
	 * @param resumePassYn the resumePassYn to set
	 */
	public void setResumePassYn(String resumePassYn) {
		this.resumePassYn = resumePassYn;
	}

	/**
	 * @return the resumeOpenDt
	 */
	public String getResumeOpenDt() {
		return resumeOpenDt;
	}

	/**
	 * @param resumeOpenDt the resumeOpenDt to set
	 */
	public void setResumeOpenDt(String resumeOpenDt) {
		this.resumeOpenDt = resumeOpenDt;
	}

	/**
	 * @return the priResumeYn
	 */
	public String getPriResumeYn() {
		return priResumeYn;
	}

	/**
	 * @param priResumeYn the priResumeYn to set
	 */
	public void setPriResumeYn(String priResumeYn) {
		this.priResumeYn = priResumeYn;
	}

	/**
	 * @return the resumeTitle
	 */
	public String getResumeTitle() {
		return resumeTitle;
	}

	/**
	 * @param resumeTitle the resumeTitle to set
	 */
	public void setResumeTitle(String resumeTitle) {
		this.resumeTitle = resumeTitle;
	}

	/**
	 * @return the referralYn
	 */
	public String getReferralYn() {
		return referralYn;
	}

	/**
	 * @param referralYn the referralYn to set
	 */
	public void setReferralYn(String referralYn) {
		this.referralYn = referralYn;
	}

	/**
	 * @return the intvwSeq
	 */
	public String getIntvwSeq() {
		return intvwSeq;
	}

	/**
	 * @param intvwSeq the intvwSeq to set
	 */
	public void setIntvwSeq(String intvwSeq) {
		this.intvwSeq = intvwSeq;
	}

	/**
	 * @return the intvwTypeCd
	 */
	public String getIntvwTypeCd() {
		return intvwTypeCd;
	}

	/**
	 * @param intvwTypeCd the intvwTypeCd to set
	 */
	public void setIntvwTypeCd(String intvwTypeCd) {
		this.intvwTypeCd = intvwTypeCd;
	}

	/**
	 * @return the intvwOpenYn
	 */
	public String getIntvwOpenYn() {
		return intvwOpenYn;
	}

	/**
	 * @param intvwOpenYn the intvwOpenYn to set
	 */
	public void setIntvwOpenYn(String intvwOpenYn) {
		this.intvwOpenYn = intvwOpenYn;
	}

	/**
	 * @return the intvwOpenDt
	 */
	public String getIntvwOpenDt() {
		return intvwOpenDt;
	}

	/**
	 * @param intvwOpenDt the intvwOpenDt to set
	 */
	public void setIntvwOpenDt(String intvwOpenDt) {
		this.intvwOpenDt = intvwOpenDt;
	}

	/**
	 * @return the intvwDt
	 */
	public String getIntvwDt() {
		return intvwDt;
	}

	/**
	 * @param intvwDt the intvwDt to set
	 */
	public void setIntvwDt(String intvwDt) {
		this.intvwDt = intvwDt;
	}

	/**
	 * @return the intvwAgreeYn
	 */
	public String getIntvwAgreeYn() {
		return intvwAgreeYn;
	}

	/**
	 * @param intvwAgreeYn the intvwAgreeYn to set
	 */
	public void setIntvwAgreeYn(String intvwAgreeYn) {
		this.intvwAgreeYn = intvwAgreeYn;
	}

	/**
	 * @return the intvwAgreeDt
	 */
	public String getIntvwAgreeDt() {
		return intvwAgreeDt;
	}

	/**
	 * @param intvwAgreeDt the intvwAgreeDt to set
	 */
	public void setIntvwAgreeDt(String intvwAgreeDt) {
		this.intvwAgreeDt = intvwAgreeDt;
	}

	/**
	 * @return the intvwMnger
	 */
	public String getIntvwMnger() {
		return intvwMnger;
	}

	/**
	 * @param intvwMnger the intvwMnger to set
	 */
	public void setIntvwMnger(String intvwMnger) {
		this.intvwMnger = intvwMnger;
	}

	/**
	 * @return the jobskTot
	 */
	public int getJobskTot() {
		return jobskTot;
	}

	/**
	 * @param jobskTot the jobskTot to set
	 */
	public void setJobskTot(int jobskTot) {
		this.jobskTot = jobskTot;
	}

	/**
	 * @return the compnyTot
	 */
	public int getCompnyTot() {
		return compnyTot;
	}

	/**
	 * @param compnyTot the compnyTot to set
	 */
	public void setCompnyTot(int compnyTot) {
		this.compnyTot = compnyTot;
	}

	/**
	 * @return the vacancyAncmtTot
	 */
	public int getVacancyAncmtTot() {
		return vacancyAncmtTot;
	}

	/**
	 * @param vacancyAncmtTot the vacancyAncmtTot to set
	 */
	public void setVacancyAncmtTot(int vacancyAncmtTot) {
		this.vacancyAncmtTot = vacancyAncmtTot;
	}

	/**
	 * @return the insttTot
	 */
	public int getInsttTot() {
		return insttTot;
	}

	/**
	 * @param insttTot the insttTot to set
	 */
	public void setInsttTot(int insttTot) {
		this.insttTot = insttTot;
	}

	/**
	 * @return the eduProgramTot
	 */
	public int getEduProgramTot() {
		return eduProgramTot;
	}

	/**
	 * @param eduProgramTot the eduProgramTot to set
	 */
	public void setEduProgramTot(int eduProgramTot) {
		this.eduProgramTot = eduProgramTot;
	}

	/**
	 * @return the applicTot
	 */
	public int getApplicTot() {
		return applicTot;
	}

	/**
	 * @param applicTot the applicTot to set
	 */
	public void setApplicTot(int applicTot) {
		this.applicTot = applicTot;
	}

	/**
	 * @return the vacancyTot
	 */
	public int getVacancyTot() {
		return vacancyTot;
	}

	/**
	 * @param vacancyTot the vacancyTot to set
	 */
	public void setVacancyTot(int vacancyTot) {
		this.vacancyTot = vacancyTot;
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
	 * @return the preferntCondCdList
	 */
	public List<String> getPreferntCondCdList() {
		return preferntCondCdList;
	}

	/**
	 * @param preferntCondCdList the preferntCondCdList to set
	 */
	public void setPreferntCondCdList(List<String> preferntCondCdList) {
		this.preferntCondCdList = preferntCondCdList;
	}

	/**
	 * @return the ageList
	 */
	public List<String> getAgeList() {
		return ageList;
	}

	/**
	 * @param ageList the ageList to set
	 */
	public void setAgeList(List<String> ageList) {
		this.ageList = ageList;
	}

	/**
	 * @return the compnySeqList
	 */
	public List<String> getCompnySeqList() {
		return compnySeqList;
	}

	/**
	 * @param compnySeqList the compnySeqList to set
	 */
	public void setCompnySeqList(List<String> compnySeqList) {
		this.compnySeqList = compnySeqList;
	}

	/**
	 * @return the insttSeqList
	 */
	public List<String> getInsttSeqList() {
		return insttSeqList;
	}

	/**
	 * @param insttSeqList the insttSeqList to set
	 */
	public void setInsttSeqList(List<String> insttSeqList) {
		this.insttSeqList = insttSeqList;
	}

	/**
	 * @return the vacancySeqList
	 */
	public List<String> getVacancySeqList() {
		return vacancySeqList;
	}

	/**
	 * @param vacancySeqList the vacancySeqList to set
	 */
	public void setVacancySeqList(List<String> vacancySeqList) {
		this.vacancySeqList = vacancySeqList;
	}

	/**
	 * @return the applicSeqList
	 */
	public List<String> getApplicSeqList() {
		return applicSeqList;
	}

	/**
	 * @param applicSeqList the applicSeqList to set
	 */
	public void setApplicSeqList(List<String> applicSeqList) {
		this.applicSeqList = applicSeqList;
	}

	/**
	 * @return the intvwSeqList
	 */
	public List<String> getIntvwSeqList() {
		return intvwSeqList;
	}

	/**
	 * @param intvwSeqList the intvwSeqList to set
	 */
	public void setIntvwSeqList(List<String> intvwSeqList) {
		this.intvwSeqList = intvwSeqList;
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
	public List<FairMngBean> getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(List<FairMngBean> list) {
		this.list = list;
	}

	public String getCompnyTypeNm() {
		return compnyTypeNm;
	}

	public void setCompnyTypeNm(String compnyTypeNm) {
		this.compnyTypeNm = compnyTypeNm;
	}

}
