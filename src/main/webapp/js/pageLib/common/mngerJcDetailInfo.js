
	var	mngerJcDetailInfo = {
			name: 'mngerJcDetailInfo',
	
			init: function() {
				
				this.beforeBind();
				this.bind();
				this.afterBind();
							
			},
			
			beforeBind: function() {
			},

			bind: function() {
				mngerJcDetailInfo.fn.getList();
			},
			afterBind: function() {
				$("#btnReg").click(function(){
					LoadingWithMask();
					
					//배열 선언
			        var m1Array = [];
			        var m2Array = [];
			        var m3Array = [];
			        var m4Array = [];
			        var proArray = [];
			        
			        $('input[name="menu1DepthCdList"]:checked').each(function(i){//체크된 리스트 저장
			        	m1Array.push($(this).val());
			        });
			        
			        $('input[name="menu2DepthCdList"]:checked').each(function(i){//체크된 리스트 저장
			        	m2Array.push($(this).val());
			        });
			        
			        $('input[name="menu3DepthCdList"]:checked').each(function(i){//체크된 리스트 저장
			        	m3Array.push($(this).val());
			        });
			        
			        $('input[name="menu4DepthCdList"]:checked').each(function(i){//체크된 리스트 저장
			        	m4Array.push($(this).val());
			        });
			        $('input[name="proList"]:checked').each(function(i){//체크된 리스트 저장
			        	proArray.push($(this).val());
			        });
			        
			        if(m1Array.length ==0) {m1Array.push('0');}
			        if(m2Array.length ==0) {m2Array.push('0');}
			        if(m3Array.length ==0) {m3Array.push('0');}
			        if(m4Array.length ==0) {m4Array.push('0');}
			        if(proArray.length ==0) {proArray.push('0');}
			        
			        var objParams = {
			                "userSeq"      : $("#userSeq").val(), //유저 저장
			                "m1List" : m1Array,       //배열 저장
			                "m2List" : m2Array,       //배열 저장
			                "m3List" : m3Array,       //배열 저장
			                "m4List" : m4Array,       //배열 저장
			                "proList": proArray       //배열 저장
			            };
			        
			        //ajax 호출
			        $.ajax({
			            url         :   "/internal/common/updateMngerMenuAuthRegAjax.do",
			            dataType    :   "json",
			            contentType :   "application/x-www-form-urlencoded; charset=UTF-8",
			            type        :   "post",
			            data        :   objParams,
			            success     :   function(retVal){

			                if(retVal.result.resultCode == "0000") {
			                    alertify.alert(retVal.result.msg);
			                } else {
			                	alertify.alert(retVal.message + "2");
			                }
			                HideLoadingWithMask();
			            },
			            error       :   function(request, status, error){
//			                console.log("AJAX_ERROR");
			            	HideLoadingWithMask();
			            }
			        });
				});
			},
			fn: {
				
				getList : function() {
					LoadingWithMask();
					
					var param = {
							"userSeq"      : $("#userSeq").val()
						};
					
					$.ajax({
					    type : 'post', // 타입
					    url :  contextPath + "/internal/common/mngerMenuAuthListAjax.do", // URL
					    dataType : 'html', // 데이터 타입
					    data : param,
					    success : function(result) { // 결과 성공
					        mngerJcDetailInfo.fn.drawList(result);
					        
					    },
					    error : function(request, status, error) { // 결과 에러
					    	HideLoadingWithMask();
					    }
					})
				},
				drawList : function(data) {
					$("#authList").append(data);
					//$('#authList').rowspanDisplay(0);
			    	//$('#authList').rowspanDisplay(1);
			    	//$('#authList').rowspanDisplay(2);
			    	//$('#authList').rowspanDisplay(3);
			    	//$('#authList').rowspanDisplay(4);
			    	HideLoadingWithMask();
				}
			}
	}