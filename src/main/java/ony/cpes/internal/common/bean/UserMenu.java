package ony.cpes.internal.common.bean;

import java.util.ArrayList;
import java.util.List;

import ony.cmm.common.bean.CommonBean;

/**
 *
 * <pre>
 *
 * </pre>
 */
public class UserMenu extends CommonBean{

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 4979179976898050104L;

	private String userSeq				=	"";
	private String menuProgramMapSeq	=	"";
	private String priProgramYn			=	"";
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
	public String getPriProgramYn() {
		return priProgramYn;
	}
	public void setPriProgramYn(String priProgramYn) {
		this.priProgramYn = priProgramYn;
	}
	
	
	
}
