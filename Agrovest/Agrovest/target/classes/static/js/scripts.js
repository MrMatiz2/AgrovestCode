$(".cardDrop").hover(
 function() {
    $('.cardCollapse').collapse('show');
  }, function() {
    $('.cardCollapse').collapse('hide');
  }
);

function limpiarCampo(){
    $("#output").val("");
}

