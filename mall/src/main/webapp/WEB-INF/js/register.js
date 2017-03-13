//js 对当前注册用户进行检查
//对用户名进行经检查，分页面和action 中检查
/*
判断字符串是否为空开始
*/
function isNotNull(str){
    if (str==""){
        return(false);
    }else{
        return(true);
    }
}

/*
 * 用来判断邮箱
 */
 
 function checkEmail(emailStr){
     var reg =/\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/i;
     if(emailStr.length !=0 ){
    	 if(reg.test(emailStr)){
    		 return true;
    	 }else{
    		 return false;
    	 }
     }
     return false;
}

/*
 * 检查用户名是否正确
 用户名可以是中文，字母，数字
 */
 function checkUserName(userStr){
	 var reg =/^[\u4e00-\u9fa5_a-zA-Z0-9]+$/ ; // 匹配中文,英文字母和数字及
	if(reg.test(userStr)){
		
		if((userStr.length <6) || (userStr.length >16)){
			return false;
		}
		return true;
	} 
	 return false;
}
/*
 * 使用焦点是函数判断
 */
 function checkUser (){
	var flag = true;
	var name =$.trim($("#userName").val());
	var t = new Date().getMilliseconds();
	var url='Login_register?t='+t;
	 var param ={username:name};
	if(isNotNull(name) && checkUserName(name)){
		  jQuery.post(url, param, callbackFun);
		  return flag;
	}else{
		$("#u").html("<img src='images/ajax/no.png'/>用户名由6~16位的字母或数字组成");
		return flag = false;
	}
 }
 function callbackFun(data){
  	 eval('json='+data+';');
  	if(json.type =='no'){
     	$("#u").html(json.show);
         flag = false;
     	
  	}else {
     $("#u").html(json.show); 
     flag = true;
  	}	
 }
 
 function checkPwd1(pwdStr){
	 var reg =/^(\w){6,16}$/;//匹配6到16 为的密码可以使数字、字母下划线
	 if(reg.test(pwdStr)){
		 return true;
	 }
	 return false;
 }
 function passwordCheck(){
	 var flag1 =false;
	 var pwd1 = $.trim($("#password").val());
	 if(!isNotNull(pwd1)){
		 $("#pwd").html("<img src='images/ajax/no.png'/>密码不能为空"); 
		 return flag1 ;
	 }
	 else if(!checkPwd1(pwd1)){
		 $("#pwd").html("<img src='images/ajax/no.png'/>密码由6~16位的数字或字母组成"); 
		 return flag1;
	 }else{
		 $("#pwd").html("<img src='images/ajax/yes.png'/>密码正确"); 
		 return flag1 = true ;
	 }
 }
 
 /*
  * 用来判断两次注册的密码是不是相同
  */

 function checkPwdSame(){
	 var flag2 = false;
	 var pwd1 = $.trim($("#password").val());
	 var pwd2 = $.trim($("#password1").val());
	if(isNotNull(pwd2) != true){
		$("#pwd1").html("<img src='images/ajax/no.png'/>确认密码不能为空");
		 return flag2;	 
		}else if(pwd1 != pwd2){
			$("#pwd1").html("<img src='images/ajax/no.png'/>两次密码不一样");
			  return flag2;
		}else{
			$("#pwd1").html("<img src='images/ajax/yes.png'/>两次密码相同");
			 return flag2 = true;
		}

 }
 function emailCheck(){
	 var flag3 = false; 
	 var email = $.trim($("#em").val());
	 if(!isNotNull(email)){
		 $("#email").html("<img src='images/ajax/no.png'/>邮箱不可以为空");
		 return flag3;
	 } else if(!checkEmail(email)){
		 $("#email").html("<img src='images/ajax/no.png'/>请输入正确的邮箱地址");
		 $("#em").focus();
		 $("#em").val("");
		 return flag3;
	 }else{
		 $("#email").html("<img src='images/ajax/yes.png'/>邮箱地址正确");
		 return flag3 = true;
	 }
 }
 function formCheck(){
	 if((((checkUser()== true) && passwordCheck()==true)  && (checkPwdSame()==true) && (emailCheck() == true))){	
       
		document.registerFrom.action="register?AddUser";
	   document.registerFrom.submit();
	 }else{
		window.alert("请确认所填写的注册信息");
	}
 }