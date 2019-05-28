window.onload=function(){
	if (self != top) {
		document.body.style.display="none";
		top.location.href="/bookstore"+localStorage.getItem("0");
	}
	var bookid=document.getElementById("book-id").value;
	var collectstatus=document.getElementById("collect-status").value;
	var collect=document.getElementById("shoucang");
	var deletecollection=document.getElementById("deletecollection");
	var anniu=document.getElementsByClassName("anniu");
	var Loginstatus=document.getElementById("Login-status").value;
	
	
	if(collectstatus==0){
		collect.style.display="blcok";
		deletecollection.style.display="none";
	}else{
		collect.style.display="none";
		deletecollection.style.display="block";
	}
	
	anniu[0].onclick=function(){//加入购物车
		if(Loginstatus==0){
			loginshow();
		}else{
			
			location.href="addshoppingcartAction?bookid="+bookid;
		}
	};
	collect.onclick=function(){//加入收藏
		if(Loginstatus==0){
			loginshow();
		}else{
			location.href="savecollectionAction?bookid="+bookid+"&collectstatus="+0;
		}
	};
	deletecollection.onclick=function(){//取消收藏
		if(Loginstatus==0){
			loginshow();
		}else{
			location.href="savecollectionAction?bookid="+bookid+"&collectstatus="+1;
		}
	};

};