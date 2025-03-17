# edu-tanaka
- 田中さん研修用リポジトリ

# ネーミングルール
## ブランチ名
- issue番号-作業内容を簡略化したもの
- 例) 999-get-without-change

# コーディングルール
## コメントについて
* privateを除いた、クラス、メソッド、変数には、javadocを必須とする


# 運用ルール
- 必ずissueごとにブランチを作成し、そこで作業する
- インデントは半角SP2つ
- 指摘対応について、1指摘対応につき1commitし、指摘のリプライにコミットハッシュを貼り付ける
## テストについて
- 下記フォルダにテスト仕様書を格納する  
self-study\ApexLegendsApp\doc\test  
ファイル名は下記とする  
issuexxx_issueタイトル.md
## プルリク（レビュー依頼）について
- 作業途中でも随時プッシュして、プルリクをDraftで作成しておく
- 一通り作業が完了したらOpenにする

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

# プロジェクトのフォルダ構造
* src/main/java/com/example/demo
  * controller
    * MVCのコントローラクラスを配置
  * model
    * view
      * 画面表示用
    * entity
      * データモデル（エンティティ）クラスを配置
      * データベースのテーブルと直接マッピングされるオブジェクト
      * データベースの構造を表現
    * dto
      * レイヤー間（特にクライアントとサーバー間）でデータを転送するためのオブジェクト
      * データベースの構造に依存しない
  * repository
    * データアクセス層（DAO）を配置
  * service
    * ビジネスロジックを含むサービスクラスを格納
  * util
    * ユーティリティクラスを配置
  * exception
    * 業務例外クラスを配置



## 特筆すべき仕様
### m_legendのage、age_noteについて
- 年齢を設定する場合はageに年齢を設定する
- 年齢が不明の場合はageをnullにする
- 年齢に関する特記事項がある場合は、age_noteに設定する

