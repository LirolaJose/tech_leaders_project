function clickIN() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8081/Movies/allMovies"
    }).done(function (data) {
        console.log(data);
        $("#movies").html(data);
        $.each(data, function (index, movie){
            $("#movies").append(index+1 + ": " + movie.name + " (" + movie.year +") " + '<input type="button" onclick="deleteByClick(\'' + movie.id + '\');" value="delete"/>' + '<br>')
        });
    }).fail(function(err) {
        $("#movies").html("<p>Error!</p>");
    });
}

function deleteByClick(id) {
    $.ajax({
        type: "DELETE",
        url: "http://localhost:8081/Admin/deleteMovie?id=" + id
    }).done(function (){
        $("#button").click()
    }).fail(function (err){
        $("#movies").html("<p>Error!</p>");
    });
}