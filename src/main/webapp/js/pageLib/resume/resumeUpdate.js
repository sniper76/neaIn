
	var	resumeUpdate = {
			name: 'resumeUpdate',

			init: function() {
				var that$ = this;

				$.when( that$.beforeBind() ).done(function( res ) {
					that$.bind();
					that$.afterBind();
				});
			},

			beforeBind: function() {
				var that$ = this;
				var deferred = $.Deferred();

				$.when( ).done(function( ) {
					deferred.resolve();
				});

	            return deferred.promise();
			},

			bind: function() {
				var that$ = this;
				var resumeInsertCompleteMsg = "<spring:message code='resume.write.insert.complete'/>";
	    		var resumeFullInsertMsg = "<spring:message code='resume.write.insert.fullCnt'/>";
	    		var resumeInsertErrorMsg = "<spring:message code='resume.write.insert.error'/>";
				commonPopupSet('isco');
				fnCntryCd();
				common.form.fnInputValidation('inputNo', '1');
				common.form.fnCheckEmail('inputEmail');

				$('.btn_addForm').on('click', function(e){
					var cloneHtml = $(e.target).closest('div').find('.tr_original').clone();
					cloneHtml.removeClass('tr_original');
					cloneHtml.find('.tr_delete').show();
					cloneHtml.find('input').val('');


					$(e.target).closest('div').find('tbody').append(cloneHtml);
					fnTrDelete();
					fnCntryCd();
					fnCalculationCareerUpdate();
					common.form.fnCheckEmail('inputEmail');
				});

				fnCalculationCareerUpdate();

				// 저장
				$('#btnSave').on('click', function(){
					var profile_title = $('#profile_title').val();

					// 인적 사항 입력 여부 체크
					var addrFullNm = $('input[name=addrFullNm]').val();
					var addrFullCd = $('input[name=addrFullCd]').val();
					var addrCd = $('input[name=addrCd]').val();
					var marriCd = $('input[name=marriCd]:checked').val();
					var familyCnt = $('#familyCnt').val();
					var underAge15FamilyCnt = $('#underAge15FamilyCnt').val();
					var overAge64FamilyCnt  = $('#overAge64FamilyCnt').val();
					var disablYn            = ($('select[name=disablYn]').val() == 'Y') ? 'Y' : 'N';
					var selfempYn           = ($('select[name=selfempYn]').val() == 'Y') ? 'Y' : 'N';
					var frstimeJobSeekerYn = ($('#frstimeJobSeekerYn').val() == 'Y') ? 'Y' : 'N';
					var studyingYn = ($('#studyingYn').val() == 'Y') ? 'Y' : 'N';
					var retMigratYn = ($('#retMigratYn').val() == 'Y') ? 'Y' : 'N';
					var srvcYn = ($('#srvcYn').val() == 'Y') ? 'Y' : 'N';
					var ethnicMinorYn = ($('#ethnicMinorYn').val() == 'Y') ? 'Y' : 'N';
					var addrDtl = $('#addrDtl').val();

					var disablOptionCdList = [];

					$('#disablOptionCd').find('input[type=checkbox]:checked').each(function(){
						disablOptionCdList.push($(this).val());
					});

					// ~ 인적 사항 입력 여부 체크

					// 희망근무 조건 입력 여부 체크

					var preferJobTitle     = $('#preferJobTitle').val();
					var preferPosition     = $('#preferPosition').val();
					var employFormCd       = $('select[name=employFormCd]').val();
					var expctMinSalaryAmt  = $('#expctMinSalaryAmt').val();
					var expctMaxSalaryAmt  = $('#expctMaxSalaryAmt').val();

					var preferEmployTypeCd = $('input[name=preferEmployTypeCd]:checked').val();

					var typeEmployHourDay = $('#typeEmployHourDay').val();
					var typeEmployDayWeek = $('#typeEmployDayWeek').val();
					var preferDayMon      = ($('#preferDayMon:checked').val() == 'Y') ? 'Y' : 'N';
					var preferDayTue      = ($('#preferDayTue:checked').val() == 'Y') ? 'Y' : 'N';
					var preferDayWed      = ($('#preferDayWed:checked').val() == 'Y') ? 'Y' : 'N';
					var preferDayThu      = ($('#preferDayThu:checked').val() == 'Y') ? 'Y' : 'N';
					var preferDayFri      = ($('#preferDayFri:checked').val() == 'Y') ? 'Y' : 'N';
					var preferDaySat      = ($('#preferDaySat:checked').val() == 'Y') ? 'Y' : 'N';
					var preferDaySun      = ($('#preferDaySun:checked').val() == 'Y') ? 'Y' : 'N';

					var nightWorkYn      = ($('#nightWorkYn:checked').val() == 'Y') ? 'Y' : 'N';
					var overTimeWorkYn      = ($('#overTimeWorkYn:checked').val() == 'Y') ? 'Y' : 'N';
					var hldayWorkYn      = ($('#hldayWorkYn:checked').val() == 'Y') ? 'Y' : 'N';

					var preferCrtctType    = $('input[name=preferCrtctType]:checked').val();
					var diffProvcWorkYn    = $('input[name=diffProvcWorkYn]:checked').val();

					var workBgnAbleYn      = $('select[name=workBgnAbleYn]:checked').val();
					var workBgnAbleWithin  = $('#workBgnAbleWithin').val();

					var hopeWorkLocList = [];

					$('#span_hopeLoc').find('span').each(function(){
						var hopeWorkLocObj = new Object();
						hopeWorkLocObj.addrCd = $(this).find('input[name=hopeLocCd]').val();
						hopeWorkLocObj.addrFullCd = $(this).find('input[name=hopeLocFullCd]').val();
						hopeWorkLocObj.addrFullNm = $(this).find('input[name=hopeLocFullNm]').val();

						hopeWorkLocList.push(hopeWorkLocObj);
					});

					var iscoList = [];
					$('#span_isco').find('span').each(function(){
						var iscoObj = new Object();
						iscoObj.iscoCd = $(this).find('input[name=iscoCd]').val();

						iscoList.push(iscoObj);
					});

					// ~ 희망근무 조건 입력 여부 체크

					// 학력 및 전문 훈련 입력 여부 체크
					var eduDegreeCd = $('select[name=eduDegreeCd]').val();

					// ~ 학력 및 전문 훈련 입력 여부 체크

					// 연구 및 전문분야 입력 여부 체크

					var ss_formList = [];

					$('#ss_form').find('tr').each(function(){
						var ss_specialStudyNm = $(this).find('input[name=ss_specialStudyNm]').val();
						var ss_bgnDt_mm = $(this).find('select[name=ss_bgnDt_mm]').val();
						var ss_bgnDt_yy = $(this).find('select[name=ss_bgnDt_yy]').val();
						var ss_endDt_mm = $(this).find('select[name=ss_endDt_mm]').val();
						var ss_endDt_yy = $(this).find('select[name=ss_endDt_yy]').val();
						var ss_insttNm = $(this).find('input[name=ss_insttNm]').val();
						var ss_cntryCd = $(this).find('select[name=ss_cntryCd]').val();
						var ss_provcCd = $(this).find('select[name=ss_provcCd]').val();

						/*if(ss_specialStudyNm == "" || ss_specialStudyNm == "" || ss_specialStudyNm == "" || ss_specialStudyNm == "" || ss_specialStudyNm == ""
							 || ss_specialStudyNm == "" || ss_specialStudyNm == "" || ss_specialStudyNm == ""){

							alertify.alert(resumeSpecialtyMsg);
						}else{*/
							var ss_formObj = new Object();
							ss_formObj.specialStudyNm = ss_specialStudyNm;
							ss_formObj.bgnDt = ss_bgnDt_yy + "-" + ss_bgnDt_mm + "-01";
							ss_formObj.endDt = ss_endDt_yy + "-" + ss_endDt_mm + "-01";
							ss_formObj.insttNm = ss_insttNm;
							ss_formObj.cntryCd = ss_cntryCd;
							ss_formObj.provcCd = ss_provcCd;

							ss_formList.push(ss_formObj);
						//}
					});

					// ~ 연구 및 전문분야 입력 여부 체크

					// 자격증 보유 여부
					var tot_proLicnsSpec = "";
					var proLicnsYn = "N";
					$('#proLicnsSpec_form').find('tr').each(function(){
						var proLicnsSpec = $(this).find('input[name=proLicnsSpec]').val();

						if(tot_proLicnsSpec == ""){
							tot_proLicnsSpec += proLicnsSpec;
						}else{
							tot_proLicnsSpec += "," + proLicnsSpec;
						}

					});

					if(tot_proLicnsSpec != ""){
						proLicnsYn = "Y";
					}

					// ~ 자격증 보유 여부

					// 기타교육
					var ot_formList = [];
					$('#ot_form').find('tr').each(function(){
						var ot_trnngEduDegreeCd = $(this).find('input[name=ot_trnngEduDegreeCd]').val();
						var ot_iscedCd          = $(this).find('input[name=ot_iscedCd]').val();
						var ot_insttNm          = $(this).find('input[name=ot_insttNm]').val();
						var ot_addrProvcCd      = $(this).find('select[name=ot_addrProvcCd]').val();
						var ot_bgnDt_mm         = $(this).find('select[name=ot_bgnDt_mm]').val();
						var ot_bgnDt_yy         = $(this).find('select[name=ot_bgnDt_yy]').val();
						var ot_endDt_mm         = $(this).find('select[name=ot_endDt_mm]').val();
						var ot_endDt_yy         = $(this).find('select[name=ot_endDt_yy]').val();

						/*if(ot_trnngEduDegreeCd == "" || ot_iscedCd == "" || ot_insttNm == "" || ot_addrProvcCd == "" || ot_bgnDt_mm == "" || ot_bgnDt_yy == ""
							|| ot_endDt_mm == "" || ot_endDt_yy == ""){

							alertify.alert(resumeOtherMsg);
						}else{*/
							var ot_formObj = new Object();
							ot_formObj.trnngEduDegreeCd = ot_trnngEduDegreeCd;
							ot_formObj.iscedCd = ot_iscedCd;
							ot_formObj.insttNm = ot_insttNm;
							ot_formObj.addrProvcCd = ot_addrProvcCd;
							ot_formObj.bgnDt = ot_bgnDt_yy + "-" + ot_bgnDt_mm + "-01";
							ot_formObj.endDt = ot_endDt_yy + "-" + ot_endDt_mm + "-01";

							ot_formList.push(ot_formObj);
						//}
					});

					// ~ 기타 교육

					// 어학
					var rl_formList = [];

					var rl_langCd_native = $('select[name=rl_langCd_native]').val();

					var rl_formObj_native = new Object();
					rl_formObj_native.langCd = rl_langCd_native;
					rl_formObj_native.langTypeCd = "Native";

					$('.rl_form').each(function(){
						var rl_langCd = $(this).find('select[name=rl_langCd]').val();
						var rl_langLvlCd = $(this).find('select[name=rl_langLvlCd]').val();

						/*if(rl_langNm == "" || rl_langLvlCd == ""){
							alertify.alert(resumeLanguageMsg);
						}else{*/
							var rl_formObj = new Object();
							rl_formObj.langCd = rl_langCd;
							rl_formObj.langLvlCd = rl_langLvlCd;
							rl_formObj.langTypeCd = "Foreign Language";

							rl_formList.push(rl_formObj);
						//}
					});

					rl_formList.push(rl_formObj_native);

					// ~ 어학

					// 경력
					var careerYn = "N";
					var workYearCnt = $('.totYear').html();
					var workMonthCnt = $('.totMonths').html();

					if(workYearCnt == ""){
						workYearCnt = "0";
					}

					if(workMonthCnt == ""){
						workMonthCnt == "0";
					}

					if(workYearCnt != "0" || workMonthCnt != "0"){
						careerYn = "Y";
					}

					var exp_formList = [];
					$('.exp_form').each(function(){
						//직급/직책 컬럼없음
						var exp_orgnzNm     = $(this).find('input[name=exp_orgnzNm]').val();
						var exp_iscoCd      = $(this).find('input[name=exp_iscoCd]').val();
						var exp_selfempYn   = $(this).find('select[name=exp_selfempYn]').val();
						var exp_bgnDt_mm    = $(this).find('select[name=exp_bgnDt_mm]').val();
						var exp_bgnDt_yy    = $(this).find('select[name=exp_bgnDt_yy]').val();
						var exp_endDt_mm    = $(this).find('select[name=exp_endDt_mm]').val();
						var exp_endDt_yy    = $(this).find('select[name=exp_endDt_yy]').val();
						var exp_leaveReason = $(this).find('input[name=exp_leaveReason]').val();

						/*if(exp_orgnzNm == "" || exp_iscoCd == "" || exp_iscoCd == "" || exp_iscoCd == "" || exp_iscoCd == ""
								|| exp_iscoCd == "" || exp_iscoCd == "" || exp_iscoCd == ""){

							alertify.alert(resumeCareerMsg);
						}else{*/
							var exp_formObj = new Object();
							exp_formObj.orgnzNm = exp_orgnzNm;
							exp_formObj.iscoCd = exp_iscoCd;
							exp_formObj.selfempYn = exp_selfempYn;
							exp_formObj.bgnDt = exp_bgnDt_yy + "-" + exp_bgnDt_mm + "-01";
							exp_formObj.endDt = exp_endDt_yy + "-" + exp_endDt_mm + "-01";
							exp_formObj.leaveReason = exp_leaveReason;

							exp_formList.push(exp_formObj);
						//}
					});

					// ~ 경력

					// skill
					var sk_formList = [];
					$('.sk_form').find('input[name=sk_skillCd]:checked').each(function(){
						sk_formList.push($(this).val());
					});
					// ~ skill

					// 추천인
					var ref_formList = [];
					$('.ref_form').each(function(){
						var ref_nm       = $(this).find('input[name=ref_nm]').val();
						var ref_orgnzNm  = $(this).find('input[name=ref_orgnzNm]').val();
						var ref_position = $(this).find('input[name=ref_position]').val();
						var ref_ref      = $(this).find('input[name=ref_ref]').val();
						var ref_cell     = $(this).find('input[name=ref_cell]').val();
						var ref_email    = $(this).find('input[name=ref_email]').val();
						var ref_addrFullNm   = $(this).find('input[name=ref_addrFullNm]').val();
						var ref_addrFullCd   = $(this).find('input[name=ref_addrFullCd]').val();
						var ref_addrCd   = $(this).find('input[name=ref_addrCd]').val();
						var ref_addrDtl  = $(this).find('input[name=ref_addrDtl]').val();

						/*if(ref_nm == "" || ref_orgnzNm == "" || ref_position == "" || ref_ref == "" || ref_cell == "" || ref_email == ""
							|| ref_addrFullNm == "" || ref_addrFullCd == "" || ref_addrCd == ""
							|| ref_addrDtl == ""
							){

							alertify.alert(resumeReferrerMsg);
						}else{*/
							var ref_formObj = new Object();

							ref_formObj.nm = ref_nm;
							ref_formObj.orgnzNm = ref_orgnzNm;
							ref_formObj.position = ref_position;
							ref_formObj.ref = ref_ref;
							ref_formObj.cell = ref_cell;
							ref_formObj.email = ref_email;
							ref_formObj.addrFullNm = ref_addrFullNm;
							ref_formObj.addrCd = ref_addrCd;
							ref_formObj.addrFullCd = ref_addrFullCd;
							ref_formObj.addrDtl = ref_addrDtl;


							ref_formList.push(ref_formObj);
						//}
					});
					// ~ 추천인

					// keyword
					var resumeKeyword = "";
					$('#keyword_area').find('span').each(function(){
						var keywordVal = $(this).html();
						var deleteSpanIndex = keywordVal.indexOf("<");
						keywordVal = keywordVal.substring(0, deleteSpanIndex);

						if(resumeKeyword == ""){
							resumeKeyword += keywordVal;
						}else{
							resumeKeyword += ',' + keywordVal;
						}
					});

					$.ajax({
						type: 'post',
						url: "/internal/resume/updateResumeAjax.do",
						dataType: 'json',
						data: {
							"userSeq" : $('#userSeq').val(),
							"resumeSeq" : $('#resumeSeq').val(),
							"resumeTitle" : profile_title,
							"addrFullNm" : addrFullNm,
							"addrFullCd" : addrFullCd,
							"addrCd" : addrCd,
							"marriCd" : marriCd,
							"familyCnt" : familyCnt,
							"underAge15FamilyCnt" : underAge15FamilyCnt,
							"overAge64FamilyCnt" : overAge64FamilyCnt,
							"disablYn" : disablYn,
							"selfempYn" : selfempYn,
							"frstimeJobSeekerYn" : frstimeJobSeekerYn,
							"studyingYn" : studyingYn,
							"retMigratYn" : retMigratYn,
							"srvcYn" : srvcYn,
							"ethnicMinorYn" : ethnicMinorYn,
							"preferJobTitle" : preferJobTitle,
							"preferPosition" : preferPosition,
							"employFormCd" : employFormCd,
							"expctMinSalaryAmt" : expctMinSalaryAmt,
							"expctMaxSalaryAmt" : expctMaxSalaryAmt,
							"preferEmployTypeCd" : preferEmployTypeCd,
							"typeEmployHourDay" : typeEmployHourDay,
							"typeEmployDayWeek" : typeEmployDayWeek,
							"preferDayMon" : preferDayMon,
							"preferDayTue" : preferDayTue,
							"preferDayWed" : preferDayWed,
							"preferDayThu" : preferDayThu,
							"preferDayFri" : preferDayFri,
							"preferDaySat" : preferDaySat,
							"preferDaySun" : preferDaySun,
							"nightWorkYn" : nightWorkYn,
							"overTimeWorkYn" : overTimeWorkYn,
							"hldayWorkYn" : hldayWorkYn,
							"preferCrtctType" : preferCrtctType,
							"diffProvcWorkYn" : diffProvcWorkYn,
							"workBgnAbleYn" : workBgnAbleYn,
							"workBgnAbleWithin" : workBgnAbleWithin,
							"proLicnsYn" : proLicnsYn,
							"proLicnsSpec" : tot_proLicnsSpec,
							"disableListStr" : JSON.stringify(disablOptionCdList),
							"hopeWorkLocListStr" : JSON.stringify(hopeWorkLocList),
							"genrlEduListStr" : eduDegreeCd,
							"specialStudyListStr" : JSON.stringify(ss_formList),
							"otherTrnngListStr" : JSON.stringify(ot_formList),
							"langListStr" : JSON.stringify(rl_formList),
							"workExpListStr" : JSON.stringify(exp_formList),
							"skillListStr" : JSON.stringify(sk_formList),
							"refManListStr" : JSON.stringify(ref_formList),
							"iscoCdListStr" : JSON.stringify(iscoList),
							"resumeKeyword" : resumeKeyword,
							"careerYn" : careerYn,
							"workYearCnt" : workYearCnt,
							"workMonthCnt" : workMonthCnt,
							"addrDtl" : addrDtl
						},
						success: function(data) {

							if(data.result == "Y"){
								alertify.alert(resumeInsertCompleteMsg, function (e){
									location.href = contextPath + "/internal/user/userElementaryInfoList.do";
								});
							}else if(data.result == "FULL"){
								alertify.alert(resumeFullInsertMsg, function (e){
									location.href = contextPath + "/internal/user/userElementaryInfoList.do";
								});
							}else{
								alertify.alert(resumeInsertErrorMsg);
							}

						},
						error: function(xhr, status, error) {
							alertify.alert(resumeInsertErrorMsg);
						}
					});
				});

				$('#btnDelete').on('click', function(){
					$.ajax({
						type: 'post',
						url: "/internal/resume/deleteResumeAjax.do",
						dataType: 'json',
						data: {
							"resumeSeq" : $('#resumeSeq').val()
						},
						success: function(data) {

							if(data.result > 0){
								alertify.alert(resumeInsertCompleteMsg, function (e){
									location.href = contextPath + "/internal/user/userElementaryInfoList.do";
								});
							}else{
								alertify.alert(resumeInsertErrorMsg);
							}

						},
						error: function(xhr, status, error) {
							alertify.alert(resumeInsertErrorMsg);
						}
					});
				});

			},

			afterBind: function() {
				var that$ = this;
			},

			fn: {
				pageAction : function() {
				},
			}
	}

	function fnSetIsco(json){
		var iscoHtml = "<span>" + json.commonNm + "<input type='hidden' class='iscoCd' name='iscoCd' value='" + json.commonCd + "'/>";
		iscoHtml += "<button type='button' class='delete'>delete</button></span>";

		$('#span_isco').append(iscoHtml);
	}

	function fnSetHopeLoc(json){
		var addrHtml = "<span>" + json.commonNm + "<input type='hidden' name='hopeLocCd' value='" + json.commonCd + "'/>";
		addrHtml += "<input type='hidden' name='hopeLocFullNm' value='" + json.commonFullNm + "'/>";
		addrHtml += "<input type='hidden' name='hopeLocFullCd' value='" + json.commonFullCd + "'/>";
		addrHtml += "<button type='button'>delete</button></span>";

		$('#span_hopeLoc').append(addrHtml);
	}

	function fnTrDelete(){
		$('.tr_delete').unbind();
		$('.tr_delete').on('click', function(e){
			$(e.target).closest('tr').remove();
		});
	}

	function fnCntryCd(){
		$('.cntryCd').unbind();
		$('.cntryCd').on('change', function(e){
			var cntryCd = $(e.target).val();

			$.ajax({
				type: 'post',
				url: "/internal/resume/addrNextDepthSelectAjax.do",
				dataType: 'json',
				data: {
					"depth" : "99",
					"condGrpCd" : cntryCd,
					"cdLength" : cntryCd.length
				},
				success: function(data) {
					var html = "";
					if(data.result.length > 0){
						for(var i in data.result){
							var resultObj = data.result[i];
							html += "<option value='" + resultObj.lvlCd +"'>" + resultObj.nmEn + "</option>";
						}
					}

					$(e.target).closest('tr').find('.provcCd').empty();
					$(e.target).closest('tr').find('.provcCd').html(html);

				},
				error: function(xhr, status, error) {
					alert('error to connecting server');
				}
			});
		});
	}

	function fnCalculationCareerUpdate(){
		$('.calCareer').on('change', function(e){
			var totCareerYy = 0;
			var totCareerMm = 0;
			$('.exp_form').each(function(){
				var startMM = $(this).find('select[name=exp_bgnDt_mm]').val();
				var startYY = $(this).find('select[name=exp_bgnDt_yy]').val();
				var endMM = $(this).find('select[name=exp_endDt_mm]').val();
				var endYY = $(this).find('select[name=exp_endDt_yy]').val();

				if(startMM != "" && startYY != "" && endMM != "" && endYY != ""){
					var startDate = new Date(startYY, Number(startMM)-1, 1);
					var endDate = new Date(endYY, Number(endMM)-1, 1);

					var careerMm = Math.floor((Number(endDate.getTime()) - Number(startDate.getTime())) / (1000 * 60 * 60 * 24 * 30));

					totCareerYy += Math.floor(careerMm / 12);
					totCareerMm += Number((careerMm % 12).toFixed());

					if(totCareerMm >= 12){
						totCareerYy += 1;
						totCareerMm -= 12;
					}
				}

			});

			//$('.calCareerResult').html(totCareerYy + "Year " + totCareerMm + "Months");
			if(totCareerYy < 0){
				totCareerYy = 0;
			}
			if(totCareerMm < 0){
				totCareerMm = 0;
			}
			$('.totYear').html(totCareerYy);
			$('.totMonths').html(totCareerMm);
		});
	}
