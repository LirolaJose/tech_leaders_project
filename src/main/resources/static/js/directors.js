function directors() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8081/directors"
    }).done(function (directors) {
        console.log(directors);
        $("#listOfDirectors").empty();
        $.each(directors, function (index, director) {
            $("#listOfDirectors").append(index + 1 + ":" + director.name + " " + director.last_name + " " +
                '<input type="button" onclick="deleteDirector(\'' + director.id + '\');" value="delete"/>' + '<br/>')
        });
    })
}

function addNewDirector() {
    $("#text").html('<h2 style="color: steelblue">Create new director:</h2>');
    $("#name").append("Name: ").append('<input id="nameDirector"/>');
    $("#lastName").append("Last name: ").append('<input id="lastNameDirector"/>');
    $("#addDirector").append('<input type="button" onclick="createDirector()" value="Create director" />');

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
        $("#buttonGetAllDirectors").click()
    }).fail(function (err) {
        $("#movies").html("<p>Error!</p>");
    });
}

function deleteDirector (id){
    if (confirm('Delete director?')) {
        $.ajax({
            type: "DELETE",
            url: "http://localhost:8081/admin/deleteDirector?" + $.param({id: id})
        }).done(function () {
            directors();
        }).fail(function (err) {
            $("#listOfDirectors").html("<p>Error!</p>");
        });
    } else {
        return false;
    }
}