<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% pageContext.setAttribute("APP_PATH" , request.getContextPath()); %>

<script type="text/javascript">
function renderSideBarMenu(data) {
	function generateSecondMenu(data) {
		if (data.length) {
			var secondMenuHtml = '<ul class="c-child-menu">';
			data.forEach(function(item, idx) {
				secondMenuHtml += '<li class="c-sidebar-nav-item"><a class="c-sidebar-nav-link" href="${APP_PATH}/'+ item.catalogUrl +'">' +
						'<svg class="c-sidebar-nav-icon"><use xlink:href="${APP_PATH}/static/back/img/svg/free.svg#cil-cursor"></use></svg>' +
						'<span class="c-text">'+ item.catalogName +'</span>' +
					'</a></li>';
			});
			secondMenuHtml += '</ul>';
			return secondMenuHtml;
		}
		return '';
	}
	
	function generateSecondCheckMenu(data) {
		var secondCheckMenuHtml;
		if (data.length) {
			data.forEach(function(item, idx) {
				secondCheckMenuHtml += '<tr><td>' +
						'<input class="menu-checkbox-input" type="checkbox" data-id="'+ item.catalogId +'" data-name='+ item.catalogName +'" data-url="'+ item.catalogUrl +'">' +
					'</td>' +
				  	'<td></td>' +
				  	'<td>' + item.catalogName + '</td>' +
				  '</tr>';
			});

		  return secondCheckMenuHtml;
		}
		return '';
	}

	var firstArrData = data.CrmCatalogdownFirst;
	var secondMapData = data.CrmCatalogSuperList;
	var menuHtml, checkMenuHtml;
	if (firstArrData.length) {
		menuHtml = '<ul class="c-sidebar-nav">';
		menuHtml +=	'<li class="c-sidebar-nav-item">' +
				'<a class="c-sidebar-nav-link" href="${APP_PATH}/BackHome/BackHomePage">' +
					'<svg class="c-sidebar-nav-icon">' +
						'<use xlink:href="${APP_PATH}/static/back/img/svg/free.svg#cil-speedometer"></use>' +
					'</svg>' +
					'<span class="c-text">Dashboard</span>' +
				'</a>' +
			'</li>';
		firstArrData.forEach(function(item, idx) {
			menuHtml += '<li class="c-sidebar-nav-item' + (secondMapData && secondMapData[idx].length ? ' c-sidebar-nav-dropdown-toggle' : '') +'">' +
				'<a class="c-sidebar-nav-link" href="'+ (secondMapData && secondMapData[idx].length ? 'javascript:void(0);' : '${APP_PATH}/'+ item.catalogUrl) +'">' +
					'<svg class="c-sidebar-nav-icon"><use xlink:href="${APP_PATH}/static/back/img/svg/free.svg#cil-cursor"></use></svg>' +
					'<span class="c-text">'+ item.catalogName +'</span>' +
				'</a>' +
				(generateSecondMenu(secondMapData && secondMapData[idx])) +
				(secondMapData && secondMapData[idx].length ? '<div class="icon"></div>' : '') +
			'</li>';

			checkMenuHtml += '<tr><td>' +
					'<input class="menu-checkbox-input" type="checkbox" data-id="'+ item.catalogId +'" data-name='+ item.catalogName +'" data-url="'+ item.catalogUrl +'">' +
				'</td>' +
			  	'<td>' + (item.catalogName || '--') + '</td>' +
			  	'<td></td>' +
			  '</tr>' + generateSecondCheckMenu(secondMapData && secondMapData[idx]);
		});
		menuHtml += '</ul>';
	} else {
		menuHtml = '没有目录数据...';
	}
	$SIDEBAR_MENU.html(menuHtml);
	$('.menu-checkbox tbody').html(checkMenuHtml);
	!isInitMenu && addSidebarEvent();
}
function initSideBarMenu() {
	$.ajax({
		url: "${APP_PATH}/CrmCatalog/getCrmCatalogByAdminId",
		type: "get",
		dataType: "json",
		contentType: 'application/json',
		success: function (data) {
			if (data.code == 100) {
				renderSideBarMenu(data.extend);
			} else {
				toastr.error(data.extend.resMsg);
			}
		},
		error: function() {
			toastr.error('Login failed, please login again!');
		},
		complete: function() {
			hideSpinner(self);
		}
	});
}

function addSidebarEvent() {
	var closeMenu = function () {
		$SIDEBAR_MENU.find('li').removeClass('active');
		$SIDEBAR_MENU.find('li ul').slideUp();
	}

	$SIDEBAR_MENU.find('.c-sidebar-nav-dropdown-toggle .icon').on('click', function (e) {
		var $li = $(this).parent();

		if ($li.is('.active')) {
			$li.removeClass('active');
			$('ul:first', $li).slideUp();
		} else {
			closeMenu();
			$li.addClass('active');
			$('ul:first', $li).slideDown();
		}
	});

	// setting current page -> navItem
	$SIDEBAR_MENU.find('a[href="' + CURRENT_URL + '"]').parent('li').addClass('current-page');
	$SIDEBAR_MENU.find('a').filter(function () {
		return this.href == CURRENT_URL;
	}).parent('li').addClass('current-page').parents('ul').slideDown().parent().addClass('active');
}

var CURRENT_URL = window.location.href.split('#')[0],
	$SIDEBAR_MENU = $('#sidebar-menu'),
	isInitMenu = false;
initSideBarMenu();
</script>