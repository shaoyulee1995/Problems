# Product Sales Analysis III

```sql
with first_product as (
    select
        product_id,
        min(year) as 'year'
    from
        Sales
    group by
        1)

select
    product_id,
    year as 'first_year',
    quantity,
    price
from
    sales
where
    (product_id, year) in (select * from first_product)
```
