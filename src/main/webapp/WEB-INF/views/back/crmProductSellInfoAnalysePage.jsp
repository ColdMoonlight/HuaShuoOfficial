<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% pageContext.setAttribute("APP_PATH" , request.getContextPath()); %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>销售分析</title>
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
			<div class="row">
				<div class="col-md-12 col-lg-6">
					<div class="card">
						<div class="card-chart card-pie"></div>
						<div class="card-mask">
							<div class="spinner-border"></div>
						</div>
					</div>
				</div>
				<div class="col-md-12 col-lg-6">
					<div class="card">
						<div class="card-chart card-bar"></div>
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
		function initChart(start, end) {
			$('#search-start-time').val(start);
			$('#search-end-time').val(end);
			$('.daterangetimepicker').val(start + ' - ' + end);
			generateChartWithData();
		}	

		function generateChart($el, option) {
			$el.css('height', 460);
			option && echarts.init($el[0]).setOption(option);
		}

		function generatePieChart() {			
			$.ajax({
				url: "${APP_PATH}/CrmProductSellInfo/GetProductSellInfoByRangeTime",
				type: "post",
				dataType: "json",
				contentType: 'application/json',
				data: JSON.stringify({
					'productsellinfoProductselltime': $('#search-start-time').val(),
					'productsellinfoMotifytime': $('#search-end-time').val(),
				}),
				success: function (data) {
					if (data.code == 100) {
						transformPieChart(data.extend.returnMsg);
					} else {
						toastr.error(data.extend.resMsg);
					}
				},
				error: function () {
					toastr.error('Failed to get payinfo-data, please refresh the page to get again！');
				}
			});
		}

		function transformPieChart(data) {
			var pieData = [];
			data.length && data.forEach(function(item, idx) {
				if (idx < 5) {
					item.length && pieData.push({
						value: item.length,
						name: item[0].productsellinfoProductsku
					});					
				} else {
					var curItem = pieData[5];
					if (curItem) {
						curItem.value += item.length;
					} else {
						pieData.push({
							value: item.length,
							name: "其他"
						});
					}
				}
			});

			var $cardPie = $('.card-pie');
			if (pieData.length) {
				var instance = generateChart($cardPie, {
				    title: { text: '售卖产品来源（sku）', left: 'center' },
				    tooltip: { trigger: 'item', formatter: '{a}: {c} ({d}%)' },
				    legend: {  orient: 'vertical', left: 'left', },
				    series: [ { name: '数量', type: 'pie', radius: '50%', data: pieData } ]
				});

				chartInstance.push(instance);
			} else {
				$cardPie.html('该时间范围内，无可用数据...');
			}
			$cardPie.parent().find(".card-mask").addClass('hide');
		}
		
		function generateBarChart() {
			
		}
		
		function transformBarChart(data) {
			var barData = [];
			data.length && data.forEach(function(item, idx) {
				var dArr = [];
				item.length && item.forEach(function(sItem, idx) {
					if (idx < 3) {
						item.length && dArr.push({
							value: item.length,
							name: item[0].productsellinfoProductsku
						});					
					}
				});				
			});
			var $cardBar = $('.card-bar');
			if (barData.length) {
				var instance = generateChart($cardBar, {
				    title: { text: '售卖产品统计（sku）', left: 'center' },
				    legend: {},
				    tooltip: { trigger: 'item' },
				    dataset: { source: barData },
				    xAxis: { type: 'date' },
				    yAxis: {},
				    series: [ {type: 'bar'}, {type: 'bar'}, {type: 'bar'} ]
				});
				

				chartInstance.push(instance);
			} else {
				$cardBar.html('该时间范围内，无可用数据...');
			}
			$cardBar.parent().find(".card-mask").addClass('hide');
		}
		
		function generateChartWithData() {
			$('.card-mask').removeClass('hide');
			generatePieChart();	
			generateBarChart();
		}

		// init
		var date = new Date();
		var ymd = date.getFullYear() + '-' + (date.getMonth() + 1 > 9 ? date.getMonth() + 1 : '0' + (date.getMonth() + 1)) + '-' + (date.getDate() > 9 ? date.getDate() : '0' + date.getDate());
		var chartInstance = [];

		initChart(ymd + ' 00:00:00', ymd + ' 23:59:59');
		bindDateRangeEvent(function(startTime, endTime) {
			$('#search-start-time').val(startTime);
			$('#search-end-time').val(endTime);
			generateChartWithData();
		});	
		// resize for chart
		$(window).on('resize', function() {
			if (chartInstance.length) {
				chartInstance.forEach(function(item, idx) {
					item.resize();
				});
			} else {
				initChart(ymd + ' 00:00:00', ymd + ' 23:59:59');
			}
		});
		</script>
	</body>
</html>