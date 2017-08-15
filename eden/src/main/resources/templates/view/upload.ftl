<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
  <link rel="stylesheet" type="text/css" href="../resources/easyui/themes/default/easyui.css">
  <link rel="stylesheet" type="text/css" href="../resources/easyui/themes/icon.css">
  <link rel="stylesheet" type="text/css" href="../resources/easyui/demo/demo.css">
  <script type="text/javascript" src="../resources/common/js/jquery.min.js"></script>
  <script type="text/javascript" src="../resources/easyui/jquery.easyui.min.js"></script>
</head>
<body>
<h2>Lazy Load Tree Nodes</h2>
<p>Get full hierarchical tree data but lazy load nodes level by level.</p>
<div style="margin:20px 0;"></div>
<div class="easyui-panel" style="padding:5px">
    <ul class="easyui-tree" data-options="url:'tree_data1.json',method:'get',loadFilter:myLoadFilter"></ul>
</div>
<h2>Basic Tree</h2>
<p>Click the arrow on the left to expand or collapse nodes.</p>
<div style="margin:20px 0;"></div>
<div class="easyui-panel" style="padding:5px">
    <ul class="easyui-tree">
        <li>
            <span>My Documents</span>
            <ul>
                <li data-options="state:'closed'">
                    <span>Photos</span>
                    <ul>
                        <li>
                            <span>Friend</span>
                        </li>
                        <li>
                            <span>Wife</span>
                        </li>
                        <li>
                            <span>Company</span>
                        </li>
                    </ul>
                </li>
                <li>
                    <span>Program Files</span>
                    <ul>
                        <li>Intel</li>
                        <li>Java</li>
                        <li>Microsoft Office</li>
                        <li>Games</li>
                    </ul>
                </li>
                <li>index.html</li>
                <li>about.html</li>
                <li>welcome.html</li>
            </ul>
        </li>
    </ul>
</div>
</body>
</html>