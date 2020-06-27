window.onload = function() {
    // ul要素を取得
var ul = document.getElementById('col_num');

    for( var i = 1; i < 100; i++ ) {
        //li要素を設定
        var li = document.createElement('li');
        //値を設定
        var text = document.createTextNode(i);
        li.appendChild(text);
        ul.appendChild(li);
    
}
}