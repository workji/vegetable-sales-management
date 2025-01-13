<#import "../layout/base.ftl" as layout>
<@layout.base title="月別売上情報">
    <div class="card">
        <div class="card-header">
            検索条件
        </div>
        <div class="card-body">
            <form id="reportForm" action="/reports/monthly" method="get">
                <div class="row">
                    <div class="col-md-2">
                        <div class="form-group required">
                            <label for="year">年</label>
                            <select class="form-control" id="year" name="year" required>
                                <#list (currentYear - 5)..(currentYear + 5) as y>
                                    <option value="${y?c}" <#if y == (searchYear?if_exists!currentYear?number)>selected</#if>>${y?c}</option>
                                </#list>
                            </select>
                        </div>
                    </div>
                    <div class="col-md-2">
                        <div class="form-group required">
                            <label for="month">月</label>
                            <select class="form-control" id="month" name="month" required>
                                <#list 1..12 as m>
                                    <option value="${m}" <#if m == searchMonth!currentMonth>selected</#if>>${m}</option>
                                </#list>
                            </select>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="form-group">
                            <label for="customerId">販売先</label>
                            <select class="form-control" id="customer" name="customer">
                                <option value="">全て</option>
                                <#list customers as customer>
                                    <option value="${customer.id}" <#if customer.id == searchCustomerId! -1>selected</#if>>
                                        ${customer.name}
                                    </option>
                                </#list>
                            </select>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="form-group">
                            <button type="submit">Submit</button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <div class="card mt-3">
        <div class="card-header d-flex justify-content-between align-items-center">
            売上情報一覧
            <a href="/reports/monthly/csv?year=${searchYear?c}&month=${searchMonth}&customer=${searchCustomerId}" class="btn btn-success">
                <i class="bi bi-download"></i> CSVダウンロード
            </a>
        </div>
        <div class="card-body">
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
    </div>
</@layout.base>