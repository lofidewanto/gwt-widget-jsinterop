// JS with wait until DOM finished

// Function for waiting an object is available
// See https://stackoverflow.com/questions/8618464/how-to-wait-for-another-js-to-load-to-proceed-operation
function whenAvailable(name, callback) {
    var interval = 10; // ms
    window.setTimeout(function () {
        if (window[name]) {
            callback(window[name]);
        } else {
            whenAvailable(name, callback);
        }
    }, interval);
}

var tag = document.createElement("p");
var text = document.createTextNode("Tutorix is the best e-learning platform in withwait");
tag.appendChild(text);

document.onreadystatechange = function () {
    if (document.readyState == "complete") {
        console.log('Document is ready, I can do something now. From JS withwait');

        var element = document.getElementById("new");
        element.appendChild(tag);

        // Wait until Calculator available
        whenAvailable("Calculator", function (t) {
            var calculator = new Calculator("From JS withwait");
            element.appendChild(calculator.getAsElement());
        });
    }
}

