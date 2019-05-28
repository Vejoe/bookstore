function mouseover(){
	document.getElementById("btn").style.background="#f01923";
}
function mouseout(){
	document.getElementById("btn").style.background="#ff2832";
}
function mouseoverbyid(id){
	document.getElementById(id).style.background="#f01923";
}
function mouseoutbyid(id){
	document.getElementById(id).style.background="#ff2832";
}
function GetSecurityCode(id) { 
	var bt01 = document.getElementById(id); 
	var phone_num = document.getElementById("phone").value; 
	bt01.disabled = true;  //当点击后倒计时时候不能点击此按钮
	var iframe = document.createElement("iframe");
	iframe.src="SecurityCodeAction?phone_num="+phone_num;
	iframe.style.display="none";
	this.parent.window.document.body.appendChild(iframe);
	var time = 5;  //倒计时30秒 
	var timer = setInterval(fun1, 1000);  //设置定时器 
	function fun1() {
		time--; 
		if(time>=0) { 
			bt01.value = time + "s后重新发送"; 
		}else{ 
			bt01.value = "重新发送验证码"; 
			bt01.disabled = false;  //倒计时结束能够重新点击发送的按钮 
			clearTimeout(timer);  //清除定时器 
			time = 5;  //设置循环重新开始条件 
			this.parent.window.document.body.removeChild(iframe);
		} 
	} 
} 