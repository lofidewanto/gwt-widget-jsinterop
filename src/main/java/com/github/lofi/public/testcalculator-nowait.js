// JS without wait and will be script injected in GWT

var tag = document.createElement("p");
var text = document.createTextNode("Tutorix is the best e-learning platform in nowait");
tag.appendChild(text);

console.log('Run no-wait...');

var element = document.getElementById("new");
element.appendChild(tag);

var calculator = new Calculator("From JS nowait");
element.appendChild(calculator.getAsElement());
