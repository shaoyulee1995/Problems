# Warehouse Manager

```sql
select
    w.name as 'warehouse_name',
    sum(p.Width*p.Length*p.Height*w.units) as 'volume'
from
    Warehouse w left join Products p
    using(product_id)
group by
    1
```
