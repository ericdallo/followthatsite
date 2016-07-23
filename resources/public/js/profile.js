$.ajaxSetup({
    scriptCharset: "utf-8",
    contentType: "text/html; charset=utf-8"
});

$(document).ready(function() {
    var timer;

    $(".site-form .url").keyup( function() { 
        var siteUrl = baseURL(this.value);
        if (!/^http:\/\//.test(siteUrl)) {
            siteUrl = "http://" + siteUrl;
        }
        var $icon = $('.site-form .icon');
        $icon.attr('src', siteUrl + '/favicon.ico');
        $icon.show();

        var $siteName = $(".site-form .name");
        if (this.value.length > 3) {
            $siteName.val(capitalizeFirstLetter(baseURLName(siteUrl)));
        }
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
function baseURLName(url) {
    url = baseURL(url);
    url = url.replace('www.','');
    if (url.indexOf('.')) {
        url = url.split('.')[0];
    }
    return url;
}

function capitalizeFirstLetter(string) {
    return string.charAt(0).toUpperCase() + string.slice(1);
}