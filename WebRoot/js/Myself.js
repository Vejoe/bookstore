var now=null;
function mouseover(num){
	if(now==num)
		return false;
	document.getElementById("m"+num).style.background="white";
	var text=document.getElementById("m"+num).innerHTML;
	document.getElementById("m"+num).innerHTML="->"+text;
	document.getElementById("m"+num).style.color="blue"
}
function mouseout(num){
	if(now==num)
		return false;
	document.getElementById("m"+num).style.background="#f6f9fb";
	var text=document.getElementById("m"+num).innerHTML;
	text=text.substring(5, text.length);
	document.getElementById("m"+num).innerHTML=text;
	document.getElementById("m"+num).style.color="black"
}
function select(num){
	if(now==num)
		return false;
	for(var i=1;i<=7;i++){
		document.getElementById("m"+i).style.background="#f6f9fb";
		document.getElementById("m"+i).style.color="black"
	}
	now=num;
	document.getElementById("m"+num).style.background="white";
	var text=document.getElementById("m"+num).innerHTML;
	text=text.substring(5, text.length);
	document.getElementById("m"+num).innerHTML=text;
	document.getElementById("m"+num).style.color="blue"
	if(num==6)
		document.getElementById("iframe").src="GetCustomerConsigneeDetailBycaccountAction.action";
	else
		document.getElementById("iframe").src="GetCustomerDetailBycaccountAction.action?num="+num;
}