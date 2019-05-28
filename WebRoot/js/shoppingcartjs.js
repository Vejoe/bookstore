//根据id删除信息
function deleteshoppingcartinfo(Id){
	if(confirm("你确定删除该记录吗?")){
		location.href="DeleteShoppingCartAction?id="+Id;
	}
}




//调用add
function addmount(Id){
	location.href="UpdateShoppingCartAction?id="+Id;
	
}

//调用douwn
function domnmount(Id){
	location.href="DownShoppingCartAction?id="+Id;
	
}

//调用delall
function delall(){
	location.href="DelAllShoppingCartAction";
}

function jiesuan(){
	location.href="BuildOrderAtion"
}