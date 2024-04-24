3 задача:
у каждого товара в таблице Товары должен быть свой id (первичный ключ), в таблице детализации у каждой строки должен быть
product_id, ссылающийся на первичный ключ в таблице Товары. 

* формула, по которой вычисляется сумма в таблице Товары: 
```sql
WITH sm AS (
    SELECT id, ROUND(SUM(price), 2) AS price
    FROM products
    GROUP BY id
)
UPDATE details
SET sum = sm.price
WHERE sm.id = details.id;
```

* формула распределения копеек - ???

* значение колонок "Округленное количество*цена, сумма" и "Распределение копеек" для Сетченко и Козлова:
"Округленное количество*цена, сумма": 
```sql

UPDATE details
SET roundQuantityMultiplyPrice = details.quantity * products.price
WHERE details.id = products.id;
```

Если сделать отдельно для Сетченко и Козлова:
```sql
UPDATE details
SET roundQuantityMultiplyPrice = details.quantity * products.price
WHERE details.id = products.id;
and detatils.secondName = 'Сетченко' or details.secondName = 'Козлов'
```

`Общий алгоритм` вычисления детализации: в таблице детализации, по id товара из таблицы товаров, находим все записи, 
предварительно рассчитав для каждого поля в таблице детализации поле "округление..." = "количество"*"цену" из таблицы товаров, 
округленное до сотых и сумму = "округление" + распределение копеек. Ищем общую сумму полей, соответвующих id товара из 
таблицы товаров и присваиваем в нее. 


