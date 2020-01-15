var	interviewSuit = {
	//----------------------------
	// InfoIndex 객체
	//----------------------------
	name: 'interviewSuit',
	year : null,
	month : null,
	date : null,
	ym : null,
	today : null,
	today_year : null,
	today_month : null,
	yearMonthFlag : false,

	init: function() {
		this.beforeBind();
		this.bind();
		this.afterBind();
	},

	beforeBind: function() {
		
	},

	bind: function() {
		var param = {
			"bsnsSeq" : $('#bsnsSeq').val()
		};
		var	opts = {
			url		: contextPath + "/bsnsRecpt/checkRentCnt.do",
			data	: param,
			type	: "post",
			sendDataType	: "json",
			success	: function(resJSON, resCode) {
				
				if(resJSON.data.resultCode == "0001"){
					$.alert(resJSON.data.msg);
					
				}else{
					interviewSuit.fn.getList();
					interviewSuit.fn.getInterviewSuitBsnsList();
				}
				
			}
		};
		common.http.ajax(opts);
	},

	afterBind: function() {
		
		$('#btn_pre').on('click', function(){
			if(interviewSuit.month == "1"){
				interviewSuit.year = Number(interviewSuit.year) - 1;
				interviewSuit.month = 12;
				interviewSuit.fn.setYm();
				interviewSuit.fn.getList();
			}else{
				interviewSuit.month = Number(interviewSuit.month) - 1;
				interviewSuit.fn.setYm();
				interviewSuit.fn.getList();
			}
		});
		
		$('#btn_next').on('click', function(){
			if(interviewSuit.month == "12"){
				interviewSuit.year = Number(interviewSuit.year) + 1;
				interviewSuit.month = 1;
				interviewSuit.fn.setYm();
				interviewSuit.fn.getList();
			}else{
				interviewSuit.month = Number(interviewSuit.month) + 1;
				interviewSuit.fn.setYm();
				interviewSuit.fn.getList();
			}
		})
		
		$('#btn_today').on('click', function(){
			interviewSuit.year = null;
			interviewSuit.month = null;
			interviewSuit.ym = null;
			interviewSuit.fn.getList();
		});
		
	},
	fn: {
		
		// 달력 조회
		getList : function() {
			var param = {
				"ym" : interviewSuit.ym,
				"year" : interviewSuit.year,
				"month" : interviewSuit.month
			};
			var	opts = {
				url		: contextPath + "/bsnsRecpt/getCalendarList.do",
				data	: param,
				type	: "post",
				sendDataType	: "json",
				success	: function(resJSON, resCode) {
					// 목록 데이터 그리기
					interviewSuit.fn.drawList(resJSON.data);
				}
			};
			common.http.ajax(opts);
		},
		
		drawList : function(dataJson) {
			
			var data   = dataJson.list;
			
			$('#calendar_tbody').empty();
			
			interviewSuit.ym = dataJson.ym;
			interviewSuit.year = dataJson.year;
			interviewSuit.month = dataJson.month;
			interviewSuit.today = dataJson.today;
			interviewSuit.today_year = dataJson.today_year;
			interviewSuit.today_month = dataJson.today_month;
			
			interviewSuit.yearMonthFlag = false;
			if(dataJson.year == dataJson.today_year && dataJson.month == dataJson.today_month){
				interviewSuit.yearMonthFlag = true;
			}
			
			$('.yearMonth').html(dataJson.year + "년 " + dataJson.month + "월");
			
			var html = "";
			for(var i in data){
				var weekValue = data[i];
				html += "<tr>";
				if(interviewSuit.yearMonthFlag && weekValue.sun == interviewSuit.today){
					html += "<td class='able c-red'><a href='#none' class='selected clickDate'>" + weekValue.sun + "</a></td>";
				}else{
					html += "<td class='able c-red'><a href='#none' class='clickDate'>" + weekValue.sun + "</a></td>";
				}
				if(interviewSuit.yearMonthFlag && weekValue.mon == interviewSuit.today){
					html += "<td class='able'><a href='#none' class='selected clickDate'>" + weekValue.mon + "</a></td>";
				}else{
					html += "<td class='able'><a href='#none' class='clickDate'>" + weekValue.mon + "</a></td>";
				}
				if(interviewSuit.yearMonthFlag && weekValue.tue == interviewSuit.today){
					html += "<td class='able'><a href='#none' class='selected clickDate'>" + weekValue.tue + "</a></td>";
				}else{
					html += "<td class='able'><a href='#none' class='clickDate'>" + weekValue.tue + "</a></td>";
				}
				if(interviewSuit.yearMonthFlag && weekValue.wed == interviewSuit.today){
					html += "<td class='able'><a href='#none' class='selected clickDate'>" + weekValue.wed + "</a></td>";
				}else{
					html += "<td class='able'><a href='#none' class='clickDate'>" + weekValue.wed + "</a></td>";
				}
				if(interviewSuit.yearMonthFlag && weekValue.thu == interviewSuit.today){
					html += "<td class='able'><a href='#none' class='selected clickDate'>" + weekValue.thu + "</a></td>";
				}else{
					html += "<td class='able'><a href='#none' class='clickDate'>" + weekValue.thu + "</a></td>";
				}
				if(interviewSuit.yearMonthFlag && weekValue.fri == interviewSuit.today){
					html += "<td class='able'><a href='#none' class='selected clickDate'>" + weekValue.fri + "</a></td>";
				}else{
					html += "<td class='able'><a href='#none' class='clickDate'>" + weekValue.fri + "</a></td>";
				}
				if(interviewSuit.yearMonthFlag && weekValue.sat == interviewSuit.today){
					html += "<td class='able c-blue'><a href='#none' class='selected clickDate'>" + weekValue.sat + "</a></td>";
				}else{
					html += "<td class='able c-blue'><a href='#none' class='clickDate'>" + weekValue.sat + "</a></td>";
				}
				html += "</tr>";
			}
			
			$('#calendar_tbody').html(html);
			interviewSuit.fn.calendarClick();
			interviewSuit.fn.setCalendarDisable();
		},
		
		calendarClick : function(){
			$('.selDay .table td a').on('click',function(e){
				$('.selDay .table td a').removeClass('selected');
				$(this).addClass('selected');
				
				if(!$(e.target).closest('td').hasClass('able')){
					$.alert('해당 날짜는 면접정장 대여신청을 할 수 없는 날짜입니다. 다른 날짜를 선택해 주세요.');
					$('#time_tbody').empty();
					return false;
				}
				
				interviewSuit.date = $(e.target).html();
				
				var month = "";
				var date = "";
				
				if(Number(interviewSuit.month) < 10){
					month = "0" + interviewSuit.month;
				}else{
					month = interviewSuit.month;
				}
				
				if(Number(interviewSuit.date) < 10){
					date = "0" + interviewSuit.date;
				}else{
					date = interviewSuit.date;
				}
				
				$('#selectedDate').html(interviewSuit.year + "년 " + month + "월 " + date + "일");
				
				var param = {
					"year" : interviewSuit.year,
					"month" : interviewSuit.month,
					"date" : interviewSuit.date,
					"bsnsSeq" : $('#bsnsSeq').val(),
				};
				
				var	opts = {
					url		: contextPath + "/bsnsRecpt/checkAvailability.do",
					data	: param,
					type	: "post",
					sendDataType	: "json",
					success	: function(resJSON, resCode) {
						
						$('#time_tbody').empty();
						if(resJSON.data.resultCode == "0000"){
							
							var value09 = "";
							var value10 = "";
							var value11 = "";
							var value12 = "";
							var value13 = "";
							var value14 = "";
							var value15 = "";
							var value16 = "";
							for(var i in resJSON.data.list){
								var listValue = resJSON.data.list[i];
								
								if("9" == listValue.startTime){
									value09 = listValue.cntFlag;
								}else if("10" == listValue.startTime){
									value10 = listValue.cntFlag;
								}else if("11" == listValue.startTime){
									value11 = listValue.cntFlag;
								}else if("12" == listValue.startTime){
									value12 = listValue.cntFlag;
								}else if("13" == listValue.startTime){
									value13 = listValue.cntFlag;
								}else if("14" == listValue.startTime){
									value14 = listValue.cntFlag;
								}else if("15" == listValue.startTime){
									value15 = listValue.cntFlag;
								}else if("16" == listValue.startTime){
									value16 = listValue.cntFlag;
								}else{
									
								}
							}
							
							var html = "";
							html += "<tr>";
							html += "<td>09:00 ~ 10:00</td>";
							if(value09 == "true"){
								html += "<td><input type='hidden' class='flag' value='true'><span class='blue'>방문가능</span></td>";
							}else if(value09 == "" || value09 == "false"){
								html += "<td><input type='hidden' class='flag' value='false'><span>방문불가</span></td>";
							}
							html += "</tr>";
							html += "<tr>";
							html += "<td>10:00 ~ 11:00</td>";
							if(value10 == "true"){
								html += "<td><input type='hidden' class='flag' value='true'><span class='blue'>방문가능</span></td>";
							}else if(value10 == "" || value10 == "false"){
								html += "<td><input type='hidden' class='flag' value='false'><span>방문불가</span></td>";
							}
							html += "</tr>";
							html += "<tr>";
							html += "<td>11:00 ~ 12:00</td>";
							if(value11 == "true"){
								html += "<td><input type='hidden' class='flag' value='true'><span class='blue'>방문가능</span></td>";
							}else if(value11 == "" || value11 == "false"){
								html += "<td><input type='hidden' class='flag' value='false'><span>방문불가</span></td>";
							}
							html += "</tr>";
							html += "<tr>";
							html += "<td>12:00 ~ 13:00</td>";
							if(value12 == "true"){
								html += "<td><input type='hidden' class='flag' value='true'><span class='blue'>방문가능</span></td>";
							}else if(value12 == "" || value12 == "false"){
								html += "<td><input type='hidden' class='flag' value='false'><span>방문불가</span></td>";
							}
							html += "</tr>";
							html += "<tr>";
							html += "<td>13:00 ~ 14:00</td>";
							if(value13 == "true"){
								html += "<td><input type='hidden' class='flag' value='true'><span class='blue'>방문가능</span></td>";
							}else if(value13 == "" || value13 == "false"){
								html += "<td><input type='hidden' class='flag' value='false'><span>방문불가</span></td>";
							}
							html += "</tr>";
							html += "<tr>";
							html += "<td>14:00 ~ 15:00</td>";
							if(value14 == "true"){
								html += "<td><input type='hidden' class='flag' value='true'><span class='blue'>방문가능</span></td>";
							}else if(value14 == "" || value14 == "false"){
								html += "<td><input type='hidden' class='flag' value='false'><span>방문불가</span></td>";
							}
							html += "</tr>";
							html += "<tr>";
							html += "<td>15:00 ~ 16:00</td>";
							if(value15 == "true"){
								html += "<td><input type='hidden' class='flag' value='true'><span class='blue'>방문가능</span></td>";
							}else if(value15 == "" || value15 == "false"){
								html += "<td><input type='hidden' class='flag' value='false'><span>방문불가</span></td>";
							}
							html += "</tr>";
							html += "<tr>";
							html += "<td>16:00 ~ 17:00</td>";
							if(value16 == "true"){
								html += "<td><input type='hidden' class='flag' value='true'><span class='blue'>방문가능</span></td>";
							}else if(value16 == "" || value16 == "false"){
								html += "<td><input type='hidden' class='flag' value='false'><span>방문불가</span></td>";
							}
							html += "</tr>";
							
							$('#time_tbody').html(html);
							interviewSuit.fn.timeClick();
							
						}else if(resJSON.data.resultCode == "0001"){
							$.alert(resJSON.data.msg);
						}
						
					}
				};
				common.http.ajax(opts);
				
			});
		},
		
		setYm : function(){
			if(interviewSuit.month == 10 || interviewSuit.month == 11 || interviewSuit.month == 12){
				interviewSuit.ym = String(interviewSuit.year) + String(interviewSuit.month);
			}else{
				interviewSuit.ym = String(interviewSuit.year) + "0" + String(interviewSuit.month);
			}
		},
		
		// 클릭 불가 처리
		setCalendarDisable : function(){
			if(Number(interviewSuit.today_year) > Number(interviewSuit.year)){
				$('#calendar_tbody').children('tr').children('td').removeClass('able');
			}else if(Number(interviewSuit.today_year) == Number(interviewSuit.year)){
				if(Number(interviewSuit.today_month) > Number(interviewSuit.month)){
					$('#calendar_tbody').children('tr').children('td').removeClass('able');
				}else if(Number(interviewSuit.today_month) == Number(interviewSuit.month)){
					$('#calendar_tbody').children('tr').children('td').each(function(){
						if($(this).find('.clickDate').html() == "" || Number(interviewSuit.today) > Number($(this).find('.clickDate').html())){
							$(this).removeClass('able');
						}
					});
				}else{
					$('#calendar_tbody').children('tr').children('td').each(function(){
						if($(this).find('.clickDate').html() == ""){
							$(this).removeClass('able');
						}
					});
				}
			}else{
				$('#calendar_tbody').children('tr').children('td').each(function(){
					if($(this).find('.clickDate').html() == ""){
						$(this).removeClass('able');
					}
				});
			}
		},
		
		getInterviewSuitBsnsList : function(){
			var param = {
				"bsnsSeq" : $('#bsnsSeq').val()
			};
			var	opts = {
				url		: contextPath + "/bsnsRecpt/getInterviewSuitBsnsList.do",
				data	: param,
				type	: "post",
				sendDataType	: "json",
				success	: function(resJSON, resCode) {
					
					var html = "";
					
					for(var i in resJSON.data.list){
						//html += "<option value='" + resJSON.data.list[i].bsnsSeq + "'><input type='hidden' class='corpId' value='" + resJSON.data.list[i].adminSeq + "'>" + resJSON.data.list[i].bsnsTitle + "</option>";
						html += "<option value='" + resJSON.data.list[i].adminSeq + "'>" + resJSON.data.list[i].bsnsTitle + "</option>";
					}
					
					$('#bsnsList').append(html);
					
				}
			};
			common.http.ajax(opts);
		},
		
		/*setInterviewSuitBsnsChange : function(){
			$('#bsnsList').on('change', function(){
				var param = {
						
				};
				var	opts = {
					url		: "/bsnsRecpt/getInterviewSuitBsnsList.do",
					data	: param,
					type	: "post",
					sendDataType	: "json",
					success	: function(resJSON, resCode) {
						
						
						
					}
				};
				common.http.ajax(opts);
				
			});
		}*/
		
		timeClick : function(){
			$('#time_tbody').unbind();
			$('#time_tbody').on('click', function(e){
				
				var wearAdminSeq = $('#bsnsList').val();
				if(wearAdminSeq == ""){
					$.alert('먼저 사업을 선택해 주세요.');
					return false;
				}
				
				var flag = $(e.target).closest('tr').find('.flag').val();
				
				if(flag == "false"){
					$.alert('해당 시간대에는 모든 방문예약이 완료되어 진행할 수 없습니다.');
					return false;
				}
				
				var timeDate = $(e.target).closest('tr').index();
				var startDate = "";
				var endDate = "";
				
				if(Number(interviewSuit.date) < 10){
					interviewSuit.date = "0" + interviewSuit.date;
				}
				
				if(interviewSuit.month == "10" || interviewSuit.month == "11" || interviewSuit.month == "12"){
					startDate = interviewSuit.year + "-" + interviewSuit.month + "-" + interviewSuit.date;
					endDate = interviewSuit.year + "-" + interviewSuit.month + "-" + interviewSuit.date;
				}else{
					startDate = interviewSuit.year + "-0" + interviewSuit.month + "-" + interviewSuit.date;
					endDate = interviewSuit.year + "-0" + interviewSuit.month + "-" + interviewSuit.date;
				}
				
				if(timeDate == "0"){
					startDate += " 09:00";
					endDate += " 10:00";
				}else if(timeDate == "1"){
					startDate += " 10:00";
					endDate += " 11:00";
				}else if(timeDate == "2"){
					startDate += " 11:00";
					endDate += " 12:00";
				}else if(timeDate == "3"){
					startDate += " 12:00";
					endDate += " 13:00";
				}else if(timeDate == "4"){
					startDate += " 13:00";
					endDate += " 14:00";
				}else if(timeDate == "5"){
					startDate += " 14:00";
					endDate += " 15:00";
				}else if(timeDate == "6"){
					startDate += " 15:00";
					endDate += " 16:00";
				}else if(timeDate == "7"){
					startDate += " 16:00";
					endDate += " 17:00";
				}
				
				var param = {
					"wearStartTime" : startDate,
					"wearEndTime" : endDate,
					"bsnsSeq" : $('#bsnsSeq').val(),
					"wearAdminSeq" : wearAdminSeq,
				};
				
				var	opts = {
					url		: contextPath + "/bsnsRecpt/interviewSuitInsertView.do",
					data	: param,
					type	: "post",
				};
				common.http.sendFormData(opts);
				
			});
		}
		
	}
}