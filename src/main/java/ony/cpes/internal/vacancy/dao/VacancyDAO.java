package ony.cpes.internal.vacancy.dao;

import java.util.List;
import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import ony.cpes.internal.vacancy.bean.VacancyBean;
import ony.cpes.internal.vacancy.bean.VacancyLocBean;
import ony.cpes.internal.vacancy.bean.VacancyLangBean;
import ony.cpes.internal.vacancy.bean.VacancyPreferntBean;

@Repository("vacancyDAO")
public class VacancyDAO extends EgovAbstractMapper{
	
	/*
	 * Vacancy Detail info
	 */
	public VacancyBean selectVacancyDtlInfo(VacancyBean param) {
        return getSqlSession().selectOne("vacancy.selectVacancyDtlInfo", param);
    }
	
	
	/*
	 * Vacancy Detail Location Info
	 */
	public List<VacancyLocBean> selectVacancyDtlInfoLoc(VacancyLocBean param) {
        return getSqlSession().selectList("vacancy.selectVacancyDtlInfoLoc", param);
    }
	
	/*
	 * Vacancy Detail Language Info
	 */
	public List<VacancyLangBean> selectVacancyDtlInfoLang(VacancyLangBean param) {
        return getSqlSession().selectList("vacancy.selectVacancyDtlInfoLang", param);
    }
	
	/*
	 * Vacancy Detail Preferential Info
	 */
	public List<VacancyPreferntBean> selectVacancyDtlInfoPrefernt(VacancyPreferntBean param) {
        return getSqlSession().selectList("vacancy.selectVacancyDtlInfoPrefernt", param);
    }
	
}
