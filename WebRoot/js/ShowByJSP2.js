function ShowByJSP2(id){
	var i=7.00;
	var q=0.50;
	//鍒涘缓涓�釜div鍜屼竴涓猧frame骞剁粰浜堟牱寮�
	var Body = this.parent.window.document.body;
    var temp = document.createElement("div");
    var jspiframe = document.createElement("iframe");
    var closebtn = document.createElement("input");
    temp.id="temp";
    jspiframe.id="jspiframe";
    closebtn.id="closebtn";
    Body.appendChild(temp);
    Body.appendChild(jspiframe);
    Body.appendChild(closebtn);
    temp.style.backgroundColor="black";
    temp.style.opacity="0.7";
    temp.style.width="100%";
    temp.style.height="100%";
    temp.style.position="fixed";
    temp.style.zIndex="3";
    temp.style.top="0%";
    jspiframe.style.zIndex="4";
    jspiframe.style.position="fixed";
    jspiframe.style.borderRadius="5px";
    jspiframe.style.top="7%";
    jspiframe.style.opacity="0.5";
    jspiframe.style.left="16%";
    jspiframe.style.width="65%";
    jspiframe.style.height="500px";
    jspiframe.style.backgroundColor="#f5f5f5";
    jspiframe.src=id;
    closebtn.type="button";
    closebtn.value="关闭";
    closebtn.style.zIndex="4";
    closebtn.style.position="fixed";
    closebtn.style.top="11%";
    closebtn.style.cursor="hand";
    closebtn.style.border="hidden";
    closebtn.style.backgroundColor="#f5f5f5";
    closebtn.style.left="79%";
    localStorage.setItem("0", this.parent.window.location.toString().substring(31));
    var timer = setInterval(function(){
    	if(i<10) {
    		i=i+0.5;
    		jspiframe.style.top = i+ '%';
        	if(q<1.10)
        		q=q+0.10;
        	jspiframe.style.opacity =q;
        }
    }, 30);
    closebtn.onmouseover=function(){
    	closebtn.style.color="#ca0c16";
    };
    closebtn.onmouseout=function(){
    	closebtn.style.color="black";
    };
    closebtn.onclick=function(){
    	Body.removeChild(temp);
    	Body.removeChild(jspiframe);
    	Body.removeChild(closebtn);
    };
}