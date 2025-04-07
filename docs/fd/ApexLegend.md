# シーケンス図

```plantuml
@startuml
skin rose

title シーケンス図_レジェンドマスタ登録

actor user
participant LegendController as LC
participant LegendService as LS
participant LegendAPIRepository as LR
database apex_db as DB

autoNumber

== 正常な登録 ==
user -> LC : POST: /legend\n(JSONでレジェンド情報を送信)
activate LC

alt 登録成功
LC -> LS : create(Legend)
activate LS

LS -> LR : save(Legend)
activate LR

note right of LR : JpaRepository経由でDBへアクセス

LR -> DB : レジェンドを登録
DB -->> LR : 保存されたレコード(Legend)

LR -->> LS : 登録データを返す(Legend)
deactivate LR

LS -->> LC : 登録データを返す(Legend)
deactivate LS

LC -->> user : 200 登録データを返す(Legend) 
else 登録失敗
autoNumber stop
LC -->> user : 400 Bad Request\n エラー内容を返す
end
deactivate LC

@enduml
```

