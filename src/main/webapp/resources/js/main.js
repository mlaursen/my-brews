$(window).scroll(function() {
  if($(this).scrollTop() > 160) {
    $(".navbar").addClass("sticky");
    $(".content").addClass("sticky");
  } else {
    $(".navbar").removeClass("sticky");
    $(".content").removeClass("sticky");
  }
});
