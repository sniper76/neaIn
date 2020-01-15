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
public class UserMenuBean extends CommonBean {

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 4979179976898050104L;

	private String userSeq		=	"";
	private String menuCd		=	"";
	private String mngId		=	"";
	private MenuBean	menu	=	new MenuBean();
	private UserBean 	user	=	new UserBean();
	private List<MenuBean> 	userMenuList	=	new ArrayList<MenuBean>();
	private List<String> m1List = new ArrayList<String>();
	private List<String> m2List = new ArrayList<String>();
	private List<String> m3List = new ArrayList<String>();
	private List<String> m4List = new ArrayList<String>();
	private List<String> proList = new ArrayList<String>();
	
	
	public List<String> getProList() {
		return proList;
	}
	public void setProList(List<String> proList) {
		this.proList = proList;
	}
	public List<String> getM1List() {
		return m1List;
	}
	public void setM1List(List<String> m1List) {
		this.m1List = m1List;
	}
	public List<String> getM2List() {
		return m2List;
	}
	public void setM2List(List<String> m2List) {
		this.m2List = m2List;
	}
	public List<String> getM3List() {
		return m3List;
	}
	public void setM3List(List<String> m3List) {
		this.m3List = m3List;
	}
	public List<String> getM4List() {
		return m4List;
	}
	public void setM4List(List<String> m4List) {
		this.m4List = m4List;
	}
	public List<MenuBean> getUserMenuList() {
		return userMenuList;
	}
	public void setUserMenuList(List<MenuBean> userMenuList) {
		this.userMenuList = userMenuList;
	}
	public UserBean getUser() {
		return user;
	}
	public void setUser(UserBean user) {
		this.user = user;
	}
	public String getMngId() {
		return mngId;
	}
	public void setMngId(String mngId) {
		this.mngId = mngId;
	}
	private List<UserMenuBean> list = new ArrayList<UserMenuBean>();
	
	public List<UserMenuBean> getList() {
		return list;
	}
	public void setList(List<UserMenuBean> list) {
		this.list = list;
	}
	public MenuBean getMenu() {
		return menu;
	}
	public void setMenu(MenuBean menu) {
		this.menu = menu;
	}
	public String getUserSeq() {
		return userSeq;
	}
	public void setUserSeq(String userSeq) {
		this.userSeq = userSeq;
	}
	public String getMenuCd() {
		return menuCd;
	}
	public void setMenuCd(String menuCd) {
		this.menuCd = menuCd;
	}
	
	

}
