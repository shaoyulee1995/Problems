# List the Products Ordered in a Period

```sql
select
    p.product_name as 'product_name',
    sum(o.unit) as 'unit'
from
    Products p join Orders o
    on p.product_id = o.product_id and
    Year(o.order_date) = 2020 and
    Month(o.order_date) = 2
group by
    o.product_id
having
    sum(o.unit) >= 100;
```
