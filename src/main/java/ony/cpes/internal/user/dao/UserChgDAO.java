package ony.cpes.internal.user.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import ony.cpes.internal.user.bean.UserChgBean;


@Repository("userChgDAO")
public class UserChgDAO extends EgovAbstractMapper{
	
	public List<UserChgBean> selectUserChgList(UserChgBean param) throws Exception {
        return getSqlSession().selectList("userChg.selectUserChgList", param);
    }
	
	public int selectUserChgListTotalCount(UserChgBean param) throws Exception {
        return getSqlSession().selectOne("userChg.selectUserChgListTotalCount", param);
	}	

	public UserChgBean selectUserChgDetail(UserChgBean param) throws Exception {
        return (UserChgBean) getSqlSession().selectOne("userChg.selectUserChgDetail", param);
    }
	
	public int updateUserChgSts(UserChgBean param) throws Exception {
        return getSqlSession().update("userChg.updateUserChgSts", param);
    }
	
	public int updateUserChgAuthCd(UserChgBean param) throws Exception{
        return getSqlSession().update("userChg.updateUserChgAuthCd", param);
    }
}
