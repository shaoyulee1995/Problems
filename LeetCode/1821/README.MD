# Find Customers With Positive Revenue this Year

```sql
select
    customer_id
from
    Customers
where
    year = '2021' and
    revenue > 0
```
