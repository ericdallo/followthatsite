$(document).ready(function() {
  $("body").removeClass("preload");
});

$(document).keyup(function(e) { 
    if (e.keyCode == 27) {
        window.location.hash = '#';
    } 
});