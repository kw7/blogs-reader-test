/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){
  $(".cardNum").keyup(function() {
  var str = "";
  $(".cardDiv .cardNum").each(function(){
    str += $(this).val();
  });
  $("#pass").val(str);
});
});

function validarNit(){
    var str = document.getElementById("nt");
    var res = str.split();
    document.getElementById("pass").innerHTML = res;
}


