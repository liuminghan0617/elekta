$(document)
		.ready(
				function() {
					/*文本框 必须标注CLASS "datatxt"*/
					$(".datatxt").uTextBox({
						className : "datatxt_0",
						lcName : "datatxt_l",
						rcName : "datatxt_r",
						tcName : "datatxt_t"
					});
					$(".txtFakeText").uTextBox({
						className : "datatxt_0",
						lcName : "datatxt_l",
						rcName : "datatxt_r",
						tcName : "datatxt_t"
					});
					/*上传控件事件 by:css*/
					function HandleFileButtonClick() {
						$("#upload").click();
						//$("#txtFilePath").attr("value", $("#upload").attr("value"));
					}
					/*select*/
					$(".uselect").uSelect({
						swidth : "320"
					});
					//初始化带滚动条的文本框
					InitScrollTextBox();

					/*mask 电话  $("#tel_number").mask("(999)999-9999");*/
					$.fn.masks({
						"tel_number" : "(999)999-9999",
					});

					/* 消除默认的TITLE提示 */
					$(".datatxt").hover(function() {
						this.temp = this.title;
						this.title = "";
					}, function() {
						this.title = this.temp;
						this.temp = null;
					});
					//tip提示插件示例 nonullt
					$('.nonullt').poshytip({
						className : 'tip-claretwhite',
						showOn : 'focus',
						alignTo : 'target',
						alignX : 'inner-left',
						offsetX : 0,
						offsetY : 5
					});
					//tip提示插件示例  someClass
					$(".someClass").poshytip({ //初始化
						className : "tip-claretwhite",
						showOn : "focus", //默认为不显示
						alignTo : "target",
						alignX : "inner-left",
						offsetX : 0,
						offsetY : 5
					});
					$(".someClass").live("focus", function() {
						var $this = $(this);
						$this.poshytip('show');
					});
					//带邮箱格式验证的tip提示
					$(".emailtxt").poshytip({
						className : "tip-claretwhite",
						showOn : "focus",
						alignTo : "target",
						alignX : "inner-left",
						offsetX : 0,
						offsetY : 5
					});

					/*表单验证*/
					var rules = { //构建验证数据
						nonullt : { //所要验证的文本框name
							//required: true, 验证：是否非空,
							nonull : true
						//minlength: 5, //验证：最小字符长度
						//maxlength: 30, //验证：最大字符长度
						//number: true //验证：是否为数字
						},
						nonulltxt : {
							nonull : true
						},
						emailtxt : {
							emailtxt : true
						}
					}
					$("#form1").validate({
						focusCleanup : false, // 当未通过验证的元素获得焦点时,并移除错误提示
						rules : rules
					});

					$('.nonullt').blur(
							function() {
								var $this = $(this);
								if ($this.val() != "") {
									$this.poshytip('hide');
									$this.closest(".dtext").removeClass(
											"errortxt");
									$this.closest(".dtext").find("span").eq(0)
											.removeClass("errortxt_l");
									$this.closest(".dtext").find("span").eq(1)
											.removeClass("errortxt_r");
								}
							});
					$(".emailtxt")
							.blur(
									function() {
										var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
										var $this = $(this);
										if ($(this).val() != ""
												&& filter.test($(this).val())) {
											$this.poshytip('hide');
											$this.closest(".dtext")
													.removeClass("errortxt");
											$this.closest(".dtext")
													.find("span").eq(0)
													.removeClass("errortxt_l");
											$this.closest(".dtext")
													.find("span").eq(1)
													.removeClass("errortxt_r");
											setTimeout(function() {
											}, 3000);
										}
									});
				});
/*初始化带滚动条的文本框*/
function InitScrollTextBox() {
	var i = 0;
	var intervalId;
	var height;
	$divTextarea = $("div#divTextarea");
	$divTextarea.focus(function() {
		intervalId = window.setInterval(function() {
			h = $divTextarea.height();
			if (h != height) {
				height = h;
				InitScrollBarTextBox("scrollTextBox", 56);
			}
		}, 10);
	});
	$divTextarea.blur(function() {
		window.clearInterval(intervalId);
	});

	InitScrollBarHeight("scrollTextBox");
	height = $divTextarea.height();
}