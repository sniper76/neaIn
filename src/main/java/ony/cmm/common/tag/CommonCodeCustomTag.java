package ony.cmm.common.tag;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.support.RequestContext;
import org.springframework.web.servlet.tags.RequestContextAwareTag;

import ony.cmm.common.bean.CommDtlCdBean;
import ony.cmm.common.bean.IsicBean;
import ony.cmm.common.service.CommonService;
import ony.cpes.internal.common.bean.JobCenterBean;

public class CommonCodeCustomTag extends RequestContextAwareTag  {

	private static final long serialVersionUID = 1L;

	@Autowired
	CommonService cmmSvc;

	@Autowired MessageSource messageSource;

	@Autowired SessionLocaleResolver localeResolver;

	private String grpCd 		= "";
	private String drawType 	= "";
	private String initValue 	= "";
	private String tagName		= "";
	private String codeKind 	= "";
	private String exceptValue	= "";
	private String disable		= "";

	public int doStartTagInternal() throws Exception {

//

		try {
			if ("commCode".equals(codeKind) ) {
				pageContext.getOut().print(customCommFunction(tagName, grpCd, drawType, initValue, exceptValue, disable));
			} else if ("jcCode".equals(codeKind)) {
				pageContext.getOut().print(customJcFunction(tagName, grpCd, drawType, initValue, exceptValue, disable));
			} else if ("birthCode".equals(codeKind)) {
				pageContext.getOut().print(customBirthFunction(tagName, grpCd, drawType, initValue, exceptValue, disable));
			} else if ("isicCode".equals(codeKind)) {
				pageContext.getOut().print(customIsicFunction(tagName, grpCd, drawType, initValue, exceptValue, disable));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return SKIP_BODY;
	}


	private String customCommFunction( String tagName, String grpCd, String drawType, String initValue, String exceptValue,String disable) throws Exception{
		// Request Paramter
		HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();

		String lang = "en";
		if (request == null || localeResolver == null || localeResolver.resolveLocale(request).getLanguage() == null) {
			lang = "en";
		} else {
			lang = localeResolver.resolveLocale(request).getLanguage();
		}

		if (cmmSvc == null) {
            // 2. WebApplicationContext를 얻는다.
            WebApplicationContext wac = getRequestContext().getWebApplicationContext();
            AutowireCapableBeanFactory beanFactory = wac.getAutowireCapableBeanFactory();
            // 3. 스프링 빈 주입
            beanFactory.autowireBean(this);
        }

		CommDtlCdBean cmmBean = new CommDtlCdBean();
		cmmBean.setGrpCd(grpCd);
		cmmBean.setLang(lang);
		cmmBean = cmmSvc.selectCommCodeList(cmmBean);

		String[] arrExcept =  exceptValue.split(",");

		String html 	= "";
		String checked 	= "";
		boolean exAll	= false;
		boolean exVal	= false;
		String disableStr = "";

		if ("true".equals(disable))
			disableStr = "disabled=\"true\"";

		if ("select".equals(drawType)) {
			html =  "<select name=\""+tagName+"\" id=\""+tagName+"\" "+disableStr+">";
			for(String ex : arrExcept) {
				if ("ALL".equals(ex)) {
					exAll = true;
				}
			}

			if (!exAll) html += "<option value=\"\"" +checked+">All</option>";

			if (cmmBean != null && cmmBean.getList().size()> 0) {
				for(CommDtlCdBean cdBean : cmmBean.getList()) {
					exVal = false;
					checked = "";
					if(initValue != null && !"".equals(initValue)) {
						if(initValue.equals(cdBean.getDtlCd())) {
							checked = "selected";
						}
					} else {
						checked = "";
					}

					for(String ex : arrExcept) {
						if (cdBean.getDtlCd().equals(ex)) {
							exVal = true;
						}
					}

					if (!exVal)
						html += "<option value=\"" + cdBean.getDtlCd() + "\"" +checked+">"+cdBean.getCdEnNm()+"</option>";
				}
			}
			html += "</select>";
		} else if("radio".equals(drawType)) {

			for(String ex : arrExcept) {
				if ("ALL".equals(ex)) {
					exAll = true;
				}
			}

			if (!exAll)
				html += "<input type=\"radio\" name=\""+tagName+"\" id=\""+tagName+"\" value='' checked/>All";

			if (cmmBean != null && cmmBean.getList().size()> 0) {
				for(CommDtlCdBean cdBean : cmmBean.getList()) {
					exVal = false;
					checked = "";
					if(initValue != null && !"".equals(initValue)) {
						if(initValue.equals(cdBean.getDtlCd())) {
							checked = "checked";
						}
					} else {
						checked = "";
					}

					for(String ex : arrExcept) {
						if (cdBean.getDtlCd().equals(ex)) {
							exVal = true;
						}
					}

					if (!exVal)
						html += "<input type=\"radio\" name=\""+tagName+"\" id=\""+tagName+"\" value=\""+cdBean.getDtlCd()+"\" "+checked+"/>" + cdBean.getCdEnNm();
				}
			}
		} else if ("check".equals(drawType)) {
			int chk_i = 0;
			if (cmmBean != null && cmmBean.getList().size()> 0) {
				for(CommDtlCdBean cdBean : cmmBean.getList()) {
					exVal = false;
					checked = "";
					if(initValue != null && !"".equals(initValue)) {
						String[] arrInit = initValue.split(",");
						for(String init : arrInit) {
							if(init.equals(cdBean.getDtlCd())) {
								checked = "checked";
								break;
							}
						}
					} else {
						checked = "";
					}

					for(String ex : arrExcept) {
						if (cdBean.getDtlCd().equals(ex)) {
							exVal = true;
						}
					}

					if (!exVal)
						html += "<input type=\"checkbox\" name=\""+tagName+"_"+String.valueOf(chk_i)+"\" id=\""+tagName+"_"+String.valueOf(chk_i)+"\" value=\""+cdBean.getDtlCd()+"\"  "+checked+"/>" + cdBean.getCdEnNm();

					chk_i++;
				}
			}
		} else {
			html = "NULL";
		}

		return html;
	}

	private String customJcFunction( String tagName, String grpCd, String drawType, String initValue,String exceptValue,String disable) throws Exception{
		// Request Paramter
		HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();

		String lang = "en";
		if (request == null || localeResolver == null || localeResolver.resolveLocale(request).getLanguage() == null) {
			lang = "en";
		} else {
			lang = localeResolver.resolveLocale(request).getLanguage();
		}

		if (cmmSvc == null) {
            // 2. WebApplicationContext를 얻는다.
            WebApplicationContext wac = getRequestContext().getWebApplicationContext();
            AutowireCapableBeanFactory beanFactory = wac.getAutowireCapableBeanFactory();
            // 3. 스프링 빈 주입
            beanFactory.autowireBean(this);
        }

		JobCenterBean jcBean = new JobCenterBean();
		jcBean.setLang(lang);
		jcBean = cmmSvc.selectJcCodeList(jcBean);

		String html = "";
		String checked = "";
		String[] arrExcept =  exceptValue.split(",");
		boolean exAll	= false;
		boolean exVal	= false;
		String disableStr = "";

		if ("true".equals(disable))
			disableStr = "disabled";


		if ("select".equals(drawType)) {
			html =  "<select name=\""+tagName+"\" id=\""+tagName+"\" "+disableStr+">";

			for(String ex : arrExcept) {
				if ("ALL".equals(ex)) {
					exAll = true;
				}
			}

			if (!exAll) html += "<option value=\"\"" +checked+">All</option>";

			if (jcBean != null && jcBean.getList().size()> 0) {
				for(JobCenterBean bean : jcBean.getList()) {
					checked = "";
					if(initValue != null && !"".equals(initValue)) {
						if(initValue.equals(bean.getJcCd())) {
							checked = "selected";
						}
					} else {
						checked = "";
					}
					html += "<option value=\"" + bean.getJcCd() + "\"" +checked+">"+bean.getJcNm()+"</option>";
				}
			}
			html += "</select>";
		} else {
			html = "NULL";
		}

		return html;
	}




	private String customBirthFunction( String tagName, String grpCd, String drawType, String initValue,String exceptValue,String disable) throws Exception{
		// Request Paramter
		RequestContext request = this.getRequestContext();

		String html = "";
		String checked = "";
		String disableStr = "";

		String[] arrInit = initValue.split("-");
		String arrInitDay = "";
		String arrInitMonth = "";
		String arrInitYear = "";

		if (arrInit != null && arrInit.length > 2) {
			if(arrInit[0] !=null)
				arrInitYear = arrInit[0];

			if(arrInit[1] !=null)
				arrInitMonth = arrInit[1];

			if (arrInit[2] !=null)
				arrInitDay = arrInit[2];
		}


		SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd");
		Calendar time = Calendar.getInstance();
		String format_time1 = format1.format(time.getTime());

		String[] arrDate = format_time1.split("-");

		if ("true".equals(disable))
			disableStr = "disabled";


		if ("select".equals(drawType)) {
			html ="<span class=\"bbs_date\">";

			html +=  "<select name=\""+tagName+"D\" id=\""+tagName+"D\" "+disableStr+" title=\"day\">";
			for (int i = 1; i < 31; i++) {
				String selected = "";
				String dayStr = String.valueOf(i);
				if (i < 10) {
					dayStr = "0"+String.valueOf(i);
				}

				if(dayStr.equals(arrInitDay)) {
					selected = "selected";
				}
				html += "<option value=\""+dayStr+"\" "+selected+">"+dayStr+"</option>";
			}
			html += "</select>\r\n" +
					"				<label for=\"day\">"+messageSource.getMessage("field.dic.day",null,LocaleContextHolder.getLocale() )+"</label>\r\n" +
					"			</span>";


			html +=  "<span class=\"bbs_date\">";
			html +=  "<select name=\""+tagName+"M\" id=\""+tagName+"M\" "+disableStr+" title=\"month\">";
			for (int i = 1; i < 13; i++) {
				String selected = "";
				String monStr = String.valueOf(i);
				if (i < 10) {
					monStr = "0"+String.valueOf(i);
				}
				if(monStr.equals(arrInitMonth)) {
					selected = "selected";
				}
				html += "<option value=\""+monStr+"\" "+selected+">"+monStr+"</option>";
			}
			html += "</select>\r\n" +
					"				<label for=\"day\">"+messageSource.getMessage("field.dic.month",null,LocaleContextHolder.getLocale() )+"</label>\r\n" +
					"			</span>";


			html +=  "<span class=\"bbs_date\">";
			html +=  "<select name=\""+tagName+"Y\" id=\""+tagName+"Y\" "+disableStr+" title=\"year\">";
			for (int i = Integer.parseInt(arrDate[0]); i > Integer.parseInt(arrDate[0]) - 100; i--) {
				String selected = "";
				String yearStr = String.valueOf(i);

				if(yearStr.equals(arrInitYear)) {
					selected = "selected";
				}

				html += "<option value=\""+yearStr+"\"  "+selected+">"+yearStr+"</option>";
			}
			html += "</select>\r\n" +
					"				<label for=\"day\">"+messageSource.getMessage("field.dic.year",null,LocaleContextHolder.getLocale() )+"</label>\r\n" +
					"			</span>";
		} else {
			html = "NULL";
		}

		return html;
	}

	private String customIsicFunction( String tagName, String grpCd, String drawType, String initValue,String exceptValue,String disable) throws Exception{
		// Request Paramter
		HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();

		String lang = "en";
		if (request == null || localeResolver == null || localeResolver.resolveLocale(request).getLanguage() == null) {
			lang = "en";
		} else {
			lang = localeResolver.resolveLocale(request).getLanguage();
		}

		if (cmmSvc == null) {
            // 2. WebApplicationContext를 얻는다.
            WebApplicationContext wac = getRequestContext().getWebApplicationContext();
            AutowireCapableBeanFactory beanFactory = wac.getAutowireCapableBeanFactory();
            // 3. 스프링 빈 주입
            beanFactory.autowireBean(this);
        }

		IsicBean isicBean = new IsicBean();
		isicBean.setLang(lang);
		List<IsicBean> isicList = cmmSvc.selectIsicCdList(isicBean);

		String[] arrExcept =  exceptValue.split(",");

		String html 	= "";
		String checked 	= "";
		boolean exAll	= false;
		boolean exVal	= false;

		String disableStr = "";
		if ("true".equals(disable))
			disableStr = "disabled";

		if ("select".equals(drawType)) {
			html =  "<select name=\""+tagName+"\" id=\""+tagName+"\" "+disableStr+">";

			for(String ex : arrExcept) {
				if ("ALL".equals(ex)) {
					exAll = true;
				}
			}

			if (!exAll) html += "<option value=\"\"" +checked+">All</option>";

			if (isicList != null && isicList.size()> 0) {
				for(IsicBean bean : isicList) {
					checked = "";
					if(initValue != null && !"".equals(initValue)) {
						if(initValue.equals(bean.getIsicCd())) {
							checked = "selected";
						}
					} else {
						checked = "";
					}

					for(String ex : arrExcept) {
						if (bean.getIsicCd().equals(ex)) {
							exVal = true;
						}
					}

					if (!exVal)
						html += "<option value=\"" + bean.getIsicCd() + "\"" +checked+">"+bean.getIsicNm()+"</option>";
				}
			}
			html += "</select>";
		} else {
			html = "NULL";
		}

		return html;
	}

	public String getTagName() {
		return tagName;
	}


	public void setTagName(String tagName) {
		this.tagName = tagName;
	}


	public String getGrpCd() {
		return grpCd;
	}


	public void setGrpCd(String grpCd) {
		this.grpCd = grpCd;
	}


	public String getDrawType() {
		return drawType;
	}


	public void setDrawType(String drawType) {
		this.drawType = drawType;
	}


	public String getInitValue() {
		return initValue;
	}


	public void setInitValue(String initValue) {
		this.initValue = initValue;
	}


	public String getCodeKind() {
		return codeKind;
	}


	public void setCodeKind(String codeKind) {
		this.codeKind = codeKind;
	}


	public String getExceptValue() {
		return exceptValue;
	}


	public void setExceptValue(String exceptValue) {
		this.exceptValue = exceptValue;
	}


	public String getDisable() {
		return disable;
	}


	public void setDisable(String disable) {
		this.disable = disable;
	}



}