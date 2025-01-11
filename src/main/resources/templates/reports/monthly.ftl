<#import "/layout/base.ftl" as layout>
<@layout.base title="月別売上情報">
    <div class="card">
        <div class="card-header">
            検索条件
        </div>
        <div class="card-body">
            <form id="reportForm" action="/vsm/reports/monthly" method="get">
                <div class="row">
                    <div class="col-md-4">
                        <div class="form-group required">
                            <label for="year">年</label>
                            <select class="form-control" id="year" name="year" required>
                                <#list (currentYear - 5)..(currentYear + 5) as y>
                                    <option value="${y}" <#if y == year>selected</#if>>${y}</option>
                                </#list>
                            </select>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="form-group required">
                            <label for="month">月</label>
                            <select class="form-control" id="month" name="month" required>
                                <#list 1..12 as m>
                                    <option value="${m}" <#if m == month>selected</#if>>${m}</option>
                                </#list>
                            </select>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="form-group">
                            <label for="customerId">販売先</label>
                            <select class="form-control" id="customerId" name="customerId">
                                <option value="">全て</option>
                                <#list customers as customer>
                                    <option value="${customer.id}" <#if customer.id == selectedCustomerId!-1>selected</#if>>
                                        ${customer.name}
                                    </option>
                                </#list>
                            </select>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <div class="card mt-3">
        <div class="card-header d-flex justify-content-between align-items-center">
            売上情報一覧
            <button id="downloadCsv" class="btn btn-success">
                <i class="bi bi-download"></i> CSVダウンロード
            </button>
        </div>
        <div class="card-body">
            <table class="table">
                <thead>
                    <tr>
                        <th>販売日</th>
                        <th>野菜名</th>
                        <th>販売先</th>
                        <th>数量</th>
                        <th>単価</th>
                        <th>合計金額</th>
                    </tr>
                </thead>
                <tbody>
                    <#assign totalQuantity = 0>
                    <#assign totalAmount = 0>
                    <#list sales as sale>
                        <tr>
                            <td>${sale.saleDate?string('yyyy-MM-dd')}</td>
                            <td>${sale.vegetableName!""}</td>
                            <td>${sale.customerName!""}</td>
                            <td>${sale.quantity}</td>
                            <td>${sale.price}</td>
                            <td>${(sale.price * sale.quantity)}</td>
                        </tr>
                        <#assign totalQuantity = totalQuantity + sale.quantity>
                        <#assign totalAmount = totalAmount + (sale.price * sale.quantity)>
                    <#else>
                        <tr>
                            <td colspan="6" class="text-center">データがありません。</td>
                        </tr>
                    </#list>
                </tbody>
                <tfoot>
                    <tr class="table-info">
                        <th colspan="3">合計</th>
                        <th>${totalQuantity}</th>
                        <th>-</th>
                        <th>${totalAmount}</th>
                    </tr>
                </tfoot>
            </table>
        </div>
    </div>
</@layout.base>