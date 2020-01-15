
$(document).ready(function() {
    $('#oneDepth').attr('disabled',true);
    $('#twoDepth').attr('disabled',true);
    $('#threeDepth').attr('disabled',true);
    $('#jobCateCd').attr('disabled',true);

   $('#depth').change(function(e) {
       var selectVal = $(this).val();
       //oneDepthList();
       if(selectVal == '1'){
        $('#oneDepth').attr('disabled',true);
        $('#twoDepth').attr('disabled',true);
        $('#threeDepth').attr('disabled',true);
        $('#oneDepth,#twoDepth,#threeDepth').find('option').each(function(){
            
            $(this).remove();
        });
        $('#oneDepth').append("<option value=\"\">1 Depth</option>");
        $('#twoDepth').append("<option value=\"\">2 Depth</option>");
        $('#threeDepth').append("<option value=\"\">3 Depth</option>");
       }else if(selectVal == '2'){
        $('#oneDepth').attr('disabled',false);
        $('#twoDepth').attr('disabled',true);
        $('#threeDepth').attr('disabled',true);
        $('#twoDepth,#threeDepth').find('option').each(function(){
            
            $(this).remove();
        });
        $('#twoDepth').append("<option value=\"\">2 Depth</option>");
        $('#threeDepth').append("<option value=\"\">3 Depth</option>");
       }else if(selectVal == '3'){
        $('#oneDepth').attr('disabled',false);
        $('#twoDepth').attr('disabled',false);
        $('#threeDepth').attr('disabled',true);
        $('#threeDepth').find('option').each(function(){
            
            $(this).remove();
        });
        $('#threeDepth').append("<option value=\"\">3 Depth</option>");
        
       }else if(selectVal == '4'){
        $('#oneDepth').attr('disabled',false);
        $('#twoDepth').attr('disabled',false);
        $('#threeDepth').attr('disabled',false);
        $('#jobCateCd').attr('disabled',false);
       }
    
   });

    //onLoadList();
    $('#oneDepth').change(function(e) {
        $('#twoDepth,#threeDepth').find('option').each(function(){
            
            $(this).remove();
        });
        $('#twoDepth').append("<option value=\"\">2 Depth</option>");
        $('#threeDepth').append("<option value=\"\">3 Depth</option>");

        var selectVal = $(this).val();

        if(selectVal != ""){
            var param = {iscoId: selectVal,iscoCd: $('#txtIscoCd').val()};

            $.ajax({
                type : 'post', // 타입
                url :  contextPath + "/internal/common/selectIscoTwoListAjax.do", // URL
                dataType : 'json', // 데이터 타입
                traditional: true,
                data : param,
                success:function(result){
                    
                    if(result.twoDepth.length != null){
                        $('#twoDepth option:first').remove();
                        $('#twoDepth').append("<option value=\"\">2 Depth</option>");
                        for(var i in result.twoDepth){
                            var depthobj = result.twoDepth[i];
                            $('#twoDepth').append("<option value=\""+ depthobj.iscoId +"\">"+ depthobj.cateNm +"</option>");
                        }
                    }
                    
                },
                complete:function(){
                    //
                }
            })
            
        }

    });


    $('#twoDepth').change(function(e) {
        $('#threeDepth').find('option').each(function(){
            
            $(this).remove();
        });
        $('#threeDepth').append("<option value=\"\">3 Depth</option>");

        var selectVal = $(this).val();

        if(selectVal != ""){
            var param = {iscoId: selectVal,iscoCd: $('#txtIscoCd').val()};

            $.ajax({
                type : 'post', // 타입
                url :  contextPath + "/internal/common/selectIscoThreeListAjax.do", // URL
                dataType : 'json', // 데이터 타입
                traditional: true,
                data : param,
                success:function(result){
                    
                    if(result.threeDepth.length != null){
                        $('#threeDepth option:first').remove();
                        $('#threeDepth').append("<option value=\"\">3 Depth</option>");
                        for(var i in result.threeDepth){
                            var depthobj = result.threeDepth[i];
                            $('#threeDepth').append("<option value=\""+ depthobj.iscoId +"\">"+ depthobj.cateNm +"</option>");
                        }
                    }
                    
                },
                complete:function(){
                    //
                }
            })
            
        }

    });

    $('#threeDepth').change(function(e) {
        

        var selectVal = $(this).val();

        if(selectVal != ""){
            var param = {iscoId: selectVal,iscoCd: $('#txtIscoCd').val()};

            $.ajax({
                type : 'post', // 타입
                url :  contextPath + "/internal/common/selectIscoFourListAjax.do", // URL
                dataType : 'json', // 데이터 타입
                traditional: true,
                data : param,
                success:function(result){
                    
                    if(result.fourDepth.length != null){
                        $('#fourDepth option:first').remove();
                        for(var i in result.fourDepth){
                            var depthobj = result.fourDepth[i];
                            $('#fourDepth').append("<option value=\""+ depthobj.iscoId +"\">"+ depthobj.cateNm +"</option>");
                        }
                    }
                    
                },
                complete:function(){
                    //
                }
            })
            
        }

    });
    
    
    
});

function oneDepthList(){
    var param = {iscoCd: $('#txtIscoCd').val()};
    $.ajax({
        type : 'post', // 타입
        url :  contextPath + "/internal/common/selectIscoOneListAjax.do", // URL
        dataType : 'json', // 데이터 타입
        traditional: true,
        success:function(result){
            
            if(result.oneDepth.length != null){
                $('#oneDepth option:first').remove();
                $('#oneDepth').append("<option value=\"\">1 Depth</option>");
                for(var i in result.oneDepth){
                    var depthobj = result.oneDepth[i];
                    $('#oneDepth').append("<option value=\""+ depthobj.iscoId +"\">"+ depthobj.cateNm +"</option>");
                }
            }
            
        },
        complete:function(){
            //
        }
    })
}




function updateIscoCdConf(){
    

    if ($('#khNm').val() == "") {
        alertify.alert(iscoNmKhMsg, function (e) {
            if (e) {
                $("#khNm").focus();
            }
        });
        return;
    }
    if ($('#enNm').val() == "") {
        alertify.alert(iscoNmEnMsg, function (e) {
            if (e) {
                $("#enNm").focus();
            }
        });
        return;
    }
    if ($('#depth option:selected').val() == "") {
        alertify.alert(iscoDepthMsg, function (e) {
            if (e) {
                $("#depth").focus();
            }
        });
        return;
    }

    var selectVal = $('#depth option:selected').val();

    if(selectVal == '2'){
        if ($('#oneDepth option:selected').val() == "") {
            alertify.alert(oneDepthMsg, function (e) {
                if (e) {
                    $("#oneDepth").focus();
                }
            });
            return;
        }
    }else if(selectVal == '3'){
        if ($('#oneDepth option:selected').val() == "") {
            alertify.alert(oneDepthMsg, function (e) {
                if (e) {
                    $("#oneDepth").focus();
                }
            });
            return;
        }
        if ($('#twoDepth option:selected').val() == "") {
            alertify.alert(twoDepthMsg, function (e) {
                if (e) {
                    $("#twoDepth").focus();
                }
            });
            return;
        }
    }else if(selectVal == '4'){
        if ($('#oneDepth option:selected').val() == "") {
            alertify.alert(oneDepthMsg, function (e) {
                if (e) {
                    $("#oneDepth").focus();
                }
            });
            return;
        }
        if ($('#twoDepth option:selected').val() == "") {
            alertify.alert(twoDepthMsg, function (e) {
                if (e) {
                    $("#twoDepth").focus();
                }
            });
            return;
        }
        if ($('#threeDepth option:selected').val() == "") {
            alertify.alert(threeDepthMsg, function (e) {
                if (e) {
                    $("#threeDepth").focus();
                }
            });
            return;
        }
    }

    /*
    if ($('#jobCateCd option:selected').val() == "") {
        alertify.alert(twoDepthMsg, function (e) {
            if (e) {
                $("#jobCateCd").focus();
            }
        });
        return;
    }*/
    
    alertify.confirm(saveMsg, function (e) {
        if (e) {
            updateIscoCd();
        } else {
            return;
        }
    });
}


function updateIscoCd(){
    var iscoCd = $('#txtIscoCd').val();
    $('#iscoCd').val(iscoCd);
    console.log("iscoCd: "+iscoCd);
    var param = $("#frm").serialize();
    
    $.ajax({
        type : 'post', // 타입
        url :  contextPath + "/internal/common/updateIscoCdMngAjax.do", // URL
        dataType : 'json', // 데이터 타입
        //data : param,
        traditional: true,
        data : param,
        success : function(result) { // 결과 성공
            var sucCode = result.stat;
            if(sucCode == "0000"){
                alertify.alert(result.msg);
                forList();
            }else{
                alertify.alert(result.msg);
            }
           
        },
        error : function(request, status, error) { // 결과 에러

        }
    })
    

}



function forList(){
    
    location.href = contextPath + "/internal/common/iscoCdMngList.do";
    
}