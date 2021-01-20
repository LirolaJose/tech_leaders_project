function clickIN() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8081/movies/allMovies"
    }).done(function (listOfMovies) {
        console.log(listOfMovies);
        $("#movies").html(listOfMovies);
        $.each(listOfMovies, function (index, movie) {
            $("#movies").append(index + 1 + ": " + movie.name + " (" + movie.year + ") " +
                '<input type="button" onclick="movieInfo(\'' + movie.id + '\');" value="info"/>' +
                '<input type="button" onclick="deleteByClick(\'' + movie.id + '\');" value="delete"/>' + '<br>')
        });
    }).fail(function (err) {
        $("#movies").html("<p>Error!</p>");
    });
}

function deleteByClick(id) {
    $.ajax({
        type: "DELETE",
        url: "http://localhost:8081/admin/deleteMovie?id=" + id
    }).done(function () {
        $("#button").click()
    }).fail(function (err) {
        $("#movies").html("<p>Error!</p>");
    });
}

function movieInfo(id) {
    $.ajax({
        type: "GET",
        url: "http://localhost:8081/movies/byId?id=" + id
    }).done(function (movie) {
        console.log(movie);
        $("#movies").html(movie);
        var genres = movie.genres.join(", ");
        $("#movies").append(movie.name + " (" + movie.year + ") " + "\"" + movie.country + "\"" + '<br/>' +
            "Director: " + movie.directorEntity.name + " " + movie.directorEntity.last_name + '<br/>' +
        "Genre: " + Array.prototype.map.call(movie.genres, s => s.genre_name).join(", ") + '<br/>' +
        '<input type="button" onclick="clickIN()"; value="Back"/>')
    });
}

function addNewMovie() {
}