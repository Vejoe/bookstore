function mouseover(id){
	document.getElementById(id).style.background="#f01923";
}
function mouseout(id){
	document.getElementById(id).style.background="#ff2832";
}
function ConsigneeAdd(){
	location.href="GetCustomerConsigneeDetailBycaccountAction?whattodo=add";
}
function ConsigneeDelete(id){
	if(confirm("你确定删除该收货人吗?"))
		location.href="DeleteConsigneeAction?id="+id;
}
function ConsigneeDetail(id){
	location.href="QueryConsigneeDetailAction?id="+id;
}