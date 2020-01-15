package ony.cpes.internal.user.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import ony.cpes.internal.user.bean.UserCmpnyBean;
import ony.cpes.internal.user.bean.UserCmpnyIsicBean;
import ony.cpes.internal.user.bean.UserCmpnyCommonBean;
import ony.cpes.internal.user.bean.UserCmpnyVccyBean;
import ony.cpes.internal.user.bean.UserCmpnyAplcBean;
import ony.cpes.internal.user.bean.UserCmpnyOfferBean;
import ony.cpes.internal.user.bean.UserCmpnyIntvwBean;
import ony.cpes.internal.user.bean.UserCmpnyFairBean;

@Repository("userCmpnyDAO")
public class UserCmpnyDAO extends EgovAbstractMapper{
	
	/*
	 * Company User List
	 */
	public List<UserCmpnyBean> selectUserCmpnyInfoListAjax(UserCmpnyBean param) {
        return getSqlSession().selectList("userCmpny.selectUserCmpnyInfoListAjax", param);
    }
	
	public int selectUserCmpnyInfoListTotalCnt(UserCmpnyBean param) {
        return getSqlSession().selectOne("userCmpny.selectUserCmpnyInfoListTotalCnt", param);
	}
	
	public List<UserCmpnyIsicBean> selectIsicCdList(UserCmpnyIsicBean param) {
        return getSqlSession().selectList("userCmpny.selectIsicCdList", param);
    }
	
	public int deleteUserInfoAjax(UserCmpnyBean param) {
        return getSqlSession().update("setUserCmpny.deleteUserInfoAjax", param);
	}	
	
	public int deleteCmpnyInfoAjax(UserCmpnyBean param) {
        return getSqlSession().update("setUserCmpny.deleteCmpnyInfoAjax", param);
	}	

    
	/*
	 * User Company Detail Info Main
	 */
	public UserCmpnyBean selectUserCmpnyDtlInfoMain(UserCmpnyBean param) {
        return getSqlSession().selectOne("userCmpny.selectUserCmpnyDtlInfoMain", param);
    }
	
	/*
	 * User Company Detail Info Base
	 */
	public UserCmpnyBean selectUserCmpnyDtlInfoBaseAjax(UserCmpnyBean param) {
        return getSqlSession().selectOne("userCmpny.selectUserCmpnyDtlInfoBaseAjax", param);
    }	
	
	/*
	 * User Company Detail Info Profile
	 */
	public UserCmpnyBean selectUserCmpnyDtlInfoProfileAjax(UserCmpnyBean param) {
        return getSqlSession().selectOne("userCmpny.selectUserCmpnyDtlInfoProfileAjax", param);
    }
	
	/*
	 * User Company Detail Info History

	public UserCmpnyBean selectUserCmpnyDtlInfoHisAjax(UserCmpnyBean param) {
        return getSqlSession().selectOne("userCmpny.selectUserCmpnyDtlInfoHisAjax", param);
    }	
	*/
	
	/*
	 * User Company Detail Info Image
	 */
	public UserCmpnyBean selectUserCmpnyDtlInfoImgAjax(UserCmpnyBean param) {
        return getSqlSession().selectOne("userCmpny.selectUserCmpnyDtlInfoImgAjax", param);
    }
	
	/*
	 * Company User Vacancy List
	 */
	public List<UserCmpnyVccyBean> selectUserCmpnyDtlInfoVccyList(UserCmpnyVccyBean param) {
        return getSqlSession().selectList("userCmpny.selectUserCmpnyDtlInfoVccyList", param);
    }
	
	public int selectUserCmpnyDtlInfoVccyListTotalCnt(UserCmpnyVccyBean param) {
        return getSqlSession().selectOne("userCmpny.selectUserCmpnyDtlInfoVccyListTotalCnt", param);
	}	

	/*
	 * Company User Common Vacancy List
	 */
	public List<UserCmpnyCommonBean> selectUserCmpnyCommonVccyList(UserCmpnyCommonBean param) {
        return getSqlSession().selectList("userCmpny.selectUserCmpnyCommonVccyList", param);
    }	
		
	/*
	 * Company User Application List
	 */
	public List<UserCmpnyAplcBean> selectUserCmpnyDtlInfoAplcList(UserCmpnyAplcBean param) {
        return getSqlSession().selectList("userCmpny.selectUserCmpnyDtlInfoAplcList", param);
    }
	
	public int selectUserCmpnyDtlInfoAplcListTotalCnt(UserCmpnyAplcBean param) {
        return getSqlSession().selectOne("userCmpny.selectUserCmpnyDtlInfoAplcListTotalCnt", param);
	}	

	/*
	 * Company User Offer List
	 */
	public List<UserCmpnyOfferBean> selectUserCmpnyDtlInfoOfferList(UserCmpnyOfferBean param) {
        return getSqlSession().selectList("userCmpny.selectUserCmpnyDtlInfoOfferList", param);
    }
	
	public int selectUserCmpnyDtlInfoOfferListTotalCnt(UserCmpnyOfferBean param) {
        return getSqlSession().selectOne("userCmpny.selectUserCmpnyDtlInfoOfferListTotalCnt", param);
	}
	
	/*
	 * Company User Interview List
	 */
	public List<UserCmpnyIntvwBean> selectUserCmpnyDtlInfoIntvwList(UserCmpnyIntvwBean param) {
        return getSqlSession().selectList("userCmpny.selectUserCmpnyDtlInfoIntvwList", param);
    }
	
	public int selectUserCmpnyDtlInfoIntvwListTotalCnt(UserCmpnyIntvwBean param) {
        return getSqlSession().selectOne("userCmpny.selectUserCmpnyDtlInfoIntvwListTotalCnt", param);
	}
	
	/*
	 * Company User Job Fair List
	 */
	public List<UserCmpnyFairBean> selectUserCmpnyDtlInfoJobfairList(UserCmpnyFairBean param) {
        return getSqlSession().selectList("userCmpny.selectUserCmpnyDtlInfoJobfairList", param);
    }
	
	public int selectUserCmpnyDtlInfoJobfairListTotalCnt(UserCmpnyFairBean param) {
        return getSqlSession().selectOne("userCmpny.selectUserCmpnyDtlInfoJobfairListTotalCnt", param);
	}	
	
}
