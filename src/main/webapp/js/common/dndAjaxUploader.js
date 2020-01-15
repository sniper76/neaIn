var dndAjaxUploader = function(bizName, programId) {
	var that$ = this;
	this.bizName = bizName;
	this.programId = programId;
	this.getBizeName = function() {
		return that$.bizName;
	};
	this.selectSaveFileList = function( fileGrpSeq ) {
		var deferred = $.Deferred();		
		var params = {
			fileGrpSeq: fileGrpSeq 
		};

		var options = {
			method : 'post',
			url : contextPath + '/fileCommon/selectAttachFileListAjax.do',
			data: params,
			dataType : 'json',
		};

		$.ajax(options).done(function(result, status, responseObj) {
			deferred.resolve(result.FileBean);
		});
		
		return deferred.promise();		    
	};
	this.insertFileDbToServer = function( arrJson ) {
		var deferred = $.Deferred();		
		var params = {
			bizNameList: arrJson.map(function(x) {return x.bizName}),
			saveNmList: arrJson.map(function(x) {return x.saveNm}),
			originalNmList: arrJson.map(function(x) {return x.originalNm}),
			saveFilePathList: arrJson.map(function(x) {return x.saveFilePath}),
			fileExtensionList: arrJson.map(function(x) {return x.fileExtension}),
			fileSizeList: arrJson.map(function(x) {return x.fileSize}),
			fileSeqList: arrJson.map(function(x) {return x.fileSeq}),
			fileGrpSeqList: arrJson.map(function(x) {return x.fileGrpSeq}),
			contentTypeList: arrJson.map(function(x) {return x.contentType})
		};

		var options = {
			method : 'post',
			url : contextPath + '/fileCommon/insertAttachFileAjax.do',
			data: params,
			traditional: true,
			dataType : 'json',
		};

		$.ajax(options).done(function(result, status, responseObj) {
			deferred.resolve('File Data insert success !!');
		});			
		
		return deferred.promise();		    
	};	
	this.deleteFileToServer = function( arrJson ) {
		var deferred = $.Deferred();		
		
		var rowCount = 0;
		arrJson.forEach(function(item) {
			
			var params = {
				bizName: item.bizName,	
				saveNm: item.saveNm,	
			}
			
			var options = {
				method : 'post',
				url : contextPath + '/fileCommon/deleteAttachFileAjax.do',
				data: params,
				dataType : 'json',
			};

			$.ajax(options).done(function(result, status, responseObj) {
				rowCount++;
				console.log(rowCount, arrJson.length);
				if (rowCount == arrJson.length) {
					deferred.resolve('File delete success !!');
				}
			});			
		});
		
		return deferred.promise();		    
	};
	this.deleteAllFileToServer = function( fileGrpSeq ) {
		var deferred = $.Deferred();		
		
		var params = {
			fileGrpSeq: fileGrpSeq,	
		}
		
		var options = {
			method : 'post',
			url : contextPath + '/fileCommon/deleteAllAttachFileAjax.do',
			data: params,
			dataType : 'json',
		};

		$.ajax(options).done(function(result, status, responseObj) {
			deferred.resolve('All file delete success !!');
		});			
		
		return deferred.promise();		    
	};	
	this.sendFileToServer = function(formData, status) {
		var deferred = $.Deferred();
		formData.append('bizName', this.bizName);
		if (typeof this.programId !== 'undefined') {
			formData.append('programId', this.programId);
		}
		
		var uploadURL = contextPath + "/fileCommon/uploadHelper.do"; //Upload URL
		var extraData = {}; //Extra Data.
		var jqXHR = $.ajax({
			xhr : function() {
				var xhrobj = $.ajaxSettings.xhr();
				if (xhrobj.upload) {
					xhrobj.upload.addEventListener('progress', function(event) {
						var percent = 0;
						var position = event.loaded || event.position;
						var total = event.total;
						if (event.lengthComputable) {
							percent = Math.ceil(position / total * 100);
						}
						//Set progress
						status.setProgress(percent);
					}, false);
				}
				return xhrobj;
			},
			url : uploadURL,
			type : "POST",
			contentType : false,
			processData : false,
			cache : false,
			data : formData,
			success : function(data) {
				if ( !$.isArray(data) ) {
					if ( data.responseCode == 601 ) {
						$( status.statusbar ).remove();
					}
					deferred.reject( data.responseText );
				} else {
					status.setProgress(100);
					var fileSeq = (data[0].saveNm).split('.')[0];
					var originalNm = data[0].originalNm;
					var fileSize = data[0].fileSize;
					status.setFileNameSize(originalNm, fileSize, fileSeq);
					deferred.resolve(data[0]);
				}
			}
		});

		status.setAbort(jqXHR);

		return deferred.promise();
	};
	this.createStatusbar = function(obj) {
		this.statusbar = $("<div class='statusbar'></div>");
		this.filename = $("<div class='filename'></div>").appendTo(this.statusbar);
		this.size = $("<div class='filesize'></div>").appendTo(this.statusbar);
		this.progressBar = $("<div class='progressBar'><div></div></div>").appendTo(this.statusbar);
		this.abort = $("<div class='abort'>Abort</div>").appendTo(this.statusbar);
		this.button = $("<div class='button'></div>").appendTo(this.statusbar);
		obj.append(this.statusbar);

		this.setFileNameSize = function(name, size, fileSeq) {
			var sizeStr = "";
			var sizeKB = size / 1024;
			if (parseInt(sizeKB) > 1024) {
				var sizeMB = sizeKB / 1024;
				sizeStr = sizeMB.toFixed(2) + " MB";
			} else {
				sizeStr = sizeKB.toFixed(2) + " KB";
			}
			if (this.statusbar.hasClass('has')) {
				name = '<a href="' + contextPath + '/fileCommon/fileDownload.do?fileSeq='+ fileSeq +'">' + name + '</a>';
			}
			this.filename.html(name);
			this.size.html(sizeStr);
			this.button.html('<input type="button" id="'+ fileSeq +'" class="bbs_btn delete btnFileDelete"  value="Delete" />');
		}
		this.setProgress = function(progress) {
			var progressBarWidth = progress * this.progressBar.width() / 100;
			this.progressBar.find('div').animate({
				width : progressBarWidth
			}, 10).html(progress + "% ");
			if (parseInt(progress) >= 100) {
				this.abort.hide();
			}
		}
		this.setAbort = function(jqxhr) {
			var sb = this.statusbar;
			this.abort.click(function() {
				jqxhr.abort();
				sb.hide();
			});
		}
		this.setHasClass = function() {
			this.statusbar.addClass('has');
		}
		this.removeAll = function() {
			obj.find('div.statusbar').not('.has').remove();
		}
		this.removeItem = function(fileSeq) {
			$('div.statusbar').find('input.btnFileDelete').each(function(i, v){
				if ( $(this).attr('id') == fileSeq ) {
					$(this).parent('div').parent('div.statusbar').remove();
				}
			});
		}
	};
	this.handleFileUpload = function(files, obj) {
		var deferred = $.Deferred();
		var results = [];
		for (var i = 0; i < files.length; i++) {
			var fd = new FormData();
			fd.append('file', files[i]);
			that$.status = new that$.createStatusbar(obj); //Using this we can set progress.
			$.when(that$.sendFileToServer(fd, that$.status)).done(function(result) {
				results.push(result);
				if (results.length == files.length) {
					deferred.resolve(results);
				}
			}).fail(function(result) {
				//that$.status.removeAll();
				deferred.reject(result);
			});
		}

		return deferred.promise();
	};
};