<html>
<head>
    <title>Story Report</title>
    <META http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="base-style.css" rel="stylesheet" type="text/css">
    <link href="style.css" rel="stylesheet" type="text/css">
    <script src="report.js" type="text/javascript"></script>
</head>
<body>
<div id="content">

    <h1 style="border-bottom: 1px solid grey;">Story Report</h1>

    <div id="summary">
        <p>This report links unit, integration and acceptance test to stories</p>
    </div>
    <div id="tabs">
        <div class="tab" id="tab0">
            <h2>Tests</h2>
            <table>
                <thead>
                <tr>
                    <th>Test</th>
                    <th>Test Method</th>
                    <th>Stories</th>
                </tr>
                </thead>
            <#list testDetails as details>
                <tr>
                    <td>${details.testName}</td>
                    <td>${details.testMethodName}</td>
                    <td class="success">
                        <#list details.stories as story>
                            <span style="padding-right:2px"><a target="_blank" href="${trelloBoard}${story}">${story}</a>
                            </span>
                        </#list>
                    </td>
                </tr>
            </#list>
            </table>
        </div>

    </div>

</body>
</html>