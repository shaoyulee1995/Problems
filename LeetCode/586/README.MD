# Customer Placing the Largest Number of Orders

```sql
select customer_number
from orders
group by customer_number
having count(1) = (select max(counts)
                   from (select count(1) as counts
                         from orders
                         group by customer_number) as sub)
```
