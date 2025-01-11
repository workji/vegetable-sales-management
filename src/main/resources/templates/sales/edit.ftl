<#import "/layout/base.ftl" as layout>
<@layout.base title="販売情報編集">
    <div class="card">
        <div class="card-header">
            販売情報編集
        </div>
        <div class="card-body">
            <form id="saleForm" action="/vsm/sales/${sale.id}/edit" method="post">
                <div class="form-group required">
                    <label for="vegetableId">野菜</label>
                    <select class="form-control" id="vegetableId" name="vegetableId" required>
                        <option value="">選択してください</option>
                        <#list vegetables as vegetable>
                            <option value="${vegetable.id}" <#if vegetable.id == sale.vegetableId>selected</#if>>
                                ${vegetable.name}
                            </option>
                        </#list>
                    </select>
                </div>

                <div class="form-group required">
                    <label for="customerId">販売先</label>
                    <select class="form-control" id="customerId" name="customerId" required>
                        <option value="">選択してください</option>
                        <#list customers as customer>
                            <option value="${customer.id}" <#if customer.id == sale.customerId>selected</#if>>
                                ${customer.name}
                            </option>
                        </#list>
                    </select>
                </div>

                <div class="form-group required">
                    <label for="quantity">数量</label>
                    <input type="number" class="form-control" id="quantity" name="quantity" 
                           value="${sale.quantity}" min="1" required>
                </div>

                <div class="form-group required">
                    <label for="price">単価</label>
                    <input type="number" class="form-control" id="price" name="price" 
                           value="${sale.price}" min="0" step="0.01" required>
                </div>

                <div class="form-group required">
                    <label for="saleDate">販売日</label>
                    <input type="date" class="form-control" id="saleDate" name="saleDate" 
                           value="${sale.saleDate?string('yyyy-MM-dd')}" required>
                </div>

                <div class="mt-3">
                    <a href="/vsm/sales" class="btn btn-secondary">キャンセル</a>
                    <button type="submit" class="btn btn-primary">更新</button>
                </div>
            </form>
        </div>
    </div>
</@layout.base>