<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/CommonCodeCustomTag.tld" prefix="commCode" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="${pageContext.request.contextPath}/js/pageLib/referral/referralHisMngList.js"></script>

<script>
	$(function() {
		common.invoker.invoke("referralHisMngList");
	});
</script>

<div class="search_box">
	<div class="top_box clearfix">
		<h3>Contents Search</h3>
		<a href="" class="btn_registration">User Registration</a>
	</div>
	<!-- //top_box -->
	<div class="contents_box">
		<form>
			<fieldset>
				<legend>Contents Search</legend>
				<table>
					<caption>Contents Search - Search, User Type, Period</caption>
					<tbody>
					<tr>
						<th scope="row">Search</th>
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
					<table id="example1111">
						<caption>Detail Contents Search - </caption>
						
						<tbody>
							
						</tbody>
					</table>
				</div>
				<div class="put_box">
					<button type="button" class="open_detail">Open Detail Search</button>
					<input type="submit" id="btnSearch" name="btnSearch" value="SEARCH" class="btn_submit" />
					<input type="submit" id="btnDelete" name="btnDelete" value="DELETE" class="btn_submit" />
				</div>
			</fieldset>
		</form>
	</div>
	<!-- //contents_box -->
</div>
<!-- //search_box -->


<table id="myTable"  class="table table-bordered">
	<caption>company list</caption>
	<thead>
		<tr>
			<th scope="col"><input name="select_all" value="1" id="example-select-all" type="checkbox" /></th>
			<th scope="col">No.</th>
			<th scope="col">Vacancy Seq</th>
			<th scope="col">Resume Seq</th>
			<th scope="col">Type</th>
			<th scope="col">Company</th>
			<th scope="col">Job Vacancy</th>
			<th scope="col">Name</th>
			<th scope="col">Date</th>
			<th scope="col">Charged Person</th>
			<th scope="col">Job Center</th>
			<th scope="col">Manage</th>
			<th scope="col">Status</th>
		</tr>
	</thead>
</table>

