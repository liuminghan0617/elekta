// /date public info
DATEERROR_0 = "必填项不能为空!"
DATEERROR_1 = "不是日期格式!"
DATEERROR_2 = "年份必须是 00-99 或 1000-4712!"
DATEERROR_3 = "月份必须在 1-12 之间!"
DATEERROR_4 = "必须按 YYYY.MM.DD 的格式输入日期!"
DATEERROR_5 = "必须按 YYYY.MM的格式输入日期!"

// 判断对象为空，返回空字符
function nullRetEmpty(obj) {
	if (isNullObject(obj)) {
		return "";
	} else {
		return obj.value;
	}
}
// 判断元素的值是否为空
// 如果为空返回true，否则返回false
function isEmpty(obj) {
	if (obj == null) {
		return true;
	}
	var v = obj.value;
	var pattern = /(\d|([^ ]))/;
	flag = pattern.test(v);
	if (!flag) {
		obj.select();
		obj.focus();
		return true;
	} else {
		return false;
	}
}

//判断元素的值长度是否大于规定长度
//如果大于规定长度返回true，否则返回false
function isBeyondLength(obj, len) {
	var str = obj.value;
	var length = 0;
	if (str == null)
		return false;
	for (var i = 0; i < str.length; i++) {
		var tempstr = str.charAt(i);
		if (isChinaese(tempstr)) {
			length = length + 2;
		} else {   
			length = length + 1;   
		}
	}
	if (length >= len) {
		return true;
	} else {
		return false;
	}
}


// 清除Form的验证信息，使用validate框架
function formCleanWarn(formId){
	$("#"+formId).validate().hideLabelAndError();
}
// 清除Form的验证信息和Form表单元素值
function formCleanAll(formId){
	formCleanWarn(formId);
	formClean(formId);
}

//验证元素是否大于规定长度
//如果大于规定长度返回true，并显示错误，否则返回false
//例如：isValidateLength('updateForm', 'businessCode', 10, 'bsCodeUpdateLength'),
//    验证form为‘updateForm’的businessCode元素长度是为大于10，如果大于10则返回true，并在bsCodeUpdateLength元素显示错误信息
//    注意elWarn元素是唯一的，el在不同form可以重名
function isInvalidLength(form, el, length, elWarn){
	if(isBeyondLength(Ext.getDom(form).elements[el], length)){
		Ext.getDom(elWarn).innerHTML="最大长度为" + length;
		return true;
	}else{
		Ext.getDom(elWarn).innerHTML="";
		return false;
	}
}
//验证元素是否为空
//如果为空返回true，并显示错误，否则返回false
function isInvalidEmpty(form, el, elWarn){
	if(isEmpty(Ext.getDom(form).elements[el])){
		Ext.getDom(elWarn).innerHTML="不可为空";
		return true;
	}else{
		Ext.getDom(elWarn).innerHTML="";
		return false;
	}
}
//清空验证信息
//清空span元素中id为UpdateRequire、UpdateLength、NewRequire、NewLength后缀的内容
//例如：invalidWarnClean('Update'),invalidWarnClean('New')
function invalidWarnClean(type){
	Ext.each(Ext.query("span[id$=" + type +"Require]"), function(item){
		item.innerHTML = "";
	});
	Ext.each(Ext.query("span[id$=" + type +"Length]"), function(item){
		item.innerHTML = "";
	});
}

// 比较两个数值的大小
function compare(a, b) {
	if (a > b) {
		return false;
	} else {
		return true;
	}
}

// 是否为日期（YYYY.MM）类型字符串
function isDotYMDate(str) {
	var r = str.match(/^(\d{4})(\.|\/)(\d{1,2})$/);
	if (r == null) {
		return false;
	} else {
		var temp = str.split(".");
		var intM;
		var tMonth = temp[1];
		if (tMonth == "08" || tMonth == "09") {
			intM = parseInt(temp[1], 10);
		} else {
			intM = parseInt(temp[1]);
		}
		if (intM > 0 && 12 >= intM) {
			return true;
		} else {
			return false;
		}
		// if(parseInt(temp[1])>0&&12>=parseInt(temp[1])){
		// return true;
		// }else{
		// return false;
		// }
	}
}
// 是否为日期（YYYY.MM.DD）类型字符串
function isDotDate(str) {
	var r = str.match(/^(\d{1,4})(\.)(\d{1,2})(\.)(\d{1,2})$/);
	if (r == null)
		return false;
	else
		return true;
}
// 是否为日期（YYYY-MM-DD）类型字符串
function isDate(str) {
	var r = str.match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/);
	if (r == null)
		return false;
	var d = new Date(r[1], r[3] - 1, r[4]);
	return (d.getFullYear() == r[1] && (d.getMonth() + 1) == r[3] && d
			.getDate() == r[4]);
}
// 判断是否是特殊字符
function isNotParticular(str) {
	if (!isNull(str)) {
		var myExp = /[\\~\!\@\#\$\%\^\&\*\\\-\_\+\=\[\]\{\}\|\\\;\:\'\"\,\.\/\<\>\?\)]+/;

		if (myExp.test(str)) {
			return true;
		} else {
			return false;
		}
	}
}

// 判断是否是有效的EMAIL地址
function isEmail(mail) {
	if (!isNull(mail)) {
		var myExp = /^[-_a-z0-9]+@([-_a-z0-9]+\.)+[a-z0-9]{2,3}$/;
		if (myExp.test(mail)) {
			return true;
		} else {
			return false;
		}
	}
}

// 验证身份证号码
function isIdCard(num) {
	var num1 = num.substr(0, num.length - 1);
	if (isNaN(num1)) {
		messageObj.infoMessage({
			title : '提示信息',
			text : '输入的身份证号码不是数字！'
		});
		return false;
	}
	var len = num.length, re;
	if (len == 15)
		re = new RegExp(/^(\d{6})()?(\d{2})(\d{2})(\d{2})(\d{3})$/);
	else if (len == 18)
		re = new RegExp(/^(\d{6})()?(\d{4})(\d{2})(\d{2})(\d{3})(\d)$/);
	else {
		messageObj.infoMessage({
			title : '提示信息',
			text : '输入的数字身份证号码位数不对！'
		});
		return false;
	}
	var a = num.match(re);
	if (a != null) {
		if (len == 15) {
			var D = new Date("19" + a[3] + "/" + a[4] + "/" + a[5]);
			var B = D.getYear() == a[3] && (D.getMonth() + 1) == a[4]
					&& D.getDate() == a[5];
		} else {
			var D = new Date(a[3] + "/" + a[4] + "/" + a[5]);
			var B = D.getFullYear() == a[3] && (D.getMonth() + 1) == a[4]
					&& D.getDate() == a[5];
		}
		if (!B) {
			messageObj.infoMessage({
				title : '提示信息',
				text : '输入的身份证号 ' + a[0] + ' 里出生日期不对！'
			});
			return false;
		}
	}
	return true;
}

// 验证身份证号码
function isIdCard(num, fun) {
	var num1 = (num.substring(0, 2)=='99')?num.substr(0, num.length - 3):num.substr(0, num.length - 1);
	if (isNaN(num1)) {
		messageObj.infoMessage({
			title : '提示信息',
			text : '输入的身份证号码不是数字！',
			fn : fun
		});
		return false;
	}
	var len = num.length, re;
	if (len == 15)
		re = new RegExp(/^(\d{6})()?(\d{2})(\d{2})(\d{2})(\d{3})$/);
	else if (len == 18)
		re = new RegExp(/^(\d{6})()?(\d{4})(\d{2})(\d{2})(\d{3})(\d)$/);
	else {
		messageObj.infoMessage({
			title : '提示信息',
			text : '输入的数字身份证号码位数不对！',
			fn : fun
		});
		return false;
	}
	var a = num.match(re);
	if (a != null) {
		if (len == 15) {
			var D = new Date("19" + a[3] + "/" + a[4] + "/" + a[5]);
			var B = D.getYear() == a[3] && (D.getMonth() + 1) == a[4]
					&& D.getDate() == a[5];
		} else {
			var D = new Date(a[3] + "/" + a[4] + "/" + a[5]);
			var B = D.getFullYear() == a[3] && (D.getMonth() + 1) == a[4]
					&& D.getDate() == a[5];
		}
		if (!B && '99' != num.substring(0, 2)) {
			messageObj.infoMessage({
				title : '提示信息',
				text : '输入的身份证号 ' + a[0] + ' 里出生日期不对！',
				fn : fun
			});
			return false;
		}
	}
	return true;
}

// 验证身份证号码
function isIdCardNew(x) {
	var num = x.value;
	if (isNull(num)) {
		return true;
	}
	var num1 = num.substr(0, num.length - 1);
	if (isNaN(num1)) {
		messageObj.infoMessage({
			title : '提示信息',
			text : '输入的身份证号码不是数字！',
			fn : function() {
				x.select();
			}
		});
		return false;
	}
	var len = num.length, re;
	if (len == 15)
		re = new RegExp(/^(\d{6})()?(\d{2})(\d{2})(\d{2})(\d{3})$/);
	else if (len == 18)
		re = new RegExp(/^(\d{6})()?(\d{4})(\d{2})(\d{2})(\d{3})(\d)$/);
	else {
		messageObj.infoMessage({
			title : '提示信息',
			text : '输入的数字身份证号码位数不对！',
			fn : function() {
				x.select();
			}
		});
		return false;
	}
	var a = num.match(re);
	if (a != null) {
		if (len == 15) {
			var D = new Date("19" + a[3] + "/" + a[4] + "/" + a[5]);
			var B = D.getYear() == a[3] && (D.getMonth() + 1) == a[4]
					&& D.getDate() == a[5];
		} else {
			var D = new Date(a[3] + "/" + a[4] + "/" + a[5]);
			var B = D.getFullYear() == a[3] && (D.getMonth() + 1) == a[4]
					&& D.getDate() == a[5];
		}
		if (!B) {
			messageObj.infoMessage({
				title : '提示信息',
				text : '输入的身份证号 ' + a[0] + ' 里出生日期不对！',
				fn : function() {
					x.select();
				}
			});
			return false;
		}
	}
	return true;
}

// 判断是否为非负整数
function isInteger(a) {
	if (!/^\d*$/.test(a)) {
		return false;
	}
	if (parseInt(a) < 0) {
		return false;
	}
	return true;
}

/*******************************************************************************
 * 函数名称：IsTelephone 函数功能：固话，手机号码检查函数，合法返回true,反之,返回false 函数参数：obj,待检查的号码 检查规则：
 * (1)电话号码由数字、"("、")"和"-"构成 (2)电话号码为3到8位
 * 
 * (3)如果电话号码中包含有区号，那么区号为三位或四位
 * 
 * (4)区号用"("、")"或"-"和其他部分隔开 (5)移动电话号码为11或12位，如果为12位,那么第一位为0
 * (6)11位移动电话号码的第一位和第二位为"13" (7)12位移动电话号码的第二位和第三位为"13"
 ******************************************************************************/
function isTelephone(obj) {
	var pattern = /^(([0\+]\d{2,3}-)?(0\d{2,3})-)?(\d{7,8})(-(\d{3,}))?$/;
	return (pattern.test(obj)) ? true : false;
}

// 判断是否为浮点数
function isFloat(str) {
	str = toMoney(str);
	var re = /^\d{0,}.\d{2}$/g;// 判断字符串是否为数字 小数点后只能两位
	// ^[0-9]+.?[0-9]*$/;// 判断字符串是否为数字
	if (re.test(str)) {
		return true;
	} else {
		return false;
	}
}
// 判断是否为浮点数
function isFloat2(str) {
	str = toMoney(str);
	var pat = /^-?\d+(\.\d{1,2})?$/;// 判断字符串是否为数字 小数点后只能两位
	if (pat.test(str)) {
		return true;
	} else {
		return false;
	}
}

//判断是否为一位小数或整数
function isFloat3(str) {
	var re = /^[0-9]+\.?[0-9]{0,1}$/;// 判断字符串是否为数字 小数点后只能1位
	if (re.test(str)) {
		return true;
	} else {
		return false;
	}
}
// 判断是否为邮编
function isPostCode(postCode) {
	if (!isNull(postCode)) {
		if (postCode.length != 6) {
			return false;
		}
		if (!isInteger(postCode)) {
			return false;
		} else {
			return true;
		}
	}
}
// 判断是否为邮编
function isPostCodeDwdj(postCode) {
	if (!isNull(postCode)) {
		if (postCode.length != 6) {
			return false;
		}
		if (!isInteger(postCode)) {
			return false;
		} else {
			// var pattern = /^([0]\d{5})$/;
			// var pattern1 = /^(\d{1}00000)$/;
			// if(pattern.test(postCode)){//第一位不能是0
			// return false;
			// }else
			// if(pattern1.test(postCode)){//后五位不能全部是0
			// return false;
			// }else{
			// return true;
			// }
			if (postCode.substr(1, 5) == '00000') {
				return false;
			} else {
				return true;
			}
		}
	}
}
function isDwJbrTel(tel) {// 前6为必须是数字
	var pattern = /^(\d{6})\s*/g;
	if (pattern.test(tel)) {
		return true;
	} else {
		return false;
	}
}
function isLxdhE(tel, o) {// 前8为必须是数字
	if (typeof(tel) != 'undefined' && tel != null && tel != '') {
		var pattern = /^(\d{8})\s*/g;
		if (pattern.test(tel)) {
			return true;
		} else {
			messageObj.infoMessage({
				title : '操作提示',
				text : '联系电话前8位必须是数字!',
				fn : function() {
					if (o) {
						o.select();
					}
				}
			});
			return false;
		}
	}
	return true;
}
function isLengthByte(str, len) {// 必须大于等于len个字节
	var length = 0;
	if (str == null)
		return false;
	for (var i = 0; i < str.length; i++) {
		var tempstr = str.charAt(i);
		if (isChinaese(tempstr)) {
			length = length + 2;
		} else {
			length = length + 1;
		}

	}
	if (length >= len) {
		return true;
	} else {
		return false;
	}
}
function isLengthByte1(str, len) {// 必须大于len个字节
	var length = 0;
	if (str == null)
		return false;
	for (var i = 0; i < str.length; i++) {
		var tempstr = str.charAt(i);
		if (isChinaese(tempstr)) {
			length = length + 2;
		} else {
			length = length + 1;
		}

	}
	if (length > len) {
		return true;
	} else {
		return false;
	}
}
function isChinaese(str) {
	if (/^[\u4e00-\u9fa5]+$/.test(str)) {
		return true;
	} else {
		return false;
	}
}

// 移动电话(手机），样式:13531214732或013531214732
function isMoveTel(elem) {
	var pattern = /^0{0,1}13[0-9]{9}$/;
	var pattern1 = /^0{0,1}15[0-9]{9}$/;
	if (!isNull(elem)) {
		if (pattern.test(elem) || pattern1.test(elem)) {
			return true;
		} else {
			return false;
		}
	}
}

// 判断输入的字符串是不是英文
function isCharsInBagEn(s, bag) {
	var i, c;
	for (i = 0; i < s.length; i++) {
		c = s.charAt(i);// 字符串s中的字符
		if (bag.indexOf(c) < 0)
			return c;
	}
	return "";
}

function isEn(s) {
	var errorChar;
	var badChar = " ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	errorChar = isCharsInBagEn(s, badChar)
	return (errorChar != "") ? false : true;
}

function isEnNotE(s) {
	var errorChar;
	var badChar = " ABCDFGHIJKLMNOPQRSTUVWXYZabcdfghijklmnopqrstuvwxyz";
	errorChar = isCharsInBagEn(s, badChar)
	return (errorChar != "") ? false : true;
}

/*******************************************************************************
 * 函数名称：lTrim 函数功能：去除左边的空格 函数参数：str,需要处理的字符串
 ******************************************************************************/
function lTrim(str) {
	return str.replace(/(^\s*)/g, "");
}

/*******************************************************************************
 * 函数名称：rTrim 函数功能：去除右边的空格 函数参数：str,需要处理的字符串
 ******************************************************************************/
function rTrim(str) {
	return str.replace(/(\s*$)/g, "");
}

/*******************************************************************************
 * 函数名称：isNull 函数功能：判断给定字符串是否为空 函数参数：str,需要处理的字符串
 ******************************************************************************/
function isNull(str) {
	if (str == null) {
		return true;
	} else if (String(str).trim() == "") {
		return true;
	} else {
		return false;
	}
}

// 判断是否是空JS对象
function isNullObject(obj) {
	return (typeof obj == 'undefine' || !obj || obj == null);
}

/**
 * 向方法中加入obj对象的值,返回map if map.is_ok == 1 有错误, 提示信息为 map.msg else map.is_ok == 2
 * 有返回值,及 map.rs 返回类型为 yyyy.mm类型
 */
function dateYMReturnMap(objString) {

	var map = {};
	var objValue = objString.trim();

	if (objValue == "") {
		map.is_ok = 1;
		map.msg = "不能为空!";
		return map;
	}

	var reg = /^[0-9]\d*(\.\d+)?$/;
	if (!reg.test(objValue)) {
		map.is_ok = 1;
		map.msg = "不是日期格式!";
		return map;
	}
	if (objString.length > 7) {
		map.is_ok = 1;
		map.msg = "不是日期格式!";
		return map;
	}
	var newValue = "";
	var index = objValue.indexOf(".");
	var objLength = objValue.length;
	var fontValue, backValue;

	if (index == -1) {
		switch (objLength) {
			case 3 :
				fontValue = objValue.substring(0, 2);
				backValue = objValue.substring(2, 3);
				newValue = "20" + fontValue;
				break;
			case 4 :
				fontValue = objValue.substring(0, 2);
				backValue = objValue.substring(2, 4);
				newValue = "20" + fontValue;
				break;
			case 6 :
				fontValue = objValue.substring(0, 4);
				backValue = objValue.substring(4, 6);
				newValue = fontValue;
				break;
			default :
				map.is_ok = 1;
				map.msg = "必须按 YYYY.MM的格式输入日期!";
				return map;
		}
	} else {

		fontValue = checkBack(objValue.substring(0, index));
		backValue = objValue.substring(index + 1, objLength);

		if (isNaN(parseInt(fontValue))) {
			map.is_ok = 1;
			map.msg = "必须按 YYYY.MM的格式输入日期.";
			return map;
		}
		if (isNaN(parseInt(backValue))) {
			map.is_ok = 1;
			map.msg = "必须按 YYYY.MM的格式输入日期.";
			return map;
		}
		// 测试年
		if (fontValue == "0" || fontValue == "0000") {
			map.is_ok = 1;
			map.msg = "年份必须是 00-99 或 1000-4712!";
			return map;
		}
		if (fontValue.length >= 5) {
			map.is_ok = 1;
			map.msg = "必须按 YYYY.MM的格式输入日期.";
			return map;
		}
		switch (fontValue.length) {
			case 1 :
				newValue = "200" + fontValue;
				break;
			case 2 :
				newValue = "20" + fontValue;
				break;
			case 3 :
				newValue = "0" + fontValue;
				break;
			case 4 :
				newValue = fontValue;
				break;
			default :
				map.is_ok = 1;
				map.msg = "必须按 YYYY.MM的格式输入日期.";
				return map;
		}
	}

	backValue = checkBack(backValue);
	// 测试月
	if (changeNum(backValue) == 0) {
		map.is_ok = 1;
		map.msg = "必须按 YYYY.MM的格式输入日期.";
		return map;
	}

	if (changeNum(backValue) > 12 || changeNum(backValue) < 1) {
		map.is_ok = 1;
		map.msg = "月份必须在 1-12 之间";
		return map;
	}

	if (changeNum(backValue) < 10) {
		if (backValue.length == 2) {
			newValue += "." + backValue;
		} else {
			newValue += "." + "0" + backValue;
		}
	} else {
		newValue += "." + backValue;
	}
	map.is_ok = 2;
	map.rs = newValue;
	return map;
}

function dateYMReturnMap2(objString) {

	var map = {};
	var objValue = objString.trim();

	if (objValue == "") {
		map.is_ok = 1;
		map.msg = "不能为空!";
		return map;
	}

	var reg = /^[0-9]\d*(\.\d+)?$/;
	if (!reg.test(objValue)) {
		map.is_ok = 1;
		map.msg = "不是日期格式!";
		return map;
	}
	if (objString.length > 7) {
		map.is_ok = 1;
		map.msg = "不是日期格式!";
		return map;
	}
	var newValue = "";
	var index = objValue.indexOf(".");
	var objLength = objValue.length;
	var fontValue, backValue;

	if (index == -1) {
		switch (objLength) {
			case 6 :
				fontValue = objValue.substring(0, 4);
				backValue = objValue.substring(4, 6);
				newValue = fontValue;
				break;
			default :
				map.is_ok = 1;
				map.msg = "必须按 YYYY.MM的格式输入日期!";
				return map;
		}
	} else {

		fontValue = checkBack(objValue.substring(0, index));
		backValue = objValue.substring(index + 1, objLength);

		if (isNaN(parseInt(fontValue))) {
			map.is_ok = 1;
			map.msg = "必须按 YYYY.MM的格式输入日期.";
			return map;
		}
		if (isNaN(parseInt(backValue))) {
			map.is_ok = 1;
			map.msg = "必须按 YYYY.MM的格式输入日期.";
			return map;
		}
		// 测试年
		if (fontValue == "0" || fontValue == "0000") {
			map.is_ok = 1;
			map.msg = "年份必须是 00-99 或 1000-4712!";
			return map;
		}
		if (fontValue.length >= 5) {
			map.is_ok = 1;
			map.msg = "必须按 YYYY.MM的格式输入日期.";
			return map;
		}
		switch (fontValue.length) {
			case 1 :
				newValue = "200" + fontValue;
				break;
			case 2 :
				newValue = "20" + fontValue;
				break;
			case 3 :
				newValue = "0" + fontValue;
				break;
			case 4 :
				newValue = fontValue;
				break;
			default :
				map.is_ok = 1;
				map.msg = "必须按 YYYY.MM的格式输入日期.";
				return map;
		}
	}

	backValue = checkBack(backValue);
	// 测试月
	if (changeNum(backValue) == 0) {
		map.is_ok = 1;
		map.msg = "必须按 YYYY.MM的格式输入日期.";
		return map;
	}

	if (changeNum(backValue) > 12 || changeNum(backValue) < 1) {
		map.is_ok = 1;
		map.msg = "月份必须在 1-12 之间";
		return map;
	}

	if (changeNum(backValue) < 10) {
		if (backValue.length == 2) {
			newValue += "." + backValue;
		} else {
			newValue += "." + "0" + backValue;
		}
	} else {
		newValue += "." + backValue;
	}
	map.is_ok = 2;
	map.rs = newValue;
	return map;
}

function focus_select_null(fid, sid, nid) {
	/*
	 * if(typeof nid != "undefined"&&nid!=null){
	 * document.getElementById(nid).value=""; }
	 * 
	 * if(typeof sid != "undefined"&&sid!=null){
	 * document.getElementById(sid).select(); } if(typeof fid !=
	 * "undefined"&&fid!=null){ document.getElementById(fid).focus(); }
	 */
}
/**
 * 把日期格式转换成YYYY.MM型 返回为文本,把值给obj.value 在text中 加入
 * onKeyDown="if(event.keyCode==13) dateYM(this)"
 */
function dateYM(obj) {
	var r;
	var objValue = obj.value.trim();

	if (isNull(objValue)) {
		return false;
	}

	var objLength = objValue.length;
	if (objLength > 7) {
		selAlert("不是日期格式!", function() {
			obj.select()
		});
		return false;
	}

	var reg = /^[0-9]\d*(\.\d+)?$/;
	if (!reg.test(objValue)) {
		selAlert("不是日期格式!", function() {
			obj.select()
		});
		return false;
	}

	var newValue = "";
	var index = objValue.indexOf(".");
	var fontValue, backValue;
	if (index == -1) {
		switch (objLength) {
			case 3 :
				fontValue = objValue.substring(0, 2);
				backValue = objValue.substring(2, 3);
				newValue = "20" + fontValue;
				break;
			case 4 :
				fontValue = objValue.substring(0, 2);
				backValue = objValue.substring(2, 4);
				newValue = "20" + fontValue;
				break;
			case 6 :
				fontValue = objValue.substring(0, 4);
				backValue = objValue.substring(4, 6);
				newValue = fontValue;
				break;
			default :
				selAlert("必须按 YYYY.MM的格式输入日期.", function() {
					obj.select()
				});
				obj.select();
				return false;
		}
	} else {

		fontValue = checkBack(objValue.substring(0, index));
		backValue = objValue.substring(index + 1, objLength);

		// 测试年
		if (fontValue == "0" || fontValue == "0000") {
			selAlert("年份必须是 00-99 或 1000-4712", function() {
				obj.select()
			});
			obj.select();
			return false;
		}
		if (fontValue.length >= 5) {
			selAlert("必须按 YYYY.MM的格式输入日期.", function() {
				obj.select()
			});
			obj.select();
			return false;
		}
		switch (fontValue.length) {
			case 1 :
				newValue = "200" + fontValue;
				break;
			case 2 :
				newValue = "20" + fontValue;
				break;
			case 3 :
				newValue = "0" + fontValue;
				break;
			case 4 :
				newValue = fontValue;
				break;
			default :
				selAlert("必须按 YYYY.MM的格式输入日期.", function() {
					obj.select()
				});
				return false;
		}
	}

	backValue = checkBack(backValue);
	// 测试月
	if (changeNum(backValue) == 0) {
		selAlert("必须按 YYYY.MM的格式输入日期.", function() {
			obj.select()
		});
		obj.select();
		return false;
	}

	if (changeNum(backValue) > 12 || changeNum(backValue) < 1) {
		selAlert("月份必须在 1-12 之间", function() {
			obj.select()
		});
		obj.select();
		return false;
	}

	if (changeNum(backValue) < 10) {
		if (backValue.length == 2) {
			newValue += "." + backValue;
		} else {
			newValue += "." + "0" + backValue;
		}
	} else {
		newValue += "." + backValue;
	}
	obj.value = newValue;
	return true;
}

// cyj
function isValYM(rqObj, isNull) {
	var r;
	var isnull = false;
	var objValue = document.getElementById(rqObj).value.trim();
	var objLength = objValue.length;
	if (typeof isNull != "undefined") {
		isnull = isNull;
	}
	if (objValue == "") {
		if (!isnull) {
			return "";
		} else {
			focus_select_null(rqObj, rqObj);
			return "必填项不能为空";
		}
	} else {
		if (objValue.length > 7) {
			objValue = objValue.substr(0, 7);
		}
	}
	var reg = /^[0-9]\d*(\.\d+)?$/;
	if (!reg.test(objValue)) {
		focus_select_null(rqObj, rqObj);
		return "不是日期格式";
	}

	var newValue = "";
	var index = objValue.indexOf(".");
	var fontValue, backValue;
	if (index == -1) {
		switch (objLength) {
			case 3 :
				fontValue = objValue.substring(0, 2);
				backValue = objValue.substring(2, 3);
				newValue = "20" + fontValue;
				break;
			case 4 :
				fontValue = objValue.substring(0, 2);
				backValue = objValue.substring(2, 4);
				newValue = "20" + fontValue;
				break;
			case 6 :
				fontValue = objValue.substring(0, 4);
				backValue = objValue.substring(4, 6);
				newValue = fontValue;
				break;
			default :
				focus_select_null(rqObj, rqObj);
				return "必须按 YYYY.MM的格式输入日期.";
		}
	} else {

		fontValue = checkBack(objValue.substring(0, index));
		backValue = objValue.substring(index + 1, objLength);

		// 测试年
		if (fontValue == "0" || fontValue == "0000") {
			focus_select_null(rqObj, rqObj);
			return "年份必须是 00-99 或 1000-4712";
		}
		if (fontValue.length >= 5) {
			focus_select_null(rqObj, rqObj);
			return "必须按 YYYY.MM的格式输入日期.";
		}
		switch (fontValue.length) {
			case 1 :
				newValue = "200" + fontValue;
				break;
			case 2 :
				newValue = "20" + fontValue;
				break;
			case 3 :
				newValue = "0" + fontValue;
				break;
			case 4 :
				newValue = fontValue;
				break;
			default :
				focus_select_null(rqObj, rqObj);
				return "必须按 YYYY.MM的格式输入日期.";
		}
	}

	backValue = checkBack(backValue);
	// 测试月
	if (changeNum(backValue) == 0) {
		focus_select_null(rqObj, rqObj);
		return "必须按 YYYY.MM的格式输入日期.";
	}

	if (changeNum(backValue) > 12 || changeNum(backValue) < 1) {
		focus_select_null(rqObj, rqObj);
		return "月份必须在 1-12 之间";
	}

	if (changeNum(backValue) < 10) {
		if (backValue.length == 2) {
			newValue += "." + backValue;
		} else {
			newValue += "." + "0" + backValue;
		}
	} else {
		newValue += "." + backValue;
	}
	document.getElementById(rqObj).value = newValue;
	return "";
}
// cyj
function getValYM(rqtext) {
	var r;
	var objValue = rqtext.trim();
	var objLength = objValue.length;

	if (objValue.length > 7) {
		objValue = objValue.substr(0, 7);
	}

	var reg = /^[0-9]\d*(\.\d+)?$/;
	if (!reg.test(objValue)) {
		return "1";
	}

	var newValue = "";
	var index = objValue.indexOf(".");
	var fontValue, backValue;
	if (index == -1) {
		switch (objLength) {
			case 3 :
				fontValue = objValue.substring(0, 2);
				backValue = objValue.substring(2, 3);
				newValue = "20" + fontValue;
				break;
			case 4 :
				fontValue = objValue.substring(0, 2);
				backValue = objValue.substring(2, 4);
				newValue = "20" + fontValue;
				break;
			case 6 :
				fontValue = objValue.substring(0, 4);
				backValue = objValue.substring(4, 6);
				newValue = fontValue;
				break;
			default :
				return "5";
		}
	} else {

		fontValue = checkBack(objValue.substring(0, index));
		backValue = objValue.substring(index + 1, objLength);

		// 测试年
		if (fontValue == "0" || fontValue == "0000") {
			return "2";
		}
		if (fontValue.length >= 5) {
			return "5";
		}
		switch (fontValue.length) {
			case 1 :
				newValue = "200" + fontValue;
				break;
			case 2 :
				newValue = "20" + fontValue;
				break;
			case 3 :
				newValue = "0" + fontValue;
				break;
			case 4 :
				newValue = fontValue;
				break;
			default :
				return "5";
		}
	}

	backValue = checkBack(backValue);
	// 测试月
	if (changeNum(backValue) == 0) {
		return "5";
	}

	if (changeNum(backValue) > 12 || changeNum(backValue) < 1) {
		return "3";
	}

	if (changeNum(backValue) < 10) {
		if (backValue.length == 2) {
			newValue += "." + backValue;
		} else {
			newValue += "." + "0" + backValue;
		}
	} else {
		newValue += "." + backValue;
	}
	return newValue;
}
/**
 * 把obj.value的值转化成 YYYY.MM.DD形式 在text中 加入 onKeyDown="if(event.keyCode==13)
 * dateYMD(this)"
 */
function dateYMD(obj) {
	var objValue = obj.value.trim();

	if (isNull(objValue)) {
		return false;
	}
	/*
	 * if (objValue.length > 10) { selAlert("不是日期格式!", function() { obj.select()
	 * }); obj.select(); return false; }
	 */
	var reg = /^[0-9]\d*(\.\d+)?(\.\d+)?$/;
	if (!reg.test(objValue)) {
		selAlert("不是日期格式!", function() {
			obj.select()
		});
		obj.select();
		return false;
	}
	var objArray = objValue.split(".");
	var newValue = "";
	if (objArray.length == 3) {
		var year = checkBack(objArray[0]);
		var month = checkBack(objArray[1]);
		var day = checkBack(objArray[2]);
		if (!isInteger(year)) {
			selAlert("年份必须是 00-99 或 1000-4712", function() {
				obj.select()
			});
			obj.select();
			return false;
		}
		if (!isInteger(month) || !isInteger(day)) {
			selAlert("必须按 YYYY.MM.DD 的格式输入日期.", function() {
				obj.select()
			});
			obj.select();
			return false;
		}
		if (year == "00" || year == "0000") {
			selAlert("年份必须是 00-99 或 1000-4712", function() {
				obj.select()
			});
			obj.select();
			return false;
		}
		switch (year.length) {
			case 1 :
				newValue = "200" + year;
				break;
			case 2 :
				newValue = "20" + year;
				break;
			case 3 :
				newValue = "0" + year;
				break;
			default :
				newValue = year;
		}
		if (month.length == 2) {
			newValue += "." + month;
		} else {
			newValue += ".0" + month;
		}

		var dayNow = getSelfDay(year, month);
		if (parseInt(day) <= parseInt(dayNow)) {
			if (day.length == 2) {
				newValue += "." + day;
			} else {
				newValue += ".0" + day;
			}
		} else {
			selError("输入日期错误!", function() {
				obj.select()
			});
			obj.select();
			return false;
		}
		obj.value = newValue;
	} else {
		var length = objValue.length;
		var year, month, day;
		switch (length) {
			case 8 :
				year = objValue.substring(0, 4);
				month = objValue.substring(4, 6);
				if (parseInt(month) > 12) {
					selAlert("必须按YYYY.MM.DD的格式输入日期. ", function() {
						obj.select();
					});
					return false;
				}
				month = checkback3(month);
				day = objValue.substring(6, 8);
				var day2 = getSelfDay(year, month);
				if (parseInt(day) > parseInt(day2)) {
					selAlert("必须按YYYY.MM.DD的格式输入日期. ", function() {
						obj.select();
					});
					return false;
				}
				day = checkback3(day);
				obj.value = year + "." + month + "." + day;
				break;
			case 6 :
				year = "20" + objValue.substring(0, 2);
				month = objValue.substring(2, 4);
				if (parseInt(month) > 12) {
					selAlert("必须按YYYY.MM.DD的格式输入日期. ", function() {
						obj.select();
					});
					return false;
				}
				month = checkback3(month);
				day = objValue.substring(4, 6);
				var day2 = getSelfDay(year, month);
				if (parseInt(day) > parseInt(day2)) {
					selAlert("必须按YYYY.MM.DD的格式输入日期. ", function() {
						obj.select();
					});
					return false;
				}
				day = checkback3(day);
				obj.value = year + "." + month + "." + day;
				break;
			default :
				selAlert("必须按YYYY.MM.DD的格式输入日期. ", function() {
					obj.select();
				});
				return false;
		}
	}
	return true;
}
function isValYMD(rqObj, isNull) {
	var isnull = false;
	var objValue = document.getElementById(rqObj).value.trim();

	if (typeof isNull != "undefined") {
		isnull = isNull;
	}
	if (objValue == "") {
		if (!isnull) {
			return "";
		} else {
			focus_select_null(rqObj, rqObj);
			return "必填项不能为空";
		}
	} else {
		if (objValue.length > 10 || objValue.length < 6) {
			focus_select_null(rqObj, rqObj);
			return "不是日期格式!";
		}
		var t = objValue.split(".");
		if (t.length < 3) {
			objValue = addPoint(t);
		} else {
			objValue = objValue.substr(0, 10);
		}
	}

	var reg = /^[0-9]\d*(\.\d+)?(\.\d+)?$/;
	if (!reg.test(objValue)) {
		focus_select_null(rqObj, rqObj);
		return "不是日期格式!";
	}
	var objArray = objValue.split(".");
	var newValue = "";
	if (objArray.length == 3) {
		var year = checkBack(objArray[0]);
		var month = checkBack(objArray[1]);
		var day = checkBack(objArray[2]);
		if (!isInteger(year)) {
			focus_select_null(rqObj, rqObj);
			return "年份必须是 00-99 或 1000-4712";
		}
		if (!isInteger(month) || !isInteger(day)) {
			focus_select_null(rqObj, rqObj);
			return "必须按 YYYY.MM.DD 的格式输入日期.";
		}
		if (year == "00" || year == "0000") {
			focus_select_null(rqObj, rqObj);
			return "年份必须是 00-99 或 1000-4712";
		}
		switch (year.length) {
			case 1 :
				newValue = "200" + year;
				break;
			case 2 :
				newValue = "20" + year;
				break;
			case 3 :
				newValue = "0" + year;
				break;
			default :
				newValue = year;
		}
		if (month.length == 2) {
			newValue += "." + month;
		} else {
			newValue += ".0" + month;
		}

		var dayNow = getSelfDay(year, month);
		if (parseInt(day) <= parseInt(dayNow)) {
			if (day.length == 2) {
				newValue += "." + day;
			} else {
				newValue += ".0" + day;
			}
		} else {
			focus_select_null(rqObj, rqObj);
			return "输入日期错误!";
		}
		document.getElementById(rqObj).value = newValue;
	} else {
		focus_select_null(rqObj, rqObj);
		return "必须按YYYY.MM.DD的格式输入日期.";
	}
	return "";
}

function getValYMD(rqtext) {
	var objValue = rqtext.trim();

	if (objValue.length < 6) {
		return "1";
	}
	var t = objValue.split(".");
	if (t.length < 3) {
		objValue = addPoint(t);
	} else {
		objValue = objValue.substr(0, 10);
	}

	var reg = /^[0-9]\d*(\.\d+)?(\.\d+)?$/;
	if (!reg.test(objValue)) {
		return "1";
	}
	var objArray = objValue.split(".");
	var newValue = "";
	if (objArray.length == 3) {
		var year = checkBack(objArray[0]);
		var month = checkBack(objArray[1]);
		var day = checkBack(objArray[2]);
		if (!isInteger(year)) {
			return "2";
		}
		if (!isInteger(month) || !isInteger(day)) {
			return "4";
		}
		if (year == "00" || year == "0000") {
			return "2";
		}
		switch (year.length) {
			case 1 :
				newValue = "200" + year;
				break;
			case 2 :
				newValue = "20" + year;
				break;
			case 3 :
				newValue = "0" + year;
				break;
			default :
				newValue = year;
		}
		if (month.length == 2) {
			newValue += "." + month;
		} else {
			newValue += ".0" + month;
		}

		var dayNow = getSelfDay(year, month);
		if (parseInt(day) <= parseInt(dayNow)) {
			if (day.length == 2) {
				newValue += "." + day;
			} else {
				newValue += ".0" + day;
			}
		} else {
			return "1";
		}
	} else {
		return "4";
	}
	return newValue;
}

function getDateInfo(count) {
	var reg = /\d$/;
	if (count.length == 1) {
		if (!reg.test(count)) {
			return "";
		} else {
			return eval("DATEERROR_" + count);
		}
	} else {
		return "";
	}
}
/**
 * 用string 输入的字符串的 来输出map if is_ok = "1" 有错误 msg 为提示信息 if is_ok = "2" 正确, rs
 * 为yyyy.mm.dd格式
 */
function dateYMDReturnMap(string) {
	var map = {};
	var objValue = string;
	if (isNull(objValue)) {
		map.is_ok = "1";
		map.msg = "不准为空!";
		return map;
	}
	var reg = /^[0-9]\d*(\.\d+)?(\.\d+)?$/;
	if (!reg.test(objValue)) {
		map.is_ok = "1";
		map.msg = "不是日期格式!";
		return map;
	}
	/*
	 * if (string.length > 10) { map.is_ok = "1"; map.msg = "不是日期格式!"; return
	 * map; }
	 */
	var objArray = objValue.split(".");
	var newValue = "";
	if (objArray.length == 3) {
		var year = checkBack(objArray[0]);
		var month = checkBack(objArray[1]);
		var day = checkBack(objArray[2]);
		if (!isInteger(year)) {
			map.is_ok = "1";
			map.msg = "年份必须是 00-99 或 1000-4712";
			return map;
		}
		if (!isInteger(month) || !isInteger(day)) {
			map.is_ok = "1";
			map.msg = "必须按 YYYY.MM.DD 的格式输入日期.";
			return map;
		}
		if (year == "00" || year == "0000") {
			map.is_ok = "1";
			map.msg = "年份必须是 00-99 或 1000-4712";
			return map;
		}
		switch (year.length) {
			case 1 :
				newValue = "200" + year;
				break;
			case 2 :
				newValue = "20" + year;
				break;
			case 3 :
				newValue = "0" + year;
				break;
			default :
				newValue = year;
		}
		if (month.length == 2) {
			newValue += "." + month;
		} else {
			newValue += ".0" + month;
		}

		var dayNow = getSelfDay(year, month);
		if (parseInt(day) <= parseInt(dayNow)) {
			if (day.length == 2) {
				newValue += "." + day;
			} else {
				newValue += ".0" + day;
			}
		} else {
			map.is_ok = "1";
			map.msg = "输入日期错误!";
			return map;
		}
	} else {
		var length = objValue.length;
		switch (length) {
			case 8 :
				var year = objValue.substring(0, 4);
				var month = objValue.substring(4, 6);
				if (parseInt(month) > 12) {
					map.is_ok = "1";
					map.msg = "必须按YYYY.MM.DD的格式输入日期.";
					return map;
				}
				var day = objValue.substring(6, 8);
				var day2 = getSelfDay(year, month);
				if (parseInt(day) > parseInt(day2)) {
					map.is_ok = "1";
					map.msg = "必须按YYYY.MM.DD的格式输入日期.";
					return map;
				}
				newValue = year + "." + month + "." + day;
				break;
			case 6 :
				year = "20" + objValue.substring(0, 2);
				month = objValue.substring(2, 4);
				if (parseInt(month) > 12) {
					map.is_ok = "1";
					map.msg = "必须按YYYY.MM.DD的格式输入日期.";
					return map;
				}
				month = checkback3(month);
				day = objValue.substring(4, 6);
				var day2 = getSelfDay(year, month);
				if (parseInt(day) > parseInt(day2)) {
					map.is_ok = "1";
					map.msg = "必须按YYYY.MM.DD的格式输入日期.";
					return map;
				}
				day = checkback3(day);
				newValue = year + "." + month + "." + day;
				break;
			default :
				map.is_ok = "1";
				map.msg = "必须按YYYY.MM.DD的格式输入日期. ";
				return map;
		};
	}
	map.is_ok = "2";
	map.rs = newValue;
	return map;
}

// 把value值转成数字型
function changeNum(value) {
	return value == "" ? 0 : parseInt(value);
}

// 判断两位数时,第一位是否为0,如08转换成8
function checkBack(value) {
	if (value.length >= 2) {
		if (value.substring(0, 1) == 0) {
			value = value.substring(1, 2);
		}
	}
	return value;
}

// 把 2 --> 02
function checkback3(value) {
	if (value.length < 2) {
		value = "0" + value;
	}
	return value
}

/**
 * 得到radio中的value值 rName radio的name
 */
function getRadio(rName) {
	var radioS = document.getElementsByName(rName);
	var value = "";
	for (var i = 0; i < radioS.length; i++) {
		if (radioS[i].checked) {
			value = radioS[i].value;
			break;
		}
	}
	return value;
}

// 操作提示
function selAlert(text) {
	messageObj.infoMessage({
		title : '操作提示',
		text : text
	});
}
function selAlert(text, fun) {
	messageObj.infoMessage({
		title : '操作提示',
		text : text,
		fn : fun
	});
}
// 操作失败
function selError(text) {
	messageObj.errorMessage({
		title : '操作失败',
		text : text
	});
}
function selError(text, fun) {
	messageObj.errorMessage({
		title : '操作失败',
		text : text,
		fn : fun
	});
}
// 操作成功
function selOk(text) {
	messageObj.okMessage({
		title : '操作成功',
		text : text
	});
}
function selOk(text, fun) {
	messageObj.okMessage({
		title : '操作成功',
		text : text,
		fn : fun
	});
}

function selMessage(title, text, fun) {
	messageObj.confirm1Message({
		title : title,
		text : text,
		fn : fun
	});
}

/**
 * 返回 当年,当月一共有多少天 当2月为闰年时,返回 29 当为平年时,返回28
 */
function getSelfDay(year, month) {
	if (month == "2") {
		var num = changeNum(year);
		if (num % 400 == 0 || (num % 4 == 0 && num % 100 != 0)) {
			return "29";
		} else {
			return "28";
		}
	}
	var value = ["31", "29", "31", "30", "31", "30", "31", "31", "30", "31",
			"30", "31"];
	var monthIndex = value[month - 1];
	return monthIndex;
}

function setTxt2Txt(txtId1, txtId2) {
	if (isNull($(txtId2).value)) {
		$(txtId2).value = $(txtId2).value;
	}
}

function zzs(a) {
	if (!isInteger(a.value)) {
		messageObj.infoMessage({
			title : '操作提示',
			text : "请输入合法正整数!",
			fn : function() {
				a.value = a.defaultValue;
				a.select();
			}
		});
		return false;
	}
}
/**
 * 判断 日期 止rqz 大于日期起 rqq rqq 起日期 rqz 止日期
 */
function checkRQ(rqq, rqz) {

	var indexQ = rqq.lastIndexOf(".");
	var indexZ = rqz.lastIndexOf(".");

	var lastRqq = rqq.substring(rqq.lastIndexOf(".") + 1);
	var lastRqz = rqz.substring(rqz.lastIndexOf(".") + 1);

	var fontRqq = rqq.substring(0, rqq.lastIndexOf("."));
	var fontRqz = rqz.substring(0, rqz.lastIndexOf("."));

	fontRqq = parseFloat(fontRqq);
	fontRqz = parseFloat(fontRqz);
	if (fontRqq >= fontRqz) {
		{
			lastRqq = parseInt(lastRqq);
			lastRqz = parseInt(lastRqz);
			if (lastRqq > lastRqz)
				return true;
			else
				return false;
		}
	} else {
		return false;
	}
}

// 日期必须是YYYY.MM.DD格式
function checkDotYMDDate(str) {
	// 如果为空，则通过校验
	if (!str)
		return true;
	if (str.length <= 7)
		str += ".01";
	var pattern = /^((\d{4})|(\d{2}))\.(\d{1,2})\.(\d{1,2})$/g;
	if (!pattern.test(str))
		return false;
	var arrDate = str.split(".");
	if (parseInt(arrDate[0], 10) < 100)
		arrDate[0] = 2000 + parseInt(arrDate[0], 10) + "";
	var date = new Date(arrDate[0], (parseInt(arrDate[1], 10) - 1) + "",
			arrDate[2]);
	if (date.getYear() == arrDate[0]
			&& date.getMonth() == (parseInt(arrDate[1], 10) - 1) + ""
			&& date.getDate() == arrDate[2])
		return true;
	else
		return false;
}

// 日期自动补0例如(2008.2->2008.02),但必须在日期验证(checkDotYMDDate)合法后调用
function dateAddZero(str) {
	if (str.substr(str.indexOf(".") + 1).indexOf(".") != -1) {
		var strArray = str.split(".");

		if (str && strArray[1].length != 2) {
			str = str.substr(0, 5) + "0" + str.substr(5, str.length);
		}

		if (str && strArray[2].length != 2) {
			str = str.substr(0, 8) + "0" + str.substr(8);
		}
	} else {
		if (str && str.substr(str.indexOf(".")).length != 3) {
			str = str.substr(0, 5) + "0" + str.substr(5, 6);
		}
	}
	return str;
}

// -->
function isMoveTelNew(elem) {
	var pattern = /^1[3,5,8]{1}[0-9]{9}$/;
	if (!isNull(elem)) {
		if (pattern.test(elem)) {
			return true;
		} else {
			return false;
		}
	}
}
function checkSjhm(o) {
	if (o.value.trim() == '') {
		return true;
	}
	if (!isMoveTelNew(o.value.trim())) {
		messageObj.infoMessage({
			title : '提示信息',
			text : '手机号码输入有误,请检查!',
			fn : function() {
				o.select();
			}
		});
	}
}

/** 验证票据号码 */
function validatePjNo(v) {
	if (!isInteger(v.value.trim())) {
		messageObj.infoMessage({
					title : '操作提示',
					text : "票据号码只能是数字(0-9)",
					fn : function() {
						v.select();
					}
				});
		return false;
	}
	return true;
}

/**
 * 票据号码补零 8位
 */
function addZeroToPjNo(v){
	if (v instanceof Object) {
		v = v.value.trim();
	}
	if(isNull(v)){
	   return '';
	}
	if(String(v).length > 8){
		return v;
	}
	var r = v;
	if(!isInteger(r)){
		return v;
	}else{
		while(String(r).length < 8){
			r = '0'+r;
		}
	}
	return r;
}

/**
 * 验证支票号 NEW laizhiming(1522) 20100926
 *  <li>用法：支票号对应的input中添加以下属性
 *	<li>最大长度限制：maxlength="14"
 *	<li>失去焦点验证：onblur="validateZph(this)" 
 *	<li>敲回车或TAB键：onkeydown="if(event.keyCode==13 || event.keyCode==9){validateZph(this);}"
 */
function validateZph(e){
	if(!e) return;
	var v = e.value.trim();
	var len = v.length;
	if(len == 0) return;
	var errMsg = '支票号格式有误！<br/><br/>' +
				'正确格式（支票号末4位数）<br/>' +
				'1个支票号：<font color=red>0001</font><br/>' +
				'2个支票号：<font color=red>0001、0002</font><br/>' +
				'3个支票号：<font color=red>0001、0002、0003</font><br/>';
	if(!(len == 4 || len == 8 || len == 9 || len == 12 || len == 14)){
		selAlert(errMsg, function(){e.select()});
		return false;
	}
	var rv;
	var dh = '、'; //顿号分隔符
	switch(len){
		case 8: // 00010002 -> 0001、0002
			if(/^\d*$/.test(v)){
				rv = v.substr(0, 4) + dh + v.substr(4, 4);
			}else{
				selAlert(errMsg, function(){e.select()});
				return false;
			}
			break;
		case 9:
			if(/\d{4}\D\d{4}/.test(v)){
				rv = v.replace(/\D/g, dh);
			}else{
				selAlert(errMsg, function(){e.select()});
				return false;
			}
			break;
		case 12: // 000100020003 -> 0001、0002、0003
			if(/^\d*$/.test(v)){
				rv = v.substr(0, 4) + dh + v.substr(4, 4) + dh + v.substr(8, 4);
			}else{
				selAlert(errMsg, function(){e.select()});
				return false;
			}
			break;
		case 14:
			if(/\d{4}\D\d{4}\D\d{4}/.test(v)){
				rv = v.replace(/\D/g, dh);
			}else{
				selAlert(errMsg, function(){e.select()});
				return false;
			}
			break;
		default:
			if(/^\d*$/.test(v)){
				rv = v;
			}else{
				selAlert(errMsg, function(){e.select()});
				return false;
			}
	}
	if(rv){
		e.value = rv;
	}else{
		e.value = v;
	}
	return true;
}

/** 验证机打票号 */
function validateJdph(o) {
	var v = o.value.trim();
	if (!isNull(v)) {
		if (String(v).length != 20) {
			messageObj.infoMessage({
						title : '操作提示',
						text : "机打票号长度有误！<br/><br/>正确长度为：<font color='red'>20</font>",
						fn : function() {
							o.select();
						}
					});
			return false;
		}
		var jdphReg = /^(S)\d{19}$/i;
		if (!jdphReg.test(v)) {
			messageObj.infoMessage({
				title : '操作提示',
				text : "机打票号格式有误！<br/><br/>正确格式为：<font color='red'>S + 19位数字</font><br/><br/>例如：<font color='blue'>S1070007201006170001</font>",
				fn : function() {
					o.select();
				}
			});
			return false;
		}
	}
	return true;
}

/**
 * onkeyup="validateLength(this)"
 * @param {} e
 */
function validateLength(e) {
	if(e.value.trim().length==0) return true;
	var len = e.value.trim().length + e.value.trim().replace(/[\u0000-\u00ff]/g,'').length;
	if (len > 24) {
		selAlert('备注附加信息不能超出24字节',function(){e.select();});
		return false;
	}
	return true;
}