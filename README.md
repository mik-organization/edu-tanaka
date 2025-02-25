# edu-tanaka
- 田中さん研修用リポジトリ

# ネーミングルール
## ブランチ名
- issue番号-作業内容を簡略化したもの
- 例) 999-get-without-change

# 運用ルール
- 必ずissueごとにブランチを作成し、そこで作業する
- インデントは半角SP2つ
- 指摘対応について、1指摘対応につき1commitし、指摘のリプライにコミットハッシュを貼り付ける

# ブランチ運用イメージ

```
                           hello---------
                           ↑            ↓
main ---ddl----->--ddl削除--------------------    
            ↓            ↓merge              ↑merge ddl新規追加
            2-apex-ddl   ---ddl削除--ddl追加----------
              ddlが存在
```

# Apex app
## DB接続情報
spring.datasource.url=jdbc:mysql://localhost:3306/apex_db  
spring.datasource.username=apex_user  
spring.datasource.password=apex  
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver  

## 特筆すべき仕様
### m_legendのage、age_noteについて
- 年齢を設定する場合はageに年齢を設定する
- 年齢が不明の場合はageをnullにする
- 年齢に関する特記事項がある場合は、age_noteに設定する

