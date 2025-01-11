<#import "/layout/base.ftl" as layout>
<@layout.base title="販売先編集">
    <div class="card">
        <div class="card-header">
            販売先編集
        </div>
        <div class="card-body">
            <form id="customerForm" action="/vsm/customers/${customer.id}/edit" method="post">
                <div class="form-group required">
                    <label for="name">顧客名</label>
                    <input type="text" class="form-control" id="name" name="name" 
                           value="${customer.name}" maxlength="100" required>
                </div>

                <div class="form-group required">
                    <label for="address">住所</label>
                    <input type="text" class="form-control" id="address" name="address" 
                           value="${customer.address}" maxlength="255" required>
                </div>

                <div class="form-group required">
                    <label for="phone">電話番号</label>
                    <input type="text" class="form-control" id="phone" name="phone" 
                           value="${customer.phone}" maxlength="20" placeholder="XXX-XXXX-XXXX" required>
                </div>

                <div class="mt-3">
                    <a href="/vsm/customers" class="btn btn-secondary">キャンセル</a>
                    <button type="submit" class="btn btn-primary">更新</button>
                </div>
            </form>
        </div>
    </div>
</@layout.base>