$(window).scroll(function() {
  if($(this).scrollTop() > 84) {
    $(".navbar").addClass("sticky");
    $(".content").addClass("sticky");
  } else {
    $(".navbar").removeClass("sticky");
    $(".content").removeClass("sticky");
  }
});

$(function() {
  $(".clear").each(function() {
    $(this).click(function() {
      var target = $(this).data("target");
      if(target != '') {
        $('#' + target).val('');
        $('#' + target).focus();
      }
    });
  });
});
