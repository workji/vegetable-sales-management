<div class="customer-list">
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>顧客名</th>
                <th>住所</th>
                <th>電話番号</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>
            <#list customers as customer>
                <tr>
                    <td>${customer.id}</td>
                    <td>${customer.name}</td>
                    <td>${customer.address}</td>
                    <td>${customer.phone}</td>
                    <td>
                        <a href="/customers/edit/${customer.id}">編集</a>
                        <a href="/customers/delete/${customer.id}" onclick="return confirm('削除してもよろしいですか？')">削除</a>
                    </td>
                </tr>
            </#list>
        </tbody>
    </table>
</div>