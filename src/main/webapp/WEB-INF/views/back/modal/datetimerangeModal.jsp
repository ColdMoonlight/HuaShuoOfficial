<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% pageContext.setAttribute("APP_PATH", request.getContextPath()); %>

<div class="modal fade" id="datetimerangeModal" tabindex="-1" role="dialog" aria-labelledby="datetimerangeModalLabel"
	aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title"></h4>
				<button class="close" type="button" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
			</div>
			<div class="modal-body">
				<div class="form-group">
					<label class="col-form-label" for="startTime">时间</label>
					<div class="controls">
						<input type="text" class="form-control datetimepicker" id="startTime" placeholder="@exmaple 2020-01-01 00:00:00" autocomplete="off"  />
					</div>
				</div>
				<div class="form-group">
					<label class="col-form-label" for="endTime">时间</label>
					<div class="controls">
						<input type="text" class="form-control datetimepicker" id="endTime" placeholder="@exmaple 2020-01-01 23:59:59" autocomplete="off"  />
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button class="btn btn-secondary btn-cancel" type="button" data-dismiss="modal">取消</button>
				<button class="btn btn-danger btn-ok" type="button">确定</button>
			</div>
		</div>
	</div>
</div>
<script>
	$('#datetimerangeModal .btn-cancel').on('click', function () {
		$('#datetimerangeModal .btn-ok').off('click');
	});
</script>