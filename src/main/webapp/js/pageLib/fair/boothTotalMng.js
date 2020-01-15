var	boothTotalMng = {
		name: 'boothTotalMng',
		dataTables: null,
		commCode: {},
		init: function() {
			var that$ = this;

			that$.beforeBind();
			that$.bind();
			that$.afterBind();
		},
		beforeBind: function() {
			var that$ = this;
		},
		bind: function() {
			var that$ = this;
		},
		afterBind: function() {
			var that$ = this;

			$('#btnFairChoose').on('click', function(e) {
				popFairLayerBtn();
			});
			
			$('#tabBoothRegMng').on('click', function(e) {
				if($('#fairSeq').val() == '') {
					alertify.alert( t( 'errors.required', [t('field.dic.job.fair')] ) , function (e) {
						if(e) {
							return false;
						}
					});
				} else {
					that$.fn.tabBoothMng( 'boothRegMng' );
				}
			});
			$('#tabBoothReqMng').on('click', function(e) {
				if($('#fairSeq').val() == '') {
					alertify.alert( t( 'errors.required', [t('field.dic.job.fair')] ) , function (e) {
						if(e) {
							return false;
						}
					});
				} else {
					that$.fn.tabBoothMng( 'boothReqMng' );
				}
			});
			$('#tabBoothResvMng').on('click', function(e) {
				if($('#fairSeq').val() == '') {
					alertify.alert( t( 'errors.required', [t('field.dic.job.fair')] ) , function (e) {
						if(e) {
							return false;
						}
					});
				} else {
					that$.fn.tabBoothMng( 'boothResvMng' );
				}
			});
			
			$('#fairSeq').on('change', function(e) {
				if ($('#fairSeq').val() != '') {
					if($('#tabBoothRegMng').parent('li').hasClass('on')) {
						$('#tabBoothRegMng').trigger('click');
					}
					if($('#tabBoothReqMng').parent('li').hasClass('on')) {
						$('#tabBoothReqMng').trigger('click');
					}
					if($('#tabBoothResvMng').parent('li').hasClass('on')) {
						$('#tabBoothResvMng').trigger('click');
					}
				}
			});
		},
		fn: {
			tabBoothMng: function( urlPath ) {
				$( "#totalBoothMngDiv").empty();
				var action = contextPath + "/internal/fair/" + urlPath + ".do"
		        $.ajax({
		            type: "POST",
		            url: action,
		            cache: true,
		            success: function(response) {
		            	$( "#totalBoothMngDiv").html( response );
		            }
		        });				
			}
		}
}
