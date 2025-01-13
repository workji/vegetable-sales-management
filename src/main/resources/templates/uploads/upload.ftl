<#import "../layout/base.ftl" as layout>
<@layout.base title="データ一括投入">
    <div class="card">
        <div class="card-header">野菜データ一括投入</div>
        <div class="card-body">
            <form action="/uploads/uploadVegetables" method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="vegetableFile">Upload Vegetable Excel File</label>
                    <input type="file" class="form-control" id="vegetableFile" name="file" accept=".xls,.xlsx" required>
                </div>
                <button type="submit" class="btn btn-primary">Upload Vegetables</button>
            </form>
        </div>
    </div>
    <div class="card">
        <div class="card-header">販売先データ一括投入</div>
        <div class="card-body">
            <form action="/uploads/uploadCustomers" method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="customerFile">Upload Customer Excel File</label>
                    <input type="file" class="form-control" id="customerFile" name="file" accept=".xls,.xlsx" required>
                </div>
                <button type="submit" class="btn btn-primary">Upload Customers</button>
            </form>
        </div>
    </div>
    <div class="card">
        <div class="card-header">販売データ一括投入</div>
        <div class="card-body">
            <form action="/uploads/uploadSales" method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="salesFile">Upload Sales Excel File</label>
                    <input type="file" class="form-control" id="salesFile" name="file" accept=".xls,.xlsx" required>
                </div>
                <button type="submit" class="btn btn-primary">Upload Sales</button>
            </form>
        </div>
    </div>
</@layout.base>