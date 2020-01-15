$(document).ready(function(){
	var jsonData = [{"id":1,"first_name":"Mariele","last_name":"Mintram","email":"mmintram0@cbsnews.com","gender":"Female","date":"2018-03-18","ip_address":"110.1.138.115","money":"50252.57"},
		{"id":2,"first_name":"Creight","last_name":"Coucher","email":"ccoucher1@google.it","gender":"Male","date":"2017-11-18","ip_address":"7.146.154.113","money":"56909.08"},
		{"id":3,"first_name":"Alie","last_name":"Bidewel","email":"abidewel2@illinois.edu","gender":"Female","date":"2017-11-14","ip_address":"207.101.136.222","money":"85243.91"},
		{"id":4,"first_name":"Rene","last_name":"Campany","email":"rcampany3@abc.net.au","gender":"Male","date":"2018-01-15","ip_address":"166.8.97.227","money":"23334.13"},
		{"id":1000,"first_name":"Tull","last_name":"Honniebal","email":"thonniebalrr@hubpages.com","gender":"Male","date":"2018-05-01","ip_address":"210.75.111.154","money":"88668.67"}];
	
	var paramData = {useYn: "Y"}; //테스트 값넘김
	
	var table = $('#myTable').DataTable({
		ajax: {
            'url':'/selectBulletinMNGList.do?_REQ_DATA_TYPE_=json&_USE_WRAPPED_OBJECT_=true', 
            "type": "POST",
            "dataType": "json",
            "contentType": "application/x-www-form-urlencoded;charset=UTF-8",
            "data": {_REQ_JSON_OBJECT_: common.json.getJSONString(paramData)},
            success: function(data){
                alert(data.resultCode);
                /*if(data.resultCode == 'success'){
                    alert("success List");
                }else{
                    alert("Fail");
                    return;
                }*/
            }
		},
        processing: true,
        serverSide: true,
        responsive: true,
        orderMulti: true,
        order : [[1, 'desc']],
        columns: [
            {"data": "bulletinNm"},
            {"data": "bulletinTypeCd"},
            {"data": "bulletinMngSeq"}, 
            {"data": "createDt"}, 
            {"data": "useYn"}, 
            {"data": "regUserSeq"},
            {"data": "regDt",
                "render": function(data, type, row){
                    /*
                     * 다른 column의 값을 다루고 싶을 땐
                     * row['COLUMN명'] 으로 꺼내쓸 수 있다.
                     */
                    if(type=='display'){
                        data = '<a href="'+ data + '">' + data + '</a>';
                    }
                    return data;
            }},
            {"data":"regDt"}
        ],
        "language": {
            "emptyTable": "데이터가 없어요.",
            "lengthMenu": "페이지당 _MENU_ 개씩 보기",
            "info": "현재 _START_ - _END_ / _TOTAL_건",
            "infoEmpty": "데이터 없음",
            "infoFiltered": "( _MAX_건의 데이터에서 필터링됨 )",
            "search": "에서 검색: ",
            "zeroRecords": "일치하는 데이터가 없어요.",
            "loadingRecords": "로딩중...",
            "processing":     "잠시만 기다려 주세요...",
            "paginate": {
                "next": "다음",
                "previous": "이전"
            }
        },
        /* Footer에 금액총합 구하기,
         * filtered data 총합만 계산하도록 함.*/
        "footerCallback":function(){
            var api = this.api(), data;
            var result = 0;
            api.column(7, {search:'applied'}).data().each(function(data,index){
                result += parseFloat(data);
            });
            $(api.column(3).footer()).html(result.toLocaleString()+'원');
        },
        dom : 'Blfrtip',
        buttons:[{
			extend:'csvHtml5',
			text: 'Export CSV',
			footer: true,
			bom: true,
			className: 'exportCSV'
		}]
    });

	/* ajax test */
	/*
	var opts = {
		url : "/selectInsttList.do",
		data : {insttNm: "테스트"},
		type : "post",
		sendDataType : "json",
		success : function(resJSON, resCode) {
			console.log(resJSON, resCode);
		}
	};
	common.http.ajax(opts);
	*/
});

function bulletinMNG_delete() {

}