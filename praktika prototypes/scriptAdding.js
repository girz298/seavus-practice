$("#fileMain").change(function()
{
     var fileResult = $('#fileMain').val();
     var mas = fileResult.split('\\');
     var nameFile = mas[mas.length - 1];
     $(this).parent().find('.fieldNameFile').val(nameFile);
    $('#progressBar').show();
    $('#progressBar').val(0);
    $('#image').show();
    var input = $(this)[0];
    var reader = new FileReader();
    reader.onload = function(e) { $('#image_preview').attr('src', e.target.result); }
    reader.readAsDataURL(input.files[0]);
    var progressbar = $('#progressBar'),
        max = progressbar.attr('max'),
        time = (1000/max),   
        value = progressbar.val();
        var loading = function() {
        value += 1;
        addValue = progressbar.val(value);    
        if (value == max) {
            clearInterval(animate);
            $('#progressBar').hide();
        }
    };
    var animate = setInterval(function() {
        loading();
    }, time);
});