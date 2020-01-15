package ony.cmm.common.bean;


/**
 * 사용자 메뉴권한 정보
 * @author (주)한신정보기술 연구개발팀 최관형
 * @since
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *  수정일           수정자     수정내용
 *  ------------- -------- ---------------------------
 *  2019.07.22 이윤희
 *
 * </pre>
 */
public class CustomUserMenuInfoBean {

	private static final long serialVersionUID = 4979179976898050104L;

	 private String menuCd = "";
	 private String upperMenuCd = "";
	 private String menuNmKh = "";
	 private String menuNmEn = "";
	 private String menuNmKr = "";
     private String menuLvl = "";
     private String menuSort = "";
     private String menuGrpCd = "";
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
	public String getMenuGrpCd() {
		return menuGrpCd;
	}
	public void setMenuGrpCd(String menuGrpCd) {
		this.menuGrpCd = menuGrpCd;
	}
	
     
     
	
}
