window.onload=function(){
	if (self != top) {
		document.body.style.display="none";
		top.location.href="/bookstore"+localStorage.getItem("0");
	}
	var key=0;
	var i=0;
	var content=document.getElementsByClassName("book-content");
	var photo=document.getElementsByClassName("photo");
	var biaoqian=document.getElementsByClassName("biaoqian");
	
	var timer=setInterval(move,2000);
	
	function setNone(){
		var i=0;
		for(i=0;i<content.length;i++){
			content[i].style.display="none";
		}
	}
	
	function setphotoNone(){
		var i=0;
		for(i=0;i<content.length;i++){
			photo[i].style.transform="none";
		}
	}
		
	for(i=0;i<content.length;i++){
		photo[i].setAttribute("index",i);

		photo[i].onmousemove=function(){
			clearInterval(timer);
			key=this.getAttribute("index");
			setNone();
			setphotoNone();
			photo[key].style.transform="scale(1.4)";			
			content[key].style.display="block";
		};
		photo[i].onmouseout=function(){
			timer=setInterval(move,2000);
		};
	}
	
	function move(){
		setNone();
		setphotoNone();
		content[key].style.display="block";
		photo[key].style.transform="scale(1.4)";
		key++;
		if(key>content.length-1){
			key=0;
		}
	}
	
	
	biaoqian[0].onclick=function(){
		clearInterval(timer);
		key--;
		if(key<0){
			key=photo.length-1;
		}
		setNone();
		setphotoNone();
		photo[key].style.transform="scale(1.4)";			
		content[key].style.display="block";
		timer=setInterval(move,2000);
	};
	
	biaoqian[1].onclick=function(){
		clearInterval(timer);
		key++;
		if(key>photo.length-1){
			key=0;
		}
		setNone();
		setphotoNone();
		photo[key].style.transform="scale(1.4)";			
		content[key].style.display="block";
		timer=setInterval(move,2000);
	};
};