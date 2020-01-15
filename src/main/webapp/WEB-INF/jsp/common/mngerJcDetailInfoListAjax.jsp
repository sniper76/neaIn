<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach var="item1" items="${menu.tailListMenu}" varStatus="status">
<tr>
	<td>
		<c:if test="${item1.menu1DepthNm ne null && item1.menu1DepthNm != '' }">
		<input type="checkbox" name="menu1DepthCdList" id="menu1_${item1.menu1DepthCd }" class="${item1.menu1DepthCd }" value="${item1.menu1DepthCd }" <c:if test="${item1.menu1AuthYn eq 'Y' }"> checked </c:if> onClick="fn_allChk(this);"/>
		</c:if>
		${item1.menu1DepthNm }
	</td>
	<td>
		<c:if test="${item1.menu2DepthNm ne null && item1.menu2DepthNm != '' }">
		<input type="checkbox" name="menu2DepthCdList" id="menu2_${item1.menu2DepthCd }" class="${item1.menu1DepthCd } ${item1.menu2DepthCd }" value="${item1.menu2DepthCd }" <c:if test="${item1.menu2AuthYn eq 'Y' }"> checked </c:if> onClick="fn_allChk(this);" />
		</c:if>
		${item1.menu2DepthNm }
	</td>
	<td>
		<c:if test="${item1.menu3DepthNm ne null && item1.menu3DepthNm != '' }">
		<input type="checkbox" name="menu3DepthCdList" id="menu3_${item1.menu3DepthCd }" class="${item1.menu1DepthCd } ${item1.menu2DepthCd } ${item1.menu3DepthCd }" value="${item1.menu3DepthCd }" <c:if test="${item1.menu3AuthYn eq 'Y' }"> checked </c:if> onClick="fn_allChk(this);" />
		</c:if>
		${item1.menu3DepthNm }
	</td>
	<td>
		<c:if test="${item1.menu4DepthNm ne null && item1.menu4DepthNm != '' }">
		<input type="checkbox" name="menu4DepthCdList" id="menu4_${item1.menu4DepthCd }" class="${item1.menu1DepthCd } ${item1.menu2DepthCd } ${item1.menu3DepthCd } ${item1.menu4DepthCd }" value="${item1.menu4DepthCd }" <c:if test="${item1.menu4AuthYn eq 'Y' }"> checked </c:if> onClick="fn_allChk(this);" />
		</c:if>
		${item1.menu4DepthNm }
	</td>
	<td>
		<c:forEach var="userProgram" items="${item1.menuProgramMapList }" varStatus="status">
			<input type="checkbox" name="proList" id="pro_${userProgram.programSeq }" value="${userProgram.menuProgramMapSeq}" class="${item1.menu1DepthCd } ${item1.menu2DepthCd } ${item1.menu3DepthCd } ${item1.menu4DepthCd }" <c:if test="${userProgram.programAuthYn eq 'Y' }"> checked </c:if>/> ${userProgram.depthNm } : ${userProgram.programNmKh }<br/>
		</c:forEach>
	</td>
	
</tr>
</c:forEach>

<script>
$(document).ready(function(){
	/* 
	 * 
	 * 같은 값이 있는 열을 병합함
	 * 
	 * 사용법 : $('#테이블 ID').rowspan(0);
	 * 
	 */    
	$.fn.rowspan = function(colIdx, isStats) {       
	    return this.each(function(){      
	        var that;     
	        $('tr', this).each(function(row) {      
	            $('td:eq('+colIdx+')', this).filter(':visible').each(function(col) {
	                 
	            	console.log($(this).html() +":" + $(that).html());
	                if ($(this).html() == $(that).html()
	                    && (!isStats 
	                            || isStats && $(this).prev().html() == $(that).prev().html()
	                            )
	                            && $(this).html().trim() != ''){    
	                    rowspan = $(that).attr("rowspan") || 1;
	                    rowspan = Number(rowspan)+1;
	 
	                    $(that).attr("rowspan",rowspan);
	                     
	                    // do your action for the colspan cell here            
	                    $(this).addClass('hide_td').hide();
	                    //$(this).remove(); 
	                    // do your action for the old cell here
	                     
	                } else {            
	                    that = this;         
	                }          
	                 
	                // set the that if not already set
	                that = (that == null) ? this : that;      
	            });     
	        });
	       
	    });  
	}; 
	 

	/* 
	 * 
	 * 같은 값이 있는 행을 병합함
	 * 
	 * 사용법 : $('#테이블 ID').colspan (0);
	 * 
	 */  
	$.fn.colspan = function(rowIdx) {
	    return this.each(function(){
	         
	        var that;
	        $('tr', this).filter(":eq("+rowIdx+")").each(function(row) {
	            $(this).find('th').filter(':visible').each(function(col) {
	                if ($(this).html() == $(that).html()) {
	                    colspan = $(that).attr("colSpan") || 1;
	                    colspan = Number(colspan)+1;
	                     
	                    $(that).attr("colSpan",colspan);
	                    $(this).hide(); // .remove();
	                } else {
	                    that = this;
	                }
	                 
	                // set the that if not already set
	                that = (that == null) ? this : that;
	                 
	            });
	        });
	    });
	}
	$('#authList').rowspan(0);
	$('#authList').rowspan(1);
	$('#authList').rowspan(2);
	$('#authList').rowspan(3);
	$('#authList').rowspan(4);
	$('.hide_td').remove();
});


function fn_allChk(obj) {
	var clsNm = $(obj).attr('class');
	
		  	if($(obj).is(":checked")) {
		  		$('.'+clsNm).attr("checked", true);
		  	} else {
		  		$('.'+clsNm).attr("checked", false);
		  	}
}
</script>