/**
 * 公共的 js
 *
 * @type {string}
 */
var api = 'http://127.0.0.1:8080';
var edition = {
	0: '无',
	1: '开发版',
	2: '生产版',
	3: '预生产版',
	4:'预览版'
}
var timer = null;
function getParams(value) {
	var query = window.location.search.substring(1);
	var vars = query.split("&");
	for (var i = 0; i < vars.length; i++) {
		var pair = vars[i].split("=");
		if (pair[0] == value) {
			return pair[1];
		}
	}
	return (false);
}
function loading(type) {
	var mark = document.getElementById('mark');
	if (type && !mark) {
		var mark = document.createElement('div');
		mark.className = 'mark';
		mark.id = 'mark';
		mark.innerHTML = '<div class="loading"></div>';
		document.body.appendChild(mark);
		return;
	}
	if (!type && mark) {
		clearTimeout(timer);
		timer = setTimeout(function() {
			mark.remove();
		}, 200);
		return;
	}
}
function errorFun(message) {
// 	document.getElementById('content').innerHTML = `
// 	<div class="error"><h3>${message}</h3>
// 	<p>
// 		<a href="javascript:void(0)" onclick="refresh()">
// 			<svg t="1574249544752" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="3710" width="50" height="50"><path d="M822.496 473.152a32 32 0 0 0-31.392 55.776l97.450667 54.848c20.32 11.434667 45.653333-2.005333 47.594666-25.248 1.674667-20.16 2.517333-35.573333 2.517334-46.528C938.666667 276.362667 747.637333 85.333333 512 85.333333S85.333333 276.362667 85.333333 512s191.029333 426.666667 426.666667 426.666667c144.106667 0 276.053333-72.032 354.752-189.536a32 32 0 1 0-53.173333-35.616C746.645333 813.461333 634.538667 874.666667 512 874.666667c-200.298667 0-362.666667-162.368-362.666667-362.666667s162.368-362.666667 362.666667-362.666667c197.098667 0 357.472 157.226667 362.538667 353.109334l-52.042667-29.290667z" p-id="3711" fill="#e6e6e6"></path>
// 			</svg>
// 			<em>刷新</em>
// 		</a>
// 	</p>
// </div>`;
loading(false)
}
function noData(){
	var empty = document.createElement('div');
	empty.className = 'empty';
	// empty.innerHTML = '<img src="./img/nodata.png" />';
	empty.innerHTML = '<b>暂无数据</b>';
	document.body.appendChild(empty);
}
function refresh(){
	window.location.reload();
}
function htmlFormat( text ) {
	if(text){
		return text.replace(/\r\n|\n|\r/g,'<br/>');
	}
	return '';
}
function timeFormat(time,bool){
	// 拿到当前时间戳和发布时的时间戳，然后得出时间戳差
	var curTime = new Date();
	var timeDiff = curTime.getTime() - time;
	// 单位换算
	var min = 60 * 1000;
	var hour = min * 60;
	var day = hour * 24;
	var week = day * 7;
				 
	// 计算发布时间距离当前时间的周、天、时、分
	var exceedWeek = Math.floor(timeDiff/week);
	var exceedDay = Math.floor(timeDiff/day);
	var exceedHour = Math.floor(timeDiff/hour);
	var exceedMin = Math.floor(timeDiff/min);
				 
	// 最后判断时间差到底是属于哪个区间，然后return
	var d = new Date(time);
	return d.getFullYear() + '-' + (d.getMonth()+1)+'-'+d.getDate()+' '+d.getHours()+':'+(d.getMinutes() < 10 ? '0' + d.getMinutes(): d.getMinutes())+':'+d.getSeconds();     
	if(exceedWeek > 0 || bool){
		var d = new Date(time);
	    return d.getFullYear() + '-' + (d.getMonth()+1)+'-'+d.getDate()+' '+d.getHours()+':'+d.getMinutes()+':'+d.getSeconds();                    
	}
	else if( exceedDay > 0){
	        return exceedDay + '天前';
	}else if(exceedHour > 0){
	            return exceedHour + '小时前';
	}else if(exceedMin < 5){
		return '刚刚';
	}else{
		return exceedMin + '分钟前';
	}
}
function isIOS(tags) {
	return tags.toLowerCase() === 'ios'.toLowerCase();
}
function resolverPackageAddress(address) {
	if (!address) {
		return ['', ''];
	}
	var adds = (address + '').split(',');
	if (adds.length <= 0) {
		return ['', ''];
	}
	return adds.map(item => {
		return item.trim();
	})
}
function fileFormat(limit){
	// var size = "";
	// if( limit ){
	// 	size = (limit / (1024 * 1024)).toFixed(2) + "MB";
	// 	return size;
	// }
	return limit + 'MB';
}
function _element(){
		var content = document.getElementById('content');
		var top = document.querySelector('.top');
		var _width = content.clientWidth;
		var _w = document.body.clientWidth;
		top.style.width = _width + 'px';
		top.style.left = '50%';
		top.style.marginLeft = -_width/2+'px';
	}
	_element();
(function(w){
	
	_element();
	window.onresize=function(){
		_element();
	}
}(window))