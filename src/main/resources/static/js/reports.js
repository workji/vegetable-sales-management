/**
 * 月別売上情報画面用JavaScript
 */

$(document).ready(function() {
    // 検索フォームのバリデーション
    $('#reportForm').on('submit', function(e) {
        if (!validateForm($(this))) {
            e.preventDefault();
        }
    });

    // 年月が変更されたらフォームを自動送信
    $('#year, #month, #customerId').on('change', function() {
        $('#reportForm').submit();
    });

    // CSVダウンロードボタンのクリック処理
    $('#downloadCsv').on('click', function() {
        var year = $('#year').val();
        var month = $('#month').val();
        var customerId = $('#customerId').val();
        
        var url = '/vsm/reports/monthly/download?year=' + year + '&month=' + month;
        if (customerId) {
            url += '&customerId=' + customerId;
        }
        
        window.location.href = url;
    });
});