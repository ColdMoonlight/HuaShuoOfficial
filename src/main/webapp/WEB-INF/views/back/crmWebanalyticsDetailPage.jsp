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
			<div class="c-main-body">
				<div class="c-table-table table-responsive-sm">
					<table class="table">
						<thead>
							<tr>
								<th>渠道</th>
								<th>投入</th>
								<th>销量</th>
								<th>销售额</th>
								<th>流量</th>
								<th>用户数</th>
								<th>新户数</th>
							</tr>
						</thead>
						<tbody></tbody>
					</table>
				</div>
			</div>
			<div class="row" style="margin-top: 1rem;">
				<div class="col-md-12 col-lg-6">
					<div class="card">
						<div class="card-chart"></div>
						<div class="chart-noresult hide">该时间范围内，无可用数据...</div>
						<div class="card-mask">
							<div class="spinner-border"></div>
						</div>
					</div>
				</div>
				<div class="col-md-12 col-lg-6">
					<div class="card">
						<div class="card-pie"></div>
						<div class="chart-noresult hide">该时间范围内，无可用数据...</div>
						<div class="card-mask">
							<div class="spinner-border"></div>
						</div>
					</div>
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
		<script type="text/javascript" src="${APP_PATH}/static/back/lib/echarts/echarts.min.js"></script>
		<!-- custom script -->
		<script type="text/javascript">
		function initDateRage(start, end) {
			$('#search-start-time').val(start);
			$('#search-end-time').val(end);
			$('.daterangetimepicker').val(start + ' - ' + end);

			getAllBlockData({
				webanalyticsBrandname: "megalookhairWebsite",
				webanalyticsCreatetime: start,
				webanalyticsMotifytime: end
			});
		}
		
		// callback get one data
		function getAllBlockData(reqData) {
			$.ajax({
				url: "${APP_PATH}/CrmWebanalytics/GetCrmWebanalyticsInfoByBrandAndRangeTime",
				type: "post",
				dataType: "json",
				contentType: 'application/json',
				data: JSON.stringify(reqData),
				success: function (data) {
					if (data.code == 100) {
						var tData = generateNewData(data.extend.crmWebanalyticsFinallList);
						transformPieChart(tData);
						renderTable(tData);
						toastr.success(data.extend.resMsg);
					} else {
						toastr.error(data.extend.resMsg);
					}
				},
				error: function () {
					toastr.error('Failed to get WebAnlysistics data, please refresh the page to get again!');
				},
				complete: function () {
					$('.c-mask').hide();
				}
			});
		}
		
		function generateNewData(data) {
			var nData = {};
			data && data.length && data.forEach(function(item) {
				function getNewItem(item) {
					var newItem = {
							webanalyticsChannelinvestmoney: 0,
							webanalyticsChannelsellnum: 0,
							webanalyticsChannelsellmoney: 0,
							webanalyticsChannelflowlnum: 0,
							webanalyticsChannelintousernum: 0,
							webanalyticsChannelintousernewnum: 0
					};
					item.length && item.forEach(function(cItem) {
						cItem.webanalyticsChannelinvestmoney && (newItem.webanalyticsChannelinvestmoney += cItem.webanalyticsChannelinvestmoney);
						cItem.webanalyticsChannelsellnum && (newItem.webanalyticsChannelsellnum += cItem.webanalyticsChannelsellnum);
						cItem.webanalyticsChannelsellmoney && (newItem.webanalyticsChannelsellmoney += cItem.webanalyticsChannelsellmoney);
						cItem.webanalyticsChannelflowlnum && (newItem.webanalyticsChannelflowlnum += cItem.webanalyticsChannelflowlnum);
						cItem.webanalyticsChannelintousernum && (newItem.webanalyticsChannelintousernum += cItem.webanalyticsChannelintousernum);
						cItem.webanalyticsChannelintousernewnum && (newItem.webanalyticsChannelintousernewnum += cItem.webanalyticsChannelintousernewnum);
					});
					return newItem;
				}
				nData[item[0].webanalyticsChannelname] = getNewItem(item);
			});
			return nData;
		}
		
		function renderTable(data) {
			var htmlStr = '';
			for (var key in data) {
				htmlStr += '<tr>' +
					'<td>'+ key +'</td>' +
					'<td>'+ (data[key].webanalyticsChannelinvestmoney) +'</td>' +
					'<td>'+ (data[key].webanalyticsChannelsellnum) +'</td>' +
					'<td>'+ (data[key].webanalyticsChannelsellmoney) +'</td>' +
					'<td>'+ (data[key].webanalyticsChannelflowlnum) +'</td>' +
					'<td>'+ (data[key].webanalyticsChannelintousernum) +'</td>' +
					'<td>'+ (data[key].webanalyticsChannelintousernewnum) +'</td>' +
				'</tr>';
			}
			$('.c-table-table tbody').html(htmlStr);
		}

		function transformPieChart(data) {
			var chartData = [];
			var pieData = [];
			for(var key in data) {
				chartData.push({
					value: data[key].webanalyticsChannelsellmoney,
					name: key
				});
				pieData.push({
					value: data[key].webanalyticsChannelflowlnum,
					name: key
				});
			}

			var $cardChart = $('.card-chart');
			var $cardPie = $('.card-pie');
			if (chartData.length) {
				$cardChart.parent().find('.chart-noresult').addClass('hide');
				$cardPie.parent().find('.chart-noresult').addClass('hide');
				var instanceChart = generateChart($cardChart, {
				    title: { text: '各渠道（销售额）数据', left: 'center' },
				    tooltip: { trigger: 'item', formatter: '{a}: {c} ({d}%)' },
				    legend: {  orient: 'vertical', left: 'left', },
				    series: [ { name: '销售额', type: 'pie', radius: '50%', data: chartData } ]
				});

				chartInstance.push(instanceChart);

				var instancePie = generateChart($cardPie, {
				    title: { text: '各渠道（流量）数据', left: 'center' },
				    tooltip: { trigger: 'item', formatter: '{a}: {c} ({d}%)' },
				    legend: {  orient: 'vertical', left: 'left', },
				    series: [ { name: '流量', type: 'pie', radius: '50%', data: pieData } ]
				});

				chartInstance.push(instancePie);
			} else {
				$cardChart.parent().find('.chart-noresult').removeClass('hide');
				$cardPie.parent().find('.chart-noresult').removeClass('hide');
			}
			$cardChart.parent().find(".card-mask").addClass('hide');
			$cardPie.parent().find(".card-mask").addClass('hide');
		}		
		
		function generateChart($el, option) {
			$el.css('height', 460);
			var instance = echarts.init($el[0]);
			instance.setOption(option);
			return instance;
		}

		// init
		var date = new Date();
		var ymd = date.getFullYear() + '-' + (date.getMonth() + 1 > 9 ? date.getMonth() + 1 : '0' + (date.getMonth() + 1)) + '-' + (date.getDate() > 9 ? date.getDate() : '0' + date.getDate());
		var chartInstance = [];

		initDateRage(ymd + ' 00:00:00', ymd + ' 23:59:59');
		bindDateRangeEvent(function(start, end) {
			$('#search-start-time').val(start);
			$('#search-end-time').val(end);
			chartInstance = [];
			getAllBlockData({
				webanalyticsBrandname: "megalookhairWebsite",
				webanalyticsCreatetime: start,
				webanalyticsMotifytime: end
			});
		});
		// resize for chart
		$(window).on('resize', function() {
			if (chartInstance.length) {
				chartInstance.forEach(function(item, idx) {
					item.resize();
				});
			}
		});
		</script>
	</body>
</html>