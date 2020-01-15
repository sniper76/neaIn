package ony.cmm.common.bean;

import ony.framework.bean.PagingBean;

/**
 * bean 공통정보를 담는 bean
 *
 * @author 우성택
 * @version 1.0
 * @since 2019.01.02
 */
public class SysConnLogBean extends PagingBean{

	private int sysConnLog = 0;
	private String userSeq = "";
	private String sessionId = "";
	private String userIp = "";
	private String url = "";
	private String connDt = "";
	private String programSeq = "";
	private String rangeCd = "";
	private String regUserSeq = "";
	private String regDt = "";
	
	public int getSysConnLog() {
		return sysConnLog;
	}
	public void setSysConnLog(int sysConnLog) {
		this.sysConnLog = sysConnLog;
	}
	public String getUserSeq() {
		return userSeq;
	}
	public void setUserSeq(String userSeq) {
		this.userSeq = userSeq;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getUserIp() {
		return userIp;
	}
	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getConnDt() {
		return connDt;
	}
	public void setConnDt(String connDt) {
		this.connDt = connDt;
	}
	public String getProgramSeq() {
		return programSeq;
	}
	public void setProgramSeq(String programSeq) {
		this.programSeq = programSeq;
	}
	public String getRangeCd() {
		return rangeCd;
	}
	public void setRangeCd(String rangeCd) {
		this.rangeCd = rangeCd;
	}
	public String getRegUserSeq() {
		return regUserSeq;
	}
	public void setRegUserSeq(String regUserSeq) {
		this.regUserSeq = regUserSeq;
	}
	public String getRegDt() {
		return regDt;
	}
	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}
		
}
