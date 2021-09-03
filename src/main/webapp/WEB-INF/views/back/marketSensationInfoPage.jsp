<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% pageContext.setAttribute("APP_PATH" , request.getContextPath()); %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>红人数据</title>
		<jsp:include page="common/backheader.jsp" flush="true"></jsp:include>	
	</head>

	<body class="c-app">
		<jsp:include page="layout/backheader.jsp" flush="true"></jsp:include>
		<div class="c-main">
			<div class="c-tab-menu"></div>
			<div class="c-tab-container">
				<div class="c-init">
					<div class="c-option">
						<span class="c-option-title">红人数据</span>
						<button class="btn btn-primary btn-create">创建</button>
					</div>
					<div class="c-table">
						<div class="c-table-tab">
							<div class="c-table-tab-item" data-idx="0">All</div>
							<div class="c-table-tab-list"></div>
							<div class="c-table-tab-tempory"></div>
						</div>
						<div class="c-table-content">
							<div class="input-group c-search">
								<svg class="c-icon">
									<use xlink:href="${APP_PATH}/static/back/img/svg/free.svg#cil-magnifying-glass"></use>
								</svg>
								<div class="form-control">
									<input id="search-word" type="text" placeholder="Search ...">
								</div>
								<a class="btn btn-primary input-group-addon btn-save-search">Save search</a>
							</div>
							<div class="c-table-table table-responsive-sm">
								<table class="table">
									<thead>
										<tr>
											<th>id</th>
											<th>红人名</th>
											<th>红人账户</th>
											<th>业务员</th>
											<th>投入-花费</th>
											<th>产出-收益</th>
											<th>产出-单数</th>
											<th>产出-流量</th>
											<th>归属-平台</th>
											<th>归属-店铺</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody></tbody>
								</table>
							</div>
							<div id="table-pagination"></div>
						 </div>
					</div>
				</div>
				<!-- edit or create -->
				<div class="c-create hide">
					<div class="c-option">
						<span class="c-option-title">创建红人数据</span>
						<div class="group">
							<button class="btn btn-secondary btn-cancel">取消</button>
							<button class="btn btn-primary btn-save">保存</button>
						</div>
					</div>
					<div class="c-form">
						<div class="row">
							<input id="sensationinfoId" hidden>
							<!-- left panel  -->
							<div class="left-panel col-lg-7 col-md-12">
								<div class="card">
									<div class="card-title">
										<div class="card-title-name">基本信息</div>
									</div>
									<div class="card-body">									
										<div class="form-group">
											<label class="col-form-label" for="sensationinfoName">红人姓名</label>
											<div class="controls">
												<input class="form-control" id="sensationinfoName" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-form-label" for="sensationinfoAccount">红人账号</label>
											<div class="controls">
												<input class="form-control" id="sensationinfoAccount" type="text" />
											</div>
										</div>
									</div>									
								</div>
								
								<div class="card">
									<div class="card-title">
										<div class="card-title-name">红人数据</div>
									</div>
									<div class="card-body">
										<div class="form-group">
											<label class="col-form-label" for="sensationinfoPrice">投入-花费</label>
											<div class="controls">
												<input class="form-control" id="sensationinfoPrice" type="text" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-form-label" for="sensationinfoOutputprice">产出-收益</label>
											<div class="controls">
												<input class="form-control" id="sensationinfoOutputprice" type="text" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-form-label" for="sensationinfoSalesnum">产出-单数</label>
											<div class="controls">
												<input class="form-control" id="sensationinfoSalesnum" type="text" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-form-label" for="sensationinfoFlowlnum">产出-流量</label>
											<div class="controls">
												<input class="form-control" id="sensationinfoFlowlnum" type="text" />
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
										<div class="card-title-name">归属（平台  & 店铺  & 业务员）</div>
									</div>									
									<div class="card-body">
										<div class="form-group">
											<label class="col-form-label" for="sensationinfoSalesmenname">业务员</label>
											<div class="controls">
												<input class="form-control" id="sensationinfoSalesmenname" type="text" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-form-label" for="sensationinfoPlatform">平台</label>
											<div class="controls">
												<select class="form-control" id="sensationinfoPlatform">
													<jsp:include page="layout/plateform-option-list.jsp"></jsp:include>
												</select>
											</div>
										</div>
										<div class="form-group">
											<label class="col-form-label" for="sensationinfoShoproomid">店铺</label>
											<div class="controls">
												<select class="form-control shop-list" id="sensationinfoShoproomid"></select>	
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
		var storageName = 'hongren';
		// init
		renderTabItems();
		getAllBlockData();
		getAllShoproomData(renderShoproomList);

		var oldTime = (new Date()).getTime(), timer = null;
		// save search
		$('.btn-save-search').on('click', function () {
			var searchVals = {
				search: $('#search-word').val()
			};
			// cancel repeat add save-search
			if (checkNewItem(searchVals)) return;
			if (searchVals.search) {
				addStorageItem(searchVals);
				$('.c-table-tab-tempory').html('');
				createTableTabItem(searchValsectionVal);
				addTableTabItem(searchVals, $('.c-table-tab-item').length);
			}
		});
		// search it
		$('#search-word').on('keyup', function() {
			var distanceTime = 1000,
				newTime =  (new Date()).getTime();
			if (newTime - oldTime < 1000) clearTimeout(timer);
			oldTime = newTime;
			timer = setTimeout(function() {
				updateSearchData();
			}, distanceTime);
		});
		// tab-item click
		$(document.body).on('click', '.c-table-tab-item', function (e) {
			$('.c-table-tab-item').removeClass('active');
			$(this).addClass('active');
			// inital pagination num
			setPageNum(1);
			setActiveItemNum($(this).data('idx'));
			getTabSearchData($(this));
		});
		// tab delete
		$(document.body).on('click', '.delete-table-tab-item', deleteTableTabItem);
		// pagination a-click
		$(document.body).on('click', '#table-pagination li', function (e) {
			getTabSearchData($('.c-table-tab-item.active'));
		});
		
		// save search
		$('.btn-save-search').on('click', function () {
			var searchVals = {
				search: $('#search-word').val()
			};
			// cancel repeat add save-search
			if (checkNewItem(searchVals)) return;
			if (searchVals.search) {
				addStorageItem(searchVals);
				$('.c-table-tab-tempory').html('');
				createTableTabItem(searchVals);
				addTableTabItem(searchVals, $('.c-table-tab-item').length);
			}
		});
		// create collection
		$('.btn-create').on('click', function () {
			$('.c-create .c-option-title').text('创建红人数据');

			// init formData
			resetFormData();
			showCreateBlock();
			isCreate = true;
		});
		// edit block
		$(document.body).on('click', '.btn-edit', function (e) {
			var sensationinfoId = $(this).data('id');
			getOneBlockData({sensationinfoId: sensationinfoId}, function(resData) {
				isUpdate = true;
			 	$('.c-create .c-option-title').text('编辑红人数据');
				showCreateBlock();
				initFormData(resData);
			});			
		});
		// delete block
		$(document.body).on('click', '.btn-delete', function (e) {
			var sensationinfoId = parseInt($(this).data('id'));
			$('#deleteModal').find('.modal-title').html('删除红人数据！');
			$('#deleteModal').modal('show');
			$('#deleteModal .btn-ok').one('click', function () {
				deleteOneBlockData({
					sensationinfoId: sensationinfoId,
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
		// get Data for table
		function getTabSearchData($this) {
			var dataVal = $this.data('val');
			if (dataVal && (dataVal.search)) {
				$('#search-word').val(dataVal.search || '');
				getAllBlockDataByParm();
			} else {
				$('#search-word').val('');
				initActiveItemNum();
				getAllBlockData();
			}
		}
		// search status change
		function updateSearchData() {
			var searchVals = {
				search: $('#search-word').val()
			};
			// inital pagination num
			setPageNum(1);

			$('.c-table-tab-item.active').removeClass('active');
			$('.c-table-tab-tempory').html(createTableTabItem(searchVals).addClass('active'));
			getTabSearchData($('.c-table-tab-tempory .c-table-tab-item'));
		}
		/* create-update tab */
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
			$('#sensationinfoId').val('');
			
			$('#sensationinfoName').val('');
			$('#sensationinfoAccount').val('');			
			$('#sensationinfoSalesmenname').val('');
			
			$('#sensationinfoPrice').val('');
			$('#sensationinfoOutputprice').val('');
			$('#sensationinfoFlowlnum').val('');
			$('#sensationinfoSalesnum').val('');

			$('#sensationinfoPlatform').val('');
			$('#sensationinfoShoproomid').val('-1');
		}
		// getFormdData
		function getFormData() {
			var data = {};
			data.sensationinfoId = parseInt($('#sensationinfoId').val());
			
			data.sensationinfoName = $('#sensationinfoName').val();
			data.sensationinfoAccount = $('#sensationinfoAccount').val();			
			data.sensationinfoSalesmenname = $('#sensationinfoSalesmenname').val();
			
			data.sensationinfoPrice = $('#sensationinfoPrice').val();
			data.sensationinfoOutputprice = $('#sensationinfoOutputprice').val();
			data.sensationinfoSalesnum = $('#sensationinfoSalesnum').val();
			data.sensationinfoFlowlnum = $('#sensationinfoFlowlnum').val();

			data.sensationinfoPlatform = $('#sensationinfoPlatform').val();
			data.sensationinfoShoproomid = $('#sensationinfoShoproomid').val();
			data.sensationinfoShoproomname = $('#sensationinfoShoproomid').find('option:selected').data('name');

			return data;
		}
		// initFormData
		function initFormData(data) {
			// init
			$('#sensationinfoId').val(data.sensationinfoId);
			
			$('#sensationinfoName').val(data.sensationinfoName);
			$('#sensationinfoAccount').val(data.sensationinfoAccount);
			$('#sensationinfoSalesmenname').val(data.sensationinfoSalesmenname);
			
			$('#sensationinfoPrice').val(data.sensationinfoPrice);
			$('#sensationinfoOutputprice').val(data.sensationinfoOutputprice);
			$('#sensationinfoSalesnum').val(data.sensationinfoSalesnum);
			$('#sensationinfoFlowlnum').val(data.sensationinfoFlowlnum);

			$('#sensationinfoPlatform').val(data.sensationinfoPlatform);
			$('#sensationinfoShoproomid').val(data.sensationinfoShoproomid);
			
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
		// callback get all data
		function getAllBlockData() {
			$('.c-mask').show();
			var formData = 'pn=' + getPageNum();
			$.ajax({
				url: "${APP_PATH}/CrmProductSellInfo/GetProductSellInfoByPage",
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
					toastr.error('Failed to get Sensation table-list, please refresh the page to get again!');
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
				url: "${APP_PATH}/MarketSensationInfo/GetOneMarketSensationInfoDetailById",
				type: "post",
				dataType: "json",
				contentType: 'application/json',
				data: JSON.stringify(reqData),
				success: function (data) {
					if (data.code == 100) {
						callback(data.extend.marketSensationInfo);
						toastr.success(data.extend.resMsg);
					} else {
						toastr.error(data.extend.resMsg);
					}
				},
				error: function () {
					toastr.error('Failed to get Sensation-data, please refresh the page to get again!');
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
				url: "${APP_PATH}/MarketSensationInfo/Add",
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
				url: "${APP_PATH}/MarketSensationInfo/Update",
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
				url: "${APP_PATH}/MarketSensationInfo/Delete",
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
		// callback get all data
		function getAllBlockData() {
			$('.c-mask').show();
			var formData = 'pn=' + getPageNum();
			$.ajax({
				url: "${APP_PATH}/MarketSensationInfo/GetMarketSensationInfoByPage",
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
					toastr.error('Failed to get Sensation table-list, please refresh the page to get again!');
				},
				complete: function () {
					$('.c-mask').hide();
				}
			});
		}
		// callback get all data By params
		function getAllBlockDataByParm() {
			$('.c-mask').show();
			var reqData = {};
			reqData.sensationinfoSalesmenname = $('#search-word').val();
			reqData.pn = getPageNum();
			$.ajax({
				url: "${APP_PATH}/MarketSensationInfo/GetMarketSensationInfoByParameterByPage",
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
					toastr.error('Failed to get Sensation table-list, please refresh the page to get again!');
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
				htmlStr += '<tr><td>' + data[i].sensationinfoId + '</td>' +
					'<td>' + (data[i].sensationinfoName || '--')  + '</td>' +
					'<td>' + (data[i].sensationinfoAccount || '--')  + '</td>' +
					'<td>' + (data[i].sensationinfoSalesmenname || '--')  + '</td>' +
					'<td>' + (data[i].sensationinfoPrice || '--')  + '</td>' +
					'<td>' + (data[i].sensationinfoOutputprice || '--')  + '</td>' +
					'<td>' + (data[i].sensationinfoSalesnum || '--')  + '</td>' +
					'<td>' + (data[i].sensationinfoFlowlnum || '--')  + '</td>' +
					'<td>' + (data[i].sensationinfoPlatform || '--')  + '</td>' +			
					'<td>' + (data[i].sensationinfoShoproomname || '--') + '</td>' +
					'<td>' +
						'<button class="btn btn-primary btn-edit" data-id="' + data[i].sensationinfoId + '">' +
							'<svg class="c-icon">' +
								'<use xlink:href="${APP_PATH}/static/back/img/svg/free.svg#cil-pencil"></use>' +
							'</svg>' +
						'</button>' +
						'<button class="btn btn-danger btn-delete" data-id="' + data[i].sensationinfoId + '">' +
							'<svg class="c-icon">' +
								'<use xlink:href="${APP_PATH}/static/back/img/svg/free.svg#cil-trash"></use>' +
							'</svg>' +
						'</button>' +
					'</td></tr>';
			}
			$('.c-table-table tbody').html(htmlStr);
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