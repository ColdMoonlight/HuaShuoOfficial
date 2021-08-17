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
										<th>昵称</th>
										<th>账号</th>
										<th>部门</th>
										<th>店铺</th>
										<th>状态</th>
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
											<label class="col-form-label" for="adminName">昵称</label>
											<div class="controls">
												<input class="form-control" id="adminName" type="text" />
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
									</div>
								</div>
								
							</div>
							<!-- right panel  -->
							<div class="right-panel col-lg-5 col-md-12">								
								<div class="card">
									<div class="card-title">
										<div class="card-title-name">账号 & 密码</div>
									</div>
									<div class="card-body">
										<div class="form-group">
											<label class="col-form-label" for="adminAccount">账号</label>
											<div class="controls">
												<input class="form-control" id="adminAccount" type="text" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-form-label" for="adminPassword">密码</label>
											<div class="controls">
												<input class="form-control" id="adminPassword" type="text" />
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-lg-12 col-md-12">
								<div class="card">
									<div class="card-title">
										<div class="card-title-name">所属部门  & 分管店铺  & 菜单权限</div>
									</div>
									<div class="card-body">
										<ul class="nav nav-tabs" role="tablist">
											<li role="presentation" class="nav-item active">
										  		<div class="nav-link" role="tab" data-toggle="tab" data-target="#department">部门</div>
										  	</li>
										  	<li role="presentation" class="nav-item">
										  		<div class="nav-link" role="tab" data-toggle="tab" data-target="#shoproom">店铺</div>
										  	</li>
										  	<li role="presentation" class="nav-item">
										  		<div class="nav-link" role="tab" data-toggle="tab" data-target="#menurole">菜单权限</div>
										  	</li>
										</ul>
										<div class="tab-content">
											<div class="tab-pane active" id="department" role="tabpanel">
												<div class="department-radio-box"></div>
											</div>
											<div class="tab-pane fade" id="shoproom" role="tabpanel">
												<div class="shoproom-radio-box"></div>
											</div>
											<div class="tab-pane fade" id="menurole" role="tabpanel">
												<input hidden name="adminMenuIdstr" id="adminMenuIdstr" />
												<input hidden name="adminMenuNamestr" id="adminMenuNamestr" />
												<input hidden name="adminMenuUrlstr" id="adminMenuUrlstr" />
												<div class="menu-checkbox table-responsive-sm">
													<table class="table">
														<thead>
															<tr>
																<th>操作</th>
																<th>父级</th>
																<th>菜单名</th>
															</tr>
														</thead>
														<tbody></tbody>
													</table>
												</div>
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
		getAllDepartmentData(renderDepartmentList);
		getAllShoproomData(renderShoproomList);
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

			resetFormData();
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
		// menu checkbox
		$('.menu-checkbox').on('change', '.menu-checkbox-input', function() {
			var $this = $(this);

			var menuIdArr = $('#adminMenuIdstr').val() ? $('#adminMenuIdstr').val().split(',') : [];
			var menuNameArr = $('#adminMenuNamestr').val() ? $('#adminMenuNamestr').val().split(',') : [];
			var menuUrlArr = $('#adminMenuUrlstr').val() ? $('#adminMenuUrlstr').val().split(',') : [];
			var curId = $this.data('id');
			var curIdx = menuIdArr.indexOf(''+curId);

			if ($this.prop('checked') && curIdx < 0) {
				menuIdArr.push(curId);
				menuNameArr.push($this.data('name'));
				menuUrlArr.push($this.data('url'));
			}

			if (!$this.prop('checked') && curIdx > -1) {
				menuIdArr.splice(curIdx, 1);
				menuNameArr.splice(curIdx, 1);
				menuUrlArr.splice(curIdx, 1);
			}
			$('#adminMenuIdstr').val(menuIdArr.join(','));
			$('#adminMenuNamestr').val(menuNameArr.join(','));
			$('#adminMenuUrlstr').val(menuUrlArr.join(','));
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
			$('#adminAccount').val('');
			$('#adminPassword').val('');
			$('input[name=department]').prop('checked', false);
			$('input[name=shoproom]').prop('checked', false);
			$('.nav-link').eq(0).click();
			$('.menu-checkbox-input').prop('checked', false);
			$('#adminMenuIdstr').val('');
			$('#adminMenuNamestr').val('');
			$('#adminMenuUrlstr').val('');
		}
		// getFormdData
		function getFormData() {
			var data = {};
			data.adminId = parseInt($('#adminId').val());
			data.adminName = $('#adminName').val();
			data.adminStatus = $('#adminStatus').prop('checked') ? 1 : 0;
			data.adminAccount = $('#adminAccount').val();
			data.adminPassword = $('#adminPassword').val();

			var department_kv =  $("input[name=department]:checked").val() && $("input[name=department]:checked").val().split('-') || [];
			data.adminDepartmentId =  parseInt(department_kv[0]);
			data.adminDepartmentName = department_kv[1];

			var shoproom_kv = $("input[name=shoproom]:checked").val() && $("input[name=shoproom]:checked").val().split('-') || [];
			data.adminShopId =  parseInt(shoproom_kv[0]);
			data.adminShopName = shoproom_kv[1];
			
			data.adminMenuIdstr = $('#adminMenuIdstr').val();
			data.adminMenuNamestr = $('#adminMenuNamestr').val();
			data.adminMenuUrlstr = $('#adminMenuUrlstr').val();

			return data;
		}
		// initFormData
		function initFormData(data) {
			function initMenuCheckbox(idArr) {
				idArr.forEach(function(item) { $('.menu-checkbox-input[data-id='+ item +']').prop('checked', true); });
			}
			// init
			$('#adminId').val(data.adminId);
			$('#adminName').val(data.adminName);
			$('#adminStatus').prop('checked', (data.adminStatus > 0 ? data.adminStatus : 0));
			$('#adminAccount').val(data.adminAccount);
			$('#adminPassword').val(data.adminPassword);

			$('#department' + data.adminDepartmentId).prop('checked', true);
			$('#shoproom' + data.adminShopId).prop('checked', true);
			
			$('#adminMenuIdstr').val(data.adminMenuIdstr);
			$('#adminMenuNamestr').val(data.adminMenuNamestr);
			$('#adminMenuUrlstr').val(data.adminMenuUrlstr);
			
			initMenuCheckbox(data.adminMenuIdstr ? data.adminMenuIdstr.split(',') : []);
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
		// callback get all department data
		function getAllDepartmentData(callback) {
			$('.c-mask').show();
			$.ajax({
				url: "${APP_PATH}/CrmDepartment/GetAllDepartmentInfo",
				type: "get",
				success: function (data) {
					if (data.code == 100) {
						callback && callback(data.extend.crmDepartmentList);
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
					'<td>' + data[i].adminAccount + '</td>' +
					'<td>' + (data[i].adminDepartmentName ? data[i].adminDepartmentName + ' - ' + data[i].adminDepartmentId : '--') + '</td>' +
					'<td>' + (data[i].adminDepartmentName ? data[i].adminShopName + ' - ' + data[i].adminShopId : '--') + '</td>' +
					'<td><a class="badge '+ (data[i].adminStatus ? 'badge-success': 'badge-danger') +'" href="javascript:;">' + (data[i].adminStatus ? 'enable' : 'disable') + '</a></td>' +
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
		// render department list
		function renderDepartmentList(data) {
			var htmlStr = '';
			for (var i = 0; i < data.length; i += 1) {
				htmlStr += '<div class="form-check">' +
				  '<input class="form-check-input" id="department'+ data[i].departmentId +'" type="radio" name="department" value="' + data[i].departmentId + '-' + data[i].departmentName + '">' +
				  '<label class="form-check-label" for="department'+ data[i].departmentId +'">' + data[i].departmentName + '</label>' +
				'</div>';
			}
			$('.department-radio-box').html(htmlStr);
		}
		// render shoproom list
		function renderShoproomList(data) {
			var htmlStr = '';
			for (var i = 0; i < data.length; i += 1) {
				htmlStr += '<div class="form-check">' +
				  '<input class="form-check-input" id="shoproom'+ data[i].shoproomId +'" type="radio" name="shoproom" value="' + data[i].shoproomId + '-' + data[i].shoproomName + '">' +
				  '<label class="form-check-label" for="shoproom'+ data[i].shoproomId +'">' + data[i].shoproomName + '</label>' +
				'</div>';
			}
			$('.shoproom-radio-box').html(htmlStr);
		}
		// render menu-role tables
		</script>
	</body>
</html>