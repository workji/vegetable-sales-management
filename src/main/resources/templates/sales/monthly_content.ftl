<div class="monthly-sales">
    <table>
        <thead>
            <tr>
                <th>月</th>
                <th>売上金額</th>
                <th>顧客数</th>
            </tr>
        </thead>
        <tbody>
            <#list monthlySales as sale>
                <tr>
                    <td>${sale.month}</td>
                    <td>${sale.amount}</td>
                    <td>${sale.customerCount}</td>
                </tr>
            </#list>
        </tbody>
    </table>
</div>