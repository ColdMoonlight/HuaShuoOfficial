<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% pageContext.setAttribute("APP_PATH" , request.getContextPath()); %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>用户列表</title>
		<jsp:include page="common/backheader.jsp" flush="true"></jsp:include>
	</head>

	<body class="c-app">
		<jsp:include page="layout/backheader.jsp" flush="true"></jsp:include>
		<div class="c-main">
			<div class="c-tab-menu"></div>
			<div class="c-tab-container">
				<div class="c-init">
					<div class="c-option">
						<span class="c-option-title">用户</span>
						<button class="btn btn-primary btn-create">创建</button>
					</div>
					<div class="c-table">
						<div class="c-table-table table-responsive-sm">
							<table class="table">
								<thead>
									<tr>
										<th>id</th>
										<th>名字</th>
										<th>父级</th>
										<th>位置</th>
										<th>URL</th>
										<th>状态</th>
										<th>描述</th>
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
						<span class="c-option-title">创建用户</span>
						<div class="group">
							<button class="btn btn-secondary btn-cancel">取消</button>
							<button class="btn btn-primary btn-save">保存</button>
						</div>
					</div>
					<div class="c-form">
						<div class="row">
							<input id="adminId" hidden>
							<!-- left panel  -->
							<div class="left-panel col-lg-7 col-md-12">
								<div class="card">
									<div class="card-title">
										<div class="card-title-name">通用</div>
									</div>
									<div class="card-body">
										<div class="form-group">
											<label class="col-form-label" for="adminName">用户名字</label>
											<div class="controls">
												<input class="form-control" id="adminName" type="text" />
											</div>
										</div>
									</div>
									<div class="form-group row">
										<label class="col-md-3 col-form-label" for="adminStatus">状态</label>
										<div class="controls col-md-3">
											<label class="c-switch c-switch-primary">
												<input class="c-switch-input" id="adminStatus" type="checkbox">
												<span class="c-switch-slider"></span>
											</label>
										</div>
									</div>
									<div class="form-group">
										<label class="col-form-label" for="catalogUrl">URL</label>
										<div class="controls">
											<input class="form-control" id="catalogUrl" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-form-label" for="catalogDesc">描述</label>
										<div class="controls">
											<textarea class="form-control" id="catalogDesc" row="6"></textarea>
										</div>
									</div>
								</div>
							</div>
							<!-- right panel  -->
							<div class="right-panel col-lg-5 col-md-12">							
								<!-- product or subject -->
								<div class="card">
									<div class="card-title">
										<div class="card-title-name">用户列表</div>
									</div>
									<div class="card-body">									
										<div class="form-group">
											<label class="col-form-label" for="catalogParentId">父级用户</label>
											<div class="controls">
												<select class="form-control menu-list" id="catalogParentId"></select>
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
		$(document.body).on('click', '#table-pagination li', function (e) { // pagination a-click
			getTabSearchData($('.c-table-tab-item.active'));
		});
		// create collection
		$('.btn-create').on('click', function () {
			$('.c-create .c-option-title').text('创建用户');

			// init formData
			resetFormData();
			showCreateBlock();
			isCreate = true;
		});
		// edit block
		$(document.body).on('click', '.btn-edit', function (e) {
			var adminId = $(this).data('id');
			getOneBlockData({adminId: adminId}, function(resData) {
				isUpdate = true;
			 	$('.c-create .c-option-title').text('编辑用户');
				showCreateBlock();
				initFormData(resData);
			});			
		});
		// delete block
		$(document.body).on('click', '.btn-delete', function (e) {
			var adminId = parseInt($(this).data('id'));
			$('#deleteModal').find('.modal-title').html('删除用户！');
			$('#deleteModal').modal('show');
			$('#deleteModal .btn-ok').one('click', function () {
				deleteOneBlockData({
					adminId: adminId,
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
			$('#adminId').val('');
			$('#adminName').val('');
			$('#adminStatus').prop('checked', false);
			$('#catalogUrl').val('');
			$('#catalogDesc').val('');			
		}
		// getFormdData
		function getFormData() {
			var data = {};
			data.adminId = parseInt($('#adminId').val());
			data.adminName = $('#adminName').val();
			data.adminStatus = $('#adminStatus').prop('checked') ? 1 : 0;
			data.catalogUrl = $('#catalogUrl').val();
			data.catalogDesc = $('#catalogDesc').val();

			data.catalogParentId =  $('#catalogParentId').val();
			data.catalogParentName = $('#catalogParentId').find('option:selected').data('name');

			return data;
		}
		// initFormData
		function initFormData(data) {
			// init
			$('#adminId').val(data.adminId);
			$('#adminName').val(data.adminName);
			$('#adminStatus').prop('checked', (data.adminStatus > 0 ? data.adminStatus : 0));
			$('#catalogParentId').val(data.catalogParentId);
			$('#catalogUrl').val(data.catalogUrl);
			$('#catalogDesc').val(data.catalogDesc);
		}
		// callback get all data
		function getAllBlockData() {
			$('.c-mask').show();
			var formData = 'pn=' + getPageNum();
			$.ajax({
				url: "${APP_PATH}/CrmAdmin/GetAdminByPage",
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
					toastr.error('Failed to get USER table-list, please refresh the page to get again!');
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
				url: "${APP_PATH}/CrmAdmin/GetOneAdminDetailById",
				type: "post",
				dataType: "json",
				contentType: 'application/json',
				data: JSON.stringify(reqData),
				success: function (data) {
					if (data.code == 100) {
						callback(data.extend.crmAdmin);
						toastr.success(data.extend.resMsg);
					} else {
						toastr.error(data.extend.resMsg);
					}
				},
				error: function () {
					toastr.error('Failed to get USER-data, please refresh the page to get again!');
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
				url: "${APP_PATH}/CrmAdmin/Add",
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
				url: "${APP_PATH}/CrmAdmin/Update",
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
				url: "${APP_PATH}/CrmAdmin/Delete",
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
				htmlStr += '<tr><td>' + data[i].adminId + '</td>' +
					'<td>' + data[i].adminName + '</td>' +
					'<td>' + (data[i].catalogParentId ? data[i].catalogParentName + ' - ' + data[i].catalogParentId : '--')+ '</td>' +
					'<td>' + data[i].catalogFirthNum + '</td>' +
					'<td>' + data[i].catalogUrl + '</td>' +
					'<td><a class="badge '+ (data[i].adminStatus ? 'badge-success': 'badge-danger') +'" href="javascript:;">' + (data[i].adminStatus ? 'enable' : 'disable') + '</a></td>' +
					'<td>' + (data[i].catalogDesc || '--') + '</td>' +
					'<td>' +
						'<button class="btn btn-primary btn-edit" data-id="' + data[i].adminId + '">' +
							'<svg class="c-icon">' +
								'<use xlink:href="${APP_PATH}/static/back/img/svg/free.svg#cil-pencil"></use>' +
							'</svg>' +
						'</button>' +
						'<button class="btn btn-danger btn-delete" data-id="' + data[i].adminId + '">' +
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