package ony.cpes.internal.vacancy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ony.cpes.internal.vacancy.bean.VacancyBean;
import ony.cpes.internal.vacancy.bean.VacancyLocBean;
import ony.cpes.internal.vacancy.bean.VacancyLangBean;
import ony.cpes.internal.vacancy.bean.VacancyPreferntBean;
import ony.cpes.internal.vacancy.dao.VacancyDAO;
import ony.cpes.internal.vacancy.service.VacancyService;

@Service("VacancyService")
public class VacancyServiceImpl implements VacancyService{

	@Autowired
	private VacancyDAO vacancyDAO;
	
	/**
	 * Vacancy Detail Info
	 * @param VacancyBean
	 * @return VacancyBean
	 */
	@Override
	public VacancyBean selectVacancyDtlInfo(VacancyBean param) throws Exception {
		return vacancyDAO.selectVacancyDtlInfo(param);
	}

	/**
	 * Vacancy Detail Location Info
	 * @param VacancyLocBean
	 * @return VacancyLocBean
	 */
	@Override
	public VacancyLocBean selectVacancyDtlInfoLoc(VacancyLocBean param) throws Exception {
		List<VacancyLocBean> list = vacancyDAO.selectVacancyDtlInfoLoc(param);
		param.setList(list);

		return param;
	}
	
	/**
	 * Vacancy Detail Language Info
	 * @param VacancyLangBean
	 * @return VacancyLangBean
	 */
	@Override
	public VacancyLangBean selectVacancyDtlInfoLang(VacancyLangBean param) throws Exception {
		List<VacancyLangBean> list = vacancyDAO.selectVacancyDtlInfoLang(param);
		param.setList(list);

		return param;
	}
	
	/**
	 * Vacancy Detail Preferential Info
	 * @param VacancyPreferntBean
	 * @return VacancyPreferntBean
	 */
	@Override
	public VacancyPreferntBean selectVacancyDtlInfoPrefernt(VacancyPreferntBean param) throws Exception {
		List<VacancyPreferntBean> list = vacancyDAO.selectVacancyDtlInfoPrefernt(param);
		param.setList(list);

		return param;
	}		

}
