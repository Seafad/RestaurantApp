<html>
    <head>
        <title>AJAX example</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <script src="script/jquery-2.1.4.js"></script>
    </head>
    <body>
        <div id="maindiv">
            <form action="NewObject" method="GET">
                <h1>Contact information</h1>
                <hr>
                <p>Name:</p>
                <input name="name" id="name" type="text" size="25" placeholder="Enter your name here!">
                <p>E-mail:</p>
                <input name="email" id="email" type="text" size="25" placeholder="Enter your email here!">
                <p>Phone:</p>
                <input name="phone" id="phone" type="text" size="25" placeholder="Enter your phone here!">
                <p>Address:</p>
                <input name="address" id="address" type="text" size="25" placeholder="Enter your address here!"><br>
                <button type="submit"  id="submit">Get object using object-creator servlet forwarding to object writer servlet forwarding to another .jsp page!</button>
                <br>
                <div class="message">
                    <p><span>Disclaimer: </span>
                        <i>The content you will see may seem ugly, besides the page will be refreshed to fulfill your worst nightmares!</i> Enjoy :)</p>
                </div>
            </form>
            <form id="downloadForm" action="FileDownloader" method="GET">
                <h1>Download file</h1>
                <input name="filePath" id="filePath" type="text">
                <button id="download" type="submit">Download file!</button>
            </form>
            <button id="submit2">Get object with AJAX!</button>
            <script type="text/javascript" src="script/ajax.js"></script>
        </div>
    </body>

</html>
