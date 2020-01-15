package ony.cpes.internal.vacancy.service;

import ony.cpes.internal.vacancy.bean.VacancyBean;
import ony.cpes.internal.vacancy.bean.VacancyLocBean;
import ony.cpes.internal.vacancy.bean.VacancyLangBean;
import ony.cpes.internal.vacancy.bean.VacancyPreferntBean;

public interface VacancyService {
	
	/**
     * Vacancy Detail Info
     *
     * @param VacancyBean
     * @return VacancyBean
     */
    public VacancyBean selectVacancyDtlInfo(VacancyBean param) throws Exception; 
    
	/**
     * Vacancy Detail Location Info
     *
     * @param VacancyLocBean
     * @return VacancyLocBean
     */
    public VacancyLocBean selectVacancyDtlInfoLoc(VacancyLocBean param) throws Exception; 
    
	/**
     * Vacancy Detail Language Info
     *
     * @param VacancyLangBean
     * @return VacancyLangBean
     */
    public VacancyLangBean selectVacancyDtlInfoLang(VacancyLangBean param) throws Exception; 
    
	/**
     * Vacancy Detail Preferential Info
     *
     * @param VacancyPreferntBean
     * @return VacancyPreferntBean
     */
    public VacancyPreferntBean selectVacancyDtlInfoPrefernt(VacancyPreferntBean param) throws Exception; 
    
}
