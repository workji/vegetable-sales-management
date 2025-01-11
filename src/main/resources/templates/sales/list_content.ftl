<div class="sales-list">
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>日付</th>
                <th>金額</th>
                <th>顧客名</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>
            <#list sales as sale>
                <tr>
                    <td>${sale.id}</td>
                    <td>${sale.saleDate?string("yyyy-MM-dd")}</td>
                    <td>${sale.price?string("0.00")!"N/A"}</td>
                    <td>${sale.customerName}</td>
                    <td>
                        <a href="/sales/edit/${sale.id}">編集</a>
                        <a href="/sales/delete/${sale.id}" onclick="return confirm('削除してもよろしいですか？')">削除</a>
                    </td>
                </tr>
            </#list>
        </tbody>
    </table>
</div>