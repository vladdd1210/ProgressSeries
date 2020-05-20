var form = document.forms["addEpisode"],
    select = form["IDTitle"],
    option = select.querySelectorAll("option"),
    input = form["IDTitleText"],
    reg;
input.oninput = function() {
    reg = new RegExp(this.value, "ig");
    select.options.length = 0;
    for (var i=0; i<option.length; i++)  {
       reg.test(option[i].text) && select.options.add(option[i]);
       reg.lastIndex = 0;
    }
};
