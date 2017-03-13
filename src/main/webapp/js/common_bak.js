/**
 * 绑定Form
 * @param formId: Form的Id
 * @param data: Json数据
 * @param suffix:属性的后缀名 如domain对象为user.name form表单中为nameUpdate,进行绑定时数据需要增加后缀字符串
 * @example bindForm("orgForm", jsonObject,"suffix")
 */
function bindForm(formId, data,suffix) {
	if (!suffix) suffix="";
	var form = document.getElementById(formId);
	for (var i = 0; i < form.elements.length;i++) {
		var element = form.elements[i];
		//if (!data[element.id]) continue;
		var elementId=element.id.substring(0,element.id.length-suffix.length);
		if (data[elementId] == undefined) continue;
		var val = data[elementId];
		switch (element.type) {
		case "text": ;
		case "hidden": ;
		case "password": element.value = val; break;
		case "textarea": element.value = val; break;
		case "radio" : 
		case "checkbox" : 
			if (val instanceof Array) element.checked = (val.indexOf(element.value) > -1);
			else element.checked = (element.value ==val);
			break;
		case "select-one" : 
		case "select-multiple" : 
			for (var j = 0; j < element.options.length; j++) {
				var option = element.options[j];
				if (val instanceof Array) {
					option.selected = (val.indexOf(option.value) > -1);
				} else {
					option.selected = (option.value == val);
				}
			}
			break;
		}
	}
}

/**
 * 通过Form绑定Json数据
 * @param formId: Form的Id
 * @param data: Json数据
 * @example bindForm("orgForm", jsonObject)
 */
function bindJson(formId, data) {
	var form = document.getElementById(formId);
	for (var i = 0; i < form.elements.length;i++) {
		var element = form.elements[i];
		//if (!data[element.id]) continue;
		if (data[element.id] == undefined) continue;
		switch (element.type) {
		case "text": ;
		case "hidden": ;
		case "password": data[element.id] = element.value; break;
		case "radio" : 
		case "checkbox" : 
			data[element.id] = element.checked ? element.value : "N";
			break;
		case "select-one" : 
		case "select-multiple" : 
			data[element.id] = "";
			for (var j = 0; j < element.options.length; j++) {
				var option = element.options[j];
				option.selected = (option.value == val);
				if (option.selected) {
					if (data[element.id] == "")
						data[element.id] = option.value;
					else
						data[element.id] = data[element.id] + "," + option.value;
				}
			}
			break;
		}
	}
}



/**
 * 把Form的所有项生成name1=value1&name2=value2&...的URL参数字符串
 * @private
 * @param urlParams: 传入字符串
 * @param suffix:属性的后缀名 如domain对象为user.name form表单中为nameUpdate,进行绑定时数据需要增加后缀字符串
 * @param formId: Form的Id
 */
function formToUrl(urlParams, formId,suffix) {
	if (!suffix) suffix="";
	var els = document.getElementById(formId).elements;
	for(var i = 0, max = els.length; i < max; i++) {
		var element = els[i];
		var id=element.id.substring(0,element.id.length-suffix.length);
		//var id = el.id;
		var value = element.value;
		if (!id) continue;
		if (urlParams != '')
			urlParams += "&";
		urlParams += id + "=" + encodeURI(value);
	}
	return urlParams;
}


/**
 * 把数组的所有项生成name1=value1&name2=value2&...的URL参数字符串
 * @private
 * @param urlParams: 传入字符串
 * @param params: 函数所有参数的数组
 * @param start: 从第几个参数开始截取
 */
function arrayToUrl(urlParams, params, start) {
	for (var i = start; i < params.length - 1; i = i + 2) {
		if (urlParams != '')
			urlParams += "&";
		urlParams += params[i] + "=" + params[i+1];
	}
	return urlParams;
}

/**
 * 清空Form所有项
 * 
 */
function formClean(formId){
	var els = document.getElementById(formId).reset();
}


/**
 * 判断项是否为空，如果为空则提示错误
 * @param itemId: 项的ID
 * @param itemPrompt: 项的中文说明
 */
function checkItemNull(itemId, itemPrompt) {
	var item = document.getElementById(itemId);
	if (item == undefined)
		return;
	if (item.value == "") {
		alert(itemPrompt + "不能为空!");
		item.focus();
		throw "NULL";
	}
}

/**
 * 判断是否符合条件，如果符合则提示错误
 * @param condition: 条件
 * @param message: 错误信息
 */
function checkCondition(condition, message) {
	checkCondition(condition, message, null);
}

function checkCondition(condition, message, itemFocusing) {
	if (condition) {
		alert(message);
		if (itemFocusing != null) {
			var item = document.getElementById(itemFocusing);
			if (item != undefined)
				item.focus();
		}
		throw "CONDITION";
	}
}

//格式化日期为yyyy.mm
function todate(s) {
	var str = "";
	if (s != "" && s.length >= 7) {
		str = s.substr(0, 4) + "." + s.substr(5, 2);
	}
	return str;
}
// 格式化日期为yyyy.mm.dd
function toYMDdate(s) {
	var str = "";
	if (s) {
		if (s != "" && s.length >= 10) {
			str = s.substr(0, 4) + "." + s.substr(5, 2) + "." + s.substr(8, 10);
		} else if (s != "" && s.length >= 5) {
			str = s + '.01';
		}
	}
	return str;
}
function WinOpen(url, height, width) {
	window.open(url, "", "height=" + height + ",width=" + width + ",top=" + getTop(heigth) + ",left=" + getLeft(width)
	+ ",toolbar=no,menubar=no,scrollbars=no,resizable=yes,location=no,status=no");
}


function showConfirm(title,text,fn)
{
	Ext.MessageBox.show({
		title:title,
        msg: text,
        buttons: Ext.Msg.YESNO,
        icon: Ext.MessageBox.QUESTION,
        fn:fn
	});
}

function delayRun(code,time)
{
	var t=setTimeout(code,time);
}
/**
 * 把Form的所有项生成 {对象.name1=value1,对象.name2=value2,...}的URL参数字符串
 * @private
 * @param urlParams: 传入字符串
 * @param formId: Form的Id
 */
function formToObjParms(formId, objParms) {
	var els = document.getElementById(formId).elements;
	for(var i = 0, max = els.length; i < max; i++) {
		var el = els[i];
		var id = el.id;
		var value = el.value;
		if (!id) continue;
		if (!objParms)
			objParms=[{"name":id,"value":value}];	
		else
			objParms.push({"name":id,"value":value});
	}
	return objParms;
}