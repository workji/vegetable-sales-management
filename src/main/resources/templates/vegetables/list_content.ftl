<div class="vegetable-list">
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>野菜名</th>
                <th>価格</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>
            <#list vegetables as vegetable>
                <tr>
                    <td>${vegetable.id}</td>
                    <td>${vegetable.name}</td>
                    <td>${vegetable.price!0}</td>
                    <td>
                        <a href="/vegetables/edit/${vegetable.id}">編集</a>
                        <a href="/vegetables/delete/${vegetable.id}" onclick="return confirm('削除してもよろしいですか？')">削除</a>
                    </td>
                </tr>
            </#list>
        </tbody>
    </table>
</div>