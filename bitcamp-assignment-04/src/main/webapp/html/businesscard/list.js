"use strict";

var liTemplateSrc = $('#li-template').text();
var template = Handlebars.compile(liTemplateSrc);

$.getJSON(`${serverApiAddr}json/businesscard/list`, (result) => {
    var html = template(result);
    $('#name-list').html(html);
});


$('#name-list').on('click', 'li', (e) => {
    var no = $(e.target).attr('data-no');
    // 넘겨줄 값이 있다면 배열에 담아서 넘겨준다.
    $(document.body).trigger('show.detail', [no]);

});


/*$('#name-list').on('click', 'li', (e) => {
    console.log('e.target의 번호 =', $(e.target).attr('data-no'));
    //alert('okok');
});*/

