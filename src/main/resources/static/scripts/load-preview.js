window.onload = function () {
    getSub("CSE", "1");

    var pdf = document.getElementById("the_pdf");
    pdf.onchange = function (ev) {
        document.getElementById("preview_msg").style.display = "unset";
        file = document.getElementById("the_pdf").files[0];

        fileReader = new FileReader();
        fileReader.onload = function (ev) {
            console.log("loading PDF");
            pdfjsLib
                .getDocument({data: fileReader.result})
                .promise.then((pdf) => {
                pdf.getPage(1).then(function (page) {
                    var desiredWidth = 100;
                    var viewport = page.getViewport({scale: 1});
                    var scale = desiredWidth / viewport.width;
                    var scaledViewport = page.getViewport({scale: scale});

                    var canvas = document.getElementById("the-canvas");
                    var context = canvas.getContext("2d");

                    canvas.height = scaledViewport.height;
                    canvas.width = scaledViewport.width;

                    var renderContext = {
                        canvasContext: context,
                        viewport: scaledViewport,
                    };
                    var renderTask = page.render(renderContext);
                    renderTask.promise.then(function () {
                        console.log("Page rendered");
                        document.getElementById("preview_msg").style.display =
                            "none";
                        var png_data = canvas.toDataURL("image/png");
                        document.getElementById("pdf_preview").src = png_data;
                    });
                });
            });
        };
        fileReader.readAsArrayBuffer(file);
    };
};

async function getSub(branch, sem) {
    const element = document.getElementById("search");
    const api_url = "http://localhost:8082/search/getSubjects";

    const response = await fetch(api_url, {
        method: "POST",
        body: JSON.stringify({
            branch: branch,
            sem: parseInt(sem),
        }),
    });

    const data = await response.json();

    element.options.length = 0;
    for (i = 0; i < data.length; i++) {
        createOption(element, data[i], data[i]);
    }
}

function createOption(ddl, text, value) {
    var opt = document.createElement("option");
    opt.value = value;
    opt.text = text;
    ddl.options.add(opt);
}
