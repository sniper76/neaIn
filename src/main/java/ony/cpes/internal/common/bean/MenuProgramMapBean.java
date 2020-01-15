package ony.cpes.internal.common.bean;

import ony.cmm.common.bean.CommonBean;

/**
 *
 * <pre>
 *
 * </pre>
 */
public class MenuProgramMapBean extends CommonBean{

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 4979179976898050104L;

	private String menuProgramMapSeq		=	"";
	private String menuCd					=	"";
	private String programSeq				=	"";
	private String priProgramYn				=	"";
	private String priProgramSeq			=	"";
	private String programNm				=	"";
	private String programNmKh				=	"";
	private String programNmEn				=	"";
	private String programUrl				=	"";
	private String userSeq					=	"";
	private String userProgramMapSeq		=	"";
	private String programAuthYn			=	"";
	private String depthNm					=	"";
	
	
	public String getDepthNm() {
		return depthNm;
	}
	public void setDepthNm(String depthNm) {
		this.depthNm = depthNm;
	}
	public String getProgramAuthYn() {
		return programAuthYn;
	}
	public void setProgramAuthYn(String programAuthYn) {
		this.programAuthYn = programAuthYn;
	}
	public String getUserProgramMapSeq() {
		return userProgramMapSeq;
	}
	public void setUserProgramMapSeq(String userProgramMapSeq) {
		this.userProgramMapSeq = userProgramMapSeq;
	}
	public String getProgramNmKh() {
		return programNmKh;
	}
	public void setProgramNmKh(String programNmKh) {
		this.programNmKh = programNmKh;
	}
	public String getProgramNmEn() {
		return programNmEn;
	}
	public void setProgramNmEn(String programNmEn) {
		this.programNmEn = programNmEn;
	}
	public String getProgramUrl() {
		return programUrl;
	}
	public void setProgramUrl(String programUrl) {
		this.programUrl = programUrl;
	}
	public String getUserSeq() {
		return userSeq;
	}
	public void setUserSeq(String userSeq) {
		this.userSeq = userSeq;
	}
	public String getProgramNm() {
		return programNm;
	}
	public void setProgramNm(String programNm) {
		this.programNm = programNm;
	}
	public String getPriProgramSeq() {
		return priProgramSeq;
	}
	public void setPriProgramSeq(String priProgramSeq) {
		this.priProgramSeq = priProgramSeq;
	}
	public String getPriProgramYn() {
		return priProgramYn;
	}
	public void setPriProgramYn(String priProgramYn) {
		this.priProgramYn = priProgramYn;
	}
	public String getMenuProgramMapSeq() {
		return menuProgramMapSeq;
	}
	public void setMenuProgramMapSeq(String menuProgramMapSeq) {
		this.menuProgramMapSeq = menuProgramMapSeq;
	}
	public String getMenuCd() {
		return menuCd;
	}
	public void setMenuCd(String menuCd) {
		this.menuCd = menuCd;
	}
	public String getProgramSeq() {
		return programSeq;
	}
	public void setProgramSeq(String programSeq) {
		this.programSeq = programSeq;
	}
	
	
	
}
