# Drop Type 1 Orders for Customers With Type 0 Orders

```sql
select
    *
from
    Orders
where
    (customer_id, order_type) in (
    select 
        customer_id, min(order_type)
    from
        Orders
    group by 
        1)
```
        