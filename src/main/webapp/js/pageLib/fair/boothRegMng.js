var	boothRegMng = {
		name: 'boothRegMng',
		boothList: [],
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

			var params = { data: { fairSeq: $('#fairSeq').val() } };
			$.when( that$.fn.getBoothRegList(params) ).done(function( result ) {
				$('#boothTel').val(result.boothTel);
				$('#boothEmail').val(result.boothEmail);
				$('#boothFeeExpln').val(result.boothFeeExpln);
				that$.boothList = result.list;
				that$.fn.initBooth();
	            deferred.resolve();
			}).fail(function(result) {
				that$.fn.initBooth();
	            deferred.resolve();
			});

            return deferred.promise();			
		},
		bind: function() {
			var that$ = this;
		},
		afterBind: function() {
			var that$ = this;
			$('#btnAddBooth').on('click', function() {
				if ($('#fairSeq').val() != null && $('#fairSeq').val() != '') {
					that$.fn.addBooth();
				} else {
					alertify.alert( t( 'errors.required', [t('field.dic.job.fair')] ) , function (e) {
						if(e) {
							return false;
						}
					});
				}				
			});
			
			$('#btnReset').on('click', function() {
				if ($('#fairSeq').val() != null && $('#fairSeq').val() != '') {
					that$.fn.initBooth();
				} else {
					alertify.alert( t( 'errors.required', [t('field.dic.job.fair')] ) , function (e) {
						if(e) {
							return false;
						}
					});
				}
			});
			
			$('#btnSubmit').on('click', function(e) {
				if ($('#fairSeq').val() == null || $.trim($('#fairSeq').val()) == '') {
					e.preventDefault();
					alertify.alert( t( 'errors.required', [t('field.dic.job.fair')] ), function (ex) {
						if(ex) {
							return false;
						}
					});
				}
				
				var boothSeqList = $('#boothLoop').find('input[name=boothSeq]').map(function(x) {return $(this).val() }).toArray();
				var boothNmList = $('#boothLoop').find('input[name=boothNm]').map(function(x) {return $(this).val() }).toArray();
				var boothFeeList = $('#boothLoop').find('input[name=boothFee]').map(function(x) {return $(this).val() }).toArray();
				var useYnList = $('#boothLoop').find('input:radio:checked').map(function(x) {return $(this).val() }).toArray();
				
				var i = boothNmList.length;
				while (i--) {
					if ($.trim(boothNmList[i]) == "" && $.trim(boothFeeList[i]) == "" && $.trim(boothSeqList[i]) == "") {
						boothSeqList.splice(i, 1);
						boothNmList.splice(i, 1);
						boothFeeList.splice(i, 1);
						useYnList.splice(i, 1);
					}
				}
				if (!boothNmList.length) {
					e.preventDefault();
					alertify.alert( t('errors.minimum.one') , function (ex) {
						if(ex) {
							return false;
						}
					});
				}
			});
			
			$('#frmBoothRegMng').submit(function(e) {
			    var form$ = $(this);
				form$.find("#btnAddBooth").attr('disabled', true);
				form$.find("#btnReset").attr('disabled', true);
				form$.find("#btnSubmit").attr('disabled', true);
				e.preventDefault();
				
				alertify.confirm( t( 'cpes.save.btn.confirm.msg' ), function (ex) {
					if(ex) {
						
						var boothSeqList = $('#boothLoop').find('input[name=boothSeq]').map(function(x) {return $(this).val() }).toArray();
						var boothNmList = $('#boothLoop').find('input[name=boothNm]').map(function(x) {return $(this).val() }).toArray();
						var boothFeeList = $('#boothLoop').find('input[name=boothFee]').map(function(x) {return $(this).val() }).toArray();
						var useYnList = $('#boothLoop').find('input:radio:checked').map(function(x) {return $(this).val() }).toArray();

						var i = boothNmList.length;
						while (i--) {
							if ($.trim(boothNmList[i]) == "" && $.trim(boothFeeList[i]) == "" && $.trim(boothSeqList[i]) == "") {
								boothSeqList.splice(i, 1);
								boothNmList.splice(i, 1);
								boothFeeList.splice(i, 1);
								useYnList.splice(i, 1);
							}
						}
						
						var params = {
								data: {
									fairSeq: $('#fairSeq').val(),
									boothTel: $('#boothTel').val(),
									boothEmail : $('#boothEmail').val(),
									boothFeeExpln : $('#boothFeeExpln').val(),
									boothSeqList: boothSeqList,
									boothNmList: boothNmList,
									boothFeeList: boothFeeList,
									useYnList: useYnList
								}
							};
						
						$.when( that$.fn.mergeAction( params ) ).done(function( result ) {
							alertify.alert( t( 'cpes.reg.success.msg' ), function (e) { if (e) {
								form$.find("#btnAddBooth").attr('disabled', false);
								form$.find("#btnReset").attr('disabled', false);
								form$.find("#btnSubmit").attr('disabled', false);

								var params = { data: { fairSeq: $('#fairSeq').val() } };
								$.when( that$.fn.getBoothRegList(params) ).done(function( result ) {
									$('#boothTel').val(result.boothTel);
									$('#boothEmail').val(result.boothEmail);
									$('#boothFeeExpln').val(result.boothFeeExpln);
									that$.boothList = result.list;
									that$.fn.initBooth();
								});
							} });
						}).fail(function ( result ) {
							form$.find("#btnAddBooth").attr('disabled', false);
							form$.find("#btnReset").attr('disabled', false);
							form$.find("#btnSubmit").attr('disabled', false);

							alertify.alert(result, function (e) { if (e) {} });
						});
					} else {
						form$.find("#btnAddBooth").attr('disabled', false);
						form$.find("#btnReset").attr('disabled', false);
						form$.find("#btnSubmit").attr('disabled', false);
						
						return false;
					}
				});
			});
		},
		fn: {
			initBooth: function() {
				$('#boothLoop').empty();
				if ( boothRegMng.boothList.length > 0 ) {
					var total = ( boothRegMng.boothList.length <= 100 ) ? 100 : Math.ceil( boothRegMng.boothList.length / 50 ) * 50;
					for (var i = 0; i < total; i++) {
						if(i%2 == 0) {
							$('#boothLoop').append("<tr></tr>");
						}
						
						var boothSeq = "";
						var boothNm = "";
						var boothFee = "";
						var useYn = "Y";
						
						if (boothRegMng.boothList.length - 1 >= i) {
							boothSeq = boothRegMng.boothList[i].boothSeq;
							boothNm = boothRegMng.boothList[i].boothNm;
							boothFee = boothRegMng.boothList[i].boothFee;
							useYn = boothRegMng.boothList[i].useYn;
						}
						
						var	Td = '<td scope="col"><input type="hidden" id="boothSeq'+i+'" name="boothSeq" value="' + boothSeq + '" /><input type="text" id="boothNm'+i+'" name="boothNm" value="' + boothNm + '" /></td>';
						Td += '<td scope="col"><input type="text" id="boothFee'+i+'" name="boothFee" value="' + boothFee + '" onKeyUp="onlyNumberCommon(this);" /></td>';
						Td += '<td scope="col"><input type="radio" id="useYnY'+i+'" name="useYn'+i+'" value="Y" ' + (useYn == "Y" ? "checked" : "" ) + ' />Yes <input type="radio" id="useYnN'+i+'" name="useYn'+i+'" value="N" ' + (useYn == "N" ? "checked" : "" ) + ' />No</td>';				
						$('#boothLoop').find('tr:last').append(Td);
					}
				} else {
					for (var i = 0; i < 100; i++) {
						if(i%2 == 0) {
							$('#boothLoop').append("<tr></tr>");
						}
						var	Td = '<td scope="col"><input type="hidden" id="boothSeq'+i+'" name="boothSeq" value="" /><input type="text" id="boothNm'+i+'" name="boothNm" value="" /></td>';
						Td += '<td scope="col"><input type="text" id="boothFee'+i+'" name="boothFee" value="" onKeyUp="onlyNumberCommon(this);" /></td>';
						Td += '<td scope="col"><input type="radio" id="useYnY'+i+'" name="useYn'+i+'" value="Y" checked />Yes <input type="radio" id="useYnN'+i+'" name="useYn'+i+'" value="N" />No</td>';				
						$('#boothLoop').find('tr:last').append(Td);
					}
				}
				$('#boothUseCnt').text( $('#boothLoop').find('input:radio[value="Y"]:checked').length );
				$('#boothTotalCnt').text( $('#boothLoop').find('tr').length * 2 );
			},
			addBooth: function() {
				var len = 50;
				var start = $('#boothLoop').find('tr').length * 2;
				var total = start + len;

				for (var i = start; i < total; i++) {
					if(i%2 == 0) {
						$('#boothLoop').append("<tr></tr>");
					}
					var	Td = '<td scope="col"><input type="hidden" id="boothSeq'+i+'" name="boothSeq" value="" /><input type="text" id="boothNm'+i+'" name="boothNm" value="" /></td>';
					Td += '<td scope="col"><input type="text" id="boothFee'+i+'" name="boothFee" value="" onKeyUp="onlyNumberCommon(this);" /></td>';
					Td += '<td scope="col"><input type="radio" id="useYnY'+i+'" name="useYn'+i+'" value="Y" checked />Yes <input type="radio" id="useYnN'+i+'" name="useYn'+i+'" value="N" />No</td>';				
					$('#boothLoop').find('tr:last').append(Td);
				}
				$('#boothUseCnt').text( $('#boothLoop').find('input:radio[value="Y"]:checked').length );
				$('#boothTotalCnt').text( $('#boothLoop').find('tr').length * 2 );
			},
			getBoothRegList: function(params) {
				var deferred = $.Deferred();
				var options = {
					    method: 'post',
					    url: contextPath + '/internal/fair/selectBoothRegListAjax.do',
					    data: params.data,
					    dataType: 'json',
					};
					    
				$.ajax(options)
				.done(function (res, status, responseObj) {
			        deferred.resolve(res.result);
				}).fail(function (result, status, responseObj) {
					deferred.reject("system error: " + status);			
				});
				return deferred.promise();
			},
			mergeAction : function(params) {
				var deferred = $.Deferred();
				var options = {
					    method: 'post',
					    url: contextPath + '/internal/fair/mergeBoothRegMngAjax.do',
				    	traditional: true,
					    data: params.data,
					    dataType: 'json',
					};
					    
				$.ajax(options)
				.done(function (res, status, responseObj) {
					if ( res.result.fairSeq ) {
				        deferred.resolve(res.result);
					} else {
						deferred.reject( t( 'cpes.error.msg' ) );
						//deferred.reject("user auth cert fail");				
					}
				}).fail(function (result, status, responseObj) {
					deferred.reject( t( 'cpes.error.msg' ) );
					//deferred.reject("system error: " + status);			
				});				
				return deferred.promise();
			}
		}
}
