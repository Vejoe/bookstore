window.onload=function(){
	if (self != top) {
		document.body.style.display="none";
		top.location.href="/bookstore"+localStorage.getItem("0");
	}
	var book_type=document.getElementsByClassName('type-name');
	var book_status=document.getElementsByClassName("book-status");
	var book_status_key=document.getElementById("bookstatus").value;
	var book_type_key=document.getElementById("booktype_num").value;
	var book_type_id=document.getElementById("booktype_id").value;
	
	book_type[book_type_key].style.backgroundColor="#eb634b";
	book_type[book_type_key].style.color="white";	
	book_status[book_status_key].style.backgroundColor="#eb634b";
	book_status[book_status_key].style.color="white";
	
	
	for(var i=0;i<book_type.length;i++){
		book_type[i].setAttribute("index",i);
		book_type[i].onclick=function(){
			book_type_key=this.getAttribute("index");
			var book_type_id=this.value;
			location.href="showAction?Page_booktype_id="+book_type_id+"&Page_booktype_num="+book_type_key+"&Page_bookstatus="+book_status_key;
		};
	}
	
	for(var i=0;i<book_status.length;i++){
		book_status[i].setAttribute("index",i);
		book_status[i].onclick=function(){
			book_status_key=this.getAttribute("index");
			location.href="showAction?Page_booktype_id="+book_type_id+"&Page_booktype_num="+book_type_key+"&Page_bookstatus="+book_status_key;
		};
	}
};