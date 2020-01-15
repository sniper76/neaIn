package ony.cpes.internal.common.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import ony.cpes.internal.common.bean.MenuBean;
import ony.cpes.internal.common.bean.ProgramBean;


@Repository("ProgramDAO")
public class ProgramDAO extends EgovAbstractMapper{
    

	/**
	 * @param MenuBean
	 * @return List<MenuBean>
	 */
	public List<ProgramBean> selectProgramMngList(ProgramBean paramObj) throws Exception {
        return getSqlSession().selectList("program.selectProgramMngList", paramObj);
    }
	
	/**
	 * @param MenuBean
	 * @return int
	 */
	public int selectProgramMngListTotalCount(ProgramBean paramObj) throws Exception {
        return getSqlSession().selectOne("program.selectProgramMngListTotalCount", paramObj);
    }
	
	
	/**
	 * @param MenuBean
	 * @return int
	 */
	public int insertProgramMng(ProgramBean paramObj) throws Exception {
        return getSqlSession().insert("setProgram.insertProgramMng", paramObj);
    }
	
	/**
	 * @param MenuBean
	 * @return int
	 */
	public int updateProgramMng(ProgramBean paramObj) throws Exception {
        return getSqlSession().update("setProgram.updateProgramMng", paramObj);
    }
	
	/**
	 * @param MenuBean
	 * @return int
	 */
	public String selectProgramId() throws Exception {
        return getSqlSession().selectOne("program.selectProgramId", null);
    }
	
	public ProgramBean selectProgramMngDetail(ProgramBean paramObj) throws Exception {
        return getSqlSession().selectOne("program.selectProgramMngDetail", paramObj);
    }
	/**
	 * @param MenuBean
	 * @return int
	 */
	public int deleteProgramMng(ProgramBean paramObj) throws Exception {
        return getSqlSession().delete("setProgram.deleteProgramMng", paramObj);
    }
	
	/**
	 * 
	 * @param paramObj
	 * @return
	 * @throws Exception
	 */
	public int deleteOtherProgramMng(ProgramBean paramObj) throws Exception {
		return getSqlSession().delete("setProgram.deleteOtherProgramMng", paramObj);
	}
	
	
}
