function hideform(Flag){


var Sign_Over_area = document.getElementById('Sign-overlay');
var Sign_In_area = document.getElementById('Sign');

switch(Flag){
    case 'open':
        Sign_Over_area.style.display = 'block';
        Sign_In_area.style.display = 'block';
        break;
    case 'close':
        Sign_Over_area.style.display = 'none';
        Sign_In_area.style.display = 'none';
        break;
    default:
        alert("不正な引数が設定されました。")
    

}   

}
