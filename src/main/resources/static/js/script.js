function cadastra(){
    var n1 = document.getElementById("username").value;
    var n2 = document.getElementById("email").value;
    var n3= document.getElementById("senha").value;
    var n4 = document.getElementById("rep_senha").value;
    

    if (n1==""){
    document.getElementById("username").focus();    
    window.alert('entre com seu nome');
    document.getElementById("username").style.borderColor="#ff0000"
    return false;
    }

    else{
    document.getElementById("username").style.borderColor="#00ff00";
    }

    if (n2==""){
    document.getElementById("email").focus();    
    window.alert('Preencha com seu email');
    document.getElementById("email").style.borderColor="#ff0000"
    return false;
    }
    else if(n2.indexOf("@")==-1){
        window.alert('Preencha com seu email');
    document.getElementById("email").focus();    
    document.getElementById("email").style.borderColor="#ff0000"
    return false;
    }
    else{
    document.getElementById("email").style.borderColor="#00ff00";
    }

    if(n3 == "" || n4 <=8 || n3<=8){
   alert('digite sua senha');
   document.getElementById("senha").style.borderColor="#ff0000"    
   return false
}
else{
    document.getElementById("senha").style.borderColor="#00ff00";
    }

if(n3 != n4){
   alert('digite a mesma senha');
   document.getElementById("rep_senha").style.borderColor="#ff0000"
   return false
}
else{
    document.getElementById("rep_senha").style.borderColor="#00ff00";
    }
   
    
   } 
   function verificar(){
    var n1 = document.getElementById("username").value;
    var n2 = document.getElementById("password").value;
    
    
    if (n1==""){
    document.getElementById("username").focus();    
    window.alert('Preencha com seu email');
    document.getElementById("username").style.borderColor="#ff0000"
    return false;
    }
    else if(n1.indexOf("@")==-1){
        window.alert('Preencha com seu email');
    document.getElementById("username").focus();    
    document.getElementById("username").style.borderColor="#ff0000"
    return false;
    }
    else{
    document.getElementById("username").style.borderColor="#00ff00";
    }
    
    if (n2==""){
    document.getElementById("password").focus();    
    window.alert('entre com sua senha');
    document.getElementById("password").style.borderColor="#ff0000"
    return false;
    }
    else if (n2==""){
    document.getElementById("password").focus();    
    window.alert('senha incorreta');
    document.getElementById("password").style.borderColor="#ff0000"
    return false;
    }
    else{
    document.getElementById("password").style.borderColor="#00ff00";
    }
    
    alert('seja bem-vindo')
    }
     function check(){

             console.log("Mensagem enviada");
        }

	 