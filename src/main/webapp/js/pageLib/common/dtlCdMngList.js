$(document).ready(function() {

    init();
    
    
    
});

var mainDataTables = "";
var subDataTables = "";
    
function init() {
        mainBind();
        subBind();
        //그룹코드 선택 이벤트
        $('#grpCdList tbody').on('click', 'tr', function () {
            var data = mainDataTables.row( this ).data();
            var col1 = data.grpCd;
            mainSelect(col1);
        });

        //공통코드 선택 이벤트
        $('#dtlCdList tbody').on('click', 'tr', function () {
            var data = subDataTables.row( this ).data();
            var col1 = data.dtlCd;
            var col2 = data.cdKhNm;
            var col3 = data.cdEnNm;
            var col4 = data.cdContent;
            var col5 = data.useYn;
            var bGrpCd = $('#srchGrpCd').val();

            $('#grpCd').val(bGrpCd);
            $('#dtlCd').val(col1);
            $('#cdKhNm').val(col2);
            $('#cdEnNm').val(col3);
            $('#cdContent').val(col4);
            //$('#useYn').val(col5);
            //console.log(col5);
            //$('input:radio[name=useYn]:input[value=' + col5 + ']').attr("checked", true);
        });

        $('#txtgrpNm').html(txtGrp);
}


function mainBind() {
    var that$ = this;
        var setColumns = [
            {"data": "grpCd"},
            {"data": "grpNm"},
            {"data": "useYn"},
            {"data": "regUserNm"}, 
            {"data": "regDt"}
        ];
        
        var orderColumns = setColumns.map(function(x) {return x.data });
        // init dataTable
        mainDataTables = $('#grpCdList').DataTable({
            paging: false,
            lengthMenu : false,
            processing: true,
            serverSide: true,
			scrollCollapse: true,
			scrollY: "200px",
            searching: false,
            //select: 'single',
            lenthChange: false,
            ordering: false,
			info: false,
            destroy: true,
            serverMethod: 'post',
            ajax: {
                url :  contextPath + "/internal/common/selectDtlMngGrpCdListAjax.do" // URL
                ,dataType: "json"
                , data: function ( d ) {
                    return $.extend( {}, d, {
                        
                        searchKeyword: $('#searchKeyword').val(),
                        searchValue: $('#searchValue').val(),
                        useYn: $('#useYn').val(),
                        lang: lang
                    } );
                }

            },
            select:{
                style: 'single'
            },
            select: true,
            columns : setColumns
            
        });
}


function subBind() {
    var that$ = this;
        var setColumns = [
            {"data": "dtlCd"},
            {"data": "cdKhNm"},
            {"data": "cdEnNm"},
            {"data": "useYn"}, 
            {"data": "cdContent"}
        ];
        
        var orderColumns = setColumns.map(function(x) {return x.data });
        // init dataTable
        subDataTables = $('#dtlCdList').DataTable({
            paging: false,
            lengthMenu : false,
            processing: true,
            serverSide: true,
			scrollCollapse: true,
			scrollY: "200px",
            searching: false,
            //select: 'single',
            lenthChange: false,
            ordering: false,
			info: false,
            destroy: true,
            serverMethod: 'post',
            ajax: {
                url :  contextPath + "/internal/common/selectDtlMngDtlCdListAjax.do" // URL
                ,dataType: "json"
                , data: function ( d ) {
                    return $.extend( {}, d, {
                        
                        grpCd: $('#srchGrpCd').val(),
                        lang: lang
                    } );
                }

            },
            columnDefs: [
                { targets: 4, visible: false, searchable: false }
            ],
            select:{
                style: 'single'
            },
            select: true,
            columns : setColumns
            
        });
}


function mainSelect(grpCd){
    var txtGrp = txtGrp+" "+grpCd;
    $('#txtgrpNm').html(grpCd);
    $('#srchGrpCd').val(grpCd);

    //상세코드 초기화
    dtlSetValueNull();
    subDataTables.ajax.reload();
}

function newDtlCd(){
    var bGrpCd = $('#srchGrpCd').val();
    if(bGrpCd == "none" || bGrpCd == ""){
        alertify.alert(selGrpMsg);
        return;
    }
    dtlSetValueNull();
    $('#grpCd').val(bGrpCd);
}


function dtlSetValueNull(){
    $('#grpCd').val("");
    $('#dtlCd').val("");
    $('#cdKhNm').val("");
    $('#cdEnNm').val("");
    $('#cdContent').val("");
    $('#useYn').val("Y");
}


function saveDtlCdConf(){
    alertify.confirm(saveMsg, function (e) {
        if (e) {
            saveDtlCd();
        } else {
            return;
        }
    });
}


function saveDtlCd(){
    var param = $("#txtfrm").serialize();
    
    $.ajax({
        type : 'post', // 타입
        url :  contextPath + "/internal/common/saveDtlCdMngAjax.do", // URL
        dataType : 'json', // 데이터 타입
        //data : param,
        traditional: true,
        data : param,
        success : function(result) { // 결과 성공
            var sucCode = result.stat;
            if(sucCode == "0000"){
                alertify.alert(result.msg);
                subDataTables.ajax.reload();
            }else{
                alertify.alert(result.msg);
            }
           
        },
        error : function(request, status, error) { // 결과 에러

        }
    })
}


function deleteDtlCdConf(){
    alertify.confirm(deleteMsg, function (e) {
        if (e) {
            deleteDtlCd();
        } else {
            return;
        }
    });
}

function deleteDtlCd(){
    var param = $("#txtfrm").serialize();
    
    $.ajax({
        type : 'post', // 타입
        url :  contextPath + "/internal/common/deleteDtlCdMngAjax.do", // URL
        dataType : 'json', // 데이터 타입
        //data : param,
        traditional: true,
        data : param,
        success : function(result) { // 결과 성공
            var sucCode = result.stat;
            if(sucCode == "0000"){
                alertify.alert(result.msg);
                subDataTables.ajax.reload();
            }else{
                alertify.alert(result.msg);
            }
           
        },
        error : function(request, status, error) { // 결과 에러

        }
    })
}
