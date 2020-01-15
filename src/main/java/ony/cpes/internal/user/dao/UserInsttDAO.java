package ony.cpes.internal.user.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import ony.cpes.internal.user.bean.UserInsttBean;
import ony.cpes.internal.user.bean.UserInsttEduBean;
import ony.cpes.internal.user.bean.UserInsttFairBean;

@Repository("userInsttDAO")
public class UserInsttDAO extends EgovAbstractMapper{
	
	/*
	 * Institution User List
	 */
	public List<UserInsttBean> selectUserInsttInfoListAjax(UserInsttBean param) {
        return getSqlSession().selectList("userInstt.selectUserInsttInfoListAjax", param);
    }
	
	public int selectUserInsttInfoListTotalCnt(UserInsttBean param) {
        return getSqlSession().selectOne("userInstt.selectUserInsttInfoListTotalCnt", param);
	}	
	
	public int deleteUserInfoAjax(UserInsttBean param) {
        return getSqlSession().update("setUserInstt.deleteUserInfoAjax", param);
	}	
	
	public int deleteInsttInfoAjax(UserInsttBean param) {
        return getSqlSession().update("setUserInstt.deleteInsttInfoAjax", param);
	}
	
	/*
	 * Institution User Detail Info Main
	 */
	public UserInsttBean selectUserInsttDtlInfoMain(UserInsttBean param) {
        return getSqlSession().selectOne("userInstt.selectUserInsttDtlInfoMain", param);
    }
	
	/*
	 * Institution User Detail Info Base
	 */
	public UserInsttBean selectUserInsttDtlInfoBaseAjax(UserInsttBean param) {
        return getSqlSession().selectOne("userInstt.selectUserInsttDtlInfoBaseAjax", param);
    }
	
	/*
	 * Institution Detail Info Profile
	 */
	public UserInsttBean selectUserInsttDtlInfoProfile(UserInsttBean param) {
        return getSqlSession().selectOne("userInstt.selectUserInsttDtlInfoProfile", param);
    }
	
	/*
	 * Institution Detail Info Image
	 */
	public UserInsttBean selectUserInsttDtlInfoImg(UserInsttBean param) {
        return getSqlSession().selectOne("userInstt.selectUserInsttDtlInfoImg", param);
    }
	
	/*
	 * Institution Detail Info Education Training
	 */
	public List<UserInsttEduBean> selectUserInsttDtlInfoEduList(UserInsttEduBean param) {
        return getSqlSession().selectList("userInstt.selectUserInsttDtlInfoEduList", param);
    }
	
	public int selectUserInsttDtlInfoEduListTotalCnt(UserInsttEduBean param) {
        return getSqlSession().selectOne("userInstt.selectUserInsttDtlInfoEduListTotalCnt", param);
	}	
	
	/*
	 * Institution Detail Info Job Fair
	 */
	public List<UserInsttFairBean> selectUserInsttDtlInfoJobfairList(UserInsttFairBean param) {
        return getSqlSession().selectList("userInstt.selectUserInsttDtlInfoJobfairList", param);
    }
	
	public int selectUserInsttDtlInfoJobfairListTotalCnt(UserInsttFairBean param) {
        return getSqlSession().selectOne("userInstt.selectUserInsttDtlInfoJobfairListTotalCnt", param);
	}		

}
