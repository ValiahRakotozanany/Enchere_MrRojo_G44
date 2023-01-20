<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>ListeDeroulant</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/styles.css">
</head>

<body style="margin-bottom: 1px;">
    <div class="container">
        <div class="row">
            <div class="col-4 col-md-7 offset-4">
                <p style="margin-bottom: 0px;">Province</p><select id="prov" class="form-select" onchange="getRegion()" style="margin-bottom: 10px;">
                </select>
                <p style="margin-bottom: 0px;">region</p><select disabled id="reg" class="form-select" onchange="getDistrict()" style="margin-bottom: 10px;">
                </select>
                <p style="margin-bottom: 0px;">district</p><select disabled id="dist" class="form-select" onchange="getCommune()" style="margin-bottom: 10px;">
                </select>
                <p style="margin-bottom: 0px;">commune</p><select disabled id="comm" class="form-select" style="margin-bottom: 10px;">
                </select>
            </div>
        </div>
    </div>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script>
        var xhr;
        try {
            xhr = new ActiveXObject('Msxml2.XMLHTTP');
        } catch (e) {
            try {
                xhr = new ActiveXObject('Microsoft.XMLHTTP');
            } catch (e2) {
                try {
                    xhr = new XMLHttpRequest();
                } catch (e3) {
                    xhr = false;
                }
            }
        }
        window.addEventListener('load', function() {
            xhr.onreadystatechange = function() {
                if (xhr.readyState == 4) {
                    if (xhr.status == 200) {
                        var province = JSON.parse(xhr.responseText);
                        var html = `<option value="">--Selectionner--</option>`;
                        for (let i = 0; i < province.length; i++) {
                            html += `
                                <option value="` + province[i].id + `">` + province[i].nom + `</option>
                        `;

                        }
                        document.getElementById('prov').innerHTML = html;


                    } else {
                        document.dyn = "Error code " + xhr.status;
                    }
                }
            };

            xhr.open("GET", "ListeProvince.php");
            xhr.send(null);
        });

        function getRegion() {
            var province = document.getElementById('prov').value;
            xhr.onreadystatechange = function() {
                if (xhr.readyState == 4) {
                    if (xhr.status == 200) {
                        document.getElementById('reg').disabled = false;
                        var region = JSON.parse(xhr.responseText);
                        var html = `<option value="">--Selectionner--</option>`;
                        for (let i = 0; i < region.length; i++) {
                            html += `
                                <option value="` + region[i].id + `">` + region[i].nom + `</option>
                        `;

                        }
                        document.getElementById('reg').innerHTML = html;


                    } else {
                        document.dyn = "Error code " + xhr.status;
                    }
                }
            }

            xhr.open("POST", "ListeRegion.php?prov="+province);
            xhr.send();
        }

        function getDistrict() {
            var region = document.getElementById('reg').value;
            xhr.onreadystatechange = function() {
                if (xhr.readyState == 4) {
                    if (xhr.status == 200) {
                        document.getElementById('dist').disabled = false;
                        var district = JSON.parse(xhr.responseText);
                        var html = `<option value="">--Selectionner--</option>`;
                        for (let i = 0; i < district.length; i++) {
                            html += `
                                <option value="` + district[i].id + `">` + district[i].nom + `</option>
                        `;

                        }
                        document.getElementById('dist').innerHTML = html;


                    } else {
                        document.dyn = "Error code " + xhr.status;
                    }
                }
            }

            xhr.open("POST", "ListeDistrict.php?reg="+region);
            xhr.send();
        }

        function getCommune() {
            var district = document.getElementById('dist').value;
            xhr.onreadystatechange = function() {
                if (xhr.readyState == 4) {
                    if (xhr.status == 200) {
                        document.getElementById('comm').disabled = false;
                        var commune = JSON.parse(xhr.responseText);
                        var html = `<option value="">--Selectionner--</option>`;
                        for (let i = 0; i < commune.length; i++) {
                            html += `
                                <option value="` + commune[i].id + `">` + commune[i].nom + `</option>
                        `;

                        }
                        document.getElementById('comm').innerHTML = html;


                    } else {
                        document.dyn = "Error code " + xhr.status;
                    }
                }
            }

            xhr.open("POST", "ListCommune.php?dist="+district);
            xhr.send();
        }

    </script>
</body>

</html>