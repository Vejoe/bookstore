//鍒涘缓涓�釜div鍜屼竴涓猧frame骞剁粰浜堟牱寮�
function loginshow(){
	var i=7.00;
	var q=0.50;
	var Body = this.parent.window.document.body;
    var temp = document.createElement("div");
    var Loginiframe = document.createElement("iframe");
    temp.id="temp";
    Loginiframe.id="Loginiframe";
    Body.appendChild(temp);
    Body.appendChild(Loginiframe);
    temp.style.backgroundColor="black";
    temp.style.opacity="0.5";
    temp.style.width="100%";
    temp.style.zIndex="3";
    temp.style.height="100%";
    temp.style.position="fixed";
    temp.style.top="0";
    Loginiframe.style.zIndex="4";
    Loginiframe.style.borderRadius="5px";
    Loginiframe.style.position="fixed";
    Loginiframe.style.top="7%";
    Loginiframe.style.opacity="0.5";
    Loginiframe.style.left="38%";
    Loginiframe.style.width="340px";
    Loginiframe.style.height="440px";
    Loginiframe.style.backgroundColor="#f5f5f5";
    Loginiframe.scrolling="no";
    Loginiframe.src="Customerlogin.jsp";
    localStorage.setItem("0", this.parent.window.location.toString().substring(31));
    var timer = setInterval(function(){
    	if(i<=10) {
    		i=i+0.5;
        	Loginiframe.style.top = i+ '%';
        	if(q<1.10)
        		q=q+0.10;
        	Loginiframe.style.opacity =q;
        }
    }, 30);
}