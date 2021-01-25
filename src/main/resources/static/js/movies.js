var divInfoBlock = "#infoBlock";
var divAddMovie = "#addMovieBlock";

function getAllMovies() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8081/movies/allMovies"
    }).done(function (listOfMovies) {
        console.log(listOfMovies);
        // $(divInfoBlock).html(listOfMovies);
        $(divInfoBlock).empty();
        $.each(listOfMovies, function (index, movie) {
            $(divInfoBlock)
                .append(index + 1 + ": " + '<a href="#" style="color: forestgreen" onclick="movieInfo(' + movie.id + ');">' + movie.name + '</a>' +
                    " (" + movie.year + ") " +
                    '<input type="button" onclick="deleteByClick(\'' + movie.id + '\');" value="delete"/>' + '<br/>')
        });
    }).fail(function (err) {
        $(divInfoBlock).html("<p>Error!</p>");
    });
}

function movieInfo(id) {
    $.ajax({
        type: "GET",
        url: "http://localhost:8081/movies/byId?" + $.param({id: id})
    }).done(function (movie) {
        console.log(movie);
        $(divInfoBlock).empty();
        $(divInfoBlock).append(movie.name + " (" + movie.year + ") " + "\"" + movie.country + "\"" + '<br/>' +
            "Director: " + movie.directorEntity.name + " " + movie.directorEntity.last_name + '<br/>' +
            "Genre: " + Array.prototype.map.call(movie.genres, s => s.genre_name).join(", ") + '<br/>' +
            '<input type="button" onclick="getAllMovies();" value="Back"/>')
    });
}

function addNewMovie() {
    $(divAddMovie).html('<h2 style="color: steelblue">Enter movie details:</h2>')
    $(divAddMovie).append("Name: ").append('<input id="movieName">' + '<br/>')
        .append("Year: ").append('<input id="year">' + '<br/>')
        .append("Country: ").append('<input id="country">' + '<br/>');

    getAllDirectors("Director: ", $("#directors"))
    getAllGenres("Genres: ", $("#genres"))
    $("#createMovie").append('<input type="button" onclick="createMovie();" value="Create movie"/>');
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

function directors() {
    $(divInfoBlock).empty()
    $.ajax({
        type: "GET",
        url: "http://localhost:8081/directors"
    }).done(function (directors) {
        console.log(directors);
        $.each(directors, function (index, director) {
            $("#listOfDirectors").append(index + 1 + ":" + director.name + " " + director.last_name + '<br/>')
        });
    })

    $("#text").html('<h2 style="color: steelblue">Create new director:</h2>');

    $("#addDirector").append('<input type="button" onclick="createDirector()" value="Create director" />');
    $("#name").append("Name: ").append('<input id="nameDirector"/>');
    $("#lastName").append("Last name: ").append('<input id="lastNameDirector"/>');

    // getAllDirectors("Directors: ", $("#listOfDirectors"));
}

function createDirector() {
    var nameDir = $("#nameDirector").val();
    var lastNameDir = $("#lastNameDirector").val();

    $.ajax({
        type: "POST",
        url: "http://localhost:8081/admin/addDirector",
        data: JSON.stringify({name: nameDir, lastName: lastNameDir}),
        contentType: "application/json",
    }).done(function (director) {
        console.log(director)
    }).fail(function (err) {
        $("#movies").html("<p>Error!</p>");
    });
}

function getAllGenres(name, div) {
    $.ajax({
        type: "GET",
        url: "http://localhost:8081/genres"
    }).done(function (genres) {
        console.log(genres);
        div.append(name).append('<select id="selectedGenres" style="width: 150px;" data-placeholder="Choose genres..."  multiple class="chosen-select" name="listOfGenres">');
        $.each(genres, function (index, genre) {
            $(".chosen-select").append($("<option></option>")
                .attr("value", genre.id)
                .text(genre.genre_name))
        })
        $(".chosen-select").chosen({
            no_results_text: "Oops, nothing found!"
        }).fail(function (err) {
            $(div).html("<p>Error!</p>");
        });
    })
}

//TODO update
function deleteByClick(id) {
    if (confirm('Delete movie?')) {
        $.ajax({
            type: "DELETE",
            url: "http://localhost:8081/admin/deleteMovie?" + $.param({id: id})
        }).done(function () {
            getAllMovies()
        }).fail(function (err) {
            $("#movies").html("<p>Error!</p>");
        });
    } else {
        return false;
    }
}


