<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>野菜販売管理システム</title>
    <link rel="stylesheet" href="/css/style.css">
    <script src="/js/common.js"></script>
</head>
<body>
    <div class="container">
        <div class="menu">
            <h2>メニュー</h2>
            <ul>
                <li><a href="/vegetables">野菜</a></li>
                <li><a href="/customers">販売先</a></li>
                <li><a href="/sales">販売情報</a></li>
                <li><a href="/sales/monthly">月別売上情報</a></li>
            </ul>
        </div>
        <div class="main-content">
            <div class="page-title">
                <h1>${pageTitle!''}</h1>
            </div>
            <div class="content">
                <#include contentTemplate>
            </div>
        </div>
    </div>
</body>
</html>