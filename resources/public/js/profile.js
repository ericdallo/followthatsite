$.ajaxSetup({
    scriptCharset: "utf-8",
    contentType: "text/html; charset=utf-8"
});

$(document).ready(function() {
    var timer;

    $(".site-form input[name='site-url']").keyup( function() { 
        var siteUrl = baseURL(this.value);
        if (!/^http:\/\//.test(siteUrl)) {
            siteUrl = "http://" + siteUrl;
        }
        var $icon = $('.site-form .icon');
        $icon.attr('src', siteUrl + '/favicon.ico');
        $icon.show();
    });
});

function baseURL(url) {
  var domain;
    if (url.indexOf("://") > -1) {
        domain = url.split('/')[2];
    }
    else {
        domain = url.split('/')[0];
    }
    domain = domain.split(':')[0];
    return domain;
}