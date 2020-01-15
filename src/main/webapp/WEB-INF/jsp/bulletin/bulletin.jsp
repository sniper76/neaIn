<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="../../../js/common/common.js"></script>
<script src="../../../js/pageLib/bulletin/bulletin.js"></script>
<script>
	$(function() {
		common.invoker.invoke("bulletinList");
	});
</script>

<div class="search_box">
	<div class="top_box clearfix">
		<h3>Contents Search</h3>
		<a href="" class="btn_registration">User Registration</a>
	</div>
	<!-- //top_box -->
	<div class="contents_box">
		<form id="frm">
			<fieldset>
				<legend>Bulletin Management Search</legend>
				<table>
					<caption>Bulletin Management Search - Search, User Type, Period</caption>
					<tbody>
					<tr>
						<th scope="row">Keyword</th>
						<td>
							<label for="Search_sel" class="skip">category selection</label>
							<select id="Search_sel">
								<option value="">All</option>
								<option value="">All</option>
								<option value="">All</option>
							</select>
							<label for="" class="skip"></label>
							<input type="text" id="" />
						</td>
						<th scope="row">User Type</th>
						<td>
							<span class="radio_box">
								<input type="radio" name="UserType" id="UserType1" />
								<label for="UserType1">All</label>
							</span>
							<span class="radio_box">
								<input type="radio" name="UserType" id="UserType2" />
								<label for="UserType2">Job Seeker</label>
							</span>
							<span class="radio_box">
								<input type="radio" name="UserType" id="UserType3" />
								<label for="UserType3">Student/Intern</label>
							</span>
							<span class="radio_box">
								<input type="radio" name="UserType" id="UserType4" />
								<label for="UserType4">Employer</label>
							</span>
							<span class="radio_box">
								<input type="radio" name="UserType" id="UserType5" />
								<label for="UserType5">Trainin Institution</label>
							</span>
						</td>
					</tr>
					<tr>
						<th scope="row">Period</th>
						<td colspan="3">
							<span class="period_box">
								<span class="date_box">
									<label for="start_date" class="skip">start date</label>
									<input type="text" id="start_date" title="Start date Select from calendar" placeholder="start date" />
									<button type="button">Start date Select from calendar</button>
								</span>
								-&nbsp;
								<span class="date_box">
									<label for="end_date" class="skip">end date</label>
									<input type="text" id="end_date" title="End date Select from calendar" placeholder="end date" />
									<button type="button">End date Select from calendar</button>
								</span>
							</span>
							<span class="period_choose">
								<button type="button">Today</button>
								<button type="button">2Week</button>
								<button type="button">1Month</button>
								<button type="button">1Year</button>
								<button type="button">All</button>
							</span>
						</td>
					</tr>
					</tbody>
				</table>
				<div class="detail_table">
					<table id="example">
						<caption>Detail Contents Search - </caption>
						
						<tbody>
							
						</tbody>
					</table>
				</div>
				<div class="put_box">
					<button type="button" class="open_detail">Open Detail Search</button>
					<input type="submit" id="btnSearch" value="SEARCH" class="btn_submit" onclick="bulletinMNG_list();"/>
					<input type="submit" id="btnDelete" value="DELETE" class="btn_submit" onclick="bulletinMNG_delete();"/>
				</div>
			</fieldset>
		</form>
	</div>
	<!-- //contents_box -->
</div>
<!-- //search_box -->


<table id="bulletin">
	<caption>program list</caption>
    <thead>
        <tr>
            <th scope="col">제목</th>
            <th scope="col">내용</th>
            <th scope="col">Program ID</th>
            <th scope="col">좋아요 사용여부</th>
            <th scope="col">사용여부</th>
            <th scope="col">등록자</th>
			<th scope="col">등록일</th>
        </tr>
    </thead>
</table>