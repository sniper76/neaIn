var	iscoMngDetail = {
		name: 'iscoMngDetail',
		init: function() {
			var that$ = this;
			$.when( that$.beforeBind() ).done(function( res ) {
				that$.bind();
				that$.afterBind();
			});
		},

		beforeBind: function() {
			var that$ = this;

		},
		bind: function() {
			var that$ = this;


		},

		afterBind: function() {
			var that$ = this;

			$('#uploadImgFile').on('change', function(e){
				var files = e.target.files;
				var fileList = Array.prototype.slice.call(files);

				fileList.forEach(function(f){
					if(!f.type.match("image.*")){
						alertify.alert("<spring:message code='error.insertFile.onlyImgFile'/>");
						return false;
					}

					var reader = new FileReader();
					reader.onload = function(event){
						$('#uploadImg').attr("src", event.target.result);
					}
					reader.readAsDataURL(f);

				});

				$('#uploadImg').show();
			});

			$('#btnList').on('click', function(){
				location.href = contextPath + '/internal/iscoMng/list.do';
			});

			$('#btnSave').on('click', function(){
				var form = $('#frm')[0];
				var formData = new FormData(form);
				if($('#uploadImgFile').val() != ""){
					formData.append("uploadImgFile", $('#uploadImgFile')[0].files[0]);
				}

				$.ajax({
			        type : 'post',
			        url :  contextPath + "/internal/iscoMng/updateIscoMngAjax.do",
			        dataType : 'json',
			        data : formData,
			        contentType: false,
					processData: false,
			        success : function(data) {

			        	if(data.result > 0){
			        		alertify.alert("직종 정보 수정이 완료되었습니다.", function(){
			        			location.href = contextPath + '/internal/iscoMng/list.do';
			        		});
			        	}else{
			        		alertify.alert("<spring:message code='resume.write.insert.error'/>");
			        	}

			        },
			        error : function(request, status, error) {
			        	alertify.alert("<spring:message code='resume.write.insert.error'/>");
			        }
			    })
			});

		},

		fn: {

		}
}
