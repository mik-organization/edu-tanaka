# edu-tanaka
- 田中さん研修用リポジトリ

# ネーミングルール
## ブランチ名
- issue番号-作業内容を簡略化したもの
- 例) 999-get-without-change

# 運用ルール
- 必ずissueごとにブランチを作成し、そこで作業する

# ブランチ運用イメージ

```
                           hello---------
                           ↑            ↓
main ---ddl----->--ddl削除--------------------    
            ↓            ↓merge              ↑merge ddl新規追加
            2-apex-ddl   ---ddl削除--ddl追加----------
              ddlが存在
```
