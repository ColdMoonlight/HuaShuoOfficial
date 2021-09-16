<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% pageContext.setAttribute("APP_PATH" , request.getContextPath()); %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>速卖通产品销售数据</title>
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
						<span class="c-option-title">产品销售数据</span>
						<button class="btn btn-primary btn-create">创建</button>
					</div>
					<div class="c-excel-btns" style="margin-top: 1rem">
						<button class="btn btn-secondary" id="btn-export-tpl">导出模板</button>
						<button class="btn btn-info" id="btn-import-data">批量导入</button>
						<!-- <button class="btn btn-primary" id="btn-export-data">导出数据</button> -->
					</div>
					<div class="c-table">
						<div class="c-table-table table-responsive-sm">
							<table class="table">
								<thead>
									<tr>
										<th>id</th>
										<th>网站</th>
										<th>单号</th>
										<th>产品sku</th>
										<th>产品名称</th>
										<th>数量</th>
										<th>产品实价</th>
										<th>销售时间</th>
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
						<span class="c-option-title">创建产品销售数据</span>
						<div class="group">
							<button class="btn btn-secondary btn-cancel">取消</button>
							<button class="btn btn-primary btn-save">保存</button>
						</div>
					</div>
					<div class="c-form">
						<div class="row">
							<input id="productsellinfoId" hidden>
							<!-- left panel  -->
							<div class="left-panel col-lg-7 col-md-12">
								<div class="card">
									<div class="card-title">
										<div class="card-title-name">数据</div>
									</div>
									<div class="card-body">
										<div class="form-group">
											<label class="col-form-label" for="productsellinfoProducttype">产品类别</label>
											<div class="controls">
												<input class="form-control" id="productsellinfoProducttype" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-form-label" for="productsellinfoProductid">产品id</label>
											<div class="controls">
												<input class="form-control" id="productsellinfoProductid" type="number" min="0" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-form-label" for="productsellinfoProductname">产品名称</label>
											<div class="controls">
												<input class="form-control" id="productsellinfoProductname" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-form-label" for="productsellinfoProductsku">产品sku</label>
											<div class="controls">
												<input class="form-control" id="productsellinfoProductsku" type="text" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-form-label" for="productsellinfoProductsku">数量</label>
											<div class="controls">
												<input class="form-control" id="productsellinfoProductsellnum" type="text" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-form-label" for="productsellinfoProductmarkprice">产品标价</label>
											<div class="controls">
												<input class="form-control" id="productsellinfoProductmarkprice" type="number" min="0" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-form-label" for="productsellinfoProductrealprice">产品实价</label>
											<div class="controls">
												<input class="form-control" id="productsellinfoProductrealprice" type="number" min="0" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-form-label" for="productsellinfoCouponprice">优惠金额</label>
											<div class="controls">
												<input class="form-control" id="productsellinfoCouponprice" type="number" min="0" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-form-label" for="productsellinfoCouponcode">优惠券</label>
											<div class="controls">
												<input class="form-control" id="productsellinfoCouponcode" />
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
										<div class="card-title-name">归属（网站 & 单号）</div>
									</div>
									<div class="card-body">									
										<div class="form-group">
											<label class="col-form-label" for="productsellinfoBrandname">网站</label>
											<div class="controls">
												<input class="form-control" id="productsellinfoBrandname" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-form-label" for="productsellinfoPlatenum">单号</label>
											<div class="controls">
												<input class="form-control" id="productsellinfoPlatenum" type="text" />
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
											<label class="col-form-label" for=productsellinfoProductselltime>销售时间</label>
											<div class="controls">
												<input type="text" class="form-control datetimepicker" id="productsellinfoProductselltime" placeholder="@exmaple 2020-01-01 12:00:00" autocomplete="off"  />
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
			$('.c-create .c-option-title').text('创建产品销售数据');

			// init formData
			resetFormData();
			showCreateBlock();
			isCreate = true;
		});
		// edit block 
		$(document.body).on('click', '.btn-edit', function (e) {
			var productsellinfoId = $(this).data('id');
			getOneBlockData({productsellinfoId: productsellinfoId}, function(resData) {
				isUpdate = true;
			 	$('.c-create .c-option-title').text('编辑产品销售数据');
				showCreateBlock();
				initFormData(resData);
			});			
		});
		// delete block
		$(document.body).on('click', '.btn-delete', function (e) {
			var productsellinfoId = parseInt($(this).data('id'));
			$('#deleteModal').find('.modal-title').html('删除产品销售数据！');
			$('#deleteModal').modal('show');
			$('#deleteModal .btn-ok').one('click', function () {
				deleteOneBlockData({
					productsellinfoId: productsellinfoId,
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
			window.location.href = '${APP_PATH}/ExcelImport/ExportProductSellInfoImportDemo';
		});
		$('#btn-import-data').on('click', function() {
			function importExcelData(reqData) {
				$('.c-mask').show();
				$.ajax({
					url: "${APP_PATH}/ExcelImport/ImportProductSellInfo",
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
			$('#datetimerangeModal').find('.modal-title').html("导出数据").end().modal('show');
		});
		$('#datetimerangeModal .btn-ok').on('click', function() {
			var startTime = $('#startTime').val(),
				endTime = $('#endTime').val();
			window.location.href = '${APP_PATH}/ExcleDownload/exportProductSellInfo?webanalyticsCreatetime='+ startTime +'&webanalyticsMotifytime=' + endTime;
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
			$('#productsellinfoId').val('');
			
			$('#productsellinfoBrandname').val('');
			$('#productsellinfoPlatenum').val('');
			
			$('#productsellinfoProducttype').val('');
			$('#productsellinfoProductid').val('');
			$('#productsellinfoProductname').val('');
			$('#productsellinfoProductsku').val('');
			$('#productsellinfoProductsellnum').val('');
			$('#productsellinfoProductmarkprice').val('');
			$('#productsellinfoProductrealprice').val('');
			$('#productsellinfoCouponprice').val('');
			$('#productsellinfoCouponcode').val('');
			
			$('#productsellinfoProductselltime').val('');
		}
		// getFormdData
		function getFormData() {
			var data = {};
			data.productsellinfoId = parseInt($('#productsellinfoId').val());
			
			data.productsellinfoBrandname = $('#productsellinfoBrandname').val();
			data.productsellinfoPlatenum = $('#productsellinfoPlatenum').val();
			
			data.productsellinfoProducttype = $('#productsellinfoProducttype').val();
			data.productsellinfoProductid = $('#productsellinfoProductid').val();
			data.productsellinfoProductname = $('#productsellinfoProductname').val();
			data.productsellinfoProductsku = $('#productsellinfoProductsku').val();
			data.productsellinfoProductsellnum = $('#productsellinfoProductsellnum').val();
			data.productsellinfoProductmarkprice = $('#productsellinfoProductmarkprice').val();
			data.productsellinfoProductrealprice = $('#productsellinfoProductrealprice').val();
			data.productsellinfoCouponprice = $('#productsellinfoCouponprice').val();
			data.productsellinfoCouponcode = $('#productsellinfoCouponcode').val();
			
			data.productsellinfoProductselltime = $('#productsellinfoProductselltime').val();

			return data;
		}
		// initFormData
		function initFormData(data) {
			// init
			$('#productsellinfoId').val(data.productsellinfoId);
			
			$('#productsellinfoBrandname').val(data.productsellinfoBrandname);
			$('#productsellinfoPlatenum').val(data.productsellinfoPlatenum);
			
			$('#productsellinfoProducttype').val(data.productsellinfoProducttype);
			$('#productsellinfoProductid').val(data.productsellinfoProductid);
			$('#productsellinfoProductname').val(data.productsellinfoProductname);
			$('#productsellinfoProductsku').val(data.productsellinfoProductsku);
			$('#productsellinfoProductsellnum').val(data.productsellinfoProductsellnum);
			$('#productsellinfoProductmarkprice').val(data.productsellinfoProductmarkprice);
			$('#productsellinfoProductrealprice').val(data.productsellinfoProductrealprice);
			$('#productsellinfoCouponprice').val(data.productsellinfoCouponprice);
			$('#productsellinfoCouponcode').val(data.productsellinfoCouponcode);
			
			$('#productsellinfoProductselltime').val(data.productsellinfoProductselltime);
		}
		// callback get all data
		function getAllBlockData() {
			$('.c-mask').show();
			var formData = 'pn=' + getPageNum();
			$.ajax({
				url: "${APP_PATH}/CrmProductSellInfo/GetProductSellInfoAliExpressByPage",
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
					toastr.error('Failed to get ProductSellInfo table-list, please refresh the page to get again!');
				},
				complete: function () {
					$('.c-mask').hide();
				}
			});
		}
	    //  callback get all
		function getProductSellInfo(val) {
			$('.c-mask').show();
			$.ajax({
				url: "${APP_PATH}/CrmProductSellInfo/GetProductSellInfoByPage",
				type: "post",
				data: "pn=" + getPageNum(),
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
					toastr.error('Failed to get ProductSellInfo table-list, please refresh the page to get again!');
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
				url: "${APP_PATH}/CrmProductSellInfo/GetOneProductSellInfoDetailById",
				type: "post",
				dataType: "json",
				contentType: 'application/json',
				data: JSON.stringify(reqData),
				success: function (data) {
					if (data.code == 100) {
						callback(data.extend.crmProductSellInfo);
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
				url: "${APP_PATH}/CrmProductSellInfo/Add",
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
				url: "${APP_PATH}/CrmProductSellInfo/Update",
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
				url: "${APP_PATH}/CrmProductSellInfo/Delete",
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
				htmlStr += '<tr><td>' + data[i].productsellinfoId + '</td>' +
					'<td>' + (data[i].productsellinfoBrandname || '--') + '</td>' +
					'<td>' + (data[i].productsellinfoPlatenum || '--') + '</td>' +
					'<td>' + (data[i].productsellinfoProductsku || '--') + '</td>' +
					'<td><div class="text-overflow" title="' + data[i].productsellinfoProductname + '">' + (data[i].productsellinfoProductname || '--') + '</div></td>' +
					'<td>' + (data[i].productsellinfoProductsellnum || '--') + '</td>' +
					'<td>' + (data[i].productsellinfoProductrealprice || '--') + '</td>' +
					'<td>' + (data[i].productsellinfoProductselltime || '--') + '</td>' +
					'<td>' +
						'<button class="btn btn-primary btn-edit" data-id="' + data[i].productsellinfoId + '">' +
							'<svg class="c-icon">' +
								'<use xlink:href="${APP_PATH}/static/back/img/svg/free.svg#cil-pencil"></use>' +
							'</svg>' +
						'</button>' +
						'<button class="btn btn-danger btn-delete" data-id="' + data[i].productsellinfoId + '">' +
							'<svg class="c-icon">' +
								'<use xlink:href="${APP_PATH}/static/back/img/svg/free.svg#cil-trash"></use>' +
							'</svg>' +
						'</button>' +
					'</td></tr>';
			}
			$('.c-table-table tbody').html(htmlStr);
		}
		// get Data for table
		function getTabSearchData($this) {
			var dataVal = $this.data('val');
			if (dataVal && dataVal.ProductSellInfo) {
				//$('#coupon-name').val(dataVal.coupon || '');
				//getSearchProductSellInfoData();
			} else {
				//$('#coupon-name').val('');
				initActiveItemNum();
				getProductSellInfo();
			}
		}
		</script>
	</body>
</html>