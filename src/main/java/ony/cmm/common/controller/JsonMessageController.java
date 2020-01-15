package ony.cmm.common.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Controller
public class JsonMessageController {


	@Autowired MessageSource messageSource;
	
	@Autowired SessionLocaleResolver localeResolver;
	
	@RequestMapping("/message/message-common.do")
	public ModelAndView getProperties(Locale locale, HttpServletRequest request, HttpServletResponse response) throws IOException {
		ModelAndView mv = new ModelAndView();
		
		String lang = locale.getLanguage().toLowerCase();
		if (StringUtils.isBlank(lang)) {
			lang = "kh";
		}
		
		String propertiesName = "message-common_" + lang ;
		
		Resource resource = new ClassPathResource("/message/" + propertiesName + ".properties");
		ArrayList<HashMap<String, String>> messageList = new ArrayList<HashMap<String, String>>();
		InputStream inputStream = resource.getInputStream();
		List<String> readLines = IOUtils.readLines(inputStream);
		for (String message : readLines) {
			if(message.trim().length() > 0) {
				if(!"#".equals(message.trim().substring(0, 1))) {
					String[] msg = message.trim().split("=");
					HashMap<String, String> map = new HashMap<String, String>();
					map.put((String)msg[0], messageSource.getMessage((String)msg[0], null, "Error", localeResolver.resolveLocale(request)));
					messageList.add(map);
				}
			}
		}

		IOUtils.closeQuietly(inputStream);

		mv.addObject("i18n", messageList);		
		mv.setViewName("jsonView");
		
  		return mv;
	}

}