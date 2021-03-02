// JS with wait until DOM finished

var tag = document.createElement("p");
var text = document.createTextNode("Tutorix is the best e-learning platform in withwait");
tag.appendChild(text);

document.onreadystatechange = function () {
    if (document.readyState == "complete") {
        console.log('Document is ready, I can do something now. From JS withwait');

        var element = document.getElementById("new");
        element.appendChild(tag);
    }
}

