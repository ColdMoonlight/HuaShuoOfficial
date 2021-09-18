<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% pageContext.setAttribute("APP_PATH" , request.getContextPath()); %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>aliexpress销售分析</title>
		<jsp:include page="common/backheader.jsp" flush="true"></jsp:include>
		<link rel="stylesheet" href="${APP_PATH}/static/back/lib/datetimepicker/daterangepicker.css">
		<style>
			.c-table-table { max-height: 460px; overflow-y: auto; }
			.c-table-table table { position: relative; }
			.c-table-table thead { position: sticky; top: 0; left: 0; background-color: #ebedef; }
			.chart-n-item+.chart-n-item { margin-top: 1rem; }
		</style>
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

			<div class="row chart-n-item">
				<div class="col-md-12 col-lg-6">
					<div class="card">
						<div class="card-chart card-pie"></div>
						<div class="chart-noresult hide">该时间范围内，无可用数据...</div>
						<div class="card-mask">
							<div class="spinner-border"></div>
						</div>
					</div>
				</div>
				<div class="col-md-12 col-lg-6">
					<div class="c-table-table">
						<table class="table table-one">
							<thead>
								<tr>
									<th>时间</th>
									<th>第一</th>
									<th>第二</th>
									<th>第三</th>
								</tr>
							</thead>
							<tbody></tbody>
						</table>
					</div>
				</div>
			</div>
			
			
			<div class="row chart-n-item">
				<div class="col-md-12 col-lg-6">
					<div class="card">
						<div class="card-chart card-pie-2"></div>
						<div class="chart-noresult hide">该时间范围内，无可用数据...</div>
						<div class="card-mask">
							<div class="spinner-border"></div>
						</div>
					</div>
				</div>
				<div class="col-md-12 col-lg-6">
					<div class="c-table-table">
						<table class="table table-two">
							<thead>
								<tr>
									<th>时间</th>
									<th>第一</th>
									<th>第二</th>
									<th>第三</th>
								</tr>
							</thead>
							<tbody></tbody>
						</table>
					</div>
				</div>
			</div>
			
			
			<div class="row chart-n-item">
				<div class="col-md-12 col-lg-6">
					<div class="card">
						<div class="card-chart card-pie-3"></div>
						<div class="chart-noresult hide">该时间范围内，无可用数据...</div>
						<div class="card-mask">
							<div class="spinner-border"></div>
						</div>
					</div>
				</div>
				<div class="col-md-12 col-lg-6">
					<div class="c-table-table">
						<table class="table table-three">
							<thead>
								<tr>
									<th>时间</th>
									<th>第一</th>
									<th>第二</th>
									<th>第三</th>
								</tr>
							</thead>
							<tbody></tbody>
						</table>
					</div>
				</div>
			</div>
			
			<div class="row chart-n-item">
				<div class="col-md-12 col-lg-6">
					<div class="card">
						<div class="card-chart card-pie-4"></div>
						<div class="chart-noresult hide">该时间范围内，无可用数据...</div>
						<div class="card-mask">
							<div class="spinner-border"></div>
						</div>
					</div>
				</div>
				<div class="col-md-12 col-lg-6">
					<div class="c-table-table">
						<table class="table table-four">
							<thead>
								<tr>
									<th>时间</th>
									<th>第一</th>
									<th>第二</th>
									<th>第三</th>
								</tr>
							</thead>
							<tbody></tbody>
						</table>
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
			var instance = echarts.init($el[0]);
			instance.setOption(option);
			return instance;
		}

		function generatePieChart($el, type, name) {			
			$.ajax({
				url: "${APP_PATH}/CrmProductSellInfo/GetProductSellInfoVoByRangeTimePlatformBrandName",
				type: "post",
				dataType: "json",
				contentType: 'application/json',
				data: JSON.stringify({
					'productsellinfoPlatformName': type,
					'productsellinfoBrandname': name,
					'productsellinfoProductselltime': $('#search-start-time').val(),
					'productsellinfoMotifytime': $('#search-end-time').val(),
				}),
				success: function (data) {
					if (data.code == 100) {
						transformPieChart($el, data.extend.returnMsg, name);
					} else {
						toastr.error(data.extend.resMsg);
					}
				},
				error: function () {
					toastr.error('Failed to get data, please refresh the page to get again！');
				}
			});
		}

		function transformPieChart($cardPie, data, name) {
			var pieData = [];
			data.length && data.forEach(function(item, idx) {
				if (idx < 10) {
					item.length && pieData.push({
						value: item.length,
						name: item[0].productsellinfoProductsku
					});					
				} else {
					var curItem = pieData[10];
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

			if (pieData.length) {
				$cardPie.parent().find('.chart-noresult').addClass('hide');
				var instance = generateChart($cardPie, {
				    title: { text: (name + ' 售卖产品来源（sku）'), left: 'center' },
				    tooltip: { trigger: 'item', formatter: '{a}: {c} ({d}%)' },
				    legend: {  orient: 'vertical', left: 'left', top: 'center' },
				    series: [ { name: '数量', type: 'pie', radius: '50%', data: pieData } ]
				});

				chartInstance.push(instance);
			} else {
				$cardPie.parent().find('.chart-noresult').removeClass('hide');
			}
			$cardPie.parent().find(".card-mask").addClass('hide');
		}
		
		function generateChartWithData() {
			$('.card-mask').removeClass('hide');
			/* arabellaAliexpress */
			generatePieChart($('.card-pie'), 'aliexpress', 'arabellaAliexpress');
			getAllBlockData($('.table-one tbody'), 'aliexpress', 'arabellaAliexpress');
			/* megalook */
			generatePieChart($('.card-pie-2'), 'aliexpress', 'megalookAliexpress');
			getAllBlockData($('.table-two tbody'), 'aliexpress', 'megalookAliexpress');
			/* aliLuminaAliexpress */
			generatePieChart($('.card-pie-3'), 'aliexpress', 'aliLuminaAliexpress');
			getAllBlockData($('.table-three tbody'), 'aliexpress', 'aliLuminaAliexpress');
			/* aliLuminaAliexpress */
			generatePieChart($('.card-pie-4'), 'aliexpress', 'beautyLuminaAliexpress');
			getAllBlockData($('.table-four tbody'), 'aliexpress', 'beautyLuminaAliexpress');
		}

		// init table-list
		function renderTable($el, data) {
			var timeArr = data.productSellInfoFinallDateList;
			var nData = data.returnMsg;
			var htmlStr = '';
			timeArr && timeArr.forEach(function(item, i) {
				htmlStr += '<tr><td>' + timeArr[i] + '</td>' +
					'<td>' + (nData[i] && nData[i][0] ? nData[i][0][0].productsellinfoProductsku + '&nbsp;(<span class="text-red">'+ nData[i][0].length +'</span>)&nbsp;' : '--') + '</td>' +
					'<td>' + (nData[i] && nData[i][1] ? nData[i][1][0].productsellinfoProductsku + '&nbsp;(<span class="text-red">'+ nData[i][0].length +'</span>)&nbsp;' : '--')+ '</td>' +
					'<td>' + (nData[i] && nData[i][2] ? nData[i][2][0].productsellinfoProductsku + '&nbsp;(<span class="text-red">'+ nData[i][0].length +'</span>)&nbsp;' : '--') + '</td>' +
					'</tr>';
			});
			$el.html(htmlStr);
		}

		function getAllBlockData($el, type, name) {
			$('.c-mask').show();
			$.ajax({
				url: "${APP_PATH}/CrmProductSellInfo/GetProductSellInfoByDatePlatformBrandName",
				type: "post",
				dataType: "json",
				contentType: 'application/json',
				data: JSON.stringify({
					'productsellinfoPlatformName': type,
					'productsellinfoBrandname': name,
					'productsellinfoProductselltime': $('#search-start-time').val(),
					'productsellinfoMotifytime': $('#search-end-time').val()
				}),
				success: function (data) {
					if (data.code == 100) {
						renderTable($el, data.extend);
						toastr.success(data.extend.resMsg);
					} else {
						toastr.error(data.extend.resMsg);
					}
				},
				error: function () {
					toastr.error('Failed to get ProductSellInfo table-list, please refresh the page to get again!');
				},
				complete: function () {
					$('.c-mask').hide();
				}
			});
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
			}
		});
		</script>
	</body>
</html>