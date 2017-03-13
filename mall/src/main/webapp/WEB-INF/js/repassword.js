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

 function checkPwd1(pwdStr){
	 var reg =/^(\w){6,16}$/;//匹配6到16 为的密码可以使数字、字母下划线
	 if(reg.test(pwdStr)){
		 return true;
	 }
	 return false;
 }
 function passwordCheck(){
	 var flag =false;
	 var pwd = $.trim($("#password").val());
	 if(!isNotNull(pwd)){
		 $("#pwd").html("<img src='images/ajax/no.png'/>密码不能为空"); 
		 return flag ;
	 }
	 else 
		 $("#pwd").html(""); 
		 return flag = true;
	 }
 function xpasswordCheck(){
	 var flag1 =false;
	 var pwd1 = $.trim($("#xpassword").val());
	 if(!isNotNull(pwd1)){
		 $("#xpwd").html("<img src='images/ajax/no.png'/>新密码不能为空"); 
		 return flag1 ;
	 }
	 else if(!checkPwd1(pwd1)){
		 $("#xpwd").html("<img src='images/ajax/no.png'/>密码由6~16位的数字或字母组成"); 
		 return flag1;
	 }else{
		 $("#xpwd").html("<img src='images/ajax/yes.png'/>密码正确"); 
		 return flag1 = true ;
	 }
 }
 
 /*
  * 用来判断两次注册的密码是不是相同
  */

 function checkPwdSame(){
	 var flag2 = false;
	 var pwd1 = $.trim($("#xpassword").val());
	 var pwd2 = $.trim($("#xpassword2").val());
	if(isNotNull(pwd2) != true){
		$("#xpwd1").html("<img src='images/ajax/no.png'/>确认密码不能为空");
		 return flag2;	 
		}else if(pwd1 != pwd2){
			$("#xpwd1").html("<img src='images/ajax/no.png'/>两次密码不一样");
			  return flag2;
		}else{
			$("#xpwd1").html("<img src='images/ajax/yes.png'/>两次密码相同");
			 return flag2 = true;
		}

 }

 function formCheck(){
	 if((((checkUser()== true) && passwordCheck()==true)  && (checkPwdSame()==true) && (xpasswordCheck() == true))){	
       
		document.registerFrom.action="register";
	   document.registerFrom.submit();
	 }else{
		 window.alert("请确认所填写的密码信息");
	}
 }