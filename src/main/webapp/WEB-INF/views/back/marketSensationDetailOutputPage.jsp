<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% pageContext.setAttribute("APP_PATH" , request.getContextPath()); %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>红人产出明细</title>
		<jsp:include page="common/backheader.jsp" flush="true"></jsp:include>
	</head>

	<body class="c-app">
		<jsp:include page="layout/backheader.jsp" flush="true"></jsp:include>
		<div class="c-main">
			<div class="c-tab-menu"></div>
			<div class="c-tab-container">
				<div class="c-init">
					<div class="c-option">
						<span class="c-option-title">红人产出明细</span>
						<button class="btn btn-primary btn-create">创建</button>
					</div>
					<div class="c-table">
						<div class="c-table-table table-responsive-sm">
							<table class="table">
								<thead>
									<tr>
										<th>id</th>
										<th>红人</th>
										<th>产品</th>
										<th>单号</th>
										<th>产出</th>
										<th>归属店铺</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody></tbody>
							</table>
						</div>
					</div>
				</div>
				<!-- edit or create -->
				<div class="c-create hide">
					<div class="c-option">
						<span class="c-option-title">创建数据</span>
						<div class="group">
							<button class="btn btn-secondary btn-cancel">取消</button>
							<button class="btn btn-primary btn-save">保存</button>
						</div>
					</div>
					<div class="c-form">
						<div class="row">
							<input id="sensationdetailoutputId" hidden>
							<!-- left panel  -->
							<div class="left-panel col-lg-7 col-md-12">
								<div class="card">
									<div class="card-title">
										<div class="card-title-name">通用</div>
									</div>
									<div class="card-body">
										<div class="form-group">
											<label class="col-form-label" for="sensationdetailoutputSensationinfoid">红人ID</label>
											<div class="controls">
												<input class="form-control" id="sensationdetailoutputSensationinfoid" type="text" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-form-label" for="sensationdetailoutputSensationinfoname">红人名字</label>
											<div class="controls">
												<input class="form-control" id="sensationdetailoutputSensationinfoname" type="text" />
											</div>
										</div>	
										<div class="form-group">
											<label class="col-form-label" for="sensationdetailoutputProduct">产品名</label>
											<div class="controls">
												<input class="form-control" id="sensationdetailoutputProduct" type="text" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-form-label" for="sensationdetailoutputResourcelink">资源链接</label>
											<div class="controls">
												<input class="form-control" id="sensationdetailoutputResourcelink" type="text" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-form-label" for="sensationdetailoutputOriginallink">产品链接</label>
											<div class="controls">
												<input class="form-control" id="sensationdetailoutputOriginallink" type="text" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-form-label" for="sensationdetailoutputSalesprice">产出</label>
											<div class="controls">
												<input class="form-control" id="sensationdetailoutputSalesprice" type="text" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-form-label" for="sensationdetailoutputPlatenum">单号</label>
											<div class="controls">
												<input class="form-control" id="sensationdetailoutputPlatenum" type="text" />
											</div>
										</div>
									</div>
								</div>
							</div>
							<!-- right panel  -->
							<div class="right-panel col-lg-5 col-md-12">
								<div class="card">
									<div class="card-title">
										<div class="card-title-name">店铺</div>
									</div>
									<div class="card-body">
										<div class="form-group">
											<label class="col-form-label" for="sensationdetailoutputShoproomid">店铺</label>
											<div class="controls">
												<select class="form-control shop-list" id="sensationdetailoutputShoproomid"></select>	
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
		<jsp:include page="common/backsidebar.jsp"></jsp:include>
		<!-- custom script -->
		<script type="text/javascript">
		var isCreate = false;
		var isUpdate = false;

		// init
		getAllBlockData();
		getAllShoproomData(renderShoproomList);
		
		$(document.body).on('click', '#table-pagination li', function (e) { // pagination a-click
			getAllBlockData();
		});

		// create collection
		$('.btn-create').on('click', function () {
			$('.c-create .c-option-title').text('创建红人产出明细');

			// init formData
			resetFormData();
			showCreateBlock();
			isCreate = true;
		});
		// edit block
		$(document.body).on('click', '.btn-edit', function (e) {
			var sensationdetailoutputId = $(this).data('id');
			getOneBlockData({sensationdetailoutputId: sensationdetailoutputId}, function(resData) {
				isUpdate = true;
			 	$('.c-create .c-option-title').text('编辑红人产出明细');
				showCreateBlock();
				initFormData(resData);
			});			
		});
		// delete block
		$(document.body).on('click', '.btn-delete', function (e) {
			var sensationdetailoutputId = parseInt($(this).data('id'));
			$('#deleteModal').find('.modal-title').html('删除红人产出明细！');
			$('#deleteModal').modal('show');
			$('#deleteModal .btn-ok').one('click', function () {
				deleteOneBlockData({
					sensationdetailoutputId: sensationdetailoutputId,
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
			$('#sensationdetailoutputId').val('');
			$('#sensationdetailoutputOriginallink').val('');
			$('#sensationdetailoutputProduct').val('');
			$('#sensationdetailoutputOriginallink').val('');
			$('#sensationdetailoutputResourcelink').val('')
			$('#sensationdetailoutputSalesprice').val('');
			$('#sensationdetailoutputPlatenum').val('');
			
			$('#sensationdetailoutputSensationinfoid').val('');
			$('#sensationdetailoutputSensationinfoname').val('');

			$('#sensationdetailoutputShoproomid').val('-1');			
		}
		// getFormdData
		function getFormData() {
			var data = {};
			data.sensationdetailoutputId = parseInt($('#sensationdetailoutputId').val());
			data.sensationdetailoutputProduct = $('#sensationdetailoutputProduct').val();
			data.sensationdetailoutputOriginallink = $('#sensationdetailoutputOriginallink').val();
			data.sensationdetailoutputResourcelink = $('#sensationdetailoutputResourcelink').val();
			data.sensationdetailoutputSalesprice = $('#sensationdetailoutputSalesprice').val();
			data.sensationdetailoutputPlatenum = $('#sensationdetailoutputPlatenum').val();

			data.sensationdetailoutputSensationinfoid = $('#sensationdetailoutputSensationinfoid').val();
			data.sensationdetailoutputSensationinfoname = $('#sensationdetailoutputSensationinfoname').val();

			data.sensationdetailoutputShoproomid = $('#sensationdetailoutputShoproomid').val();
			data.sensationdetailoutputShoproomname = $('#sensationdetailoutputShoproomid').find('option:selected').data('name');
			return data;
		}
		// initFormData
		function initFormData(data) {
			// init
			$('#sensationdetailoutputId').val(data.sensationdetailoutputId);
			$('#sensationdetailoutputProduct').val(data.sensationdetailoutputProduct);
			$('#sensationdetailoutputOriginallink').val(data.sensationdetailoutputOriginallink);
			$('#sensationdetailoutputResourcelink').val(data.sensationdetailoutputResourcelink);
			$('#sensationdetailoutputSalesprice').val(data.sensationdetailoutputSalesprice);
			$('#sensationdetailoutputPlatenum').val(data.sensationdetailoutputPlatenum);

			$('#sensationdetailoutputSensationinfoid').val(data.sensationdetailoutputSensationinfoid);
			$('#sensationdetailoutputSensationinfoname').val(data.sensationdetailoutputSensationinfoname);

			$('#sensationdetailoutputShoproomid').val(data.sensationdetailoutputShoproomid);
		}
		// callback get all data
		function getAllBlockData() {
			$('.c-mask').show();
			var reqData = { "pn": getPageNum()};
			$.ajax({
				url: "${APP_PATH}/MarketSensationDetailOutput/GetMarketSensationDetailOutputByPage",
				type: "post",
				dataType: "json",
				contentType: 'application/json',
				data: JSON.stringify(reqData),
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
					toastr.error('Failed to get Sensation-details table-list, please refresh the page to get again!');
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
				url: "${APP_PATH}/MarketSensationDetailOutput/GetOneMarketSensationDetailOutputDetailById",
				type: "post",
				dataType: "json",
				contentType: 'application/json',
				data: JSON.stringify(reqData),
				success: function (data) {
					if (data.code == 100) {
						callback(data.extend.marketSensationDetailOutput);
						toastr.success(data.extend.resMsg);
					} else {
						toastr.error(data.extend.resMsg);
					}
				},
				error: function () {
					toastr.error('Failed to get Sensation-details data, please refresh the page to get again!');
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
				url: "${APP_PATH}/MarketSensationDetailOutput/Add",
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
				url: "${APP_PATH}/MarketSensationDetailOutput/Update",
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
				url: "${APP_PATH}/MarketSensationDetailOutput/Delete",
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
				htmlStr += '<tr><td>' + data[i].sensationdetailoutputId + '</td>' +
					'<td>' + (data[i].sensationdetailoutputSensationinfoname || '--') + '</td>' +
					'<td>' + (data[i].sensationdetailoutputProduct || '--') + '</td>' +
					'<td>' + (data[i].sensationdetailoutputPlatenum || '--') + '</td>' +
					'<td>' + (data[i].sensationdetailoutputSalesprice || '--') + '</td>' +
					'<td>' + (data[i].sensationdetailoutputShoproomname || '--') + '</td>' +
					'<td>' +
						'<button class="btn btn-primary btn-edit" data-id="' + data[i].sensationdetailoutputId + '">' +
							'<svg class="c-icon">' +
								'<use xlink:href="${APP_PATH}/static/back/img/svg/free.svg#cil-pencil"></use>' +
							'</svg>' +
						'</button>' +
						'<button class="btn btn-danger btn-delete" data-id="' + data[i].sensationdetailoutputId + '">' +
							'<svg class="c-icon">' +
								'<use xlink:href="${APP_PATH}/static/back/img/svg/free.svg#cil-trash"></use>' +
							'</svg>' +
						'</button>' +
					'</td></tr>';
			}
			$('.c-table-table tbody').html(htmlStr);
		}
		// callback get all shoproom data
		function getAllShoproomData(callback) {
			$('.c-mask').show();
			$.ajax({
				url: "${APP_PATH}/CrmShopRoom/GetAllShopRoomInfo",
				type: "get",
				success: function (data) {
					if (data.code == 100) {
						callback && callback(data.extend.crmShopRoomList);
						toastr.success(data.extend.resMsg);
					} else {
						toastr.error(data.extend.resMsg);
					}
				},
				error: function () {
					toastr.error('Failed to get SHOP-ROOM table-list, please refresh the page to get again!');
				},
				complete: function () {
					$('.c-mask').hide();
				}
			});
		}
		// render shoproom list
		function renderShoproomList(data) {
			var optionStr = '<option value="-1">请选择所属店铺</option>';
			for (var i = 0; i < data.length; i += 1) {
				optionStr += '<option value="'+ data[i].shoproomId +'" data-name="' + data[i].shoproomName + '">' + data[i].shoproomName + '</option>';
			}
			$('.shop-list').html(optionStr);
		}
		</script>
	</body>
</html>