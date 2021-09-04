<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% pageContext.setAttribute("APP_PATH" , request.getContextPath()); %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>渠道分析</title>
		<jsp:include page="common/backheader.jsp" flush="true"></jsp:include>
		<link rel="stylesheet" href="${APP_PATH}/static/back/lib/datetimepicker/daterangepicker.css">	
	</head>

	<body class="c-app">
		<jsp:include page="layout/backheader.jsp" flush="true"></jsp:include>
		<div class="c-main">
			<div class="c-tab-menu"></div>
			<div class="c-tab-container">
				<div class="c-init">
					<div class="c-option">
						<span class="c-option-title">渠道</span>
						<button class="btn btn-primary btn-create">创建</button>
					</div>
					<div class="c-excel-btns" style="margin-top: 1rem">
						<button class="btn btn-secondary" id="btn-export-tpl">导出模板</button>
						<button class="btn btn-info" id="btn-import-data">批量导入</button>
						<button class="btn btn-primary" id="btn-export-data">导出数据</button>
					</div>
					<div class="c-table">
						<div class="c-table-table table-responsive-sm">
							<table class="table">
								<thead>
									<tr>
										<th>id</th>
										<th>网站</th>
										<th>渠道</th>
										<th>投入</th>
										<th>产出</th>
										<th>成交订单</th>
										<th>流量</th>
										<th>用户总数</th>
										<th>新用户数</th>
										<th>时间</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody></tbody>
							</table>
						</div>
						<div id="table-pagination"></div>
					</div>
				</div>
				<!-- edit or create -->
				<div class="c-create hide">
					<div class="c-option">
						<span class="c-option-title">创建渠道</span>
						<div class="group">
							<button class="btn btn-secondary btn-cancel">取消</button>
							<button class="btn btn-primary btn-save">保存</button>
						</div>
					</div>
					<div class="c-form">
						<div class="row">
							<input id="webanalyticsId" hidden>
							<!-- left panel  -->
							<div class="left-panel col-lg-7 col-md-12">
								<div class="card">
									<div class="card-title">
										<div class="card-title-name">数据</div>
									</div>
									<div class="card-body">
										<div class="form-group">
											<label class="col-form-label" for="webanalyticsChannelinvestmoney">投入</label>
											<div class="controls">
												<input class="form-control" id="webanalyticsChannelinvestmoney" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-form-label" for="webanalyticsChannelsellmoney">产出</label>
											<div class="controls">
												<input class="form-control" id="webanalyticsChannelsellmoney" type="text" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-form-label" for="webanalyticsChannelflowlnum">流量</label>
											<div class="controls">
												<input class="form-control" id="webanalyticsChannelflowlnum" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-form-label" for="webanalyticsChannelsellnum">成交单数</label>
											<div class="controls">
												<input class="form-control" id="webanalyticsChannelsellnum" type="text" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-form-label" for="webanalyticsChannelintousernum">用户总数</label>
											<div class="controls">
												<input class="form-control" id="webanalyticsChannelintousernum" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-form-label" for="webanalyticsChannelintousernewnum">新用户数</label>
											<div class="controls">
												<input class="form-control" id="webanalyticsChannelintousernewnum" type="text" />
											</div>
										</div>
									</div>
								</div>
								<div class="card">
									<div class="card-title">
										<div class="card-title-name">时间</div>
									</div>
									<div class="card-body">									
										<div class="form-group">
											<label class="col-form-label" for="webanalyticsCreatetime">时间</label>
											<div class="controls">
												<input type="text" class="form-control datetimepicker" id="webanalyticsCreatetime" placeholder="@exmaple 2020-01-01 12:00:00" autocomplete="off"  />
											</div>
										</div>
									</div>
								</div>
							</div>
							<!-- right panel  -->
							<div class="right-panel col-lg-5 col-md-12">							
								<!-- product or subject -->
								<div class="card">
									<div class="card-title">
										<div class="card-title-name">归属（渠道 & 网站）</div>
									</div>
									<div class="card-body">									
										<div class="form-group">
											<label class="col-form-label" for="webanalyticsBrandname">网站</label>
											<div class="controls">
												<input class="form-control" id="webanalyticsBrandname" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-form-label" for="webanalyticsChannelname">渠道</label>
											<div class="controls">
												<input class="form-control" id="webanalyticsChannelname" type="text" />
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- mask -->
				<div class="c-mask">
					<div class="spinner-border"></div>
				</div>
			</div>
		</div>
		<jsp:include page="layout/backfooter.jsp" flush="true"></jsp:include>

		<!-- common script  -->
		<jsp:include page="common/backfooter.jsp"></jsp:include>
		<jsp:include page="modal/deleteModal.jsp"></jsp:include>
		<jsp:include page="modal/datetimerangeModal.jsp"></jsp:include>
		<jsp:include page="common/backsidebar.jsp"></jsp:include>
		<!-- other -->
		<script type="text/javascript" src="${APP_PATH}/static/back/lib/datetimepicker/moment.min.js"></script>
		<script type="text/javascript" src="${APP_PATH}/static/back/lib/datetimepicker/daterangepicker.js"></script>
		<!-- custom script -->
		<script type="text/javascript">
		var isCreate = false;
		var isUpdate = false;
		// init
		getAllBlockData();
		bindDateRangeEvent(function(startTime, endTime) {
			$('#search-start-time').val(startTime);
			$('#search-end-time').val(endTime);
		});
		bindDateTimepicker();

		$(document.body).on('click', '#table-pagination li', function (e) { // pagination a-click
			getAllBlockData();
		});
		// create collection
		$('.btn-create').on('click', function () {
			$('.c-create .c-option-title').text('创建渠道');

			// init formData
			resetFormData();
			showCreateBlock();
			isCreate = true;
		});
		// edit block
		$(document.body).on('click', '.btn-edit', function (e) {
			var webanalyticsId = $(this).data('id');
			getOneBlockData({webanalyticsId: webanalyticsId}, function(resData) {
				isUpdate = true;
			 	$('.c-create .c-option-title').text('编辑渠道');
				showCreateBlock();
				initFormData(resData);
			});			
		});
		// delete block
		$(document.body).on('click', '.btn-delete', function (e) {
			var webanalyticsId = parseInt($(this).data('id'));
			$('#deleteModal').find('.modal-title').html('删除渠道！');
			$('#deleteModal').modal('show');
			$('#deleteModal .btn-ok').one('click', function () {
				deleteOneBlockData({
					webanalyticsId: webanalyticsId,
				}, function() {
					getAllBlockData();
				});
			});
		});
		// save block
		$('.c-create .btn-save').on('click', function () {
			function resetBlock() {
				// redirect tab-active & then search-data
				if (isCreate) isCreate = false;
				getAllBlockData();
				showInitBlock();
			}

			if (isUpdate) {
				updateOneBlockData(getFormData(), function() {
					initSideBarMenu();
					resetBlock();
				});
			}

			if (isCreate) {				
				insertOneBlockData(getFormData(), function() {
					initSideBarMenu();
					resetBlock();
				});
			}
		});
		// cancel blocks save
		$('.c-create .btn-cancel').on('click', function () {
			isCreate = false;
			isUpdate = false;

			showInitBlock();
		});
		// import/export callback
		$('#btn-export-tpl').on('click', function() {
			window.location.href = '${APP_PATH}/ExcelImport/ExportWebanalyticsImportDemo';
		});
		$('#btn-import-data').on('click', function() {
			function importExcelData(reqData) {
				$('.c-mask').show();
				$.ajax({
					url: "${APP_PATH}/ExcelImport/ImportWebanalytics",
					type: "post",
					data: reqData,
					processData: false,
					contentType: false,
					cache: false,
					success: function (data) {
						getAllBlockData();						
					},
					error: function (err) {
						toastr.error(err);
					},
					complete: function () {
						$('.c-mask').hide();
					}
				});
			}
			var $inputFile = $('<input type="file" accept=".xlsx,.xls"/>');
			var formData = new FormData();

			$inputFile.click(); // trigger input-file evt
			$inputFile.on('change', function() {
				formData.append('file', $inputFile[0].files[0]);
				formData.append('name', $inputFile.val());
				importExcelData(formData);				
			})
		});
		$('#btn-export-data').on('click', function() {
			function initDateRage(start, end) {
				$('#startTime').val(start);
				$('#endTime').val(end);
			}
			// init
			var date = new Date();
			var ymd = date.getFullYear() + '-' + (date.getMonth() + 1 > 9 ? date.getMonth() + 1 : '0' + (date.getMonth() + 1)) + '-' + (date.getDate() > 9 ? date.getDate() : '0' + date.getDate());

			initDateRage(ymd + ' 00:00:00', ymd + ' 23:59:59');
			$('#datetimerangeModal').find('.modal-title').html("导出渠道数据").end().modal('show');
		});
		$('#datetimerangeModal .btn-ok').on('click', function() {
			var startTime = $('#startTime').val(),
				endTime = $('#endTime').val();
			window.location.href = '${APP_PATH}/ExcleDownload/exportWebanalyticsInfo?webanalyticsCreatetime='+ startTime +'&webanalyticsMotifytime=' + endTime;
			setTimeout(function(){ $('#datetimerangeModal').modal('hide'); },0);
		});
		function showCreateBlock() {
			$('.c-init').addClass('hide');
			$('.c-create').removeClass('hide');
		}
		function showInitBlock() {
			$('.c-init').removeClass('hide');
			$('.c-create').addClass('hide');
		}
		// handle formData
		// reset data
		function resetFormData() {
			$('#webanalyticsId').val('');
			$('#webanalyticsChannelinvestmoney').val('');
			$('#webanalyticsChannelsellmoney').val('');
			$('#webanalyticsChannelsellnum').val('');
			$('#webanalyticsChannelflowlnum').val('');
			$('#webanalyticsChannelintousernum').val('');
			$('#webanalyticsChannelintousernewnum').val('');

			$('#webanalyticsCreatetime').val('');
			
			$('#webanalyticsBrandname').val('');
			$('#webanalyticsChannelname').val('');
		}
		// getFormdData
		function getFormData() {
			var data = {};
			data.webanalyticsId = parseInt($('#webanalyticsId').val());
			data.webanalyticsChannelinvestmoney = $('#webanalyticsChannelinvestmoney').val();
			data.webanalyticsChannelsellmoney = $('#webanalyticsChannelsellmoney').val();
			data.webanalyticsChannelsellnum = $('#webanalyticsChannelsellnum').val();
			data.webanalyticsChannelflowlnum = $('#webanalyticsChannelflowlnum').val();
			data.webanalyticsChannelintousernum = $('#webanalyticsChannelintousernum').val();
			data.webanalyticsChannelintousernewnum = $('#webanalyticsChannelintousernewnum').val();

			data.webanalyticsCreatetime = $('#webanalyticsCreatetime').val();

			data.webanalyticsBrandname = $('#webanalyticsBrandname').val();
			data.webanalyticsChannelname = $('#webanalyticsChannelname').val();

			return data;
		}
		// initFormData
		function initFormData(data) {
			// init
			$('#webanalyticsId').val(data.webanalyticsId);
			$('#webanalyticsChannelinvestmoney').val(data.webanalyticsChannelinvestmoney);
			$('#webanalyticsChannelsellmoney').val(data.webanalyticsChannelsellmoney);
			$('#webanalyticsChannelsellnum').val(data.webanalyticsChannelsellnum);
			$('#webanalyticsChannelflowlnum').val(data.webanalyticsChannelflowlnum);
			$('#webanalyticsChannelintousernum').val(data.webanalyticsChannelintousernum);
			$('#webanalyticsChannelintousernewnum').val(data.webanalyticsChannelintousernewnum);
			
			$('#webanalyticsCreatetime').val(data.webanalyticsCreatetime);

			$('#webanalyticsChannelname').val(data.webanalyticsChannelname);
			$('#webanalyticsBrandname').val(data.webanalyticsBrandname);
		}
		// callback get all data
		function getAllBlockData() {
			$('.c-mask').show();
			var formData = 'pn=' + getPageNum();
			$.ajax({
				url: "${APP_PATH}/CrmWebanalytics/GetCrmWebanalyticsByPage",
				type: "post",
				data: formData,
				success: function (data) {
					if (data.code == 100) {
						renderTable(data.extend.pageInfo.list);
						renderTablePagination(data.extend.pageInfo);
						toastr.success(data.extend.resMsg);
					} else {
						toastr.error(data.extend.resMsg);
					}
				},
				error: function () {
					toastr.error('Failed to get Analytics table-list, please refresh the page to get again!');
				},
				complete: function () {
					$('.c-mask').hide();
				}
			});
		}
		// callback get one data
		function getOneBlockData(reqData, callback) {
			$('.c-mask').show();
			$.ajax({
				url: "${APP_PATH}/CrmWebanalytics/GetOneCrmWebanalyticsDetailById",
				type: "post",
				dataType: "json",
				contentType: 'application/json',
				data: JSON.stringify(reqData),
				success: function (data) {
					if (data.code == 100) {
						callback(data.extend.crmWebanalytics);
						toastr.success(data.extend.resMsg);
					} else {
						toastr.error(data.extend.resMsg);
					}
				},
				error: function () {
					toastr.error('Failed to get Analytics-data, please refresh the page to get again!');
				},
				complete: function () {
					$('.c-mask').hide();
				}
			});
		}
		// callback insert
		function insertOneBlockData(reqData, callback) {
			$('.c-mask').show();
			$.ajax({
				url: "${APP_PATH}/CrmWebanalytics/Add",
				type: "post",
				cache: false,
				dataType: "json",
				contentType: 'application/json',
				data: JSON.stringify(reqData),
				success: function (data) {
					if (data.code == 100) {
						toastr.success(data.extend.resMsg);
						callback();
					} else {
						toastr.error(data.extend.resMsg);
					}
				},
				error: function (err) {
					toastr.error(err);
				},
				complete: function () {
					$('.c-mask').hide();
				}
			});
		}
		// callback update
		function updateOneBlockData(reqData, callback) {
			$('.c-mask').show();
			$.ajax({
				url: "${APP_PATH}/CrmWebanalytics/Update",
				type: "post",
				cache: false,
				dataType: "json",
				contentType: 'application/json',
				data: JSON.stringify(reqData),
				success: function (data) {
					if (data.code == 100) {
						toastr.success(data.extend.resMsg);
						callback && callback();
					} else {
						toastr.error(data.extend.resMsg);
					}
				},
				error: function (err) {
					toastr.error(err);
				},
				complete: function () {
					$('.c-mask').hide();
				}
			});
		}
		// callback delete
		function deleteOneBlockData(reqData, callback) {
			$('.c-mask').show();
			$.ajax({
				url: "${APP_PATH}/CrmWebanalytics/Delete",
				type: "post",
				cache: false,
				dataType: "json",
				contentType: 'application/json',
				data: JSON.stringify(reqData),
				success: function (data) {
					if (data.code == 100) {
						toastr.success(data.extend.resMsg);
						$('#deleteModal').modal('hide');
						callback();
					} else {
						toastr.error(data.extend.resMsg);
					}
				},
				error: function (err) {
					toastr.error(err);
				},
				complete: function () {
					$('.c-mask').hide();
				}
			});
		}
		// init table-list
		function renderTable(data) {
			var htmlStr = '';
			for (var i = 0, len = data.length; i < len; i += 1) {
				htmlStr += '<tr><td>' + data[i].webanalyticsId + '</td>' +
					'<td>' + data[i].webanalyticsBrandname + '</td>' +
					'<td>' + data[i].webanalyticsChannelname + '</td>' +
					'<td>' + data[i].webanalyticsChannelinvestmoney + '</td>' +
					'<td>' + data[i].webanalyticsChannelsellmoney + '</td>' +
					'<td>' + data[i].webanalyticsChannelsellnum + '</td>' +
					'<td>' + data[i].webanalyticsChannelflowlnum + '</td>' +
					'<td>' + data[i].webanalyticsChannelintousernum + '</td>' +
					'<td>' + data[i].webanalyticsChannelintousernewnum + '</td>' +
					'<td>' + data[i].webanalyticsCreatetime + '</td>' +					
					'<td>' +
						'<button class="btn btn-primary btn-edit" data-id="' + data[i].webanalyticsId + '">' +
							'<svg class="c-icon">' +
								'<use xlink:href="${APP_PATH}/static/back/img/svg/free.svg#cil-pencil"></use>' +
							'</svg>' +
						'</button>' +
						'<button class="btn btn-danger btn-delete" data-id="' + data[i].webanalyticsId + '">' +
							'<svg class="c-icon">' +
								'<use xlink:href="${APP_PATH}/static/back/img/svg/free.svg#cil-trash"></use>' +
							'</svg>' +
						'</button>' +
					'</td></tr>';
			}
			$('.c-table-table tbody').html(htmlStr);
		}
		</script>
	</body>
</html>