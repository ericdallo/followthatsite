$.ajaxSetup({
    scriptCharset: "utf-8",
    contentType: "text/html; charset=utf-8"
});

$(document).ready(function() {

    $(".card-container #card-site-url").each(function(i) {
        maskLargeUrl($(this));

        var $cardContent = $(this.parentElement);
        var $card = $(this.parentElement.parentElement);

        var url = baseURL(this.innerText);
        url = verifyHttp(url);

        $.getJSON({
            async: true,
            url: "http://whateverorigin.org/get?url=" + encodeURIComponent(url) + "&callback=?",
            success: function (response) {
                var $metaTheme = $(response.contents).filter("meta[name='theme-color']")[0];
                if ($metaTheme != undefined) {
                    $card.css('background-color', $metaTheme.content);
                    $card.css('border-color', $metaTheme.content);
                    var rgb = hexToRgb($metaTheme.content);
                    var brightness = Math.round(((parseInt(rgb.r) * 299) + (parseInt(rgb.g) * 587) + (parseInt(rgb.b) * 114)) /1000);
                    if (brightness > 190) {
                        $cardContent.css('color', 'black');
                    } else {
                        $cardContent.css('color', 'white');
                    }
                }
            },
        });
        var $imgUrl = $card.find('.icon');
        $imgUrl.attr('src', url + '/favicon.ico');
    });

    var timer;
    $(".site-form .url").keyup( function() { 
        var siteUrl = baseURL(this.value);
        siteUrl = verifyHttp(siteUrl);
        var $icon = $('.site-form .icon');
        $icon.attr('src', siteUrl + '/favicon.ico');
        $icon.show();

        var $siteName = $(".site-form .name");
        if (this.value.length > 3) {
            $siteName.val(capitalizeFirstLetter(baseURLName(siteUrl)));
        }
    });

    $(".card-container .delete").on('click', function() {
        $(this).parent().parent(".card-container").fadeOut();
        var username = $(this).data("username");
        var siteId = $(this).data("site-id");
        $.ajax({
            url: "/" + username + "/sites/" + siteId,
            type: "DELETE",
            success: function() {
                
            }
        });
    });
});

function maskLargeUrl($siteUrl) {
    if ($siteUrl.text().length > 34) {
        var simpleSiteUrl = $siteUrl.text().substring(0,30) + "...";
        $siteUrl.text(simpleSiteUrl);
    }
}

function verifyHttp(siteUrl) {
    if (!/^http:\/\//.test(siteUrl)) {
        siteUrl = "http://" + siteUrl;
    }
    return siteUrl;
}

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

function hexToRgb(hex) {
    var result = /^#?([a-f\d]{2})([a-f\d]{2})([a-f\d]{2})$/i.exec(hex);
    return result ? {
        r: parseInt(result[1], 16),
        g: parseInt(result[2], 16),
        b: parseInt(result[3], 16)
    } : null;
}
