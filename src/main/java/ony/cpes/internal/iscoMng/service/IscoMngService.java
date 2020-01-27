package ony.cpes.internal.iscoMng.service;

import ony.cmm.common.bean.IscoBean;

public interface IscoMngService {
	public IscoBean selectIscoMngList(IscoBean param);
	public IscoBean selectIscoMngDetail(IscoBean param);
	public int updateIscoMng(IscoBean param);
}
