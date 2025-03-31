# レジェンドマスタ登録・削除・更新APIのテスト仕様書
## はじめに
- サーバーを起動して、Talend API Testerを使ってテストを行う
- Json形式でリクエストを送る

## レジェンド登録機能
### 正常系 レジェンド登録
- METHOD「POST」、URL「http:\//localhost:8080\/legend」、BODYに「"name":"ラプソディ"、"age":23、"sortIndex":27」を入力して、sendをクリック

   - [x] エラーが返されないこと(200OK)
   - [x] 入力した内容が結果として返されること
   - [x] データベースに登録されていること  

### 異常系 METHOD間違い
- METHOD「PUT」、URL「http:\//localhost:8080/legend」、BODYに「"name":"フェード"、"age":55、"sortIndex":28」を入力して、sendをクリック

  - [x] エラーが返されること（405 Method Not Allowed）  

### 異常系 URL間違い
- METHOD「POST」、URL「http:\//localhost:8080」、BODYに「"name":"フェード"、"age":55、"sortIndex":28」にしてsendをクリック

  - [x] エラーが返されること（404 Not Found）  

### 異常系 id指定（URL間違い）
- METHOD「POST」、URL「http:\//localhost:8080/legend/28」、BODYに「"name":"フェード"、"age":55、"sortIndex":28」を入力して、sendをクリック

  - [x] エラーが返されること（405 Method Not Allowed）

### 異常系 必須項目未設定（nameとSortIndex）
- METHOD「POST」、URL「http:\//localhost:8080/legend」、BODYに「"age":55」を入力して、sendをクリック

  - [x] エラーが返されること（500 Internal Server Error）  

### 異常系 insortIndexを文字列で設定
- METHOD「POST」、URL「http:\//localhost:8080/legend」、BODYに「"name":"フェード"、"age":55、"sortIndex":"aa"」を入力して、sendをクリック

  - [x] エラーが返されること（400 Bad Request）  

### 異常系 ageを文字列で設定
- METHOD「POST」、URL「http:\//localhost:8080/legend」、BODYに「"name":"フェード"、"age":"ごじゅうご"、"sortIndex":28」を入力して、sendをクリック

  - [x] エラーが返されること（400 Bad Request） 

## レジェンド更新機能
### 正常系 レジェンド更新
- METHOD「PUT」、URL「http:\//localhost:8080/legend/27」、BODYに「"name":"ラプソディ", "realName":"リン・ミ・ヴォ"、"gender":"女性", "sortIndex":27」を入力して、sendをクリック

  - [x] エラーが返されないこと(200OK)
  - [x] 入力した内容が結果として返されること
  - [x] データベースに更新されていること  

 - 備考
   - 更新時もnameとsortIndexを指定する必要はあるか（別issueにて対応予定）  
   - 現状、上書更新になっているため、全部指定しないと前のデータは消されてしまう（〃）
   - nameとsortIndexがnullで更新された場合はエラー表示させるようにしたい（〃）

### 異常系 METHOD間違い
- METHOD「POST」、URL「http:\//localhost:8080/legend/27」、BODYに「"name": "ラプソディ"、"realName":"リン・ミ・ヴォ"、"gender":"女性", "sortIndex": 27」を入力して、sendをクリック

  - [x] エラーが返されること（405 Method Not Allowed）  

### 異常系 存在しないidを指定
- METHOD「PUT」、URL「http:\//localhost:8080/legend/100」、BODYに「"name": "ラプソディ"、"realName":"リン・ミ・ヴォ"、"gender":"女性", "sortIndex": 27」を入力して、sendをクリック

  - [x] エラーが返されること（500 Internal Server Error）
  - [x] エラーメッセージに「レジェンドID100は見つかりません」と表示  

### 異常系 id未指定
- METHOD「PUT」、URL「http:\//localhost:8080/legend」、BODYに「"name": "ラプソディ"、"realName":"リン・ミ・ヴォ"、"gender":"女性", "sortIndex": 27」を入力して、sendをクリック

  - [x] エラーが返されること（405 Method Not Allowed）  

### 異常系 insortIndexを文字列で設定
- METHOD「PUT」、URL「http:\//localhost:8080/legend/27」、BODYに「"name": "ラプソディ"、"realName":"リン・ミ・ヴォ"、"gender":"女性", "sortIndex": "bb"」を入力して、sendをクリック


  - [x] エラーが返されること（400 Bad Request）  

### 異常系 ageを文字列で設定
- METHOD「PUT」、URL「http:\//localhost:8080/legend/27」、BODYに「"name": "ラプソディ"、"realName":"リン・ミ・ヴォ"、"age":"にじゅういち"、"gender":"女性", "sortIndex": 27」を入力して、sendをクリック

  - [x] エラーが返されること（400 Bad Request） 

## レジェン削除機能
### 正常系 レジェンド削除
- METHOD「DELETE」、URL「http:\//localhost:8080/legend/27」を入力して、sendをクリック

  - [x] エラーが返されないこと(200OK)
  - [x] 「レジェンドID27は削除されました」と返されること
  - [x] データベースから削除されていること  

### 異常系 METHOD間違い
- METHOD「POST」、URL「http:\//localhost:8080/legend/1」を入力して、sendをクリック

  - [x] エラーが返されること（405 Method Not Allowed）  

### 異常系 存在しないidを指定
- METHOD「DELETE」、URL「http:\//localhost:8080/legend/100」を入力して、sendをクリック

  - [x] エラーが返されること（500 Internal Server Error）
  - [x] エラーメッセージに「レジェンドID100は見つかりません」と表示  

### 異常系 id未指定
- METHOD「DELETE」、URL「http:\//localhost:8080/legend」を入力して、sendをクリック

  - [x] エラーが返されること（405 Method Not Allowed）

## テスト結果（エビデンス）
- エビデンスは以下のフォルダに格納
https://drive.google.com/drive/folders/1fBQBw_KvgdEczQj4EadISnfAeKI37P_p
