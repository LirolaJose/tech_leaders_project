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
    getAllDirectors("Director: ", $(divDirectors));
    getAllGenres("Genres: ", $(divGenres));
    $("#createMovie").append('<input type="button" onclick="createMovie();" value="Create movie"/>')
}

function createMovie() {
    var name = $("#movieName").val();
    var year = $("#year").val();
    var country = $("#country").val();
    var director = $("#selectDirectors option:selected").val();
    var genres = $("#selectedGenres").val();

    $.ajax({
        type: "POST",
        url: "http://localhost:8081/admin/addMovie",
        data: JSON.stringify({name: name, year: year, directorId: director, country: country, genres: genres}),
        contentType: "application/json",
    }).done(function (movie) {
        console.log(movie)
        $("#buttonGetMovies").click()
    }).fail(function (err) {
        $("#movies").html("<p>Error!</p>");
    });
}

function getAllDirectors(name, div) {
    $.ajax({
        type: "GET",
        url: "http://localhost:8081/directors"
    }).done(function (listOfDirectors) {
        console.log(listOfDirectors);
        div.append(name).append('<select id="selectDirectors" size="\'' + listOfDirectors.length + '\'"/>');
        $.each(listOfDirectors, function (index, director) {
            $('#selectDirectors').append($("<option></option>")
                .attr("value", director.id)
                .text(director.name + " " + director.last_name));
        }).fail(function (err) {
            $(div).html("<p>Error!</p>");
        });
    })
}

function getAllGenres(name, div) {
    $.ajax({
        type: "GET",
        url: "http://localhost:8081/genres"
    }).done(function (genres) {
        console.log(genres);
        div.append(name).append('<select id="selectedGenres" data-placeholder="Begin typing a name to filter..."  multiple class="chosen-select" name="test">')
        $.each(genres, function (index, genre) {
            $(".chosen-select").append($("<option></option>")
                    .attr("value", genre.id)
                    .text(genre.genre_name))
            })
        $(".chosen-select").chosen({
            no_results_text: "Oops, nothing found!"
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


