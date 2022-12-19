window.onload = function () {
    getSub("CSE", "1");
};

async function getSub(branch, sem) {
    const element = document.getElementById("search");
    const api_url = "http://localhost:8082/search/getSubjects";

    const response = await fetch(api_url, {
        method: 'POST',
        body: JSON.stringify({
            "branch": branch,
            "sem": parseInt(sem)
        })
    })

    const data = await response.json();

    element.options.length = 0;
    for (i = 0; i < data.length; i++) {
        createOption(element, data[i], data[i]);
    }
}

function createOption(ddl, text, value) {
    var opt = document.createElement('option');
    opt.value = value;
    opt.text = text;
    ddl.options.add(opt);
}