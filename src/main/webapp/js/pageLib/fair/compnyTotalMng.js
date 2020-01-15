var	compnyTotalMng = {
		name: 'compnyTotalMng',
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
			
			$('#tabCompnyJoinMng').on('click', function(e) {
				if($('#fairSeq').val() == '') {
					alertify.alert( t( 'errors.required', [t('field.dic.job.fair')] ), function (e) {
						if(e) {
							return false;
						}
					});
				} else {
					that$.fn.tabCompnyMng( 'compnyJoinMng' );
				}				
			});
			$('#tabCompnyReqestMng').on('click', function(e) {
				if($('#fairSeq').val() == '') {
					alertify.alert( t( 'errors.required', [t('field.dic.job.fair')] ), function (e) {
						if(e) {
							return false;
						}
					});
				} else {
					that$.fn.tabCompnyMng( 'compnyReqestMng' );
				}					
			});
			$('#tabCompnyInviteMng').on('click', function(e) {
				if($('#fairSeq').val() == '') {
					alertify.alert( t( 'errors.required', [t('field.dic.job.fair')] ), function (e) {
						if(e) {
							return false;
						}
					});
				} else {
					that$.fn.tabCompnyMng( 'compnyInviteMng' );
				}					
			});
			
			$('#fairSeq').on('change', function(e) {
				if ($('#fairSeq').val() != '') {
					if($('#tabCompnyJoinMng').parent('li').hasClass('on')) {
						$('#tabCompnyJoinMng').trigger('click');
					}
					if($('#tabCompnyReqestMng').parent('li').hasClass('on')) {
						$('#tabCompnyReqestMng').trigger('click');
					}
					if($('#tabCompnyInviteMng').parent('li').hasClass('on')) {
						$('#tabCompnyInviteMng').trigger('click');
					}
				}
			});			
		},
		fn: {
			tabCompnyMng: function( urlPath ) {
				$( "#totalCompnyMngDiv").empty();
				var action = contextPath + "/internal/fair/" + urlPath + ".do"
		        $.ajax({
		            type: "POST",
		            url: action,
		            cache: true,
		            success: function(response) {
		            	$( "#totalCompnyMngDiv").html( response );
		            }
		        });				
			}
		}
}
