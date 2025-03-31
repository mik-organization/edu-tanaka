# レジェンドマスタ登録・削除・更新APIのテスト仕様書
## はじめに
- サーバーを起動して、Talend API Testerを使ってテストを行う
- Json形式でリクエストを送る

## レジェンド登録機能
### 正常系 レジェンド登録
- METHOD「POST」、URL「http:\//localhost:8080\/legend」、BODYに「"name":"ラプソディ"、"realName":"リン・ミ・ヴォ"、"age":23、"sortIndex":28」を入力して、sendをクリック

   - [ ] エラーが返されないこと(200OK)
   - [ ] 入力した内容が結果として返されること
   - [ ] データベースに登録されていること  

### 異常系 METHOD間違い
- METHOD「PUT」、URL「http:\//localhost:8080/legend」、BODYに「"name":"ラプソディ"、"age":23、"sortIndex":28」を入力して、sendをクリック

  - [ ] エラーが返されること（405 Method Not Allowed）  

### 異常系 URL間違い
- METHOD「POST」、URL「http:\//localhost:8080」、BODYに「"name":"ラプソディ"、"age"=23、"sortIndex"=28」にしてsendをクリック

  - [ ] エラーが返されること（404 Not Found）  

### 異常系 id指定（URL間違い）
- METHOD「POST」、URL「http:\//localhost:8080/legend/34」、BODYに「"name":"ラプソディ"、"age"=23、"sortIndex"=28」を入力して、sendをクリック

  - [ ] エラーが返されること（405 Method Not Allowed）

### 異常系 必須項目未設定（nameとSortIndex）
- METHOD「POST」、URL「http:\//localhost:8080」、BODYに「"age"=23」を入力して、sendをクリック

  - [ ] エラーが返されること（500 Internal Server Error）  

### 異常系 insortIndexを文字列で設定
- METHOD「POST」、URL「http:\//localhost:8080」、BODYに「"name"="ラプソディ"、"age"=23、"sortIndex"="aa"」を入力して、sendをクリック

  - [ ] エラーが返されること（400 Bad Request）  

## レジェンド更新機能
### 正常系 レジェンド更新
- METHOD「PUT」、URL「http:\//localhost:8080/legend/33」、BODYに「"name":"ラプソディ", "realName":"リン・ミ・ヴォ"、"gender":"女性", "sortIndex":28」を入力して、sendをクリック

  - [ ] エラーが返されないこと(200OK)
  - [ ] 入力した内容が結果として返されること
  - [ ] データベースに更新されていること  

 - 備考
   - 更新時もnameとsortIndexを指定する必要はあるか（別issueにて対応予定）  
   - nameとsortIndexがnullで更新された場合はエラー表示させる

### 異常系 METHOD間違い
- METHOD「POST」、URL「http:\//localhost:8080/legend/33」、BODYに「"name": "ラプソディ"、"realName":"リン・ミ・ヴォ"、"gender":"女性", "sortIndex": 28」を入力して、sendをクリック

  - [ ] エラーが返されること（405 Method Not Allowed）  

### 異常系 id指定なし
- METHOD「PUT」、URL「http:\//localhost:8080/legend」、BODYに「"name":"ラプソディ"、"age":23、"sortIndex":28」を入力して、sendをクリック

  - [ ] エラーが返されること（405 Method Not Allowed）

## レジェン削除機能
### 正常系 レジェンド削除
- METHOD「DELETE」、URL「http:\//localhost:8080/legend/33」を入力して、sendをクリック

  - [ ] エラーが返されないこと(200OK)
  - [ ] 「レジェンドID34は削除されました」と返されること
  - [ ] データベースから削除されていること  

### 異常系 METHOD間違い
- METHOD「POST」、URL「http:\//localhost:8080/legend/33」を入力して、sendをクリック

  - [ ] エラーが返されること（405 Method Not Allowed）  

### 異常系 id指定なし
- METHOD「DELETE」、URL「http:\//localhost:8080/legend」を入力して、sendをクリック

  - [ ] エラーが返されること（405 Method Not Allowed）

