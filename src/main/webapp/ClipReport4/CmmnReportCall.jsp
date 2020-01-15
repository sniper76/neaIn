<%@page import="com.clipsoft.clipreport.oof.OOFFile"%>
<%@page import="com.clipsoft.clipreport.oof.OOFDocument"%>
<%@page import="java.io.File"%>
<%@page import="com.clipsoft.clipreport.server.service.ReportUtil"%>
<%@page import="com.clipsoft.clipreport.oof.connection.*"%>
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	request.setCharacterEncoding("UTF-8");


	String crfName = "";

	OOFDocument oof = OOFDocument.newOOF();

	//화면에서 넘겨받는 구분 값 추가 - 20190612
	String viewFlag = (request.getParameter("clipReportFlag")==""||request.getParameter("clipReportFlag") == null ? "" : request.getParameter("clipReportFlag"));

	//화면에서 넘겨 받은 구분 값 + .crf 조합으로 리포트 파일명 조합
	crfName = viewFlag+".crf";
	OOFFile file = oof.addFile("crf.root", "%root%/crf/"+crfName);


	System.out.println("ClipReport File Name==================="+ crfName);
	System.out.println("ClipReport viewFlag==================="+ viewFlag);

	//개인 프로필 관리 > 인쇄
	if("resume".equals(viewFlag)){
		String resumeDetailJson = (request.getParameter("resumeDetailJson")==""||request.getParameter("resumeDetailJson") == null ? "" : request.getParameter("resumeDetailJson"));
		String careerListJson = (request.getParameter("careerListJson")==""||request.getParameter("careerListJson") == null ? "" : request.getParameter("careerListJson"));

		//JSON 1건 인경우.. 맨앞, 맨뒤에 "{\"list\":[   ]}"  감싸줘야 함
		OOFConnectionMemo c1 = oof.addConnectionMemo("JSON1", "{\"list\":["+resumeDetailJson+"]}");
		c1.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}");

		//JSON LIST 타입.. 맨앞, 맨뒤에 "{\"list\":   }"  감싸줘야 함
		OOFConnectionMemo c2 =oof.addConnectionMemo("JSON2", "{\"list\":"+careerListJson+"}");
		c2.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}");

		//파라미터1개
		oof.addField("NAME","VALUE");

	}else if("memberJoin".equals(viewFlag)){
		//회원가입기간별 통계
		String listJson = (request.getParameter("listJson")==""||request.getParameter("listJson") == null ? "" : request.getParameter("listJson"));

		OOFConnectionMemo c1 =oof.addConnectionMemo("listJson", "{\"list\":"+listJson+"}");
		c1.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}"); 

	}else if("memberVisit".equals(viewFlag)){
		//개인회원 접속통계
		String listJson = (request.getParameter("listJson")==""||request.getParameter("listJson") == null ? "" : request.getParameter("listJson"));
		OOFConnectionMemo c1 =oof.addConnectionMemo("listJson", "{\"list\":"+listJson+"}");
		System.out.println("json data==========>"+"{\"list\":"+listJson+"}");
		c1.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}");



	}else if("prvStatusMemberJoin".equals(viewFlag)){
		//개인 회원 가입 현황
		//리포트 상단 공통 영역
		String statusMemberJoin0 = (request.getParameter("reportInfoDataMapJson")==""||request.getParameter("reportInfoDataMapJson") == null ? "" : request.getParameter("reportInfoDataMapJson"));
		OOFConnectionMemo c0 =oof.addConnectionMemo("statusMemberJoin0", "{\"list\":"+statusMemberJoin0+"}");

		//통계관리 > 구직자통계 > 개인회원 현황> 회원가입 현황
		String statusMemberJoin1 = (request.getParameter("prvMemberJoinListJson")==""||request.getParameter("prvMemberJoinListJson") == null ? "" : request.getParameter("prvMemberJoinListJson"));
		OOFConnectionMemo c1 =oof.addConnectionMemo("statusMemberJoin1", "{\"list\":"+statusMemberJoin1+"}");

		//통계관리 > 구직자통계 > 개인회원 현황> 기간별 회원가입 현황
		String statusMemberJoin2 = (request.getParameter("eachTimePrvMemberJoinCntJson")==""||request.getParameter("eachTimePrvMemberJoinCntJson") == null ? "" : request.getParameter("eachTimePrvMemberJoinCntJson"));
		OOFConnectionMemo c2 =oof.addConnectionMemo("statusMemberJoin2", "{\"list\":"+statusMemberJoin2+"}");

		//통계관리 > 구직자통계 > 개인회원 현황> 회원가입 내역(리스트)
		String statusMemberJoin3 = (request.getParameter("prvMemberJoinStatusJson")==""||request.getParameter("prvMemberJoinStatusJson") == null ? "" : request.getParameter("prvMemberJoinStatusJson"));
		OOFConnectionMemo c3 =oof.addConnectionMemo("statusMemberJoin3", "{\"list\":"+statusMemberJoin3+"}");

		//차트 데이터
		String statusMemberJoin4 = (request.getParameter("prvMemberJoinStatusChartJson")==""||request.getParameter("prvMemberJoinStatusChartJson") == null ? "" : request.getParameter("prvMemberJoinStatusChartJson"));
		OOFConnectionMemo c4 =oof.addConnectionMemo("statusMemberJoin4", "{\"list\":"+statusMemberJoin4+"}");
		
		//일/월구분
		String statusMemberJoin5 = (request.getParameter("dateModeChartAndListJson")==""||request.getParameter("dateModeChartAndListJson") == null ? "" : request.getParameter("dateModeChartAndListJson"));
		OOFConnectionMemo c5 =oof.addConnectionMemo("statusMemberJoin5", "{\"list\":"+statusMemberJoin5+"}");
				
		c0.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}");
		c1.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}");
		c2.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}");
		c3.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}");
		c4.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}");
		c5.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}");


	}else if("prvStatusAccess".equals(viewFlag)){
		//개인 접속현황
		//리포트 상단 공통 영역
		String prvStatusAccess0 = (request.getParameter("reportInfoDataMapJson")==""||request.getParameter("reportInfoDataMapJson") == null ? "" : request.getParameter("reportInfoDataMapJson"));
		OOFConnectionMemo c0 =oof.addConnectionMemo("prvStatusAccess0", "{\"list\":"+prvStatusAccess0+"}");

		//회원접속현황
		String prvStatusAccess1 = (request.getParameter("todayLoginStatusInfoJsonJson")==""||request.getParameter("todayLoginStatusInfoJsonJson") == null ? "" : request.getParameter("todayLoginStatusInfoJsonJson"));
		OOFConnectionMemo c1 =oof.addConnectionMemo("prvStatusAccess1", "{\"list\":"+prvStatusAccess1+"}");

		//기간별 회원접속  현황
		String prvStatusAccess2 = (request.getParameter("prvLoginPeriodInfoJson")==""||request.getParameter("prvLoginPeriodInfoJson") == null ? "" : request.getParameter("prvLoginPeriodInfoJson"));
		OOFConnectionMemo c2 =oof.addConnectionMemo("prvStatusAccess2", "{\"list\":"+prvStatusAccess2+"}");

		//회원가입 내역(리스트)
		String prvStatusAccess3 = (request.getParameter("PrvLoginListInfoJson")==""||request.getParameter("PrvLoginListInfoJson") == null ? "" : request.getParameter("PrvLoginListInfoJson"));
		OOFConnectionMemo c3=oof.addConnectionMemo("prvStatusAccess3", "{\"list\":"+prvStatusAccess3+"}");

		//차트데이터
		String prvStatusAccess4 = (request.getParameter("PrvLoginListChartInfoJson")==""||request.getParameter("PrvLoginListChartInfoJson") == null ? "" : request.getParameter("PrvLoginListChartInfoJson"));
		OOFConnectionMemo c4=oof.addConnectionMemo("prvStatusAccess4", "{\"list\":"+prvStatusAccess4+"}");
		
		//일/월구분
		String prvStatusAccess5 = (request.getParameter("dateModeChartAndListJson")==""||request.getParameter("dateModeChartAndListJson") == null ? "" : request.getParameter("dateModeChartAndListJson"));
		OOFConnectionMemo c5 =oof.addConnectionMemo("prvStatusAccess5", "{\"list\":"+prvStatusAccess5+"}");
				
		c0.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}");
		c1.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}");
		c2.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}");
		c3.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}");
		c4.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}");
		c5.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}");

	}else if("prvStatusSexAge".equals(viewFlag)){
		//개인 성별/연령 현황
		//리포트 상단 공통 영역
	
		String statusSexAge0 = (request.getParameter("reportInfoDataMapJson")==""||request.getParameter("reportInfoDataMapJson") == null ? "" : request.getParameter("reportInfoDataMapJson"));
		OOFConnectionMemo c0 =oof.addConnectionMemo("statusSexAge0", "{\"list\":"+statusSexAge0+"}");

		//회원 성별 현황
		String statusSexAge1 = (request.getParameter("statisticsCustSexInfoJson")==""||request.getParameter("statisticsCustSexInfoJson") == null ? "" : request.getParameter("statisticsCustSexInfoJson"));
		OOFConnectionMemo c1 =oof.addConnectionMemo("statusSexAge1", "{\"list\":"+statusSexAge1+"}");

		//총 회원 수 및 연령별 데이터, 파이차트 옆 연령 별 데이터
		String statusSexAge2 = (request.getParameter("statisticsCustAgeInfoJson")==""||request.getParameter("statisticsCustAgeInfoJson") == null ? "" : request.getParameter("statisticsCustAgeInfoJson"));
		OOFConnectionMemo c2 =oof.addConnectionMemo("statusSexAge2", "{\"list\":"+statusSexAge2+"}");

		//라인차트 데이터
		String statusSexAge3 = (request.getParameter("lineChartDataJson")==""||request.getParameter("lineChartDataJson") == null ? "" : request.getParameter("lineChartDataJson"));
		OOFConnectionMemo c3 =oof.addConnectionMemo("statusSexAge3", "{\"list\":"+statusSexAge3+"}");

		//파이차트 데이터
		String statusSexAge4 = (request.getParameter("pieChartDataJson")==""||request.getParameter("pieChartDataJson") == null ? "" : request.getParameter("pieChartDataJson"));
		OOFConnectionMemo c4 =oof.addConnectionMemo("statusSexAge4", "{\"list\":"+statusSexAge4+"}");
	
		//일/월구분
		String statusSexAge5 = (request.getParameter("dateModeAndSexJson")==""||request.getParameter("dateModeAndSexJson") == null ? "" : request.getParameter("dateModeAndSexJson"));
		OOFConnectionMemo c5 =oof.addConnectionMemo("statusSexAge5", "{\"list\":"+statusSexAge5+"}");
				
		c0.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}");
		c1.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}");
		c2.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}");
		c3.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}");
		c4.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}");
		c5.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}");
		
	}else if("prvStatusArea".equals(viewFlag)){
		//개인 지역별현황
		//리포트 상단 공통 영역
		String prvStatusArea0 = (request.getParameter("reportInfoDataMapJson")==""||request.getParameter("reportInfoDataMapJson") == null ? "" : request.getParameter("reportInfoDataMapJson"));
		OOFConnectionMemo c0 =oof.addConnectionMemo("prvStatusArea0", "{\"list\":"+prvStatusArea0+"}");

		//회원 지역별 현황 (총회원수, 남성, 여성)
		String prvStatusArea1 = (request.getParameter("totalInfoJson")==""||request.getParameter("totalInfoJson") == null ? "" : request.getParameter("totalInfoJson"));
		OOFConnectionMemo c1 =oof.addConnectionMemo("prvStatusArea1", "{\"list\":"+prvStatusArea1+"}");

		//회원 지역별 현황 (성/시별 회원수)
		String prvStatusArea2 = (request.getParameter("listResultJson")==""||request.getParameter("listResultJson") == null ? "" : request.getParameter("listResultJson"));
		OOFConnectionMemo c2 =oof.addConnectionMemo("prvStatusArea2", "{\"list\":"+prvStatusArea2+"}");

		//성/시별 상세 지역현황
		String prvStatusArea3 = (request.getParameter("detailListResultJson")==""||request.getParameter("detailListResultJson") == null ? "" : request.getParameter("detailListResultJson"));
		OOFConnectionMemo c3 =oof.addConnectionMemo("prvStatusArea3", "{\"list\":"+prvStatusArea3+"}");
		
		//센터구분
		String prvStatusArea4 = (request.getParameter("detailGrpCenterJson")==""||request.getParameter("detailGrpCenterJson") == null ? "" : request.getParameter("detailGrpCenterJson"));
		OOFConnectionMemo c4 =oof.addConnectionMemo("prvStatusArea4", "{\"list\":"+prvStatusArea4+"}");
				
		c0.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}");
		c1.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}");
		c2.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}");
		c3.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}");
		c4.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}");


	}else if("corStatusMemberJoin".equals(viewFlag)){
		//기업가입현황
		//리포트 상단 공통 영역
		String corStatusMemberJoin0 = (request.getParameter("reportInfoDataMapJson")==""||request.getParameter("reportInfoDataMapJson") == null ? "" : request.getParameter("reportInfoDataMapJson"));
		OOFConnectionMemo c0 =oof.addConnectionMemo("corStatusMemberJoin0", "{\"list\":"+corStatusMemberJoin0+"}");

		//기업가입현황
		String corStatusMemberJoin1 = (request.getParameter("statsDataJson")==""||request.getParameter("statsDataJson") == null ? "" : request.getParameter("statsDataJson"));
		OOFConnectionMemo c1 =oof.addConnectionMemo("corStatusMemberJoin1", "{\"list\":"+corStatusMemberJoin1+"}");

		//기간별 기업가입 현황
		String corStatusMemberJoin2 = (request.getParameter("totalInfoJson")==""||request.getParameter("totalInfoJson") == null ? "" : request.getParameter("totalInfoJson"));
		OOFConnectionMemo c2 =oof.addConnectionMemo("corStatusMemberJoin2", "{\"list\":"+corStatusMemberJoin2+"}");

		//회원가입 내역(리스트)
		String corStatusMemberJoin3 = (request.getParameter("coBatchMemberListJson")==""||request.getParameter("coBatchMemberListJson") == null ? "" : request.getParameter("coBatchMemberListJson"));
		OOFConnectionMemo c3 =oof.addConnectionMemo("corStatusMemberJoin3", "{\"list\":"+corStatusMemberJoin3+"}");

		//차트데이터
		String corStatusMemberJoin4 = (request.getParameter("batchDataJson")==""||request.getParameter("batchDataJson") == null ? "" : request.getParameter("batchDataJson"));
		OOFConnectionMemo c4 =oof.addConnectionMemo("corStatusMemberJoin4", "{\"list\":"+corStatusMemberJoin4+"}");


		c0.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}");
		c1.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}");
		c2.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}");
		c3.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}");
		c4.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}");

	}else if("corStatusAccess".equals(viewFlag)){
		//기업접속현황
		//리포트 상단 공통 영역
		String corStatusAccess0 = (request.getParameter("reportInfoDataMapJson")==""||request.getParameter("reportInfoDataMapJson") == null ? "" : request.getParameter("reportInfoDataMapJson"));
		OOFConnectionMemo c0 =oof.addConnectionMemo("corStatusAccess0", "{\"list\":"+corStatusAccess0+"}");

		//기업회원접속현황 - 총 접속자수
		String corStatusAccess1 = (request.getParameter("coTotalJson")==""||request.getParameter("coTotalJson") == null ? "" : request.getParameter("coTotalJson"));
		OOFConnectionMemo c1 =oof.addConnectionMemo("corStatusAccess1", "{\"list\":"+corStatusAccess1+"}");

		//기업회원접속현황 - 오늘의접속자수, 신규접속자수,페이지뷰
		String corStatusAccess1_1 = (request.getParameter("coMemberTodayJson")==""||request.getParameter("coMemberTodayJson") == null ? "" : request.getParameter("coMemberTodayJson"));
		OOFConnectionMemo c1_1 =oof.addConnectionMemo("corStatusAccess1_1", "{\"list\":"+corStatusAccess1_1+"}");

		//기간별 기업가입 현황
		String corStatusAccess2 = (request.getParameter("coMemberBatchJson")==""||request.getParameter("coMemberBatchJson") == null ? "" : request.getParameter("coMemberBatchJson"));
		OOFConnectionMemo c2 =oof.addConnectionMemo("corStatusAccess2", "{\"list\":"+corStatusAccess2+"}");

		//회원가입 내역(리스트)
		String corStatusAccess3 = (request.getParameter("statsDataJson")==""||request.getParameter("statsDataJson") == null ? "" : request.getParameter("statsDataJson"));
		OOFConnectionMemo c3 =oof.addConnectionMemo("corStatusAccess3", "{\"list\":"+corStatusAccess3+"}");

		//차트데이터
		String corStatusAccess4 = (request.getParameter("batchDataJson")==""||request.getParameter("batchDataJson") == null ? "" : request.getParameter("batchDataJson"));
		OOFConnectionMemo c4 =oof.addConnectionMemo("corStatusAccess4", "{\"list\":"+corStatusAccess4+"}");

		c0.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}");
		//c1.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}");
		oof.addField("corStatusAccess1",corStatusAccess1);
		c1_1.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}");
		c2.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}");
		c3.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}");
		c4.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}");

	}else if("corStatusArea".equals(viewFlag)){
		//기업 지역별 현황
		//리포트 상단 공통 영역
		String corStatusArea0 = (request.getParameter("reportInfoDataMapJson")==""||request.getParameter("reportInfoDataMapJson") == null ? "" : request.getParameter("reportInfoDataMapJson"));
		OOFConnectionMemo c0 =oof.addConnectionMemo("corStatusArea0", "{\"list\":"+corStatusArea0+"}");

		//회원 지역별 현황
		String corStatusArea1 = (request.getParameter("totalInfoJson")==""||request.getParameter("totalInfoJson") == null ? "" : request.getParameter("totalInfoJson"));
		OOFConnectionMemo c1 =oof.addConnectionMemo("corStatusArea1", "{\"list\":"+corStatusArea1+"}");

		//성/시별 회원현황
		String corStatusArea2 = (request.getParameter("listResultJson")==""||request.getParameter("listResultJson") == null ? "" : request.getParameter("listResultJson"));
		OOFConnectionMemo c2 =oof.addConnectionMemo("corStatusArea2", "{\"list\":"+corStatusArea2+"}");

		//성/시별 상세 지역현황
		String corStatusArea3 = (request.getParameter("detailListResultJson")==""||request.getParameter("detailListResultJson") == null ? "" : request.getParameter("detailListResultJson"));
		OOFConnectionMemo c3 =oof.addConnectionMemo("corStatusArea3", "{\"list\":"+corStatusArea3+"}");

		c0.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}");
		c1.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}");
		c2.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}");
		c3.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}");


	}else if("statPlcmt".equals(viewFlag)){
		//취업알선 통계
		//리포트 상단 공통 영역
		String statPlcmt0 = (request.getParameter("reportInfoDataMapJson")==""||request.getParameter("reportInfoDataMapJson") == null ? "" : request.getParameter("reportInfoDataMapJson"));
		OOFConnectionMemo c0 =oof.addConnectionMemo("statPlcmt0", "{\"list\":"+statPlcmt0+"}");

		//알선수,알선기업수,알선성공수
		String statPlcmt1 = (request.getParameter("plcmtTotalInfoJson")==""||request.getParameter("plcmtTotalInfoJson") == null ? "" : request.getParameter("plcmtTotalInfoJson"));
		OOFConnectionMemo c1 =oof.addConnectionMemo("statPlcmt1", "{\"list\":"+statPlcmt1+"}");

		//센터별 통계
		String statPlcmt2 = (request.getParameter("plcmtListJson")==""||request.getParameter("plcmtListJson") == null ? "" : request.getParameter("plcmtListJson"));
		OOFConnectionMemo c2 =oof.addConnectionMemo("statPlcmt2", "{\"list\":"+statPlcmt2+"}");

		//지점별 통계
		String statPlcmt3 = (request.getParameter("plcmtDetailListJson")==""||request.getParameter("plcmtDetailListJson") == null ? "" : request.getParameter("plcmtDetailListJson"));
		OOFConnectionMemo c3 =oof.addConnectionMemo("statPlcmt3", "{\"list\":"+statPlcmt3+"}");

		//차트데이터
		String statPlcmt4 = (request.getParameter("plcmtListChartJson")==""||request.getParameter("plcmtListChartJson") == null ? "" : request.getParameter("plcmtListChartJson"));
		OOFConnectionMemo c4 =oof.addConnectionMemo("statPlcmt4", "{\"list\":"+statPlcmt4+"}");

		c0.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}");
		c1.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}");
		c2.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}");
		c3.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}");
		c4.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}");
		
	}else if("recommendationLetter".equals(viewFlag)){
		
		//리포트 상단 공통 영역
		String recommendationLetter0 = (request.getParameter("reportInfoDataMapJson")==""||request.getParameter("reportInfoDataMapJson") == null ? "" : request.getParameter("reportInfoDataMapJson"));
		OOFConnectionMemo c0 =oof.addConnectionMemo("recommendationLetter0", "{\"header\":"+recommendationLetter0+"}");

		//알선수,알선기업수,알선성공수
		String recommendationLetter1 = (request.getParameter("recommendationLetterJson")==""||request.getParameter("recommendationLetterJson") == null ? "" : request.getParameter("recommendationLetterJson"));
		OOFConnectionMemo c1 =oof.addConnectionMemo("recommendationLetter1", "{\"list\":"+recommendationLetter1+"}");
		
		c0.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}");
		c1.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}");
			
	}else if("seekStatusSeek".equals(viewFlag)){	
		// 구직자 현황 통계
		String seekStatusSeek0 = (request.getParameter("reportInfoMapJson")==""||request.getParameter("reportInfoMapJson") == null ? "" : request.getParameter("reportInfoMapJson"));
		OOFConnectionMemo c0 = oof.addConnectionMemo("*", seekStatusSeek0);
		
		c0.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}");
		
	}else if("seekStatusArea".equals(viewFlag)){
		// 구직자 지역별 통계
		String seekStatusArea0 = (request.getParameter("reportInfoMapJson")==""||request.getParameter("reportInfoMapJson") == null ? "" : request.getParameter("reportInfoMapJson"));
		OOFConnectionMemo c0 = oof.addConnectionMemo("*", seekStatusArea0);
		
		c0.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}");
	}else if("accessStatusHourAccess".equals(viewFlag)){
		// 프로필등록 시간별 통계
		// 작업중 .........
	}else if("wantedStatusCo".equals(viewFlag)){
		// 구인기업 현황
		String wantedStatusCo0 = (request.getParameter("reportInfoMapJson")==""||request.getParameter("reportInfoMapJson") == null ? "" : request.getParameter("reportInfoMapJson"));
		OOFConnectionMemo c0 = oof.addConnectionMemo("*", wantedStatusCo0);
		
		c0.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}");
	}else if("wantedStatusArea".equals(viewFlag)){
		// 구인기업 지역별 통계
		String wantedStatusArea0 = (request.getParameter("reportInfoMapJson")==""||request.getParameter("reportInfoMapJson") == null ? "" : request.getParameter("reportInfoMapJson"));
		OOFConnectionMemo c0 = oof.addConnectionMemo("*", wantedStatusArea0);
		
		c0.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}");
	}else if("wantedStatusWanted".equals(viewFlag)){
		// 구인기업 구인통계
		String wantedStatusWanted0 = (request.getParameter("reportInfoMapJson")==""||request.getParameter("reportInfoMapJson") == null ? "" : request.getParameter("reportInfoMapJson"));
		OOFConnectionMemo c0 = oof.addConnectionMemo("*", wantedStatusWanted0);
		
		c0.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}");
	}else if("wantedStatusJobs".equals(viewFlag)){
		// 구인기업 직종별 통계
		String wantedStatusJobs0 = (request.getParameter("reportInfoMapJson")==""||request.getParameter("reportInfoMapJson") == null ? "" : request.getParameter("reportInfoMapJson"));
		OOFConnectionMemo c0 = oof.addConnectionMemo("*", wantedStatusJobs0);
		
		c0.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}");
	}else if("wantedStatusCoTp".equals(viewFlag)){
		// 구인기업 기업형태별 통계
		String wantedStatusCoTp0 = (request.getParameter("reportInfoMapJson")==""||request.getParameter("reportInfoMapJson") == null ? "" : request.getParameter("reportInfoMapJson"));
		OOFConnectionMemo c0 = oof.addConnectionMemo("*", wantedStatusCoTp0);
		
		c0.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}");
	}else if("wantedStatusSalary".equals(viewFlag)){
		// 구인기업 급여별 통계
		String wantedStatusSalary0 = (request.getParameter("reportInfoMapJson")==""||request.getParameter("reportInfoMapJson") == null ? "" : request.getParameter("reportInfoMapJson"));
		OOFConnectionMemo c0 = oof.addConnectionMemo("*", wantedStatusSalary0);
		
		c0.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}");
	}else if("wantedStatusSpcltySkillLvl".equals(viewFlag)){
		// 구인기업 기술전문레벨별 통계
		String wantedStatusSpcltySkillLvl0 = (request.getParameter("reportInfoMapJson")==""||request.getParameter("reportInfoMapJson") == null ? "" : request.getParameter("reportInfoMapJson"));
		OOFConnectionMemo c0 = oof.addConnectionMemo("*", wantedStatusSpcltySkillLvl0);
		
		c0.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}");
	}else if("accessStatusYearAccess".equals(viewFlag)){
		// 연간접속자 통계
		String accessStatusYearAccess0 = (request.getParameter("reportInfoMapJson")==""||request.getParameter("reportInfoMapJson") == null ? "" : request.getParameter("reportInfoMapJson"));
		OOFConnectionMemo c0 = oof.addConnectionMemo("*", accessStatusYearAccess0);
		
		c0.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}");
	}else if("accessStatusHourAccess".equals(viewFlag)){
		// 시간대별 접속자 통계
		// 
		//
	}else if("eventStatusArea".equals(viewFlag)){
		// 지역별 채용행사 현황
		String eventStatusArea0 = (request.getParameter("reportInfoMapJson")==""||request.getParameter("reportInfoMapJson") == null ? "" : request.getParameter("reportInfoMapJson"));
		OOFConnectionMemo c0 = oof.addConnectionMemo("*", eventStatusArea0);
		
		c0.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}");
	}else if("eventStatusBranch".equals(viewFlag)){
		// 지점별 채용행사 현황
		String eventStatusBranch0 = (request.getParameter("reportInfoMapJson")==""||request.getParameter("reportInfoMapJson") == null ? "" : request.getParameter("reportInfoMapJson"));
		OOFConnectionMemo c0 = oof.addConnectionMemo("*", eventStatusBranch0);
		
		c0.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}");
	}else if("eventStatusJobs".equals(viewFlag)){	
		// 직종별 채용행사 현황
		String eventStatusJobs0 = (request.getParameter("reportInfoMapJson")==""||request.getParameter("reportInfoMapJson") == null ? "" : request.getParameter("reportInfoMapJson"));
		OOFConnectionMemo c0 = oof.addConnectionMemo("*", eventStatusJobs0);
		
		c0.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}");
	}else if("eventStatusPerEvent10".equals(viewFlag)){	
		// 채용행사별 현황
		String eventStatusPerEvent10_0 = (request.getParameter("reportInfoMapJson")==""||request.getParameter("reportInfoMapJson") == null ? "" : request.getParameter("reportInfoMapJson"));
		OOFConnectionMemo c0 = oof.addConnectionMemo("*", eventStatusPerEvent10_0);
		
		c0.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}");
	}else if("eventStatusPerEvent20".equals(viewFlag)){	
		// 채용행사별 현황
		String eventStatusPerEvent20_0 = (request.getParameter("reportInfoMapJson")==""||request.getParameter("reportInfoMapJson") == null ? "" : request.getParameter("reportInfoMapJson"));
		OOFConnectionMemo c0 = oof.addConnectionMemo("*", eventStatusPerEvent20_0);
		
		c0.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}");
	}else if("eventStatusPerEvent30".equals(viewFlag)){	
		// 채용행사별 현황
		String eventStatusPerEvent30_0 = (request.getParameter("reportInfoMapJson")==""||request.getParameter("reportInfoMapJson") == null ? "" : request.getParameter("reportInfoMapJson"));
		OOFConnectionMemo c0 = oof.addConnectionMemo("*", eventStatusPerEvent30_0);
		
		c0.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}");
	
	}else if("eventStatusPerEvent40".equals(viewFlag)){	
		// 채용행사별 현황
		String eventStatusPerEvent40_0 = (request.getParameter("reportInfoMapJson")==""||request.getParameter("reportInfoMapJson") == null ? "" : request.getParameter("reportInfoMapJson"));
		OOFConnectionMemo c0 = oof.addConnectionMemo("*", eventStatusPerEvent40_0);
		
		c0.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}");
	}else if("eventStatusPerEvent50".equals(viewFlag)){	
		// 채용행사별 현황
		String eventStatusPerEvent50_0 = (request.getParameter("reportInfoMapJson")==""||request.getParameter("reportInfoMapJson") == null ? "" : request.getParameter("reportInfoMapJson"));
		OOFConnectionMemo c0 = oof.addConnectionMemo("*", eventStatusPerEvent50_0);
		
		c0.addContentParamJSON("*", "utf-8", "{%dataset.json.root%}");
	}


%><%@include file="Property.jsp"%><%
	//세션을 활용하여 리포트키들을 관리하지 않는 옵션
//request.getSession().setAttribute("ClipReport-SessionList-Allow", false);
	String resultKey =  ReportUtil.createReport(request, oof, "false", "false", request.getRemoteAddr(), propertyPath);

//    System.out.println("propertyPath======>" + propertyPath);

//리포트의 특정 사용자 ID를 부여합니다.
//clipreport4.properties 의 useuserid 옵션이 true 일 때만 적용됩니다.
//clipreport4.properties 의 useuserid 옵션이 true 이고 기본 예제[String resultKey =  ReportUtil.createReport(request, oof, "false", "false", request.getRemoteAddr(), propertyPath);] 사용 했을 때 세션ID가 userID로 사용 됩니다.
//String resultKey =  ReportUtil.createReport(request, oof, "false", "false", request.getRemoteAddr(), propertyPath, "userID");

//리포트key의 사용자문자열을 추가합니다.(문자숫자만 가능합니다.)
//String resultKey =  ReportUtil.createReport(request, oof, "false", "false", request.getRemoteAddr(), propertyPath, "", "usetKey");

//리포트를 저장 스토리지를 지정하여 생성합니다.
//String resultKey =  ReportUtil.createReportByStorage(request, oof, "false", "false", request.getRemoteAddr(), propertyPath, "rpt1");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Report</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<link rel="stylesheet" type="text/css" href="./css/clipreport.css">
	<link rel="stylesheet" type="text/css" href="./css/UserConfig.css">
	<link rel="stylesheet" type="text/css" href="./css/font.css">
	<script type='text/javascript' src='./js/jquery-1.11.1.js'></script>
	<script type='text/javascript' src='./js/clipreport.js'></script>
	<script type='text/javascript' src='./js/UserConfig.js'></script>
	<script type='text/javascript'>
		var urlPath = document.location.protocol + "//" + document.location.host;

		function html2xml(divPath){
			var reportkey = "<%=resultKey%>";
			var report = createImportJSPReport(urlPath + "/ClipReport4/Clip.jsp", reportkey, document.getElementById(divPath));
			report.setLanguage("en");
			//리포트 실행
			report.view();
		}
	</script>
</head>
<body onload="html2xml('targetDiv1')">
<div id='targetDiv1' style='position:absolute;top:5px;left:5px;right:5px;bottom:5px;'></div>
</body>
</html>
