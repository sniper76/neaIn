package ony.cpes.internal.referral.bean;

import java.util.List;

import ony.cmm.common.bean.CommonBean;
import ony.cpes.internal.resume.bean.ResumeBean;
import ony.cpes.internal.user.bean.UserBean;

/**
 * referral
 * @author onycom
 * @since
 * @version 1.0
 * @see
 *
 * <pre>
 * << (Modification Information) >>
 *
 *  Modify Date     Modifier    Description
 *  ------------- 	-------- 	---------------------------
 *  2019.11.18 		ckw
 *
 * </pre>
 */
public class ReferralMatchBean extends CommonBean{

	private static final long serialVersionUID = 4979179976898050104L;
	
	/* Data Variable */
	private String resumeSeq   = "";
	private String userSeq     = "";
	private String userNm      = "";
	private String resumeTitle = "";
	private String nowWorkSts  = "";
	private String userAuthCd  = "";
	private String cell        = "";
	private String emailAddr   = "";
	private String modDt       = "";
	private String jcNm        = "";
	private String jcCd        = "";
	private String jobskStsCd  = "";
	private String jobskReqSeq = "";
	private String 	fullUserNm  			= "";
	private String  age                     = "";
	private String email                    = "";
	private String gender                   = "";
	private String addrDtl                  = "";
	private String rank                     = "";
	private String rate                     = "";
	private String compnyNm                 = "";
	private String vacancyTitle             = "";
	private String location                 = "";
	private String positions                = "";
	private String closeDt                  = "";
	private String resumeSeqCnt             = "";
	private String 	compnySeq				= "";
	private String 	compnyId				= "";
	private String 	compnyNmKh				= "";
	private String 	compnyNmEn				= "";
	private String 	compnyTypeCd			= "";
	private String 	mngerNm					= "";
	private String 	mngerPosition			= "";
	private String 	mngerCell				= "";
	private String 	mngerEmail				= "";
	private String 	mngerTel				= "";
	private String  addrFullNm              = "";
	private String  addrNm                  = "";
	private String  occup                   = "";
	private String  loc                     = "";
	private String  wage                    = "";
	private String  edu                     = "";
	private int     totPoint                    ;
	private String  vacancySeq              = "";
	private String  employFormCd            = "";
	private String  oneDepth            = "";
	private String  twoDepth            = "";
	private String  threeDepth            = "";
	private String  fourDepth            = "";
	private String     province          = "";
	private String     district          = "";
	private String  minEduDegreeCd      = "";
	private int     salary              ;
	private int  expctMinSalaryAmt   ;
	private String  oneDepthNm            = "";
	private String  twoDepthNm            = "";
	private String  threeDepthNm            = "";
	private String  fourDepthNm            = "";
	private String  distNm                 = "";

	private List<ReferralMatchBean> list;
	
	/* Paging Variable */
	private int draw;
    private int recordsTotal		= 0;
    private int recordsFiltered		= 0;
    private int start 				= 0;
    private int length 				= 10;
    private int orderStr 			= 0;
    private String orderColumn 		= "";
    private String orderColumnSort 	= "";
	
    private UserBean user = new UserBean();
    private ResumeBean resume = new ResumeBean();
    private List<UserBean> userList;
    
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
	 * @return the jobskReqSeq
	 */
	public String getJobskReqSeq() {
		return jobskReqSeq;
	}
	/**
	 * @param jobskReqSeq the jobskReqSeq to set
	 */
	public void setJobskReqSeq(String jobskReqSeq) {
		this.jobskReqSeq = jobskReqSeq;
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
	 * @return the nowWorkSts
	 */
	public String getNowWorkSts() {
		return nowWorkSts;
	}
	/**
	 * @param nowWorkSts the nowWorkSts to set
	 */
	public void setNowWorkSts(String nowWorkSts) {
		this.nowWorkSts = nowWorkSts;
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
	 * @return the emailAddr
	 */
	public String getEmailAddr() {
		return emailAddr;
	}
	/**
	 * @param emailAddr the emailAddr to set
	 */
	public void setEmailAddr(String emailAddr) {
		this.emailAddr = emailAddr;
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
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
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
	 * @return the userList
	 */
	public List<UserBean> getUserList() {
		return userList;
	}
	/**
	 * @param userList the userList to set
	 */
	public void setUserList(List<UserBean> userList) {
		this.userList = userList;
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
	 * @return the jcNm
	 */
	public String getJcNm() {
		return jcNm;
	}
	/**
	 * @param jcNm the jcNm to set
	 */
	public void setJcNm(String jcNm) {
		this.jcNm = jcNm;
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
	 * @return the list
	 */
	public List<ReferralMatchBean> getList() {
		return list;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(List<ReferralMatchBean> list) {
		this.list = list;
	}
	/**
	 * @return the draw
	 */
	public int getDraw() {
		return draw;
	}
	/**
	 * @param draw the draw to set
	 */
	public void setDraw(int draw) {
		this.draw = draw;
	}
	/**
	 * @return the recordsTotal
	 */
	public int getRecordsTotal() {
		return recordsTotal;
	}
	/**
	 * @param recordsTotal the recordsTotal to set
	 */
	public void setRecordsTotal(int recordsTotal) {
		this.recordsTotal = recordsTotal;
	}
	/**
	 * @return the recordsFiltered
	 */
	public int getRecordsFiltered() {
		return recordsFiltered;
	}
	/**
	 * @param recordsFiltered the recordsFiltered to set
	 */
	public void setRecordsFiltered(int recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}
	/**
	 * @return the start
	 */
	public int getStart() {
		return start;
	}
	/**
	 * @param start the start to set
	 */
	public void setStart(int start) {
		this.start = start;
	}
	/**
	 * @return the length
	 */
	public int getLength() {
		return length;
	}
	/**
	 * @param length the length to set
	 */
	public void setLength(int length) {
		this.length = length;
	}
	/**
	 * @return the orderStr
	 */
	public int getOrderStr() {
		return orderStr;
	}
	/**
	 * @param orderStr the orderStr to set
	 */
	public void setOrderStr(int orderStr) {
		this.orderStr = orderStr;
	}
	/**
	 * @return the orderColumn
	 */
	public String getOrderColumn() {
		return orderColumn;
	}
	/**
	 * @param orderColumn the orderColumn to set
	 */
	public void setOrderColumn(String orderColumn) {
		this.orderColumn = orderColumn;
	}
	/**
	 * @return the orderColumnSort
	 */
	public String getOrderColumnSort() {
		return orderColumnSort;
	}
	/**
	 * @param orderColumnSort the orderColumnSort to set
	 */
	public void setOrderColumnSort(String orderColumnSort) {
		this.orderColumnSort = orderColumnSort;
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
	 * @return the resume
	 */
	public ResumeBean getResume() {
		return resume;
	}
	/**
	 * @param resume the resume to set
	 */
	public void setResume(ResumeBean resume) {
		this.resume = resume;
	}
	/**
	 * @return the fullUserNm
	 */
	public String getFullUserNm() {
		return fullUserNm;
	}
	/**
	 * @param fullUserNm the fullUserNm to set
	 */
	public void setFullUserNm(String fullUserNm) {
		this.fullUserNm = fullUserNm;
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
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
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
	 * @return the rank
	 */
	public String getRank() {
		return rank;
	}
	/**
	 * @param rank the rank to set
	 */
	public void setRank(String rank) {
		this.rank = rank;
	}
	/**
	 * @return the rate
	 */
	public String getRate() {
		return rate;
	}
	/**
	 * @param rate the rate to set
	 */
	public void setRate(String rate) {
		this.rate = rate;
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
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @return the positions
	 */
	public String getPositions() {
		return positions;
	}
	/**
	 * @param positions the positions to set
	 */
	public void setPositions(String positions) {
		this.positions = positions;
	}
	/**
	 * @return the closeDt
	 */
	public String getCloseDt() {
		return closeDt;
	}
	/**
	 * @param closeDt the closeDt to set
	 */
	public void setCloseDt(String closeDt) {
		this.closeDt = closeDt;
	}
	/**
	 * @return the resumeSeqCnt
	 */
	public String getResumeSeqCnt() {
		return resumeSeqCnt;
	}
	/**
	 * @param resumeSeqCnt the resumeSeqCnt to set
	 */
	public void setResumeSeqCnt(String resumeSeqCnt) {
		this.resumeSeqCnt = resumeSeqCnt;
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
	 * @return the compnyId
	 */
	public String getCompnyId() {
		return compnyId;
	}
	/**
	 * @param compnyId the compnyId to set
	 */
	public void setCompnyId(String compnyId) {
		this.compnyId = compnyId;
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
	 * @return the mngerPosition
	 */
	public String getMngerPosition() {
		return mngerPosition;
	}
	/**
	 * @param mngerPosition the mngerPosition to set
	 */
	public void setMngerPosition(String mngerPosition) {
		this.mngerPosition = mngerPosition;
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
	 * @return the mngerTel
	 */
	public String getMngerTel() {
		return mngerTel;
	}
	/**
	 * @param mngerTel the mngerTel to set
	 */
	public void setMngerTel(String mngerTel) {
		this.mngerTel = mngerTel;
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
	 * @return the occup
	 */
	public String getOccup() {
		return occup;
	}
	/**
	 * @param occup the occup to set
	 */
	public void setOccup(String occup) {
		this.occup = occup;
	}
	/**
	 * @return the loc
	 */
	public String getLoc() {
		return loc;
	}
	/**
	 * @param loc the loc to set
	 */
	public void setLoc(String loc) {
		this.loc = loc;
	}
	/**
	 * @return the wage
	 */
	public String getWage() {
		return wage;
	}
	/**
	 * @param wage the wage to set
	 */
	public void setWage(String wage) {
		this.wage = wage;
	}
	/**
	 * @return the edu
	 */
	public String getEdu() {
		return edu;
	}
	/**
	 * @param edu the edu to set
	 */
	public void setEdu(String edu) {
		this.edu = edu;
	}
	
	/**
	 * @return the totPoint
	 */
	public int getTotPoint() {
		return totPoint;
	}
	/**
	 * @param totPoint the totPoint to set
	 */
	public void setTotPoint(int totPoint) {
		this.totPoint = totPoint;
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
	 * @return the province
	 */
	public String getProvince() {
		return province;
	}
	/**
	 * @param province the province to set
	 */
	public void setProvince(String province) {
		this.province = province;
	}
	/**
	 * @return the district
	 */
	public String getDistrict() {
		return district;
	}
	/**
	 * @param district the district to set
	 */
	public void setDistrict(String district) {
		this.district = district;
	}
	/**
	 * @return the minEduDegreeCd
	 */
	public String getMinEduDegreeCd() {
		return minEduDegreeCd;
	}
	/**
	 * @param minEduDegreeCd the minEduDegreeCd to set
	 */
	public void setMinEduDegreeCd(String minEduDegreeCd) {
		this.minEduDegreeCd = minEduDegreeCd;
	}
	/**
	 * @return the salary
	 */
	public int getSalary() {
		return salary;
	}
	/**
	 * @param salary the salary to set
	 */
	public void setSalary(int salary) {
		this.salary = salary;
	}
	/**
	 * @return the expctMinSalaryAmt
	 */
	public int getExpctMinSalaryAmt() {
		return expctMinSalaryAmt;
	}
	/**
	 * @param expctMinSalaryAmt the expctMinSalaryAmt to set
	 */
	public void setExpctMinSalaryAmt(int expctMinSalaryAmt) {
		this.expctMinSalaryAmt = expctMinSalaryAmt;
	}
	/**
	 * @return the oneDepthNm
	 */
	public String getOneDepthNm() {
		return oneDepthNm;
	}
	/**
	 * @param oneDepthNm the oneDepthNm to set
	 */
	public void setOneDepthNm(String oneDepthNm) {
		this.oneDepthNm = oneDepthNm;
	}
	/**
	 * @return the twoDepthNm
	 */
	public String getTwoDepthNm() {
		return twoDepthNm;
	}
	/**
	 * @param twoDepthNm the twoDepthNm to set
	 */
	public void setTwoDepthNm(String twoDepthNm) {
		this.twoDepthNm = twoDepthNm;
	}
	/**
	 * @return the threeDepthNm
	 */
	public String getThreeDepthNm() {
		return threeDepthNm;
	}
	/**
	 * @param threeDepthNm the threeDepthNm to set
	 */
	public void setThreeDepthNm(String threeDepthNm) {
		this.threeDepthNm = threeDepthNm;
	}
	/**
	 * @return the fourDepthNm
	 */
	public String getFourDepthNm() {
		return fourDepthNm;
	}
	/**
	 * @param fourDepthNm the fourDepthNm to set
	 */
	public void setFourDepthNm(String fourDepthNm) {
		this.fourDepthNm = fourDepthNm;
	}
	/**
	 * @return the distNm
	 */
	public String getDistNm() {
		return distNm;
	}
	/**
	 * @param distNm the distNm to set
	 */
	public void setDistNm(String distNm) {
		this.distNm = distNm;
	}
    
    
}