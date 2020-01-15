package ony.cpes.internal.resume.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import ony.cmm.common.bean.CommDtlCdBean;
import ony.cmm.common.dao.CommonDAO;
import ony.cpes.internal.resume.bean.ResumeBean;
import ony.cpes.internal.resume.bean.ResumeDisablBean;
import ony.cpes.internal.resume.bean.ResumeGenrlEduBean;
import ony.cpes.internal.resume.bean.ResumeHopeWorkLocBean;
import ony.cpes.internal.resume.bean.ResumeIscoBean;
import ony.cpes.internal.resume.bean.ResumeLangBean;
import ony.cpes.internal.resume.bean.ResumeLocBean;
import ony.cpes.internal.resume.bean.ResumeOtrTrngBean;
import ony.cpes.internal.resume.bean.ResumeRefmanBean;
import ony.cpes.internal.resume.bean.ResumeSkillBean;
import ony.cpes.internal.resume.bean.ResumeSpcEduBean;
import ony.cpes.internal.resume.bean.ResumeWorkExpBean;
import ony.cpes.internal.resume.dao.ResumeDAO;
import ony.cpes.internal.resume.service.ResumeService;
import ony.framework.util.StringUtil;

@Service("ResumeService")
public class ResumeServiceImpl implements ResumeService{

	@Autowired
	private ResumeDAO resumeDAO;

	@Autowired
	private CommonDAO commonDao;

	/**
	 * Resume Human Info
	 * @param ResumeBean
	 * @return ResumeBean
	 */
	@Override
	public ResumeBean selectResumeHumanInfo(ResumeBean param) throws Exception {
		return resumeDAO.selectResumeHumanInfo(param);
	}

	/**
	 * Disable Option Code
	 * @param ResumeBean
	 * @return ResumeBean
	 */
	@Override
	public ResumeBean selectDisableOptNm(ResumeBean param) throws Exception	{
		return resumeDAO.selectDisableOptNm(param);
	}

	/**
	 * Resume ISCO Info
	 * @param ResumeIscoBean
	 * @return ResumeIscoBean
	 */
	@Override
	public ResumeIscoBean selectIscoList(ResumeIscoBean param) throws Exception {
		List<ResumeIscoBean> list = resumeDAO.selectIscoList(param);
		param.setList(list);

		return param;
	}

	/**
	 * Resume Prefer Work Loc Info
	 * @param ResumeLocBean
	 * @return ResumeLocBean
	 */
	@Override
	public ResumeLocBean selectPreferWorkLocList(ResumeLocBean param) throws Exception {
		List<ResumeLocBean> list = resumeDAO.selectPreferWorkLocList(param);
		param.setList(list);

		return param;
	}

	/**
     * Resume Special Education Info
     *
     * @param ResumeSpcEduBean
     * @return ResumeSpcEduBean
     */
	@Override
	public ResumeSpcEduBean selectResumeSpcEduInfo(ResumeSpcEduBean param) throws Exception {
		List<ResumeSpcEduBean> list = resumeDAO.selectResumeSpcEduInfo(param);
		param.setList(list);

		return param;
	}

	/**
	 * Resume Other Training Info
	 * @param ResumeOtrTrngBean
	 * @return ResumeOtrTrngBean
	 */
	@Override
	public ResumeOtrTrngBean selectResumeOtrTrngInfo(ResumeOtrTrngBean param) throws Exception {
		List<ResumeOtrTrngBean> list = resumeDAO.selectResumeOtrTrngInfo(param);
		param.setList(list);

		return param;
	}

	/**
	 * Resume Language Info
	 * @param ResumeLangBean
	 * @return ResumeLangBean
	 */
	@Override
	public ResumeLangBean selectResumeLangInfo(ResumeLangBean param) throws Exception {
		List<ResumeLangBean> list = resumeDAO.selectResumeLangInfo(param);
		param.setList(list);

		return param;
	}

	/**
	 * Resume Work Exp Info
	 * @param ResumeWorkExpBean
	 * @return ResumeWorkExpBean
	 */
	@Override
	public ResumeWorkExpBean selectResumeWorkExpInfo(ResumeWorkExpBean param) throws Exception {
		List<ResumeWorkExpBean> list = resumeDAO.selectResumeWorkExpInfo(param);
		param.setList(list);

		return param;
	}

	/**
	 * Resume Skill Info
	 * @param ResumeWorkExpBean
	 * @return ResumeWorkExpBean
	 */
	@Override
	public ResumeSkillBean selectResumeSkillInfo(ResumeSkillBean param) throws Exception {
		List<ResumeSkillBean> list = resumeDAO.selectResumeSkillInfo(param);
		param.setList(list);

		return param;
	}

	/**
	 * Resume Work Exp Info
	 * @param ResumeWorkExpBean
	 * @return ResumeWorkExpBean
	 */
	@Override
	public ResumeSkillBean selectResumeSkillDtlInfo(ResumeSkillBean param) throws Exception {
		List<ResumeSkillBean> list = resumeDAO.selectResumeSkillDtlInfo(param);
		param.setList(list);

		return param;
	}

	/**
	 * Resume Refman Info
	 * @param ResumeRefmanBean
	 * @return ResumeRefmanBean
	 */
	@Override
	public ResumeRefmanBean selectResumeRefmanInfo(ResumeRefmanBean param) throws Exception {
		List<ResumeRefmanBean> list = resumeDAO.selectResumeRefmanInfo(param);
		param.setList(list);

		return param;
	}

	@Override
	public List<CommDtlCdBean> selectResumeSkillList(CommDtlCdBean param) throws Exception {
		List<CommDtlCdBean> resultList = new ArrayList<CommDtlCdBean>();
		List<CommDtlCdBean> skillCdList = commonDao.selectCommCodeList(param);

		for(CommDtlCdBean cdBean : skillCdList) {
			int cd = Integer.parseInt(cdBean.getDtlCd().substring(3));
			int check = cd % 100;

			if(check == 0) {
				cdBean.setList(new ArrayList<CommDtlCdBean>());
				resultList.add(cdBean);
			}else {
				for(CommDtlCdBean checkBean : resultList) {
					int sameCheck = Integer.parseInt(checkBean.getDtlCd().substring(3));

					if((cd / 100) == (sameCheck / 100)) {
						checkBean.getList().add(cdBean);
					}
				}
			}

		}

		return resultList;
	}

	@Override
	public int insertResume(ResumeBean param) {
		int result = 0;

		int totCnt = resumeDAO.selectResumeTotCnt(param);

		if(totCnt < 1) {
			param.setPriResumeYn("Y");
			result = resumeDAO.insertResume(param);

			if(result == 1) {
				ObjectMapper mapper = new ObjectMapper();

				try {
					// 희망 근무 지역 등록
					List<ResumeHopeWorkLocBean> hopeLockList = mapper.readValue(param.getHopeWorkLocListStr(), new TypeReference<List<ResumeHopeWorkLocBean>>(){});

					for(ResumeHopeWorkLocBean hopeLockBean : hopeLockList) {
						hopeLockBean.setResumeSeq(param.getResumeSeq());
						hopeLockBean.setRegUserSeq(param.getRegUserSeq());
						hopeLockBean.setModUserSeq(param.getModUserSeq());
						resumeDAO.insertResumeHopeWorkLoc(hopeLockBean);
					}

					// 연구 및 전문분야 등록
					List<ResumeSpcEduBean> specialStudyList = mapper.readValue(param.getSpecialStudyListStr(), new TypeReference<List<ResumeSpcEduBean>>(){});

					for(ResumeSpcEduBean specialStudyBean : specialStudyList) {
						specialStudyBean.setResumeSeq(param.getResumeSeq());
						specialStudyBean.setRegUserSeq(param.getRegUserSeq());
						specialStudyBean.setModUserSeq(param.getModUserSeq());
						resumeDAO.insertResumeSpecialStudy(specialStudyBean);
					}

					// 자격증 보유 여부 등록

					// 기타교육 등록
					List<ResumeOtrTrngBean> otherTrnngList = mapper.readValue(param.getOtherTrnngListStr(), new TypeReference<List<ResumeOtrTrngBean>>(){});

					for(ResumeOtrTrngBean otherTrnngBean : otherTrnngList) {
						otherTrnngBean.setResumeSeq(param.getResumeSeq());
						otherTrnngBean.setRegUserSeq(param.getRegUserSeq());
						otherTrnngBean.setModUserSeq(param.getModUserSeq());
						resumeDAO.insertResumeOtherTrnng(otherTrnngBean);
					}

					// 어학 등록
					List<ResumeLangBean> langList = mapper.readValue(param.getLangListStr(), new TypeReference<List<ResumeLangBean>>(){});

					for(ResumeLangBean langBean : langList) {
						langBean.setResumeSeq(param.getResumeSeq());
						langBean.setRegUserSeq(param.getRegUserSeq());
						langBean.setModUserSeq(param.getModUserSeq());

						if("Native".equals(langBean.getLangTypeCd())) {
							langBean.setLangTypeCd("LTC0000000001");
						}else if("Foreign Language".equals(langBean.getLangTypeCd())){
							langBean.setLangTypeCd("LTC0000000002");
						}
						resumeDAO.insertResumeLang(langBean);
					}

					// 경력 등록
					List<ResumeWorkExpBean> workExpList = mapper.readValue(param.getWorkExpListStr(), new TypeReference<List<ResumeWorkExpBean>>(){});

					for(ResumeWorkExpBean workExpBean : workExpList) {
						workExpBean.setResumeSeq(param.getResumeSeq());
						workExpBean.setRegUserSeq(param.getRegUserSeq());
						workExpBean.setModUserSeq(param.getModUserSeq());
						resumeDAO.insertResumeWorkExp(workExpBean);
					}

					// skill 등록
					List<String> skillList = mapper.readValue(param.getSkillListStr(), new TypeReference<List<String>>(){});

					for(String skillCd : skillList) {

						ResumeSkillBean skillBean = new ResumeSkillBean();
						skillBean.setResumeSeq(param.getResumeSeq());
						skillBean.setRegUserSeq(param.getRegUserSeq());
						skillBean.setModUserSeq(param.getModUserSeq());
						skillBean.setSkillCd(skillCd);
						resumeDAO.insertResumeSkill(skillBean);
					}

					// 추천인 등록
					List<ResumeRefmanBean> refManList = mapper.readValue(param.getRefManListStr(), new TypeReference<List<ResumeRefmanBean>>(){});

					for(ResumeRefmanBean refManBean : refManList) {
						refManBean.setResumeSeq(param.getResumeSeq());
						refManBean.setRegUserSeq(param.getRegUserSeq());
						refManBean.setModUserSeq(param.getModUserSeq());
						resumeDAO.insertResumeRefMan(refManBean);
					}

					// 장애 여부 등록
					List<String> disableList = mapper.readValue(param.getDisableListStr(), new TypeReference<List<String>>(){});

					for(String disableCd : disableList) {
						ResumeDisablBean disableBean = new ResumeDisablBean();
						disableBean.setResumeSeq(param.getResumeSeq());
						disableBean.setRegUserSeq(param.getRegUserSeq());
						disableBean.setModUserSeq(param.getModUserSeq());
						disableBean.setDisableCd(disableCd);
						resumeDAO.insertResumeDisable(disableBean);
					}

					// 일반교육 등록
					ResumeGenrlEduBean genrlBean = new ResumeGenrlEduBean();
					genrlBean.setResumeSeq(param.getResumeSeq());
					genrlBean.setRegUserSeq(param.getRegUserSeq());
					genrlBean.setModUserSeq(param.getModUserSeq());
					genrlBean.setEduDegreeCd(param.getGenrlEduListStr());
					resumeDAO.insertResumeGenrlEdu(genrlBean);

					// 직종
					List<ResumeIscoBean> iscoCdList = mapper.readValue(param.getIscoCdListStr(), new TypeReference<List<ResumeIscoBean>>(){});

					for(ResumeIscoBean iscoBean : iscoCdList) {
						iscoBean.setResumeSeq(param.getResumeSeq());
						iscoBean.setRegUserSeq(param.getRegUserSeq());
						iscoBean.setModUserSeq(param.getModUserSeq());
						resumeDAO.insertResumeIsco(iscoBean);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}else {
			result = 99;
		}

		return result;
	}

	@Override
	public List<ResumeDisablBean> selectResumeDisableDetail(ResumeBean param) {
		return resumeDAO.selectResumeDisableDetail(param);
	}

	@Override
	public ResumeGenrlEduBean selectResumeGenrlEduDetail(ResumeBean param) {
		return resumeDAO.selectResumeGenrlEduDetail(param);
	}

	@Override
	public List<CommDtlCdBean> selectResumeSkillForDetail(ResumeBean param) throws Exception {
		List<ResumeSkillBean> rskList = resumeDAO.selectResumeSkillDetail(param);

		CommDtlCdBean commDtlCdBean = new CommDtlCdBean();
  		commDtlCdBean.setGrpCd("SKILL_CD");
		List<CommDtlCdBean> skillCdList = selectResumeSkillList(commDtlCdBean);
		List<CommDtlCdBean> removeList = null;

		for(CommDtlCdBean skillBean : skillCdList) {
			removeList = new ArrayList<CommDtlCdBean>();

			for(CommDtlCdBean skill : skillBean.getList()) {
				boolean flag = false;
				for(ResumeSkillBean rsk : rskList) {
					if(skill.getDtlCd().equals(rsk.getSkillCd())) {
						flag = true;
					}
				}
				if(!flag) {
					removeList.add(skill);
				}
			}

			skillBean.getList().removeAll(removeList);
		}

		removeList = new ArrayList<CommDtlCdBean>();
		for(CommDtlCdBean skillBean : skillCdList) {

			if(skillBean.getList().size() == 0) {
				removeList.add(skillBean);
			}
		}

		skillCdList.removeAll(removeList);
		return skillCdList;
	}

	@Override
	public ResumeBean selectResumeDetail(ResumeBean param) {
		ResumeBean result = resumeDAO.selectResumeDetail(param);
		if(result.getResumeKeyword() != null && !"".equals(result.getResumeKeyword())) {
			result.setResumeKeywordList(result.getResumeKeyword().split(","));
		}

		if(result.getProLicnsSpec() != null && !"".equals(result.getProLicnsSpec())) {
			result.setProLicnsSpecList(result.getProLicnsSpec().split(","));
		}
		return result;
	}

	@Override
	public List<ResumeIscoBean> selectResumeIsco(ResumeBean param) {
		return resumeDAO.selectResumeIsco(param);
	}

	@Override
	public List<ResumeRefmanBean> selectResumeRefManDetail(ResumeBean param) {
		return resumeDAO.selectResumeRefManDetail(param);
	}

	@Override
	public List<ResumeSkillBean> selectResumeSkillDetail(ResumeBean param) {
		return resumeDAO.selectResumeSkillDetail(param);
	}

	@Override
	public int updateResume(ResumeBean param) {
		int result = 0;
		result = resumeDAO.updateResume(param);

		ObjectMapper mapper = new ObjectMapper();

		try {
			// 희망 근무 지역
			resumeDAO.deleteResumeHopeWorkLoc(param);
			if(!StringUtil.isEmpty(param.getHopeWorkLocListStr())) {
				List<ResumeHopeWorkLocBean> hopeLockList = mapper.readValue(param.getHopeWorkLocListStr(), new TypeReference<List<ResumeHopeWorkLocBean>>(){});

				for(ResumeHopeWorkLocBean hopeLockBean : hopeLockList) {
					hopeLockBean.setResumeSeq(param.getResumeSeq());
					hopeLockBean.setRegUserSeq(param.getRegUserSeq());
					hopeLockBean.setModUserSeq(param.getModUserSeq());
					resumeDAO.insertResumeHopeWorkLoc(hopeLockBean);
				}
			}

			// 연구 및 전문분야 등록
			resumeDAO.deleteResumeSpecialStudy(param);
			if(!StringUtil.isEmpty(param.getSpecialStudyListStr())) {
				List<ResumeSpcEduBean> specialStudyList = mapper.readValue(param.getSpecialStudyListStr(), new TypeReference<List<ResumeSpcEduBean>>(){});

				for(ResumeSpcEduBean specialStudyBean : specialStudyList) {
					specialStudyBean.setResumeSeq(param.getResumeSeq());
					specialStudyBean.setRegUserSeq(param.getRegUserSeq());
					specialStudyBean.setModUserSeq(param.getModUserSeq());
					resumeDAO.insertResumeSpecialStudy(specialStudyBean);
				}
			}


			// 자격증 보유 여부 등록

			// 기타교육 등록
			resumeDAO.deleteResumeOtherTrnng(param);
			if(!StringUtil.isEmpty(param.getOtherTrnngListStr())) {
				List<ResumeOtrTrngBean> otherTrnngList = mapper.readValue(param.getOtherTrnngListStr(), new TypeReference<List<ResumeOtrTrngBean>>(){});

				for(ResumeOtrTrngBean otherTrnngBean : otherTrnngList) {
					otherTrnngBean.setResumeSeq(param.getResumeSeq());
					otherTrnngBean.setRegUserSeq(param.getRegUserSeq());
					otherTrnngBean.setModUserSeq(param.getModUserSeq());
					resumeDAO.insertResumeOtherTrnng(otherTrnngBean);
				}
			}

			// 어학 등록
			resumeDAO.deleteResumeLang(param);
			if(!StringUtil.isEmpty(param.getLangListStr())) {
				List<ResumeLangBean> langList = mapper.readValue(param.getLangListStr(), new TypeReference<List<ResumeLangBean>>(){});

				for(ResumeLangBean langBean : langList) {
					langBean.setResumeSeq(param.getResumeSeq());
					langBean.setRegUserSeq(param.getRegUserSeq());
					langBean.setModUserSeq(param.getModUserSeq());

					if("Native".equals(langBean.getLangTypeCd())) {
						langBean.setLangTypeCd("LTC0000000001");
					}else if("Foreign Language".equals(langBean.getLangTypeCd())){
						langBean.setLangTypeCd("LTC0000000002");
					}
					resumeDAO.insertResumeLang(langBean);
				}
			}

			// 경력 등록
			resumeDAO.deleteResumeWorkExp(param);
			if(!StringUtil.isEmpty(param.getWorkExpListStr())) {
				List<ResumeWorkExpBean> workExpList = mapper.readValue(param.getWorkExpListStr(), new TypeReference<List<ResumeWorkExpBean>>(){});

				for(ResumeWorkExpBean workExpBean : workExpList) {
					workExpBean.setResumeSeq(param.getResumeSeq());
					workExpBean.setRegUserSeq(param.getRegUserSeq());
					workExpBean.setModUserSeq(param.getModUserSeq());
					resumeDAO.insertResumeWorkExp(workExpBean);
				}
			}

			// skill 등록
			resumeDAO.deleteResumeSkill(param);
			if(!StringUtil.isEmpty(param.getSkillListStr())) {
				List<String> skillList = mapper.readValue(param.getSkillListStr(), new TypeReference<List<String>>(){});

				for(String skillCd : skillList) {

					ResumeSkillBean skillBean = new ResumeSkillBean();
					skillBean.setResumeSeq(param.getResumeSeq());
					skillBean.setRegUserSeq(param.getRegUserSeq());
					skillBean.setModUserSeq(param.getModUserSeq());
					skillBean.setSkillCd(skillCd);
					resumeDAO.insertResumeSkill(skillBean);
				}
			}

			// 추천인 등록
			resumeDAO.deleteResumeRefMan(param);
			if(!StringUtil.isEmpty(param.getRefManListStr())) {
				List<ResumeRefmanBean> refManList = mapper.readValue(param.getRefManListStr(), new TypeReference<List<ResumeRefmanBean>>(){});

				for(ResumeRefmanBean refManBean : refManList) {
					refManBean.setResumeSeq(param.getResumeSeq());
					refManBean.setRegUserSeq(param.getRegUserSeq());
					refManBean.setModUserSeq(param.getModUserSeq());
					resumeDAO.insertResumeRefMan(refManBean);
				}
			}

			// 장애 여부 등록
			resumeDAO.deleteResumeDisabl(param);
			if(!StringUtil.isEmpty(param.getDisableListStr())) {
				List<String> disableList = mapper.readValue(param.getDisableListStr(), new TypeReference<List<String>>(){});

				for(String disableCd : disableList) {
					ResumeDisablBean disableBean = new ResumeDisablBean();
					disableBean.setResumeSeq(param.getResumeSeq());
					disableBean.setRegUserSeq(param.getRegUserSeq());
					disableBean.setModUserSeq(param.getModUserSeq());
					disableBean.setDisableCd(disableCd);
					resumeDAO.insertResumeDisable(disableBean);
				}
			}

			// 일반교육 등록
			resumeDAO.deleteResumeGenrlEdu(param);
			if(!StringUtil.isEmpty(param.getGenrlEduListStr())) {
				ResumeGenrlEduBean genrlBean = new ResumeGenrlEduBean();
				genrlBean.setResumeSeq(param.getResumeSeq());
				genrlBean.setRegUserSeq(param.getRegUserSeq());
				genrlBean.setModUserSeq(param.getModUserSeq());
				genrlBean.setEduDegreeCd(param.getGenrlEduListStr());
				resumeDAO.insertResumeGenrlEdu(genrlBean);
			}

			// 직종
			resumeDAO.deleteResumeIsco(param);
			if(!StringUtil.isEmpty(param.getIscoCdListStr())) {
				List<ResumeIscoBean> iscoCdList = mapper.readValue(param.getIscoCdListStr(), new TypeReference<List<ResumeIscoBean>>(){});

				for(ResumeIscoBean iscoBean : iscoCdList) {
					iscoBean.setResumeSeq(param.getResumeSeq());
					iscoBean.setRegUserSeq(param.getRegUserSeq());
					iscoBean.setModUserSeq(param.getModUserSeq());
					resumeDAO.insertResumeIsco(iscoBean);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public String selectResumeDisableForUpdate(ResumeBean param) {
		String result = "";
		List<ResumeDisablBean> list = resumeDAO.selectResumeDisableDetail(param);

		for(ResumeDisablBean resumeDisablBean : list) {
			if("".equals(result)) {
				result += resumeDisablBean.getDisableCd();
			}else {
				result += "," + resumeDisablBean.getDisableCd();
			}
		}

		return result;
	}

	@Override
	public int deleteResume(ResumeBean param) {
		return resumeDAO.deleteResume(param);
	}

}
