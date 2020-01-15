package ony.cpes.internal.fair.bean;

import java.util.Date;
import java.util.List;

import ony.cmm.common.bean.CommonBean;

public class FairWorkshopBean extends CommonBean{
	private String fairWorkshopSeq;
	private String fairSeq;
	private String workshopNm;
	private String expln;
	private String workshopThumFileGrpSeq;
	private String workshopDt;
	private String bgnHour;
	private String bgnMinute;
	private String bgnAmpm;
	private String endHour;
	private String endMinute;
	private String endAmpm;
	private String workshopAddrCd;
	private String workshopAddrFullCd;
	private String workshopAddrFullNm;
	private String workshopAddrDtl;
	private String lectureRoom;
	private String tuitionGrpCd;
	private String tuition;
	private String googleMapLink;
	private String mngerNm;
	private String mngerTel;
	private String mngerEmail;
	private String target;
	private String recurmtMan;
	private String teacherNm1;
	private String teacherNm2;
	private String teacherPhoto1FileGrpSeq;
	private String teacherPhoto2FileGrpSeq;
	private String teacherBhist1;
	private String teacherBhist2;
	private String teachFileGrpSeq;
	private String useYn;
	private String workshopStsCd;
	private String delYn;

	private String patcptnCnt;
	private String recurmtType;
	private String uploadResult;
	private Date workshopDtDate;
	private String workshopStsNm;
	private String thumFilePath;
	private String teacherPhoto1FilePath;
	private String teacherPhoto2FilePath;
	private String modUserNm;

	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	public String getModUserNm() {
		return modUserNm;
	}
	public void setModUserNm(String modUserNm) {
		this.modUserNm = modUserNm;
	}
	public String getThumFilePath() {
		return thumFilePath;
	}
	public void setThumFilePath(String thumFilePath) {
		this.thumFilePath = thumFilePath;
	}
	public String getTeacherPhoto1FilePath() {
		return teacherPhoto1FilePath;
	}
	public void setTeacherPhoto1FilePath(String teacherPhoto1FilePath) {
		this.teacherPhoto1FilePath = teacherPhoto1FilePath;
	}
	public String getTeacherPhoto2FilePath() {
		return teacherPhoto2FilePath;
	}
	public void setTeacherPhoto2FilePath(String teacherPhoto2FilePath) {
		this.teacherPhoto2FilePath = teacherPhoto2FilePath;
	}
	public String getWorkshopStsNm() {
		return workshopStsNm;
	}
	public void setWorkshopStsNm(String workshopStsNm) {
		this.workshopStsNm = workshopStsNm;
	}
	public String getWorkshopStsCd() {
		return workshopStsCd;
	}
	public void setWorkshopStsCd(String workshopStsCd) {
		this.workshopStsCd = workshopStsCd;
	}
	public Date getWorkshopDtDate() {
		return workshopDtDate;
	}
	public void setWorkshopDtDate(Date workshopDtDate) {
		this.workshopDtDate = workshopDtDate;
	}
	public String getUploadResult() {
		return uploadResult;
	}
	public void setUploadResult(String uploadResult) {
		this.uploadResult = uploadResult;
	}
	private List<FairWorkshopBean> list;

	public String getRecurmtType() {
		return recurmtType;
	}
	public void setRecurmtType(String recurmtType) {
		this.recurmtType = recurmtType;
	}
	public List<FairWorkshopBean> getList() {
		return list;
	}
	public void setList(List<FairWorkshopBean> list) {
		this.list = list;
	}
	public String getPatcptnCnt() {
		return patcptnCnt;
	}
	public void setPatcptnCnt(String patcptnCnt) {
		this.patcptnCnt = patcptnCnt;
	}
	public String getFairWorkshopSeq() {
		return fairWorkshopSeq;
	}
	public void setFairWorkshopSeq(String fairWorkshopSeq) {
		this.fairWorkshopSeq = fairWorkshopSeq;
	}
	public String getFairSeq() {
		return fairSeq;
	}
	public void setFairSeq(String fairSeq) {
		this.fairSeq = fairSeq;
	}
	public String getWorkshopNm() {
		return workshopNm;
	}
	public void setWorkshopNm(String workshopNm) {
		this.workshopNm = workshopNm;
	}
	public String getExpln() {
		return expln;
	}
	public void setExpln(String expln) {
		this.expln = expln;
	}
	public String getWorkshopThumFileGrpSeq() {
		return workshopThumFileGrpSeq;
	}
	public void setWorkshopThumFileGrpSeq(String workshopThumFileGrpSeq) {
		this.workshopThumFileGrpSeq = workshopThumFileGrpSeq;
	}
	public String getWorkshopDt() {
		return workshopDt;
	}
	public void setWorkshopDt(String workshopDt) {
		this.workshopDt = workshopDt;
	}
	public String getBgnHour() {
		return bgnHour;
	}
	public void setBgnHour(String bgnHour) {
		this.bgnHour = bgnHour;
	}
	public String getBgnMinute() {
		return bgnMinute;
	}
	public void setBgnMinute(String bgnMinute) {
		this.bgnMinute = bgnMinute;
	}
	public String getBgnAmpm() {
		return bgnAmpm;
	}
	public void setBgnAmpm(String bgnAmpm) {
		this.bgnAmpm = bgnAmpm;
	}
	public String getEndHour() {
		return endHour;
	}
	public void setEndHour(String endHour) {
		this.endHour = endHour;
	}
	public String getEndMinute() {
		return endMinute;
	}
	public void setEndMinute(String endMinute) {
		this.endMinute = endMinute;
	}
	public String getEndAmpm() {
		return endAmpm;
	}
	public void setEndAmpm(String endAmpm) {
		this.endAmpm = endAmpm;
	}
	public String getWorkshopAddrCd() {
		return workshopAddrCd;
	}
	public void setWorkshopAddrCd(String workshopAddrCd) {
		this.workshopAddrCd = workshopAddrCd;
	}
	public String getWorkshopAddrFullCd() {
		return workshopAddrFullCd;
	}
	public void setWorkshopAddrFullCd(String workshopAddrFullCd) {
		this.workshopAddrFullCd = workshopAddrFullCd;
	}
	public String getWorkshopAddrFullNm() {
		return workshopAddrFullNm;
	}
	public void setWorkshopAddrFullNm(String workshopAddrFullNm) {
		this.workshopAddrFullNm = workshopAddrFullNm;
	}
	public String getWorkshopAddrDtl() {
		return workshopAddrDtl;
	}
	public void setWorkshopAddrDtl(String workshopAddrDtl) {
		this.workshopAddrDtl = workshopAddrDtl;
	}
	public String getLectureRoom() {
		return lectureRoom;
	}
	public void setLectureRoom(String lectureRoom) {
		this.lectureRoom = lectureRoom;
	}
	public String getTuitionGrpCd() {
		return tuitionGrpCd;
	}
	public void setTuitionGrpCd(String tuitionGrpCd) {
		this.tuitionGrpCd = tuitionGrpCd;
	}
	public String getTuition() {
		return tuition;
	}
	public void setTuition(String tuition) {
		this.tuition = tuition;
	}
	public String getGoogleMapLink() {
		return googleMapLink;
	}
	public void setGoogleMapLink(String googleMapLink) {
		this.googleMapLink = googleMapLink;
	}
	public String getMngerNm() {
		return mngerNm;
	}
	public void setMngerNm(String mngerNm) {
		this.mngerNm = mngerNm;
	}
	public String getMngerTel() {
		return mngerTel;
	}
	public void setMngerTel(String mngerTel) {
		this.mngerTel = mngerTel;
	}
	public String getMngerEmail() {
		return mngerEmail;
	}
	public void setMngerEmail(String mngerEmail) {
		this.mngerEmail = mngerEmail;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getRecurmtMan() {
		return recurmtMan;
	}
	public void setRecurmtMan(String recurmtMan) {
		this.recurmtMan = recurmtMan;
	}
	public String getTeacherNm1() {
		return teacherNm1;
	}
	public void setTeacherNm1(String teacherNm1) {
		this.teacherNm1 = teacherNm1;
	}
	public String getTeacherNm2() {
		return teacherNm2;
	}
	public void setTeacherNm2(String teacherNm2) {
		this.teacherNm2 = teacherNm2;
	}
	public String getTeacherPhoto1FileGrpSeq() {
		return teacherPhoto1FileGrpSeq;
	}
	public void setTeacherPhoto1FileGrpSeq(String teacherPhoto1FileGrpSeq) {
		this.teacherPhoto1FileGrpSeq = teacherPhoto1FileGrpSeq;
	}
	public String getTeacherPhoto2FileGrpSeq() {
		return teacherPhoto2FileGrpSeq;
	}
	public void setTeacherPhoto2FileGrpSeq(String teacherPhoto2FileGrpSeq) {
		this.teacherPhoto2FileGrpSeq = teacherPhoto2FileGrpSeq;
	}
	public String getTeacherBhist1() {
		return teacherBhist1;
	}
	public void setTeacherBhist1(String teacherBhist1) {
		this.teacherBhist1 = teacherBhist1;
	}
	public String getTeacherBhist2() {
		return teacherBhist2;
	}
	public void setTeacherBhist2(String teacherBhist2) {
		this.teacherBhist2 = teacherBhist2;
	}
	public String getTeachFileGrpSeq() {
		return teachFileGrpSeq;
	}
	public void setTeachFileGrpSeq(String teachFileGrpSeq) {
		this.teachFileGrpSeq = teachFileGrpSeq;
	}
	public String getUseYn() {
		return useYn;
	}
	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

}
