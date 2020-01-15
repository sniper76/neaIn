var uploadHoler = "dext5uploadArea";
var uploadId = "commonUpload";
var	courseDtl = {
		name: 'courseDtl',

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
			dext5uploadEvnt();
		},

		afterBind: function() {
			var that$ = this;
            // Handle form submission event
            $('#btnSubmit').on('click', function(e) {
            	that$.fn.pageAction();
            });
		},

		fn: {
			pageAction : function() {
				$("#frmCourseDtl").attr("method", "post");
				$("#frmCourseDtl").attr("action", contextPath + "/internal/counsel/courseAnsReg.do");
				$("#frmCourseDtl").submit();
			},
		}
}

/*********************************************************************************
 * DEXT5 UPLOAD FUNCTION
 * uploadHolder : call Position
 * new Dext5Upload : call upload module
 **********************************************************************************/
function dext5uploadEvnt(){
	DEXT5UPLOAD.config.UploadHolder = uploadHoler;
	DEXT5UPLOAD.config.Mode = 'view'; // edit, view
	new Dext5Upload(uploadId);

	var ansFileGrpSeq = $('#ansFileGrpSeq').val();

	if(ansFileGrpSeq != ""){
		$.ajax({
			type: 'post',
			url: contextPath + "/common/selectDext5upload.do",
			dataType: 'json',
			data: {
				"fileGrpSeq" : ansFileGrpSeq
			},
			success: function(data) {

				if(data.result.length > 0){
					for(var i in data.result){
						var obj = data.result[i];
						DEXT5UPLOAD.AddUploadedFile(obj.fileSeq, obj.originalNm, obj.saveFilePath, obj.fileSize, "", uploadId);
					}
				}

			},
			error: function(xhr, status, error) {
				alertify.alert("시스템 에러.");
			}
		});
	}
}
