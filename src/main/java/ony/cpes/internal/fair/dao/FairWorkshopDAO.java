package ony.cpes.internal.fair.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import ony.cpes.internal.fair.bean.FairWorkshopBean;
import ony.cpes.internal.fair.bean.FairWorkshopPatcptnBean;

@Repository("FairWorkshopDAO")
public class FairWorkshopDAO extends EgovAbstractMapper {

	public List<FairWorkshopBean> selectFairWorkshopList(FairWorkshopBean param) {
		return getSqlSession().selectList("fairWorkshop.selectFairWorkshopList", param);
	}

	public int selectFairWorkshopTotCnt(FairWorkshopBean param) {
		return getSqlSession().selectOne("fairWorkshop.selectFairWorkshopTotCnt", param);
	}

	public int insertFairWorkshop(FairWorkshopBean param) {
		return getSqlSession().insert("setFairWorkshop.insertFairWorkshop", param);
	}

	public FairWorkshopBean selectWorkshopDetail(FairWorkshopBean param) {
		return getSqlSession().selectOne("fairWorkshop.selectWorkshopDetail", param);
	}

	public int updateFairWorkshop(FairWorkshopBean param) {
		return getSqlSession().update("setFairWorkshop.updateFairWorkshop", param);
	}

	public int deleteFairWorkshopPatcptn(FairWorkshopBean param) {
		return getSqlSession().delete("setFairWorkshop.deleteFairWorkshopPatcptn", param);
	}

	public List<FairWorkshopPatcptnBean> selectWorkshopPatcptnList(FairWorkshopPatcptnBean param){
		return getSqlSession().selectList("fairWorkshop.selectWorkshopPatcptnList", param);
	}

	public int selectWorkshopPatcptnTotCnt(FairWorkshopPatcptnBean param) {
		return getSqlSession().selectOne("fairWorkshop.selectWorkshopPatcptnTotCnt", param);
	}

	public int updateWorkshopPatcptnJcAgreeCd(FairWorkshopPatcptnBean param) {
		return getSqlSession().update("setFairWorkshop.updateWorkshopPatcptnJcAgreeCd", param);
	}
}
