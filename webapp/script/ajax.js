/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    var name = $("#name").val();
    var email = $("#email").val();
    var phone = $("#phone").val();
    var address = $("#address").val();
    $('#submit2').click(function () {
        $.get('ajaxServlet',
                {
                    name: name,
                    email: email,
                    phone: phone,
                    address: address
                }, function (contact) {
            $('<div class="contact">').hide().appendTo("#maindiv")                 
                    .append($('<h1>').text(contact.name))  
                    .append($('<hr>'))
                    .append($('<p>').append("Phone: " + "<b>" + contact.phone + "</b>"))
                    .append($('<p>').append("E-mail: "+ "<b>" +contact.email + "</b>")) 
                    .append($('<p>').append("Address: " + "<b>" + contact.address + "</b>")).slideDown("slow");

        });
    });
    
    var path = $("#filePath").val();
    $('#download').click(function () {
        $.get('FileDownloader',
                {path: path}, function (file) {
                    $("#downloadForm").append("<p>").text("Download has started! " + file);
        });
    });
});