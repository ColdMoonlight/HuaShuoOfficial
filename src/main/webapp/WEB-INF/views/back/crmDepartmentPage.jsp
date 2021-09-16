<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% pageContext.setAttribute("APP_PATH" , request.getContextPath()); %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>部门列表</title>
		<jsp:include page="common/backheader.jsp" flush="true"></jsp:include>
	</head>

	<body class="c-app">
		<jsp:include page="layout/backheader.jsp" flush="true"></jsp:include>
		<div class="c-main">
			<div class="c-tab-menu"></div>
			<div class="c-tab-container">
				<div class="c-init">
					<div class="c-option">
						<span class="c-option-title">部门</span>
						<button class="btn btn-primary btn-create">创建</button>
					</div>
					<div class="c-table">
						<div class="c-table-table table-responsive-sm">
							<table class="table">
								<thead>
									<tr>
										<th>id</th>
										<th>部门名字</th>
										<th>部门sql名</th>
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
						<span class="c-option-title">创建部门</span>
						<div class="group">
							<button class="btn btn-secondary btn-cancel">取消</button>
							<button class="btn btn-primary btn-save">保存</button>
						</div>
					</div>
					<div class="c-form">
						<div class="row">
							<input id="departmentId" hidden>
							<!-- left panel  -->
							<div class="left-panel col-lg-7 col-md-12">
								<div class="card">
									<div class="form-group">
										<label class="col-form-label" for="departmentName">部门名字</label>
										<div class="controls">
											<input class="form-control" id="departmentName" type="text" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-form-label" for="departmentSqlName">部门名字</label>
										<div class="controls">
											<input class="form-control" id="departmentSqlName" type="text" />
										</div>
									</div>
								</div>
							</div>
							<!-- right panel  -->
							<div class="right-panel col-lg-5 col-md-12">							
								
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

		// create collection
		$('.btn-create').on('click', function () {
			$('.c-create .c-option-title').text('创建部门');

			// init formData
			resetFormData();
			showCreateBlock();
			isCreate = true;
		});
		// edit block
		$(document.body).on('click', '.btn-edit', function (e) {
			var departmentId = $(this).data('id');
			getOneBlockData({departmentId: departmentId}, function(resData) {
				isUpdate = true;
			 	$('.c-create .c-option-title').text('编辑部门');
				showCreateBlock();
				initFormData(resData);
			});			
		});
		// delete block
		$(document.body).on('click', '.btn-delete', function (e) {
			var departmentId = parseInt($(this).data('id'));
			$('#deleteModal').find('.modal-title').html('删除部门！');
			$('#deleteModal').modal('show');
			$('#deleteModal .btn-ok').one('click', function () {
				deleteOneBlockData({
					departmentId: departmentId,
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
			$('#departmentId').val('');
			$('#departmentName').val('');		
		}
		// getFormdData
		function getFormData() {
			var data = {};
			data.departmentId = parseInt($('#departmentId').val());
			data.departmentName = $('#departmentName').val();
			data.departmentSqlName = $('#departmentSqlName').val();
			return data;
		}
		// initFormData
		function initFormData(data) {
			// init
			$('#departmentId').val(data.departmentId);
			$('#departmentName').val(data.departmentName);
			$('#departmentSqlName').val(data.departmentSqlName);
		}
		// callback get all data
		function getAllBlockData() {
			$('.c-mask').show();
			$.ajax({
				url: "${APP_PATH}/CrmDepartment/GetAllDepartmentInfo",
				type: "get",
				success: function (data) {
					if (data.code == 100) {
						renderTable(data.extend.crmDepartmentList);
						toastr.success(data.extend.resMsg);
					} else {
						toastr.error(data.extend.resMsg);
					}
				},
				error: function () {
					toastr.error('Failed to get DEPARTMENT table-list, please refresh the page to get again!');
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
				url: "${APP_PATH}/CrmDepartment/GetOneDepartmentDetailById",
				type: "post",
				dataType: "json",
				contentType: 'application/json',
				data: JSON.stringify(reqData),
				success: function (data) {
					if (data.code == 100) {
						callback(data.extend.crmDepartment);
						toastr.success(data.extend.resMsg);
					} else {
						toastr.error(data.extend.resMsg);
					}
				},
				error: function () {
					toastr.error('Failed to get DEPARTMENT data, please refresh the page to get again!');
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
				url: "${APP_PATH}/CrmDepartment/Add",
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
				url: "${APP_PATH}/CrmDepartment/Update",
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
				url: "${APP_PATH}/CrmDepartment/Delete",
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
				htmlStr += '<tr><td>' + data[i].departmentId + '</td>' +
					'<td>' + data[i].departmentName + '</td>' +
					'<td>' + data[i].departmentSqlName + '</td>' +
					'<td>' +
						'<button class="btn btn-primary btn-edit" data-id="' + data[i].departmentId + '">' +
							'<svg class="c-icon">' +
								'<use xlink:href="${APP_PATH}/static/back/img/svg/free.svg#cil-pencil"></use>' +
							'</svg>' +
						'</button>' +
						'<button class="btn btn-danger btn-delete" data-id="' + data[i].departmentId + '">' +
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