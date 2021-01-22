var divMovies = "#movies";
var divEnterMovie = "#enterMovie"
var divDirectors = "#directors"
var divGenres = "#genres"

function getListOfMovies() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8081/movies/allMovies"
    }).done(function (listOfMovies) {
        console.log(listOfMovies);
        $(divMovies).html(listOfMovies);
        $.each(listOfMovies, function (index, movie) {
            $(divMovies).append(index + 1 + ": " + movie.name + " (" + movie.year + ") " +
                '<input type="button" onclick="movieInfo(\'' + movie.id + '\');" value="info"/>' +
                '<input type="button" onclick="deleteByClick(\'' + movie.id + '\');" value="delete"/>' +
                '<br/>')
        });
    }).fail(function (err) {
        $(divMovies).html("<p>Error!</p>");
    });
}

function movieInfo(id) {
    $.ajax({
        type: "GET",
        url: "http://localhost:8081/movies/byId?" + $.param({id: id})
    }).done(function (movie) {
        console.log(movie);
        $(divMovies).empty();
        $(divMovies).append(movie.name + " (" + movie.year + ") " + "\"" + movie.country + "\"" + '<br/>' +
            "Director: " + movie.directorEntity.name + " " + movie.directorEntity.last_name + '<br/>' +
            "Genre: " + Array.prototype.map.call(movie.genres, s => s.genre_name).join(", ") + '<br/>' +
            '<input type="button" onclick="getListOfMovies();" value="Back"/>')
    });
}

function addNewMovie() {
    $(divEnterMovie).html('<h2 style="color: steelblue">Enter movie details:</h2>');
    $(divEnterMovie).append("Name: ").append('<input id="movieName">' + '<br/>');
    $(divEnterMovie).append("Year: ").append('<input id="year">' + '<br/>');
    $(divEnterMovie).append("Country: ").append('<input id="country">' + '<br/>');
    getAllDirectors($(divDirectors), "Director: ");
    // $(divDirectors).append("Director: ").append('<input id="director">' + '<br/>');
    $(divGenres).append("Genres: ").append('<input id="genre">' + '<br/>');
    $("#createMovie").append('<input type="button" onclick="createMovie();" value="Create movie"/>')
}

function createMovie() {
    var name = document.getElementById('movieName').value;
    var year = document.getElementById('year').value;
    var country = document.getElementById('country').value;
    var director = $("#listDirectors option:selected").val()
    var genres = document.getElementById('genre').value;


    $.ajax({
        type: "POST",
        url: "http://localhost:8081/admin/addMovie",
        data: JSON.stringify( { name: name, year: year, directorId: director, country: country, genres: [genres] }),
        contentType: "application/json",
    }).done(function (movie) {
        console.log(movie)
        $("#buttonGetMovies").click()
    }).fail(function (err) {
        $("#movies").html("<p>Error!</p>");
    });
}

function getAllDirectors(div, name) {
    $.ajax({
        type: "GET",
        url: "http://localhost:8081/directors"
    }).done(function (listOfDirectors) {
        console.log(listOfDirectors);
        div.append(name).append('<select id="listDirectors" size="\'' + listOfDirectors.length + '\'"/>');
        $.each(listOfDirectors, function (index, director) {
            $('#listDirectors')
                .append($("<option></option>")
                    .attr("value", director.id)
                    .text(director.name + " " + director.last_name));
        })
    })
}

function getSelectListOfDirectors() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8081/directors"
    }).done(function (listOfDirectors) {
        console.log(listOfDirectors);
        $("#directors").append('<select name="listDirectors" size="\'' + listOfDirectors.length + '\'"/>');
        return $.each(listOfDirectors, function (index, director) {
            $("#directors").append($('#listDirectors')
                .append($("<option></option>")
                    .attr("director", index)
                    .text(director.name + " " + director.last_name)));
        })
    })
}


function deleteByClick(id) {
    if (confirm('Delete movie?')) {
        $.ajax({
            type: "DELETE",
            url: "http://localhost:8081/admin/deleteMovie?" + $.param({id: id})
        }).done(function () {
            getListOfMovies()
        }).fail(function (err) {
            $("#movies").html("<p>Error!</p>");
        });
    } else {
        return false;
    }
}


