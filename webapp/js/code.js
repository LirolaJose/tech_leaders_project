function clickIN() {

    $.ajax({
        type: "GET",
        url: "http://localhost:8081/Movies/allMovies"
    }).done(function (data) {
        console.log(data);
        $("#movies").html(data);
        $.each(data, function (index, value){
            var $input = $('<input type="button" value="new button" />');
            $("#movies").append(index+1 + ": " + value.name + " (" + value.year +") ").append('<input type="button" value="delete" />' + '<br>');
        });
    }).fail(function(err) {
        $("#movies").html("<p>Error!</p>");
    });
}
