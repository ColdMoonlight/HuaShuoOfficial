<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% pageContext.setAttribute("APP_PATH" , request.getContextPath()); %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>crm Web Analystics Graph</title>
		<jsp:include page="common/backheader.jsp" flush="true"></jsp:include>
		<link rel="stylesheet" href="${APP_PATH}/static/back/lib/datetimepicker/daterangepicker.css">	
	</head>

	<body class="c-app">
		<jsp:include page="layout/backheader.jsp" flush="true"></jsp:include>
		<div class="c-main">
			<div class="c-main-head row">
				<div class="c-dropdown col-md-6 col-lg-3">
					<div class="form-group row">
						<label class="col-form-label" style="float: left; margin-left: 1rem;" for="c-dropdown-website">Website</label>
						<div class="controls col-md-9" style="padding-left: .5rem;">
							<select class="form-control" id="c-dropdown-website">
								<option value="megalookhairWebsite">megalookhairWebsite</option>
								<option value="arabella">arabella</option>
								<option value="ayiyi">ayiyi</option>
							</select>
						</div>
					</div>
				</div>
				<div class="c-date-time-range">
					<div class="form-group">
						<label class="col-form-label" for="search-time">
							<svg class="c-icon">
								<use xlink:href="${APP_PATH}/static/back/img/svg/free.svg#cil-av-timer"></use>
							</svg>
						</label>
						<div class="controls">
							<input hidden id="search-start-time" />
							<input hidden id="search-end-time" />
							<input class="form-control daterangetimepicker" type="text" placeholder="@exmaple 2020-01-01 00:00:00 - 2020-01-01 23:59:59" >
						</div>
					</div>
				</div>
				<div class="">
					<div class="form-group row">
					<button class="btn btn-primary btn-select">查询</button>
					</div>
				</div>
				
				<div class="c-table">
					<div class="table-detail"></div>
				</div>
			</div>
		</div>
		<jsp:include page="layout/backfooter.jsp" flush="true"></jsp:include>

		<!-- common script  -->
		<jsp:include page="common/backfooter.jsp"></jsp:include>
		<jsp:include page="common/backsidebar.jsp"></jsp:include>
		<!-- other -->
		<script type="text/javascript" src="${APP_PATH}/static/back/lib/datetimepicker/moment.min.js"></script>
		<script type="text/javascript" src="${APP_PATH}/static/back/lib/datetimepicker/daterangepicker.js"></script>
		<!-- custom script -->
		<script type="text/javascript">
		function initDateRage(start, end) {
			$('#search-start-time').val(start);
			$('#search-end-time').val(end);
			$('.daterangetimepicker').val(start + ' - ' + end);
		}
		// init
		var date = new Date();
		var ymd = date.getFullYear() + '-' + (date.getMonth() + 1 > 9 ? date.getMonth() + 1 : '0' + (date.getMonth() + 1)) + '-' + (date.getDate() > 9 ? date.getDate() : '0' + date.getDate());

		initDateRage(ymd + ' 00:00:00', ymd + ' 23:59:59');
		bindDateRangeEvent(function(startTime, endTime) {
			$('#search-start-time').val(startTime);
			$('#search-end-time').val(endTime);
		});
		
		
		// create collection
		$('.btn-select').on('click', function () {
			console.log("--------------");
			var reqData = getFormData();
			console.log(reqData);
			getSelectDate(reqData);});

		// getFormdData
		function getFormData() {
			var data = {};
			data.webanalyticsBrandname = $('#c-dropdown-website').val();
			data.webanalyticsCreatetime = $('#search-start-time').val();
			data.webanalyticsMotifytime = $('#search-end-time').val();
			return data;
		}
		
		// callback get one data
		function getSelectDate(reqData) {
			$.ajax({
				url: "${APP_PATH}/CrmWebanalytics/GetCrmWebanalyticsInfoByRangeTimeAndBrand",
				type: "post",
				dataType: "json",
				contentType: 'application/json',
				data: JSON.stringify(reqData),
				success: function (data) {
					if (data.code == 100) {
						renderTable(data);
						toastr.success(data.extend.resMsg);
					} else {
						toastr.error(data.extend.resMsg);
					}
				},
				error: function () {
					toastr.error('Failed to get SHOP-ROOM data, please refresh the page to get again!');
				},
				complete: function () {
					$('.c-mask').hide();
				}
			});
		}
		
		// init table-list
		function renderTable(data) {
			var crmWebanalyticsBrandListData = data.extend.crmWebanalyticsBrandList;
			console.log(crmWebanalyticsBrandListData);
			console.log("-----------------------------------");
			var CrmWebanalyticsAllListData = data.extend.CrmWebanalyticsAllList;
			console.log(CrmWebanalyticsAllListData);
			console.log("-----------------------------------");
			var AllMoney=0;
			var AllNum=0;
			var htmlStr = '';
			for (var i = 0, len = CrmWebanalyticsAllListData.length; i < len; i += 1) {
				AllMoney=AllMoney+CrmWebanalyticsAllListData[i].webanalyticsChannelsellmoney;
			}
			for (var i = 0, len = CrmWebanalyticsAllListData.length; i < len; i += 1) {
				var baifenbi =CrmWebanalyticsAllListData[i].webanalyticsChannelsellmoney/AllMoney*100;
				htmlStr += '<tr><td>&nbsp;&nbsp;' + CrmWebanalyticsAllListData[i].webanalyticsBrandname + '&nbsp;&nbsp;</td>' +
					'<td>&nbsp;&nbsp;' + CrmWebanalyticsAllListData[i].webanalyticsChannelname + '&nbsp;&nbsp;</td>' +
					'<td>&nbsp;&nbsp;' + CrmWebanalyticsAllListData[i].webanalyticsChannelinvestmoney + '&nbsp;&nbsp;</td>' +
					'<td>&nbsp;&nbsp;' + CrmWebanalyticsAllListData[i].webanalyticsChannelintousernum + '&nbsp;&nbsp;</td>' +
					'<td>&nbsp;&nbsp;' + CrmWebanalyticsAllListData[i].webanalyticsChannelintousernewnum + '&nbsp;&nbsp;</td>' +
					'<td>&nbsp;&nbsp;' + CrmWebanalyticsAllListData[i].webanalyticsChannelflowlnum + '&nbsp;&nbsp;</td>' +
					'<td>&nbsp;&nbsp;' + CrmWebanalyticsAllListData[i].webanalyticsChannelsellnum + '&nbsp;&nbsp;</td>' +
					'<td>&nbsp;&nbsp;' + CrmWebanalyticsAllListData[i].webanalyticsChannelsellmoney + '&nbsp;&nbsp;</td>' +
					'<td>&nbsp;&nbsp;' + baifenbi.toFixed(2) + '%&nbsp;&nbsp;</td>' +
					'</tr>';
			}
			$('.table-detail').html(htmlStr);
		}
		</script>
	</body>
</html>