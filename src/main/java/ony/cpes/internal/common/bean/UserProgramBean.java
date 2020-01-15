package ony.cpes.internal.common.bean;

import java.util.ArrayList;
import java.util.List;

import ony.cmm.common.bean.CommonBean;
import ony.cpes.internal.user.bean.UserBean;

/**
 *
 * <pre>
 *
 * </pre>
 */
public class UserProgramBean extends CommonBean {

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 4979179976898050104L;

	private String userSeq					=	"";
	private String menuProgramMapSeq		=	"";
	private String menuCd					=	"";
	private String programSeq				=	"";
	private String priProgramYn				=	"";
	private String programNmKh				=	"";
	private String programNm				=	"";
	private String programNmEn				=	"";
	private String programUrl				=	"";

	
	
	public String getProgramNmKh() {
		return programNmKh;
	}
	public void setProgramNmKh(String programNmKh) {
		this.programNmKh = programNmKh;
	}
	public String getProgramNm() {
		return programNm;
	}
	public void setProgramNm(String programNm) {
		this.programNm = programNm;
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
	public String getPriProgramYn() {
		return priProgramYn;
	}
	public void setPriProgramYn(String priProgramYn) {
		this.priProgramYn = priProgramYn;
	}
	
	
	
}
