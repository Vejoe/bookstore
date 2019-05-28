window.onload=function(){
	var i=20.00;
	var j=10.00;
	var q=0.50;
	//创建一个div和一个iframe并给予样式
	var Body = this.parent.window.document.body;
    var temp = document.createElement("div");
    var goiframe = document.createElement("iframe");
    temp.id="temp";
    goiframe.id="goiframe";
    Body.appendChild(temp);
    Body.appendChild(goiframe);
    temp.style.backgroundColor="black";
    temp.style.opacity="0.7";
    temp.style.width="100%";
    temp.style.height="100%";
    temp.style.position="fixed";
    temp.style.top="0%";
    goiframe.style.zIndex="2";
    goiframe.style.borderRadius="15px";
    goiframe.style.position="fixed";
    goiframe.style.top="20%";
    goiframe.style.opacity="0.5";
    goiframe.style.left="36%";
    goiframe.style.width="350px";
    goiframe.style.height="200px";
    goiframe.style.backgroundColor="white";
    goiframe.scrolling="no";
    goiframe.src="Gotomainpage.jsp";
    var timer = setInterval(function(){
    	if(i<28) {
    		j=j/2.00;
    		if(j<2.00)
    			j=2.00;
    		i=i+j;
    		goiframe.style.top = i+ '%';
        	if(q<1.10)
        		q=q+0.20;
        	goiframe.style.opacity =q;
        }
    }, 30);
}