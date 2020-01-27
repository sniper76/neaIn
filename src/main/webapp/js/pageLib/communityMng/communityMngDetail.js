var	communityMngDetail = {
    name: 'communityMngDetail',
    dataTables: null,

    init: function() {
        this.beforeBind();
        this.bind();
        this.afterBind();

    },

    beforeBind: function() {
        var that$ = this;
        common.sys.getDatepicker();

    },


    bind: function() {
        var that$ = this;
    },

    afterBind: function() {
        var that$ = this;

        $('#btnList').on('click', function(){
        	location.href = contextPath + "/internal/community/list.do";
        });

        $('#btnAgree').on('click', function(){
        	$.ajax({
				type: 'post',
				url: contextPath + "/internal/community/updateCommunityMngAgreeAjax.do",
				dataType: 'json',
				data: {
					"seq" : $('#seq').val(),
					"contentsFlag" : $('#contentsFlag').val()
				},
				success: function(data) {

					if(data.result > 0){
						alertify.alert("게시글 승인이 완료되었습니다.", function(){
							location.href = contextPath + "/internal/community/list.do";
						});
					}else{
						alertify.alert("<spring:message code='resume.write.insert.error'/>");
					}

				},
				error: function(xhr, status, error) {
					alertify.alert("<spring:message code='resume.write.insert.error'/>");
				}
			});
        });

    },
    fn: {

    }
}
