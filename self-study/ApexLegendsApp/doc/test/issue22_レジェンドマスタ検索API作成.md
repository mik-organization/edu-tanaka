# レジェンドマスタ検索APIのテスト仕様書
## はじめに
- サーバーを起動して、Talend API Testerを使ってテストを行う
- Json形式でリクエストを送る

## レジェンド全件検索機能
### 正常系 レジェンド全件検索
- METHOD「GET」、URL「http:\//localhost:8080\/legend」を入力して、sendをクリック

   - [x] エラーが返されないこと(200OK)
   - [x] データベースにあるレジェンドが全て表示されること  

### 異常系 METHOD間違い
- METHOD「PUT」、URL「http:\//localhost:8080/legend」を入力して、sendをクリック

  - [x] エラーが返されること（405 Method Not Allowed）  

### 異常系 URL間違い
- METHOD「GET」、URL「http:\//localhost:8080」を入力して、sendをクリック

  - [x] エラーが返されること（404 Not Found）  

## レジェンド名の部分一致検索機能
### 正常系 レジェンド 部分一致検索
- METHOD「GET」、URL「http:\//localhost:8080\/legend/あ」を入力して、sendをクリック

   - [x] エラーが返されないこと(200OK)
   - [x] 指定した文字を含んでいるレジェンドが表示されること  

- METHOD「GET」、URL「http:\//localhost:8080\/legend/ライフライン」を入力して、sendをクリック

   - [x] エラーが返されないこと(200OK)
   - [x] 指定したレジェンドが表示されること  

### 異常系 METHOD間違い
- METHOD「PUT」、URL「http:\//localhost:8080/legend/あ」を入力して、sendをクリック

  - [x] エラーが返されること（400 Bad Request）  

### 異常系 URL間違い
- METHOD「GET」、URL「http:\//localhost:8080」を入力して、sendをクリック

  - [x] エラーが返されること（404 Not Found）  

### 異常系 英語で指定
- METHOD「GET」、URL「http:\//localhost:8080/legend/a」を入力して、sendをクリック

  - [x] 該当のレジェンドが表示されないこと  
  → 別issueにて例外ハンドリング追加予定

## テスト結果（エビデンス）
- エビデンスは以下のフォルダに格納  
https://drive.google.com/drive/u/1/folders/1WgtSYg967vuUjqS73wywwhYm-Dpat7ww
