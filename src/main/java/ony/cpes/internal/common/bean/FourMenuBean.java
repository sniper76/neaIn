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
public class FourMenuBean extends CommonBean{

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 4979179976898050104L;

	private String menuCd		=	"";
	private String upperMenuCd	=	"";
	private String menuNmKh		=	"";
	private String menuNmEn		=	"";
	private String menuNmKr		=	"";
	private String menuLvl		=	"";
	private String menuSort		=	"";
	private String menuUrl		=	"";
	private String useYn		=	"";
	private String bulletinYn	=	"";
	
	private FourMenuBean menu		=	new FourMenuBean();
	
	
	private List<FourMenuBean> list = new ArrayList<FourMenuBean>();
	
	public FourMenuBean getMenu() {
		return menu;
	}
	public void setMenu(FourMenuBean menu) {
		this.menu = menu;
	}
	public List<FourMenuBean> getList() {
		return list;
	}
	public void setList(List<FourMenuBean> list) {
		this.list = list;
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
	
	
	

}
