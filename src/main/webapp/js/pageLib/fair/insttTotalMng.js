var	insttTotalMng = {
		name: 'insttTotalMng',
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
			
			$('#tabInsttJoinMng').on('click', function(e) {
				if($('#fairSeq').val() == '') {
					alertify.alert( t( 'errors.required', [t('field.dic.job.fair')] ), function (e) {
						if(e) {
							return false;
						}
					});
				} else {
					that$.fn.tabInsttMng( 'insttJoinMng' );
				}
			});
			$('#tabInsttReqestMng').on('click', function(e) {
				if($('#fairSeq').val() == '') {
					alertify.alert( t( 'errors.required', [t('field.dic.job.fair')] ), function (e) {
						if(e) {
							return false;
						}
					});
				} else {
					that$.fn.tabInsttMng( 'insttReqestMng' );
				}				
			});
			$('#tabInsttInviteMng').on('click', function(e) {
				if($('#fairSeq').val() == '') {
					alertify.alert( t( 'errors.required', [t('field.dic.job.fair')] ), function (e) {
						if(e) {
							return false;
						}
					});
				} else {
					that$.fn.tabInsttMng( 'insttInviteMng' );
				}				
			});
			
			$('#fairSeq').on('change', function(e) {
				if ($('#fairSeq').val() != '') {
					if($('#tabInsttJoinMng').parent('li').hasClass('on')) {
						$('#tabInsttJoinMng').trigger('click');
					}
					if($('#tabInsttReqestMng').parent('li').hasClass('on')) {
						$('#tabInsttReqestMng').trigger('click');
					}
					if($('#tabInsttInviteMng').parent('li').hasClass('on')) {
						$('#tabInsttInviteMng').trigger('click');
					}
				}
			});			
		},
		fn: {
			tabInsttMng: function( urlPath ) {
				$( "#totalInsttMngDiv").empty();
				var action = contextPath + "/internal/fair/" + urlPath + ".do"
		        $.ajax({
		            type: "POST",
		            url: action,
		            cache: true,
		            success: function(response) {
		            	$( "#totalInsttMngDiv").html( response );
		            }
		        });				
			}
		}
}
