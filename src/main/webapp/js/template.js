/** 通用JS* */
$(window).load(function() {
	/* 页面框架高度设定 */
	setMainContentSize();
	$(window).resize(function() {
		setMainContentSize();
	});
	/* 注册顶部导航悬浮事件 */
	$(".top-navigation-menu").each(function(i) {
		var index = i + 1;
		var c = "span-icon-top-" + index + "-hover";
		var $a = $(this).find("a:eq(0)");
		$a.mouseenter(function() {
			$a.find("span").addClass(c);
			$(this).closest("li").addClass("top-navigation-menu-hover");
		}).mouseleave(function() {
			$a.find("span").removeClass(c);
			$(this).closest("li").removeClass("top-navigation-menu-hover");
		});
	});
	/* 顶部菜单 */
	$("#topMenu").navigation({
		mainmenuid : "topMenu", // Menu DIV id
		location : 'top'// left right top bottom
	});

	/* 窗口模式 */
	$(".load_for_dialog").bind("click", function() {
		var id = $(this).find(".load_module_id").val();
		var title = $(this).find(".load_module_name").val();
		var url = $(this).find(".load_url").val();
		var width = $(this).find(".load_width").val();
		var height = $(this).find(".load_height").val();
		// $("#work_main_div").empty();
		$("#" + id).window({
			id : id, /* 窗口后缀ID */
			title : title,
			width : width, /* 窗口宽度 */
			height : height, /* 窗口高度 */
			targetid : "work_main_div", /* 目标容器ID */
			url : url,
			params : {
				"p1" : "v1",
				"p2" : "v2"
			}
		});
		return false;
	});

	/* 应用盒子 */
	$("#work_main_div").appbox({
		id : "appbox_bar",
		titleMessage : "已开启",
		width : 250,
		maxHeight : 800,
		noRunMessage : "您还没开启任何模块",
		containmentId : "work_div"
	});
});

/**
 * 设置页面工作区域的大小
 * 
 * @param targetId
 *			目标ID
 */
function setMainContentSize() {
	/* 页面整体高度减去头和尾的高度 */
	var height = $(window).height() - $("div#page_header").outerHeight(true)
			- $("div#page_bottom").outerHeight(true) - 44;
	// alert($(window).height() - otherHeight - 44);
	// alert($(window).width());
	$("div#page_content").css("height", height);
	$("div#scroll").css("height", height);
	/* 初始化滚动条 */
	InitScrollBarHeight("scroll");
}
