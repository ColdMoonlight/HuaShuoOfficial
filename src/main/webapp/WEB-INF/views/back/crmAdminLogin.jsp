<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% pageContext.setAttribute("APP_PATH" , request.getContextPath()); %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Login</title>
		<jsp:include page="common/backheader.jsp" flush="true"></jsp:include>
		<!-- login style  -->
		<style>
			.c-app { background-color: #f5feff; }
			.container { display: flex; flex-direction: column; justify-content: space-between; min-height: 100vh; }
			.container::before, .container::after { display: none; }
			.header { display: flex; align-items: center; height: 10vh; }
			.header img { width: 16rem; }
			.login-box { display: flex; align-items: center; justify-content: center; }
			.login-bg>img { width: 100%; }
			#reset-password-form, .spinner>.spinner-border { display: none; }
			.input-group { margin-bottom: 16px; }
			.footer { display: flex; align-items: center; justify-content: center; height: 20vh; }
			@media screen and (max-width: 1024px) {
				.header { justify-content: center; }
				.md-down-none { display: none; }
				.btn-primary.spinner { width: 100%; }
			}
		</style>
	</head>
	<body class="c-app">
		<div class="container">
			<div class="header">
				<img src="${APP_PATH }/static/common/dblogo.png" />
			</div>
			<div class="row login-box">
				<div class="col-md-8 col-lg-8 login-bg md-down-none">
					<img src="${APP_PATH }/static/back/img/logon.jpg" />
				</div>
				<div class="card col-md-4 col-lg-4">
					<form id="login-form">
						<div class="card-body">
							<p class="text-muted">Sign In to your account</p>
							<div class="input-group">
								<span class="input-group-addon">
									<svg class="c-icon">
										<use xlink:href="${APP_PATH}/static/back/img/svg/free.svg#cil-user"></use>
									</svg>
								</span>
								<input class="form-control" name="adminAccount" type="text" placeholder="Username">
							</div>
							<div class="input-group">
								<span class="input-group-addon">
									<svg class="c-icon">
										<use xlink:href="${APP_PATH}/static/back/img/svg/free.svg#cil-lock-locked"></use>
									</svg>
								</span>
								<input class="form-control" name="adminPassword" type="password" placeholder="Password">
							</div>
							<div class="row">
								<div class="col-sm-6">
									<button class="btn btn-primary spinner" type="button" id="back-login">
										<span class="spinner-text">Login</span>
										<div class="spinner-border" role="status" aria-hidden="true"></div>
									</button>
								</div>
								<div class="col-sm-6 text-right">
									<button class="btn btn-link px-0" id="change-password" type="button">Change Password</button>
								</div>
							</div>
						</div>
					</form>
					<form id="reset-password-form">
						<div class="card-body">
							<p class="text-muted">Change Your Password</p>
							<div class="input-group">
								<span class="input-group-addon">
									<svg class="c-icon">
										<use xlink:href="${APP_PATH}/static/back/img/svg/free.svg#cil-user"></use>
									</svg>
								</span>
								<input class="form-control" name="adminAccount" type="text" placeholder="Username">
							</div>
							<div class="input-group">
								<span class="input-group-addon">
									<svg class="c-icon">
										<use xlink:href="${APP_PATH}/static/back/img/svg/free.svg#cil-lock-locked"></use>
									</svg>
								</span>
								<input class="form-control" name="adminPassword" type="password" placeholder="Old Password">
							</div>
							<div class="input-group">
								<span class="input-group-addon">
									<svg class="c-icon">
										<use xlink:href="${APP_PATH}/static/back/img/svg/free.svg#cil-lock-locked"></use>
									</svg>
								</span>
								<input class="form-control" name="adminCreatetime" type="password" placeholder="New Password">
							</div>
							<div class="row">
								<div class="col-sm-6">
									<button class="btn btn-primary spinner" type="button" id="back-reset">
										<span class="spinner-text">Rseset</span>
										<div class="spinner-border" role="status" aria-hidden="true"></div>
									</button>
								</div>
								<div class="col-sm-6 text-right">
									<button class="btn btn-link px-0" id="go-signin" type="button">Back SignIn</button>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
			<div class="footer">
				<p class="text-center">© 2020-~ MegaLook.com. All rights reserved.</p>
			</div>
		</div>

	<jsp:include page="common/backfooter.jsp"></jsp:include>
	<!-- custom script -->
	<script>
		$('#back-login').on('click', function(e) {
			var self = this;
			showSpinner(self);
			var data = $('#login-form').serializeArray().reduce(function(acc, item) {acc[item.name] = item.value; return acc;}, {});
			$.ajax({
				url: "${APP_PATH }/CrmAdmin/CheakAdminUser",
				type: "post",
				dataType: "json",
				contentType: 'application/json',
				data: JSON.stringify(data),
				success: function (data) {
					if (data.code == 100) {
						toastr.success(data.extend.resMsg + ', The jump will take place later。');
						setTimeout(function() {
							window.location.href = '${APP_PATH }/BackHome/BackHomePage';
						}, 100);
					} else {
						toastr.error(data.extend.resMsg);
					}
				},
				error: function() {
					toastr.error('Login failed, please login again！');
				},
				complete: function() {
					hideSpinner(self);
				}
			});
		});
		$('#back-reset').on('click', function(e) {
			var self = this;
			showSpinner(self);
			var data = $('#reset-password-form').serializeArray().reduce(function(acc, item) {acc[item.name] = item.value; return acc;}, {});
			$.ajax({
				url: "${APP_PATH }/CrmAdmin/UpdateAdminPassword",
				type: "post",
				dataType: "json",
				contentType: 'application/json',
				data: JSON.stringify(data),
				success: function (data) {
					if (data.code == 100) {
						toastr.success(data.extend.resMsg + ', Please click the back to login button below to log in again');
					} else {
						toastr.error(data.extend.resMsg);
					}
				},
				error: function() {
					toastr.error('Password modification failed, please resubmit！');
				},
				complete: function() {
					hideSpinner(self);
				}
			});
		});
		$('#change-password').on('click', function(e) {
			$('#login-form').slideUp();
			$('#reset-password-form').slideDown();
		});
		$('#go-signin').on('click', function(e) {
			$('#login-form').slideDown();
			$('#reset-password-form').slideUp();
		});
	</script>
	</body>
</html>