# Find Expensive Cities

```sql
select
    city
from
    Listings
group by
    1
having 
    avg(price) > (select avg(price) from Listings)
order by
    1
```