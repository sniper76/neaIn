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
public class MenuBean extends CommonBean{

	private static final long serialVersionUID = 4979179976898050104L;

	private String menuCd		=	"";
	private String upperMenuCd	=	"";
	private String menuNmKh		=	"";
	private String menuNm		=	"";
	private String menuNmEn		=	"";
	private String menuNmKr		=	"";
	private String menuLvl		=	"";
	private String menuSort		=	"";
	private String menuUrl		=	"";
	private String useYn		=	"";
	private String bulletinYn	=	"";
	private String menuOrder	=	"";
	private String parameter	=	"";
	private String fullMenuCd	=	"";
	private String rangeCd		=	"";
	private String priProgramSeq	=	"";
	private String programSeqTemp	=	"";
	private String programSeqArr	=	"";
	private String programUrl		=	"";
	
	private String menu1DepthCd		=	"";
	private String menu2DepthCd		=	"";
	private String menu3DepthCd		=	"";
	private String menu4DepthCd		=	"";
	
	private String menu1DepthNm		=	"";
	private String menu2DepthNm		=	"";
	private String menu3DepthNm		=	"";
	private String menu4DepthNm		=	"";
	
	private String menu1DepthCdChk	=	"";
	private String menu2DepthCdChk	=	"";
	private String menu3DepthCdChk	=	"";
	private String menu4DepthCdChk	=	"";
	
	private String userMenuCd		=	"";
	
	private String userSeq			=	"";
	
	private List<MenuProgramMapBean> menuProgramMapList = new ArrayList<MenuProgramMapBean>();
	
	private List<MenuBean> tailListMenu = new ArrayList<MenuBean>();
	private List<MenuBean> menuAuthList = new ArrayList<MenuBean>();
	
	private String menuAuthYn		=	"";
	private String menu1AuthYn		=	"";
	private String menu2AuthYn		=	"";
	private String menu3AuthYn		=	"";
	private String menu4AuthYn		=	"";
	
	public String getMenuAuthYn() {
		return menuAuthYn;
	}

	public void setMenuAuthYn(String menuAuthYn) {
		this.menuAuthYn = menuAuthYn;
	}

	public String getMenu1AuthYn() {
		return menu1AuthYn;
	}

	public void setMenu1AuthYn(String menu1AuthYn) {
		this.menu1AuthYn = menu1AuthYn;
	}

	public String getMenu2AuthYn() {
		return menu2AuthYn;
	}

	public void setMenu2AuthYn(String menu2AuthYn) {
		this.menu2AuthYn = menu2AuthYn;
	}

	public String getMenu3AuthYn() {
		return menu3AuthYn;
	}

	public void setMenu3AuthYn(String menu3AuthYn) {
		this.menu3AuthYn = menu3AuthYn;
	}

	public String getMenu4AuthYn() {
		return menu4AuthYn;
	}

	public void setMenu4AuthYn(String menu4AuthYn) {
		this.menu4AuthYn = menu4AuthYn;
	}

	public String getUserMenuCd() {
		return userMenuCd;
	}

	public void setUserMenuCd(String userMenuCd) {
		this.userMenuCd = userMenuCd;
	}

	public String getMenu1DepthCdChk() {
		return menu1DepthCdChk;
	}

	public void setMenu1DepthCdChk(String menu1DepthCdChk) {
		this.menu1DepthCdChk = menu1DepthCdChk;
	}

	public String getMenu2DepthCdChk() {
		return menu2DepthCdChk;
	}

	public void setMenu2DepthCdChk(String menu2DepthCdChk) {
		this.menu2DepthCdChk = menu2DepthCdChk;
	}

	public String getMenu3DepthCdChk() {
		return menu3DepthCdChk;
	}

	public void setMenu3DepthCdChk(String menu3DepthCdChk) {
		this.menu3DepthCdChk = menu3DepthCdChk;
	}

	public String getMenu4DepthCdChk() {
		return menu4DepthCdChk;
	}

	public void setMenu4DepthCdChk(String menu4DepthCdChk) {
		this.menu4DepthCdChk = menu4DepthCdChk;
	}

	public String getMenu4DepthCd() {
		return menu4DepthCd;
	}

	public void setMenu4DepthCd(String menu4DepthCd) {
		this.menu4DepthCd = menu4DepthCd;
	}

	public String getMenu1DepthNm() {
		return menu1DepthNm;
	}

	public void setMenu1DepthNm(String menu1DepthNm) {
		this.menu1DepthNm = menu1DepthNm;
	}

	public String getMenu2DepthNm() {
		return menu2DepthNm;
	}

	public void setMenu2DepthNm(String menu2DepthNm) {
		this.menu2DepthNm = menu2DepthNm;
	}

	public String getMenu3DepthNm() {
		return menu3DepthNm;
	}

	public void setMenu3DepthNm(String menu3DepthNm) {
		this.menu3DepthNm = menu3DepthNm;
	}

	public String getMenu4DepthNm() {
		return menu4DepthNm;
	}

	public void setMenu4DepthNm(String menu4DepthNm) {
		this.menu4DepthNm = menu4DepthNm;
	}

	public List<MenuBean> getMenuAuthList() {
		return menuAuthList;
	}

	public void setMenuAuthList(List<MenuBean> menuAuthList) {
		this.menuAuthList = menuAuthList;
	}

	public String getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(String userSeq) {
		this.userSeq = userSeq;
	}

	public String getProgramUrl() {
		return programUrl;
	}

	public void setProgramUrl(String programUrl) {
		this.programUrl = programUrl;
	}

	public String getProgramSeqArr() {
		return programSeqArr;
	}

	public void setProgramSeqArr(String programSeqArr) {
		this.programSeqArr = programSeqArr;
	}

	public String getMenu1DepthCd() {
		return menu1DepthCd;
	}

	public void setMenu1DepthCd(String menu1DepthCd) {
		this.menu1DepthCd = menu1DepthCd;
	}

	public String getMenu2DepthCd() {
		return menu2DepthCd;
	}

	public void setMenu2DepthCd(String menu2DepthCd) {
		this.menu2DepthCd = menu2DepthCd;
	}

	public String getMenu3DepthCd() {
		return menu3DepthCd;
	}

	public void setMenu3DepthCd(String menu3DepthCd) {
		this.menu3DepthCd = menu3DepthCd;
	}

	public List<MenuProgramMapBean> getMenuProgramMapList() {
		return menuProgramMapList;
	}

	public void setMenuProgramMapList(List<MenuProgramMapBean> menuProgramMapList) {
		this.menuProgramMapList = menuProgramMapList;
	}

	public String getProgramSeqTemp() {
		return programSeqTemp;
	}

	public void setProgramSeqTemp(String programSeqTemp) {
		this.programSeqTemp = programSeqTemp;
	}

	public String getPriProgramSeq() {
		return priProgramSeq;
	}

	public void setPriProgramSeq(String priProgramSeq) {
		this.priProgramSeq = priProgramSeq;
	}

	public String getRangeCd() {
		return rangeCd;
	}

	public void setRangeCd(String rangeCd) {
		this.rangeCd = rangeCd;
	}

	public String getFullMenuCd() {
		return fullMenuCd;
	}

	public void setFullMenuCd(String fullMenuCd) {
		this.fullMenuCd = fullMenuCd;
	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	public String getMenuOrder() {
		return menuOrder;
	}

	public void setMenuOrder(String menuOrder) {
		this.menuOrder = menuOrder;
	}

	public String getMenuNm() {
		return menuNm;
	}

	public void setMenuNm(String menuNm) {
		this.menuNm = menuNm;
	}

	public String getMenuCd() {
		return menuCd;
	}

	public void setMenuCd(String menuCd) {
		this.menuCd = menuCd;
	}

	public String getUpperMenuCd() {
		return upperMenuCd;
	}

	public void setUpperMenuCd(String upperMenuCd) {
		this.upperMenuCd = upperMenuCd;
	}

	public String getMenuNmKh() {
		return menuNmKh;
	}

	public void setMenuNmKh(String menuNmKh) {
		this.menuNmKh = menuNmKh;
	}

	public String getMenuNmEn() {
		return menuNmEn;
	}

	public void setMenuNmEn(String menuNmEn) {
		this.menuNmEn = menuNmEn;
	}

	public String getMenuNmKr() {
		return menuNmKr;
	}

	public void setMenuNmKr(String menuNmKr) {
		this.menuNmKr = menuNmKr;
	}

	public String getMenuLvl() {
		return menuLvl;
	}

	public void setMenuLvl(String menuLvl) {
		this.menuLvl = menuLvl;
	}

	public String getMenuSort() {
		return menuSort;
	}

	public void setMenuSort(String menuSort) {
		this.menuSort = menuSort;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public String getUseYn() {
		return useYn;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

	public String getBulletinYn() {
		return bulletinYn;
	}

	public void setBulletinYn(String bulletinYn) {
		this.bulletinYn = bulletinYn;
	}

	public List<MenuBean> getTailListMenu() {
		return tailListMenu;
	}

	public void setTailListMenu(List<MenuBean> tailListMenu) {
		this.tailListMenu = tailListMenu;
	}
	
	
	
}
