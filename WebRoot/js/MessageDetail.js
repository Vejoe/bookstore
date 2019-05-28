function MessageDetail(id){
	//创建一个div和一个iframe并给予样式
	var i=9.00;
	var q=0.50;
	var Body = this.parent.window.document.body;  
    var Messagetemp = document.createElement("div");
    var Messageiframe = document.createElement("iframe");
    Messagetemp.id="Messagetemp";
    Messageiframe.id="Messageiframe";
    Body.appendChild(Messagetemp);
    Body.appendChild(Messageiframe);
    Messagetemp.style.backgroundColor="black";
    Messagetemp.style.opacity="0.5";
    Messagetemp.style.width="100%";
    Messagetemp.style.height="100%";
    Messagetemp.style.position="fixed";
    Messagetemp.style.top="0%";
    Messagetemp.style.zIndex="5";
    Messageiframe.style.zIndex="6";
    Messageiframe.style.borderRadius="5px";
    Messageiframe.style.position="fixed";
    Messageiframe.style.top="9%";
    Messageiframe.style.opacity="0.5";
    Messageiframe.style.left="37%";
    Messageiframe.style.width="320px";
    Messageiframe.style.height="440px";
    Messageiframe.style.backgroundColor="#f5f5f5";
    Messageiframe.scrolling="no";
    Messageiframe.src="QueryMessageDetailAction?id="+id;
    var timer = setInterval(function(){
    	if(i<12) {
    		i=i+0.5;
    		Messageiframe.style.top = i+ '%';
        	if(q<1.1)
        		q=q+0.1;
        	Messageiframe.style.opacity =q;
        }
    }, 30);
}