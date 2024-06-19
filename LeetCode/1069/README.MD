# Product Sales Analysis II

```sql
select
    product_id,
    sum(quantity) as 'total_quantity'
from
    Sales s inner join Product p
    using(product_id)
group by 1
```
