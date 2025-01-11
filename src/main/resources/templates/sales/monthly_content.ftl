<div class="monthly-sales">
    <form action="/sales/monthly" method="get">
        <label for="year">Year:</label>
        <input type="text" id="year" name="year" value="${(searchYear?if_exists!"${currentYear}")?c}" required pattern="\d{4}" title="Please enter a valid 4-digit year" oninput="this.value = this.value.replace(/[^0-9]/g, '').slice(0, 4);">
        <label for="month">Month:</label>
        <input type="number" id="month" name="month" value="${searchMonth!currentMonth}" required>
        <label for="customer">Customer:</label>
        <select id="customer" name="customer">
            <option value="">All</option>
            <#list customers as customer>
                <option value="${customer.id}" <#if searchCustomerId?has_content && (customer.id == searchCustomerId?number)>selected</#if>>${customer.name}</option>
            </#list>
        </select>
        <button type="submit">Submit</button>
    </form>
    <br/>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>日付</th>
                <th>金額</th>
                <th>顧客名</th>
            </tr>
        </thead>
        <tbody>
            <#if monthlySales??>
                <#list monthlySales as sale>
                    <tr>
                        <td>${sale.id}</td>
                        <td>${sale.saleDate?string("yyyy-MM-dd")}</td>
                        <td>${sale.price!"N/A"}</td>
                        <td>${sale.customerName}</td>
                    </tr>
                </#list>
            <#else>
                <tr>
                    <td colspan="4">No sales data available for the selected month.</td>
                </tr>
            </#if>
        </tbody>
    </table>
</div>