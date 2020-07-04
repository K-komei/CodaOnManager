function hideform(Flag){


var Sign_Over_area = document.getElementById('Sign-overlay');
var Sign_In_area = document.getElementById('Sign');


if (Flag = "open") {
    Sign_Over_area.style.display = 'block';
    Sign_In_area.style.display = 'block';    
}else{
    Sign_Over_area.style.display = 'none';
    Sign_In_area.style.display = 'none';
}
    

}
